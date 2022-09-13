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
@Table(name = "portfolio_mutual_fund_details")
//@Check(constraints = "mutualFundUnits>=0")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ApiModel(description = "Model for portfolio mutual fund details")
public class PortfolioMutualFundDetails {
    @Id
    @ApiModelProperty(value = "Unique id representing mutual fund details")
    @JsonIgnore
    private String id;
    @ApiModelProperty(value = "Name of the mutual fund")
    private String mutualFundName;
    @ApiModelProperty(value = "Number of mutual fund units held by the customer")
    private int mutualFundUnits;
    @ManyToOne
    @JoinColumn(name = "portfolio_id", nullable = false)
    @JsonIgnore
    private PortfolioDetails portfolioDetails;
}
