package com.example.kafkalearning.test4.service;

import com.example.kafkalearning.test4.config.KafkaConfig;
import com.example.kafkalearning.test4.model.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private static final Logger log = LoggerFactory.getLogger(OrderService.class);

    private final KafkaTemplate<String, OrderEvent> kafkaTemplate;

    public OrderService(KafkaTemplate<String, OrderEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publish(OrderEvent event) {
        kafkaTemplate.executeInTransaction(operations -> {
            log.debug("Publishing {} to {} and {}", event.getOrderId(), KafkaConfig.ORDER_TOPIC, KafkaConfig.ARCHIVE_TOPIC);
            operations.send(KafkaConfig.ORDER_TOPIC, event.getOrderId(), event);
            operations.send(KafkaConfig.ARCHIVE_TOPIC, event.getOrderId(), event);
            return null;
        });
    }
}
