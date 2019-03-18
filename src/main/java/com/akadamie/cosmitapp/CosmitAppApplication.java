package com.akadamie.cosmitapp;

import com.akadamie.cosmitapp.Models.Planet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:config.properties")
@SpringBootApplication
public class CosmitAppApplication {

    public static void main(String[] args) {




        SpringApplication.run(CosmitAppApplication.class, args);
    }

}
