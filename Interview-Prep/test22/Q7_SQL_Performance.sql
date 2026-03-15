-- Q7_SQL_Performance.sql: Bulk insert via staging table.
CREATE TABLE temp_orders AS SELECT * FROM orders WHERE 1=0;
INSERT INTO temp_orders SELECT * FROM new_orders_batch;
INSERT INTO orders SELECT * FROM temp_orders;
