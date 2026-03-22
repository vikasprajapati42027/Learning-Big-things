package com.example.redislearning.test1.service;

import com.example.redislearning.test1.model.ProfileCache;
import org.springframework.data.redis.core.ChannelTopic;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;

@Service
public class ProfileService {
    private final RedisTemplate<String, ProfileCache> redisTemplate;
    private final ChannelTopic topic;

    public ProfileService(RedisTemplate<String, ProfileCache> redisTemplate, ChannelTopic topic) {
        this.redisTemplate = redisTemplate;
        this.topic = topic;
    }

    public ProfileCache save(ProfileCache profile) {
        profile.setLastUpdated(Instant.now());
        redisTemplate.opsForValue().set(profile.getId(), profile, Duration.ofHours(1));
        redisTemplate.convertAndSend(topic.getTopic(), profile);
        return profile;
    }

    public ProfileCache find(String id) {
        ProfileCache cached = redisTemplate.opsForValue().get(id);
        if (cached != null) {
            return cached;
        }
        ProfileCache stub = new ProfileCache(id, "unknown", "unknown@example.com", Instant.now(), null);
        redisTemplate.opsForValue().set(id, stub, Duration.ofMinutes(5));
        return stub;
    }
}
