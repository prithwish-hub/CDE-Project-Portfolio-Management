package com.cts.sharepriceservice.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stock_details")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@ApiModel(description = "Stock Details Model")
public class StockDetails {
    @Id
    @ApiModelProperty(value = "Unique id representing the stock")
    private String id;
    @ApiModelProperty(value = "Name of the stock")
    private String name;
    @ApiModelProperty(value = "Current market price of the stock in NRI")
    private Double value;
}
