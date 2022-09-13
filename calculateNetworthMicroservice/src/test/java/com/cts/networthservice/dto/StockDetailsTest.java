package com.cts.networthservice.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class StockDetailsTest {
    StockDetails stockDetails = new StockDetails();

    @Test
    @DisplayName("Testing if StockDetails class is loading or not")
    void testStockDetailsLoadingOrNot() {
        assertNotNull(stockDetails);
    }

    @Test
    @DisplayName("Testing all getters and setters")
    void testAllGettersAndSetters() {
        stockDetails.setId("101");
        stockDetails.setName("LIC");
        stockDetails.setValue(2304.56);

        assertEquals("101", stockDetails.getId());
        assertEquals("LIC", stockDetails.getName());
        assertEquals(2304.56, stockDetails.getValue());
    }
}