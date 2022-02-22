create database if not exists quanlybanhang;
use quanlybanhang;

create table Customer(
cID int auto_increment primary key,
cName varchar(200),
cAge int
);

create table `Order`(
oID int auto_increment primary key,
cID int,
oDate date,
oTotalPrice long,
foreign key(cID) references Customer(cID)
);

create table Product(
pID int auto_increment primary key,
pName varchar(50),
pPrice int
);
create table OrderDetail(
oID int,
pID int,
odQTY int,
primary key(oID,pID),
foreign key(oID) references `Order`(oID),
foreign key(pID) references Product(pID)
);
