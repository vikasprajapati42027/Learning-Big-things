package com.example.stream;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Test 44: Spring Cloud Stream.
 * Abstraction over Kafka/RabbitMQ.
 */
public class MessageSender {

    @Autowired
    private Source source;

    public void send(String msg) {
        // You don't care if it's Kafka or RabbitMQ!
        // Spring Cloud Stream handles the details.
        source.output().send(MessageBuilder.withPayload(msg).build());
    }
}
