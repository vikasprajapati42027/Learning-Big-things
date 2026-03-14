package com.example.shutdown;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Configure in properties: server.shutdown=graceful
@SpringBootApplication
public class ShutdownApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShutdownApplication.class, args);
    }
}
