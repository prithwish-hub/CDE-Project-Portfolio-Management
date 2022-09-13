package com.cts.networthservice.controller;

import com.cts.networthservice.dto.AssetSaleRequest;
import com.cts.networthservice.dto.AssetSaleResponse;
import com.cts.networthservice.dto.NetWorthDTO;
import com.cts.networthservice.exception.InvalidJwtTokenException;
import com.cts.networthservice.exception.PortfolioNotFoundException;
import com.cts.networthservice.service.PortfolioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@Api(value = "Endpoints for net worth calculation and sell assets")
@CrossOrigin
public class PortfolioController {

    @Autowired
    private PortfolioService portfolioService;


    /**
     * http://localhost:8084/net-worth-service/calculateNetworth/{id}
     * Calculate net worth response entity.
     *
     * @param jwtToken the jwt token
     * @param id       the id
     * @return the response entity
     * @throws PortfolioNotFoundException the portfolio not found exception
     * @throws InvalidJwtTokenException   the invalid jwt token exception
     */
    @ApiOperation(value = "CalculateNetWorth",
            notes = "Post authorization of the request it calculates value of all assets",
            httpMethod = "GET", response = ResponseEntity.class)
    @GetMapping("/calculateNetworth/{id}")
    public ResponseEntity<NetWorthDTO> calculateNetWorth(
            @RequestHeader("Authorization") @ApiParam(name = "jwtToken", value = "Jwt Token of the user to check its validity") String jwtToken,
            @PathVariable @ApiParam(name = "UserId", value = "Id of the user to calculate new worth") String id
    ) throws PortfolioNotFoundException, InvalidJwtTokenException {
        log.info("START - net worth calculation request for user : {}", id);
        ResponseEntity<NetWorthDTO> response = portfolioService.calculateNetWorth(jwtToken, id);
        log.info("END- net worth calculation request");
        return response;
    }


    /**
     * http://localhost:8084/net-worth-service/sellAssets
     * Sell assets response entity.
     *
     * @param jwtToken         the jwt token
     * @param assetSaleRequest the asset sale request
     * @return the response entity
     * @throws PortfolioNotFoundException the portfolio not found exception
     * @throws InvalidJwtTokenException   the invalid jwt token exception
     */
    @ApiOperation(value = "SellAssets",
            notes = "Post authorization of the request it sells the assets",
            httpMethod = "POST", response = ResponseEntity.class)
    @PostMapping("/sellAssets")
    public ResponseEntity<AssetSaleResponse> sellAssets(
            @RequestHeader("Authorization") @ApiParam(name = "jwtToken", value = "Jwt Token of the user to check its validity") String jwtToken,
            @RequestBody @ApiParam(name = "assetSaleRequest", value = "Details of asset sell request") AssetSaleRequest assetSaleRequest
    ) throws PortfolioNotFoundException, InvalidJwtTokenException {
        log.info("START - asset sell request for user : {}", assetSaleRequest.getUserId());
        ResponseEntity<AssetSaleResponse> response = portfolioService.sellAssets(jwtToken, assetSaleRequest);
        log.info("END- asset sell request");
        return response;
    }
}
