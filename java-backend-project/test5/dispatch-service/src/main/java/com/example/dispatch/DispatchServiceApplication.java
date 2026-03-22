package com.example.dispatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example")
public class DispatchServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(DispatchServiceApplication.class, args);
    }
}
