create database sample_db;
use sample_db;
 
create table person_course(
id int primary key auto_increment,
name varchar(50) not null,
age int not null,
course varchar(50) not null,
price double not null
);

insert into person_course (name,age,course,price) 
values ('Hoang',20,'C#',200),
 ('Viet',22,'Java',500),
 ('Quoc',35,'PHP',800),
 ('Long',21,'C++',100),
 ('Tuan',40,'Python',2000),
 ('Vinh',25,'Koltin',300),
 ('Dung',20,'Swiff',600),
 ('Hoang',20,'C#',800);
 
 select * from person_course
 where name='Hoang';
 
 select name, sum(price) from person_course
 where name= 'Hoang';
 
 select distinct name from person_course;