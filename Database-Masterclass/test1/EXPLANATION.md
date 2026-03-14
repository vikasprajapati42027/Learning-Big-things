# Test 1: The 50-Query Join Challenge (Interview Grade)

## 1. The Strategy
This test is designed like a real-world interview. We don't just use one table; we use a **6-table schema** that mimics a real E-commerce platform.

## 2. Relationships to Study
- **1-to-Many**: `Users -> Orders`, `Categories -> Products`.
- **Many-to-Many**: `Orders <-> Products` (via `Order_Items`).
- **Many-to-Many**: `Users <-> Products` (via `Reviews`).

## 3. Top 3 Interview Patterns in these 50 Queries:
1. **The "Missing" Pattern (LEFT JOIN + IS NULL)**: Used in Q3 and Q15 to find users or products that lack certain activity.
2. **The "Multi-Hop" Join**: Q5 and Q7 demonstrate joining 4+ tables to get a result. 
3. **Filtering after Aggregation (HAVING)**: Q13 and Q18 show how to filter groups based on counts.

## 4. Why 50 Queries?
Repetition builds muscle memory. By doing 50 variations of Joins, Subqueries, and Groupings, you will be able to write SQL for any complex reporting requirement in seconds.
