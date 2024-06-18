package com.example.springproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class JwtApplication {

    private static final String Secret_key = "";

    public static void main(String[] args) {
        SpringApplication.run(JwtApplication.class, args);
    }


}
