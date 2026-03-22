package com.example.kafkalearning.test4.service;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

@Component
public class OrderMetrics {
    private final Counter processedCounter;
    private final Counter duplicateCounter;
    private final Counter dltCounter;

    public OrderMetrics(MeterRegistry registry) {
        this.processedCounter = Counter.builder("order.processed").description("Processed Kafka orders").register(registry);
        this.duplicateCounter = Counter.builder("order.duplicates").description("Duplicate order submissions").register(registry);
        this.dltCounter = Counter.builder("order.dlt").description("Orders routed to DLT").register(registry);
    }

    public void incrementProcessed() {
        processedCounter.increment();
    }

    public void incrementDuplicate() {
        duplicateCounter.increment();
    }

    public void incrementDlt() {
        dltCounter.increment();
    }
}
