# Test 3: Kafka Payment Flow and Dead-letter Routing

## Simple Explanation
This scenario connects a REST endpoint to Kafka so that payment requests are written to `payment-events`. A `@KafkaListener` inspects each record, and if the amount looks suspicious (negative or too large) it copies the event to a dead-letter topic (`payment-events-dlt`) for manual review.

## Key concepts
| Layer | Focus |
|-------|-------|
| REST + Kafka | `KafkaTemplate` is auto-configured, so the controller simply calls `send` and returns the original payload with HTTP 202.
| Topic management | `NewTopic` beans ensure the main and DLT topics exist with the desired partition count.
| Consumer handling | The listener reads from `payment-events`, logs metadata, and reroutes invalid payloads by using the same `KafkaTemplate` to publish to the DLT. Normal events are left untouched and can be processed further when needed.

## Outcome
You now understand how to produce/consume JSON payloads in Spring Kafka, how to decode headers like `topic`/`offset`, and how to reroute poisoned data to a secondary Kafka topic so it is persisted for investigation.
