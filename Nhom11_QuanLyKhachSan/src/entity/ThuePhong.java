package entity;

import java.util.Date;

public class ThuePhong {
	private String maThuePhong;
	private String maKH;
	private String tenKH;
	private String maPhong;
	private String maDV;
	private String tenDV;
	private Date ngayDen;
	private Date ngayDi;
	private float datCoc;
	private String ghiChu;
	
	public String getMaThuePhong() {
		return maThuePhong;
	}
	public void setMaThuePhong(String maThuePhong) {
		this.maThuePhong = maThuePhong;
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
	public Date getNgayDen() {
		return ngayDen;
	}
	public void setNgayDen(Date ngayDen) {
		this.ngayDen = ngayDen;
	}
	public Date getNgayDi() {
		return ngayDi;
	}
	public void setNgayDi(Date ngayDi) {
		this.ngayDi = ngayDi;
	}
	public float getDatCoc() {
		return datCoc;
	}
	public void setDatCoc(float datCoc) {
		this.datCoc = datCoc;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	
	public ThuePhong() {
		super();
	}
	public ThuePhong(String maThuePhong, String maKH, String tenKH, String maPhong, String maDV, String tenDV,
			Date ngayDen, Date ngayDi, float datCoc, String ghiChu) {
		super();
		this.maThuePhong = maThuePhong;
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.maPhong = maPhong;
		this.maDV = maDV;
		this.tenDV = tenDV;
		this.ngayDen = ngayDen;
		this.ngayDi = ngayDi;
		this.datCoc = datCoc;
		this.ghiChu = ghiChu;
	}
}
