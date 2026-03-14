package com.example.resilience;

import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.stereotype.Service;
import java.util.concurrent.CompletableFuture;

@Service
public class ResilienceService {

    // Test 34: Retry Pattern
    // If it fails, try again 3 times (useful for network flickers)
    @Retry(name = "backendA", fallbackMethod = "fallback")
    public String callService() {
        return "Success!";
    }

    // Test 35: Time Limiter
    // If the service takes more than 1 second, kill the request
    @TimeLimiter(name = "backendB")
    public CompletableFuture<String> callSlowService() {
        return CompletableFuture.supplyAsync(() -> {
            try { Thread.sleep(5000); } catch (Exception e) {}
            return "Too late!";
        });
    }

    public String fallback(Exception e) { return "Recovery Mode!"; }
}
