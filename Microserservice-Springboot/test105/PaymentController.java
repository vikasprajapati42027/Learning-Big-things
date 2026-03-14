package com.example.idempotency;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.ConcurrentHashMap;

@RestController
public class PaymentController {

    private final ConcurrentHashMap<String, String> processedKeys = new ConcurrentHashMap<>();

    @PostMapping("/pay")
    public String pay(@RequestHeader("Idempotency-Key") String key) {
        // If we already saw this key, return the previous result immediately
        if (processedKeys.containsKey(key)) {
            return "SUCCESS: (Duplicate Request ignored, returning original result)";
        }

        // Process actual payment
        String result = "SUCCESS: Payment charged at " + System.currentTimeMillis();
        processedKeys.put(key, result);
        
        return result;
    }
}
