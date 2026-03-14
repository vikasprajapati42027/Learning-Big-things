-- ==========================================
-- 1. SETUP: Performance Tracking Table
-- ==========================================

CREATE TABLE sales_stats (
    employee_name VARCHAR(50),
    department VARCHAR(50),
    revenue INT,
    sale_date DATE
);

INSERT INTO sales_stats VALUES 
('Vikas', 'IT', 5000, '2024-01-01'),
('Rahul', 'IT', 7000, '2024-01-02'),
('Amit', 'Sales', 3000, '2024-01-01'),
('Sonia', 'Sales', 9000, '2024-01-02'),
('Vikas', 'IT', 2000, '2024-01-05');

-- ==========================================
-- 2. THE 10 WINDOW FUNCTION QUERIES
-- ==========================================

-- Q1: ROW_NUMBER (Unique number for every row)
SELECT employee_name, revenue, ROW_NUMBER() OVER (ORDER BY revenue DESC) as rank_num FROM sales_stats;

-- Q2: RANK (Gives same rank for ties, but skips the next number)
SELECT employee_name, revenue, RANK() OVER (ORDER BY revenue DESC) as rnk FROM sales_stats;

-- Q3: DENSE_RANK (Same as rank, but does NOT skip numbers)
SELECT employee_name, revenue, DENSE_RANK() OVER (ORDER BY revenue DESC) as drnk FROM sales_stats;

-- Q4: PARTITION BY (Rank employees WITHIN their own department)
SELECT department, employee_name, revenue, RANK() OVER (PARTITION BY department ORDER BY revenue DESC) FROM sales_stats;

-- Q5: LEAD (Look at the NEXT row's revenue)
SELECT employee_name, revenue, LEAD(revenue) OVER (ORDER BY sale_date) as next_sale FROM sales_stats;

-- Q6: LAG (Look at the PREVIOUS row's revenue - Great for growth calculation)
SELECT employee_name, revenue, LAG(revenue) OVER (ORDER BY sale_date) as prev_sale FROM sales_stats;

-- Q7: Running Total (SUM OVER without partition)
SELECT employee_name, revenue, SUM(revenue) OVER (ORDER BY sale_date) as running_total FROM sales_stats;

-- Q8: Department Total vs Individual (Compare me against my team total)
SELECT employee_name, department, revenue, SUM(revenue) OVER (PARTITION BY department) as dept_total FROM sales_stats;

-- Q9: Percentage Contribution to Dept
SELECT employee_name, revenue, (revenue * 100.0 / SUM(revenue) OVER (PARTITION BY department)) as percent_of_dept FROM sales_stats;

-- Q10: NTILE (Divide data into 4 quartiles - useful for "Top 25% performers")
SELECT employee_name, revenue, NTILE(4) OVER (ORDER BY revenue DESC) as quartile FROM sales_stats;
