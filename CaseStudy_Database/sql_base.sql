use furama;

-- 2.	Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 kí tự.--
select * from nhan_vien
where (ho_ten like 'h%' or ho_ten like 'k%' or ho_ten like 't%') and char_length(ho_ten) <= 15;


-- 3.	Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.--
select * from khach_hang 
where ((year(current_date())-year(ngay_sinh))>=18 and (year(current_date())-year(ngay_sinh))<=50)
and (dia_chi like'%Đà Nẵng' or dia_chi like '%Quảng Trị');


-- 4.	Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.--
select kh.ma_khach_hang, kh.ho_ten, count(hd.ma_khach_hang) as so_lan_dat_phong
from khach_hang as kh join hop_dong as hd on kh.ma_khach_hang=hd.ma_khach_hang
where kh.ma_loai_khach=1
group by hd.ma_khach_hang
order by so_lan_dat_phong asc;


-- 5.Hiển thị ma_khach_hang, ho_ten, ten_loai_khach, ma_hop_dong, ten_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tong_tien (Với tổng tiền được tính theo công thức như sau: Chi Phí Thuê + Số Lượng * Giá, với Số Lượng và Giá là từ bảng dich_vu_di_kem, hop_dong_chi_tiet) cho tất cả các khách hàng đã từng đặt phòng. (những khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra). --
select kh.ma_khach_hang,kh.ho_ten,lk.ten_loai_khach,hd.so_hop_dong,dv.ten_dich_vu,hd.ngay_lam_hop_dong, hd.ngay_ket_thuc, dv.chi_phi_thue+sum(hdct.so_luong)*dvdk.gia as tong_tien
from ((((khach_hang as kh 
left join loai_khach as lk on kh.ma_loai_khach=lk.ma_loai_khach)
left join hop_dong as hd on kh.ma_khach_hang=hd.ma_khach_hang) 
left join dich_vu as dv on hd.ma_dich_vu=dv.ma_dich_vu)
left join hop_dong_chi_tiet as hdct on hd.so_hop_dong=hdct.ma_hop_dong)
left join dich_vu_di_kem as dvdk on hdct.ma_dich_vu_di_kem=dvdk.ma_dich_vu_di_kem
group by hd.so_hop_dong;


-- 6.	Hiển thị ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu của tất cả các loại dịch vụ chưa từng được khách hàng thực hiện đặt từ quý 1 của năm 2021 (Quý 1 là tháng 1, 2, 3)002E --
create view dich_vu_chua_duoc_dat_quy_1 as
select ma_dich_vu
from hop_dong
where month(ngay_lam_hop_dong)=1 or month(ngay_lam_hop_dong)=2 or month(ngay_lam_hop_dong)=3
group by ma_dich_vu;

select dv.ma_dich_vu, dv.ten_dich_vu, dv.dien_tich, ldv.ten_loai_dich_vu
from (dich_vu as dv join loai_dich_vu as ldv on dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu) join hop_dong as hd on dv.ma_dich_vu = hd.ma_dich_vu
where hd.ma_dich_vu not in (select ma_dich_vu from dich_vu_chua_duoc_dat_quy_1)
group by hd.ma_dich_vu;


-- 7. Hiển thị thông tin ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue, ten_loai_dich_vu của tất cả các loại dịch vụ đã từng được khách hàng đặt phòng trong năm 2020 nhưng chưa từng được khách hàng đặt phòng trong năm 2021.
create view hop_dong_views as
select ma_dich_vu
from hop_dong
where year(ngay_lam_hop_dong)=2021;


select dv.ma_dich_vu, dv.ten_dich_vu, dv.dien_tich,dv.so_nguoi_toi_da,dv.chi_phi_thue,ldv.ten_loai_dich_vu
from (dich_vu as dv join loai_dich_vu as ldv on dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu) join hop_dong as hd on dv.ma_dich_vu = hd.ma_dich_vu
where  hd.ma_dich_vu not in (select * from hop_dong_views)
group by hd.ma_dich_vu;

