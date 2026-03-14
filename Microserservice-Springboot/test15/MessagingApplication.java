package com.example.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MessagingApplication {
    public static void main(String[] args) {
        SpringApplication.run(MessagingApplication.class, args);
    }

    @RabbitListener(queues = "order_queue")
    public void handleOrder(String message) {
        System.out.println("Processing event: " + message);
    }
}
/**
 * Test 15: Event-Driven with RabbitMQ.
 * 
 * Instead of Service A calling B (Synchronous), 
 * Service A throws a message into a queue and walks away (Asynchronous).
 */
