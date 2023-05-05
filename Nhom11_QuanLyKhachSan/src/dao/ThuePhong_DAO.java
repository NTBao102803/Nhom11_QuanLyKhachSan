package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.ThuePhong;

public class ThuePhong_DAO {
	public ArrayList<ThuePhong> getAll_ThuePhong() {
		ArrayList<ThuePhong> dsThuePhong = new ArrayList<ThuePhong>();
		
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select *from View_ThuePhong";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String maPhieu = rs.getString(1);
				String maKH = rs.getString(2);
				String tenKH = rs.getString(3);
				String maPhong = rs.getString(4);
				String maDV = rs.getString(5);
				String tenDV = rs.getString(6);
				Date ngayDen = rs.getDate(7);
				Date ngayDi = rs.getDate(8);
				float datCoc = rs.getFloat(9);
				String ghiChu = rs.getString(10);
				
				ThuePhong tp = new ThuePhong(maPhieu, maKH, tenKH, maPhong, maDV, tenDV, ngayDen, ngayDi, datCoc, ghiChu);
				dsThuePhong.add(tp);
			}
		
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsThuePhong;
	}
	
}
