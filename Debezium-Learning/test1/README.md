# Test 1: Debezium Change Data Capture Lab

## Why learn this now
After building Kafka producers/consumers, the next natural step is to capture database changes without touching application code. Debezium plugs into MySQL/PostgreSQL and streams `INSERT`/`UPDATE`/`DELETE` events into Kafka topics, so downstream services can react with the same tooling you already have.

## Project overview
- Use Spring Boot and Debezium Embedded Engine to tail a local database (e.g., MySQL) binlog.
- Forward each change event to Kafka through `KafkaTemplate` so downstream consumers can reuse the data.
- Schemas are serialized with JSON and include metadata such as the source table, operation, and timestamps.

## Run directions
1. Start a local MySQL container (or use an existing one) with binlog enabled.
2. Run `mvn clean package` then `mvn spring-boot:run` from `Debezium-Learning/test1`.
3. Apply schema changes to the watched table (insert or update rows) and watch the Spring Boot log plus the target Kafka topic for CDC events.

## What to inspect
- Debezium emits `io.debezium.data.Envelope` style payloads that contain `before`/`after` states.
- Each event arrives in Kafka on a topic derived from the database/table name (e.g., `dbserver1.inventory.products`).
- The README includes curl calls against the REST shim that replays captured events for testing.
