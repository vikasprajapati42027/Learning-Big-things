package com.example.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class KafkaApplication {
    public static void main(String[] args) {
        SpringApplication.run(KafkaApplication.class, args);
    }

    @KafkaListener(topics = "user_topic", groupId = "group_id")
    public void consume(String message) {
        System.out.println("Kafka message received: " + message);
    }
}
/**
 * Test 16: Apache Kafka.
 * 
 * Kafka is for High-throughput streaming. 
 * It can handle billions of events per day.
 */
