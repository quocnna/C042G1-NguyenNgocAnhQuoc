use furama_v1;

SET sql_mode=(SELECT REPLACE(@@sql_mode,'ONLY_FULL_GROUP_BY',''));
-- SET sql_mode=(SELECT CONCAT(@@sql_mode,'ONLY_FULL_GROUP_BY',''));
-- set sql_safe_updates = 0;

select cus.id, cus.fullname,ct.name, con.id, ser.name, con.start_day, con.end_day, count(con.customer_id) 'number order', sum(ser.price+ sac.price*ctd.quanlity) 'total' from customer cus
left join customer_type ct
on cus.customer_type_id= ct.id
left join contract con
on cus.id = con.customer_id
left join service ser
on con.service_id= ser.id
left join contract_detail ctd
on con.id= ctd.contract_id
left join service_accompany sac
on ctd.service_accompany_id= sac.id
group by cus.fullname;