package com.cts.networthservice.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AssetSaleResponse {
    private Boolean saleStatus;
    private Double netWorth;
}
