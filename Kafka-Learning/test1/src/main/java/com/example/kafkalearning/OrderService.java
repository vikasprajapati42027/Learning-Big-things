package com.example.kafkalearning;

public interface OrderService {
    OrderView createOrder(OrderCreateRequest request);
}
