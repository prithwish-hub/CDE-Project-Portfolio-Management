package com.cts.networthservice.repository;

import com.cts.networthservice.entity.PortfolioDetails;
import com.cts.networthservice.entity.PortfolioMutualFundDetails;
import com.cts.networthservice.entity.PortfolioStockDetails;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class PortfolioStockRepoTest {
    @MockBean
    PortfolioStockRepo stockRepo;

    @Test
    void testGetCurrentStockStatus() {
        Set<PortfolioStockDetails> stockDetails = Set.of(new PortfolioStockDetails("1001", "TCS", 23, null),
                new PortfolioStockDetails("1002", "LIC", 2, null));
        Set<PortfolioMutualFundDetails> mutualFundDetails = Set.of(new PortfolioMutualFundDetails("1001", "ICICI", 10, null),
                new PortfolioMutualFundDetails("1002", "Nippon", 20, null));
        PortfolioDetails portfolioDetails = new PortfolioDetails("1001", "U101", stockDetails, mutualFundDetails);
        PortfolioStockDetails fundDetails = new PortfolioStockDetails("ST1001", "LIC", 20, portfolioDetails);

        when(stockRepo.getCurrentStockStatus("1001", "LIC")).thenReturn(fundDetails);
        assertEquals(fundDetails, stockRepo.getCurrentStockStatus("1001", "LIC"));
    }
}