package com.example.ddd;

// Domain Entity (Rich with logic)
public class Order {
    private String id;
    private double amount;
    private String status;

    public void processPayment() {
        if (amount > 0) {
            this.status = "PAID";
        } else {
            throw new RuntimeException("Invalid amount");
        }
    }
}
// Note: This is in the 'domain' layer, free from Spring annotations if possible.
