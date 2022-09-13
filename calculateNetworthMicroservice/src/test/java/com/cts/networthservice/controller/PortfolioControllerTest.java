package com.cts.networthservice.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class PortfolioControllerTest {
    @Autowired
    PortfolioController portfolioController;

    @Test
    @DisplayName("Testing if PortfolioController class is loading or not")
    void testPortfolioControllerLoadingOrNot() {
        assertNotNull(portfolioController);
    }
}