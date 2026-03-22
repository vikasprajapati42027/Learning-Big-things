# Test 1: Debezium Embedded Engine Demo

## Simple explanation
This test boots the Debezium Embedded Engine inside Spring Boot, pointing it at a MySQL binlog. The engine emits `ChangeEvent<SourceRecord>` objects whenever rows are inserted/updated/deleted, and we forward them into a dedicated Kafka topic so downstream services can reuse the data.

## Key pieces
1. `DebeziumConfig` configures the connector properties (binlog host, user, offset storage). Spring manages the embedded engine lifecycle.
2. `ChangeEventRouter` listens for Debezium events and publishes them through a transactional `KafkaTemplate` (simulated, since we only re-publish).
3. `ChangeReplayController` exposes a REST endpoint to replay the latest event for quick verification and to ensure the Kafka topic can be re-played.

## Outcome
You learn how to embed Debezium into Spring Boot, route CDC events into Kafka, and offer a lightweight HTTP surface to replay or inspect change events for debugging.
