package com.example.rider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example")
public class RiderServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(RiderServiceApplication.class, args);
    }
}
