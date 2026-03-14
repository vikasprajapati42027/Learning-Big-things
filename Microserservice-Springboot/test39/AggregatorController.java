package com.example.aggregator;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * Test 39: Service Aggregator Pattern.
 * Merging multiple API calls into one.
 */
@RestController
public class OrderAggregatorController {

    private final RestTemplate rest = new RestTemplate();

    @GetMapping("/complete-order/{id}")
    public Object getFullDetails(@PathVariable String id) {
        // Step 1: Call Order Service
        Object order = rest.getForObject("http://order-service/orders/" + id, Object.class);
        
        // Step 2: Call User Service
        Object user = rest.getForObject("http://user-service/users/" + id, Object.class);
        
        // Step 3: Call Delivery Service
        Object delivery = rest.getForObject("http://delivery-service/status/" + id, Object.class);

        // Merge them and return in ONE JSON
        return Map.of("order", order, "user", user, "delivery", delivery);
    }
}
