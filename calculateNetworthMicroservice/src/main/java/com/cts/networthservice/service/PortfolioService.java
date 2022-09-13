package com.cts.networthservice.service;

import com.cts.networthservice.clients.AuthFeignClient;
import com.cts.networthservice.clients.MutualFundFeignClient;
import com.cts.networthservice.clients.StockFeignClient;
import com.cts.networthservice.dto.AssetSaleRequest;
import com.cts.networthservice.dto.AssetSaleResponse;
import com.cts.networthservice.dto.NetWorthDTO;
import com.cts.networthservice.entity.PortfolioDetails;
import com.cts.networthservice.entity.PortfolioMutualFundDetails;
import com.cts.networthservice.entity.PortfolioStockDetails;
import com.cts.networthservice.exception.InvalidJwtTokenException;
import com.cts.networthservice.exception.PortfolioNotFoundException;
import com.cts.networthservice.repository.PortfolioDetailsRepo;
import com.cts.networthservice.repository.PortfolioMutualFundRepo;
import com.cts.networthservice.repository.PortfolioStockRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;

@Service
@Slf4j
public class PortfolioService {

    @Autowired
    private PortfolioDetailsRepo portfolioDetailsRepo;
    @Autowired
    private PortfolioStockRepo stockRepo;
    @Autowired
    private PortfolioMutualFundRepo mutualFundRepo;
    @Autowired
    private AuthFeignClient authFeignClient;
    @Autowired
    private StockFeignClient stockFeignClient;
    @Autowired
    private MutualFundFeignClient mutualFundFeignClient;

    @Transactional
    public ResponseEntity<NetWorthDTO> calculateNetWorth(String jwtToken, String userId) throws PortfolioNotFoundException, InvalidJwtTokenException {
        if (authFeignClient.validate(jwtToken).getBody().isValid()) {
            PortfolioDetails portfolioDetails = portfolioDetailsRepo.findByUserId(userId)
                    .orElseThrow(() -> new PortfolioNotFoundException("No portfolio found for user id : " + userId));
            log.info("Portfolio details found");
            double netWorth = getNetWorthValue(jwtToken, portfolioDetails.getStockDetailsList(), portfolioDetails.getMutualFundDetailsList());
            NetWorthDTO netWorthDTO = new NetWorthDTO();
            netWorthDTO.setPortfolioId(portfolioDetails.getId());
            netWorthDTO.setStocks(portfolioDetails.getStockDetailsList());
            netWorthDTO.setMutualFunds(portfolioDetails.getMutualFundDetailsList());
            netWorthDTO.setNetWorth(netWorth);
            return ResponseEntity.ok(netWorthDTO);
        }
        log.error("Jwt token is not valid");
        throw new InvalidJwtTokenException("Jwt token is not valid");
    }

    @Transactional
    public ResponseEntity<AssetSaleResponse> sellAssets(String jwtToken, AssetSaleRequest assetSaleRequest) throws PortfolioNotFoundException, InvalidJwtTokenException {
        if (authFeignClient.validate(jwtToken).getBody().isValid()) {
            PortfolioDetails portfolioDetails = portfolioDetailsRepo.findByUserId(assetSaleRequest.getUserId())
                    .orElseThrow(() -> new PortfolioNotFoundException("No portfolio found for user id : " + assetSaleRequest.getUserId()));
            log.info("Portfolio details found");

            if (assetSaleRequest.getStocks() != null && !assetSaleRequest.getStocks().isEmpty()) {
                for (PortfolioStockDetails p : assetSaleRequest.getStocks()) {
                    PortfolioStockDetails stockDetails = stockRepo.getCurrentStockStatus(portfolioDetails.getId(), p.getStockName());
                    p.setStockCount(stockDetails.getStockCount() - p.getStockCount());
                    if (p.getStockCount() == 0)
                        stockRepo.deleteStockRecord(portfolioDetails.getId(), p.getStockName());
                    else
                        stockRepo.updateStockStatus(portfolioDetails.getId(), p.getStockName(), p.getStockCount());
                }
            }

            if (assetSaleRequest.getMutualFunds() != null && !assetSaleRequest.getMutualFunds().isEmpty()) {
                for (PortfolioMutualFundDetails p : assetSaleRequest.getMutualFunds()) {
                    PortfolioMutualFundDetails fundDetails = mutualFundRepo.getCurrentMutualFundStatus(portfolioDetails.getId(), p.getMutualFundName());
                    p.setMutualFundUnits(fundDetails.getMutualFundUnits() - p.getMutualFundUnits());
                    if (p.getMutualFundUnits() == 0)
                        mutualFundRepo.deleteCurrentMutualFund(portfolioDetails.getId(), p.getMutualFundName());
                    else
                        mutualFundRepo.updateMutualFundStatus(portfolioDetails.getId(), p.getMutualFundName(), p.getMutualFundUnits());
                }
            }

            double netWorth = getNetWorthValue(jwtToken, assetSaleRequest.getStocks(), assetSaleRequest.getMutualFunds());
            return ResponseEntity.ok(new AssetSaleResponse(true, netWorth));
        }
        log.error("Jwt token is not valid");
        throw new InvalidJwtTokenException("Jwt token is not valid");
    }

    public double getNetWorthValue(String jwtToken, Set<PortfolioStockDetails> stocks, Set<PortfolioMutualFundDetails> mutualFunds) {
        double netWorth = 0;

        if (stocks != null && !stocks.isEmpty()) {
            for (PortfolioStockDetails x : stocks) {
                String stockName = x.getStockName();
                int count = x.getStockCount();
                netWorth += stockFeignClient.getStockDetailsByName(jwtToken, stockName).getBody().getValue() * count;
            }
        }

        if (mutualFunds != null && !mutualFunds.isEmpty()) {
            for (PortfolioMutualFundDetails x : mutualFunds) {
                String mutualFundName = x.getMutualFundName();
                int count = x.getMutualFundUnits();
                netWorth += mutualFundFeignClient.getMutualFundDetailsByName(jwtToken, mutualFundName).getBody().getValue() * count;
            }
        }

        if (netWorth > 0)
            netWorth = Math.round(netWorth * 100.0) / 100.0;
        log.info("Calculated net worth : {}",netWorth);
        return netWorth;
    }
}
