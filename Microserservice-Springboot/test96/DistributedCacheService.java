package com.example.cache;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class DistributedCacheService {

    @Cacheable(value = "products", key = "#id")
    public String getProductInfo(String id) {
        // Slow database call simulated
        try { Thread.sleep(3000); } catch (InterruptedException e) {}
        return "Product Data from DB for: " + id;
    }
}
// Note: This requires 'spring-boot-starter-data-redis' and configuration in properties.
