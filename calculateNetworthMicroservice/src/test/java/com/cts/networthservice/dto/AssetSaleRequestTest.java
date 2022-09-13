package com.cts.networthservice.dto;

import com.cts.networthservice.entity.PortfolioMutualFundDetails;
import com.cts.networthservice.entity.PortfolioStockDetails;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class AssetSaleRequestTest {
    AssetSaleRequest assetSaleRequest = new AssetSaleRequest();

    @Test
    @DisplayName("Testing if AssetSaleRequest class is loading or not")
    void testAssetSaleRequestLoadingOrNot() {
        assertNotNull(assetSaleRequest);
    }

    @Test
    @DisplayName("Testing all getters and setters")
    void testAllGettersAndSetters() {
        assetSaleRequest.setUserId("101");
        Set<PortfolioStockDetails> stockDetails = Set.of(new PortfolioStockDetails("1001", "TCS", 23, null),
                new PortfolioStockDetails("1002", "LIC", 2, null));
        assetSaleRequest.setStocks(stockDetails);
        Set<PortfolioMutualFundDetails> mutualFundDetails = Set.of(new PortfolioMutualFundDetails("1001", "ICICI", 10, null),
                new PortfolioMutualFundDetails("1002", "Nippon", 20, null));
        assetSaleRequest.setMutualFunds(mutualFundDetails);

        assertEquals("101",assetSaleRequest.getUserId());
        assertEquals(stockDetails,assetSaleRequest.getStocks());
        assertEquals(mutualFundDetails,assetSaleRequest.getMutualFunds());
    }
}