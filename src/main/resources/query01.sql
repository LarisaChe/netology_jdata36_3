SELECT o.product_name
FROM jdata36.customers c INNER JOIN jdata36.orders o ON c.id = o.customer_id
WHERE LOWER(c.name) = LOWER(:paramName);