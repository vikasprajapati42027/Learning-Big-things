package com.example.tracking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example")
public class TrackingServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(TrackingServiceApplication.class, args);
    }
}
