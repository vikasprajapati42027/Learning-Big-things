package com.example.ratelimiter.controller;

import com.example.ratelimiter.service.SlidingWindowRateLimiter;
import com.example.ratelimiter.service.TokenBucketRateLimiter;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoController {
    private final TokenBucketRateLimiter tokenBucket;
    private final SlidingWindowRateLimiter sliding;

    public DemoController(TokenBucketRateLimiter tokenBucket, SlidingWindowRateLimiter sliding) {
        this.tokenBucket = tokenBucket;
        this.sliding = sliding;
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello(HttpServletRequest request) {
        String userKey = request.getRemoteAddr();
        boolean allowed = tokenBucket.allow("tb:" + userKey, 5, 10, 1);
        if (!allowed) {
            return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).body("Token bucket limit exceeded");
        }
        return ResponseEntity.ok("Hello, you are within rate limit!");
    }

    @GetMapping("/search")
    public ResponseEntity<String> search(HttpServletRequest request) {
        String userKey = request.getRemoteAddr();
        boolean allowed = sliding.allow(userKey, 20, 60); // 20 requests per 60s
        if (!allowed) {
            return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).body("Sliding window limit exceeded");
        }
        return ResponseEntity.ok("Search ok");
    }
}
