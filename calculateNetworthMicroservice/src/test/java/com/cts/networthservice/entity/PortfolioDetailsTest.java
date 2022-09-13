package com.cts.networthservice.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PortfolioDetailsTest {
    PortfolioDetails portfolioDetails = new PortfolioDetails();

    @Test
    @DisplayName("Testing if PortfolioDetails class is loading or not")
    void testPortfolioDetailsLoadingOrNot() {
        assertNotNull(portfolioDetails);
    }

    @Test
    @DisplayName("Testing all getters and setters")
    void testAllGettersAndSetters() {
        portfolioDetails.setId("P101");
        portfolioDetails.setUserId("101");
        Set<PortfolioStockDetails> stockDetails = Set.of(new PortfolioStockDetails("1001", "TCS", 23, null),
                new PortfolioStockDetails("1002", "LIC", 2, null));
        portfolioDetails.setStockDetailsList(stockDetails);
        Set<PortfolioMutualFundDetails> mutualFundDetails = Set.of(new PortfolioMutualFundDetails("1001", "ICICI", 10, null),
                new PortfolioMutualFundDetails("1002", "Nippon", 20, null));
        portfolioDetails.setMutualFundDetailsList(mutualFundDetails);

        assertEquals("P101", portfolioDetails.getId());
        assertEquals("101", portfolioDetails.getUserId());
        assertEquals(stockDetails, portfolioDetails.getStockDetailsList());
        assertEquals(mutualFundDetails, portfolioDetails.getMutualFundDetailsList());
    }
}