package com.example.kafkalearning;

import java.util.Optional;

public interface OrderRepository {
    Order save(Order order);
    Optional<Order> findById(String orderId);
}
