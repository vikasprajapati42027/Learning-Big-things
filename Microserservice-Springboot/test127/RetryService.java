package com.example.retry;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class RetryService {

    private int attempt = 0;

    @Retryable(value = RuntimeException.class, maxAttempts = 3, backoff = @Backoff(delay = 1000))
    public String callUnstableApi() {
        attempt++;
        System.out.println("Attempt #" + attempt);
        if (attempt < 3) throw new RuntimeException("API unavailable, retrying...");
        return "Success on attempt " + attempt;
    }

    @Recover
    public String recover(RuntimeException e) {
        return "Fallback: All 3 attempts failed. Using default data.";
    }
}
