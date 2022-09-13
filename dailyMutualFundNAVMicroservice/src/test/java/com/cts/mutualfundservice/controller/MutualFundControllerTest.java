package com.cts.mutualfundservice.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class MutualFundControllerTest {
    @Autowired
    MutualFundController mutualFundController;

    @Test
    @DisplayName("Testing if MutualFundController class is loading or not")
    void testMutualFundControllerLoadingOrNot() {
        assertNotNull(mutualFundController);
    }
}