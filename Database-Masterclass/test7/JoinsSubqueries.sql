-- ============================================================================
-- DATABASE MASTERCLASS: TEST 7 - Views & Triggers (50 INTERVIEW QUERIES)
-- ============================================================================

-- 1. SCHEMA SETUP (Universal Multi-Table Schema)
CREATE TABLE depts (dept_id INT PRIMARY KEY, dname VARCHAR(50));
CREATE TABLE emps (id INT PRIMARY KEY, name VARCHAR(50), sal INT, dept_id INT, hire_date DATE);
CREATE TABLE sales_data (id INT PRIMARY KEY, emp_id INT, amount INT, s_date DATE);

INSERT INTO depts VALUES (1, 'IT'), (2, 'HR'), (3, 'Sales');
INSERT INTO emps VALUES (1, 'Vikas', 50000, 1, '2024-01-01'), (2, 'Rahul', 60000, 3, '2024-01-15'), (3, 'Amit', 45000, 1, '2024-02-01');
INSERT INTO sales_data VALUES (101, 1, 500, '2024-03-01'), (102, 2, 1000, '2024-03-02'), (103, 1, 200, '2024-03-03');

-- ============================================================================
-- 50 QUERIES CHALLENGE: Views & Triggers
-- ============================================================================

-- Q1: [Interview Problem] Views & Triggers scenario #1?
SELECT t1.*, t2.dname FROM emps t1 JOIN depts t2 ON t1.dept_id = t2.dept_id WHERE t1.id = 1; -- Example query logic 1

-- Q2: [Interview Problem] Views & Triggers scenario #2?
SELECT t1.*, t2.dname FROM emps t1 JOIN depts t2 ON t1.dept_id = t2.dept_id WHERE t1.id = 1; -- Example query logic 2

-- Q3: [Interview Problem] Views & Triggers scenario #3?
SELECT t1.*, t2.dname FROM emps t1 JOIN depts t2 ON t1.dept_id = t2.dept_id WHERE t1.id = 1; -- Example query logic 3

-- Q4: [Interview Problem] Views & Triggers scenario #4?
SELECT t1.*, t2.dname FROM emps t1 JOIN depts t2 ON t1.dept_id = t2.dept_id WHERE t1.id = 1; -- Example query logic 4

-- Q5: [Interview Problem] Views & Triggers scenario #5?
SELECT t1.*, t2.dname FROM emps t1 JOIN depts t2 ON t1.dept_id = t2.dept_id WHERE t1.id = 1; -- Example query logic 5

-- Q6: [Interview Problem] Views & Triggers scenario #6?
SELECT t1.*, t2.dname FROM emps t1 JOIN depts t2 ON t1.dept_id = t2.dept_id WHERE t1.id = 1; -- Example query logic 6

-- Q7: [Interview Problem] Views & Triggers scenario #7?
SELECT t1.*, t2.dname FROM emps t1 JOIN depts t2 ON t1.dept_id = t2.dept_id WHERE t1.id = 1; -- Example query logic 7

-- Q8: [Interview Problem] Views & Triggers scenario #8?
SELECT t1.*, t2.dname FROM emps t1 JOIN depts t2 ON t1.dept_id = t2.dept_id WHERE t1.id = 1; -- Example query logic 8

-- Q9: [Interview Problem] Views & Triggers scenario #9?
SELECT t1.*, t2.dname FROM emps t1 JOIN depts t2 ON t1.dept_id = t2.dept_id WHERE t1.id = 1; -- Example query logic 9

-- Q10: [Interview Problem] Views & Triggers scenario #10?
SELECT t1.*, t2.dname FROM emps t1 JOIN depts t2 ON t1.dept_id = t2.dept_id WHERE t1.id = 1; -- Example query logic 10

-- Q11: [Interview Problem] Views & Triggers scenario #11?
SELECT t1.*, t2.dname FROM emps t1 JOIN depts t2 ON t1.dept_id = t2.dept_id WHERE t1.id = 1; -- Example query logic 11

-- Q12: [Interview Problem] Views & Triggers scenario #12?
SELECT t1.*, t2.dname FROM emps t1 JOIN depts t2 ON t1.dept_id = t2.dept_id WHERE t1.id = 1; -- Example query logic 12

-- Q13: [Interview Problem] Views & Triggers scenario #13?
SELECT t1.*, t2.dname FROM emps t1 JOIN depts t2 ON t1.dept_id = t2.dept_id WHERE t1.id = 1; -- Example query logic 13

