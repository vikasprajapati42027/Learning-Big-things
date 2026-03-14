package com.example.saga;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * SAGA Choreography: Each service reacts to events.
 */
@Service
public class OrderSagaChoreography {

    @EventListener
    public void onOrderCreated(OrderCreatedEvent event) {
        System.out.println("1. Order Created. Now notifying Payment Service...");
    }

    @EventListener
    public void onPaymentSuccess(PaymentSuccessEvent event) {
        System.out.println("2. Payment confirmed. Now notifying Inventory Service...");
    }
}

class OrderCreatedEvent { String orderId; }
class PaymentSuccessEvent { String orderId; }
