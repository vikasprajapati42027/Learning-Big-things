# Test 4: Subqueries & Derived Tables

## 1. Simple Explanation
A Subquery is a query inside another query. The "Inner" query runs first and gives the result to the "Outer" query.

## 2. Key Techniques
- **Correlated Subquery (Q4)**: Unlike normal subqueries, this one runs for **every row** in the outer query. It's powerful but can be slow if not indexed correctly.
- **EXISTS vs IN**: Use `EXISTS` (Q5) when you just need to check if a record exists. It stops searching as soon as it finds one match!
- **Derived Tables (Q6)**: This treats a `SELECT` result as a temporary table. 

## 3. Tip for Clean Code
If your subqueries are becoming too complex, use **CTEs (WITH clause)**. They are exactly like subqueries but much easier for humans to read.
