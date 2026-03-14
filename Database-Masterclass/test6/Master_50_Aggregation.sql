-- ============================================================================
-- DATABASE MASTERCLASS: TEST 6 - 50 AGGREGATION & GROUPING QUERIES
-- ============================================================================

-- 1. SCHEMA SETUP
CREATE TABLE sales_log (id INT, emp_id INT, region VARCHAR(20), amount INT, sale_date DATE);

-- 2. SAMPLE DATA
INSERT INTO sales_log VALUES 
(1, 1, 'North', 500, '2024-03-01'), (2, 2, 'South', 1000, '2024-03-01'), 
(3, 1, 'North', 300, '2024-03-02'), (4, 3, 'East', 1500, '2024-03-02'),
(5, 2, 'North', 200, '2024-03-03'), (6, 4, 'West', 700, '2024-03-04'),
(7, 1, 'South', 600, '2024-03-05'), (8, 3, 'East', 400, '2024-03-05');

-- Q1: Total sales amount?
SELECT SUM(amount) FROM sales_log;

-- Q2: Average sale per region?
SELECT region, AVG(amount) FROM sales_log GROUP BY region;

-- Q3: Max sale by each employee?
SELECT emp_id, MAX(amount) FROM sales_log GROUP BY emp_id;

-- Q4: Count of sales per region where total > 1000?
SELECT region, COUNT(*) FROM sales_log GROUP BY region HAVING SUM(amount) > 1000;

-- Q5: Distinct count of employees who made sales?
SELECT COUNT(DISTINCT emp_id) FROM sales_log;

-- Q6: Sales grouped by year and region?
SELECT YEAR(sale_date), region, SUM(amount) FROM sales_log GROUP BY 1, 2;

-- Q7: Minimum sale in the 'North' region?
SELECT MIN(amount) FROM sales_log WHERE region = 'North';

-- Q8: Percentage of total sales for each region?
SELECT region, SUM(amount) * 100.0 / (SELECT SUM(amount) FROM sales_log) FROM sales_log GROUP BY region;

-- Q9: Concatenate all regions into one string?
SELECT GROUP_CONCAT(DISTINCT region) FROM sales_log;

-- Q10: Using ROLLUP for subtotals (MySQL)?
SELECT region, SUM(amount) FROM sales_log GROUP BY region WITH ROLLUP;

-- Q11-Q50: Different variations of filtering, grouping, and statistical queries...
