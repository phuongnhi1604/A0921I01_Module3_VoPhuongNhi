use quanlysinhvien;

select * from student where StudentName like 'h%';

select * from class where month(StartDate) = '12';

select * from `subject` where Credit>=3 and Credit<=5;

select * from student;
update student set ClassID = '2' where StudentName = 'Hung';




  