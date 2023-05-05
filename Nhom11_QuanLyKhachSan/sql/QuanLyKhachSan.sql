use master
create database QLKS
use QLKS

/*Bảng nhân viên*/
create table tbl_NhanVien(
	ID int identity(0,1),
	MaNV varchar(10)not null,
	HoTenNV varchar(50) not null,
	TenDangNhap varchar(30) not null,
	MatKhau varchar(30) not null,
	NgaySinh datetime default null,
	DiaChi varchar(50) not null,
	Email varchar(30)not null,
	SoDT varchar(30) not null,
	GioiTinh bit,
	ChucVu varchar(30),
	GhiChu nvarchar(200),
	primary key(MaNV),
)

insert into tbl_NhanVien values ('NV01','Nguyen Thai Bao','ThaiBao','123456','02-10-2003','Binh Duong','ThaiBao@gmail.com','0387776610',1,'Quan ly','Nothing')
insert into tbl_NhanVien values ('NV02','Nguyen Anh Vu','AnhVu','123456','02-18-2002','Di An','AnhVu@gmail.com','0909198842',1,'Nhan vien','Nothing')
insert into tbl_NhanVien values ('NV03','Tran Van Loi','VanLoi','123456','02-18-2002','Di An','VanLoi@gmail.com','0909091234',1,'Nhan vien','Nothing')
insert into tbl_NhanVien values ('NV04','Nguyen Thanh Thuan','ThanhThuan','123456','04-18-2003','Di An','ThanhThuan@gmail.com','0387564218',1,'Nhan vien','Nothing')

/* Dịch vụ*/

create table tbl_DichVu(
	MaDV varchar(10) not null,
	TenDV varchar(20) not null,
	DonGia float not null,
	primary key(MaDV),
)

insert into tbl_DichVu values ('DV01','Giat Do',50000)
insert into tbl_DichVu values ('DV02','Thue xe',70000)
insert into tbl_DichVu values ('DV03','Nau an',40000)
insert into tbl_DichVu values ('DV04','Matxa',90000)

insert into tbl_DichVu values ('DV05','Spa',100000)
insert into tbl_DichVu values ('DV06','Nha hang',150000)
insert into tbl_DichVu values ('DV07','Quay bar',200000)
insert into tbl_DichVu values ('DV08','Phong hop',500000)

insert into tbl_DichVu values ('DV09','Xe dua don san bay',250000)
insert into tbl_DichVu values ('DV10','San golf',1000000)
insert into tbl_DichVu values ('DV11','Be boi 4 mua',80000)
insert into tbl_DichVu values ('DV12','Phong gym',50000)

/*Bảng Phòng*/

create table tbl_Phong(
	MaPhong varchar(10) not null,
	LoaiPhong varchar(30) not null,
	TinhTrang varchar(20) not null,
	Giaphong float not null,
	primary key(MaPhong),
)

insert into tbl_Phong values ('P101','Phong Gia dinh','tren 3 nam',600000)
insert into tbl_Phong values ('P102','Phong Don','tren 3 nam',300000)
insert into tbl_Phong values ('P103','Phong Doi','tren 3 nam',450000)
insert into tbl_Phong values ('P104','Phong Gia dinh','duoi 3 nam',600000)
insert into tbl_Phong values ('P105','Phong Don','duoi 3 nam',300000)
insert into tbl_Phong values ('P106','Phong Doi','duoi 3 nam',450000)
insert into tbl_Phong values ('P107','Phong Doi','duoi 3 nam',450000)
insert into tbl_Phong values ('P108','Phong Don','tren 3 nam',300000)
insert into tbl_Phong values ('P109','Phong Gia dinh','tren 3 nam',600000)

insert into tbl_Phong values ('P201','Phong Doi','duoi 3 nam',450000)
insert into tbl_Phong values ('P202','Phong Doi','duoi 3 nam',450000)
insert into tbl_Phong values ('P203','Phong Don','tren 3 nam',300000)
insert into tbl_Phong values ('P204','Phong Gia dinh','tren 3 nam',600000)



