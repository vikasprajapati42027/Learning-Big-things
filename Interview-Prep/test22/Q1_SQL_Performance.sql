-- Q1_SQL_Performance.sql: Choose an index to speed up frequent lookups.
SELECT id, customer_id, order_date
FROM orders
WHERE customer_id = 123 AND status = 'completed'
ORDER BY order_date DESC;
