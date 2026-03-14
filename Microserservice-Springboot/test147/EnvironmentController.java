package com.example.env;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class EnvironmentController {

    @Value("${spring.profiles.active:default}")
    private String activeProfile;

    @Value("${server.port:8080}")
    private int serverPort;

    @Value("${DB_URL:jdbc:h2:mem:testdb}")
    private String dbUrl; // From environment variable

    @GetMapping("/env-info")
    public Map<String, Object> envInfo() {
        return Map.of(
            "activeProfile", activeProfile,
            "serverPort", serverPort,
            "dbUrl", dbUrl
        );
    }
}
