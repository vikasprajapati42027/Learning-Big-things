# Test 2: CAP Theorem

## Simple Explanation
In a distributed system, you can only guarantee 2 out of these 3:

| Property | Meaning |
|----------|---------|
| **C**onsistency | Every read gets the latest write |
| **A**vailability | Every request gets a response (might be old data) |
| **P**artition Tolerance | System works even if network breaks between nodes |

## The Trade-off
Network failures (Partitions) WILL happen. So you choose: C or A.

| Choose | Database Examples | When |
|--------|-----------------|------|
| **CP** (Consistent + Partition Tolerant) | MongoDB, HBase, Zookeeper | Finance, inventory |
| **AP** (Available + Partition Tolerant) | Cassandra, CouchDB, DynamoDB | Social media, analytics |
| **CA** (Consistent + Available) | MySQL, PostgreSQL | Single server (no partition possible!) |

## Real Example
Two servers are separated by a network failure.
- **Bank**: Choose CP → Refuse transactions until network heals (safe!)
- **Social feed**: Choose AP → Show slightly old posts (acceptable!)
