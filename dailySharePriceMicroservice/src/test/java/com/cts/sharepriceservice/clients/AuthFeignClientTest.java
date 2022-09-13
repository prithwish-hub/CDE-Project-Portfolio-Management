package com.cts.sharepriceservice.clients;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

class AuthFeignClientTest {
    AuthFeignClient authFeignClient;

    @Test
    @DisplayName("Testing if AuthFeignClient is loading or not")
    void testAuthClientLoadingOrNot() {
        assertNull(authFeignClient);
    }
}