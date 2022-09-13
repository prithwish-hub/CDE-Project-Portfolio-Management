package com.cts.sharepriceservice.service;

import com.cts.sharepriceservice.clients.AuthFeignClient;
import com.cts.sharepriceservice.dto.ValidationResponse;
import com.cts.sharepriceservice.entity.StockDetails;
import com.cts.sharepriceservice.exception.InvalidJwtTokenException;
import com.cts.sharepriceservice.exception.StockNotFoundException;
import com.cts.sharepriceservice.repository.StockDetailsRepo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class StockPriceServiceTest {
    @Autowired
    StockPriceService stockPriceService;
    @MockBean
    StockDetailsRepo stockDetailsRepo;
    @MockBean
    AuthFeignClient authFeignClient;

    @Test
    @DisplayName("Testing if StockPriceService class is loading or not")
    void testStockPriceServiceLoadingOrNot() {
        assertNotNull(stockPriceService);
    }

    @Test
    @DisplayName("Testing getStockDetailsByName with valid valid stock name")
    void testGetStockDetailsByNameWithValidStockName() {
        StockDetails stockDetails = new StockDetails("101", "LIC", 530.45);
        ValidationResponse response = new ValidationResponse(true);
        when(stockDetailsRepo.findByName("LIC")).thenReturn(Optional.of(stockDetails));
        when(authFeignClient.validate("ABC")).thenReturn(ResponseEntity.ok(response));

        StockDetails actualDetails = stockPriceService.getStockDetailsByName("ABC", "LIC").getBody();
        assertEquals(stockDetails, actualDetails);
    }

    @Test
    @DisplayName("Testing getStockDetailsByName with valid invalid stock name")
    void testGetStockDetailsByNameWithInvalidStockName() {
        ValidationResponse response = new ValidationResponse(true);
        when(authFeignClient.validate("ABC")).thenReturn(ResponseEntity.ok(response));
        assertThrows(StockNotFoundException.class, () -> stockPriceService.getStockDetailsByName("ABC", "LIC"));
    }

    @Test
    @DisplayName("Testing getStockDetailsByName with invalid Jwt Token")
    void testGetStockDetailsByNameWithInvalidJwtToken() {
        ValidationResponse response = new ValidationResponse(false);
        when(authFeignClient.validate("ABC")).thenReturn(ResponseEntity.ok(response));
        assertThrows(InvalidJwtTokenException.class, () -> stockPriceService.getStockDetailsByName("ABC", "LIC"));
    }
}