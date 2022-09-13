package com.cts.networthservice.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class GlobalExceptionHandlerTest {
    @Autowired
    GlobalExceptionHandler globalExceptionHandler;

    @Test
    @DisplayName("Test whether GlobalExceptionHandler class is loading or not")
    void testGlobalExceptionHandlerLoadingOrNot() {
        assertNotNull(globalExceptionHandler);
    }
}