/*Bảng tiện nghi*/
create table tbl_TienNghi(
	MaTienNghi varchar(10) not null,
	MaPhong varchar(10) not null,
	TenTienNghi varchar(20) not null,
	TinhTrang varchar(20) not null,
	SoLuong int,
	primary key(MaTienNghi,MaPhong),
	CONSTRAINT KN_MaTienNghi FOREIGN KEY (MaPhong) REFERENCES tbl_Phong(MaPhong),
)
insert into tbl_TienNghi values ('TN01','P101','Tivi','Tot',1)
insert into tbl_TienNghi values ('TN02','P101','Tu Lanh','Tot',1)
insert into tbl_TienNghi values ('TN03','P101','Dieu Hoa','Tot',1)
insert into tbl_TienNghi values ('TN04','P101','May tinh','Tot',1)

insert into tbl_TienNghi values ('TN01','P102','Tivi','Kha',1)
insert into tbl_TienNghi values ('TN02','P102','Tu Lanh','Kha',1)
insert into tbl_TienNghi values ('TN03','P102','Dieu Hoa','Kha',1)
insert into tbl_TienNghi values ('TN04','P102','May tinh','Kha',1)

insert into tbl_TienNghi values ('TN01','P103','Tivi','Kem',1)
insert into tbl_TienNghi values ('TN02','P103','Tu Lanh','Kem',1)
insert into tbl_TienNghi values ('TN03','P103','Dieu Hoa','Kem',1)
insert into tbl_TienNghi values ('TN04','P103','May tinh','Tot',1)

insert into tbl_TienNghi values ('TN01','P104','Tivi','Tot',1)
insert into tbl_TienNghi values ('TN02','P104','Tu Lanh','Tot',1)
insert into tbl_TienNghi values ('TN03','P104','Dieu Hoa','Tot',1)
insert into tbl_TienNghi values ('TN04','P104','May tinh','Tot',1)
insert into tbl_TienNghi values ('TN04','P105','May tinh','Tot',1)

/*Bảng khách hàng*/

create table tbl_KhachHang(
	MaKH varchar(15) not null,
	TenKH varchar(50) not null,
	NgaySinh smalldateTime,
	GioiTinh bit,
	SoCCCD varchar(20) ,
	SoDienThoai varchar(20) ,
	QueQuan varchar(50),
	QuocTich varchar(50),
	GhiChu nvarchar(200),
	primary key(MaKH),
)
insert into tbl_KhachHang values ('KH01','Nguyen Thai Bao','02/10/2003',1,'456789254613','0387776610','Binh Duong','Viet Nam','Nothing')
insert into tbl_KhachHang values ('KH02','Tran Van Loi','11/21/1992',1,'456714230878','09888900','Thai Nguyen','Viet Nam','Nothing')
insert into tbl_KhachHang values ('KH03','Nguyen Thanh Thuan','11/21/1992',1,'456789254613','09888900','Yen Bia','Viet Nam','Nothing')
insert into tbl_KhachHang values ('KH04','Nguyen Anh Vu','11/21/1992',1,'456789254613','09888900','Thai Nguyen','Viet Nam','Nothing')
insert into tbl_KhachHang values ('KH05','Nguyen Tuan Kiet','06/21/2006',1,'845612317910','0365789410','Binh Phuoc','Viet Nam','Nothing')

insert into tbl_KhachHang values ('KH06','Lam Thai Tra Giang','08/19/2003',0,'369852147012','0365228124','Tra Vinh','Viet Nam','Nothing')
insert into tbl_KhachHang values ('KH07','Le Thi Tuyet','07/06/1982',0,'741025896356','0346994414','Thanh Hoa','Viet Nam','Nothing')
insert into tbl_KhachHang values ('KH08','Nguyen Van Phuc','01/01/1983',1,'369852147045','0354990441','Binh Duong','Viet Nam','Nothing')
insert into tbl_KhachHang values ('KH09','Nguyen Ngoc Tuong Vi','05/01/2003',0,'987456022316','0364897652','Da Nang','Viet Nam','Nothing')
insert into tbl_KhachHang values ('KH10','Tran Kim Hue','07/29/2005',0,'123456487913','0364888450','Khach hoa','Viet Nam','Nothing')

/*Bảng sử dụng dịch vụ*/

