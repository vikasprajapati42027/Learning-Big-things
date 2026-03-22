package com.example.kafkalearning;

public record OrderEvent(String orderId, String status, long createdAt) {}
