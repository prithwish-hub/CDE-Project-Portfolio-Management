package com.cts.mutualfundservice.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mutual_fund_details")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@ApiModel(description = "Mutual Fund Details Model")
public class MutualFundDetails {
    @Id
    @ApiModelProperty(value = "Unique id representing the mutual fund")
    private String id;
    @ApiModelProperty(value = "Name of the mutual fund")
    private String name;
    @ApiModelProperty(value = "NAV of the mutual fund")
    private Double value;
}
