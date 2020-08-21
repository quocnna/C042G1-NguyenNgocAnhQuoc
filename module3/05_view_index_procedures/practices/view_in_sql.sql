use classicmodels;

CREATE VIEW customer_views AS
SELECT customerNumber, customerName, phone
FROM  customers;

DROP VIEW customer_views;

select * from customer_views;

CREATE OR REPLACE VIEW customer_views AS
SELECT customerNumber, customerName, contactFirstName, contactLastName, phone
FROM customers
WHERE city = 'Nantes';

select * from customer_views;