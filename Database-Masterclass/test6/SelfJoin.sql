-- Boss-Employee Relationship
SELECT e.name as Employee, m.name as Manager
FROM employees e
LEFT JOIN employees m ON e.manager_id = m.id;
