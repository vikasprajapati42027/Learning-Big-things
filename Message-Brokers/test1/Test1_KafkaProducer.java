package com.example.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
class OrderEventProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private static final String TOPIC = "order-events";

    OrderEventProducer(KafkaTemplate<String, String> kafka) {
        this.kafkaTemplate = kafka;
    }

    public void publishOrderCreated(String orderId) {
        String event = "{\"event\":\"ORDER_CREATED\",\"orderId\":\"" + orderId + "\"}";
        kafkaTemplate.send(TOPIC, orderId, event); // key=orderId ensures ordering for same order
        System.out.println("Published: " + event);
    }
}

@RestController
public class Test1_KafkaProducer {
    private final OrderEventProducer producer;
    Test1_KafkaProducer(OrderEventProducer p) { this.producer = p; }

    @PostMapping("/orders/{id}")
    public String createOrder(@PathVariable String id) {
        producer.publishOrderCreated(id);
        return "Order " + id + " event published to Kafka!";
    }
}
