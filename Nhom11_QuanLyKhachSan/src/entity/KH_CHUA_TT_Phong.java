package entity;

import java.sql.Date;

public class KH_CHUA_TT_Phong {
	private String maKH;
	private String tenKh;
	private String maPhieuthuephong;
	private String maPhong;
	private Date ngayDen;
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getTenKh() {
		return tenKh;
	}
	public void setTenKh(String tenKh) {
		this.tenKh = tenKh;
	}
	public String getMaPhieuthuephong() {
		return maPhieuthuephong;
	}
	public void setMaPhieuthuephong(String maPhieuthuephong) {
		this.maPhieuthuephong = maPhieuthuephong;
	}
	public String getMaPhong() {
		return maPhong;
	}
	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}
	public Date getNgayDen() {
		return ngayDen;
	}
	public void setNgayDen(Date ngayDen) {
		this.ngayDen = ngayDen;
	}
	
	public KH_CHUA_TT_Phong() {
		
	}
	public KH_CHUA_TT_Phong(String maKH, String tenKh, String maPhieuthuephong, String maPhong, Date ngayDen) {
		super();
		this.maKH = maKH;
		this.tenKh = tenKh;
		this.maPhieuthuephong = maPhieuthuephong;
		this.maPhong = maPhong;
		this.ngayDen = ngayDen;
	}
	
	
}
