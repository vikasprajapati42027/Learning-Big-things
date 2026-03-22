package com.example.ratelimiter.service;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

@Service
public class SlidingWindowRateLimiter {
    private final StringRedisTemplate redisTemplate;

    public SlidingWindowRateLimiter(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * Sliding window counter using Redis sorted set.
     */
    public boolean allow(String key, int limit, int windowSeconds) {
        long nowMillis = Instant.now().toEpochMilli();
        long windowStart = nowMillis - windowSeconds * 1000L;
        String zsetKey = "sw:" + key;

        redisTemplate.opsForZSet().removeRangeByScore(zsetKey, 0, windowStart);
        Long count = redisTemplate.opsForZSet().zCard(zsetKey);
        if (count != null && count >= limit) {
            return false;
        }
        redisTemplate.opsForZSet().add(zsetKey, String.valueOf(nowMillis), nowMillis);
        redisTemplate.expire(zsetKey, windowSeconds, TimeUnit.SECONDS);
        return true;
    }
}
