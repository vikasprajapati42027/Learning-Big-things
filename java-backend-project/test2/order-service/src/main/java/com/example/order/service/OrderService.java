package com.example.order.service;

import com.example.common.constants.Topics;
import com.example.common.events.OrderCreatedEvent;
import com.example.order.model.Order;
import com.example.order.repository.OrderRepository;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository repository;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public OrderService(OrderRepository repository, KafkaTemplate<String, Object> kafkaTemplate) {
        this.repository = repository;
        this.kafkaTemplate = kafkaTemplate;
    }

    public Order create(Order order) {
        order.setStatus("PENDING");
        Order saved = repository.save(order);
        OrderCreatedEvent event = new OrderCreatedEvent(saved.getId(), saved.getUserId(), saved.getProductId(), saved.getQuantity(), saved.getAmount());
        kafkaTemplate.send(Topics.ORDERS_CREATED, event);
        return saved;
    }

    public List<Order> list() {
        return repository.findAll();
    }

    public void markPaid(Long orderId, String status) {
        repository.findById(orderId).ifPresent(order -> {
            order.setStatus(status);
            repository.save(order);
        });
    }
}
