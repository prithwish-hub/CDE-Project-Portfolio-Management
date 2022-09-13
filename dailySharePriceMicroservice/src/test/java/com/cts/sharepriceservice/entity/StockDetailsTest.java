package com.cts.sharepriceservice.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StockDetailsTest {

    StockDetails details=new StockDetails();

    @Test
    @DisplayName("Test whether StockDetails class is loading or not")
    void testStockDetailsLoadingOrNot(){
        assertNotNull(details);
    }

    @Test
    @DisplayName("Testing getId and setId methods")
    void testGetAndSetId() {
        details.setId("a54b43b4-bbf9-4dc0-a56e-752df82b7817");
        assertEquals("a54b43b4-bbf9-4dc0-a56e-752df82b7817",details.getId());
    }

    @Test
    @DisplayName("Testing getName and setName methods")
    void testGetAndSetName() {
        details.setName("LIC");
        assertEquals("LIC",details.getName());
    }

    @Test
    @DisplayName("Testing getValue and setValue methods")
    void testGetAndSetValue() {
        details.setValue(123.45);
        assertEquals(123.45,details.getValue());
    }

    @Test
    @DisplayName("Testing toString method")
    void testToString() {
        details=new StockDetails("101","Airtel",534.67);
        assertEquals("StockDetails(id=101, name=Airtel, value=534.67)",details.toString());
    }
}