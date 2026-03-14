package com.example.saga;

import org.springframework.stereotype.Service;

@Service
public class SagaChoreographyService {

    public void processOrder() {
        System.out.println("Step 1: Order Created. Publishing 'OrderCreatedEvent' to Kafka.");
        // Inventory Service will listen to this and reserve stock
        // Payment Service will listen to this and charge card
    }

    public void handlePaymentSuccess() {
        System.out.println("Step 2: Payment Success received. Moving order to 'CONFIRMED'.");
    }
}
