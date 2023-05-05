package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.SuDungDichVu;


public class SuDungDichVu_DAO {
	public ArrayList<SuDungDichVu> getAll_SuDungDichVu() {
		ArrayList<SuDungDichVu> dsSDDV = new ArrayList<SuDungDichVu>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT *FROM tbl_SDDV";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maPhieu = rs.getString(1);
				String maKH = rs.getString(2);
				String maDV = rs.getString(3);
				Date ngaySD = rs.getDate(4);
				
				SuDungDichVu sddv = new SuDungDichVu(maPhieu, maKH, maDV, ngaySD);
				dsSDDV.add(sddv);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsSDDV;
	}
	
	public boolean create(SuDungDichVu sddv) {
		ConnectDB.getInstance();
		
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("INSERT INTO tbl_SDDV (MaPhieuSDDV,MaKH,MaDV,NgaySD)" + "VALUES(?, ?, ?, ?)");
			stmt.setString(1, sddv.getMaSDDV());
			stmt.setString(2, sddv.getMaKH());
			stmt.setString(3, sddv.getMaDV());
			stmt.setDate(4, new Date(sddv.getNgaySD().getTime()));
			
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return n > 0;
	}
	public boolean delete_SDDV(String maPhieuSDDV) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("DELETE FROM tbl_SDDV WHERE MaPhieuSDDV=?");
			stmt.setString(1, maPhieuSDDV);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return n > 0;
	}
	// cập nhật
	public boolean capNhat_SDDV(SuDungDichVu sddv) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement(
					"UPDATE tbl_SDDV SET MaKH=?,MaDV=?,NgaySD=? WHERE MaPhieuSDDV=?");
			
			stmt.setString(1, sddv.getMaKH());
			stmt.setString(2, sddv.getMaDV());
			stmt.setDate(3, new Date(sddv.getNgaySD().getTime()));
			stmt.setString(4, sddv.getMaSDDV());
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
