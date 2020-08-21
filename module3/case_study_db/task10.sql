select c.id, c.start_day, c.end_day, c.down_payment, count(cd.contract_id) as num_of_accom_service from contract c
join contract_detail cd on c.id= cd.contract_id
group by cd.contract_id;
-- group by and count diff group by not count; because of bug ambiguos id so use alias 

