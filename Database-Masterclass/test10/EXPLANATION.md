# Test 10: Denormalization & JSON Data

## 1. What is Denormalization?
Sometimes, Normalization makes queries too slow because of too many JOINs. Denormalization is **Intentionally** adding redundant data to speed up reads.

## 2. 3NF vs Denormalized
- **3NF**: Slow Reads (Jobs), Fast Writes (Updates).
- **Denormalized**: Fast Reads (Single query), Slow Weights (Cascading updates).

## 3. MySQL 8.0 JSON Strategy
Modern databases allow you to store JSON. This is "Best of both worlds." You store normalized IDs but then store a "Metadata Blob" for fast UI rendering.
**Rule**: If you search by a field in JSON frequently, create a **Virtual Column (Q8)** and Index it. Without this, the DB has to parse the JSON for every row, which is slow.
