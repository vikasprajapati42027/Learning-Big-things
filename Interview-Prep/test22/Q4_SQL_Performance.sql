-- Q4_SQL_Performance.sql: Use shard key filter to hit single partition.
SELECT id, user_id, activity
FROM user_activity
WHERE region = 'us-east-1'
AND activity_date BETWEEN '2025-01-01' AND '2025-01-31';
