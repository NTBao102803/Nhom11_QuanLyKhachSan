package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.Phong;

public class Phong_DAO {
	public ArrayList<Phong> getAllPhongTrong() {
		ArrayList<Phong> dsPhong = new ArrayList<Phong>();
		
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT* FROM tbl_Phong where MaPhong not in (SELECT MaPhong FROM tbl_ThuePhong)";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String ma = rs.getString(1);
				String loai = rs.getString(2);
				String tinhTrang = rs.getString(3);
				float donGia = rs.getFloat(4);
				
				Phong p = new Phong(ma, loai, tinhTrang, donGia);
				dsPhong.add(p);
			}
		
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsPhong;
	}
	public ArrayList<Phong> getAllPhong() {
		ArrayList<Phong> dsPhong = new ArrayList<Phong>();
		
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT* FROM tbl_Phong";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String ma = rs.getString(1);
				String loai = rs.getString(2);
				String tinhTrang = rs.getString(3);
				float donGia = rs.getFloat(4);
				
				Phong p = new Phong(ma, loai, tinhTrang, donGia);
				dsPhong.add(p);
			}
		
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsPhong;
	}
	//tìm phòng theo mã
			public Phong timPhongTheoMa(String maPhong) {
				ConnectDB.getInstance();
				Connection con = ConnectDB.getConnection();
				String sql = "select * from tbl_Phong where MaPhong = ?";
				try {
					PreparedStatement stmt = con.prepareStatement(sql);
					stmt.setString(1, maPhong);	
					ResultSet rs = stmt.executeQuery();
					if(rs.next()) {
						return new Phong(rs.getString(1), rs.getString(2), rs.getString(3) ,rs.getFloat(4));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return null;
			}
	
	//Thêm phòng vào SQL
		public boolean create_Phong(Phong ph) {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			PreparedStatement stmt = null;
			int n = 0;
			try {
				stmt = con.prepareStatement("INSERT INTO tbl_Phong VALUES (?,?,?,?)");
				stmt.setString(1, ph.getMaPhong());
				stmt.setString(2, ph.getLoaiPhong());
				stmt.setString(3, ph.getTinhTrang());
				stmt.setFloat(4, ph.getGiaPhong());
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
		//Xóa phòng trên SQL
		public boolean delete_Phong(String ma) {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			PreparedStatement stmt = null;
			int n = 0;
			try {
				stmt = con.prepareStatement("DELETE FROM tbl_Phong WHERE MaPhong =?");
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
		
		//Cập nhật thông tin phòng
		public boolean capNhat_Phong(Phong ph) {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			PreparedStatement stmt = null;
			int n = 0;
			try {
				stmt = con.prepareStatement("UPDATE tbl_Phong SET LoaiPhong=? , TinhTrang=?,Giaphong=? WHERE MaPhong=?");
				stmt.setString(1, ph.getLoaiPhong());
				stmt.setString(2, ph.getTinhTrang());
				stmt.setFloat(3, ph.getGiaPhong());
				stmt.setString(4, ph.getMaPhong());
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
