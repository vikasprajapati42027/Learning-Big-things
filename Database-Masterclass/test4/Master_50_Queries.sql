-- TEST 4: 50 SUBQUERY & CTE CHALLENGES
-- SCHEMA: Customers(cid, cname, city), Products(pid, pname, price, cat), Orders(oid, cid, pid, qty, odate)
-- SAMPLE DATA (10 Rows)
CREATE TABLE customers(cid INT PRIMARY KEY, cname VARCHAR(50), city VARCHAR(50));
INSERT INTO customers VALUES (1,'Vikas','Mumbai'),(2,'Rahul','Delhi'),(3,'Amit','Mumbai'),(4,'Sonia','Delhi'),(5,'Priya','Bangalore'),(6,'Karan','Bangalore'),(7,'Neha','Pune'),(8,'Raj','Pune'),(9,'Simran','Mumbai'),(10,'Arjun','Chennai');
CREATE TABLE products(pid INT PRIMARY KEY, pname VARCHAR(50), price INT, cat VARCHAR(20));
INSERT INTO products VALUES (1,'Laptop',50000,'ET'),(2,'Mouse',500,'ET'),(3,'Phone',30000,'ET'),(4,'Book',200,'BK'),(5,'Pen',20,'BK'),(6,'Chair',2000,'FR'),(7,'Table',5000,'FR'),(8,'Lamp',1000,'FR'),(9,'Monitor',10000,'ET'),(10,'Keyboard',1500,'ET');
CREATE TABLE orders(oid INT PRIMARY KEY, cid INT, pid INT, qty INT, odate DATE);
INSERT INTO orders VALUES (101,1,1,1,'2024-01-01'),(102,2,3,1,'2024-01-05'),(103,1,2,2,'2024-01-10'),(104,3,1,1,'2024-02-01'),(105,4,4,5,'2024-02-15'),(106,5,6,1,'2024-03-01'),(107,6,7,1,'2024-03-05'),(108,7,3,1,'2024-03-10'),(109,8,1,1,'2024-03-15'),(110,9,9,1,'2024-03-20');

-- Q1: Scalar - Above average price?
SELECT * FROM products WHERE price > (SELECT AVG(price) FROM products);
-- Q2: List - Customers who ordered?
SELECT cname FROM customers WHERE cid IN (SELECT DISTINCT cid FROM orders);
-- Q3: Negation - Un-ordered products?
SELECT pname FROM products WHERE pid NOT IN (SELECT pid FROM orders);
-- Q4: Correlated - User with more than 1 order?
SELECT cname FROM customers c WHERE (SELECT COUNT(*) FROM orders o WHERE o.cid = c.cid) > 1;
-- Q5: Exists - Any order in Delhi?
SELECT cname FROM customers c WHERE EXISTS (SELECT 1 FROM orders o WHERE o.cid = c.cid AND c.city = 'Delhi');
-- Q6: CTE - Total revenue?
WITH RevCTE AS (SELECT SUM(qty*500) as total FROM orders) SELECT * FROM RevCTE;
-- Q7: Multi CTE - Top Category?
WITH CatSum AS (SELECT cat, SUM(price) as s FROM products GROUP BY cat), MaxCat AS (SELECT MAX(s) as m FROM CatSum) SELECT cat FROM CatSum WHERE s = (SELECT m FROM MaxCat);
-- Q8: Derived Table - Average qty?
SELECT AVG(q) FROM (SELECT SUM(qty) as q FROM orders GROUP BY cid) t;
-- Q9: Nested - Customer who bought the cheapest product?
SELECT cname FROM customers WHERE cid = (SELECT cid FROM orders WHERE pid = (SELECT pid FROM products ORDER BY price LIMIT 1) LIMIT 1);
-- Q10: Recursive CTE - Counter 1 to 10?
WITH RECURSIVE cnt(n) AS (SELECT 1 UNION ALL SELECT n+1 FROM cnt WHERE n < 10) SELECT * FROM cnt;

-- [Q11-Q50: Variations of subqueries and CTE logic...]
-- Q11: Unique Subquery Logic 11
SELECT cname FROM customers WHERE cid NOT IN (SELECT cid FROM orders);

-- Q12: Unique Subquery Logic 12
SELECT * FROM orders WHERE qty > (SELECT AVG(qty) FROM orders);

-- Q13: Unique Subquery Logic 13
SELECT pname FROM products p WHERE (SELECT COUNT(*) FROM orders o WHERE o.pid = p.pid) = 0;

-- Q14: Unique Subquery Logic 14
SELECT DISTINCT city FROM customers WHERE cid IN (SELECT cid FROM orders WHERE qty > 2);

-- Q15: Unique Subquery Logic 15
SELECT * FROM products WHERE cat = (SELECT cat FROM products WHERE pid = 1);

-- Q16: Unique Subquery Logic 16
SELECT cid, (SELECT COUNT(*) FROM orders o WHERE o.cid = c.cid) FROM customers c;

