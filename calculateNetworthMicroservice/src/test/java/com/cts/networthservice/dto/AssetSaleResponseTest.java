package com.cts.networthservice.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AssetSaleResponseTest {
    AssetSaleResponse assetSaleResponse = new AssetSaleResponse();

    @Test
    @DisplayName("Testing if AssetSaleResponse class is loading or not")
    void testAssetSaleResponseLoadingOrNot() {
        assertNotNull(assetSaleResponse);
    }

    @Test
    @DisplayName("Testing all getters and setters")
    void testAllGettersAndSetters() {
        assetSaleResponse.setSaleStatus(true);
        assetSaleResponse.setNetWorth(12345.67);

        assertTrue(assetSaleResponse.getSaleStatus());
        assertEquals(12345.67,assetSaleResponse.getNetWorth());
    }
}