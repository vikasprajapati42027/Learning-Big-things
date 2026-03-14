package com.example.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class ExternalApiHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        boolean isDown = Math.random() > 0.8; // Simulating a check
        if (isDown) {
            return Health.down().withDetail("Reason", "External API is not responding").build();
        }
        return Health.up().withDetail("Status", "Connected to API Gateway").build();
    }
}
