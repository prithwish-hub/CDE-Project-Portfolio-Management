package com.cts.networthservice.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PortfolioStockDetailsTest {
    PortfolioStockDetails portfolioStockDetails = new PortfolioStockDetails();

    @Test
    @DisplayName("Testing if PortfolioStockDetails class is loading or not")
    void testPortfolioStockDetailsLoadingOrNot() {
        assertNotNull(portfolioStockDetails);
    }

    @Test
    @DisplayName("Testing all getters and setters")
    void testAllGettersAndSetters() {
        portfolioStockDetails.setId("101");
        portfolioStockDetails.setStockName("LIC");
        portfolioStockDetails.setStockCount(2);

        assertEquals("101", portfolioStockDetails.getId());
        assertEquals("LIC", portfolioStockDetails.getStockName());
        assertEquals(2, portfolioStockDetails.getStockCount());
    }
}