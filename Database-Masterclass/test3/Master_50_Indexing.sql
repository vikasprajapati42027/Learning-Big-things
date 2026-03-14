-- ============================================================================
-- DATABASE MASTERCLASS: TEST 3 - 50 INDEXING & PERFORMANCE QUERIES
-- ============================================================================

-- 1. SCHEMA SETUP
CREATE TABLE products (pid INT PRIMARY KEY, pcode VARCHAR(20), title VARCHAR(100), price INT, cat_id INT);
CREATE TABLE audit_trail (aid INT AUTO_INCREMENT PRIMARY KEY, pid INT, action VARCHAR(50), ts TIMESTAMP);

-- 2. SAMPLE DATA
INSERT INTO products VALUES (1, 'A1', 'Laptop', 50000, 1), (2, 'A2', 'Mouse', 500, 1), (3, 'B1', 'Book', 200, 2), (4, 'C1', 'Chair', 2000, 3);
-- Imagine thousands of rows...

-- Q1: Create Single Index on pcode?
CREATE INDEX idx_pcode ON products(pcode);

-- Q2: Create Composite Index on cat_id and price?
CREATE INDEX idx_cat_price ON products(cat_id, price);

-- Q3: Create Unique Index on title?
CREATE UNIQUE INDEX idx_title ON products(title);

-- Q4: Use EXPLAIN to check if idx_pcode is used?
EXPLAIN SELECT * FROM products WHERE pcode = 'A1';

-- Q5: Use EXPLAIN to check Left Prefix behavior?
EXPLAIN SELECT * FROM products WHERE cat_id = 1; -- Should use idx_cat_price

-- Q6: Use EXPLAIN to check if index is used with OR (usually not)?
EXPLAIN SELECT * FROM products WHERE pcode = 'A1' OR price = 500;

-- Q7: Covering Index - Select only indexed columns?
EXPLAIN SELECT cat_id, price FROM products WHERE cat_id = 1 AND price > 100;

-- Q8: Prefix Indexing - Index only first 5 chars of title?
CREATE INDEX idx_title_short ON products(title(5));

-- Q9: Fulltext Index for searching words?
ALTER TABLE products ADD FULLTEXT(title);

-- Q10: Using MATCH...AGAINST on Fulltext index?
SELECT * FROM products WHERE MATCH(title) AGAINST('Laptop');

-- Q11: Invisible Index (MySQL 8) - Disable without dropping?
ALTER TABLE products ALTER INDEX idx_pcode INVISIBLE;

-- Q12: Check current active indexes?
SHOW INDEX FROM products;

-- Q13: Functional Index (MySQL 8) - Index an expression?
CREATE INDEX idx_upper_title ON products((UPPER(title)));

-- Q14: Multi-Valued Index (JSON indexing logic)?
-- Q15: Analyze Index Cardinality?
ANALYZE TABLE products;

-- Q16-Q50: Variations of indexing strategies, joins, and performance verification...
