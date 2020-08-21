use furama_v1;

select * from employee
-- where substring_index(fullname,' ',-1) regexp binary '^[HKT]' and fullname regexp binary '^.{0,15}$';
where substring_index(fullname,' ',-1) regexp binary '^[HKT]' and length(fullname) <=15;

-- select right(fullname, locate(' ', reverse(fullname)) ) from employee;
-- select right(fullname, position(' ' in reverse(fullname))) from employee;
select SUBSTRING_INDEX(fullname, ' ', -1) from employee;
-- select trim(replace(fullname,SUBSTRING_INDEX(fullname, ' ', LENGTH(fullname)- LENGTH(REPLACE(fullname,' ',''))),'')) from employee;