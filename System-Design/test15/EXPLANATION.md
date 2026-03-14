# Test 15: Saga Pattern (Distributed Transactions)

## Simple Explanation
In a Monolith, you can use `@Transactional` to update 5 tables at once. In Microservices, each service has its OWN database. You can't use a single transaction.

## The Saga Pattern
A sequence of local transactions. Each service performs its update and then triggers the next service.

## Two Types:
1. **Choreography**: Each service publishes an event (e.g., "OrderCreated") and the next service listens and acts. (No central boss).
2. **Orchestration**: A central "Saga Manager" tells Service A to do X, then Service B to do Y.

## What if it fails? (Compensating Transactions)
If Step 3 (Payment) fails, you must "Undo" Step 1 (Inventory) and Step 2 (Order).
- You call **Compensating Transactions**: "Restock Inventory" and "Cancel Order".

## Summary
You don't get immediate correctness (ACID). You get **Eventual Consistency**.
- User sees: "Order is processing..."
- Eventually: "Order Confirmed" or "Failed (Refunded)".
