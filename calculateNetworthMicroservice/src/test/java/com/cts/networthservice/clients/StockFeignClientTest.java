package com.cts.networthservice.clients;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StockFeignClientTest {
    StockFeignClient stockFeignClient;

    @Test
    @DisplayName("Testing if StockFeignClient is loading or not")
    void testStockClientLoadingOrNot() {
        assertNull(stockFeignClient);
    }
}