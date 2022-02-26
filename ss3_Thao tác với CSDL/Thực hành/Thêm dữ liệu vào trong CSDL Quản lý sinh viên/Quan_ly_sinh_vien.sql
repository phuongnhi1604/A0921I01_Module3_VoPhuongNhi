use quanlysinhvien;

insert into class values(1,'A1','2008-12-20',1);
insert into class values(2,'A2','2008-12-22',1);
insert into class values(3,'A3',current_date(),0);

insert into student (StudentName,Address,Phone,`Status`,ClassID)
values ('Hung','Ha Noi','0912113113',1,1);
insert into student (StudentName,Address,`Status`,ClassID)
values ('Hoa','Hai Phong',1,1);
insert into student (StudentName,Address,Phone,`Status`,ClassID)
values ('Manh','HCM','0123123123',0,2);

insert into `subject` values(1,'CF',5,1),(2,'C',6,1),(3,'HDJ',5,1),(4,'RDBMS',10,1);

insert into mark(SubId,StudentID, Mark, ExamTimes)
values (1,1,8,1),(1,2,10,2),(2,1,12,1);

select * from class;
select * from student;
select * from `subject`;
select * from mark;

