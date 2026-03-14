package com.example.cqrs;

import java.util.List;

// Write Model (Command)
class OrderCommandService {
    public void createOrder(String details) { 
        // Logic for saving and consistency
    }
}

// Read Model (Query)
class OrderQueryService {
    public List<String> getOrderHistory() {
        // Optimized for fast searching
        return List.of("Order 1", "Order 2");
    }
}
// In advanced CQRS, these would use two different databases!
