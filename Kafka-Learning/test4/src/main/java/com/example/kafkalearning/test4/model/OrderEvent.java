package com.example.kafkalearning.test4.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Pattern;

import java.time.Instant;
import java.util.Map;

public class OrderEvent {
    @NotBlank
    private String orderId;

    @NotBlank
    private String customerId;

    @Positive
    private double amount;

    @Pattern(regexp = "[A-Z]{3}")
    private String currency;

    @NotBlank
    private String status;

    @NotNull
    private Instant createdAt;

    private Map<String, String> metadata;

    public OrderEvent() {
        // Jackson
    }

    public OrderEvent(String orderId, String customerId, double amount, String currency, String status, Instant createdAt, Map<String, String> metadata) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.amount = amount;
        this.currency = currency;
        this.status = status;
        this.createdAt = createdAt;
        this.metadata = metadata;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }

    @Override
    public String toString() {
        return "OrderEvent{" +
                "orderId='" + orderId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                ", status='" + status + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
