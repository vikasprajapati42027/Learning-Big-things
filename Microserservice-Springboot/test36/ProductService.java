package com.example.cache;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Test 36: Cache-Aside Pattern with Redis.
 */
@Service
public class ProductService {

    // 1. Check Redis Cache.
    // 2. If data is there, return it (FAST!).
    // 3. If NOT there, go to Database.
    // 4. Save result in Cache for next time.
    @Cacheable(value = "products", key = "#id")
    public String getProductInfo(Long id) {
        System.out.println(">>> Cache Miss! Going to slow Database...");
        return "Product Data from DB";
    }
}
