package com.example.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * Test 41: Custom Health Checks (Self-Healing).
 */
@Component
public class ExternalApiHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        boolean isApiUp = checkExternalApi(); // Check if your partner's API is working
        if (isApiUp) {
            return Health.up().withDetail("External API", "Working perfect").build();
        }
        return Health.down().withDetail("External API", "Partner system is down!").build();
    }

    private boolean checkExternalApi() { return true; }
}
