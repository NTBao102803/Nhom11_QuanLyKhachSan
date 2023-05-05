package entity;

import java.util.Date;

public class motPhongTT_TongHop_DV {
	private String MaPhieuThuePhong;
	private String maPhong;
	private String maDV;
	private String tenDV;
	private float donGia;
	
	public String getMaPhieuThuePhong() {
		return MaPhieuThuePhong;
	}
	public void setMaPhieuThuePhong(String MaPhieuThuePhong) {
		this.MaPhieuThuePhong = MaPhieuThuePhong;
	}
	public String getMaPhong() {
		return maPhong;
	}
	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
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
	public motPhongTT_TongHop_DV() {
		// TODO Auto-generated constructor stub
	}																	
	public motPhongTT_TongHop_DV(String MaPhieuThuePhong, String maPhong, String maDV, String tenDV,
			float donGia) {
		super();
		this.MaPhieuThuePhong = MaPhieuThuePhong;
		this.maPhong = maPhong;
		this.maDV = maDV;
		this.tenDV = tenDV;
		this.donGia = donGia;
	}

	
	
}
