package com.example.redis;

import org.springframework.data.redis.connection.stream.RecordId;
import org.springframework.data.redis.connection.stream.StringRecord;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class RedisStreamService {

    private final StringRedisTemplate redisTemplate;

    public RedisStreamService(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public RecordId publishToStream(String key, String value) {
        // Redis Streams are like a lightweight Kafka
        StringRecord record = StringRecord.create("my-stream", Map.of(key, value));
        return redisTemplate.opsForStream().add(record);
    }
}
