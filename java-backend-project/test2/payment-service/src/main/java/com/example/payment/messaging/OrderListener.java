package com.example.payment.messaging;

import com.example.common.constants.Topics;
import com.example.common.events.OrderCreatedEvent;
import com.example.payment.service.PaymentService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class OrderListener {

    private final PaymentService paymentService;

    public OrderListener(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @KafkaListener(topics = Topics.ORDERS_CREATED, groupId = "payment-service")
    public void handleOrder(OrderCreatedEvent event) {
        paymentService.handle(event);
    }
}
