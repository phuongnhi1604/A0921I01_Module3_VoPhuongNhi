create database if not exists furamar_resort;
use furamar_resort; 

create table service_type(
service_type_id int primary key auto_increment,
service_type_name varchar(45)
);

create table rent_type(
rent_type_id int primary key auto_increment,
rent_type_name varchar(45),
rent_type_cost double
);

create table service(
service_id int primary key auto_increment,
service_name varchar(45),
service_area double,
service_max_people int,
rent_type_id int,
service_type_id int,
stardard_room varchar(45),
description_other_convenience varchar(45),
pool_area double,
number_of_floors int,
foreign key(rent_type_id) references rent_type(rent_type_id),
foreign key(service_type_id) references service_type(service_type_id)
);

create table customer_type(
customer_type_id int primary key auto_increment,
customer_type_name varchar(45)
);

create table customer(
customer_id int primary key auto_increment,
customer_type_id int,
customer_name varchar(45),
customer_birthday date,
customer_gender bit(1),
customer_id_card varchar(45),
customer_phone varchar(45),
customer_email varchar(45),
customer_address varchar(45),
foreign key(customer_type_id) references customer_type(customer_type_id)
);

create table role(
role_id int primary key auto_increment,
role_name varchar(255)
);

create table `user`(
username varchar(255),
password varchar(255)
);
create table user_role(
role_id int,
username varchar(255),
foreign key(role_id) references role(role_id),
foreign key(username) references user(username)
);

create table user(
username varchar(255),
password varchar(255)
);

create table `position`(
position_id int primary key auto_increment,
position_name varchar(45)
);

create table education_degree(
education_degree_id int primary key auto_increment,
education_degree_name varchar(45)
);

create table division(
division_id int primary key auto_increment,
division_name varchar(45)
);

create table attach_service(
attach_service_id int primary key auto_increment,
attach_service_name varchar(45),
attach_service_cost double,
attach_service_unit int,
attach_service_status varchar(45)
);

create table contract(
contract_id int primary key auto_increment,
contract_start_day datetime,
contract_end_day datetime,
contract_deposit double,
contract_total_money double,
employee_id int,
customer_id int,
service_id int,
foreign key(employee_id) references employee(employee_id),
foreign key(customer_id) references customer(customer_id),
foreign key(service_id) references service(service_id)
);

create table contract_detail(
contract_detail_id int primary key auto_increment, 
contract_id int,
attach_service_id int,
quantity int,
foreign key(attach_service_id) references attach_service(attach_service_id),
foreign key(contract_id) references contract(contract_id)
);


