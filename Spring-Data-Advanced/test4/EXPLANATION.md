# Test 4: Table Per Class

## 🏛️ 1. Concept
Every class (including the parent) gets a separate table. The child tables "copy" the columns of the parent.

## ⚠️ 2. Warning
Hibernate uses `UNION` queries for polymorphic searches, which is very expensive on large datasets.
