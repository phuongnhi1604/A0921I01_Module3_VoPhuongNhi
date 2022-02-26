use quanlybanhang;

insert into customer values(1,'Minh Quan',10);
insert into customer values(2,'Ngoc oanh',20);
insert into customer values(3,'Hong Ha',50);
select * from customer;

insert into `order`(oID,cID,oDate) values(1,1,'2006-03-21');
insert into `order`(oID,cID,oDate) values(2,2,'2006-03-23');
insert into `order`(oID,cID,oDate) values(3,1,'2006-03-16');
select * from `order`;

insert into product values(1,'May Giat',3);
insert into product values(2,'Tu Lanh',5);
insert into product values(3,'Dieu Hoa',7);
insert into product values(4,'Quat',1);
insert into product values(5,'Bep Dien',2);
select * from product;

insert into orderdetail values(1,1,3);
insert into orderdetail values(1,3,7);
insert into orderdetail values(1,4,2);
insert into orderdetail values(2,1,1);
insert into orderdetail values(3,1,8);
insert into orderdetail values(2,5,4);
insert into orderdetail values(2,3,3);
select * from orderdetail;

-- Hiển thị các thông tin  gồm oID, oDate, oTotalPrice của tất cả các hóa đơn trong bảng Order --
select oID, oDate, oTotalPrice from `order`;

-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách --
select * from customer as c, product as p
where c.cID in (select cID from `order`)
order by c.cID asc;

-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào --
select * from customer as c
where c.cID not in (select cID from `order`);

-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn. Giá bán của từng loại được tính = odQTY*pPrice)--
select o.oID, o.oDate, sum(od.odQTY * p.pPrice) as gia_tien 
from ((`order` as o join orderdetail as od on o.oID = od.oID) join product as p on od.pID = p.pID)
group by o.oID; 
