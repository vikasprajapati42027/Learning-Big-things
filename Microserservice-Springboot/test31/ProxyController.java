package com.example.strangler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ProxyController {

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/legacy/**")
    public String proxyToMonolith() {
        // In a real Strangler Fig, the Gateway or a specific service
        // proxies requests to the old Monolith until they are rewritten.
        return "Request routed to the Legacy Monolith... (Still alive)";
    }

    @GetMapping("/modern/billing")
    public String modernService() {
        // This part has been extracted from the monolith
        return "New Billing Microservice: Fast and Independent!";
    }
}
