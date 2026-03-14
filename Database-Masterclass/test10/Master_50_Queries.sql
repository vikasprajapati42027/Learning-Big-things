-- TEST 10: 50 UNIQUE INTERVIEW CHALLENGES
-- 1. SETUP SCHEMA
CREATE TABLE customers (cid INT PRIMARY KEY, cname VARCHAR(50), city VARCHAR(50));
CREATE TABLE products (pid INT PRIMARY KEY, pname VARCHAR(50), price INT, cat VARCHAR(20));
CREATE TABLE orders (oid INT PRIMARY KEY, cid INT, pid INT, qty INT, odate DATE);

-- 2. SAMPLE DATA (10 Rows)
INSERT INTO customers VALUES (1,'Vikas','Mumbai'),(2,'Rahul','Delhi'),(3,'Amit','Mumbai'),(4,'Sonia','Delhi'),(5,'Priya','Bangalore'),(6,'Karan','Bangalore'),(7,'Neha','Pune'),(8,'Raj','Pune'),(9,'Simran','Mumbai'),(10,'Arjun','Chennai');
INSERT INTO products VALUES (1,'Laptop',50000,'ET'),(2,'Mouse',500,'ET'),(3,'Phone',30000,'ET'),(4,'Book',200,'BK'),(5,'Pen',20,'BK'),(6,'Chair',2000,'FR'),(7,'Table',5000,'FR'),(8,'Lamp',1000,'FR'),(9,'Monitor',10000,'ET'),(10,'Keyboard',1500,'ET');
INSERT INTO orders VALUES (101,1,1,1,'2024-01-01'),(102,2,3,1,'2024-01-05'),(103,1,2,2,'2024-01-10'),(104,3,1,1,'2024-02-01'),(105,4,4,5,'2024-02-15'),(106,5,6,1,'2024-03-01'),(107,6,7,1,'2024-03-05'),(108,7,3,1,'2024-03-10'),(109,8,1,1,'2024-03-15'),(110,9,9,1,'2024-03-20');

-- 3. THE 50 UNIQUE QUERIES
-- Q1: Select All
SELECT * FROM products;

-- Q2: Sort Desc
SELECT * FROM products ORDER BY price DESC;

-- Q3: Top 3
SELECT * FROM products ORDER BY price ASC LIMIT 3;

-- Q4: Exact Match
SELECT cname FROM customers WHERE city = 'Mumbai';

-- Q5: Comparison
SELECT pname FROM products WHERE price < 1000;

-- Q6: Wildcard Start
SELECT * FROM products WHERE pname LIKE 'L%';

-- Q7: In Set
SELECT * FROM products WHERE cat IN ('ET', 'BK');

-- Q8: Range Check
SELECT * FROM products WHERE price BETWEEN 1000 AND 10000;

-- Q9: Null Filtering
SELECT * FROM customers WHERE city IS NULL;

-- Q10: Row Counting
SELECT COUNT(*) FROM orders;

-- Q11: Summation
SELECT SUM(price) FROM products;

-- Q12: Averaging
SELECT AVG(price) FROM products;

-- Q13: Find Minimum
SELECT MIN(price) FROM products;

-- Q14: Find Maximum
SELECT MAX(price) FROM products WHERE cat = 'BK';

-- Q15: Basic Grouping
SELECT city, COUNT(*) FROM customers GROUP BY city;

-- Q16: Group Filtering
SELECT city, COUNT(*) FROM customers GROUP BY city HAVING COUNT(*) > 1;

-- Q17: Join Tables
SELECT o.oid, c.cname FROM orders o JOIN customers c ON o.cid = c.cid;

-- Q18: Left Join Nulls
SELECT c.cname, o.oid FROM customers c LEFT JOIN orders o ON c.cid = o.cid WHERE o.oid IS NULL;

-- Q19: Multi Table Join
SELECT p.pname, c.cname FROM products p JOIN orders o ON p.pid = o.pid JOIN customers c ON o.cid = c.cid;

-- Q20: Distinct Cat
SELECT DISTINCT cat FROM products;

-- Q21: String Concat
SELECT CONCAT(cname, ' is from ', city) FROM customers;

-- Q22: Extract Year
SELECT oid, YEAR(odate) FROM orders;

-- Q23: Days Since
SELECT oid, DATEDIFF(NOW(), odate) FROM orders;

-- Q24: Rounding
SELECT pname, ROUND(price * 1.18, 2) as final_price FROM products;

-- Q25: Upper Case
SELECT UPPER(pname) FROM products;

-- Q26: Lowercase
SELECT LOWER(city) FROM customers;

-- Q27: Name Length
SELECT cname, LENGTH(cname) FROM customers;

-- Q28: Safe Nulls
SELECT cname, COALESCE(city, 'Unknown') FROM customers;

-- Q29: Conditional Label
SELECT pname, CASE WHEN price > 5000 THEN 'Premium' ELSE 'Budget' END FROM products;

-- Q30: Search Position
SELECT city, INSTR(city, 'a') FROM customers;

-- Q31: Sub-string
SELECT SUBSTRING(pname, 1, 4) FROM products;

-- Q32: Casting Type
SELECT CAST(price AS CHAR) FROM products;

-- Q33: Scalar Subquery
SELECT pname FROM products WHERE price > (SELECT AVG(price) FROM products);

-- Q34: Subquery In
SELECT cname FROM customers WHERE cid IN (SELECT DISTINCT cid FROM orders);

-- Q35: Not In Subquery
SELECT pname FROM products WHERE pid NOT IN (SELECT DISTINCT pid FROM orders);

-- Q36: Correlated Subquery
SELECT c.cname FROM customers c WHERE (SELECT COUNT(*) FROM orders o WHERE o.cid = c.cid) > 1;

-- Q37: Exists Audit
SELECT * FROM products p WHERE EXISTS (SELECT 1 FROM orders o WHERE o.pid = p.pid);

-- Q38: Union Unique
SELECT city FROM customers UNION SELECT 'Singapore';

-- Q39: Intersect Logic
SELECT cid FROM customers WHERE city='Mumbai' AND cid IN (SELECT cid FROM orders);

-- Q40: Except Logic
SELECT pid FROM products WHERE cat='ET' AND pid NOT IN (SELECT pid FROM orders);

-- Q41: Date Format
SELECT DATE_FORMAT(odate, '%d-%m-%Y') FROM orders;

-- Q42: Add Days
SELECT DATE_ADD(odate, INTERVAL 7 DAY) FROM orders;

-- Q43: Standard Rank
SELECT pname, RANK() OVER(ORDER BY price DESC) as rk FROM products;

-- Q44: Dense Ranking
SELECT pname, DENSE_RANK() OVER(ORDER BY price DESC) as drk FROM products;

-- Q45: Row Sequencing
SELECT cname, city, ROW_NUMBER() OVER(PARTITION BY city ORDER BY cname) as rn FROM customers;

-- Q46: Prev Row Value
SELECT oid, odate, LAG(odate) OVER(ORDER BY odate) as prev FROM orders;

-- Q47: Next Row Value
SELECT oid, odate, LEAD(odate) OVER(ORDER BY odate) as next_val FROM orders;

-- Q48: Running Total
SELECT oid, qty, SUM(qty) OVER(ORDER BY oid) as cum_sum FROM orders;

-- Q49: First of Group
SELECT cid, FIRST_VALUE(oid) OVER(PARTITION BY cid ORDER BY odate) FROM orders;

-- Q50: Last of Group
SELECT cid, LAST_VALUE(oid) OVER(PARTITION BY cid ORDER BY odate ROWS BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING) FROM orders;

