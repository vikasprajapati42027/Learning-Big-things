# Test 69: Apache Cassandra

Massive-scale, always-available distributed database.

## Key Files:
- `SensorRepository.java`: Shows a Cassandra table for IoT sensor data.
- `EXPLANATION.md`: Why Cassandra is chosen for write-heavy workloads.

## Concept:
Cassandra can handle millions of writes per second across dozens of servers with zero single point of failure. It's the database behind Netflix watchlists and IoT sensor networks — where data MUST always be recorded, even if some servers fail.
