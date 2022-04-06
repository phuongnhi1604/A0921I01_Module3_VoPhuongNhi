create database if not exists furamar_resort;
use furamar_resort; 

drop database furamar_resort;

create table service_type(
service_type_id int primary key auto_increment,
service_type_name varchar(45)
);

insert into service_type values(1,'Villa'),(2,'House'),(3,'Room');

create table rent_type(
rent_type_id int primary key auto_increment,
rent_type_name varchar(45),
rent_type_cost double
);

insert into rent_type values(1,'Year',100000000),(2,'Month',30000000),(3,'Day',6000000),(4,'Hour',400000);

create table service(
service_id int primary key auto_increment,
service_name varchar(45),
service_area double,
service_max_people int,
rent_type_id int,
service_type_id int,
stardard_room varchar(45),
description_other_convenience varchar(100),
pool_area double,
number_of_floors int,
foreign key(rent_type_id) references rent_type(rent_type_id),
foreign key(service_type_id) references service_type(service_type_id)
);


create table customer_type(
customer_type_id int primary key auto_increment,
customer_type_name varchar(45)
);
insert into customer_type values(1,'Diamond'),(2,'Platinium'),(3,'Gold'),(4,'Silver'),(5,'Member');

create table customer(
customer_id int primary key auto_increment,
customer_type_id int,
customer_name varchar(100),
customer_birthday date,
customer_gender bit(1),
customer_id_card varchar(45),
customer_phone varchar(45),
customer_email varchar(50),
customer_address varchar(200),
foreign key(customer_type_id) references customer_type(customer_type_id)
);


create table role(
role_id int primary key auto_increment,
role_name varchar(255)
);

create table `user`(
username varchar(255) primary key,
password varchar(255)
);
create table user_role(
role_id int,
username varchar(255),
foreign key(role_id) references role(role_id),
foreign key(username) references user(username)
);


create table `position`(
position_id int primary key auto_increment,
position_name varchar(45)
);
insert into `position` values(1,'Le Tan'),(2,'Phuc Vu'),(3,'Chuyen Vien'),(4,'Giam Sat'),(5,'Quan Ly'),(6,'Giam Doc');

create table education_degree(
education_degree_id int primary key auto_increment,
education_degree_name varchar(45)
);
insert into education_degree values(1,'Trung Cap'),(2,'Cao Dang'),(3,'Dai Hoc'),(4,'Sau Dai Hoc');


create table division(
division_id int primary key auto_increment,
division_name varchar(45)
);
insert into division values(1,'Sale - Marketing'),(2,'Hanh Chinh'),(3,'Phuc Vu'),(4,'Quan Ly');

create table employee(
employee_id int primary key auto_increment,
employee_name varchar(100),
employee_birthday date,
employee_id_card varchar(45),
employee_salary double,
employee_phone varchar(45),
employee_email varchar(50),
position_id int,
education_degree_id int,
division_id int,
username varchar(255),
foreign key(position_id) references `position`(position_id),
foreign key(education_degree_id) references education_degree(education_degree_id),
foreign key(division_id) references division(division_id),
foreign key(username) references `user`(username)
);

create table attach_service(
attach_service_id int primary key auto_increment,
attach_service_name varchar(100),
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


