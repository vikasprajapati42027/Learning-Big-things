package com.example.common.constants;

/**
 * Central place for Kafka topic names so producers/consumers stay aligned.
 */
public final class Topics {
    private Topics() {}

    public static final String ORDERS_CREATED = "orders.created";
    public static final String PAYMENTS_COMPLETED = "payments.completed";
}
