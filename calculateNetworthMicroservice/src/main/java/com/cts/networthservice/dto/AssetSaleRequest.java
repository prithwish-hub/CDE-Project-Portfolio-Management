package com.cts.networthservice.dto;

import com.cts.networthservice.entity.PortfolioMutualFundDetails;
import com.cts.networthservice.entity.PortfolioStockDetails;
import lombok.*;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AssetSaleRequest {
    private String userId;
    private Set<PortfolioStockDetails> stocks;
    private Set<PortfolioMutualFundDetails> mutualFunds;
}
