package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.DichVu;
//import entity.NhanVien;
//import entity.Phong;

public class DichVu_DAO {
	private Connection con = ConnectDB.getConnection();
	public ArrayList<DichVu> getAllDichVu() {
		ArrayList<DichVu> dsDichVu = new ArrayList<DichVu>();
		
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT *FROM tbl_DichVu";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				float donGia = rs.getFloat(3);
				
				DichVu dv = new DichVu(ma, ten, donGia);
				dsDichVu.add(dv);
			}
		
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsDichVu;
	}
	
	public boolean deleteDichVu(String maCT) throws Exception {
		String sql = "DELETE FROM tbl_DichVu  WHERE MaDV = ? ";
		int n = 0;
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, maCT);
			n = stmt.executeUpdate();
		}
		return n > 0;
	}
	
	public DichVu timDichVu(String maDV) {
		String sql = "select * from tbl_DichVu where MaDV = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, maDV);	
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				return new DichVu(rs.getString(1), rs.getString(2), rs.getFloat(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public boolean themDichVu(DichVu dv) {
		if(timDichVu(dv.getMaDichVu())!=null){
			return false;
		}
		int n = 0;
		String sql = "insert into tbl_DichVu values (?, ?, ?)";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1,  dv.getMaDichVu());
			stmt.setString(2, dv.getTenDichVu());
			stmt.setFloat(3, dv.getDonGiaDichVu());
			n = stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n>0;
	}
	//Cập nhật thông tin phòng
	public boolean capNhat_DichVu(DichVu dv) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("UPDATE tbl_DichVu SET TenDV=?,DonGia=? WHERE MaDV=?");
			stmt.setString(1, dv.getTenDichVu());
			stmt.setFloat(2, dv.getDonGiaDichVu());
			stmt.setString(3, dv.getMaDichVu());
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
}
