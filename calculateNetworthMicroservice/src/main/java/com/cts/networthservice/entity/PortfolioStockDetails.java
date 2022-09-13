package com.cts.networthservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "portfolio_stock_details")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ApiModel(description = "Model for portfolio stock details")
public class PortfolioStockDetails {
    @Id
    @ApiModelProperty(value = "Unique id representing stock details")
    @JsonIgnore
    private String id;
    @ApiModelProperty(value = "Name of the stock")
    private String stockName;
    @ApiModelProperty(value = "Number of shares of that stock held by the customer")
    private int stockCount;
    @ManyToOne
    @JoinColumn(name = "portfolio_id", nullable = false)
    @JsonIgnore
    private PortfolioDetails portfolioDetails;
}
