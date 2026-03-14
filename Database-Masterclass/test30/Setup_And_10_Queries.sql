-- ============================================================================
-- DATABASE MASTERCLASS: TEST30 - 50 UNIQUE INTERVIEW QUERIES
-- ============================================================================

-- 1. SCHEMA SETUP
CREATE TABLE customers (cid INT PRIMARY KEY, cname VARCHAR(50), city VARCHAR(50));
CREATE TABLE products (pid INT PRIMARY KEY, pname VARCHAR(50), price INT, cat VARCHAR(20));
CREATE TABLE orders (oid INT PRIMARY KEY, cid INT, pid INT, qty INT, odate DATE);

-- 2. SAMPLE DATA (10 Rows)
INSERT INTO customers VALUES (1,'Vikas','Mumbai'),(2,'Rahul','Delhi'),(3,'Amit','Mumbai'),(4,'Sonia','Delhi'),(5,'Priya','Bangalore'),(6,'Karan','Bangalore'),(7,'Neha','Pune'),(8,'Raj','Pune'),(9,'Simran','Mumbai'),(10,'Arjun','Chennai');
INSERT INTO products VALUES (1,'Laptop',50000,'ET'),(2,'Mouse',500,'ET'),(3,'Phone',30000,'ET'),(4,'Book',200,'BK'),(5,'Pen',20,'BK'),(6,'Chair',2000,'FR'),(7,'Table',5000,'FR'),(8,'Lamp',1000,'FR'),(9,'Monitor',10000,'ET'),(10,'Keyboard',1500,'ET');
INSERT INTO orders VALUES (101,1,1,1,'2024-01-01'),(102,2,3,1,'2024-01-05'),(103,1,2,2,'2024-01-10'),(104,3,1,1,'2024-02-01'),(105,4,4,5,'2024-02-15'),(106,5,6,1,'2024-03-01'),(107,6,7,1,'2024-03-05'),(108,7,3,1,'2024-03-10'),(109,8,1,1,'2024-03-15'),(110,9,9,1,'2024-03-20');

-- 3. 50 UNIQUE QUERIES (NO REPEATS)
-- Q1: Simple Select?
SELECT * FROM products;

-- Q2: Desc Order?
SELECT * FROM products ORDER BY price DESC;

-- Q3: Top 3 Limit?
SELECT * FROM products ORDER BY price LIMIT 3;

-- Q4: Filter Equal?
SELECT cname FROM customers WHERE city = 'Mumbai';

-- Q5: Filter Less Than?
SELECT pname FROM products WHERE price < 1000;

-- Q6: Pattern Match?
SELECT * FROM products WHERE pname LIKE 'L%';

-- Q7: In Clause?
SELECT * FROM products WHERE cat IN ('ET', 'BK');

-- Q8: Between Range?
SELECT * FROM products WHERE price BETWEEN 1000 AND 10000;

-- Q9: Null Check?
SELECT * FROM customers WHERE city IS NULL;

-- Q10: Simple Count?
SELECT COUNT(*) FROM orders;

-- Q11: Sum Column?
SELECT SUM(price) FROM products;

-- Q12: Average Value?
SELECT AVG(price) FROM products;

-- Q13: Min Value?
SELECT MIN(price) FROM products;

-- Q14: Max Value?
SELECT MAX(price) FROM products WHERE cat = 'BK';

-- Q15: Group By Count?
SELECT city, COUNT(*) FROM customers GROUP BY city;

-- Q16: Having Clause?
SELECT city, COUNT(*) FROM customers GROUP BY city HAVING COUNT(*) > 2;

-- Q17: Inner Join?
SELECT o.oid, c.cname FROM orders o JOIN customers c ON o.cid = c.cid;

-- Q18: Left Join?
SELECT c.cname, o.oid FROM customers c LEFT JOIN orders o ON c.cid = o.cid;

-- Q19: Right Join?
SELECT p.pname, o.oid FROM products p RIGHT JOIN orders o ON p.pid = o.pid;

