select c.id 'contract_id', ser.name 'service_name', sa.name 'acc_service_name', count(cd.contract_id) as num_used from service_accompany sa
join contract_detail cd on sa.id= cd.service_accompany_id
join contract c on cd.contract_id= c.id
join service ser on c.service_id= ser.id
group by sa.name
having count(cd.contract_id)=1;