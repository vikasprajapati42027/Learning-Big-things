# Test 4: Production-ready Kafka Order Pipeline

## Overview
This lab layers on production concerns: idempotent producers, transactional fan-out, dead-letter handling, manual acknowledgements, and monitoring hooks for a resilient order-processing pipeline.

## Key Features
1. **Idempotent producer + transactions** – `KafkaTemplate` is configured with `enable.idempotence`, custom retries, and `transactional.id`, so each HTTP POST either writes to both `order-events` and `order-events-archive` or rolls back cleanly.
2. **Manual consumer with DLT** – Consumer commits offsets only after processing succeeds; failures flow into `order-events-dlt` via `DeadLetterPublishingRecoverer`.
3. **Observability** – Micrometer counters track processed, duplicate, and dead-lettered orders while Actuator exposes health/metrics endpoints.
4. **Validation & deduplication** – `@Valid` payloads enforce schema, and a concurrent store keeps track of processed order IDs.

## Running steps
```bash
mvn clean package
mvn spring-boot:run
```

Publish a valid order:
```bash
curl -X POST http://localhost:8084/orders \
  -H "Content-Type: application/json" \
  -d '{"orderId":"ord-101","customerId":"cust-7","amount":1200,"currency":"USD","status":"CREATED"}'
```

Send a bad payload (too large or negative) to trigger dead-letter:
```bash
curl -X POST http://localhost:8084/orders -H "Content-Type: application/json" -d '{"orderId":"ord-999","customerId":"cust-9","amount":99999,"currency":"USD","status":"CREATED"}'
```

Observe topics:
```bash
kafka-console-consumer --bootstrap-server localhost:9092 --topic order-events --from-beginning --property print.key=true
kafka-console-consumer --bootstrap-server localhost:9092 --topic order-events-archive --from-beginning --property print.key=true
kafka-console-consumer --bootstrap-server localhost:9092 --topic order-events-dlt --from-beginning --property print.key=true
```

## Prometheus-ready metrics
1. `http://localhost:8084/actuator/metrics/order.processed` (counter of successful entries).
2. `http://localhost:8084/actuator/metrics/order.duplicates` (tracks dedup hits).
3. `http://localhost:8084/actuator/prometheus` for all exposed metrics.

## Verification
- Only validated payloads enter `order-events` and `order-events-archive` with identical offsets (due to transactions).
- Invalid or suspicious messages appear in `order-events-dlt` with headers describing the failure.
- Actuator metrics increase when the listener processes/duplicates messages.
