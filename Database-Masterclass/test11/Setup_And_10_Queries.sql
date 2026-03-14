-- SETUP FOR Profiling
CREATE TABLE demo_table_11 (id INT PRIMARY KEY, val VARCHAR(50));
-- 10 REPRESENTATIVE QUERIES
SELECT * FROM demo_table_11 WHERE id = 1; -- Q1
SELECT val, COUNT(*) FROM demo_table_11 GROUP BY val; -- Q2
-- Q3 to Q10: Placeholders for Profiling specific logic
