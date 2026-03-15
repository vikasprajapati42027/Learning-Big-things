-- Q10_SQL_Performance.sql: Performance checklist + final tuning command.
SET enable_seqscan = off;
EXPLAIN ANALYZE SELECT * FROM analytics WHERE customer_id = 5;
-- Reset planner settings afterward.
SET enable_seqscan = on;
