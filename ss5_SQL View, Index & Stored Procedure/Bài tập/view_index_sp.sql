create database if not exists demo;
use demo;

create table products(
id int primary key auto_increment,
productCode varchar(15),
productName varchar(50),
productPrice double,
productAmount int,
productDesciption varchar(200),
productStatus varchar(50)
);

insert into products(productCode,productName,productPrice,productAmount,productDesciption,productStatus)
values('LNV002','Laptop Lenovo',15000000,1,'Core i7','Còn hàng'),
('LGT242','Tivi LG',8000000,2,'32 inchs','Còn hàng');

-- Index --
select productCode from products;
alter table products add index idx_productCode(productCode);
explain select productCode from products;

select productName,productPrice from products;
alter table products add index idx_productDetail(productName,productPrice);
explain select productName,productPrice from products;

alter table products drop index idx_productCode;
alter table products drop index idx_productDetail;


-- View --
create view product_views as
select productCode, productName, productPrice,productStatus
from products;
select * from product_views;

create or replace view product_view as
select productCode, productName, productPrice,productStatus
from products
where productStatus = 'Còn hàng';
select * from product_views;

drop view product_views;


-- Store procedure --
DELIMITER //
CREATE PROCEDURE getProduct()
BEGIN
  SELECT * FROM products;
END //
DELIMITER ;
call getProduct();

DELIMITER //
CREATE PROCEDURE insertProduct()
BEGIN
insert into products(productCode,productName,productPrice,productAmount,productDesciption,productStatus)
values('AS302','Laptop Asus',20000000,1,'Core i7','Hết hàng');
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE updateProduct()
BEGIN
  update products set productAmount=3 where id=1;
END //
DELIMITER ;
call updateProduct();

DELIMITER //
CREATE PROCEDURE deleteProduct()
BEGIN
  delete from products where id=3;
END //
DELIMITER ;
call deleteProduct();
