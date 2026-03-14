# Test 64: Apache Pulsar

The unified messaging platform.

## Pulsar vs Kafka:
- **Architecture**: Pulsar separates "Store" from "Serve". This makes it easier to scale.
- **Latency**: Pulsar often has lower latency.
- **Storage**: Pulsar can store petabytes of data by offloading to cloud storage automatically.

Spring Boot has `spring-pulsar` to make integration as easy as `PulsarTemplate.send()`.
