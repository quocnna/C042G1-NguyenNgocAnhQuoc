use furama_v1;

select ser.id, ser.name, ser.area, ser.price, st.name from service ser
join service_type st
on ser.service_type_id= st.id
where ser.id not in(
	select con.service_id from contract con
	join service on con.service_id = service.id
	where con.start_day > '2019-03-31');