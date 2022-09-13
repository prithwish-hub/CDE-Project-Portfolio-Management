package com.cts.sharepriceservice.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ErrorResponseTest {
    ErrorResponse response = new ErrorResponse();

    @Test
    @DisplayName("Test whether ErrorResponse class is loading or not")
    void testErrorResponseLoadingOrNot() {
        assertNotNull(response);
    }

    @Test
    @DisplayName("Testing getMessage and setMessage methods")
    void testGetAndSetMessage() {
        response.setMessage("Stock not found");
        assertEquals("Stock not found", response.getMessage());
    }

    @Test
    @DisplayName("Testing getTimestamp and setTimestamp methods")
    void testGetAndSetTimestamp() {
        response.setTimestamp(LocalDateTime.of(2012, 5, 4, 10, 20));
        assertEquals(LocalDateTime.of(2012, 5, 4, 10, 20), response.getTimestamp());
    }

    @Test
    @DisplayName("Testing toString method")
    void testToString() {
        response.setMessage("Stock not found");
        response.setTimestamp(LocalDateTime.of(2012, 5, 4, 10, 20));
        assertEquals("ErrorResponse(message=Stock not found, timestamp=2012-05-04T10:20)", response.toString());
    }
}