-- Test 3: Indexes — Making Queries 100x Faster

-- Without index: MySQL scans ALL rows (Full Table Scan) — slow for 10M rows
SELECT * FROM employees WHERE email = 'vikas@email.com';

-- Create an index on email column
CREATE INDEX idx_employees_email ON employees(email);

-- Now MySQL jumps directly to the row (Index Seek) — lightning fast!
SELECT * FROM employees WHERE email = 'vikas@email.com';

-- Composite (Multi-column) Index
-- Useful when you always filter by both columns together
CREATE INDEX idx_dept_salary ON employees(dept_id, salary);

-- This query USES the index (dept_id is first in the index)
SELECT * FROM employees WHERE dept_id = 1 AND salary > 50000;

-- This query does NOT use the index (salary first skips dept_id)
-- SELECT * FROM employees WHERE salary > 50000; -- Full scan!

-- EXPLAIN: See if your query uses an index
EXPLAIN SELECT * FROM employees WHERE email = 'vikas@email.com';
-- Look for: "type: ref" (index used) vs "type: ALL" (full table scan = BAD)

-- When NOT to create indexes:
-- 1. Small tables (< 1000 rows) — overhead not worth it
-- 2. Columns that change very frequently — index must be rebuilt on every change
-- 3. Low cardinality columns — e.g., "gender" with only M/F (index barely helps)
