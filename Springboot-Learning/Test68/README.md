# Test 68: Apache Cassandra (The Beast)

Handling Big Data at scale.

## Key Concept: Partitioning
Data is spread across many nodes based on a **Partition Key**. This allows you to store petabytes of data while keeping access fast.

## Trade-off (CAP Theorem):
Cassandra prioritizes **Availability** and **Partition Tolerance** over Consistency (AP system). This means data might take a few milliseconds to replicate to all nodes (Eventual Consistency).
