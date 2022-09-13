package com.cts.sharepriceservice.service;

import com.cts.sharepriceservice.clients.AuthFeignClient;
import com.cts.sharepriceservice.entity.StockDetails;
import com.cts.sharepriceservice.exception.InvalidJwtTokenException;
import com.cts.sharepriceservice.exception.StockNotFoundException;
import com.cts.sharepriceservice.repository.StockDetailsRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StockPriceService {

    @Autowired
    private StockDetailsRepo stockDetailsRepo;
    @Autowired
    private AuthFeignClient authFeignClient;

    public ResponseEntity<StockDetails> getStockDetailsByName(String jwtToken, String stockName) throws StockNotFoundException, InvalidJwtTokenException {
        if (authFeignClient.validate(jwtToken).getBody().isValid()) {
            StockDetails stockDetails = stockDetailsRepo.findByName(stockName)
                    .orElseThrow(() -> new StockNotFoundException("No stock found with name : " + stockName));
            log.info("Stock details found");
            log.debug("Stock details : {}",stockDetails);
            return ResponseEntity.ok(stockDetails);
        }
        log.error("Jwt token is not valid");
        throw new InvalidJwtTokenException("Jwt token is not valid");
    }
}
