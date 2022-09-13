package com.cts.networthservice.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "portfolio_details")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ApiModel(description = "Model for portfolio details")
public class PortfolioDetails {
    @Id
    @ApiModelProperty(value = "Unique id representing the portfolio")
    private String id;
    @ApiModelProperty(value = "Id of the corresponding user")
    private String userId;
    @OneToMany(mappedBy = "portfolioDetails", fetch = FetchType.EAGER)
    private Set<PortfolioStockDetails> stockDetailsList;
    @OneToMany(mappedBy = "portfolioDetails", fetch = FetchType.EAGER)
    private Set<PortfolioMutualFundDetails> mutualFundDetailsList;
}
