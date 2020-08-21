update customer set customer_type_id = 1 where id in (
select distinct(id) from (
select cus.id, c.start_day, c.total_payment + sum(sa.price* cd.quanlity) as total_pay from customer cus
join customer_type ct on cus.customer_type_id=  ct.id
join contract c on cus.id= c.customer_id
join contract_detail cd on c.id= cd.contract_id
join service_accompany sa on cd.service_accompany_id= sa.id
where cus.customer_type_id=2 and year(c.start_day)= 2019
group by c.id
having total_pay >100) as tmp
);