package com.example.gateway;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Mono;

/**
 * Test 32: Rate Limiting.
 * Keep your servers safe from "Spam" or "DDoS" attacks.
 */
public class RateLimitConfig {

    @Bean
    public KeyResolver userKeyResolver() {
        // Limit based on User ID or IP Address
        return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());
    }
}
