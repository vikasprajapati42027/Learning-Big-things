# System Design Masterclass

## Topics to Cover

### Core Concepts
- `01_ScalabilityBasics` – Vertical vs Horizontal scaling
- `02_LoadBalancing` – Round Robin, Least Connections, Sticky Sessions
- `03_CAPTheorem` – Consistency, Availability, Partition Tolerance
- `04_BASEvsACID` – Eventual consistency in distributed systems

### Caching Strategies
- `05_CacheAside` – Application manages cache
- `06_WriteThrough` – Cache + DB written together
- `07_WriteBehind` – Write to cache, async flush to DB
- `08_CDNStrategy` – Edge caching for static assets

### Data Patterns
- `09_ConsistentHashing` – Minimal redistribution on scaling
- `10_DatabaseSharding` – Horizontal partitioning strategies
- `11_ReadReplicas` – Master-slave, master-master
- `12_DataPartitioning` – Range, hash, list partitioning

### High Availability
- `13_CircuitBreaker` – Cascading failure prevention
- `14_Bulkhead` – Thread pool isolation
- `15_RateLimiting` – Token bucket, leaky bucket
- `16_BackpressureHandling` – Reactive stream control

### Famous System Designs
- `17_DesignURLShortener` – Bit.ly design
- `18_DesignTwitter` – Fan-out on write/read
- `19_DesignUberBackend` – Location matching system
- `20_DesignNetflixStreaming` – CDN, ABR, recommendation
- `21_DesignWhatsApp` – WebSocket, message queue, delivery receipts