-- 8.Hiển thị thông tin ho_ten khách hàng có trong hệ thống, với yêu cầu ho_ten không trùng nhau.
	-- Cách 1: --
select ho_ten from khach_hang group by ho_ten;
	-- Cách 2: --
select distinct ho_ten from khach_hang;


-- 9.	Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2021 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.--
select month(ngay_lam_hop_dong) as thang, count(so_hop_dong) as so_luong_khach_hang
from hop_dong
where year(ngay_lam_hop_dong)=2021
group by thang
order by thang asc;


-- 10.	Hiển thị thông tin tương ứng với từng hợp đồng thì đã sử dụng bao nhiêu dịch vụ đi kèm. Kết quả hiển thị bao gồm ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem).--
select hd.so_hop_dong,hd.ngay_lam_hop_dong,hd.ngay_ket_thuc,hd.tien_dat_coc,sum(hdct.so_luong) as so_luong_dich_vu_di_kem
from (hop_dong as hd left join hop_dong_chi_tiet as hdct on hd.so_hop_dong=hdct.ma_hop_dong) 
left join dich_vu_di_kem as dvdk on hdct.ma_dich_vu_di_kem=dvdk.ma_dich_vu_di_kem
group by hd.so_hop_dong;


-- 11.	Hiển thị thông tin các dịch vụ đi kèm đã được sử dụng bởi những khách hàng có ten_loai_khach là “Diamond” và có dia_chi ở “Vinh” hoặc “Quảng Ngãi”.
select dvdk.ma_dich_vu_di_kem, dvdk.ten_dich_vu_di_kem
from (((dich_vu_di_kem as dvdk join hop_dong_chi_tiet as hdct on dvdk.ma_dich_vu_di_kem=hdct.ma_dich_vu_di_kem)
join hop_dong as hd on hdct.ma_hop_dong=hd.so_hop_dong)
join khach_hang as kh on hd.ma_khach_hang=kh.ma_khach_hang)
where kh.ma_loai_khach=1 and (kh.dia_chi like '%Vinh' or kh.dia_chi like '%Quảng Ngãi');


-- 12.	Hiển thị thông tin ma_hop_dong, ho_ten (nhân viên), ho_ten (khách hàng), so_dien_thoai (khách hàng), ten_dich_vu, so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem), tien_dat_coc của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2020 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2021.--
create view nam_lam_hop_dong_views as
select so_hop_dong
from hop_dong
where month(ngay_lam_hop_dong)<7 and year(ngay_lam_hop_dong)=2021;

select hd.so_hop_dong,nv.ho_ten,kh.ho_ten,kh.sdt,dv.ten_dich_vu,sum(hdct.so_luong) as so_luong_dich_vu_di_kem,hd.tien_dat_coc
from (((hop_dong as hd join nhan_vien as nv on hd.ma_nhan_vien=nv.ma_nhan_vien) left join khach_hang as kh on hd.ma_khach_hang=kh.ma_khach_hang)
left join dich_vu as dv on hd.ma_dich_vu=dv.ma_dich_vu) left join hop_dong_chi_tiet as hdct on hd.so_hop_dong=hdct.ma_hop_dong
where month(hd.ngay_lam_hop_dong)>9 and year(hd.ngay_lam_hop_dong)=2020 and hd.so_hop_dong not in (select * from nam_lam_hop_dong_views)
group by hd.so_hop_dong;


-- 13.Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).
create temporary table temp1 (select dvdk.ma_dich_vu_di_kem, dvdk.ten_dich_vu_di_kem, sum(hdct.so_luong) as so_luong_dich_vu_di_kem
from dich_vu_di_kem as dvdk join hop_dong_chi_tiet as hdct on dvdk.ma_dich_vu_di_kem=hdct.ma_dich_vu_di_kem
group by dvdk.ma_dich_vu_di_kem);


