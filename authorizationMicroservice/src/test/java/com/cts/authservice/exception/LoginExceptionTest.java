package com.cts.authservice.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class LoginExceptionTest {
    LoginException exception = new LoginException("LoginException");

    @Test
    @DisplayName("Test whether LoginException class is loading or not")
    void testExceptionClassLoadingOrNot() {
        assertNotNull(exception);
    }
}