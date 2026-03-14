# Test 7: Views, Triggers & Auditing

## 1. Views
A View is a "Virtual Table." It doesn't store data itself; it stores a **Select Query**. 
- **Use Case**: Give a View to the Frontend team so they don't have to write complex 5-table JOINs every time. They just call `SELECT * FROM my_view`.

## 2. Triggers
A Trigger is a script that "Fires" automatically when a specific event (INSERT, UPDATE, DELETE) happens.
- **Auditing**: Excellent for recording who changed what.
- **Data Integrity**: Use `BEFORE INSERT` (Q8) to double-check data rules that are too complex for a standard constraint.

## 3. Warning!
Don't overuse triggers. Since they run "behind the scenes," they can make debugging very difficult because things change in the database that aren't visible in the application code!
