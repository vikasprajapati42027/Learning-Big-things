# Test 1: Kafka Learning (Basic → Advanced)

## Simple Explanation
Kafka is a scalable, durable message broker. This test walks the learner from a Maven-powered Spring Boot project that produces and consumes Kafka events, up to advanced resiliency features.

## Learning Flow
1. **Basic (Maven + Spring Boot)** – Add `spring-kafka`, wire up a `KafkaTemplate`, and send/read JSON strings so the pipeline runs end-to-end.
2. **Intermediate (Topics, Partitions, Concurrency)** – Configure topic creation, partition-aware keys, and listener concurrency so the service stays performant.
3. **Advanced (Manual Ack, Dead-letter, Transactions)** – Handle poison messages, enable manual acknowledgements, and combine producer/consumer transactions for at-least-once guarantees.

## Key Concepts Covered
| Layer | Focus |
|-------|-------|
| `mvn` | Dependency management, `spring-boot-maven-plugin`, and property overrides for Kafka brokers. |
| Spring Boot | Auto-configured Kafka templates and listeners, Rest endpoints to trigger events, and bean wiring for producer/consumer services. |
| Kafka | Topics, partitions, offsets, acknowledgment modes, retries, and monitoring hooks through actuator metrics. |

## Outcome
After this test you can bootstrap a Maven + Spring Boot app that publishes to Kafka, scales via partitions, and survives the rough edges of real-world streaming workloads.
