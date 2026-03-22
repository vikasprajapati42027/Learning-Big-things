package com.example.kafkalearning;

public class Order {
    private final String orderId;
    private final String status;
    private final long createdAt;

    public Order(String orderId, String status, long createdAt) {
        this.orderId = orderId;
        this.status = status;
        this.createdAt = createdAt;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getStatus() {
        return status;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public OrderEvent toEvent() {
        return new OrderEvent(orderId, status, createdAt);
    }
}
