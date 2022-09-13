package com.cts.networthservice.service;

import com.cts.networthservice.clients.AuthFeignClient;
import com.cts.networthservice.clients.MutualFundFeignClient;
import com.cts.networthservice.clients.StockFeignClient;
import com.cts.networthservice.dto.MutualFundDetails;
import com.cts.networthservice.dto.NetWorthDTO;
import com.cts.networthservice.dto.StockDetails;
import com.cts.networthservice.dto.ValidationResponse;
import com.cts.networthservice.entity.PortfolioDetails;
import com.cts.networthservice.entity.PortfolioMutualFundDetails;
import com.cts.networthservice.entity.PortfolioStockDetails;
import com.cts.networthservice.exception.InvalidJwtTokenException;
import com.cts.networthservice.exception.PortfolioNotFoundException;
import com.cts.networthservice.repository.PortfolioDetailsRepo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
class PortfolioServiceTest {

    @Autowired
    PortfolioService portfolioService;
    @MockBean
    AuthFeignClient authFeignClient;
    @MockBean
    MutualFundFeignClient mutualFundFeignClient;
    @MockBean
    StockFeignClient stockFeignClient;
    @MockBean
    PortfolioDetailsRepo portfolioDetailsRepo;

    @Test
    @DisplayName("Testing calculate net worth with valid jwt and userid")
    void testCalculateNetWorth() {
        Set<PortfolioStockDetails> stockDetails = Set.of(new PortfolioStockDetails("1001", "TCS", 23, null),
                new PortfolioStockDetails("1002", "LIC", 2, null));
        Set<PortfolioMutualFundDetails> mutualFundDetails = Set.of(new PortfolioMutualFundDetails("1001", "ICICI", 10, null),
                new PortfolioMutualFundDetails("1002", "Nippon", 20, null));
        PortfolioDetails portfolioDetails = new PortfolioDetails("P101", "U101", stockDetails, mutualFundDetails);

        when(authFeignClient.validate("ABC")).thenReturn(ResponseEntity.ok(new ValidationResponse(true)));
        when(portfolioDetailsRepo.findByUserId("U101")).thenReturn(Optional.of(portfolioDetails));
        when(stockFeignClient.getStockDetailsByName("ABC", "TCS")).thenReturn(ResponseEntity.ok(new StockDetails("S1", "TCS", 50.0)));
        when(stockFeignClient.getStockDetailsByName("ABC", "LIC")).thenReturn(ResponseEntity.ok(new StockDetails("S2", "LIC", 100.0)));
        when(mutualFundFeignClient.getMutualFundDetailsByName("ABC", "ICICI")).thenReturn(ResponseEntity.ok(new MutualFundDetails("M1", "ICICI", 40.0)));
        when(mutualFundFeignClient.getMutualFundDetailsByName("ABC", "Nippon")).thenReturn(ResponseEntity.ok(new MutualFundDetails("M2", "Nippon", 30.0)));

        NetWorthDTO netWorthDTO = new NetWorthDTO("P101", stockDetails, mutualFundDetails, 2350.0);
        assertEquals(netWorthDTO.getNetWorth(), portfolioService.calculateNetWorth("ABC", "U101").getBody().getNetWorth());
    }

    @Test
    @DisplayName("Testing calculate net worth with invalid jwt")
    void testCalculateNetWorthWithInvalidJwt() {
        when(authFeignClient.validate("ABC")).thenReturn(ResponseEntity.ok(new ValidationResponse(false)));
        assertThrows(InvalidJwtTokenException.class, () -> portfolioService.calculateNetWorth("ABC", "U101"));
    }

    @Test
    @DisplayName("Testing calculate net worth with invalid userid")
    void testCalculateNetWorthWithInvalidUserId() {
        when(authFeignClient.validate("ABC")).thenReturn(ResponseEntity.ok(new ValidationResponse(true)));
        assertThrows(PortfolioNotFoundException.class, () -> portfolioService.calculateNetWorth("ABC", "U101"));
    }

}