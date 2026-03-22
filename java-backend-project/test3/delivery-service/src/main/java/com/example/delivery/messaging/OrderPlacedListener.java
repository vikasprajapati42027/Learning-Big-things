package com.example.delivery.messaging;

import com.example.common.constants.Topics;
import com.example.common.events.OrderPlacedEvent;
import com.example.delivery.service.DeliveryService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class OrderPlacedListener {
    private final DeliveryService deliveryService;

    public OrderPlacedListener(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @KafkaListener(topics = Topics.ORDERS_PLACED, groupId = "delivery-service")
    public void handleOrder(OrderPlacedEvent event) {
        deliveryService.accept(event);
    }
}
