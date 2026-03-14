# Test 44: Unit of Work

## 🛒 1. Simple Explanation
Imagine you have a **Shopping Cart**. You change 5 items. 
- **Bad way**: Send 5 separate updates to the database.
- **Unit of Work way**: Track all changes in memory. When you click "Checkout," the system sends **one single transaction** to the database with all changes. 
This ensures either everything saves, or nothing saves (No partial errors!).
