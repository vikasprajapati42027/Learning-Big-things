# Test 3: Database Indexing Strategy

## 1. Why do we need Indexes?
Imagine a 1,000-page book. If you want to find "Chapter 7", you can either:
1. Scan every page (Full Table Scan).
2. Look at the **Index** at the back (Index Seek).

## 2. Types of Indexes
- **Single Index**: Fast for searching one column.
- **Composite Index (Q4)**: Fast for searching two columns at once. **Rule**: The leftmost column in the index must be used in the `WHERE` clause for the index to work.
- **Fulltext Index (Q7)**: Standard `LIKE %xxx%` is slow. Fulltext is 100x faster for searching words in paragraphs.

## 3. The Performance Trade-off
Indexes make **READS** fast, but they make **WRITES** slow! 
Every time you `INSERT` a row, the database must also update the Index. Don't index every column! Only index columns used in `WHERE`, `JOIN`, or `ORDER BY`.
