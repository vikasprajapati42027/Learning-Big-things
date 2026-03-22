package com.example.kafkalearning.test3.model;

import java.util.Map;

public class PaymentEvent {
    private String paymentId;
    private double amount;
    private String currency;
    private String status;
    private Map<String, String> metadata;

    public PaymentEvent() {
        // Jackson
    }

    public PaymentEvent(String paymentId, double amount, String currency, String status, Map<String, String> metadata) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.currency = currency;
        this.status = status;
        this.metadata = metadata;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
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

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }

    @Override
    public String toString() {
        return "PaymentEvent{" +
                "paymentId='" + paymentId + '\'' +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                ", status='" + status + '\'' +
                ", metadata=" + metadata +
                '}';
    }
}
