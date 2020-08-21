select e.id 'employee_id', c.id 'contract_id',  e.fullname 'employee_name', d.name 'degree_name', dep.name 'department_name', e.phone, e.address, count(c.id) as num_of_contract from employee e
join degree d on e.degree_id= d.id
join department dep on e.department_id= dep.id
join contract c on e.id= c.employee_id
where year(c.start_day) between 2018 and 2019
group by e.id
having num_of_contract<=3
