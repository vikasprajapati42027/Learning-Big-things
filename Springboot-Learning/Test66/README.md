# Test 66: Dead Letter Queues (DLQ)

Handling failure like a pro.

## The Flow:
1. Message arrives in Main Queue.
2. Consumer tries to process but fails (Exception).
3. RabbitMQ retries (e.g., 3 times).
4. Still fails? Move it to the **Dead Letter Exchange**, which sends it to the **DLQ**.

## Why?
It prevents your main app from getting stuck on a "Poison Message" while allowing you to manually fix and replay the error later.
