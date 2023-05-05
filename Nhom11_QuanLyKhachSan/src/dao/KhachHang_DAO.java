package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import connectDB.ConnectDB;
import entity.KhachHang;

public class KhachHang_DAO {

	public ArrayList<KhachHang> getAllKhachHang() {
		ArrayList<KhachHang> dsKhachHang = new ArrayList<KhachHang>();

		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT * FROM tbl_KhachHang";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String gt = rs.getBoolean("GioiTinh") ? "Nam" : "Nữ";
				dsKhachHang.add(new KhachHang(rs.getString("MaKH"), rs.getString("TenKH"), rs.getDate("NgaySinh"), gt,
						rs.getString("SoCCCD"), rs.getString("SoDienThoai"), rs.getString("QueQuan"), rs.getString("QuocTich"),
						rs.getString("GhiChu")));
			}

		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Dữ liệu trống!");
		}
		return dsKhachHang;
	}

	// Thêm khách hàng
	public boolean create_KhachHang(KhachHang kh) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("INSERT INTO tbl_KhachHang VALUES (?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, kh.getMaKH());
			stmt.setString(2, kh.getTenKH());
			stmt.setDate(3, new Date(kh.getNgaySinhKH().getTime()));
			stmt.setBoolean(4, kh.getGioiTinhKH().equals("Nam") ? true : false);
			stmt.setString(5, kh.getSoCMTKH());
			stmt.setString(6, kh.getSoDienThoaiKH());
			stmt.setString(7, kh.getQueQuanKH());
			stmt.setString(8, kh.getQuocTichKH());
			stmt.setString(9, kh.getGhiChuKH());
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

	// Xóa khách hàng
	public boolean delete_KhachHang(String ma) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("DELETE FROM tbl_KhachHang WHERE MaKH =?");
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

	public boolean capNhat_KhachHang(KhachHang kh) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement(
					"UPDATE tbl_KhachHang SET TenKH=? , NgaySinh=?,GioiTinh=?,SoCCCD=?,SoDienThoai=?,QueQuan=? ,QuocTich=?,GhiChu=? WHERE MaKH=?");
			stmt.setString(1, kh.getTenKH());
			stmt.setDate(2, new Date(kh.getNgaySinhKH().getTime()));
			stmt.setBoolean(3, kh.getGioiTinhKH().equals("Nam") ? true : false);
			stmt.setString(4, kh.getSoCMTKH());
			stmt.setString(5, kh.getSoDienThoaiKH());
			stmt.setString(6, kh.getQueQuanKH());
			stmt.setString(7, kh.getQuocTichKH());
			stmt.setString(8, kh.getGhiChuKH());
			stmt.setString(9, kh.getMaKH());
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
