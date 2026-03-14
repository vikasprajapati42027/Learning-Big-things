-- SCHEMA SETUP
CREATE TABLE stock (id INT PRIMARY KEY, item VARCHAR(50), qty INT);
INSERT INTO stock VALUES (1, 'Phone', 10), (2, 'Laptop', 5);

-- Q1: Procedure to Add Stock?
DELIMITER //
CREATE PROCEDURE AddStock(IN prod_id INT, IN add_qty INT)
BEGIN
    UPDATE stock SET qty = qty + add_qty WHERE id = prod_id;
END //
DELIMITER ;
CALL AddStock(1, 5);
-- Q2: Procedure with OUT Param (Get total qty)?
DELIMITER //
CREATE PROCEDURE GetTotalStock(OUT total INT)
BEGIN
    SELECT SUM(qty) INTO total FROM stock;
END //
DELIMITER ;
-- Q3: Procedure with Loop?
-- Q4: Procedure with Cursor?
-- Q5-Q50: Variations of logic, transactions inside procs, bulk updates...
