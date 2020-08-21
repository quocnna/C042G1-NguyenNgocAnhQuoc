use furama_v1;
SET sql_mode=(SELECT REPLACE(@@sql_mode,'ONLY_FULL_GROUP_BY',''));

drop temporary table if exists statistics; 
create temporary table statistics (
	id int auto_increment primary key,
    month varchar(10) not null unique
);
insert into statistics values (1, 'Jan'),(2, 'Feb'),(3, 'Mar'),(4, 'Apr'),(5, 'May'),(6, 'Jun'),(7, 'Jul'),(8, 'Aug'),(9, 'Sep'),(10, 'Oct'),(11, 'Nov'),(12, 'Dec');

-- select s.month, count(c.customer_id) as no_booking, sum(c.total_payment) as total from statistics s
-- left join contract c on s.id= month(c.start_day)
-- where year(c.start_day)=2019
-- -- where is filter condition after join, so left is useless
-- group by s.id
-- order by s.id;

-- select s.month, count(c.customer_id) as no_booking, sum(c.total_payment) as total from statistics s
-- left join contract c on s.id= month(c.start_day)
-- group by s.id
-- order by s.id;

select s.month as Month, ifnull(temp.NoOfCustomers,0) as NoOfCustomers, ifnull(temp.revenue,0) as Revenue from statistics s
left join(
	select month(c.start_day) as month, count(c.customer_id) as NoOfCustomers, sum(c.total_payment) as revenue from contract c
    where year(c.start_day)=2019
    group by month
    -- if not have groupby, it will defaut groupby with column count()
) as temp
on s.id= temp.month
order by s.id;


-- select statistics.month, ifnull(temp.contract_id, 0) as contract_id, ifnull(temp.NoOfCustomers, 0) as NoOfCustomers, ifnull(temp.revenue, 0) as `revenue`
-- from statistics
-- left join (
-- 	select date_format(contracts.contract_start_date, '%b') as month, contracts.contract_id, count(contracts.customer_id) as `NoOfCustomers`, sum(Tong) as `revenue`
-- 	from contracts
-- 	join customers on contracts.customer_id = customers.customer_id
--     join customerpercontract using(contract_id)
-- 	where year(contracts.contract_start_date) = 2019
-- 	group by month) as temp
-- using(month)
-- -- using(month)
-- -- using keyword have to the same type data
-- order by statistics.id;