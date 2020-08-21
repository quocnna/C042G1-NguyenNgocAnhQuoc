select * from service_accompany sa
join contract_detail cd on sa.id= cd.service_accompany_id
join contract c on cd.contract_id= c.id
join customer cus on c.customer_id= cus.id
join customer_type ct on cus.customer_type_id= ct.id
where ct.name= 'diamond' and cus.address in ('Vinh','Da Nang');