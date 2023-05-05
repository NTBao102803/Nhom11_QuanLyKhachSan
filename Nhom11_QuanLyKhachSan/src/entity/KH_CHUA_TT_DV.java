package entity;

import java.sql.Date;

public class KH_CHUA_TT_DV {
	private String maKhach;
	private String tenKhach;
	private String maPhieuThue;
	private String maDV;
	private Date ngaySD;
	
	public String getMaKhach() {
		return maKhach;
	}
	public void setMaKhach(String maKhach) {
		this.maKhach = maKhach;
	}
	public String getTenKhach() {
		return tenKhach;
	}
	public void setTenKhach(String tenKhach) {
		this.tenKhach = tenKhach;
	}
	
	public String getMaPhieuThue() {
		return maPhieuThue;
	}
	public void setMaPhieuThue(String maPhieuThue) {
		this.maPhieuThue = maPhieuThue;
	}
	public String getMaDV() {
		return maDV;
	}
	public void setMaDV(String maDV) {
		this.maDV = maDV;
	}
	public Date getNgaySD() {
		return ngaySD;
	}
	public void setNgaySD(Date ngaySD) {
		this.ngaySD = ngaySD;
	}
	
	public KH_CHUA_TT_DV() {
		super();
	}
	public KH_CHUA_TT_DV(String maKhach, String tenKhach, String maPhieuThue, String maDV, Date ngaySD) {
		super();
		this.maKhach = maKhach;
		this.tenKhach = tenKhach;
		this.maPhieuThue = maPhieuThue;
		this.maDV = maDV;
		this.ngaySD = ngaySD;
	}
	
}
