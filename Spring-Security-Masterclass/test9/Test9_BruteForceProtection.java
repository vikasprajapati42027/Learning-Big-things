package com.example.security;

import org.springframework.web.bind.annotation.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

// Test 9: Brute Force Protection (Login Attempt Limiter)
@RestController
public class Test9_BruteForceProtection {

    // In production: use Redis so this scales across ALL servers
    private final ConcurrentHashMap<String, AtomicInteger> attempts = new ConcurrentHashMap<>();
    private static final int MAX_ATTEMPTS = 5;

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        if (isBlocked(username)) {
            return "ACCOUNT LOCKED: Too many failed attempts. Try after 30 minutes.";
        }

        boolean valid = "vikas".equals(username) && "password123".equals(password);

        if (!valid) {
            int count = attempts.computeIfAbsent(username, k -> new AtomicInteger(0))
                                .incrementAndGet();
            return "Wrong password! Attempt " + count + "/" + MAX_ATTEMPTS;
        }

        // Clear attempts on success
        attempts.remove(username);
        return "Login successful!";
    }

    private boolean isBlocked(String username) {
        AtomicInteger count = attempts.get(username);
        return count != null && count.get() >= MAX_ATTEMPTS;
    }
}
