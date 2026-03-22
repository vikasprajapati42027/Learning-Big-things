package com.example.kafkalearning.test4.service;

import com.example.kafkalearning.test4.model.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class OrderProcessor {
    private static final Logger log = LoggerFactory.getLogger(OrderProcessor.class);

    private final OrderStore orderStore;
    private final OrderMetrics orderMetrics;

    public OrderProcessor(OrderStore orderStore, OrderMetrics orderMetrics) {
        this.orderStore = orderStore;
        this.orderMetrics = orderMetrics;
    }

    public void process(OrderEvent event) {
        if (!orderStore.tryMarkProcessed(event.getOrderId())) {
            log.debug("Duplicate detected for {}", event.getOrderId());
            orderMetrics.incrementDuplicate();
            return;
        }

        if (event.getAmount() > 5000) {
            orderMetrics.incrementDlt();
            throw new OrderProcessingException("Order amount exceeds threshold: " + event.getAmount());
        }

        log.info("Processing order {} for {} amount {}", event.getOrderId(), event.getCustomerId(), event.getAmount());
        orderMetrics.incrementProcessed();
    }
}
