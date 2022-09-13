package com.cts.networthservice.dto;

import com.cts.networthservice.entity.PortfolioMutualFundDetails;
import com.cts.networthservice.entity.PortfolioStockDetails;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class NetWorthDTO {
    private String portfolioId;
    private Set<PortfolioStockDetails> stocks;
    private Set<PortfolioMutualFundDetails> mutualFunds;
    private Double netWorth;
}
