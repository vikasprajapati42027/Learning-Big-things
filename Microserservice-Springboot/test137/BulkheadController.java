package com.example.bulkhead;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BulkheadController {

    @GetMapping("/limited-resource")
    @Bulkhead(name = "fastService", type = Bulkhead.Type.SEMAPHORE)
    public String getLimited() {
        // Only a fixed number of threads can enter this method at once
        return "Resource access successful (Thread safe and isolated)";
    }
}
