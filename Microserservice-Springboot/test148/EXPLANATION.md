# Test 148: CDC (Change Data Capture) with Debezium

Watching your database for changes and reacting in real-time.

## Key Files:
- `DebeziumSimulation.java`: Logical view of reacting to DB logs.
- `EXPLANATION.md`: Why CDC is the ultimate way to sync microservices.

## Concept:
Instead of your code calling Kafka, Debezium "watches" the low-level Binary Log (BinLog) of your database (MySQL/Postgres). The moment a row is added or changed, Debezium detects it and sends a message to Kafka automatically. It's the most reliable way to keep multiple systems in sync.