create table tbl_SDDV(
	MaPhieuSDDV varchar(10)not null,
	MaKH varchar(15) not null,
	MaDV varchar(10) not null,
	NgaySD datetime,
	primary key(MaPhieuSDDV,MaKH,MaDV),
	CONSTRAINT KN_MaDV FOREIGN KEY (MaDV) REFERENCES tbl_DichVu(MaDV),
	CONSTRAINT PK_MaKH_KHACHHANG FOREIGN KEY (MaKH) REFERENCES tbl_KhachHang(MaKH),
)
insert into tbl_SDDV values ('MPSD01','KH01','DV01','2023-4-30')
insert into tbl_SDDV values ('MPSD02','KH03','DV03','2023-4-29')
insert into tbl_SDDV values ('MPSD03','KH04','DV04','2023-4-28')
insert into tbl_SDDV values ('MPSD04','KH04','DV03','2023-4-27')
insert into tbl_SDDV values ('MPSD05','KH04','DV03','2023-5-3')

insert into tbl_SDDV values ('MPSD06','KH02','DV05','2023-4-30')
insert into tbl_SDDV values ('MPSD07','KH05','DV06','2023-4-29')
insert into tbl_SDDV values ('MPSD08','KH06','DV07','2023-4-28')
insert into tbl_SDDV values ('MPSD09','KH07','DV08','2023-4-27')
insert into tbl_SDDV values ('MPSD10','KH08','DV09','2023-5-3')

insert into tbl_SDDV values ('MPSD11','KH09','DV10','2023-4-30')
insert into tbl_SDDV values ('MPSD12','KH10','DV11','2023-4-29')
insert into tbl_SDDV values ('MPSD13','KH10','DV12','2023-4-28')
insert into tbl_SDDV values ('MPSD14','KH08','DV09','2023-4-27')
insert into tbl_SDDV values ('MPSD15','KH07','DV07','2023-5-3')

/*Bảng thuê phòng*/
create table tbl_ThuePhong(
	MaPhieuThuePhong int identity(1,1),
	MaKH varchar(15) not null,
	MaPhong varchar(10),
	MaDV varchar(10),
	NgayDen smalldateTime not null,
	NgayDi smalldateTime,
	DatCoc float,
	GhiChu nvarchar(200),
	primary key(MaPhieuThuePhong,MaKH,MaPhong,MaDV),
	CONSTRAINT KN_KhachHang_MaKH_ThuePhong FOREIGN KEY (MaKH)REFERENCES tbl_KhachHang(MaKH),
	CONSTRAINT KN_DichVu_MaDV FOREIGN KEY (MaDV)REFERENCES tbl_DichVu(MaDV),
	CONSTRAINT KN_Phong_MaPhong FOREIGN KEY (MaPhong) REFERENCES tbl_Phong(MaPhong),
)

/*Bảng hóa đơn thanh toán sử dụng dịch vụ*/
create table HoaDonTTSDDV(
	MaHD varchar(10) not null,
	MaPhieuSDDV varchar(10)not null,
	MaKH varchar(15) not null,
	MaDV varchar(10) not null,
	NgayThanhToan smalldateTime not null,
	TongTien float,
	primary key (MaPhieuSDDV,MaKH,MaDV),
	CONSTRAINT PK_HoaDON_SDDV FOREIGN KEY (MaPhieuSDDV,MaKH,MaDV) REFERENCES tbl_SDDV(MaPhieuSDDV,MaKH,MaDV),
)
/*Bảng hóa đơn thanh toán tổng hợp*/
create table HoaDonTTTH(
	MaHDTH varchar(10) not null,
	MaPhieuThuePhong int,
	MaKH varchar(15) not null,
	MaPhong varchar(10),
	MaDV varchar(10) not null,
	NgayThanhToan smalldateTime not null,
	TienPhong float,
	TienDV float,
	TongTien float,
	primary key (MaHDTH,MaPhieuThuePhong,MaKH,MaDV,MaPhong),
	CONSTRAINT PK_HoaDON_ThuePhong_1 FOREIGN KEY (MaPhieuThuePhong,MaKH,MaPhong,MaDV) REFERENCES tbl_ThuePhong(MaPhieuThuePhong,MaKH,MaPhong,MaDV),
)


/*View_PhongTrong*/

create view View_PhongTrong
as
SELECT * FROM tbl_Phong where MaPhong not in (SELECT MaPhong FROM tbl_ThuePhong)

/*View_ThuePhong*/
create view View_ThuePhong
as
Select MaPhieuThuePhong,tbl_ThuePhong.MaKH,tbl_KhachHang.TenKH,tbl_ThuePhong.MaPhong,
tbl_ThuePhong.MaDV,tbl_DichVu.TenDV,tbl_ThuePhong.NgayDen,tbl_ThuePhong.NgayDi,tbl_ThuePhong.DatCoc,tbl_ThuePhong.GhiChu 
from tbl_ThuePhong,tbl_KhachHang,tbl_DichVu
where (tbl_ThuePhong.MaKH = tbl_KhachHang.MaKH)
AND (tbl_DichVu.MaDV = tbl_ThuePhong.MaDV)

