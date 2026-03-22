# Test 3: Kafka Payment Event Flow

## Overview
This lab ships a lightweight Spring Boot service that produces `PaymentEvent`s and consumes them with a business listener that routes suspicious entries to a dead-letter topic. It demonstrates how to wire Kafka producers/consumers, inspect consumer offsets, and branch events that fail validation.

## Running steps
```bash
mvn clean package
mvn spring-boot:run
```

Use the REST API to publish events:
```bash
curl -X POST http://localhost:8082/payments \
  -H "Content-Type: application/json" \
  -d '{"paymentId":"pay-123","amount":1250.50,"currency":"USD","status":"CREATED"}'
```

Send a few good/ bad payloads so the listener can emit logs and optionally copy the message to the `payment-events-dlt` topic:
```bash
curl -X POST http://localhost:8082/payments -H "Content-Type: application/json" -d '{"paymentId":"pay-999","amount":-20,"currency":"USD","status":"CREATED"}'
```

Then examine both topics with `kafka-console-consumer`:
```bash
kafka-console-consumer --bootstrap-server localhost:9092 --topic payment-events --from-beginning --property print.key=true
kafka-console-consumer --bootstrap-server localhost:9092 --topic payment-events-dlt --from-beginning --property print.key=true
```

## What to verify
- The consumer logs include offsets, topic partition, and the validation decision.
- Any message above 2000 or with a negative amount lands in `payment-events-dlt`.
- The REST endpoint accepts JSON and mirrors the payload in the response.

## Next ideas
- Add Schema Registry with Avro for both topics.
- Plug in Micrometer metrics to count how many messages were rerouted.
- Throw in a `RetryTemplate` so temporary failures can reprocess before DLT.
