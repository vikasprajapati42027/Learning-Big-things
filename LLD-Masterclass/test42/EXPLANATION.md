# Test 42: Repository Pattern

## 🗃️ 1. Simple Explanation
The Repository is a **special kind of DAO**. It acts like an **In-Memory Collection** of domain objects. 
- You ask: `repo.findActiveUsers()`
- You don't care if there's a SQL `WHERE` clause or a NoSQL filter behind it.
It's the "Bridge" between the Domain (Pure Logic) and the Data mapping layer.
