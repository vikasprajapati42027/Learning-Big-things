package com.example.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }
}
/**
 * Test 10: Production-Style Config Server
 * In Test 8, we used 'native' files. 
 * In a real production environment, we use a Git Repository.
 * This allows versioning, auditing (who changed what?), and easy rollbacks.
 */
