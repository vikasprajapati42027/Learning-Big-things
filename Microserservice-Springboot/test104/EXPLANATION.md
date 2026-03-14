# Test 104: Transactional Outbox Pattern

Ensuring data consistency between your Database and Message Broker (Kafka).

## Key Files:
- `OrderService.java`: Demonstrates saving both the business data and the event in a single transaction.
- `EXPLANATION.md`: Why you should never call Kafka inside a `@Transactional` block.

## Why use it?
If you save an order and then Kafka is down, your data is inconsistent (Order saved, but no email sent). In the Outbox pattern, you save the "Event" in the same transaction as the "Order". A separate process then reads the Outbox table and pushes to Kafka reliably.
