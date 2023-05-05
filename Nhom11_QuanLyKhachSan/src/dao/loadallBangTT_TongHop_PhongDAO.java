package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import connectDB.ConnectDB;
import entity.motPhongTT_TongHop_PHONG;


public class loadallBangTT_TongHop_PhongDAO {
	public ArrayList<motPhongTT_TongHop_PHONG> loadMotPhong_Phong() throws SQLException{
		
		ArrayList<motPhongTT_TongHop_PHONG> hop_PHONGs = new ArrayList<motPhongTT_TongHop_PHONG>();
		String sql = "select *from Mot_KH_PHONG ";
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		if(rs != null){
			try {
				while(rs.next()){
					hop_PHONGs.add(new motPhongTT_TongHop_PHONG(rs.getString("MaPhieuThuePhong"), rs.getString("MaPhong"),
							rs.getDate("NgayDen"), rs.getDate("NgayTra"),rs.getInt("SoNgayO"), rs.getFloat("GiaPhong")));
				}
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Error!");
				e.printStackTrace();
			}
		}else{
			JOptionPane.showMessageDialog(null, "Du lieu trong!");
		}
		return hop_PHONGs;
	}
	
}
