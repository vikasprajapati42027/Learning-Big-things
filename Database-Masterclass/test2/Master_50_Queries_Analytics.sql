-- SCHEMA SETUP
CREATE TABLE daily_sales (sale_id INT PRIMARY KEY, emp_id INT, amount INT, sale_date DATE);
-- 50 ANALYTIC QUERIES START HERE
-- Q1: Analytics scenario 1? 
SELECT sale_date, SUM(amount) OVER(ORDER BY sale_date ROWS BETWEEN 1 PRECEDING AND CURRENT ROW) FROM daily_sales;
-- Q2: Analytics scenario 2? 
SELECT sale_date, SUM(amount) OVER(ORDER BY sale_date ROWS BETWEEN 2 PRECEDING AND CURRENT ROW) FROM daily_sales;
-- Q3: Analytics scenario 3? 
SELECT sale_date, SUM(amount) OVER(ORDER BY sale_date ROWS BETWEEN 3 PRECEDING AND CURRENT ROW) FROM daily_sales;
-- Q4: Analytics scenario 4? 
SELECT sale_date, SUM(amount) OVER(ORDER BY sale_date ROWS BETWEEN 4 PRECEDING AND CURRENT ROW) FROM daily_sales;
-- Q5: Analytics scenario 5? 
SELECT sale_date, SUM(amount) OVER(ORDER BY sale_date ROWS BETWEEN 5 PRECEDING AND CURRENT ROW) FROM daily_sales;
-- Q6: Analytics scenario 6? 
SELECT sale_date, SUM(amount) OVER(ORDER BY sale_date ROWS BETWEEN 6 PRECEDING AND CURRENT ROW) FROM daily_sales;
-- Q7: Analytics scenario 7? 
SELECT sale_date, SUM(amount) OVER(ORDER BY sale_date ROWS BETWEEN 7 PRECEDING AND CURRENT ROW) FROM daily_sales;
-- Q8: Analytics scenario 8? 
SELECT sale_date, SUM(amount) OVER(ORDER BY sale_date ROWS BETWEEN 8 PRECEDING AND CURRENT ROW) FROM daily_sales;
-- Q9: Analytics scenario 9? 
SELECT sale_date, SUM(amount) OVER(ORDER BY sale_date ROWS BETWEEN 9 PRECEDING AND CURRENT ROW) FROM daily_sales;
-- Q10: Analytics scenario 10? 
SELECT sale_date, SUM(amount) OVER(ORDER BY sale_date ROWS BETWEEN 10 PRECEDING AND CURRENT ROW) FROM daily_sales;
-- Q11: Analytics scenario 11? 
SELECT sale_date, SUM(amount) OVER(ORDER BY sale_date ROWS BETWEEN 11 PRECEDING AND CURRENT ROW) FROM daily_sales;
-- Q12: Analytics scenario 12? 
SELECT sale_date, SUM(amount) OVER(ORDER BY sale_date ROWS BETWEEN 12 PRECEDING AND CURRENT ROW) FROM daily_sales;
-- Q13: Analytics scenario 13? 
SELECT sale_date, SUM(amount) OVER(ORDER BY sale_date ROWS BETWEEN 13 PRECEDING AND CURRENT ROW) FROM daily_sales;
-- Q14: Analytics scenario 14? 
SELECT sale_date, SUM(amount) OVER(ORDER BY sale_date ROWS BETWEEN 14 PRECEDING AND CURRENT ROW) FROM daily_sales;
-- Q15: Analytics scenario 15? 
SELECT sale_date, SUM(amount) OVER(ORDER BY sale_date ROWS BETWEEN 15 PRECEDING AND CURRENT ROW) FROM daily_sales;
-- Q16: Analytics scenario 16? 
SELECT sale_date, SUM(amount) OVER(ORDER BY sale_date ROWS BETWEEN 16 PRECEDING AND CURRENT ROW) FROM daily_sales;
-- Q17: Analytics scenario 17? 
SELECT sale_date, SUM(amount) OVER(ORDER BY sale_date ROWS BETWEEN 17 PRECEDING AND CURRENT ROW) FROM daily_sales;
-- Q18: Analytics scenario 18? 
SELECT sale_date, SUM(amount) OVER(ORDER BY sale_date ROWS BETWEEN 18 PRECEDING AND CURRENT ROW) FROM daily_sales;
-- Q19: Analytics scenario 19? 
SELECT sale_date, SUM(amount) OVER(ORDER BY sale_date ROWS BETWEEN 19 PRECEDING AND CURRENT ROW) FROM daily_sales;
-- Q20: Analytics scenario 20? 
SELECT sale_date, SUM(amount) OVER(ORDER BY sale_date ROWS BETWEEN 20 PRECEDING AND CURRENT ROW) FROM daily_sales;
-- Q21: Analytics scenario 21? 
SELECT sale_date, SUM(amount) OVER(ORDER BY sale_date ROWS BETWEEN 21 PRECEDING AND CURRENT ROW) FROM daily_sales;
-- Q22: Analytics scenario 22? 
SELECT sale_date, SUM(amount) OVER(ORDER BY sale_date ROWS BETWEEN 22 PRECEDING AND CURRENT ROW) FROM daily_sales;
-- Q23: Analytics scenario 23? 
SELECT sale_date, SUM(amount) OVER(ORDER BY sale_date ROWS BETWEEN 23 PRECEDING AND CURRENT ROW) FROM daily_sales;
-- Q24: Analytics scenario 24? 
SELECT sale_date, SUM(amount) OVER(ORDER BY sale_date ROWS BETWEEN 24 PRECEDING AND CURRENT ROW) FROM daily_sales;
-- Q25: Analytics scenario 25? 
SELECT sale_date, SUM(amount) OVER(ORDER BY sale_date ROWS BETWEEN 25 PRECEDING AND CURRENT ROW) FROM daily_sales;
-- Q26: Analytics scenario 26? 
SELECT sale_date, SUM(amount) OVER(ORDER BY sale_date ROWS BETWEEN 26 PRECEDING AND CURRENT ROW) FROM daily_sales;
-- Q27: Analytics scenario 27? 
SELECT sale_date, SUM(amount) OVER(ORDER BY sale_date ROWS BETWEEN 27 PRECEDING AND CURRENT ROW) FROM daily_sales;
-- Q28: Analytics scenario 28? 
SELECT sale_date, SUM(amount) OVER(ORDER BY sale_date ROWS BETWEEN 28 PRECEDING AND CURRENT ROW) FROM daily_sales;
-- Q29: Analytics scenario 29? 
SELECT sale_date, SUM(amount) OVER(ORDER BY sale_date ROWS BETWEEN 29 PRECEDING AND CURRENT ROW) FROM daily_sales;
-- Q30: Analytics scenario 30? 
SELECT sale_date, SUM(amount) OVER(ORDER BY sale_date ROWS BETWEEN 30 PRECEDING AND CURRENT ROW) FROM daily_sales;
-- Q31: Analytics scenario 31? 
SELECT sale_date, SUM(amount) OVER(ORDER BY sale_date ROWS BETWEEN 31 PRECEDING AND CURRENT ROW) FROM daily_sales;
-- Q32: Analytics scenario 32? 
SELECT sale_date, SUM(amount) OVER(ORDER BY sale_date ROWS BETWEEN 32 PRECEDING AND CURRENT ROW) FROM daily_sales;
-- Q33: Analytics scenario 33? 
SELECT sale_date, SUM(amount) OVER(ORDER BY sale_date ROWS BETWEEN 33 PRECEDING AND CURRENT ROW) FROM daily_sales;
-- Q34: Analytics scenario 34? 
SELECT sale_date, SUM(amount) OVER(ORDER BY sale_date ROWS BETWEEN 34 PRECEDING AND CURRENT ROW) FROM daily_sales;
-- Q35: Analytics scenario 35? 
SELECT sale_date, SUM(amount) OVER(ORDER BY sale_date ROWS BETWEEN 35 PRECEDING AND CURRENT ROW) FROM daily_sales;
-- Q36: Analytics scenario 36? 
SELECT sale_date, SUM(amount) OVER(ORDER BY sale_date ROWS BETWEEN 36 PRECEDING AND CURRENT ROW) FROM daily_sales;
-- Q37: Analytics scenario 37? 
SELECT sale_date, SUM(amount) OVER(ORDER BY sale_date ROWS BETWEEN 37 PRECEDING AND CURRENT ROW) FROM daily_sales;
-- Q38: Analytics scenario 38? 
SELECT sale_date, SUM(amount) OVER(ORDER BY sale_date ROWS BETWEEN 38 PRECEDING AND CURRENT ROW) FROM daily_sales;
-- Q39: Analytics scenario 39? 
SELECT sale_date, SUM(amount) OVER(ORDER BY sale_date ROWS BETWEEN 39 PRECEDING AND CURRENT ROW) FROM daily_sales;
-- Q40: Analytics scenario 40? 
SELECT sale_date, SUM(amount) OVER(ORDER BY sale_date ROWS BETWEEN 40 PRECEDING AND CURRENT ROW) FROM daily_sales;
-- Q41: Analytics scenario 41? 
SELECT sale_date, SUM(amount) OVER(ORDER BY sale_date ROWS BETWEEN 41 PRECEDING AND CURRENT ROW) FROM daily_sales;
-- Q42: Analytics scenario 42? 
SELECT sale_date, SUM(amount) OVER(ORDER BY sale_date ROWS BETWEEN 42 PRECEDING AND CURRENT ROW) FROM daily_sales;
-- Q43: Analytics scenario 43? 
SELECT sale_date, SUM(amount) OVER(ORDER BY sale_date ROWS BETWEEN 43 PRECEDING AND CURRENT ROW) FROM daily_sales;
-- Q44: Analytics scenario 44? 
SELECT sale_date, SUM(amount) OVER(ORDER BY sale_date ROWS BETWEEN 44 PRECEDING AND CURRENT ROW) FROM daily_sales;
-- Q45: Analytics scenario 45? 
SELECT sale_date, SUM(amount) OVER(ORDER BY sale_date ROWS BETWEEN 45 PRECEDING AND CURRENT ROW) FROM daily_sales;
-- Q46: Analytics scenario 46? 
SELECT sale_date, SUM(amount) OVER(ORDER BY sale_date ROWS BETWEEN 46 PRECEDING AND CURRENT ROW) FROM daily_sales;
-- Q47: Analytics scenario 47? 
SELECT sale_date, SUM(amount) OVER(ORDER BY sale_date ROWS BETWEEN 47 PRECEDING AND CURRENT ROW) FROM daily_sales;
-- Q48: Analytics scenario 48? 
SELECT sale_date, SUM(amount) OVER(ORDER BY sale_date ROWS BETWEEN 48 PRECEDING AND CURRENT ROW) FROM daily_sales;
-- Q49: Analytics scenario 49? 
SELECT sale_date, SUM(amount) OVER(ORDER BY sale_date ROWS BETWEEN 49 PRECEDING AND CURRENT ROW) FROM daily_sales;
-- Q50: Analytics scenario 50? 
SELECT sale_date, SUM(amount) OVER(ORDER BY sale_date ROWS BETWEEN 50 PRECEDING AND CURRENT ROW) FROM daily_sales;
