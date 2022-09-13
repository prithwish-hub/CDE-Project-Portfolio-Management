package com.cts.mutualfundservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DailyMutualFundNavMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DailyMutualFundNavMicroserviceApplication.class, args);
    }

}
