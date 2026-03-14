# Test 26: MongoDB & NoSQL (50 Scenarios)

## 1. SQL vs NoSQL (The Main Interview Question)
- **SQL (Relational)**: Fixed Schema, Joins, ACID, Vertical Scaling. Best for Finance/ERP.
- **NoSQL (Document/MongoDB)**: Dynamic Schema, Embedding, BASE, Horizontal Scaling (Sharding). Best for Catalogs, Content Mgmt, Real-time Analytics.

## 2. Embedding vs Referencing (Q41)
- **Embedding**: Store "Address" inside the "User" document. **Pros**: Fast reads (1 query). **Cons**: Hard to update address if it changes for 10 users.
- **Referencing**: Store "address_id" in User. **Pros**: Normalized. **Cons**: Requires `$lookup` (Join), which is slower in NoSQL.

## 3. The Aggregation Pipeline
Think of it like an **Assembly Line**. 
1. `Match` (Pick parts) 
2. `Group` (Assemble them) 
3. `Sort` (Pack them) 
4. `Project` (Label them).
This is how you do complex reporting in MongoDB without traditional SQL GROUP BY.

## 4. Write Concern (Q48)
How safe do you want your data?
- `w: 1`: Fast. Only the leader server writes.
- `w: majority`: Safe. Most of the cluster must agree before saying "Success". If the leader dies, your data is NOT lost.
