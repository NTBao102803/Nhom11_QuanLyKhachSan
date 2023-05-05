package entity;

import java.util.Date;
import java.util.Objects;

public class NhanVien {
	private String MaNV;
	private String fullName;
	private String userName;
	private String passWord;
	private Date DOB;
	private String address;
	private String email;
	private String phoneNumber;
	private boolean sex;
	private String chucVu;
	private String note;
	
	
	
	public String getMaNV() {
		return MaNV;
	}
	public void setMaNV(String maNV) {
		MaNV = maNV;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public Date getDOB() {
		return DOB;
	}
	public void setDOB(Date dOB) {
		this.DOB = dOB;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public boolean isSex() {
		return sex;
	}
	public String getPhai()
	{
		if(sex==true)
			return "Nam";
			else 
			return "Nữ";
	}
	@Override
	public int hashCode() {
		return Objects.hash(MaNV);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVien other = (NhanVien) obj;
		return Objects.equals(MaNV, other.MaNV);
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	public String getChucVu() {
		return chucVu;
	}
	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public NhanVien() {
		super();
	}
	public NhanVien(String maNV, String fullName, String userName, String passWord, Date dOB, String address,
			String email, String phoneNumber, boolean sex, String chucVu, String note) {
		super();
		MaNV = maNV;
		this.fullName = fullName;
		this.userName = userName;
		this.passWord = passWord;
		this.DOB = dOB;
		this.address = address;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.sex = sex;
		this.chucVu = chucVu;
		this.note = note;
	}
	
	
	
}
