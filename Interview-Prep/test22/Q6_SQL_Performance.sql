-- Q6_SQL_Performance.sql: Force join order to keep optimizer from choosing skewed plan.
SELECT /*+ LEADING(c o) USE_NL(o) */ o.id, c.name
FROM customers c
JOIN orders o ON o.customer_id = c.id
WHERE c.country = 'US';
