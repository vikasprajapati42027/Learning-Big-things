package com.example.redislearning.test1.service;

import com.example.redislearning.test1.model.ProfileCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ProfileSubscriber {
    private static final Logger log = LoggerFactory.getLogger(ProfileSubscriber.class);

    public void handleNotification(ProfileCache profile) {
        log.info("[Subscriber] notified about {}", profile);
    }
}
