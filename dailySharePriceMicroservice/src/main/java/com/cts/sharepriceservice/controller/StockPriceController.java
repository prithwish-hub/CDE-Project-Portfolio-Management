package com.cts.sharepriceservice.controller;

import com.cts.sharepriceservice.entity.StockDetails;
import com.cts.sharepriceservice.exception.InvalidJwtTokenException;
import com.cts.sharepriceservice.exception.StockNotFoundException;
import com.cts.sharepriceservice.service.StockPriceService;
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
@Api(value = "Endpoints to retrieve the current market price of the stocks from database and return")
public class StockPriceController {
    @Autowired
    private StockPriceService stockPriceService;

    /**
     * http://localhost:8082/share-price-service/dailySharePrice/{stockName}
     * Gets stock details by name.
     *
     * @param jwtToken  the jwt token
     * @param stockName the stock name
     * @return the stock details by name
     * @throws StockNotFoundException   the stock not found exception
     * @throws InvalidJwtTokenException the invalid jwt token exception
     */
    @ApiOperation(value = "GetStockDetailsByName",
            notes = "Post authorization of the request it returns stock details",
            httpMethod = "GET", response = ResponseEntity.class)
    @GetMapping("/dailySharePrice/{stockName}")
    public ResponseEntity<StockDetails> getStockDetailsByName(
            @RequestHeader("Authorization") @ApiParam(name = "jwtToken", value = "Jwt Token of the user to check its validity") String jwtToken,
            @PathVariable @ApiParam(name = "StockName", value = "Name of the stock to find its details") String stockName)
            throws StockNotFoundException, InvalidJwtTokenException {

        log.info("START - stock details request for : {}", stockName);
        ResponseEntity<StockDetails> response = stockPriceService.getStockDetailsByName(jwtToken, stockName);
        log.info("END - stock details request");
        return response;

    }
}
