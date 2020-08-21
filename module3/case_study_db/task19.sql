update service_accompany set price= price*10 where id in (
select distinct(id) from(
select sa.id, sa.price, count(sa.name) as num_book from service_accompany sa
join contract_detail cd on sa.id= cd.service_accompany_id
join contract co on cd.contract_id= co.id
where year(co.start_day)=2019
group by sa.name
having num_book>2) as tmp
);