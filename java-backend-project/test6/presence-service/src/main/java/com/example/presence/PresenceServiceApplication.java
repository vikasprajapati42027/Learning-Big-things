package com.example.presence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example")
public class PresenceServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(PresenceServiceApplication.class, args);
    }
}
