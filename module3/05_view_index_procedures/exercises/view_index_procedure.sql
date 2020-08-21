create database if not exists exercise05;
use exercise05;


create table product(
id int primary key not null auto_increment,
code varchar(50),
name varchar(50),
price double,
amount int,
description varchar(100),
status tinyint
);


insert into product (code,name,price,amount,description,status) values
('code1','name1',1,1,'description1',0),
('code2','name2',2,2,'description1',0),
('code3','name3',3,3,'description1',0),
('code4','name4',4,4,'description1',0),
('code5','name5',5,5,'description1',0),
('code6','name6',6,6,'description1',0),
('code7','name7',7,7,'description1',0),
('code8','name8',8,8,'description1',0);



create unique index product_index on product(code);
create index composite_index_name_price on product(name,price);



explain select * from product
where code='code1';

explain select * from product
where name='name1' and price=1;



create view productView as
select code, name, price, status
from product;

rename table productView to product_view;
drop view product_view;


delimiter //
create procedure allproduct()
begin
select * from product;
end
// delimiter ;
call allproduct();


delimiter //
create procedure add_new_product(pcode varchar(50),pname varchar(50),pprice double, pamount int, pdescription varchar(100), pstatus tinyint)
begin
insert into product (code,name,price,amount,description,status) values
(pcode,pname,pprice,pamount,pdescription,pstatus);
end
// delimiter ;
call add_new_product('newcode','newname',8,8,'newdescription',1);


delimiter //
create procedure update_product_by_id(pid int,pcode varchar(50),pname varchar(50),pprice double, pamount int, pdescription varchar(100), pstatus tinyint)
begin
update product
set name=pname,code=pcode,price=pprice,amount=pamount,description=pdescription,status=pstatus
where id=pid;
end
// delimiter ;
call update_product_by_id(1,'editcode','editname',9,9,'editdescription',1);


delimiter //
create procedure delete_product_by_id(pid int)
begin
delete from product
where id=pid;
end
// delimiter ;
call delete_product_by_id(2);


select * from product;