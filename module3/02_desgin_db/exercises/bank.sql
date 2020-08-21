create database if not exists bank;
use bank;

create table customer(
id int not null,
full_name varchar(50),
address varchar(50),
email varchar(50),
phone varchar(50),
primary key (id)
);

create table account_type(
id int primary key not null,
name varchar(50)
);

create table account(
id int not null,
account_type varchar(50),
date datetime,
balance double,
customer_id int,
account_type_id int,
primary key (id),
foreign key (customer_id) references customer (id),
foreign key (account_type_id) references account_type (id)
);

create table transaction(
id int not null,
date datetime,
amount double,
description varchar(100),
account_id int,
primary key (id),
foreign key (account_id) references account (id)
);