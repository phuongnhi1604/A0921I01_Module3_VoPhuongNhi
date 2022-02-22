create database if not exists student_management;
use student_management;

-- Tạo bảng Class --
create table Class(
id int primary key,
`name` varchar(50)
);

-- Hiển thị toàn bộ bảng Class --
select * from Class;

-- Thêm dữ liệu vào bảng --
insert into Class value(1,'a09');
insert into Class value(2,'a08');
insert into Class value(3,'a07');

-- Sửa dữ liệu name của id = 1 --
update Class set `name` = 'a0921i01' where id=1;

-- Xóa cột có id = 3 --
delete from Class where id=3;

-- Tạo bảng Teacher --
create table Teacher(
id int primary key,
`name` varchar(50),
age int,
country varchar(30)
);

-- Hiển thị bảng Teacher --
select * from Teacher;

-- Hiển thị cột id, name --
select id,name from Teacher;

-- Thêm dữ liệu vào bảng --
insert into Teacher(id,name,age,country) values(1,'nhi',20,'VietNam');
insert into Teacher(id,name,age,country) values(2,'tan',21,'VietNam');

-- Sửa dữ liệu age của id = 1;
update Teacher set age = 21 where id = 1;

-- XÓA TOÀN BỘ DỮ LIỆU CỦA CÁC BẢNG --
delete from Class;
delete from Teacher;

-- XÓA CSDL --
drop database student_management;








