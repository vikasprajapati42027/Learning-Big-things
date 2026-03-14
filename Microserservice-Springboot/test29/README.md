# Test 29: Database per Service

The Golden Rule of Microservices.

## The Rule:
**Never share a database between two microservices.** 

## Why?
1. **Coupling**: If Service A changes a table column, Service B shouldn't crash.
2. **Independence**: Service A might need a fast NoSQL DB (MongoDB), while Service B needs a relational DB (PostgreSQL).
3. **Scaling**: You can scale the database of the "Orders" service without touching the "Users" database.

If Service A needs data from Service B, it must call B's API or listen to its events—it never goes into B's database!
