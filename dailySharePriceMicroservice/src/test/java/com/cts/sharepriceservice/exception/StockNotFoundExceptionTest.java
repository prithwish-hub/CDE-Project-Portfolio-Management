package com.cts.sharepriceservice.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StockNotFoundExceptionTest {
    StockNotFoundException exception=new StockNotFoundException("StockNotFoundException");

    @Test
    @DisplayName("Test whether StockNotFoundException class is loading or not")
    void testExceptionClassLoadingOrNot(){
        assertNotNull(exception);
    }
}