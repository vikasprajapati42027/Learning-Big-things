package com.example.mastery;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class ConfigController {

    // Rule 3: Config in Environment
    @Value("${DB_URL:jdbc:mysql://localhost:3306/default}")
    private String dbUrl;

    @Value("${SERVICE_PORT:8080}")
    private String port;

    @GetMapping("/system-info")
    public Map<String, String> getInfo() {
        return Map.of(
            "DatabaseBinding", dbUrl,
            "PortBinding", port,
            "State", "Stateless (Rule 6)",
            "Environment", "Dev/Prod Parity (Rule 10)"
        );
    }
}
