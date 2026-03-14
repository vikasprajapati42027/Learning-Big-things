-- 1. Standard CTE for readability
WITH RegionalSales AS (
    SELECT region, SUM(amount) as total_sales
    FROM orders
    GROUP BY region
)
SELECT region, total_sales
FROM RegionalSales
WHERE total_sales > (SELECT AVG(total_sales) FROM RegionalSales);

-- 2. Recursive CTE (Generating a hierarchy or numbers)
WITH RECURSIVE CategoryPath AS (
    SELECT id, name, parent_id, name AS path
    FROM categories WHERE parent_id IS NULL
    UNION ALL
    SELECT c.id, c.name, c.parent_id, CONCAT(cp.path, ' > ', c.name)
    FROM categories c
    JOIN CategoryPath cp ON cp.id = c.parent_id
)
SELECT * FROM CategoryPath;
