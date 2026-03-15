-- Q5_SQL_Performance.sql: Covering index for date-heavy reporting.
CREATE INDEX idx_orders_customer_date ON orders(customer_id, order_date)
INCLUDE (total_amount);
