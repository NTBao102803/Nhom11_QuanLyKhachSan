package entity;

import  java.util.Date;

public class KhachHang {
	private String maKH;
	private String tenKH;
	private Date ngaySinhKH;
	private String gioiTinhKH;
	private String soCMTKH;
	private String soDienThoaiKH;
	private String queQuanKH;
	private String quocTichKH;
	private String ghiChuKH;
	public KhachHang(String maKH, String tenKH, Date ngaySinhKH, String gioiTinhKH, String soCMTKH,
			String soDienThoaiKH, String queQuanKH, String quocTichKH, String ghiChuKH) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.ngaySinhKH = ngaySinhKH;
		this.gioiTinhKH = gioiTinhKH;
		this.soCMTKH = soCMTKH;
		this.soDienThoaiKH = soDienThoaiKH;
		this.queQuanKH = queQuanKH;
		this.quocTichKH = quocTichKH;
		this.ghiChuKH = ghiChuKH;
	}
	public KhachHang(String maKH) {
		super();
		this.maKH = maKH;
	}
	public KhachHang() {
		super();
	}
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public Date getNgaySinhKH() {
		return ngaySinhKH;
	}
	public void setNgaySinhKH(Date ngaySinhKH) {
		this.ngaySinhKH = ngaySinhKH;
	}
	public String getGioiTinhKH() {
		return gioiTinhKH;
	}
	public void setGioiTinhKH(String gioiTinhKH) {
		this.gioiTinhKH = gioiTinhKH;
	}
	public String getSoCMTKH() {
		return soCMTKH;
	}
	public void setSoCMTKH(String soCMTKH) {
		this.soCMTKH = soCMTKH;
	}
	public String getSoDienThoaiKH() {
		return soDienThoaiKH;
	}
	public void setSoDienThoaiKH(String soDienThoaiKH) {
		this.soDienThoaiKH = soDienThoaiKH;
	}
	public String getQueQuanKH() {
		return queQuanKH;
	}
	public void setQueQuanKH(String queQuanKH) {
		this.queQuanKH = queQuanKH;
	}
	public String getQuocTichKH() {
		return quocTichKH;
	}
	public void setQuocTichKH(String quocTichKH) {
		this.quocTichKH = quocTichKH;
	}
	public String getGhiChuKH() {
		return ghiChuKH;
	}
	public void setGhiChuKH(String ghiChuKH) {
		this.ghiChuKH = ghiChuKH;
	}
	
	
}
