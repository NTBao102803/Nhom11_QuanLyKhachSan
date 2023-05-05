package dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import entity.NhanVien;
import connectDB.ConnectDB;

public class NhanVien_DAO {
	public ArrayList<NhanVien>getAllNhanVien(){
		ArrayList<NhanVien> dsNhanVien = new ArrayList<NhanVien>();
		
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT *FROM tbl_NhanVien";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String ma = rs.getString(2);
				String fullName = rs.getString(3);
				String userName = rs.getString(4);
				String passWord = rs.getString(5);
				Date DOB = rs.getDate(6);
				String address = rs.getString(7);
				String email = rs.getString(8);
				String phoneNumber = rs.getString(9);
				boolean sex = rs.getBoolean(10);
				String chucVu = rs.getString(11);
				String note = rs.getString(12);
				
				NhanVien nv = new NhanVien(ma,fullName,userName,passWord,DOB,address,email,phoneNumber,sex,chucVu,note);
				dsNhanVien.add(nv);
			}
		
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsNhanVien;
	}
	//ThĂªm nhĂ¢n viĂªn 
	public boolean create_NhanVien(NhanVien kh) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("INSERT INTO tbl_NhanVien(Ad_MaNV,Ad_FullName,Ad_User,Ad_Pass,Ad_DBO,Ad_Adress,Ad_Email,Ad_Phone,Ad_Sex,Ad_ChucVu,Ad_Notes)VALUES (?,?,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, kh.getMaNV());
			stmt.setString(2, kh.getFullName());
			stmt.setString(3, kh.getUserName());
			stmt.setString(4, kh.getPassWord());
			stmt.setDate(5, new Date(kh.getDOB().getTime()));
			stmt.setString(6, kh.getAddress());
			stmt.setString(7, kh.getEmail());
			stmt.setString(8, kh.getPhoneNumber());
			stmt.setBoolean(9, kh.getPhai().equals("Nam") ? true : false);
			stmt.setString(10, kh.getChucVu());
			stmt.setString(11, kh.getNote());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return n > 0;
	}

	// XĂ³a khĂ¡ch hĂ ng
	public boolean delete_NhanVien(String ma) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("DELETE FROM tbl_NhanVien WHERE Ad_MaNV =?");
			stmt.setString(1, ma);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return n > 0;
	}

	public boolean capNhat_KhachHang(NhanVien kh) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement(
					"UPDATE tbl_NhanVien SET Ad_FullName=?,Ad_User=?,Ad_Pass=?,Ad_DBO=?,Ad_Adress=?,Ad_Email=?,Ad_Phone=?,"
							+ "Ad_Sex=?,Ad_ChucVu=?,Ad_Notes=? WHERE Ad_MaNV=?");
			stmt.setString(1, kh.getFullName());
			stmt.setString(2, kh.getUserName());
			stmt.setString(3, kh.getPassWord());
			stmt.setDate(4, new Date(kh.getDOB().getTime()));
			stmt.setString(5, kh.getAddress());
			stmt.setString(6, kh.getEmail());
			stmt.setString(7, kh.getPhoneNumber());
			stmt.setBoolean(8, kh.getPhai().equals("Nam") ? true : false);
			stmt.setString(9, kh.getChucVu());
			stmt.setString(10, kh.getNote());
			stmt.setString(11,kh.getMaNV());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return n > 0;
	}
	public NhanVien timNhanVienTheoTaiKhoan(String user) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "Select * from tbl_NhanVien where TenDangNhap = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, user);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				NhanVien nv = new NhanVien(rs.getString(2),rs.getString(3) , rs.getString(4), rs.getString(5), rs.getDate(6), rs.getString(7), rs.getString(8)
						, rs.getString(9), rs.getBoolean(10), rs.getString(11), rs.getString(12));
				return nv;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
				
	}
	
	public boolean doiMatKhau(NhanVien nv) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		if(timNhanVienTheoTaiKhoan(nv.getUserName())!=null){	
			String sql = "UPDATE tbl_NhanVien "
					+ "   SET MatKhau = ? "
					+ " WHERE  TenDangNhap = ? ";
			try(PreparedStatement stmt = con.prepareStatement(sql)){
				stmt.setString(1, nv.getPassWord());
				stmt.setString(2, nv.getUserName());
				int n = stmt.executeUpdate();
				return n>0;
			}		
		}
		return false;
	}
}
