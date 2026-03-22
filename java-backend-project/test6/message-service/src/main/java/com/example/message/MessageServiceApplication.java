package com.example.message;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example")
public class MessageServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(MessageServiceApplication.class, args);
    }
}
