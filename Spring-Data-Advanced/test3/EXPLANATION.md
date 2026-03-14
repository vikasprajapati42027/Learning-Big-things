# Test 3: Joined Table Inheritance

## 🔗 1. Concept
Each class has its own table. The child table has a foreign key to the parent table's ID.

## ⚖️ 2. Trade-off
- **Pros**: Very clean database design (normalized).
- **Cons**: Requires SQL `JOIN` which can be slow for large data.