select dvdk.ma_dich_vu_di_kem, dvdk.ten_dich_vu_di_kem, sum(hdct.so_luong) as so_luong_dich_vu_di_kem
from dich_vu_di_kem as dvdk join hop_dong_chi_tiet as hdct on dvdk.ma_dich_vu_di_kem=hdct.ma_dich_vu_di_kem
group by dvdk.ma_dich_vu_di_kem
having so_luong_dich_vu_di_kem >= all (select so_luong_dich_vu_di_kem from temp1);


-- 14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. Thông tin hiển thị bao gồm ma_hop_dong, ten_loai_dich_vu, ten_dich_vu_di_kem, so_lan_su_dung (được tính dựa trên việc count các ma_dich_vu_di_kem).
select hd.so_hop_dong, ldv.ten_loai_dich_vu, dvdk.ten_dich_vu_di_kem, count(hdct.ma_dich_vu_di_kem) as so_lan_su_dung
from (((loai_dich_vu as ldv join dich_vu as dv on ldv.ma_loai_dich_vu=dv.ma_loai_dich_vu) join hop_dong as hd on dv.ma_dich_vu=hd.ma_dich_vu)
join hop_dong_chi_tiet as hdct on hd.so_hop_dong=hdct.ma_hop_dong) join dich_vu_di_kem as dvdk on hdct.ma_dich_vu_di_kem=dvdk.ma_dich_vu_di_kem
group by hdct.ma_dich_vu_di_kem
having so_lan_su_dung=1
order by hd.so_hop_dong asc;


-- 15.	Hiển thi thông tin của tất cả nhân viên bao gồm ma_nhan_vien, ho_ten, ten_trinh_do, ten_bo_phan, so_dien_thoai, dia_chi mới chỉ lập được tối đa 3 hợp đồng từ năm 2020 đến 2021.
select nv.ma_nhan_vien,nv.ho_ten,td.ten_trinh_do,bp.ten_bo_phan,nv.sdt,nv.dia_chi
from (((nhan_vien as nv join trinh_do as td on nv.ma_trinh_do=td.ma_trinh_do) join bo_phan as bp on nv.ma_bo_phan=bp.ma_bo_phan)
join hop_dong as hd on nv.ma_nhan_vien=hd.ma_nhan_vien)
where (year(hd.ngay_lam_hop_dong)>=2020 and year(hd.ngay_lam_hop_dong)<=2021)
group by nv.ma_nhan_vien
having count(hd.ma_nhan_vien)<=3
order by nv.ma_nhan_vien asc;

-- 16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2019 đến năm 2021.
create temporary table nhan_vien_temp1(select * from nhan_vien);

create view nhan_vien_lam_hop_dong_views as
select ma_nhan_vien from hop_dong
where year(ngay_lam_hop_dong)>=2019 and year(ngay_lam_hop_dong)<=2021
group by ma_nhan_vien;

delete from nhan_vien_temp1
where ma_nhan_vien not in (select * from nhan_vien_lam_hop_dong_views);

select * from nhan_vien_temp1; -- Danh sách nhân viên sau khi xóa các nhân viên có mã 1,4,5,6,8,9 --


-- 17. Cập nhật thông tin những khách hàng có ten_loai_khach từ Platinum lên Diamond, chỉ cập nhật những khách hàng đã từng đặt phòng với Tổng Tiền thanh toán trong năm 2021 là lớn hơn 10.000.000 VNĐ.
create view tong_tien as 
select kh.ma_khach_hang,kh.ho_ten,lk.ten_loai_khach,hd.so_hop_dong,dv.ten_dich_vu,hd.ngay_lam_hop_dong, hd.ngay_ket_thuc, dv.chi_phi_thue+sum(hdct.so_luong)*dvdk.gia as tong_tien, lk.ma_loai_khach
from ((((khach_hang as kh 
left join loai_khach as lk on kh.ma_loai_khach=lk.ma_loai_khach)
left join hop_dong as hd on kh.ma_khach_hang=hd.ma_khach_hang) 
left join dich_vu as dv on hd.ma_dich_vu=dv.ma_dich_vu)
left join hop_dong_chi_tiet as hdct on hd.so_hop_dong=hdct.ma_hop_dong)
left join dich_vu_di_kem as dvdk on hdct.ma_dich_vu_di_kem=dvdk.ma_dich_vu_di_kem
where year(ngay_lam_hop_dong)=2021 
group by hd.so_hop_dong
having tong_tien>10000000;

