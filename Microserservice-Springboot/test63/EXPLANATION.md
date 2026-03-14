# Test 63: Dead Letter Queue (DLQ)

Safely handling messages that cannot be processed.

## Key Files:
- `DeadLetterConsumer.java`: Shows how a failed message moves to the DLQ automatically.
- `EXPLANATION.md`: Why every production queue needs a safety net.

## Concept:
When a message fails 3 times (e.g., invalid data), instead of losing it forever, RabbitMQ moves it to a "Dead Letter Queue." An operator can then review and replay or discard these messages safely.
