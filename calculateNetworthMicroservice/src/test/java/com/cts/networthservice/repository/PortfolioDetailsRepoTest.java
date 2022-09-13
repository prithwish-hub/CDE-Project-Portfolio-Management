package com.cts.networthservice.repository;

import com.cts.networthservice.entity.PortfolioDetails;
import com.cts.networthservice.entity.PortfolioMutualFundDetails;
import com.cts.networthservice.entity.PortfolioStockDetails;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class PortfolioDetailsRepoTest {
    @MockBean
    PortfolioDetailsRepo portfolioDetailsRepo;

    @Test
    @DisplayName("Testing if testFindByUserId is working or not")
    void testFindByUserId() {
        Set<PortfolioStockDetails> stockDetails = Set.of(new PortfolioStockDetails("1001", "TCS", 23, null),
                new PortfolioStockDetails("1002", "LIC", 2, null));
        Set<PortfolioMutualFundDetails> mutualFundDetails = Set.of(new PortfolioMutualFundDetails("1001", "ICICI", 10, null),
                new PortfolioMutualFundDetails("1002", "Nippon", 20, null));
        PortfolioDetails portfolioDetails = new PortfolioDetails("101", "U1001", stockDetails, mutualFundDetails);
        when(portfolioDetailsRepo.findByUserId("U1001")).thenReturn(Optional.of(portfolioDetails));
        assertEquals(Optional.of(portfolioDetails), portfolioDetailsRepo.findByUserId("U1001"));
    }
}