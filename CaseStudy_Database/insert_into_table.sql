use furama;

-- THÊM THÔNG TIN VÀO CÁC BẢNG

insert into vi_tri(ten_vi_tri) value('Quản Lý');
insert into vi_tri(ten_vi_tri) value('Nhân Viên');
select * from vi_tri;

insert into trinh_do(ten_trinh_do) value('Trung Cấp');
insert into trinh_do(ten_trinh_do) value('Cao Đẳng');
insert into trinh_do(ten_trinh_do) value('Đại Học');
insert into trinh_do(ten_trinh_do) value('Sau Đại Học');
select * from trinh_do;

insert into bo_phan(ten_bo_phan) value('Sale-Marketing');
insert into bo_phan(ten_bo_phan) value('Hành Chính');
insert into bo_phan(ten_bo_phan) value('Phục Vụ');
insert into bo_phan(ten_bo_phan) value('Quản Lý');
select * from bo_phan;

insert into nhan_vien(ho_ten,ngay_sinh,cmnd,luong,sdt,email,dia_chi,ma_trinh_do,ma_vi_tri,ma_bo_phan) values('Nguyễn Văn An','1970-11-07',
'456231786',10000000,'0901234121','annguyen@gmail.com','295 Nguyễn Tất thành, Đà Nẵng',3,1,1);
insert into nhan_vien(ho_ten,ngay_sinh,cmnd,luong,sdt,email,dia_chi,ma_trinh_do,ma_vi_tri,ma_bo_phan) values('Lê Văn Bình','1997-04-09',
'654231234',7000000,'0934212314','binhlv@gmail.com','22 Yên Bái, Đà Nẵng',2,1,2);
insert into nhan_vien(ho_ten,ngay_sinh,cmnd,luong,sdt,email,dia_chi,ma_trinh_do,ma_vi_tri,ma_bo_phan) values('Hồ Thị Yến','1995-12-12',
'999231723',14000000,'0412352315','thiyen@gmail.com','K234/11 Điện Biên Phủ, Gia Lai',3,1,2);
update nhan_vien set dia_chi='K234/11 Điện Biên Phủ, Gia Lai' where ma_nhan_vien=3;
insert into nhan_vien(ho_ten,ngay_sinh,cmnd,luong,sdt,email,dia_chi,ma_trinh_do,ma_vi_tri,ma_bo_phan) values('Võ Công Toản','1980-04-04',
'123231365',17000000,'0374443232','toan0404@gmail.com','77 Hoàng Diệu, Quảng Trị',4,1,4);
insert into nhan_vien(ho_ten,ngay_sinh,cmnd,luong,sdt,email,dia_chi,ma_trinh_do,ma_vi_tri,ma_bo_phan) values('Nguyễn Bỉnh Phát','1999-12-09',
'454363232',6000000,'0902341231','phatphat@gmail.com.com','43 Yên Bái, Đà Nẵng',1,2,1);
insert into nhan_vien(ho_ten,ngay_sinh,cmnd,luong,sdt,email,dia_chi,ma_trinh_do,ma_vi_tri,ma_bo_phan) values('Khúc Nguyễn An Nghi','2000-11-08',
'964542311',7000000,'0978653213','annghi20@gmail.com','294 Nguyễn Tất Thành, Đà Nẵng',2,2,3);
insert into nhan_vien(ho_ten,ngay_sinh,cmnd,luong,sdt,email,dia_chi,ma_trinh_do,ma_vi_tri,ma_bo_phan) values('Nguyễn Hữu Hà','1993-01-01',
'534323231',8000000,'0941234553','nhh0101@gmail.com','295 Nguyễn Tất thành, Đà Nẵng',3,2,2);
insert into nhan_vien(ho_ten,ngay_sinh,cmnd,luong,sdt,email,dia_chi,ma_trinh_do,ma_vi_tri,ma_bo_phan) values('Nguyễn Hà Đông','1989-09-03',
'234414123',9000000,'0642123111','donghanguyen@gmail.com','111 Hùng Vương, Hà Nội',4,2,4);
insert into nhan_vien(ho_ten,ngay_sinh,cmnd,luong,sdt,email,dia_chi,ma_trinh_do,ma_vi_tri,ma_bo_phan) values('Tòng Hoang','1982-09-03',
'256781231',6000000,'0245144444','hoangtong@gmail.com','213 Hàm Nghi, Đà Nẵng',4,2,4);
insert into nhan_vien(ho_ten,ngay_sinh,cmnd,luong,sdt,email,dia_chi,ma_trinh_do,ma_vi_tri,ma_bo_phan) values('Nguyễn Công Đạo','1994-01-08',
'755434343',8000000,'0988767111','nguyencongdao12@gmail.com','6 Hoà Khánh, Đồng Nai',3,2,2);
select * from nhan_vien;

