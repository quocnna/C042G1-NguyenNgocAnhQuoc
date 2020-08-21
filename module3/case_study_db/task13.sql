select sa.name, count(cd.contract_id) as num_of_booking from service_accompany sa
join contract_detail cd on sa.id= cd.service_accompany_id
join contract c on cd.contract_id= c.id
join customer cus on c.customer_id= cus.id
group by sa.name
order by count(cd.contract_id) desc
limit 1;

-- create table if not exists mostused
-- 	select contract_id, attach_service_name, attach_service_id, count(*) as amount
-- 	from attachservices
-- 	join contractdetails using(attach_service_id)
--     join contracts using(contract_id)
-- 	group by attach_service_name;

-- select attach_service_name, amount
-- from mostused
-- where amount in (select max(amount) from mostused);
-- #drop table mostused
-- ;