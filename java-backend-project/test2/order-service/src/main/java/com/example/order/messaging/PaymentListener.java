package com.example.order.messaging;

import com.example.common.constants.Topics;
import com.example.common.events.PaymentCompletedEvent;
import com.example.order.service.OrderService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PaymentListener {

    private final OrderService orderService;

    public PaymentListener(OrderService orderService) {
        this.orderService = orderService;
    }

    @KafkaListener(topics = Topics.PAYMENTS_COMPLETED, groupId = "order-service")
    public void handlePayment(PaymentCompletedEvent event) {
        orderService.markPaid(event.orderId(), event.status());
    }
}