create temporary table cap_nhat_loai_khach_hang_temp as 
select kh.ma_khach_hang,kh.ho_ten,lk.ma_loai_khach from khach_hang as kh join loai_khach as lk on kh.ma_loai_khach=lk.ma_loai_khach;

select * from cap_nhat_loai_khach_hang_temp;
update cap_nhat_loai_khach_hang_temp set ma_loai_khach=1 where ma_loai_khach in (select ma_loai_khach from tong_tien);

select * from cap_nhat_loai_khach_hang_temp;
-- 18. Xóa những khách hàng có hợp đồng trước năm 2021 (chú ý ràng buộc giữa các bảng).
create temporary table xoa_khach_hang_temp(
select * from khach_hang);

select * from xoa_khach_hang_temp; 

create view kh_co_hop_dong_sau_2021_views as
select kh.ma_khach_hang,hd.ngay_lam_hop_dong from hop_dong as hd join khach_hang as kh on hd.ma_khach_hang=kh.ma_khach_hang
where year(hd.ngay_lam_hop_dong)<2021;

select * from kh_co_hop_dong_sau_2021_views;

delete from xoa_khach_hang_temp 
where ma_khach_hang in (select ma_khach_hang from kh_co_hop_dong_sau_2021_views);

select * from xoa_khach_hang_temp;
-- 19.	Cập nhật giá cho các dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2020 lên gấp đôi.--
create view dich_vu_di_kem_temp as 
(select dvdk.ma_dich_vu_di_kem, dvdk.ten_dich_vu_di_kem, dvdk.gia, sum(hdct.so_luong) as so_lan_su_dung, hd.ngay_lam_hop_dong
from (dich_vu_di_kem as dvdk join hop_dong_chi_tiet as hdct on dvdk.ma_dich_vu_di_kem=hdct.ma_dich_vu_di_kem) join hop_dong as hd on hdct.ma_hop_dong=hd.so_hop_dong
where year(hd.ngay_lam_hop_dong)=2020
group by dvdk.ma_dich_vu_di_kem
having sum(hdct.so_luong)>10);

create temporary table cap_nhat_gia_dich_vu_di_kem_temp(select dvdk.ma_dich_vu_di_kem, dvdk.ten_dich_vu_di_kem, dvdk.gia, sum(hdct.so_luong) as so_lan_su_dung, hd.ngay_lam_hop_dong
from (dich_vu_di_kem as dvdk join hop_dong_chi_tiet as hdct on dvdk.ma_dich_vu_di_kem=hdct.ma_dich_vu_di_kem) join hop_dong as hd on hdct.ma_hop_dong=hd.so_hop_dong
group by dvdk.ma_dich_vu_di_kem);

update cap_nhat_gia_dich_vu_di_kem_temp set gia=gia*2 where ma_dich_vu_di_kem in (select ma_dich_vu_di_kem from dich_vu_di_kem_temp);

select * from cap_nhat_gia_dich_vu_di_kem_temp;

-- 20.	Hiển thị thông tin của tất cả các nhân viên và khách hàng có trong hệ thống, thông tin hiển thị bao gồm id (ma_nhan_vien, ma_khach_hang), ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi.	--
select ma_nhan_vien as id, ho_ten, email, sdt, ngay_sinh, dia_chi from nhan_vien
union
select ma_khach_hang as id, ho_ten, email, sdt, ngay_sinh, dia_chi from khach_hang;







