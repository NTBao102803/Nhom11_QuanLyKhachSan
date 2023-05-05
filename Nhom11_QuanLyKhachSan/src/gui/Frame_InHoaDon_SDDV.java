package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import entity.motDV_TT;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;


public class Frame_InHoaDon_SDDV extends JFrame {

	private JPanel contentPane;
	private JTable table;
	public JLabel lbl_txt_SoHD;
	public JLabel lbl_txt_phieusddv;
	public JLabel lbl_txt_NgayThanhToan;
	public JLabel lbl_txt_MaKhachHang;
	public JLabel lbl_txt_tenKhachHang;
	public JLabel lbl_txt_NgaySinh;
	public JLabel lbl_txt_GioiTinh;
	public JLabel lbl_txt_SoCMNN ;
	public JLabel lbl_txt_SoDT;
	public JLabel lbl_txt_QueQuan;
	public JLabel lbl_txt_TongTien;
	public JLabel lbl_txt_QuocTich;
	private DefaultTableModel model_HDTT_DV;
	public static JTextField HDDV;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame_InHoaDon_SDDV frame = new Frame_InHoaDon_SDDV();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Frame_InHoaDon_SDDV() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			ConnectDB.getInstance().connect();
		} catch (Exception e) {
		}
		setBounds(400, 50, 600, 649);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 564, 589);
		contentPane.add(panel);
		panel.setLayout(null);
		
		HDDV = new JTextField();
		HDDV.setBounds(50, 50,0, 0);
		panel.add(HDDV);
		
		JLabel lblNewLabel = new JLabel("Số hóa đơn : ");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel.setBounds(10, 11, 106, 14);
		panel.add(lblNewLabel);
		
		JLabel lblPhiuSDng = new JLabel("Phiếu sử dụng dịch vụ");
		lblPhiuSDng.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblPhiuSDng.setBounds(10, 28, 113, 14);
		panel.add(lblPhiuSDng);
		
		lbl_txt_SoHD = new JLabel("New label");
		lbl_txt_SoHD.setBounds(150, 11, 61, 14);
		panel.add(lbl_txt_SoHD);
		
		lbl_txt_phieusddv = new JLabel("New label");
		lbl_txt_phieusddv.setBounds(150, 28, 61, 14);
		panel.add(lbl_txt_phieusddv);
		
		JLabel lblNgyThnhTon = new JLabel("Ngày thanh toán:");
		lblNgyThnhTon.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNgyThnhTon.setBounds(367, 11, 98, 14);
		panel.add(lblNgyThnhTon);
		
		lbl_txt_NgayThanhToan = new JLabel("New label");
		lbl_txt_NgayThanhToan.setBounds(475, 11, 79, 14);
		panel.add(lbl_txt_NgayThanhToan);
		
		JLabel lblNewLabel_1 = new JLabel("Hóa Đơn Thanh Toán Dịch Vụ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBounds(127, 67, 309, 34);
		panel.add(lblNewLabel_1);
		
		JLabel lblMKhchHng = new JLabel("Mã khách hàng:");
		lblMKhchHng.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblMKhchHng.setBounds(10, 134, 106, 14);
		panel.add(lblMKhchHng);
		
		JLabel lblTnKhchHng = new JLabel("Tên khách hàng:");
		lblTnKhchHng.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblTnKhchHng.setBounds(10, 171, 106, 14);
		panel.add(lblTnKhchHng);
		
		JLabel lblNgySinh = new JLabel("Ngày sinh:");
		lblNgySinh.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNgySinh.setBounds(10, 207, 106, 14);
		panel.add(lblNgySinh);
		
		JLabel lblGiiTnh = new JLabel("Giới tính :");
		lblGiiTnh.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblGiiTnh.setBounds(10, 242, 106, 14);
		panel.add(lblGiiTnh);
		
		JLabel lblSCmnn = new JLabel("Số CCCD:");
		lblSCmnn.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblSCmnn.setBounds(314, 134, 106, 14);
		panel.add(lblSCmnn);
		
		JLabel lblSinThoi = new JLabel("Số điện thoại:");
		lblSinThoi.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblSinThoi.setBounds(314, 171, 106, 14);
		panel.add(lblSinThoi);
		
		JLabel lblQuQun = new JLabel("Quê quán:");
		lblQuQun.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblQuQun.setBounds(314, 207, 106, 14);
		panel.add(lblQuQun);
		
		JLabel lblQucTch = new JLabel("Quốc tịch:");
		lblQucTch.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblQucTch.setBounds(314, 242, 106, 14);
		panel.add(lblQucTch);
		
		lbl_txt_MaKhachHang = new JLabel("New label");
		lbl_txt_MaKhachHang.setBounds(150, 134, 113, 14);
		panel.add(lbl_txt_MaKhachHang);
		
		lbl_txt_tenKhachHang = new JLabel("New label");
		lbl_txt_tenKhachHang.setBounds(150, 171, 113, 14);
		panel.add(lbl_txt_tenKhachHang);
		
		lbl_txt_NgaySinh = new JLabel("New label");
		lbl_txt_NgaySinh.setBounds(150, 207, 113, 14);
		panel.add(lbl_txt_NgaySinh);
		
		lbl_txt_GioiTinh = new JLabel("New label");
		lbl_txt_GioiTinh.setBounds(150, 242, 113, 14);
		panel.add(lbl_txt_GioiTinh);
		
		lbl_txt_SoCMNN = new JLabel("New label");
		lbl_txt_SoCMNN.setBounds(441, 134, 113, 14);
		panel.add(lbl_txt_SoCMNN);
		
		lbl_txt_SoDT = new JLabel("New label");
		lbl_txt_SoDT.setBounds(441, 171, 113, 14);
		panel.add(lbl_txt_SoDT);
		
		lbl_txt_QueQuan = new JLabel("New label");
		lbl_txt_QueQuan.setBounds(441, 207, 113, 14);
		panel.add(lbl_txt_QueQuan);
		
		lbl_txt_QuocTich = new JLabel("New label");
		lbl_txt_QuocTich.setBounds(441, 242, 113, 14);
		panel.add(lbl_txt_QuocTich);
		
		JLabel lblChiTitDch = new JLabel("Chi tiết dịch vụ");
		lblChiTitDch.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblChiTitDch.setBounds(10, 379, 106, 14);
		panel.add(lblChiTitDch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 410, 544, 88);
		panel.add(scrollPane);
		String[] colsHDTT_DV = {"Mã KH", "Ngày SD", "Mã DV", "Tên DV", "Đơn Giá"};
		model_HDTT_DV = new DefaultTableModel(colsHDTT_DV, 0);
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblTngTin = new JLabel("Tổng tiền");
		lblTngTin.setBounds(150, 333, 61, 14);
		panel.add(lblTngTin);
		
		lbl_txt_TongTien = new JLabel("New label");
		lbl_txt_TongTien.setBounds(269, 333, 88, 14);
		panel.add(lbl_txt_TongTien);
		
		doDuLieuLable();
		loadallBangTTSDDV();
	}
	
	public void doDuLieuLable(){
		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sqlqery = "select *from HDDV";
		try {
			Statement statement = con.createStatement();
			 ResultSet rs = statement.executeQuery(sqlqery);
			while(rs.next()){
				HDDV.setText(rs.getString("HDDV"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		String sql ="select *from view_inHoaDon where MaHD = '"+HDDV.getText()+"'";
		try {
			Statement statement = con.createStatement();
			 ResultSet rs = statement.executeQuery(sql);
			if(rs != null){
				if(rs.next()){
					lbl_txt_SoHD.setText(rs.getString("MaHD"));
					lbl_txt_phieusddv.setText(rs.getString("MaPhieuSDDV"));
					lbl_txt_NgayThanhToan.setText(rs.getString("NgayThanhToan"));
					lbl_txt_MaKhachHang.setText(rs.getString("MaKH"));
					lbl_txt_tenKhachHang.setText(rs.getString("TenKH"));
					lbl_txt_NgaySinh.setText(rs.getString("NgaySinh"));
					if (rs.getString("GioiTinh").equals("1"))
						lbl_txt_GioiTinh.setText("Nam");
					else
						lbl_txt_GioiTinh.setText("Nữ");
					lbl_txt_SoCMNN.setText(rs.getString("SoCCCD"));
					lbl_txt_SoDT.setText(rs.getString("SoDienThoai"));
					lbl_txt_QueQuan.setText(rs.getString("QueQuan"));
					lbl_txt_TongTien.setText(rs.getString("TongTien"));
					lbl_txt_QuocTich.setText(rs.getString("QuocTich"));
				}
			} 
			else{
				JOptionPane.showMessageDialog(null,"Trong!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
			
	public void loadallBangTTSDDV(){
		for(motDV_TT motDV_TT : loadMotDV()){
			model_HDTT_DV.addRow(new Object[]{
					motDV_TT.getMaKH(),
					motDV_TT.getNgaySDDV(),
					motDV_TT.getMaDV(),
					motDV_TT.getTenDV(),
					motDV_TT.getDonGia(),
			});
		}
		table.setModel(model_HDTT_DV);
	}
	
	public ArrayList<motDV_TT> loadMotDV(){
		ArrayList<motDV_TT> motDV_TTs = new ArrayList<motDV_TT>();
		
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select *from Mot_DV_KH_SDDV_IN where MaHD = '"+HDDV.getText()+"'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
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
