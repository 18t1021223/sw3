package com.example.sw2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import static com.fasterxml.jackson.databind.MapperFeature.DEFAULT_VIEW_INCLUSION;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class Sw2Application {

    public static void main(String[] args) {
        SpringApplication.run(Sw2Application.class, args);
    }

}
