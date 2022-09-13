package com.cts.networthservice.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class StockDetails {
    private String id;
    private String name;
    private Double value;
}
