package com.example.stocks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RealtimeStocksApplication {
    public static void main(String[] args) {
        SpringApplication.run(RealtimeStocksApplication.class, args);
    }
}
