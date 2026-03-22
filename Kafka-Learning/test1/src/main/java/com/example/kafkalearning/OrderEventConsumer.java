package com.example.kafkalearning;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class OrderEventConsumer {
    private static final Logger log = LoggerFactory.getLogger(OrderEventConsumer.class);

    private final ObjectMapper objectMapper;

    public OrderEventConsumer(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @KafkaListener(topics = "orders", containerFactory = "kafkaListenerContainerFactory")
    public void consume(ConsumerRecord<String, String> record, Acknowledgment ack) {
        try {
            OrderEvent event = objectMapper.readValue(record.value(), OrderEvent.class);
            log.info("Consumed order={} partition={} offset={} metadata={}", event.orderId(), record.partition(), record.offset(), record.topic());
        } catch (JsonProcessingException ex) {
            log.error("Unable to parse payload {}", record.value(), ex);
        } finally {
            ack.acknowledge();
        }
    }
}
