package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import connectDB.ConnectDB;
import entity.KH_CHUA_TT_Phong;

public class KH_CHUA_TT_PhongDAO {
	public ArrayList<KH_CHUA_TT_Phong> loadTTPhong() throws SQLException{
		ArrayList<KH_CHUA_TT_Phong> tt_Phongs = new ArrayList<KH_CHUA_TT_Phong>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "select * from view_SuDungChuaThanhToan_TongHop";
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		if(rs!= null){
			try {
				while(rs.next()){
					tt_Phongs.add(new KH_CHUA_TT_Phong(rs.getString("MaKH"),rs.getString("TenKH"),rs.getString("MaPhieuThuePhong"),rs.getString("MaPhong"),
							rs.getDate("NgayDen")));
				}
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Error!");
				e.printStackTrace();
			}
		}else{
			JOptionPane.showMessageDialog(null, "Dữ liệu trống!");
		}
		return tt_Phongs;
	}
}
