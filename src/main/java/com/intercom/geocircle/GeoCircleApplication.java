package com.intercom.geocircle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class GeoCircleApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeoCircleApplication.class, args);
    }

}
