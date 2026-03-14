-- ============================================================================
-- DATABASE MASTERCLASS: Test 49 - 50 UNIQUE INTERVIEW QUERIES
-- ============================================================================

-- 1. SCHEMA SETUP
CREATE TABLE customers (cid INT PRIMARY KEY, cname VARCHAR(50), city VARCHAR(50));
CREATE TABLE products (pid INT PRIMARY KEY, pname VARCHAR(50), price INT, cat VARCHAR(20));
CREATE TABLE orders (oid INT PRIMARY KEY, cid INT, pid INT, qty INT, odate DATE);

-- 2. SAMPLE DATA (10+ Rows)
INSERT INTO customers VALUES (1,'Vikas','Mumbai'),(2,'Rahul','Delhi'),(3,'Amit','Mumbai'),(4,'Sonia','Delhi'),(5,'Priya','Bangalore'),(6,'Karan','Bangalore'),(7,'Neha','Pune'),(8,'Raj','Pune'),(9,'Simran','Mumbai'),(10,'Arjun','Chennai');
INSERT INTO products VALUES (1,'Laptop',50000,'ET'),(2,'Mouse',500,'ET'),(3,'Phone',30000,'ET'),(4,'Book',200,'BK'),(5,'Pen',20,'BK'),(6,'Chair',2000,'FR'),(7,'Table',5000,'FR'),(8,'Lamp',1000,'FR'),(9,'Monitor',10000,'ET'),(10,'Keyboard',1500,'ET');
INSERT INTO orders VALUES (101,1,1,1,'2024-01-01'),(102,2,3,1,'2024-01-05'),(103,1,2,2,'2024-01-10'),(104,3,1,1,'2024-02-01'),(105,4,4,5,'2024-02-15'),(106,5,6,1,'2024-03-01'),(107,6,7,1,'2024-03-05'),(108,7,3,1,'2024-03-10'),(109,8,1,1,'2024-03-15'),(110,9,9,1,'2024-03-20');

