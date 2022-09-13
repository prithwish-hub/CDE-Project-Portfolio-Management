package com.cts.sharepriceservice.clients;

import com.cts.sharepriceservice.dto.ValidationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "${authservice.client.name}", url = "${authservice.client.url}")
public interface AuthFeignClient {
    @GetMapping("/validate")
    ResponseEntity<ValidationResponse> validate(@RequestHeader(name = "Authorization") String jwtToken);
}
