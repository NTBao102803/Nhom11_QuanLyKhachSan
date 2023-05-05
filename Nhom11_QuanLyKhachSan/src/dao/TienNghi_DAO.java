package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.Phong;
import entity.TienNghi;


public class TienNghi_DAO {
	Phong_DAO phong_dao;
	private Connection con = ConnectDB.getConnection();
	public ArrayList<TienNghi> getAllTienNghi() {
		ArrayList<TienNghi> dsTienNghi = new ArrayList<TienNghi>();
		
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT *FROM tbl_TienNghi";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String ma = rs.getString(1);
				String maPhong = rs.getString(2);
				Phong p = new Phong(maPhong);
				String ten = rs.getString(3);
				String trinhTrang = rs.getString(4);
				int donGia = rs.getInt(5);
				TienNghi tn = new TienNghi(ma, p, ten, trinhTrang, donGia);
				dsTienNghi.add(tn);
			}
		
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsTienNghi;
	}
	
	public boolean deleteTienNghi(String maCT) throws Exception {
		String sql = "DELETE FROM tbl_DichVu  WHERE MaDV = ? ";
		int n = 0;
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, maCT);
			n = stmt.executeUpdate();
		}
		return n > 0;
	}
	
	public TienNghi timTienNghiTheoMa(String maTN) {
		String sql = "select * from tbl_TienNghi where MaTienNghi = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, maTN);	
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				Phong p = phong_dao.timPhongTheoMa(rs.getString(2));
				rs.getString(2);
				return new TienNghi(rs.getString(1), p, rs.getString(3), rs.getString(4), rs.getInt(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public boolean themTienNghi(TienNghi tn) {
		int n = 0;
		String sql = "insert into tbl_TienNghi values (?, ?, ?, ?, ?)";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1,  tn.getMaTienNghi());
			stmt.setString(2, tn.getPhong().getMaPhong());
			stmt.setString(3, tn.getTenTienNghi());
			stmt.setString(4, tn.getTinhTrang());
			stmt.setInt(5, tn.getSoLuong());
			n = stmt.executeUpdate();		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n>0;
	}
	//Cập nhật thông tin tiện nghi
	public boolean capNhat_TienNghi(TienNghi tn) {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			PreparedStatement stmt = null;
			int n = 0;
			try {
				stmt = con.prepareStatement("UPDATE tbl_TienNghi SET  TenTienNghi=?, TinhTrang=?, SoLuong=? WHERE MaPhong=?");
				//stmt.setString(1, tn.getPhong().getMaPhong());
				stmt.setString(1, tn.getTenTienNghi());
				stmt.setString(2, tn.getTinhTrang());
				stmt.setInt(3, tn.getSoLuong());
				stmt.setString(4, tn.getPhong().getMaPhong());
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
