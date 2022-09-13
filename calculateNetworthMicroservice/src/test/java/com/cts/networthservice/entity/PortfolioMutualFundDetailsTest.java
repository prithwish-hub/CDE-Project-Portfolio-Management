package com.cts.networthservice.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PortfolioMutualFundDetailsTest {
    PortfolioMutualFundDetails portfolioMutualFundDetails = new PortfolioMutualFundDetails();

    @Test
    @DisplayName("Testing if PortfolioMutualFundDetails class is loading or not")
    void testPortfolioMutualFundDetailsLoadingOrNot() {
        assertNotNull(portfolioMutualFundDetails);
    }

    @Test
    @DisplayName("Testing all getters and setters")
    void testAllGettersAndSetters() {
        portfolioMutualFundDetails.setId("101");
        portfolioMutualFundDetails.setMutualFundName("ICICI");
        portfolioMutualFundDetails.setMutualFundUnits(2);

        assertEquals("101", portfolioMutualFundDetails.getId());
        assertEquals("ICICI", portfolioMutualFundDetails.getMutualFundName());
        assertEquals(2, portfolioMutualFundDetails.getMutualFundUnits());
    }
}