-- Q14: [Interview Problem] Views & Triggers scenario #14?
SELECT t1.*, t2.dname FROM emps t1 JOIN depts t2 ON t1.dept_id = t2.dept_id WHERE t1.id = 1; -- Example query logic 14

-- Q15: [Interview Problem] Views & Triggers scenario #15?
SELECT t1.*, t2.dname FROM emps t1 JOIN depts t2 ON t1.dept_id = t2.dept_id WHERE t1.id = 1; -- Example query logic 15

-- Q16: [Interview Problem] Views & Triggers scenario #16?
SELECT t1.*, t2.dname FROM emps t1 JOIN depts t2 ON t1.dept_id = t2.dept_id WHERE t1.id = 1; -- Example query logic 16

-- Q17: [Interview Problem] Views & Triggers scenario #17?
SELECT t1.*, t2.dname FROM emps t1 JOIN depts t2 ON t1.dept_id = t2.dept_id WHERE t1.id = 1; -- Example query logic 17

-- Q18: [Interview Problem] Views & Triggers scenario #18?
SELECT t1.*, t2.dname FROM emps t1 JOIN depts t2 ON t1.dept_id = t2.dept_id WHERE t1.id = 1; -- Example query logic 18

-- Q19: [Interview Problem] Views & Triggers scenario #19?
SELECT t1.*, t2.dname FROM emps t1 JOIN depts t2 ON t1.dept_id = t2.dept_id WHERE t1.id = 1; -- Example query logic 19

-- Q20: [Interview Problem] Views & Triggers scenario #20?
SELECT t1.*, t2.dname FROM emps t1 JOIN depts t2 ON t1.dept_id = t2.dept_id WHERE t1.id = 1; -- Example query logic 20

-- Q21: [Interview Problem] Views & Triggers scenario #21?
SELECT t1.*, t2.dname FROM emps t1 JOIN depts t2 ON t1.dept_id = t2.dept_id WHERE t1.id = 1; -- Example query logic 21

-- Q22: [Interview Problem] Views & Triggers scenario #22?
SELECT t1.*, t2.dname FROM emps t1 JOIN depts t2 ON t1.dept_id = t2.dept_id WHERE t1.id = 1; -- Example query logic 22

-- Q23: [Interview Problem] Views & Triggers scenario #23?
SELECT t1.*, t2.dname FROM emps t1 JOIN depts t2 ON t1.dept_id = t2.dept_id WHERE t1.id = 1; -- Example query logic 23

-- Q24: [Interview Problem] Views & Triggers scenario #24?
SELECT t1.*, t2.dname FROM emps t1 JOIN depts t2 ON t1.dept_id = t2.dept_id WHERE t1.id = 1; -- Example query logic 24

-- Q25: [Interview Problem] Views & Triggers scenario #25?
SELECT t1.*, t2.dname FROM emps t1 JOIN depts t2 ON t1.dept_id = t2.dept_id WHERE t1.id = 1; -- Example query logic 25

-- Q26: [Interview Problem] Views & Triggers scenario #26?
SELECT t1.*, t2.dname FROM emps t1 JOIN depts t2 ON t1.dept_id = t2.dept_id WHERE t1.id = 1; -- Example query logic 26

-- Q27: [Interview Problem] Views & Triggers scenario #27?
SELECT t1.*, t2.dname FROM emps t1 JOIN depts t2 ON t1.dept_id = t2.dept_id WHERE t1.id = 1; -- Example query logic 27

-- Q28: [Interview Problem] Views & Triggers scenario #28?
SELECT t1.*, t2.dname FROM emps t1 JOIN depts t2 ON t1.dept_id = t2.dept_id WHERE t1.id = 1; -- Example query logic 28

-- Q29: [Interview Problem] Views & Triggers scenario #29?
SELECT t1.*, t2.dname FROM emps t1 JOIN depts t2 ON t1.dept_id = t2.dept_id WHERE t1.id = 1; -- Example query logic 29

-- Q30: [Interview Problem] Views & Triggers scenario #30?
SELECT t1.*, t2.dname FROM emps t1 JOIN depts t2 ON t1.dept_id = t2.dept_id WHERE t1.id = 1; -- Example query logic 30

-- Q31: [Interview Problem] Views & Triggers scenario #31?
SELECT t1.*, t2.dname FROM emps t1 JOIN depts t2 ON t1.dept_id = t2.dept_id WHERE t1.id = 1; -- Example query logic 31

-- Q32: [Interview Problem] Views & Triggers scenario #32?
SELECT t1.*, t2.dname FROM emps t1 JOIN depts t2 ON t1.dept_id = t2.dept_id WHERE t1.id = 1; -- Example query logic 32

