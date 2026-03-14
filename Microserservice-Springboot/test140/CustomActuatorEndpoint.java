package com.example.actuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;
import java.util.Map;

@Component
@Endpoint(id = "app-info")
public class CustomActuatorEndpoint {

    @ReadOperation
    public Map<String, Object> info() {
        return Map.of(
            "version", "2.5.0",
            "build-date", "2026-03-14",
            "team", "Backend Engineering",
            "status", "Operational"
        );
    }
}
