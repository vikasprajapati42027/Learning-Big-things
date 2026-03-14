package com.example.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.retry.annotation.Backoff;
import org.springframework.stereotype.Component;

@Component
public class Test2_KafkaConsumer {

    // Basic consumer — listens to one topic
    @KafkaListener(topics = "order-events", groupId = "order-processor")
    public void processOrder(ConsumerRecord<String, String> record) {
        System.out.println("Received: " + record.value());
        System.out.println("Partition: " + record.partition() + ", Offset: " + record.offset());
        // Process the order...
    }

    // With automatic retry on failure
    @RetryableTopic(
        attempts = "3",
        backoff = @Backoff(delay = 1000, multiplier = 2), // 1s, 2s, 4s
        dltTopicSuffix = "-dlt"  // Failed after all retries → dead letter topic
    )
    @KafkaListener(topics = "payment-events", groupId = "payment-processor")
    public void processPayment(String message) {
        System.out.println("Processing payment: " + message);
        if (message.contains("FAIL")) throw new RuntimeException("Simulated failure");
        System.out.println("Payment processed successfully!");
    }
}
