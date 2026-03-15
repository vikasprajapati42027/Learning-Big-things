-- Q8_SQL_Performance.sql: Limit result set for dashboards.
SELECT id, name, total_revenue
FROM revenue_snapshot
ORDER BY snapshot_date DESC
LIMIT 50;
