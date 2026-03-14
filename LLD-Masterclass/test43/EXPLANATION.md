# Test 43: Service Layer Pattern

## 👔 1. Simple Explanation
Think of the Service Layer as the **Floor Manager**. 
- It coordinates between the **Controller** (Input) and the **Repository** (Database).
- It handles **Transactions**. (Wait, before saving the Order, we MUST reduce the Stock. If Stock fails, roll back everything!).
- It is the only place where "Business Rules" live.
