package com.demo.rentortopedic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@EntityScan(basePackages = {"com.demo.rentortopedic.model"})  // scan JPA entities
@SpringBootApplication
public class RentOrtopedicApplication {

    public static void main(String[] args) {
        SpringApplication.run(RentOrtopedicApplication.class, args);
    }

}

