# Test 8: Stored Procedures & Functions

## 1. Stored Procedure vs Function
- **Procedure**: Used for **Actions** (Update multiple tables, run a transaction). It can return many values via `OUT` parameters.
- **Function**: Used for **Calculations**. It returns exactly ONE value and can be used directly inside a `SELECT` statement (Q5).

## 2. When to use them?
- **Security**: You can give a user permission to "CALL my_proc" but REVOKE permission to "SELECT from my_table." This forces them to go through your logic.
- **Performance**: Instead of sending 10 Java strings over the network, you send 1 "CALL" command, and the SQL runs natively on the DB server.

## 3. The "ProcessSale" Case (Q6)
This is a standard Senior interview question. Put your transaction inside a procedure so that if the DB has stock, it commits; otherwise, it rolls back instantly without the Application having to decide.
