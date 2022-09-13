package com.cts.mutualfundservice.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class MutualFundDetailsTest {
    MutualFundDetails mutualFundDetails = new MutualFundDetails();

    @Test
    @DisplayName("Test whether MutualFundDetails class is loading or not")
    void testMutualFundDetailsLoadingOrNot(){
        assertNotNull(mutualFundDetails);
    }

    @Test
    @DisplayName("Testing getId and setId methods")
    void testGetAndSetId() {
        mutualFundDetails.setId("a54b43b4-bbf9-4dc0-a56e-752df82b7817");
        assertEquals("a54b43b4-bbf9-4dc0-a56e-752df82b7817",mutualFundDetails.getId());
    }

    @Test
    @DisplayName("Testing getName and setName methods")
    void testGetAndSetName() {
        mutualFundDetails.setName("ICICI");
        assertEquals("ICICI",mutualFundDetails.getName());
    }

    @Test
    @DisplayName("Testing getValue and setValue methods")
    void testGetAndSetValue() {
        mutualFundDetails.setValue(123.45);
        assertEquals(123.45,mutualFundDetails.getValue());
    }

    @Test
    @DisplayName("Testing toString method")
    void testToString() {
        mutualFundDetails=new MutualFundDetails("101","ICICI",534.67);
        assertEquals("MutualFundDetails(id=101, name=ICICI, value=534.67)",mutualFundDetails.toString());
    }
}