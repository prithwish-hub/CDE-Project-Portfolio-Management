package com.cts.authservice.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ApiModel(description = "Model class for user logged in to the application")
public class AppUser {
    @Id
    @ApiModelProperty(value = "Unique id representing each user")
    private String id;
    @ApiModelProperty(value = "Username of the user")
    private String username;
    @ApiModelProperty(value = "Password of the user")
    private String password;
}
