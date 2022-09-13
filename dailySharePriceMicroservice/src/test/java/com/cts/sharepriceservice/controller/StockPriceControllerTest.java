package com.cts.sharepriceservice.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class StockPriceControllerTest {
    @Autowired
    StockPriceController stockPriceController;

    @Test
    @DisplayName("Testing if StockPriceController class is loading or not")
    void testStockPriceControllerLoadingOrNot() {
        assertNotNull(stockPriceController);
    }
}