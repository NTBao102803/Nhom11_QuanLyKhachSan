package entity;

public class TienNghi {
	private String maTienNghi;
	private Phong phong;
	private String tenTienNghi;
	private String tinhTrang;
	private int soLuong;
	public String getMaTienNghi() {
		return maTienNghi;
	}
	public void setMaTienNghi(String maTienNghi) {
		this.maTienNghi = maTienNghi;
	}

	public String getTenTienNghi() {
		return tenTienNghi;
	}
	public void setTenTienNghi(String tenTienNghi) {
		this.tenTienNghi = tenTienNghi;
	}
	public String getTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	
	public Phong getPhong() {
		return phong;
	}
	public void setPhong(Phong phong) {
		this.phong = phong;
	}
	public TienNghi() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TienNghi(String maTienNghi) {
		super();
		this.maTienNghi = maTienNghi;
	}
	public TienNghi(String maTienNghi, Phong phong, String tenTienNghi, String tinhTrang, int soLuong) {
		super();
		this.maTienNghi = maTienNghi;
		this.phong = phong;
		this.tenTienNghi = tenTienNghi;
		this.tinhTrang = tinhTrang;
		this.soLuong = soLuong;
	}
	

	
}
