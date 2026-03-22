package com.example.kafkalearning;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryOrderRepository implements OrderRepository {
    private final Map<String, Order> store = new ConcurrentHashMap<>();

    @Override
    public Order save(Order order) {
        store.put(order.getOrderId(), order);
        return order;
    }

    @Override
    public Optional<Order> findById(String orderId) {
        return Optional.ofNullable(store.get(orderId));
    }

    public Collection<Order> findAll() {
        return store.values();
    }
}
