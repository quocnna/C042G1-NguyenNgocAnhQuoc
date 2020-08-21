use classicmodels;

select * from products;

SELECT count(productCode) FROM products;

select sum(buyPrice) from products;

select max(buyPrice) from products;

select min(buyPrice) from products;

select avg(buyPrice) from products;

select round(buyPrice) from products;


-- in function cannot SELECT or EXECUTE like PROCEDURE

-- CREATE FUNCTION hello (s CHAR(20))
--   RETURNS CHAR(50) DETERMINISTIC
--   RETURN CONCAT('Hello, ',s,'!');
--   
--   SELECT hello('Susan') AS 'greeting';


delimiter //
create function testf(s varchar(20))
returns varchar(20) no sql
begin
declare res varchar(20);
set res= concat(s,'haha');
-- select fullname from customer where id=2;
-- Error Code: 1415. Not allowed to return a result set from a function
return trim(res);
end
// delimiter ;
select testf('quoc') as aa;

-- FUNCTION restrict more than sp
-- Dynamic SQL is not allowed in stored function or trigger 
-- This function has none od DETERMINISTIC, NO SQL, or READ SQL DATA in its declaration and binary logging is enabled (you *might* want to use less safe log.)
-- SET GLOBAL log_bin_trust_function_creators = 1;