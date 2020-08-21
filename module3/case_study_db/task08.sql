use furama_v1;

select distinct(fullname) from customer;

select fullname from customer
group by fullname;
-- group by 1;

select fullname from customer
union
select fullname from customer;