package com.example.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "user-topic", groupId = "group-1")
    public void consume(String message) {
        System.out.println("Consumed from Kafka: " + message);
    }
}
