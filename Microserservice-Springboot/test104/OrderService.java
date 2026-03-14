package com.example.outbox;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    private final OutboxRepository outboxRepository;

    public OrderService(OutboxRepository outboxRepository) {
        this.outboxRepository = outboxRepository;
    }

    @Transactional
    public void placeOrder(String orderId) {
        // 1. Save local order to DB
        System.out.println("Saving Order: " + orderId);
        
        // 2. Save event info to THE SAME database (The Outbox)
        // This ensures the Event is only sent if the Order is saved!
        outboxRepository.save(new OutboxEvent(orderId, "ORDER_CREATED"));
    }
}
