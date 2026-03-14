package com.example.aggregator;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Map;

@Service
public class AggregatorService {
    private final RestTemplate restTemplate;

    public AggregatorService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Map<String, Object> getMergedData(String id) {
        // Simulating calls to other services
        // In reality, these would be real microservice URLs
        return Map.of(
            "orderId", id,
            "userDetails", "User data from User-Service",
            "paymentStatus", "Success from Payment-Service",
            "trackingInfo", "In-transit from Shipping-Service"
        );
    }
}
