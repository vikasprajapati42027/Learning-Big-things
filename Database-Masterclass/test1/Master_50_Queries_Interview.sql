-- SCHEMA SETUP
CREATE TABLE users (user_id INT PRIMARY KEY, username VARCHAR(50));
CREATE TABLE products (prod_id INT PRIMARY KEY, prod_name VARCHAR(100), price INT);
CREATE TABLE orders (order_id INT PRIMARY KEY, user_id INT, order_date DATE);
CREATE TABLE order_items (item_id INT PRIMARY KEY, order_id INT, prod_id INT, qty INT);
-- 50 JOIN QUERIES START HERE
-- Q1: Join scenario 1? 
SELECT u.username, p.prod_name FROM users u JOIN orders o ON u.user_id = o.user_id JOIN order_items oi ON o.order_id = oi.order_id JOIN products p ON oi.prod_id = p.prod_id WHERE u.user_id = 1;
-- Q2: Join scenario 2? 
SELECT u.username, p.prod_name FROM users u JOIN orders o ON u.user_id = o.user_id JOIN order_items oi ON o.order_id = oi.order_id JOIN products p ON oi.prod_id = p.prod_id WHERE u.user_id = 2;
-- Q3: Join scenario 3? 
SELECT u.username, p.prod_name FROM users u JOIN orders o ON u.user_id = o.user_id JOIN order_items oi ON o.order_id = oi.order_id JOIN products p ON oi.prod_id = p.prod_id WHERE u.user_id = 3;
-- Q4: Join scenario 4? 
SELECT u.username, p.prod_name FROM users u JOIN orders o ON u.user_id = o.user_id JOIN order_items oi ON o.order_id = oi.order_id JOIN products p ON oi.prod_id = p.prod_id WHERE u.user_id = 4;
-- Q5: Join scenario 5? 
SELECT u.username, p.prod_name FROM users u JOIN orders o ON u.user_id = o.user_id JOIN order_items oi ON o.order_id = oi.order_id JOIN products p ON oi.prod_id = p.prod_id WHERE u.user_id = 5;
-- Q6: Join scenario 6? 
SELECT u.username, p.prod_name FROM users u JOIN orders o ON u.user_id = o.user_id JOIN order_items oi ON o.order_id = oi.order_id JOIN products p ON oi.prod_id = p.prod_id WHERE u.user_id = 6;
-- Q7: Join scenario 7? 
SELECT u.username, p.prod_name FROM users u JOIN orders o ON u.user_id = o.user_id JOIN order_items oi ON o.order_id = oi.order_id JOIN products p ON oi.prod_id = p.prod_id WHERE u.user_id = 7;
-- Q8: Join scenario 8? 
SELECT u.username, p.prod_name FROM users u JOIN orders o ON u.user_id = o.user_id JOIN order_items oi ON o.order_id = oi.order_id JOIN products p ON oi.prod_id = p.prod_id WHERE u.user_id = 8;
-- Q9: Join scenario 9? 
SELECT u.username, p.prod_name FROM users u JOIN orders o ON u.user_id = o.user_id JOIN order_items oi ON o.order_id = oi.order_id JOIN products p ON oi.prod_id = p.prod_id WHERE u.user_id = 9;
-- Q10: Join scenario 10? 
SELECT u.username, p.prod_name FROM users u JOIN orders o ON u.user_id = o.user_id JOIN order_items oi ON o.order_id = oi.order_id JOIN products p ON oi.prod_id = p.prod_id WHERE u.user_id = 10;
-- Q11: Join scenario 11? 
SELECT u.username, p.prod_name FROM users u JOIN orders o ON u.user_id = o.user_id JOIN order_items oi ON o.order_id = oi.order_id JOIN products p ON oi.prod_id = p.prod_id WHERE u.user_id = 11;
-- Q12: Join scenario 12? 
SELECT u.username, p.prod_name FROM users u JOIN orders o ON u.user_id = o.user_id JOIN order_items oi ON o.order_id = oi.order_id JOIN products p ON oi.prod_id = p.prod_id WHERE u.user_id = 12;
-- Q13: Join scenario 13? 
SELECT u.username, p.prod_name FROM users u JOIN orders o ON u.user_id = o.user_id JOIN order_items oi ON o.order_id = oi.order_id JOIN products p ON oi.prod_id = p.prod_id WHERE u.user_id = 13;
-- Q14: Join scenario 14? 
SELECT u.username, p.prod_name FROM users u JOIN orders o ON u.user_id = o.user_id JOIN order_items oi ON o.order_id = oi.order_id JOIN products p ON oi.prod_id = p.prod_id WHERE u.user_id = 14;
-- Q15: Join scenario 15? 
SELECT u.username, p.prod_name FROM users u JOIN orders o ON u.user_id = o.user_id JOIN order_items oi ON o.order_id = oi.order_id JOIN products p ON oi.prod_id = p.prod_id WHERE u.user_id = 15;
-- Q16: Join scenario 16? 
SELECT u.username, p.prod_name FROM users u JOIN orders o ON u.user_id = o.user_id JOIN order_items oi ON o.order_id = oi.order_id JOIN products p ON oi.prod_id = p.prod_id WHERE u.user_id = 16;
-- Q17: Join scenario 17? 
SELECT u.username, p.prod_name FROM users u JOIN orders o ON u.user_id = o.user_id JOIN order_items oi ON o.order_id = oi.order_id JOIN products p ON oi.prod_id = p.prod_id WHERE u.user_id = 17;
-- Q18: Join scenario 18? 
SELECT u.username, p.prod_name FROM users u JOIN orders o ON u.user_id = o.user_id JOIN order_items oi ON o.order_id = oi.order_id JOIN products p ON oi.prod_id = p.prod_id WHERE u.user_id = 18;
-- Q19: Join scenario 19? 
SELECT u.username, p.prod_name FROM users u JOIN orders o ON u.user_id = o.user_id JOIN order_items oi ON o.order_id = oi.order_id JOIN products p ON oi.prod_id = p.prod_id WHERE u.user_id = 19;
-- Q20: Join scenario 20? 
SELECT u.username, p.prod_name FROM users u JOIN orders o ON u.user_id = o.user_id JOIN order_items oi ON o.order_id = oi.order_id JOIN products p ON oi.prod_id = p.prod_id WHERE u.user_id = 20;
-- Q21: Join scenario 21? 
SELECT u.username, p.prod_name FROM users u JOIN orders o ON u.user_id = o.user_id JOIN order_items oi ON o.order_id = oi.order_id JOIN products p ON oi.prod_id = p.prod_id WHERE u.user_id = 21;
-- Q22: Join scenario 22? 
SELECT u.username, p.prod_name FROM users u JOIN orders o ON u.user_id = o.user_id JOIN order_items oi ON o.order_id = oi.order_id JOIN products p ON oi.prod_id = p.prod_id WHERE u.user_id = 22;
-- Q23: Join scenario 23? 
SELECT u.username, p.prod_name FROM users u JOIN orders o ON u.user_id = o.user_id JOIN order_items oi ON o.order_id = oi.order_id JOIN products p ON oi.prod_id = p.prod_id WHERE u.user_id = 23;
-- Q24: Join scenario 24? 
SELECT u.username, p.prod_name FROM users u JOIN orders o ON u.user_id = o.user_id JOIN order_items oi ON o.order_id = oi.order_id JOIN products p ON oi.prod_id = p.prod_id WHERE u.user_id = 24;
-- Q25: Join scenario 25? 
SELECT u.username, p.prod_name FROM users u JOIN orders o ON u.user_id = o.user_id JOIN order_items oi ON o.order_id = oi.order_id JOIN products p ON oi.prod_id = p.prod_id WHERE u.user_id = 25;
-- Q26: Join scenario 26? 
SELECT u.username, p.prod_name FROM users u JOIN orders o ON u.user_id = o.user_id JOIN order_items oi ON o.order_id = oi.order_id JOIN products p ON oi.prod_id = p.prod_id WHERE u.user_id = 26;
-- Q27: Join scenario 27? 
SELECT u.username, p.prod_name FROM users u JOIN orders o ON u.user_id = o.user_id JOIN order_items oi ON o.order_id = oi.order_id JOIN products p ON oi.prod_id = p.prod_id WHERE u.user_id = 27;
-- Q28: Join scenario 28? 
SELECT u.username, p.prod_name FROM users u JOIN orders o ON u.user_id = o.user_id JOIN order_items oi ON o.order_id = oi.order_id JOIN products p ON oi.prod_id = p.prod_id WHERE u.user_id = 28;
-- Q29: Join scenario 29? 
SELECT u.username, p.prod_name FROM users u JOIN orders o ON u.user_id = o.user_id JOIN order_items oi ON o.order_id = oi.order_id JOIN products p ON oi.prod_id = p.prod_id WHERE u.user_id = 29;
-- Q30: Join scenario 30? 
SELECT u.username, p.prod_name FROM users u JOIN orders o ON u.user_id = o.user_id JOIN order_items oi ON o.order_id = oi.order_id JOIN products p ON oi.prod_id = p.prod_id WHERE u.user_id = 30;
-- Q31: Join scenario 31? 
SELECT u.username, p.prod_name FROM users u JOIN orders o ON u.user_id = o.user_id JOIN order_items oi ON o.order_id = oi.order_id JOIN products p ON oi.prod_id = p.prod_id WHERE u.user_id = 31;
-- Q32: Join scenario 32? 
SELECT u.username, p.prod_name FROM users u JOIN orders o ON u.user_id = o.user_id JOIN order_items oi ON o.order_id = oi.order_id JOIN products p ON oi.prod_id = p.prod_id WHERE u.user_id = 32;
-- Q33: Join scenario 33? 
SELECT u.username, p.prod_name FROM users u JOIN orders o ON u.user_id = o.user_id JOIN order_items oi ON o.order_id = oi.order_id JOIN products p ON oi.prod_id = p.prod_id WHERE u.user_id = 33;
-- Q34: Join scenario 34? 
SELECT u.username, p.prod_name FROM users u JOIN orders o ON u.user_id = o.user_id JOIN order_items oi ON o.order_id = oi.order_id JOIN products p ON oi.prod_id = p.prod_id WHERE u.user_id = 34;
-- Q35: Join scenario 35? 
SELECT u.username, p.prod_name FROM users u JOIN orders o ON u.user_id = o.user_id JOIN order_items oi ON o.order_id = oi.order_id JOIN products p ON oi.prod_id = p.prod_id WHERE u.user_id = 35;
-- Q36: Join scenario 36? 
SELECT u.username, p.prod_name FROM users u JOIN orders o ON u.user_id = o.user_id JOIN order_items oi ON o.order_id = oi.order_id JOIN products p ON oi.prod_id = p.prod_id WHERE u.user_id = 36;
-- Q37: Join scenario 37? 
SELECT u.username, p.prod_name FROM users u JOIN orders o ON u.user_id = o.user_id JOIN order_items oi ON o.order_id = oi.order_id JOIN products p ON oi.prod_id = p.prod_id WHERE u.user_id = 37;
-- Q38: Join scenario 38? 
SELECT u.username, p.prod_name FROM users u JOIN orders o ON u.user_id = o.user_id JOIN order_items oi ON o.order_id = oi.order_id JOIN products p ON oi.prod_id = p.prod_id WHERE u.user_id = 38;
-- Q39: Join scenario 39? 
SELECT u.username, p.prod_name FROM users u JOIN orders o ON u.user_id = o.user_id JOIN order_items oi ON o.order_id = oi.order_id JOIN products p ON oi.prod_id = p.prod_id WHERE u.user_id = 39;
-- Q40: Join scenario 40? 
SELECT u.username, p.prod_name FROM users u JOIN orders o ON u.user_id = o.user_id JOIN order_items oi ON o.order_id = oi.order_id JOIN products p ON oi.prod_id = p.prod_id WHERE u.user_id = 40;
-- Q41: Join scenario 41? 
SELECT u.username, p.prod_name FROM users u JOIN orders o ON u.user_id = o.user_id JOIN order_items oi ON o.order_id = oi.order_id JOIN products p ON oi.prod_id = p.prod_id WHERE u.user_id = 41;
-- Q42: Join scenario 42? 
SELECT u.username, p.prod_name FROM users u JOIN orders o ON u.user_id = o.user_id JOIN order_items oi ON o.order_id = oi.order_id JOIN products p ON oi.prod_id = p.prod_id WHERE u.user_id = 42;
-- Q43: Join scenario 43? 
SELECT u.username, p.prod_name FROM users u JOIN orders o ON u.user_id = o.user_id JOIN order_items oi ON o.order_id = oi.order_id JOIN products p ON oi.prod_id = p.prod_id WHERE u.user_id = 43;
-- Q44: Join scenario 44? 
SELECT u.username, p.prod_name FROM users u JOIN orders o ON u.user_id = o.user_id JOIN order_items oi ON o.order_id = oi.order_id JOIN products p ON oi.prod_id = p.prod_id WHERE u.user_id = 44;
-- Q45: Join scenario 45? 
SELECT u.username, p.prod_name FROM users u JOIN orders o ON u.user_id = o.user_id JOIN order_items oi ON o.order_id = oi.order_id JOIN products p ON oi.prod_id = p.prod_id WHERE u.user_id = 45;
-- Q46: Join scenario 46? 
SELECT u.username, p.prod_name FROM users u JOIN orders o ON u.user_id = o.user_id JOIN order_items oi ON o.order_id = oi.order_id JOIN products p ON oi.prod_id = p.prod_id WHERE u.user_id = 46;
-- Q47: Join scenario 47? 
SELECT u.username, p.prod_name FROM users u JOIN orders o ON u.user_id = o.user_id JOIN order_items oi ON o.order_id = oi.order_id JOIN products p ON oi.prod_id = p.prod_id WHERE u.user_id = 47;
-- Q48: Join scenario 48? 
SELECT u.username, p.prod_name FROM users u JOIN orders o ON u.user_id = o.user_id JOIN order_items oi ON o.order_id = oi.order_id JOIN products p ON oi.prod_id = p.prod_id WHERE u.user_id = 48;
-- Q49: Join scenario 49? 
SELECT u.username, p.prod_name FROM users u JOIN orders o ON u.user_id = o.user_id JOIN order_items oi ON o.order_id = oi.order_id JOIN products p ON oi.prod_id = p.prod_id WHERE u.user_id = 49;
-- Q50: Join scenario 50? 
SELECT u.username, p.prod_name FROM users u JOIN orders o ON u.user_id = o.user_id JOIN order_items oi ON o.order_id = oi.order_id JOIN products p ON oi.prod_id = p.prod_id WHERE u.user_id = 50;
