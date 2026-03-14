# Test 5: 50 Scenarios in Transactions & Concurrency

## 1. The Senior Developer's Compass
Understanding `ACID` is theory; understanding **Locking Contention** is practice. This test teaches you how to handle millions of simultaneous transactions without corrupting data or causing system-wide stalls.

## 2. Key Interview Patterns
- **Optimistic Locking (Q11)**: Why is it better for high-traffic apps than `SELECT FOR UPDATE`? (Reduces DB-level lock holding time).
- **SKIP LOCKED (Q16)**: How to build a high-speed job queue using MySQL 8.
- **Deadlock Avoidance**: Always locking rows in a **Consistent Order** (e.g., always lock smaller ID first).

## 3. Row-Level vs Table-Level
MySQL (InnoDB) is smart. It uses **Row-Level Locking**. If Vikas and Rahul are withdrawing money at the same time, they don't block each other. But if they share an account, the Database manages the wait.

## 4. The 50 Scenarios
By practicing these, you learn to debug "Lock Wait Timeout" errors and choose the right **Isolation Level** for your application (Usually `READ COMMITTED` or `REPEATABLE READ`).
