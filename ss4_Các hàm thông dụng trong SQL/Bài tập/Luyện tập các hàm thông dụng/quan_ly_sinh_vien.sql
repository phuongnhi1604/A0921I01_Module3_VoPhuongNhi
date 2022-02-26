use quanlysinhvien;

-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất --
select *, max(Credit) from `subject`;

-- Hiển thị các thông tin môn học có điểm thi lớn nhất. --
select sub.SubID ,sub.SubName, max(m.mark) from `subject` as sub join mark as m on sub.subID=m.SubID;

-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần --
select s.StudentID,s.StudentName,s.Address,s.Phone,s.Status,s.ClassID, avg(m.Mark) as DTB from student as s, mark as m
where s.StudentID = m.StudentID
group by s.StudentID
order by DTB desc;

