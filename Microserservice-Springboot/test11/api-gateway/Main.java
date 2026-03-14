package com.example.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GatewaySecurityApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewaySecurityApplication.class, args);
    }
}

/**
 * Test 11: Security at the Gateway.
 * 
 * Why check security at the Gateway?
 * If you check security in every microservice, you repeat code. 
 * If you check it at the Gateway, you protect ALL services in one place.
 */
