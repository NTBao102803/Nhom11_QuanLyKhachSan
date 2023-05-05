package entity;

public class DichVu {
	private String maDichVu;
	private String tenDichVu;
	private float donGiaDichVu;
	
	public String getMaDichVu() {
		return maDichVu;
	}
	public void setMaDichVu(String maDichVu) {
		this.maDichVu = maDichVu;
	}
	public String getTenDichVu() {
		return tenDichVu;
	}
	public void setTenDichVu(String tenDichVu) {
		this.tenDichVu = tenDichVu;
	}
	public float getDonGiaDichVu() {
		return donGiaDichVu;
	}
	public void setDonGiaDichVu(float donGiaDichVu) {
		this.donGiaDichVu = donGiaDichVu;
	}
	public DichVu(String maDichVu, String tenDichVu, float donGiaDichVu) {
		super();
		this.maDichVu = maDichVu;
		this.tenDichVu = tenDichVu;
		this.donGiaDichVu = donGiaDichVu;
	}
	public DichVu() {
		super();
	}
	public DichVu(String maDichVu) {
		super();
		this.maDichVu = maDichVu;
	}
	
	
}
