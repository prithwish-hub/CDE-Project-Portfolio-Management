package com.cts.networthservice.clients;

import com.cts.networthservice.dto.MutualFundDetails;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "${mutualfundservice.client.name}", url = "${mutualfundservice.client.url}")
public interface MutualFundFeignClient {
    @GetMapping("/mutualFundNav/{mutualFundName}")
    ResponseEntity<MutualFundDetails> getMutualFundDetailsByName(@RequestHeader("Authorization") String jwtToken, @PathVariable String mutualFundName);
}
