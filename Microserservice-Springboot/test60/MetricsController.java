package com.example.metrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MetricsController {

    private final Counter requestCounter;
    private final Timer processingTimer;

    public MetricsController(MeterRegistry registry) {
        // Metric: Total requests
        this.requestCounter = Counter.builder("api.requests.total")
                .description("Total number of API calls")
                .register(registry);

        // Metric: Time taken to process
        this.processingTimer = Timer.builder("api.processing.time")
                .description("Time taken to process orders")
                .register(registry);
    }

    @GetMapping("/track")
    public String track() {
        requestCounter.increment();
        
        return processingTimer.record(() -> {
            try { Thread.sleep(200); } catch (InterruptedException e) {}
            return "Metric recorded: One more request tracked!";
        });
    }
}
