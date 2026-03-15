-- Q2_SQL_Performance.sql: Compare execution plan between sequential and indexed scans.
EXPLAIN ANALYZE
SELECT product_id, SUM(quantity) AS total
FROM order_items
WHERE product_id = 42
GROUP BY product_id;
