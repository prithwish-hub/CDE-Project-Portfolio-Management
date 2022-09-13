package com.cts.networthservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CalculateNetworthMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CalculateNetworthMicroserviceApplication.class, args);
    }

}
