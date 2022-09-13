package com.cts.authservice.config;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SwaggerConfigTest {
    SwaggerConfig config = new SwaggerConfig();

    @Test
    @DisplayName("Testing if SwaggerConfig class is loading or not")
    void testSwaggerConfigLoadingOrNot() {
        assertNotNull(config);
    }
}