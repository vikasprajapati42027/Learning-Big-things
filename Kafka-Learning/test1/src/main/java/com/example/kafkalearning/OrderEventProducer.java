package com.example.kafkalearning;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderEventProducer {
    private static final Logger log = LoggerFactory.getLogger(OrderEventProducer.class);
    private static final String TOPIC = "orders";

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public OrderEventProducer(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    public void publishOrderCreated(OrderEvent event) {
        try {
            String payload = objectMapper.writeValueAsString(event);
            kafkaTemplate
                    .send(TOPIC, event.orderId(), payload)
                    .addCallback(result -> {
                        if (result != null && result.getRecordMetadata() != null) {
                            log.info("Published {} to partition {}", event.orderId(), result.getRecordMetadata().partition());
                        } else {
                            log.info("Published {} (partition info unavailable)", event.orderId());
                        }
                    }, ex -> log.warn("Publish failed for {}", event.orderId(), ex));
        } catch (JsonProcessingException ex) {
            log.error("Failed to serialize order event {}", event.orderId(), ex);
        }
    }
}
