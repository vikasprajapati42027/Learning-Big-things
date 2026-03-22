# Test 1: Kafka Learning Lab (Maven + Spring Boot + Kafka)

## Overview
This module proves you know how to start from scratch with Maven, wire Spring Boot to Kafka, and then evolve the pipeline from a simple producer-consumer to a robust streaming workflow.

## Walkthrough
1. **Bootstrap** – Run `mvn clean spring-boot:run` to start the embedded Spring Boot app. Kafka configuration lives in `src/main/resources/application.properties`.
2. **Model → Repository → Service** – `OrderCreateRequest` flows through `OrderServiceImpl`, which builds the domain `Order`, stores it via `OrderRepository`, and hands the event to `OrderEventProducer`.
3. **Controller → Kafka** – `POST /orders` accepts JSON (e.g., `{"orderId":"123","status":"ORDER_CREATED"}`), delegates to the service and returns an `OrderView` summarizing the persisted order and Kafka handoff.
4. **Consume events** – `OrderEventConsumer` listens to the same topic, logs offsets/partitions, and manually acknowledges each record so you can add dead-letter or retry logic later.
5. **Scale it up** – Change the topic partition count or listener concurrency in `KafkaConfig` to see how the app parallelizes work.
6. **Advanced checks** – Toggle manual ack, activate a dead-letter topic, or wrap the producer call inside a Kafka transaction to ensure exactly-once/at-least-once semantics.

## Build + Run Commands
```bash
mvn clean package
mvn spring-boot:run
```
While the app is running you can fire:

```bash
curl -X POST http://localhost:8080/orders \
  -H "Content-Type: application/json" \
  -d '{"orderId":"123","status":"ORDER_CREATED"}'
```

and watch the console logs plus the `OrderView` response describing the stored order and the queued Kafka event.

## What to verify
- The console shows `Published` and `Consumed` logs for each request.
- The consumer metadata (partitions, offsets) matches the payload key.
- The topic is auto-created with at least two partitions (see `KafkaConfig`).

## Next Levels
- Swap the serializers for Avro/Protobuf and introduce schema validation.
- Use `@KafkaListener` error handlers to forward failed records to `dead-letter-orders`.
- Connect actuator metrics (`spring.kafka.consumer.metrics-enabled=true`) to monitor lag and processing rates.