-- Q20: Cross Join?
SELECT DISTINCT p.cat, c.city FROM products p CROSS JOIN customers c;

-- Q21: Self Join?
SELECT a.cname, b.cname, a.city FROM customers a JOIN customers b ON a.city = b.city WHERE a.cid < b.cid;

-- Q22: In Subquery?
SELECT pname FROM products WHERE pid NOT IN (SELECT DISTINCT pid FROM orders);

-- Q23: From Subquery?
SELECT cat, rev FROM (SELECT cat, SUM(price*qty) as rev FROM products p JOIN orders o ON p.pid = o.pid GROUP BY cat) t ORDER BY rev DESC LIMIT 1;

-- Q24: Select Subquery?
SELECT oid, (SELECT cname FROM customers c WHERE c.cid = o.cid) FROM orders o;

-- Q25: Exists Clause?
SELECT cname FROM customers c WHERE EXISTS (SELECT 1 FROM orders o JOIN products p ON o.pid = p.pid WHERE o.cid = c.cid AND p.pname = 'Laptop');

-- Q26: Union?
SELECT city FROM customers UNION SELECT cat FROM products;

-- Q27: Union All?
SELECT city FROM customers UNION ALL SELECT cat FROM products;

-- Q28: Case When?
SELECT pname, CASE WHEN price > 1000 THEN 'Expensive' ELSE 'Cheap' END FROM products;

-- Q29: Coalesce?
SELECT cname, COALESCE(city, 'Roaming') FROM customers;

-- Q30: Distinct Select?
SELECT DISTINCT cat FROM products;

-- Q31: Concat String?
SELECT CONCAT('Hello ', cname, ' from ', city) FROM customers;

-- Q32: Date Year?
SELECT cid, YEAR(odate) FROM orders;

-- Q33: Date Diff?
SELECT oid, DATEDIFF(NOW(), odate) FROM orders;

-- Q34: Numeric Round?
SELECT pname, ROUND(price/75, 2) FROM products;

-- Q35: Numeric Sqrt?
SELECT pname, SQRT(price) FROM products;

-- Q36: String Upper?
SELECT UPPER(cat) FROM products;

-- Q37: String Trim?
SELECT TRIM(cname) FROM customers;

-- Q38: String Replace?
SELECT REPLACE(cname, 'a', '*') FROM customers;

-- Q39: String Length?
SELECT cname FROM customers ORDER BY LENGTH(cname) DESC LIMIT 1;

-- Q40: Pos Search?
SELECT city, INSTR(city, 'u') FROM customers;

-- Q41: Substring?
SELECT SUBSTRING(pname, 1, 3) FROM products;

-- Q42: Casting?
SELECT CAST(price as CHAR) FROM products;

-- Q43: Nested In?
SELECT * FROM orders WHERE pid IN (SELECT pid FROM products WHERE price > 10000);

-- Q44: Rank Analytic?
SELECT pname, RANK() OVER(ORDER BY price DESC) FROM products;

-- Q45: Dense Rank?
SELECT pname, DENSE_RANK() OVER(ORDER BY price DESC) FROM products;

-- Q46: Row Number?
SELECT cname, city, ROW_NUMBER() OVER(PARTITION BY city ORDER BY cname) FROM customers;

-- Q47: Lag Analytic?
SELECT oid, odate, LAG(odate) OVER(PARTITION BY cid ORDER BY odate) FROM orders;

-- Q48: Lead Analytic?
SELECT oid, odate, LEAD(odate) OVER(PARTITION BY cid ORDER BY odate) FROM orders;

-- Q49: First Value?
SELECT cid, FIRST_VALUE(pid) OVER(PARTITION BY cid ORDER BY odate) FROM orders;

-- Q50: Cumulative Sum?
SELECT cid, odate, SUM(qty*100) OVER(PARTITION BY cid ORDER BY odate) as cum_sum FROM orders;

