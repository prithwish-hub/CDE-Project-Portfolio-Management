package com.cts.sharepriceservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DailySharePriceMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DailySharePriceMicroserviceApplication.class, args);
    }

}
