package com.example.booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example")
public class BookingServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookingServiceApplication.class, args);
    }
}