insert into loai_khach(ten_loai_khach) value('Dinamond');
insert into loai_khach(ten_loai_khach) value('Platinium');
insert into loai_khach(ten_loai_khach) value('Gold');
insert into loai_khach(ten_loai_khach) value('Sliver');
insert into loai_khach(ten_loai_khach) value('Member');
select * from loai_khach;

insert into khach_hang(ho_ten,ngay_sinh,gioi_tinh,cmnd,sdt,email,dia_chi,ma_loai_khach) values('Nguyễn Thị Hào','1970-11-07',
0,'643431213','0945423362','thihao07@gmail.com','23 Nguyễn Hoàng, Đà Nẵng',5);
insert into khach_hang(ho_ten,ngay_sinh,gioi_tinh,cmnd,sdt,email,dia_chi,ma_loai_khach) values('Phạm Xuân Diệu','1992-08-08',
1,'865342123','0954333333','xuandieu92@gmail.com','K77/22 Thái Phiên, Quảng Trị',3);
insert into khach_hang(ho_ten,ngay_sinh,gioi_tinh,cmnd,sdt,email,dia_chi,ma_loai_khach) values('Trương Đình Nghệ','1990-02-27',
1,'488645199','0373213122','nghenhan2702@gmail.com','K323/12 Ông Ích Khiêm, Vinh',1);
insert into khach_hang(ho_ten,ngay_sinh,gioi_tinh,cmnd,sdt,email,dia_chi,ma_loai_khach) values('Dương Văn Quan','1981-07-08',
1,'543432111','0490039241','duongquan@gmail.com','K453/12 Lê Lợi, Đà Nẵng',1);
insert into khach_hang(ho_ten,ngay_sinh,gioi_tinh,cmnd,sdt,email,dia_chi,ma_loai_khach) values('Hoàng Trần Nhi Nhi','1995-12-09',
0,'795453345','0312345678','nhinhi123@gmail.com','224 Lý Thái Tổ, Gia Lai',4);
insert into khach_hang(ho_ten,ngay_sinh,gioi_tinh,cmnd,sdt,email,dia_chi,ma_loai_khach) values('Tôn Nữ Mộc Châu','2005-12-06',
0,'732434215','0988888844','tonnuchau@gmail.com','37 Yên Thế, Đà Nẵng',4);
insert into khach_hang(ho_ten,ngay_sinh,gioi_tinh,cmnd,sdt,email,dia_chi,ma_loai_khach) values('Nguyễn Mỹ Kim','1984-04-08',
0,'965656433','0912345698','kimcuong84@gmail.com','K123/45 Lê Lợi, Hồ Chí Minh',1);
insert into khach_hang(ho_ten,ngay_sinh,gioi_tinh,cmnd,sdt,email,dia_chi,ma_loai_khach) values('Nguyễn Thị Hào','1999-04-08',
0,'732434215','0763212345','haohao99@gmail.com','55 Nguyễn Văn Linh, Kon Tum',3);
insert into khach_hang(ho_ten,ngay_sinh,gioi_tinh,cmnd,sdt,email,dia_chi,ma_loai_khach) values('Trần Đại Danh','1994-07-01',
1,'432341235','0643343433','danhhai99@gmail.com','24 Lý Thường Kiệt, Quảng Ngãi',1);
insert into khach_hang(ho_ten,ngay_sinh,gioi_tinh,cmnd,sdt,email,dia_chi,ma_loai_khach) values('Nguyễn Tâm Đắc','1989-07-01',
1,'344343432','0987654321','dactam@gmail.com','22 Ngô Quyền, Đà Nẵng',2);
insert into khach_hang(ho_ten,ngay_sinh,gioi_tinh,cmnd,sdt,email,dia_chi,ma_loai_khach) values('Võ Phương Nhi','2001-04-16',
0,'333743432','0935638353','phuongnhi@gmail.com','21 Tiểu La, Đà Nẵng',5);
select * from khach_hang;

