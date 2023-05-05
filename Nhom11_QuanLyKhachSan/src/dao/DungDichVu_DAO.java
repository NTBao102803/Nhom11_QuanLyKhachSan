package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import java.util.ArrayList;

import javax.swing.JOptionPane;

import connectDB.ConnectDB;
import entity.DichVu;
import entity.motDV_TT;

public class DungDichVu_DAO {
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
	public ArrayList<motDV_TT> loadMotDV(String text1){

		
		ArrayList<motDV_TT> motDV_TTs = new ArrayList<motDV_TT>();
		String sql = "select *from Mot_DV_KH_SDDV where MaPhieuSDDV = '"+text1+"'";
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement statement;
		ResultSet rs = null;
		try {
			statement = con.createStatement();
			rs = statement.executeQuery(sql);
			if(rs != null){
				while(rs.next()){
					motDV_TTs.add(new motDV_TT(rs.getString("MaPhieuSDDV"),rs.getString("MaKH"),rs.getDate("NgaySD"), rs.getString("MaDV"),
							rs.getString("TenDV"), rs.getFloat("DonGia")));
				}
			}else{
				JOptionPane.showMessageDialog(null, "Du lieu trong!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Error!");
		}
		return motDV_TTs;
	}
}
