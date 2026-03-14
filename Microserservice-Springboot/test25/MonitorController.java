package com.example.monitoring;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MonitorController {

    private final Counter orderCounter;

    public MonitorController(MeterRegistry registry) {
        // Custom Metric: Count how many orders are placed
        this.orderCounter = Counter.builder("shop.orders.count")
                .description("Total number of orders")
                .register(registry);
    }

    @GetMapping("/place-order")
    public String order() {
        orderCounter.increment();
        return "Order Placed! Metrics updated.";
    }
}
