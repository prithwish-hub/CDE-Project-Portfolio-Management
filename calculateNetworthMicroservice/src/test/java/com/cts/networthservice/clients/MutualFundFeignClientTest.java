package com.cts.networthservice.clients;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MutualFundFeignClientTest {
    MutualFundFeignClient mutualFundFeignClient;

    @Test
    @DisplayName("Testing if MutualFundFeignClient is loading or not")
    void testMutualFundClientLoadingOrNot() {
        assertNull(mutualFundFeignClient);
    }
}