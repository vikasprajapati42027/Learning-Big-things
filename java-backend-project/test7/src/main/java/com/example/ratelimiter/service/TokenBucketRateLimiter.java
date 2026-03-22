package com.example.ratelimiter.service;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Collections;

@Service
public class TokenBucketRateLimiter {
    private static final String LUA = """
    local key = KEYS[1]
    local max_tokens = tonumber(ARGV[1])
    local refill_rate = tonumber(ARGV[2])
    local now = tonumber(ARGV[3])
    local requested = tonumber(ARGV[4])

    local data = redis.call('HMGET', key, 'tokens', 'timestamp')
    local tokens = tonumber(data[1]) or max_tokens
    local last_refill = tonumber(data[2]) or now

    local delta = now - last_refill
    local refill = delta * refill_rate
    tokens = math.min(max_tokens, tokens + refill)

    local allowed = tokens >= requested
    if allowed then
        tokens = tokens - requested
    end

    redis.call('HMSET', key, 'tokens', tokens, 'timestamp', now)
    redis.call('EXPIRE', key, 60)
    return allowed and 1 or 0
    """;

    private final StringRedisTemplate redisTemplate;
    private final DefaultRedisScript<Long> script;

    public TokenBucketRateLimiter(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.script = new DefaultRedisScript<>(LUA, Long.class);
    }

    /**
     * @param key unique key per subject (e.g. user/ip)
     * @param permitsPerSecond tokens added per second
     * @param burst maximum bucket size
     * @param requested tokens required for this request
     * @return true if allowed
     */
    public boolean allow(String key, int permitsPerSecond, int burst, int requested) {
        long now = Instant.now().getEpochSecond();
        Long result = redisTemplate.execute(script, Collections.singletonList(key),
                String.valueOf(burst), String.valueOf(permitsPerSecond), String.valueOf(now), String.valueOf(requested));
        return result != null && result == 1L;
    }
}