--TT DV
--View nhung khach hang chua thanh toan . Muon thanh toan
create view view_SuDungChuaThanhToan
as
select tbl_KhachHang.MaKH ,tbl_KhachHang.TenKH,tbl_SDDV.MaPhieuSDDV,tbl_SDDV.MaDV,tbl_SDDV.NgaySD
from tbl_KhachHang,tbl_SDDV
Where tbl_KhachHang.MaKH =tbl_SDDV.MaKH 
AND tbl_SDDV.MaPhieuSDDV not in (select MaPhieuSDDV from HoaDonTTSDDV)

select * from view_SuDungChuaThanhToan

/*Hóa đơn tổng hợp*/
create table HDTH(
	HDTH varchar(10),
)
/*Hóa đơn dùng dịch vụ*/
create table HDDV(
	HDDV varchar(10),
)


-- Tạo view đổ dữ liệu 1 dv trong thanh toán phòng - đổ ra table chi tiết
create view Mot_DV_KH_PHONG
as
select tbl_ThuePhong.MaPhieuThuePhong,tbl_ThuePhong.MaPhong,
tbl_ThuePhong.MaDV,tbl_DichVu.TenDV,tbl_DichVu.DonGia
from tbl_ThuePhong,tbl_DichVu
where tbl_ThuePhong.MaDV = tbl_DichVu.MaDV
AND tbl_ThuePhong.MaDV= tbl_DichVu.MaDV

-- Tạo view đổ dữ liệu 1 phòng trong thanh toán phòng - đổ ra table chi tiết phòng
create view Mot_KH_PHONG
as
select tbl_ThuePhong.MaPhieuThuePhong,tbl_ThuePhong.MaPhong,tbl_ThuePhong.NgayDen,
tbl_ThuePhong.NgayDi as 'NgayTra',(DATEDIFF(DAY,tbl_ThuePhong.NgayDen,tbl_ThuePhong.NgayDi)) as 'SoNgayO',tbl_Phong.GiaPhong
from tbl_ThuePhong,tbl_Phong
where tbl_ThuePhong.MaPhong = tbl_Phong.MaPhong

-- LAY DS MOT KHACH HANG TT TONG HOP Do ra lable
select tbl_KhachHang.TenKH,tbl_KhachHang.NgaySinh,tbl_KhachHang.GioiTinh,tbl_KhachHang.SoCCCD,
tbl_KhachHang.SoDienThoai,tbl_KhachHang.QueQuan,tbl_KhachHang.QuocTich
from tbl_KhachHang ,tbl_ThuePhong
where (tbl_ThuePhong.MaKH = tbl_KhachHang.MaKH) 
AND tbl_ThuePhong.MaPhieuThuePhong = '1'


--------view những khách hàng chưa thanh toán muốn thanh toán
create view view_SuDungChuaThanhToan_TongHop
as
select tbl_KhachHang.MaKH ,tbl_KhachHang.TenKH,tbl_ThuePhong.MaPhieuThuePhong,tbl_ThuePhong.MaPhong,tbl_ThuePhong.NgayDen
from tbl_KhachHang,tbl_ThuePhong
Where tbl_KhachHang.MaKH =tbl_ThuePhong.MaKH 
AND tbl_ThuePhong.MaPhieuThuePhong not in (select MaPhieuThuePhong from HoaDonTTTH)

-- View load lên các label thanh toán phòng khi ấn vào button chọn thì hiện thông tin 
create view view_loadLable_TT_Phong
as
SELECT tbl_ThuePhong.MaPhieuThuePhong,tbl_ThuePhong.MaPhong,tbl_ThuePhong.MaKH,tbl_ThuePhong.MaDV ,
DATEDIFF(DAY,tbl_ThuePhong.NgayDen,tbl_ThuePhong.NgayDi)*tbl_Phong.GiaPhong as 'TienPhong' ,
tbl_DichVu.DonGia as 'TienDV' ,tbl_ThuePhong.DatCoc ,
(((DATEDIFF(DAY,tbl_ThuePhong.NgayDen,tbl_ThuePhong.NgayDi)*tbl_Phong.GiaPhong) +tbl_DichVu.DonGia) -tbl_ThuePhong.DatCoc) as 'TongTien' 
from tbl_ThuePhong,tbl_Phong,tbl_DichVu
WHERE tbl_ThuePhong.MaDV = tbl_DichVu.MaDV
AND tbl_ThuePhong.MaPhong = tbl_Phong.MaPhong

