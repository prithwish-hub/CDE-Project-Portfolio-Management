package com.cts.networthservice.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class MutualFundDetailsTest {
    MutualFundDetails mutualFundDetails = new MutualFundDetails();

    @Test
    @DisplayName("Testing if MutualFundDetails class is loading or not")
    void testMutualFundDetailsLoadingOrNot() {
        assertNotNull(mutualFundDetails);
    }

    @Test
    @DisplayName("Testing all getters and setters")
    void testAllGettersAndSetters() {
        mutualFundDetails.setId("101");
        mutualFundDetails.setName("ICICI");
        mutualFundDetails.setValue(2304.56);

        assertEquals("101", mutualFundDetails.getId());
        assertEquals("ICICI", mutualFundDetails.getName());
        assertEquals(2304.56, mutualFundDetails.getValue());
    }

}