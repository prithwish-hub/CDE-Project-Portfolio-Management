package com.cts.networthservice.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidationResponseTest {
    ValidationResponse response = new ValidationResponse();

    @Test
    @DisplayName("Test whether ValidationResponse class is loading or not")
    void testValidationResponseLoadingOrNot() {
        assertNotNull(response);
    }

    @Test
    @DisplayName("Testing isValid and setValid methods")
    void testIsAndSetValid() {
        response.setValid(false);
        assertFalse(response.isValid());
    }

    @Test
    @DisplayName("Testing toString method")
    void testToString() {
        response.setValid(true);
        assertEquals("ValidationResponse(valid=true)", response.toString());
    }
}