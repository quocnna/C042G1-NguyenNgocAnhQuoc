select id, fullname, email, phone, birthday, address, 'employee' as type from employee
union
select id, fullname, email, phone, birthday, address, 'customer' from customer;