insert into loai_dich_vu(ten_loai_dich_vu) value('Villa');
insert into loai_dich_vu(ten_loai_dich_vu) value('House');
insert into loai_dich_vu(ten_loai_dich_vu) value('Room');
select * from loai_dich_vu;

insert into dich_vu_di_kem(ten_dich_vu_di_kem,gia,don_vi,trang_thai) values('Karaoke',10000,'Giờ','Tiện nghi, hiện đại');
insert into dich_vu_di_kem(ten_dich_vu_di_kem,gia,don_vi,trang_thai) values('thuê xe máy',10000,'Chiếc','Hỏng 1 xe');
insert into dich_vu_di_kem(ten_dich_vu_di_kem,gia,don_vi,trang_thai) values('Thuê xe đạp',20000,'Chiếc','Tốt');
insert into dich_vu_di_kem(ten_dich_vu_di_kem,gia,don_vi,trang_thai) values('Buffet buổi sáng',15000,'Suất','Đầy đủ đồ ăn, tráng miệng');
insert into dich_vu_di_kem(ten_dich_vu_di_kem,gia,don_vi,trang_thai) values('Buffet buổi trưa',90000,'Suất','Đầy đủ đồ ăn, tráng miệng');
insert into dich_vu_di_kem(ten_dich_vu_di_kem,gia,don_vi,trang_thai) values('Buffet buổi tối',16000,'Suất','Đầy đủ đồ ăn, tráng miệng');
select * from dich_vu_di_kem;

insert into kieu_thue(ten_kieu_thue) value('Year');
insert into kieu_thue(ten_kieu_thue) value('Month');
insert into kieu_thue(ten_kieu_thue) value('Day');
insert into kieu_thue(ten_kieu_thue) value('Hour');
select * from kieu_thue;

insert into dich_vu(ten_dich_vu,dien_tich,chi_phi_thue,so_nguoi_toi_da,tieu_chuan_phong,mo_ta_tien_nghi_khac,dien_tich_ho_boi,so_tang,ma_kieu_thue,
ma_loai_dich_vu) values('Villa Beach Front',25000,10000000,10,'Vip','Có hồ bơi',500,4,3,1);
insert into dich_vu(ten_dich_vu,dien_tich,chi_phi_thue,so_nguoi_toi_da,tieu_chuan_phong,mo_ta_tien_nghi_khac,so_tang,ma_kieu_thue,
ma_loai_dich_vu) values('House Princess 01',14000,5000000,7,'Vip','Có thêm bếp nướng',3,2,2);
insert into dich_vu(ten_dich_vu,dien_tich,chi_phi_thue,so_nguoi_toi_da,tieu_chuan_phong,mo_ta_tien_nghi_khac,ma_kieu_thue,
ma_loai_dich_vu) values('Room Twin 01',5000,1000000,2,'Normal','Có tivi',4,3);
insert into dich_vu(ten_dich_vu,dien_tich,chi_phi_thue,so_nguoi_toi_da,tieu_chuan_phong,mo_ta_tien_nghi_khac,dien_tich_ho_boi,so_tang,ma_kieu_thue,
ma_loai_dich_vu) values('Villa No Beach Front',22000,9000000,8,'Normal','Có hồ bơi',300,3,3,1);
insert into dich_vu(ten_dich_vu,dien_tich,chi_phi_thue,so_nguoi_toi_da,tieu_chuan_phong,mo_ta_tien_nghi_khac,so_tang,ma_kieu_thue,
ma_loai_dich_vu) values('House Princess 02',10000,4000000,5,'Normal','Có thêm bếp nướng',2,3,2);
insert into dich_vu(ten_dich_vu,dien_tich,chi_phi_thue,so_nguoi_toi_da,tieu_chuan_phong,mo_ta_tien_nghi_khac,ma_kieu_thue,
ma_loai_dich_vu) values('Room Twin 02',3000,900000,2,'Normal','Có tivi',4,3);
select * from dich_vu;

