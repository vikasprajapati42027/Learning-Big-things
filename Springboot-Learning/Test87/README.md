# Test 87: SAGA Pattern (Distributed Transactions)

ACID is impossible in Microservices. SAGA is the solution.

## The Problem:
An order requires:
1. `Inventory Service` (Decrement stock).
2. `Payment Service` (Charge card).
3. `Shipping Service` (Ship items).

If Payment fails, you MUST put the stock back in Inventory. But they are different databases!

## The Solution:
A Saga is a sequence of local transactions. Each transaction updates the database and publishes an event. If one fails, the Saga runs **Compensating Transactions** (Undo operations) to clean up.
