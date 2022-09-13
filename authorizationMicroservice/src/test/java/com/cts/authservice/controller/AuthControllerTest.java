package com.cts.authservice.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class AuthControllerTest {
    @Autowired
    AuthController authController;

    @Test
    @DisplayName("Testing if AuthController class is loading or not")
    void testAuthControllerLoadingOrNot() {
        assertNotNull(authController);
    }
}