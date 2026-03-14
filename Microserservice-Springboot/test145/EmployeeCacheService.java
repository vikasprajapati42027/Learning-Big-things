package com.example.cache;

import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
@CacheConfig(cacheNames = "employees")
public class EmployeeCacheService {

    private final Map<Long, String> db = new HashMap<>(Map.of(1L, "Vikas", 2L, "Rahul", 3L, "Priya"));

    @Cacheable(key = "#id")
    public String getEmployee(Long id) {
        System.out.println("Fetching from DB for id: " + id);
        return db.get(id);
    }

    @CacheEvict(key = "#id")
    public void deleteEmployee(Long id) {
        db.remove(id);
        System.out.println("Deleted and evicted cache for id: " + id);
    }

    @CachePut(key = "#id")
    public String updateEmployee(Long id, String name) {
        db.put(id, name);
        return name; // Updated value goes back into cache
    }
}
