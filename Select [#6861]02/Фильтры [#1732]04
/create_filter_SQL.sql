CREATE TABLE type(
id SERIAL PRIMARY KEY,
name VARCHAR(255)
);

CREATE TABLE product(
id SERIAL PRIMARY KEY,
name VARCHAR(255),
type_id INT REFERENCES type(id),
expired_date boolean,
price FLOAT
);

SELECT p.name
FROM product AS p
JOIN type AS t
ON p.type_id = t.id
WHERE t.name = 'сыр';

SELECT p.name
FROM product AS p
WHERE p.name LIKE 'Мороженное%';

SELECT p.name
FROM product AS p
WHERE expired_date IN (true);

SELECT max(p.price)
FROM product AS p;

SELECT t.name AS "имя_типа", sum(p.id) AS "количество"
FROM product AS p
JOIN type AS t
ON p.type_id = t.id
GROUP BY t.name;

SELECT type.name AS "имя_типа", count(*) AS "количество"
FROM product AS p
JOIN type ON p.type_id = type.id
GROUP BY type.id;


SELECT p.name
FROM product AS p
JOIN type AS t
ON p.type_id = t.id
WHERE t.name
IN ('сыр', 'молоко');

SELECT *
FROM product AS p
JOIN type AS t
ON p.type_id = t.id;

SELECT *
FROM product , type
WHERE type_id = type.id;
