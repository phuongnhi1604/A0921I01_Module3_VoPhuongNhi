create database if not exists test;

-- database được sử dụng hiện tại --
use test;

-- Tạo bảng --
create table student(
id int,
`name` varchar(40),
birthday date
);

-- Thêm khóa chính vào bảng --
alter table student add primary key pk_id(id);

-- Thêm cột cho bảng --
alter table student add column `point` int;

-- Hiển thị bảng / Lấy toàn bộ dữ liệu trong bảng --
select * from student;

-- Lấy thông tin theo cột --
select id as ma_sv, name from student;

-- Thêm dữ liệu vào bảng --
insert into student values (1,'nhi','2001-11-20');
insert into student(name, id, birthday) values ('tan',2,'2009-3-8');

-- Sửa dữ liệu --
update student set `name` = 'nhi1' where id=2;

-- Xóa toàn bộ dữ liệu trong bảng student --
delete from student;

-- Xóa bảng student khỏi csdl --
drop table student;

-- Xóa database --
drop database test;








