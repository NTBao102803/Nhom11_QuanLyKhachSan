package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import connectDB.ConnectDB;
import entity.KH_CHUA_TT_DV;


public class KH_CHUA_TT_DVDAO {
	public ArrayList<KH_CHUA_TT_DV> loadNotDV(){
		ArrayList<KH_CHUA_TT_DV> notDVs = new ArrayList<KH_CHUA_TT_DV>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "select * from view_SuDungChuaThanhToan";
		Statement statement;
		try {
			statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			if(rs != null){
				while(rs.next()){
					String maKH = rs.getString("MaKH");
					String tenKH = rs.getString("TenKH");
					String maPhieuSDDV = rs.getString("MaPhieuSDDV"); 
					String maDV = rs.getString("MaDV");
					Date ngaySD = rs.getDate("NgaySD");
					KH_CHUA_TT_DV notDV = new KH_CHUA_TT_DV(maKH, tenKH, maPhieuSDDV, maDV, ngaySD);
					notDVs.add(notDV);
				}	
			}
			else{
				JOptionPane.showMessageDialog(null,"Dữ liệu trống!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,"Error CSDL roi");
		}
		return notDVs;
	}
}
