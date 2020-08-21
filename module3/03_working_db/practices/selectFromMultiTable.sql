use classicmodels;

select c.customerNumber, c.customerName, c.phone, p.paymentDate, p.amount
from customers c
inner join payments p
on c.customerNumber= p.customerNumber
where c.city= 'Las Vegas';

select customers.customerNumber, customers.customerName, orders.orderNumber, orders.status
from customers
left join orders
on customers.customerNumber = orders.customerNumber; 

select customers.customerNumber, customers.customerName, orders.orderNumber, orders.status
from customers LEFT JOIN orders
on customers.customerNumber = orders.customerNumber
where orderNumber is null
