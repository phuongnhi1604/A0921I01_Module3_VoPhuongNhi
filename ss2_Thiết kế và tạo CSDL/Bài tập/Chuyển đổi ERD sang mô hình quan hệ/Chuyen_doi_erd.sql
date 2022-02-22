create database if not exists quanlydonhang;
use quanlydonhang;

create table PhieuXuat(
SoPX varchar(20) not null primary key,
NgayXuat date
);

create table VatTu(
MaVTU varchar(20) not null primary key,
TenVTU varchar(200)
);

create table PhieuNhap(
SoPN varchar(20) not null primary key,
NgayNhap date
);

create table Xuat(
SoPX varchar(20),
MaVTU varchar(20),
DGXuat int,
SLXuat int,
primary key(SoPX, MaVTU),
foreign key(SoPX) references PhieuXuat(SoPX),
foreign key(MaVTU) references VatTu(MaVTU)
);

create table Nhap(
SoPN varchar(20),
MaVTU varchar(20),
DGNhap int,
SLNhap int,
primary key(SoPN, MaVTU),
foreign key(SoPN) references PhieuNhap(SoPN),
foreign key(MaVTU) references VatTu(MaVTU)
);
create table SDT(
MaSDT int auto_increment primary key,
MaVung int,
Sdt varchar(20)
);

create table NhaCC(
MaNCC varchar(20) primary key,
TenNCC varchar(200),
DiaChi varchar(200),
Sdt int,
foreign key(Sdt) references SDT(MaSDT)
);

create table DonDH(
SoDH varchar(20) not null primary key,
NgayDH date,
NCC varchar(20),
foreign key(NCC) references NhaCC(MaNCC)
);

create table DatHang(
MaVTU varchar(20),
SoDH varchar(20),
primary key(MaVTU, SoDH),
foreign key(MaVTU) references VatTu(MaVTU),
foreign key(SoDH) references DonDH(SoDH)
);

