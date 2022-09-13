package com.cts.mutualfundservice.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class InvalidJwtTokenExceptionTest {
    InvalidJwtTokenException exception = new InvalidJwtTokenException("InvalidJwtTokenException");

    @Test
    @DisplayName("Test whether InvalidJwtTokenException class is loading or not")
    void testExceptionClassLoadingOrNot() {
        assertNotNull(exception);
    }
}