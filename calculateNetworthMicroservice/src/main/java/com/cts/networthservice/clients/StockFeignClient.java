package com.cts.networthservice.clients;

import com.cts.networthservice.dto.StockDetails;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "${stockservice.client.name}", url = "${stockservice.client.url}")
public interface StockFeignClient {
    @GetMapping("/dailySharePrice/{stockName}")
    ResponseEntity<StockDetails> getStockDetailsByName(@RequestHeader("Authorization") String jwtToken, @PathVariable String stockName);
}
