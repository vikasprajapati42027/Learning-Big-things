# Test 2: Kafka Streams Windowed Metrics

## Overview
This module builds on Test 1 by adding a Kafka Streams pipeline that rolls up events from `user-actions` into minute-based counts and writes the aggregates to `user-action-counts`.

## What You Learn
1. Use Spring Boot and Spring Kafka Streams to define a `KStream` topology.
2. Create topics via `NewTopic` beans so the topology always has the required input/output.
3. Publish JSON events via `KafkaTemplate` and inspect downstream aggregates with `kafka-console-consumer`.

## Run the Lab
```bash
mvn clean package
mvn spring-boot:run
```

While the app is running send actions (JSON values are auto-serialized):
```bash
curl -X POST http://localhost:8081/actions \
  -H "Content-Type: application/json" \
  -d '{"userId":"alice","action":"LOGIN"}'
```

Then watch the aggregated counts: 
```bash
kafka-console-consumer \
  --bootstrap-server localhost:9092 \
  --topic user-action-counts \
  --from-beginning \
  --property print.key=true \
  --property value.deserializer=org.apache.kafka.common.serialization.StringDeserializer
```

Aggregations emit one record per `(action, window)` pair every 1 minute, so repeat the `curl` calls and wait for windows to close to see new counts.
