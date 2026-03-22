package com.example.order.messaging;

import com.example.common.constants.Topics;
import com.example.common.events.DeliveryStatusEvent;
import com.example.order.service.OrderService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class DeliveryStatusListener {
    private final OrderService orderService;

    public DeliveryStatusListener(OrderService orderService) {
        this.orderService = orderService;
    }

    @KafkaListener(topics = Topics.DELIVERY_STATUS, groupId = "order-service")
    public void handleStatus(DeliveryStatusEvent event) {
        orderService.updateStatus(event.orderId(), event.status());
    }
}
