package com.example.kafkalearning.test4.service;

import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class OrderStore {
    private final Set<String> processedOrders = ConcurrentHashMap.newKeySet();

    public boolean tryMarkProcessed(String orderId) {
        return processedOrders.add(orderId);
    }

    public boolean isProcessed(String orderId) {
        return processedOrders.contains(orderId);
    }
}
