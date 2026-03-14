package com.example.ratelimit;

import io.github.bucket4j.Bucket;
import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Refill;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.Duration;

@RestController
public class RateLimitController {

    // 10 tokens per minute
    private final Bucket bucket = Bucket.builder()
            .addLimit(Bandwidth.classic(10, Refill.intervally(10, Duration.ofMinutes(1))))
            .build();

    @GetMapping("/api/limited")
    public String limitedApi() {
        if (bucket.tryConsume(1)) {
            return "Request allowed! Tokens remaining.";
        } else {
            return "Too many requests! Wait until refill.";
        }
    }
}
