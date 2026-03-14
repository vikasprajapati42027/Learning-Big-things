# Test 65: RabbitMQ (Smart Routing)

Using Exchanges and Routing Keys to direct messages.

## Key Files:
- `RabbitConfig.java`: Demonstrates how to bind a Queue to an Exchange with a specific Routing Key.
- `EXPLANATION.md`: Why RabbitMQ is better at complex logic than Kafka.

## Concept:
Unlike Kafka (which is a simple stream), RabbitMQ acts like a post office. You send a letter to the "Exchange", and based on the "Routing Key" (address), the Exchange decides which mailbox (Queue) it should go into.
