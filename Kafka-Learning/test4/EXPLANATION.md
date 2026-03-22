# Test 4: Production-Ready Kafka Order Pipeline

## Simple Explanation
This module creates a Spring Boot service that emits orders to Kafka with full production safeguards: producer transactions, manual acknowledgment, dead-letter routing, schema validation, and observability hooks.

## Architecture Highlights
| Component | Description |
|-----------|-------------|
| REST + Validation | `OrderController` accepts POST /orders with `@Valid` payloads. Invalid JSON is rejected before hitting Kafka, and `@ControllerAdvice` turns violations into clear HTTP 400 responses.
| Kafka Producer | `KafkaConfig` builds an idempotent, transactional `KafkaTemplate` plus `NewTopic` beans. The service writes each `OrderEvent` to both `order-events` (primary stream) and `order-events-archive` within one transaction to keep consumer views consistent.
| Kafka Consumer | `OrderEventListener` uses manual acknowledgement and a `SeekToCurrentErrorHandler` backed by `DeadLetterPublishingRecoverer`. Suspicious orders (too large or missing data) throw `OrderProcessingException`, sending the record to `order-events-dlt` while allowing the container to resume.
| Deduplication Store | `OrderStore` keeps a thread-safe set of processed `orderId`s so retries/resubmits don’t process the same business action twice; duplicates increment a Micrometer counter.
| Observability | Counters (`order.processed`, `order.duplicates`, `order.dlt`) feed Micrometer so Prometheus/Actuator can monitor success, duplicates, and dead-letter volumes.

## Outcome
You’ll see how production-ready Kafka services validate input, deduplicate work, keep transactional writes consistent across topics, and surface metrics while still being resilient to bad data.
