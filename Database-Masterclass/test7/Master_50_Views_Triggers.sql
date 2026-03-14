-- SCHEMA SETUP
CREATE TABLE users (uid INT PRIMARY KEY, name VARCHAR(50), balance INT);
CREATE TABLE audit_log (log_id INT AUTO_INCREMENT PRIMARY KEY, msg VARCHAR(255), ts TIMESTAMP);
INSERT INTO users VALUES (1, 'Vikas', 1000), (2, 'Rahul', 2000), (3, 'Amit', 500);

-- Q1: Create View for High Balance Users?
CREATE VIEW v_rich AS SELECT * FROM users WHERE balance > 1000;
-- Q2: Query the View?
SELECT * FROM v_rich;
-- Q3: Create Audit Trigger on Update?
DELIMITER //
CREATE TRIGGER tr_audit_update AFTER UPDATE ON users FOR EACH ROW
BEGIN
    INSERT INTO audit_log(msg) VALUES (CONCAT('User ', OLD.uid, ' balance changed from ', OLD.balance, ' to ', NEW.balance));
END //
DELIMITER ;
-- Q4: Test the Trigger?
UPDATE users SET balance = 1500 WHERE uid = 1;
SELECT * FROM audit_log;
-- Q5: View with Join?
-- Q6: Trigger to prevent negative balance?
-- Q7-Q50: Variations of views, security views, check triggers, delete triggers...
