package com.example.deadletter;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class DeadLetterConsumer {

    @RabbitListener(queues = "main-queue")
    public void processMessage(String message) {
        System.out.println("Processing: " + message);
        if (message.contains("BAD")) {
            throw new RuntimeException("Bad message! Will go to Dead Letter Queue.");
        }
    }

    @RabbitListener(queues = "dead-letter-queue")
    public void handleDeadLetter(String message) {
        System.out.println("Dead Letter Queue received: " + message + " for manual review.");
    }
}