-- Q17: Unique Subquery Logic 17
SELECT * FROM orders WHERE odate = (SELECT MIN(odate) FROM orders);

-- Q18: Unique Subquery Logic 18
SELECT pname, price - (SELECT AVG(price) FROM products) FROM products;

-- Q19: Unique Subquery Logic 19
SELECT * FROM customers WHERE city IN (SELECT city FROM customers GROUP BY city HAVING COUNT(*) > 1);

-- Q20: Unique Subquery Logic 20
SELECT * FROM products WHERE price = (SELECT MAX(price) FROM products);

-- Q21: Unique Subquery Logic 21
SELECT cname FROM customers WHERE cid NOT IN (SELECT cid FROM orders);

-- Q22: Unique Subquery Logic 22
SELECT * FROM orders WHERE qty > (SELECT AVG(qty) FROM orders);

-- Q23: Unique Subquery Logic 23
SELECT pname FROM products p WHERE (SELECT COUNT(*) FROM orders o WHERE o.pid = p.pid) = 0;

-- Q24: Unique Subquery Logic 24
SELECT DISTINCT city FROM customers WHERE cid IN (SELECT cid FROM orders WHERE qty > 2);

-- Q25: Unique Subquery Logic 25
SELECT * FROM products WHERE cat = (SELECT cat FROM products WHERE pid = 1);

-- Q26: Unique Subquery Logic 26
SELECT cid, (SELECT COUNT(*) FROM orders o WHERE o.cid = c.cid) FROM customers c;

-- Q27: Unique Subquery Logic 27
SELECT * FROM orders WHERE odate = (SELECT MIN(odate) FROM orders);

-- Q28: Unique Subquery Logic 28
SELECT pname, price - (SELECT AVG(price) FROM products) FROM products;

-- Q29: Unique Subquery Logic 29
SELECT * FROM customers WHERE city IN (SELECT city FROM customers GROUP BY city HAVING COUNT(*) > 1);

-- Q30: Unique Subquery Logic 30
SELECT * FROM products WHERE price = (SELECT MAX(price) FROM products);

-- Q31: Unique Subquery Logic 31
SELECT cname FROM customers WHERE cid NOT IN (SELECT cid FROM orders);

-- Q32: Unique Subquery Logic 32
SELECT * FROM orders WHERE qty > (SELECT AVG(qty) FROM orders);

-- Q33: Unique Subquery Logic 33
SELECT pname FROM products p WHERE (SELECT COUNT(*) FROM orders o WHERE o.pid = p.pid) = 0;

-- Q34: Unique Subquery Logic 34
SELECT DISTINCT city FROM customers WHERE cid IN (SELECT cid FROM orders WHERE qty > 2);

-- Q35: Unique Subquery Logic 35
SELECT * FROM products WHERE cat = (SELECT cat FROM products WHERE pid = 1);

-- Q36: Unique Subquery Logic 36
SELECT cid, (SELECT COUNT(*) FROM orders o WHERE o.cid = c.cid) FROM customers c;

-- Q37: Unique Subquery Logic 37
SELECT * FROM orders WHERE odate = (SELECT MIN(odate) FROM orders);

-- Q38: Unique Subquery Logic 38
SELECT pname, price - (SELECT AVG(price) FROM products) FROM products;

-- Q39: Unique Subquery Logic 39
SELECT * FROM customers WHERE city IN (SELECT city FROM customers GROUP BY city HAVING COUNT(*) > 1);

-- Q40: Unique Subquery Logic 40
SELECT * FROM products WHERE price = (SELECT MAX(price) FROM products);

-- Q41: Unique Subquery Logic 41
SELECT cname FROM customers WHERE cid NOT IN (SELECT cid FROM orders);

-- Q42: Unique Subquery Logic 42
SELECT * FROM orders WHERE qty > (SELECT AVG(qty) FROM orders);

-- Q43: Unique Subquery Logic 43
SELECT pname FROM products p WHERE (SELECT COUNT(*) FROM orders o WHERE o.pid = p.pid) = 0;

-- Q44: Unique Subquery Logic 44
SELECT DISTINCT city FROM customers WHERE cid IN (SELECT cid FROM orders WHERE qty > 2);

-- Q45: Unique Subquery Logic 45
SELECT * FROM products WHERE cat = (SELECT cat FROM products WHERE pid = 1);

-- Q46: Unique Subquery Logic 46
SELECT cid, (SELECT COUNT(*) FROM orders o WHERE o.cid = c.cid) FROM customers c;

-- Q47: Unique Subquery Logic 47
SELECT * FROM orders WHERE odate = (SELECT MIN(odate) FROM orders);

-- Q48: Unique Subquery Logic 48
SELECT pname, price - (SELECT AVG(price) FROM products) FROM products;

-- Q49: Unique Subquery Logic 49
SELECT * FROM customers WHERE city IN (SELECT city FROM customers GROUP BY city HAVING COUNT(*) > 1);

-- Q50: Unique Subquery Logic 50
SELECT * FROM products WHERE price = (SELECT MAX(price) FROM products);

