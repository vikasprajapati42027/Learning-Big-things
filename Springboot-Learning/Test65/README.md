# Test 65: RabbitMQ (The Smart Broker)

Routing messages with precision.

## Why RabbitMQ?
Kafka is a "Dumb Broker" (smart consumer). RabbitMQ is a **"Smart Broker"** (smart routing logic inside the broker itself).

## Key Terms:
- **Exchange**: Post office. Gets the message and decides where to send it.
- **Binding**: Connects the Exchange to a Queue.
- **Routing Key**: The address label on the message.
