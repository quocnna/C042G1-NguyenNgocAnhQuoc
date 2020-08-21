use furama_v1;

select any_value(cus.fullname) 'customer name', count(cus.fullname) as number_booking from customer cus
inner join customer_type ct
on cus.customer_type_id= ct.id
inner join contract con
on cus.id= con.customer_id
where ct.name= 'diamond'
group by cus.fullname
order by number_booking;

