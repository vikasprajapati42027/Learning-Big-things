# Test 2: The 50-Query Analytics Challenge

## 1. The Power of OVER()
Window functions are the difference between a "Query Writer" and an "Analytics Expert". They allow you to look at "neighbors" (LAG/LEAD) and "hierarchies" (RANK) without breaking the rows into groups.

## 2. Advanced Multi-Table Logic
This test uses 4 primary tables: `Employees`, `Products`, `Daily_Sales`, and `Reviews`. By joining 2 or 3 tables, you can answer complex questions like:
- "What is the average profit per sale per employee?" (Q23)
- "Which products have been sold in every department?" (Q43)

## 3. Top Interview Challenges Included:
- **The Islands Problem (Q30)**: Using `DATE_SUB` and `ROW_NUMBER` to find consecutive streaks of activity. This is a very common senior-level SQL interview question.
- **Outlier Detection (Q40/Q49)**: Identifying anomalies using subqueries or **Z-Scores** (Standard Deviation). 
- **Pivot Tables (Q50)**: Using `SUM(CASE WHEN...)` to transform rows into columns for financial reporting.

## 4. Why 50 Queries?
Repetition builds muscle memory. By doing 50 variations of Window functions across multiple tables, you will be able to handle any high-level ETL or Data Engineering task.
