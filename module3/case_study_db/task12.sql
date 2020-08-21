select c.id, e.fullname 'employee', cus.fullname 'customer', cus.phone 'customer_phone', ser.name 'service name', count(cd.contract_id) as num_of_accom_service, sum(c.down_payment) 'total down payment' from contract c
join employee e on c.employee_id= e.id
join customer cus on c.customer_id= cus.id
join contract_detail cd on c.id= cd.contract_id
join service ser on c.service_id= ser.id
where month(c.start_day) between 10 and 12 and c.service_id not in (
	select service_id from contract
    where month(start_day) between 1 and 9
    )
group by cd.contract_id;
