package com.example.kafkalearning;

import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderEventProducer producer;
    private final OrderRepository repository;

    public OrderServiceImpl(OrderEventProducer producer, OrderRepository repository) {
        this.producer = producer;
        this.repository = repository;
    }

    @Override
    public OrderView createOrder(OrderCreateRequest request) {
        String orderId = (request.getOrderId() == null || request.getOrderId().isBlank())
                ? UUID.randomUUID().toString()
                : request.getOrderId();
        String status = (request.getStatus() == null || request.getStatus().isBlank())
                ? "ORDER_CREATED"
                : request.getStatus();
        long timestamp = Instant.now().toEpochMilli();
        Order order = new Order(orderId, status, timestamp);
        producer.publishOrderCreated(order.toEvent());
        Order saved = repository.save(order);
        return new OrderView(saved.getOrderId(), saved.getStatus(), "Event queued to Kafka topic orders", saved.getCreatedAt());
    }
}
