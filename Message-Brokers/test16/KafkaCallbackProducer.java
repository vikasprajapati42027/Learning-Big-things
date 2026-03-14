package com.example.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaCallbackProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaCallbackProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String msg) {
        kafkaTemplate.send("my_topic", msg)
            .whenComplete((result, ex) -> {
                if (ex == null) {
                    System.out.println("Sent offset: " + result.getRecordMetadata().offset());
                } else {
                    System.err.println("Failed to send: " + ex.getMessage());
                }
            });
    }
}
