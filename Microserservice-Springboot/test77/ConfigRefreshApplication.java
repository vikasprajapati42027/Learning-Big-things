package com.example.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;

@SpringBootApplication
@RestController
@RefreshScope
public class ConfigRefreshApplication {

    @Value("${app.message:Default Hello}")
    private String message;

    public static void main(String[] args) {
        SpringApplication.run(ConfigRefreshApplication.class, args);
    }

    @GetMapping("/message")
    public String getMessage() {
        return "Config say: " + message;
    }
}
