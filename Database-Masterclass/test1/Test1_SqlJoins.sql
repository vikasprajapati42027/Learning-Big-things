-- Test 1: SQL JOINs Deep Dive
-- Sample tables: employees and departments

CREATE TABLE departments (
    id INT PRIMARY KEY,
    name VARCHAR(50)
);
CREATE TABLE employees (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    dept_id INT,
    salary DECIMAL(10,2)
);

-- Insert test data
INSERT INTO departments VALUES (1,'IT'),(2,'HR'),(3,'Finance');
INSERT INTO employees VALUES
  (1,'Vikas',1,90000),(2,'Rahul',1,75000),
  (3,'Priya',2,60000),(4,'Anita',NULL,55000); -- Anita has NO department

-- INNER JOIN: Only matching rows (Anita excluded — no dept)
SELECT e.name, d.name AS dept
FROM employees e
INNER JOIN departments d ON e.dept_id = d.id;

-- LEFT JOIN: All employees, even without department (Anita shows with NULL dept)
SELECT e.name, d.name AS dept
FROM employees e
LEFT JOIN departments d ON e.dept_id = d.id;

-- RIGHT JOIN: All departments, even empty ones (Finance shows even with no employees)
SELECT e.name, d.name AS dept
FROM employees e
RIGHT JOIN departments d ON e.dept_id = d.id;

-- Self JOIN: Find pairs of employees in the same department
SELECT a.name AS emp1, b.name AS emp2, a.dept_id
FROM employees a
JOIN employees b ON a.dept_id = b.dept_id AND a.id < b.id;
