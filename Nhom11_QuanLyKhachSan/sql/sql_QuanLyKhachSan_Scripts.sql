USE [master]
GO
/****** Object:  Database [QLKS]    Script Date: 5/5/2023 11:42:34 AM ******/
CREATE DATABASE [QLKS]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'QLKS', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.SQLEXPRESS\MSSQL\DATA\QLKS.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'QLKS_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.SQLEXPRESS\MSSQL\DATA\QLKS_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [QLKS] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QLKS].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QLKS] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QLKS] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QLKS] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QLKS] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QLKS] SET ARITHABORT OFF 
GO
ALTER DATABASE [QLKS] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [QLKS] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QLKS] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QLKS] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QLKS] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QLKS] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QLKS] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QLKS] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QLKS] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QLKS] SET  ENABLE_BROKER 
GO
ALTER DATABASE [QLKS] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QLKS] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QLKS] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QLKS] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QLKS] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QLKS] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QLKS] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QLKS] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [QLKS] SET  MULTI_USER 
GO
ALTER DATABASE [QLKS] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QLKS] SET DB_CHAINING OFF 
GO
ALTER DATABASE [QLKS] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [QLKS] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [QLKS] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [QLKS] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [QLKS] SET QUERY_STORE = ON
GO
ALTER DATABASE [QLKS] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [QLKS]
GO
/****** Object:  Table [dbo].[tbl_DichVu]    Script Date: 5/5/2023 11:42:35 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_DichVu](
	[MaDV] [varchar](10) NOT NULL,
	[TenDV] [varchar](20) NOT NULL,
	[DonGia] [float] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaDV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbl_KhachHang]    Script Date: 5/5/2023 11:42:35 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_KhachHang](
	[MaKH] [varchar](15) NOT NULL,
	[TenKH] [varchar](50) NOT NULL,
	[NgaySinh] [smalldatetime] NULL,
	[GioiTinh] [bit] NULL,
	[SoCCCD] [varchar](20) NULL,
	[SoDienThoai] [varchar](20) NULL,
	[QueQuan] [varchar](50) NULL,
	[QuocTich] [varchar](50) NULL,
	[GhiChu] [nvarchar](200) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbl_ThuePhong]    Script Date: 5/5/2023 11:42:35 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_ThuePhong](
	[MaPhieuThuePhong] [int] IDENTITY(1,1) NOT NULL,
	[MaKH] [varchar](15) NOT NULL,
	[MaPhong] [varchar](10) NOT NULL,
	[MaDV] [varchar](10) NOT NULL,
	[NgayDen] [smalldatetime] NOT NULL,
	[NgayDi] [smalldatetime] NULL,
	[DatCoc] [float] NULL,
	[GhiChu] [nvarchar](200) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaPhieuThuePhong] ASC,
	[MaKH] ASC,
	[MaPhong] ASC,
	[MaDV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  View [dbo].[View_ThuePhong]    Script Date: 5/5/2023 11:42:35 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
/*View_ThuePhong*/
create view [dbo].[View_ThuePhong]
as
Select MaPhieuThuePhong,tbl_ThuePhong.MaKH,tbl_KhachHang.TenKH,tbl_ThuePhong.MaPhong,
tbl_ThuePhong.MaDV,tbl_DichVu.TenDV,tbl_ThuePhong.NgayDen,tbl_ThuePhong.NgayDi,tbl_ThuePhong.DatCoc,tbl_ThuePhong.GhiChu 
from tbl_ThuePhong,tbl_KhachHang,tbl_DichVu
where (tbl_ThuePhong.MaKH = tbl_KhachHang.MaKH)
AND (tbl_DichVu.MaDV = tbl_ThuePhong.MaDV)
GO
/****** Object:  Table [dbo].[tbl_Phong]    Script Date: 5/5/2023 11:42:35 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_Phong](
	[MaPhong] [varchar](10) NOT NULL,
	[LoaiPhong] [varchar](30) NOT NULL,
	[TinhTrang] [varchar](20) NOT NULL,
	[Giaphong] [float] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaPhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  View [dbo].[View_PhongTrong]    Script Date: 5/5/2023 11:42:35 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create view [dbo].[View_PhongTrong]
as
SELECT * FROM tbl_Phong where MaPhong not in (SELECT MaPhong FROM tbl_ThuePhong)
GO
/****** Object:  Table [dbo].[tbl_SDDV]    Script Date: 5/5/2023 11:42:35 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_SDDV](
	[MaPhieuSDDV] [varchar](10) NOT NULL,
	[MaKH] [varchar](15) NOT NULL,
	[MaDV] [varchar](10) NOT NULL,
	[NgaySD] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[MaPhieuSDDV] ASC,
	[MaKH] ASC,
	[MaDV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDonTTSDDV]    Script Date: 5/5/2023 11:42:35 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDonTTSDDV](
	[MaHD] [varchar](10) NOT NULL,
	[MaPhieuSDDV] [varchar](10) NOT NULL,
	[MaKH] [varchar](15) NOT NULL,
	[MaDV] [varchar](10) NOT NULL,
	[NgayThanhToan] [smalldatetime] NOT NULL,
	[TongTien] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[MaPhieuSDDV] ASC,
	[MaKH] ASC,
	[MaDV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  View [dbo].[view_SuDungChuaThanhToan]    Script Date: 5/5/2023 11:42:35 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
--View nhung khach hang chua thanh toan . Muon thanh toan
create view [dbo].[view_SuDungChuaThanhToan]
as
select tbl_KhachHang.MaKH ,tbl_KhachHang.TenKH,tbl_SDDV.MaPhieuSDDV,tbl_SDDV.MaDV,tbl_SDDV.NgaySD
from tbl_KhachHang,tbl_SDDV
Where tbl_KhachHang.MaKH =tbl_SDDV.MaKH 
AND tbl_SDDV.MaPhieuSDDV not in (select MaPhieuSDDV from HoaDonTTSDDV)
GO
/****** Object:  View [dbo].[Mot_DV_KH_PHONG]    Script Date: 5/5/2023 11:42:35 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- Tạo view đổ dữ liệu 1 dv trong thanh toán phòng - đổ ra table chi tiết
create view [dbo].[Mot_DV_KH_PHONG]
as
select tbl_ThuePhong.MaPhieuThuePhong,tbl_ThuePhong.MaPhong,
tbl_ThuePhong.MaDV,tbl_DichVu.TenDV,tbl_DichVu.DonGia
from tbl_ThuePhong,tbl_DichVu
where tbl_ThuePhong.MaDV = tbl_DichVu.MaDV
AND tbl_ThuePhong.MaDV= tbl_DichVu.MaDV
GO
/****** Object:  View [dbo].[Mot_KH_PHONG]    Script Date: 5/5/2023 11:42:35 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- Tạo view đổ dữ liệu 1 phòng trong thanh toán phòng - đổ ra table chi tiết phòng
create view [dbo].[Mot_KH_PHONG]
as
select tbl_ThuePhong.MaPhieuThuePhong,tbl_ThuePhong.MaPhong,tbl_ThuePhong.NgayDen,
tbl_ThuePhong.NgayDi as 'NgayTra',(DATEDIFF(DAY,tbl_ThuePhong.NgayDen,tbl_ThuePhong.NgayDi)) as 'SoNgayO',tbl_Phong.GiaPhong
from tbl_ThuePhong,tbl_Phong
where tbl_ThuePhong.MaPhong = tbl_Phong.MaPhong
GO
/****** Object:  Table [dbo].[HoaDonTTTH]    Script Date: 5/5/2023 11:42:35 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDonTTTH](
	[MaHDTH] [varchar](10) NOT NULL,
	[MaPhieuThuePhong] [int] NOT NULL,
	[MaKH] [varchar](15) NOT NULL,
	[MaPhong] [varchar](10) NOT NULL,
	[MaDV] [varchar](10) NOT NULL,
	[NgayThanhToan] [smalldatetime] NOT NULL,
	[TienPhong] [float] NULL,
	[TienDV] [float] NULL,
	[TongTien] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[MaHDTH] ASC,
	[MaPhieuThuePhong] ASC,
	[MaKH] ASC,
	[MaDV] ASC,
	[MaPhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  View [dbo].[view_SuDungChuaThanhToan_TongHop]    Script Date: 5/5/2023 11:42:35 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create view [dbo].[view_SuDungChuaThanhToan_TongHop]
as
select tbl_KhachHang.MaKH ,tbl_KhachHang.TenKH,tbl_ThuePhong.MaPhieuThuePhong,tbl_ThuePhong.MaPhong,tbl_ThuePhong.NgayDen
from tbl_KhachHang,tbl_ThuePhong
Where tbl_KhachHang.MaKH =tbl_ThuePhong.MaKH 
AND tbl_ThuePhong.MaPhieuThuePhong not in (select MaPhieuThuePhong from HoaDonTTTH)
GO
/****** Object:  View [dbo].[view_loadLable_TT_Phong]    Script Date: 5/5/2023 11:42:35 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- View load lên các label thanh toán phòng khi ấn vào button chọn thì hiện thông tin 
create view [dbo].[view_loadLable_TT_Phong]
as
SELECT tbl_ThuePhong.MaPhieuThuePhong,tbl_ThuePhong.MaPhong,tbl_ThuePhong.MaKH,tbl_ThuePhong.MaDV ,
DATEDIFF(DAY,tbl_ThuePhong.NgayDen,tbl_ThuePhong.NgayDi)*tbl_Phong.GiaPhong as 'TienPhong' ,
tbl_DichVu.DonGia as 'TienDV' ,tbl_ThuePhong.DatCoc ,
(((DATEDIFF(DAY,tbl_ThuePhong.NgayDen,tbl_ThuePhong.NgayDi)*tbl_Phong.GiaPhong) +tbl_DichVu.DonGia) -tbl_ThuePhong.DatCoc) as 'TongTien' 
from tbl_ThuePhong,tbl_Phong,tbl_DichVu
WHERE tbl_ThuePhong.MaDV = tbl_DichVu.MaDV
AND tbl_ThuePhong.MaPhong = tbl_Phong.MaPhong
GO
/****** Object:  View [dbo].[View_TTSDDV]    Script Date: 5/5/2023 11:42:35 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create view [dbo].[View_TTSDDV]
as
Select HoaDonTTSDDV.MaHD,HoaDonTTSDDV.MaKH,tbl_KhachHang.TenKH,HoaDonTTSDDV.MaDV ,tbl_DichVu.TenDV,
tbl_SDDV.NgaySD, HoaDonTTSDDV.NgayThanhToan ,tbl_DichVu.DonGia,tbl_DichVu.DonGia*(DATEDIFF(DAY,tbl_SDDV.NgaySD,HoaDonTTSDDV.NgayThanhToan))as 'TongTien'
from HoaDonTTSDDV ,tbl_SDDV ,tbl_KhachHang ,tbl_DichVu
where (HoaDonTTSDDV.MaKH = tbl_SDDV.MaKH)
AND (tbl_KhachHang.MaKH = HoaDonTTSDDV.MaKH)
AND (tbl_DichVu.MaDV = HoaDonTTSDDV.MaDV)
AND (tbl_SDDV.MaDV = HoaDonTTSDDV.MaDV)
GO
/****** Object:  View [dbo].[Mot_DV_KH_SDDV]    Script Date: 5/5/2023 11:42:35 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- Tao View do du lieu 1 DV cho SDDV
create view [dbo].[Mot_DV_KH_SDDV]
as
select tbl_SDDV.MaPhieuSDDV,tbl_SDDV.MaKH,tbl_SDDV.NgaySD,tbl_DichVu.MaDV,tbl_DichVu.TenDV,tbl_DichVu.DonGia
from tbl_SDDV,tbl_DichVu
where tbl_SDDV.MaDV =tbl_DichVu.MaDV
GO
/****** Object:  View [dbo].[view_inHoaDon]    Script Date: 5/5/2023 11:42:35 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
----View IN HÓA ĐƠN SDDV
create view [dbo].[view_inHoaDon]
as
select tbl_KhachHang.MaKH ,tbl_KhachHang.TenKH ,tbl_KhachHang.NgaySinh ,tbl_KhachHang.GioiTinh ,tbl_KhachHang.SoCCCD ,
tbl_KhachHang.SoDienThoai,tbl_KhachHang.QueQuan,tbl_KhachHang.QuocTich,
HoaDonTTSDDV.MaHD,HoaDonTTSDDV.MaPhieuSDDV,HoaDonTTSDDV.NgayThanhToan ,HoaDonTTSDDV.TongTien 
from tbl_KhachHang,HoaDonTTSDDV
Where (tbl_KhachHang.MaKH =HoaDonTTSDDV.MaKH)
GO
/****** Object:  View [dbo].[Mot_DV_KH_SDDV_IN]    Script Date: 5/5/2023 11:42:35 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
--Tao View do du lieu 1 DV trong TT  - do ra table chi tiet IN HOA DON DICH VU IN IIN IN IN IN
create view [dbo].[Mot_DV_KH_SDDV_IN]
as
select HoaDonTTSDDV.MaHD,tbl_SDDV.MaPhieuSDDV,tbl_SDDV.MaKH,tbl_SDDV.NgaySD,tbl_DichVu.MaDV,tbl_DichVu.TenDV,tbl_DichVu.DonGia
from tbl_SDDV,tbl_DichVu,HoaDonTTSDDV
where tbl_SDDV.MaDV =tbl_DichVu.MaDV
AND HoaDonTTSDDV.MaDV = tbl_SDDV.MaDV
AND HoaDonTTSDDV.MaPhieuSDDV =tbl_SDDV.MaPhieuSDDV
GO
/****** Object:  Table [dbo].[HDDV]    Script Date: 5/5/2023 11:42:35 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HDDV](
	[HDDV] [varchar](10) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HDTH]    Script Date: 5/5/2023 11:42:35 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HDTH](
	[HDTH] [varchar](10) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbl_NhanVien]    Script Date: 5/5/2023 11:42:35 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_NhanVien](
	[ID] [int] IDENTITY(0,1) NOT NULL,
	[MaNV] [varchar](10) NOT NULL,
	[HoTenNV] [varchar](50) NOT NULL,
	[TenDangNhap] [varchar](30) NOT NULL,
	[MatKhau] [varchar](30) NOT NULL,
	[NgaySinh] [datetime] NULL,
	[DiaChi] [varchar](50) NOT NULL,
	[Email] [varchar](30) NOT NULL,
	[SoDT] [varchar](30) NOT NULL,
	[GioiTinh] [bit] NULL,
	[ChucVu] [varchar](30) NULL,
	[GhiChu] [nvarchar](200) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbl_TienNghi]    Script Date: 5/5/2023 11:42:35 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_TienNghi](
	[MaTienNghi] [varchar](10) NOT NULL,
	[MaPhong] [varchar](10) NOT NULL,
	[TenTienNghi] [varchar](20) NOT NULL,
	[TinhTrang] [varchar](20) NOT NULL,
	[SoLuong] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[MaTienNghi] ASC,
	[MaPhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[tbl_NhanVien] ADD  DEFAULT (NULL) FOR [NgaySinh]
GO
ALTER TABLE [dbo].[HoaDonTTSDDV]  WITH CHECK ADD  CONSTRAINT [PK_HoaDON_SDDV] FOREIGN KEY([MaPhieuSDDV], [MaKH], [MaDV])
REFERENCES [dbo].[tbl_SDDV] ([MaPhieuSDDV], [MaKH], [MaDV])
GO
ALTER TABLE [dbo].[HoaDonTTSDDV] CHECK CONSTRAINT [PK_HoaDON_SDDV]
GO
ALTER TABLE [dbo].[HoaDonTTTH]  WITH CHECK ADD  CONSTRAINT [PK_HoaDON_ThuePhong_1] FOREIGN KEY([MaPhieuThuePhong], [MaKH], [MaPhong], [MaDV])
REFERENCES [dbo].[tbl_ThuePhong] ([MaPhieuThuePhong], [MaKH], [MaPhong], [MaDV])
GO
ALTER TABLE [dbo].[HoaDonTTTH] CHECK CONSTRAINT [PK_HoaDON_ThuePhong_1]
GO
ALTER TABLE [dbo].[tbl_SDDV]  WITH CHECK ADD  CONSTRAINT [KN_MaDV] FOREIGN KEY([MaDV])
REFERENCES [dbo].[tbl_DichVu] ([MaDV])
GO
ALTER TABLE [dbo].[tbl_SDDV] CHECK CONSTRAINT [KN_MaDV]
GO
ALTER TABLE [dbo].[tbl_SDDV]  WITH CHECK ADD  CONSTRAINT [PK_MaKH_KHACHHANG] FOREIGN KEY([MaKH])
REFERENCES [dbo].[tbl_KhachHang] ([MaKH])
GO
ALTER TABLE [dbo].[tbl_SDDV] CHECK CONSTRAINT [PK_MaKH_KHACHHANG]
GO
ALTER TABLE [dbo].[tbl_TienNghi]  WITH CHECK ADD  CONSTRAINT [KN_MaTienNghi] FOREIGN KEY([MaPhong])
REFERENCES [dbo].[tbl_Phong] ([MaPhong])
GO
ALTER TABLE [dbo].[tbl_TienNghi] CHECK CONSTRAINT [KN_MaTienNghi]
GO
ALTER TABLE [dbo].[tbl_ThuePhong]  WITH CHECK ADD  CONSTRAINT [KN_DichVu_MaDV] FOREIGN KEY([MaDV])
REFERENCES [dbo].[tbl_DichVu] ([MaDV])
GO
ALTER TABLE [dbo].[tbl_ThuePhong] CHECK CONSTRAINT [KN_DichVu_MaDV]
GO
ALTER TABLE [dbo].[tbl_ThuePhong]  WITH CHECK ADD  CONSTRAINT [KN_KhachHang_MaKH_ThuePhong] FOREIGN KEY([MaKH])
REFERENCES [dbo].[tbl_KhachHang] ([MaKH])
GO
ALTER TABLE [dbo].[tbl_ThuePhong] CHECK CONSTRAINT [KN_KhachHang_MaKH_ThuePhong]
GO
ALTER TABLE [dbo].[tbl_ThuePhong]  WITH CHECK ADD  CONSTRAINT [KN_Phong_MaPhong] FOREIGN KEY([MaPhong])
REFERENCES [dbo].[tbl_Phong] ([MaPhong])
GO
ALTER TABLE [dbo].[tbl_ThuePhong] CHECK CONSTRAINT [KN_Phong_MaPhong]
GO
USE [master]
GO
ALTER DATABASE [QLKS] SET  READ_WRITE 
GO
