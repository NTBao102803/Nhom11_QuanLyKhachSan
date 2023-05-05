package entity;

import java.sql.Date;

public class motDV_TT {
	private String maPhieuSDDV;
	private String maKH;
	private Date ngaySDDV;
	private String maDV;
	private String tenDV;
	private float donGia;
	public String getMaPhieuSDDV() {
		return maPhieuSDDV;
	}
	public void setMaPhieuSDDV(String maPhieuSDDV) {
		this.maPhieuSDDV = maPhieuSDDV;
	}
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public Date getNgaySDDV() {
		return ngaySDDV;
	}
	public void setNgaySDDV(Date ngaySDDV) {
		this.ngaySDDV = ngaySDDV;
	}
	public String getMaDV() {
		return maDV;
	}
	public void setMaDV(String maDV) {
		this.maDV = maDV;
	}
	public String getTenDV() {
		return tenDV;
	}
	public void setTenDV(String tenDV) {
		this.tenDV = tenDV;
	}
	public float getDonGia() {
		return donGia;
	}
	public void setDonGia(float donGia) {
		this.donGia = donGia;
	}
	
	public motDV_TT() {
		super();
	}
	
	public motDV_TT(String maPhieuSDDV, String maKH, Date ngaySDDV, String maDV, String tenDV, float donGia) {
		super();
		this.maPhieuSDDV = maPhieuSDDV;
		this.maKH = maKH;
		this.ngaySDDV = ngaySDDV;
		this.maDV = maDV;
		this.tenDV = tenDV;
		this.donGia = donGia;
	}
	
	
}
