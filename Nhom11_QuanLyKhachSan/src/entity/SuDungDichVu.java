package entity;

import java.util.Date;
import java.util.Objects;

public class SuDungDichVu {
	private String maSDDV;
	private String maKH;
	private String maDV;
	private Date ngaySD;
	
	public String getMaSDDV() {
		return maSDDV;
	}
	public void setMaSDDV(String maSDDV) {
		this.maSDDV = maSDDV;
	}
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
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
	
	public SuDungDichVu() {
		super();
	}
	public SuDungDichVu(String maSDDV, String maKH, String maDV, Date ngaySD) {
		super();
		this.maSDDV = maSDDV;
		this.maKH = maKH;
		this.maDV = maDV;
		this.ngaySD = ngaySD;
	}
	public SuDungDichVu(String maSDDV) {
		super();
		this.maSDDV = maSDDV;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maSDDV);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SuDungDichVu other = (SuDungDichVu) obj;
		return Objects.equals(maSDDV, other.maSDDV);
	}
	
}
