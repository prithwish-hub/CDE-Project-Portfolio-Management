package com.cts.sharepriceservice.repository;

import com.cts.sharepriceservice.entity.StockDetails;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class StockDetailsRepoTest {

    @MockBean
    StockDetailsRepo stockDetailsRepo;

    @Test
    @DisplayName("Testing if stock details repository methods are working or not")
    void testFindByName() {
        StockDetails stockDetails = new StockDetails("101", "LIC", 530.45);
        when(stockDetailsRepo.findByName("LIC")).thenReturn(Optional.of(stockDetails));
        assertEquals(Optional.of(stockDetails),stockDetailsRepo.findByName("LIC"));
    }
}