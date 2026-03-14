package com.example.hexagonal;

// Domain Port (Interface)
interface PaymentPort {
    void pay(double amount);
}

// Infrastructure Adapter (Implementation)
class StripeAdapter implements PaymentPort {
    @Override
    public void pay(double amount) {
        System.out.println("Payment processed via Stripe.");
    }
}