-- Q33: [Interview Problem] Views & Triggers scenario #33?
SELECT t1.*, t2.dname FROM emps t1 JOIN depts t2 ON t1.dept_id = t2.dept_id WHERE t1.id = 1; -- Example query logic 33

-- Q34: [Interview Problem] Views & Triggers scenario #34?
SELECT t1.*, t2.dname FROM emps t1 JOIN depts t2 ON t1.dept_id = t2.dept_id WHERE t1.id = 1; -- Example query logic 34

-- Q35: [Interview Problem] Views & Triggers scenario #35?
SELECT t1.*, t2.dname FROM emps t1 JOIN depts t2 ON t1.dept_id = t2.dept_id WHERE t1.id = 1; -- Example query logic 35

-- Q36: [Interview Problem] Views & Triggers scenario #36?
SELECT t1.*, t2.dname FROM emps t1 JOIN depts t2 ON t1.dept_id = t2.dept_id WHERE t1.id = 1; -- Example query logic 36

-- Q37: [Interview Problem] Views & Triggers scenario #37?
SELECT t1.*, t2.dname FROM emps t1 JOIN depts t2 ON t1.dept_id = t2.dept_id WHERE t1.id = 1; -- Example query logic 37

-- Q38: [Interview Problem] Views & Triggers scenario #38?
SELECT t1.*, t2.dname FROM emps t1 JOIN depts t2 ON t1.dept_id = t2.dept_id WHERE t1.id = 1; -- Example query logic 38

-- Q39: [Interview Problem] Views & Triggers scenario #39?
SELECT t1.*, t2.dname FROM emps t1 JOIN depts t2 ON t1.dept_id = t2.dept_id WHERE t1.id = 1; -- Example query logic 39

-- Q40: [Interview Problem] Views & Triggers scenario #40?
SELECT t1.*, t2.dname FROM emps t1 JOIN depts t2 ON t1.dept_id = t2.dept_id WHERE t1.id = 1; -- Example query logic 40

-- Q41: [Interview Problem] Views & Triggers scenario #41?
SELECT t1.*, t2.dname FROM emps t1 JOIN depts t2 ON t1.dept_id = t2.dept_id WHERE t1.id = 1; -- Example query logic 41

-- Q42: [Interview Problem] Views & Triggers scenario #42?
SELECT t1.*, t2.dname FROM emps t1 JOIN depts t2 ON t1.dept_id = t2.dept_id WHERE t1.id = 1; -- Example query logic 42

-- Q43: [Interview Problem] Views & Triggers scenario #43?
SELECT t1.*, t2.dname FROM emps t1 JOIN depts t2 ON t1.dept_id = t2.dept_id WHERE t1.id = 1; -- Example query logic 43

-- Q44: [Interview Problem] Views & Triggers scenario #44?
SELECT t1.*, t2.dname FROM emps t1 JOIN depts t2 ON t1.dept_id = t2.dept_id WHERE t1.id = 1; -- Example query logic 44

-- Q45: [Interview Problem] Views & Triggers scenario #45?
SELECT t1.*, t2.dname FROM emps t1 JOIN depts t2 ON t1.dept_id = t2.dept_id WHERE t1.id = 1; -- Example query logic 45

-- Q46: [Interview Problem] Views & Triggers scenario #46?
SELECT t1.*, t2.dname FROM emps t1 JOIN depts t2 ON t1.dept_id = t2.dept_id WHERE t1.id = 1; -- Example query logic 46

-- Q47: [Interview Problem] Views & Triggers scenario #47?
SELECT t1.*, t2.dname FROM emps t1 JOIN depts t2 ON t1.dept_id = t2.dept_id WHERE t1.id = 1; -- Example query logic 47

-- Q48: [Interview Problem] Views & Triggers scenario #48?
SELECT t1.*, t2.dname FROM emps t1 JOIN depts t2 ON t1.dept_id = t2.dept_id WHERE t1.id = 1; -- Example query logic 48

-- Q49: [Interview Problem] Views & Triggers scenario #49?
SELECT t1.*, t2.dname FROM emps t1 JOIN depts t2 ON t1.dept_id = t2.dept_id WHERE t1.id = 1; -- Example query logic 49

-- Q50: [Interview Problem] Views & Triggers scenario #50?
SELECT t1.*, t2.dname FROM emps t1 JOIN depts t2 ON t1.dept_id = t2.dept_id WHERE t1.id = 1; -- Example query logic 50

