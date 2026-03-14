package com.example.locking;

import org.springframework.stereotype.Service;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class DistributedLockService {

    // Simulating a Redis-based distributed lock
    private final ConcurrentHashMap<String, Boolean> redisMock = new ConcurrentHashMap<>();

    public boolean acquireLock(String lockKey) {
        // In real world: redis.setIfAbsent(lockKey, true, Duration.ofSeconds(10))
        return redisMock.putIfAbsent(lockKey, true) == null;
    }

    public void releaseLock(String lockKey) {
        redisMock.remove(lockKey);
    }
}
