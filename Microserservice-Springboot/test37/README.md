# Test 37: Transactional Outbox Pattern

Ensuring Database and Message Queue are in sync.

## The Problem:
1. You save an Order to the **Database**.
2. You try to send a message to **Kafka**.
3. **KAFKA IS DOWN.**
Now your DB says "Order Placed", but the shipping service never heard about it. Data is inconsistent!

## The Solution (Outbox):
1. In the **SAME SQL Transaction**, you save:
   - The Order data in `Orders` table.
   - The Kafka message in a special `Outbox` table.
2. A separate "Poller" service constantly checks the `Outbox` table.
3. If it finds a message, it tries to send it to Kafka.
4. Once Kafka confirms receipt, it deletes the message from the `Outbox`.

This ensures **At-Least-Once Delivery** even if the network fails!
