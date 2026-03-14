package com.example.cbsf;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderServiceWithCircuitBreaker {

    private final RestTemplate restTemplate = new RestTemplate();

    @CircuitBreaker(name = "inventoryService", fallbackMethod = "getFallbackInventory")
    public String checkInventory(String productId) {
        return restTemplate.getForObject("http://inventory-service/stock/" + productId, String.class);
    }

    public String getFallbackInventory(String productId, Exception ex) {
        return "Inventory temporarily unavailable. Showing cached availability for product: " + productId;
    }
}
