package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import connectDB.ConnectDB;
import entity.motPhongTT_TongHop_DV;



public class loadallBangTT_TongHop_DVDAO {


	public ArrayList<motPhongTT_TongHop_DV> loadMotPhong_DV() throws SQLException{
		
		ArrayList<motPhongTT_TongHop_DV> motPhongTT_TongHop_DVs = new ArrayList<motPhongTT_TongHop_DV>();
		String sql = "select *from Mot_DV_KH_PHONG ";
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		if(rs != null){
			try {
				while(rs.next()){																									
					motPhongTT_TongHop_DVs.add(new motPhongTT_TongHop_DV(rs.getString("MaPhieuThuePhong"), rs.getString("MaPhong"), rs.getString("MaDV"),rs.getString("TenDV"), rs.getFloat("DonGia")));
				}
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Error!");
				e.printStackTrace();
			}
		}else{
			JOptionPane.showMessageDialog(null, "Du lieu trong!");
		}
		return motPhongTT_TongHop_DVs;
	}
}
