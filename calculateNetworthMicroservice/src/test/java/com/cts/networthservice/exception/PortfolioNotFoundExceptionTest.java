package com.cts.networthservice.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PortfolioNotFoundExceptionTest {
    PortfolioNotFoundException exception = new PortfolioNotFoundException("PortfolioNotFoundException");

    @Test
    @DisplayName("Test whether PortfolioNotFoundException class is loading or not")
    void testExceptionClassLoadingOrNot() {
        assertNotNull(exception);
    }
}