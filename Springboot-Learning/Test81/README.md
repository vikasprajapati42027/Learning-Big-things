# Test 81: Spring Cloud Stream

Abstraction over messaging brokers.

## The Goal:
You don't want your code to be tied to RabbitMQ or Kafka. You want to write logic, and let Spring handle the "Plumbing".

## Core Concepts:
- **Binding**: Connection between your code and the broker.
- **Binder**: The implementation (e.g., Kafka Binder, Rabbit Binder).
- **Functions**: In newer versions, you just define a Java `Bean` of type `Function`, `Consumer`, or `Supplier`. Spring Cloud Stream automatically connects them to a "Topic" or "Queue".
