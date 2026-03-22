package com.example.kafkalearning;

public class OrderView {
    private final String orderId;
    private final String status;
    private final String message;
    private final long timestamp;

    public OrderView(String orderId, String status, String message, long timestamp) {
        this.orderId = orderId;
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public long getTimestamp() {
        return timestamp;
    }
}
