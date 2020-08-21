use furama_v1;

select * from service ser
join service_type st
on ser.service_type_id= st.id
join contract con
on ser.id= con.service_id
-- where year(con.start_day)=2018 and year(con.start_day) not in (
-- 	select year(start_day) from contract
--     where year(start_day)=2019
-- );
where year(con.start_day)= 2018 and ser.id not in(
	select service_id from contract
    where start_day=2019
);