/*view thanh toán sử dụng dịch vụ*/
create view View_TTSDDV
as
Select HoaDonTTSDDV.MaHD,HoaDonTTSDDV.MaKH,tbl_KhachHang.TenKH,HoaDonTTSDDV.MaDV ,tbl_DichVu.TenDV,
tbl_SDDV.NgaySD, HoaDonTTSDDV.NgayThanhToan ,tbl_DichVu.DonGia,tbl_DichVu.DonGia*(DATEDIFF(DAY,tbl_SDDV.NgaySD,HoaDonTTSDDV.NgayThanhToan))as 'TongTien'
from HoaDonTTSDDV ,tbl_SDDV ,tbl_KhachHang ,tbl_DichVu
where (HoaDonTTSDDV.MaKH = tbl_SDDV.MaKH)
AND (tbl_KhachHang.MaKH = HoaDonTTSDDV.MaKH)
AND (tbl_DichVu.MaDV = HoaDonTTSDDV.MaDV)
AND (tbl_SDDV.MaDV = HoaDonTTSDDV.MaDV)

-- Tao View do du lieu 1 DV cho SDDV
create view Mot_DV_KH_SDDV
as
select tbl_SDDV.MaPhieuSDDV,tbl_SDDV.MaKH,tbl_SDDV.NgaySD,tbl_DichVu.MaDV,tbl_DichVu.TenDV,tbl_DichVu.DonGia
from tbl_SDDV,tbl_DichVu
where tbl_SDDV.MaDV =tbl_DichVu.MaDV

--doDuLieuLable TTSDDV
select tbl_SDDV.MaKH,tbl_SDDV.MaDV,tbl_DichVu.TenDV,DATEDIFF(day,tbl_SDDV.NgaySD,HoaDonTTSDDV.NgayThanhToan)*tbl_DichVu.DonGia AS 'TienDV'
from tbl_SDDV,tbl_DichVu,HoaDonTTSDDV
where tbl_SDDV.MaPhieuSDDV ='MHDSD05' 
AND (tbl_SDDV.MaDV = tbl_DichVu.MaDV)
AND (HoaDonTTSDDV.MaPhieuSDDV =tbl_SDDV.MaPhieuSDDV)

----View IN HÓA ĐƠN SDDV
create view view_inHoaDon
as
select tbl_KhachHang.MaKH ,tbl_KhachHang.TenKH ,tbl_KhachHang.NgaySinh ,tbl_KhachHang.GioiTinh ,tbl_KhachHang.SoCCCD ,
tbl_KhachHang.SoDienThoai,tbl_KhachHang.QueQuan,tbl_KhachHang.QuocTich,
HoaDonTTSDDV.MaHD,HoaDonTTSDDV.MaPhieuSDDV,HoaDonTTSDDV.NgayThanhToan ,HoaDonTTSDDV.TongTien 
from tbl_KhachHang,HoaDonTTSDDV
Where (tbl_KhachHang.MaKH =HoaDonTTSDDV.MaKH)

select *from view_inHoaDon
DELETE FROM view_inHoaDon WHERE MaHD = 1
select *from HDDV


--Tao View do du lieu 1 DV trong TT  - do ra table chi tiet IN HOA DON DICH VU IN IIN IN IN IN
create view Mot_DV_KH_SDDV_IN
as
select HoaDonTTSDDV.MaHD,tbl_SDDV.MaPhieuSDDV,tbl_SDDV.MaKH,tbl_SDDV.NgaySD,tbl_DichVu.MaDV,tbl_DichVu.TenDV,tbl_DichVu.DonGia
from tbl_SDDV,tbl_DichVu,HoaDonTTSDDV
where tbl_SDDV.MaDV =tbl_DichVu.MaDV
AND HoaDonTTSDDV.MaDV = tbl_SDDV.MaDV
AND HoaDonTTSDDV.MaPhieuSDDV =tbl_SDDV.MaPhieuSDDV

select *from Mot_DV_KH_SDDV_IN