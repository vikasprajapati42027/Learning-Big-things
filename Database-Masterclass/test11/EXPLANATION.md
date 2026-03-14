# Test 11: 50 Scenarios in Performance Tuning

## 1. The FAU Plan: Find, Analyze, Update
Performance tuning is not luck; it's a process.
1. **Find**: Use the Slow Query Log or `SHOW PROCESSLIST`.
2. **Analyze**: Use `EXPLAIN` and `EXPLAIN ANALYZE`. Look for "ALL", "Using filesort", or "Using temporary".
3. **Update**: Create composite indexes, rewrite queries, or adjust memory settings (Buffer Pools).

## 2. The Golden Rule of Indexing
**Selectivity matters.** An index on a "Gender" column is useless (50% split). An index on "Email" is perfect.

## 3. Covering Indexes
If all the columns you want (SELECT a, b) are part of the index (INDEX(a, b)), MySQL never reads the actual table from the disk. It reads the index (which is in RAM). This is **100x faster**.

## 4. The Pagination Trap
`LIMIT 1000000, 10` is slow because MySQL must read 1,000,010 rows and throw away the first million. Use the **Joined-Subquery** method (Q16) to speed this up.
