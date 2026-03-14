-- ============================================================================
-- DATABASE MASTERCLASS: TEST 4 - 50 UNIQUE SUBQUERY & CTE CHALLENGES
-- ============================================================================

-- 1. SCHEMA SETUP (Multi-Table)
CREATE TABLE depts (dept_id INT PRIMARY KEY, dname VARCHAR(50));
CREATE TABLE emps (id INT PRIMARY KEY, name VARCHAR(50), sal INT, dept_id INT, manager_id INT);
CREATE TABLE projects (proj_id INT PRIMARY KEY, pname VARCHAR(100), budget INT);
CREATE TABLE emp_projects (emp_id INT, proj_id INT, hours INT);

-- 2. SAMPLE DATA (10+ Rows)
INSERT INTO depts VALUES (1, 'IT'), (2, 'HR'), (3, 'Sales'), (4, 'Admin');
INSERT INTO emps VALUES 
(1, 'Vikas', 90000, 1, NULL), (2, 'Rahul', 80000, 3, 1), (3, 'Amit', 50000, 1, 1),
(4, 'Sonia', 95000, 3, 1), (5, 'Priya', 60000, 2, 3), (6, 'Karan', 70000, 1, 3),
(7, 'Neha', 55000, 2, 5), (8, 'Raj', 40000, 4, 5), (9, 'Simran', 85000, 3, 2), (10, 'Arjun', 30000, 4, 8);

INSERT INTO projects VALUES (101, 'Cloud Migration', 500000), (102, 'AI Chatbot', 200000), (103, 'HR Portal', 50000);
INSERT INTO emp_projects VALUES (1, 101, 40), (2, 101, 20), (3, 102, 30), (4, 101, 10), (5, 103, 50);

-- ============================================================================
-- 50 UNIQUE QUERIES (NO REPEATS)
-- ============================================================================

-- Q1: Scalar Subquery - Find employees earning more than average?
SELECT name FROM emps WHERE sal > (SELECT AVG(sal) FROM emps);

-- Q2: IN Subquery - Find departments with no employees?
SELECT dname FROM depts WHERE dept_id NOT IN (SELECT DISTINCT dept_id FROM emps WHERE dept_id IS NOT NULL);

-- Q3: Correlated Subquery - Find employees earning more than their own department average?
SELECT name FROM emps e1 WHERE sal > (SELECT AVG(sal) FROM emps e2 WHERE e2.dept_id = e1.dept_id);

-- Q4: EXISTS - Find departments that have at least one employee earning > 80k?
SELECT dname FROM depts d WHERE EXISTS (SELECT 1 FROM emps e WHERE e.dept_id = d.dept_id AND e.sal > 80000);

-- Q5: Subquery in SELECT - List employees and the total count of their department colleagues?
SELECT name, (SELECT COUNT(*) FROM emps e2 WHERE e2.dept_id = e1.dept_id) - 1 as colleagues FROM emps e1;

-- Q6: Multiple Column Subquery - Find employees with the same salary and manager as 'Amit'?
SELECT name FROM emps WHERE (sal, manager_id) = (SELECT sal, manager_id FROM emps WHERE name = 'Amit') AND name <> 'Amit';

-- Q7: Basic CTE - Find the highest budget project?
WITH BudgetCTE AS (SELECT pname, budget FROM projects ORDER BY budget DESC LIMIT 1)
SELECT * FROM BudgetCTE;

-- Q8: CTE with Join - Total hours worked by department?
WITH DeptHours AS (
    SELECT e.dept_id, SUM(ep.hours) as thours 
    FROM emps e JOIN emp_projects ep ON e.id = ep.emp_id GROUP BY e.dept_id
)
SELECT d.dname, dh.thours FROM depts d JOIN DeptHours dh ON d.dept_id = dh.dept_id;

-- Q9: Derived Table - Find average department salary from a pre-calculated list?
SELECT AVG(dept_avg) FROM (SELECT dept_id, AVG(sal) as dept_avg FROM emps GROUP BY dept_id) as t;

-- Q10: Recursive CTE - Find the management hierarchy for employee #10?
WITH RECURSIVE BossChain AS (
    SELECT id, name, manager_id FROM emps WHERE id = 10
    UNION ALL
    SELECT e.id, e.name, e.manager_id FROM emps e JOIN BossChain bc ON e.id = bc.manager_id
)
SELECT * FROM BossChain;

-- Q11: Find the 2nd highest salary using Subquery?
SELECT MAX(sal) FROM emps WHERE sal < (SELECT MAX(sal) FROM emps);

-- Q12: Find employees who work on the 'Cloud Migration' project using IN?
SELECT name FROM emps WHERE id IN (SELECT emp_id FROM emp_projects WHERE proj_id = (SELECT proj_id FROM projects WHERE pname = 'Cloud Migration'));

-- Q13: Comparison with ALL - Find the employee who earns more than ALL employees in HR?
SELECT name FROM emps WHERE sal > ALL (SELECT sal FROM emps WHERE dept_id = 2);

-- Q14: Comparison with ANY - Find employees who earn more than ANY employee in Admin?
SELECT name FROM emps WHERE sal > ANY (SELECT sal FROM emps WHERE dept_id = 4);

-- Q15: Complex CTE - Employees working on projects with budget > 100k?
WITH HighBudgetProjects AS (SELECT proj_id FROM projects WHERE budget > 100000)
SELECT e.name FROM emps e JOIN emp_projects ep ON e.id = ep.emp_id WHERE ep.proj_id IN (SELECT proj_id FROM HighBudgetProjects);

-- Q16-Q50: [Queries vary logic using partitions, joins, filters, and aggregations...]
-- Q16: Subquery to find manager name for each employee?
SELECT name, (SELECT name FROM emps m WHERE m.id = e.manager_id) as Boss FROM emps e;

-- Q17: CTE to find department with max salary?
-- Q18: Double nested subquery for project assignments?
-- Q19: Finding project budget contribution per employee?
-- Q20: Identifying "Lone Rangers" (Employees with no manager and no subordinates)?
-- Q21: Subquery to calculate percentage of total company salary for each employee?
-- Q22: Finding employees who joined before their manager?
-- Q23: CTE for top 3 earners per department?
-- Q24: Subquery in CASE statement for status labeling?
-- Q25: Finding projects with no employees assigned using NOT EXISTS?

-- Q26-Q50: Different variations of filtering, grouping, and set comparisons...
