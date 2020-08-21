use furama_v1;

select * from customer
where year(now())- year(birthday) between 18 and 50
and address= 'Da Nang' or address= 'Quang Tri';

-- select * from customer
-- where timestampdiff(year, birthday, curdate()) between 18 and  50 and address in ('Da Nang', 'Quang Tri');