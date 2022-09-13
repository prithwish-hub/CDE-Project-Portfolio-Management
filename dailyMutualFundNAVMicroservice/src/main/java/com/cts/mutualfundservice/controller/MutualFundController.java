package com.cts.mutualfundservice.controller;

import com.cts.mutualfundservice.entity.MutualFundDetails;
import com.cts.mutualfundservice.exception.InvalidJwtTokenException;
import com.cts.mutualfundservice.exception.MutualFundNotFoundException;
import com.cts.mutualfundservice.service.MutualFundService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@Api(value = "Endpoints to retrieve NAV of the mutual funds from database and return")
public class MutualFundController {
    @Autowired
    private MutualFundService mutualFundService;


    /**
     * http://localhost:8083/mutual-fund-price-service/mutualFundNav/{mutualFundName}
     * Gets mutual fund details by name.
     *
     * @param jwtToken       the jwt token
     * @param mutualFundName the mutual fund name
     * @return the mutual fund details by name
     * @throws MutualFundNotFoundException the mutual fund not found exception
     * @throws InvalidJwtTokenException    the invalid jwt token exception
     */
    @ApiOperation(value = "GetMutualFundDetailsByName",
            notes = "Post authorization of the request it returns mutual fund details",
            httpMethod = "GET", response = ResponseEntity.class)
    @GetMapping("/mutualFundNav/{mutualFundName}")
    public ResponseEntity<MutualFundDetails> getMutualFundDetailsByName(
            @RequestHeader("Authorization") @ApiParam(name = "jwtToken", value = "Jwt Token of the user to check its validity") String jwtToken,
            @PathVariable @ApiParam(name = "MutualFundName", value = "Name of the mutual fund to find its details") String mutualFundName
    ) throws MutualFundNotFoundException, InvalidJwtTokenException {
        log.info("START - mutual fund details request for : {}", mutualFundName);
        ResponseEntity<MutualFundDetails> response = mutualFundService.getMutualFundDetailsByName(jwtToken, mutualFundName);
        log.info("END - mutual fund details request");
        return response;
    }
}
