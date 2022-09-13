package com.cts.networthservice.dto;

import com.cts.networthservice.entity.PortfolioMutualFundDetails;
import com.cts.networthservice.entity.PortfolioStockDetails;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class NetWorthDTOTest {
    NetWorthDTO netWorthDTO = new NetWorthDTO();

    @Test
    @DisplayName("Testing if NetWorthDTO class is loading or not")
    void testNetWorthDTOLoadingOrNot() {
        assertNotNull(netWorthDTO);
    }

    @Test
    @DisplayName("Testing all getters and setters")
    void testAllGettersAndSetters() {
        netWorthDTO.setPortfolioId("1001");
        Set<PortfolioStockDetails> stockDetails = Set.of(new PortfolioStockDetails("1001", "TCS", 23, null),
                new PortfolioStockDetails("1002", "LIC", 2, null));
        netWorthDTO.setStocks(stockDetails);
        Set<PortfolioMutualFundDetails> mutualFundDetails = Set.of(new PortfolioMutualFundDetails("1001", "ICICI", 10, null),
                new PortfolioMutualFundDetails("1002", "Nippon", 20, null));
        netWorthDTO.setMutualFunds(mutualFundDetails);
        netWorthDTO.setNetWorth(12345.67);

        assertEquals("1001", netWorthDTO.getPortfolioId());
        assertEquals(stockDetails, netWorthDTO.getStocks());
        assertEquals(mutualFundDetails, netWorthDTO.getMutualFunds());
        assertEquals(12345.67, netWorthDTO.getNetWorth());
    }
}