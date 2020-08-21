delete from employee
where id not in(
		select id from(
        -- can't specify target table
		select distinct e.id
        from employee e
        join contract c on e.id= c.employee_id
        where year(c.start_day) between 2017 and 2020
        ) as tmp
);

-- update employee e join contract c on e.id= c.employee_id set e.name= 'abc';
--  You can't specify target table 'e' for update in FROM clause
-- cannot using the same update (delete from employee e join contract c on e.id= c.employee_id;) canot join