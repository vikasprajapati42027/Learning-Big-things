-- SETUP FOR Bulk Loading
CREATE TABLE demo_table_13 (id INT PRIMARY KEY, val VARCHAR(50));
-- 10 REPRESENTATIVE QUERIES
SELECT * FROM demo_table_13 WHERE id = 1; -- Q1
SELECT val, COUNT(*) FROM demo_table_13 GROUP BY val; -- Q2
-- Q3 to Q10: Placeholders for Bulk Loading specific logic
