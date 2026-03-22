package com.example.driver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example")
public class DriverServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(DriverServiceApplication.class, args);
    }
}
