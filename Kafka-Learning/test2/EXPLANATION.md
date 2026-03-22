# Test 2: Kafka Streams Windowed Aggregation

## Simple Explanation
A Kafka Streams topology groups `UserAction` events by the `action` field, applies a 1-minute tumbling window, and counts how many times each action occurred inside the window. The topology writes one JSON summary per window to `user-action-counts`.

## Topology Overview
1. **Input** – `user-actions` topic carries payloads like `{"userId":"alice","action":"LOGIN"}`. The REST controller writes events with the userId as the partition key so the count stays even across retries.
2. **Stream Processing** – The stream filters empty actions, uses `action` as the new key, and groups by that key before applying `TimeWindows.of(Duration.ofMinutes(1))` so every minute forms a separate aggregation bucket. Manual grace of 5 seconds lets late-arriving events still join the window.
3. **State Store** – `Materialized.as("user-action-count-store")` keeps the latest counts for interactive parity and debugging. Each window result is sent to the output topic via `Produced.with(Serdes.String(), JsonSerde)`.

## Inspecting the Output
Use `kafka-console-consumer` (or a UI tool) to read from `user-action-counts`. Each message includes `action`, window start/end timestamps, and the total count for that window. You can also watch the Spring Boot log, which prints every incoming event and the `KStream` count transitions.
