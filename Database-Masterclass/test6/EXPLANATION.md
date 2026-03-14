# Test 6: Set Operations & Data Transformation

## 1. UNION vs UNION ALL
- **UNION**: Sifts through results to remove duplicates. It's slower because of the extra sorting.
- **UNION ALL**: Fast! It just glues results together. Use this if you know there are no duplicates or if you don't care.

## 2. COALESCE (Q6)
This is a standard Senior Java Dev trick. When your database returns `NULL`, your Java app might throw a `NullPointerException`. By using `COALESCE` in the query, you ensure the database returns a "Default value" (like an empty string or 0) instead of `NULL`.

## 3. String Aggregation (Q7)
`GROUP_CONCAT` is powerful for reporting. Instead of 10 rows for "User - Order", you get 1 row with "User - Order1, Order2, Order3". 