-- 3. 50 UNIQUE QUERIES
-- Q1: Simple select all? SELECT * FROM products;
-- Q2: Order products by price? SELECT * FROM products ORDER BY price DESC;
-- Q3: Limit top 3 cheapest products? SELECT * FROM products ORDER BY price LIMIT 3;
-- Q4: Find customers from Mumbai? SELECT cname FROM customers WHERE city = 'Mumbai';
-- Q5: Products cheaper than 1k? SELECT pname FROM products WHERE price < 1000;
-- Q6: Search products starting with 'L'? SELECT * FROM products WHERE pname LIKE 'L%';
-- Q7: Orders for categories ET or BK? SELECT * FROM products WHERE cat IN ('ET', 'BK');
-- Q8: Products in price range 1k-10k? SELECT * FROM products WHERE price BETWEEN 1000 AND 10000;
-- Q9: Customers with no city set? SELECT * FROM customers WHERE city IS NULL;
-- Q10: Total count of orders? SELECT COUNT(*) FROM orders;
-- Q11: Total revenue from all sales? SELECT SUM(qty * (SELECT price FROM products p WHERE p.pid = o.pid)) FROM orders o;
-- Q12: Average product price? SELECT AVG(price) FROM products;
-- Q13: Minimum order quantity? SELECT MIN(qty) FROM orders;
-- Q14: Maximum price in BK category? SELECT MAX(price) FROM products WHERE cat = 'BK';
-- Q15: Count customers per city? SELECT city, COUNT(*) FROM customers GROUP BY city;
-- Q16: Cities with > 2 customers? SELECT city, COUNT(*) FROM customers GROUP BY city HAVING COUNT(*) > 2;
-- Q17: List orders with customer name? SELECT o.oid, c.cname FROM orders o JOIN customers c ON o.cid = c.cid;
-- Q18: All customers and their orders (even if no orders)? SELECT c.cname, o.oid FROM customers c LEFT JOIN orders o ON c.cid = o.cid;
-- Q19: All products and who ordered them? SELECT p.pname, c.cname FROM products p LEFT JOIN orders o ON p.pid = o.pid LEFT JOIN customers c ON o.cid = c.cid;
-- Q20: Cartesian product of cat and city? SELECT DISTINCT p.cat, c.city FROM products p CROSS JOIN customers c;
-- Q21: Self join to find customer pairs in same city? SELECT a.cname, b.cname, a.city FROM customers a JOIN customers b ON a.city = b.city WHERE a.cid < b.cid;
-- Q22: Subquery: Products not bought yet? SELECT pname FROM products WHERE pid NOT IN (SELECT DISTINCT pid FROM orders);
-- Q23: Subquery in FROM: Top cat by revenue? SELECT cat, rev FROM (SELECT cat, SUM(price*qty) as rev FROM products p JOIN orders o ON p.pid = o.pid GROUP BY cat) t ORDER BY rev DESC LIMIT 1;
-- Q24: Subquery in SELECT: User name for each order? SELECT oid, (SELECT cname FROM customers c WHERE c.cid = o.cid) FROM orders o;
-- Q25: EXISTS: Find customers who ordered 'Laptop'? SELECT cname FROM customers c WHERE EXISTS (SELECT 1 FROM orders o JOIN products p ON o.pid = p.pid WHERE o.cid = c.cid AND p.pname = 'Laptop');
-- Q26: UNION: Distinct list of cities and categories? SELECT city FROM customers UNION SELECT cat FROM products;
-- Q27: UNION ALL: Combined list with duplicates? SELECT city FROM customers UNION ALL SELECT cat FROM products;
-- Q28: Intersect logic: Customers in Mumbai AND Delhi? (None but logical) SELECT cid FROM customers WHERE city='Mumbai' AND cid IN (SELECT cid FROM customers WHERE city='Delhi');
-- Q29: Except logic: Products in ET but not ordered? SELECT pid FROM products WHERE cat='ET' AND pid NOT IN (SELECT pid FROM orders);
-- Q30: CASE: Label products as Cheap/Expensive? SELECT pname, CASE WHEN price > 1000 THEN 'Expensive' ELSE 'Cheap' END FROM products;
-- Q31: COALESCE: Handle missing city? SELECT cname, COALESCE(city, 'Roaming') FROM customers;
-- Q32: DISTINCT: List of unique categories? SELECT DISTINCT cat FROM products;
-- Q33: CONCAT: Custom user message? SELECT CONCAT('Hello ', cname, ' from ', city) FROM customers;
-- Q34: Date Year? SELECT cid, YEAR(odate) FROM orders;
-- Q35: Months since order? SELECT oid, TIMESTAMPDIFF(MONTH, odate, NOW()) FROM orders;
-- Q36: Rounding prices? SELECT pname, ROUND(price/75, 2) as usd FROM products;
-- Q37: Math: Square root of price? SELECT pname, SQRT(price) FROM products;
-- Q38: UPPER: Category caps? SELECT UPPER(cat) FROM products;
-- Q39: TRIM: Cleaned names? SELECT TRIM(cname) FROM customers;
-- Q40: REPLACE: Censored names? SELECT REPLACE(cname, 'a', '*') FROM customers;
-- Q41: LENGTH: Longest name? SELECT cname FROM customers ORDER BY LENGTH(cname) DESC LIMIT 1;
-- Q42: INSTR: Position of 'u' in city? SELECT city, INSTR(city, 'u') FROM customers;
-- Q43: SUBSTRING: First 3 chars of product? SELECT SUBSTRING(pname, 1, 3) FROM products;
-- Q44: CAST: Price to string? SELECT CAST(price as CHAR) FROM products;
-- Q45: Subquery with IN: Orders in high price cats? SELECT * FROM orders WHERE pid IN (SELECT pid FROM products WHERE price > 10000);
-- Q46: RANK: Rank products by price? SELECT pname, RANK() OVER(ORDER BY price DESC) FROM products;
-- Q47: ROW_NUMBER: Row num per city? SELECT cname, city, ROW_NUMBER() OVER(PARTITION BY city ORDER BY cname) FROM customers;
-- Q48: LAG: Previous order date? SELECT oid, odate, LAG(odate) OVER(PARTITION BY cid ORDER BY odate) FROM orders;
-- Q49: FIRST_VAL: First product bought by user? SELECT cid, FIRST_VALUE(pid) OVER(PARTITION BY cid ORDER BY odate) FROM orders;
-- Q50: Cumulative SUM: Money spent by user? SELECT cid, odate, SUM(qty*100) OVER(PARTITION BY cid ORDER BY odate) as cum_sum FROM orders;