insert into hop_dong(ngay_lam_hop_dong,ngay_ket_thuc,tien_dat_coc,ma_nhan_vien,ma_khach_hang,ma_dich_vu)
values('2020-12-08','2020-12-08',0,3,1,3);
insert into hop_dong(ngay_lam_hop_dong,ngay_ket_thuc,tien_dat_coc,ma_nhan_vien,ma_khach_hang,ma_dich_vu)
values('2020-07-14','2020-07-21',200000,7,3,1);
insert into hop_dong(ngay_lam_hop_dong,ngay_ket_thuc,tien_dat_coc,ma_nhan_vien,ma_khach_hang,ma_dich_vu)
values('2021-03-15','2021-03-17',50000,3,4,2);
insert into hop_dong(ngay_lam_hop_dong,ngay_ket_thuc,tien_dat_coc,ma_nhan_vien,ma_khach_hang,ma_dich_vu)
values('2021-01-14','2021-01-18',100000,7,5,5);
insert into hop_dong(ngay_lam_hop_dong,ngay_ket_thuc,tien_dat_coc,ma_nhan_vien,ma_khach_hang,ma_dich_vu)
values('2021-07-14','2021-07-15',0,7,2,6);
insert into hop_dong(ngay_lam_hop_dong,ngay_ket_thuc,tien_dat_coc,ma_nhan_vien,ma_khach_hang,ma_dich_vu)
values('2021-06-01','2021-06-03',0,7,7,6);
insert into hop_dong(ngay_lam_hop_dong,ngay_ket_thuc,tien_dat_coc,ma_nhan_vien,ma_khach_hang,ma_dich_vu)
values('2021-09-02','2021-09-05',100000,7,4,4);
insert into hop_dong(ngay_lam_hop_dong,ngay_ket_thuc,tien_dat_coc,ma_nhan_vien,ma_khach_hang,ma_dich_vu)
values('2021-06-17','2021-06-16',150000,3,4,1);
insert into hop_dong(ngay_lam_hop_dong,ngay_ket_thuc,tien_dat_coc,ma_nhan_vien,ma_khach_hang,ma_dich_vu)
values('2020-11-19','2020-11-19',0,3,4,3);
insert into hop_dong(ngay_lam_hop_dong,ngay_ket_thuc,tien_dat_coc,ma_nhan_vien,ma_khach_hang,ma_dich_vu)
values('2021-04-12','2021-04-14',0,10,3,5);
insert into hop_dong(ngay_lam_hop_dong,ngay_ket_thuc,tien_dat_coc,ma_nhan_vien,ma_khach_hang,ma_dich_vu)
values('2021-04-25','2021-04-25',0,2,2,1);
insert into hop_dong(ngay_lam_hop_dong,ngay_ket_thuc,tien_dat_coc,ma_nhan_vien,ma_khach_hang,ma_dich_vu)
values('2021-05-25','2021-05-27',0,7,10,1);
select * from hop_dong;

insert into hop_dong_chi_tiet(so_luong,ma_hop_dong,ma_dich_vu_di_kem) values(5,2,4),
(8,2,5),
(15,2,6),
(1,3,1),
(11,3,2),
(1,1,3),
(2,1,2),
(2,12,2);
select * from hop_dong_chi_tiet;