package entity;

import java.sql.Date;

public class motPhongTT_TongHop_PHONG {
	
	private String phieu;
	private String maPhong;
	private Date ngayDen;
	private Date ngayTra;
	private int soNgayO;
	private float tienPhong;
	
	public String getPhieu() {
		return phieu;
	}

	public void setPhieu(String phieu) {
		this.phieu = phieu;
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

	public Date getNgayTra() {
		return ngayTra;
	}

	public void setNgayTra(Date ngayTra) {
		this.ngayTra = ngayTra;
	}

	public int getSoNgayO() {
		return soNgayO;
	}

	public void setSoNgayO(int soNgayO) {
		this.soNgayO = soNgayO;
	}

	public float getTienPhong() {
		return tienPhong;
	}

	public void setTienPhong(float tienPhong) {
		this.tienPhong = tienPhong;
	}

	public motPhongTT_TongHop_PHONG() {
		// TODO Auto-generated constructor stub
	}

	public motPhongTT_TongHop_PHONG(String phieu, String maPhong, Date ngayDen, Date ngayTra, int soNgayO,
			float tienPhong) {
		super();
		this.phieu = phieu;
		this.maPhong = maPhong;
		this.ngayDen = ngayDen;
		this.ngayTra = ngayTra;
		this.soNgayO = soNgayO;
		this.tienPhong = tienPhong;
	}
	
	
	
}
