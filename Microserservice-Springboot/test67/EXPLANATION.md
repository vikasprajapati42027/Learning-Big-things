# Test 67: Apache Kafka (Consumer)

Listening to real-time event streams.

## Key Files:
- `KafkaConsumerService.java`: Demonstrates the `@KafkaListener` annotation for non-blocking consumption.
- `EXPLANATION.md`: Consumer Groups and Offsets.

## Concept:
Unlike standard MQ systems where a message is deleted once read, Kafka keeps the data. Consumer Groups allow multiple instances of a service to share the workload, while keeping track of where each one stopped reading (Offsets).
