-- Q3_SQL_Performance.sql: Tune parameter sniffing with OPTIMIZE FOR UNKNOWN (SQL Server example).
DECLARE @customerId INT = 5;
OPTION (OPTIMIZE FOR (@customerId UNKNOWN))
SELECT * FROM orders WHERE customer_id = @customerId;
