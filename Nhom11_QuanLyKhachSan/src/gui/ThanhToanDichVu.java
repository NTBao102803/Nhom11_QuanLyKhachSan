package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import dao.DungDichVu_DAO;
import dao.KH_CHUA_TT_DVDAO;
import entity.KH_CHUA_TT_DV;
import entity.motDV_TT;

public class ThanhToanDichVu extends JFrame {
	protected JPanel panel_HoaDonTTDV;
	private JTextField txt_phieuSDDV;
	private JTextField txt_MaHD_HDTTDV;
	private JLabel lbl_txt_MaKhach;
	private JLabel lbl_txt_MaDV;
	private JLabel lbl_txt_TenDV;
	private JLabel lbl_txt_TenKH;
	private JLabel lbl_txt_ngaySinh;
	private JLabel lbl_txt_GioiTinh;
	private JLabel lbl_txt_SoCMNN;
	private JLabel lbl_txt_SoDT;
	private JLabel lbl_txt_QueQuan;
	private JLabel lbl_txt_QuocTich;
	private JTable Jtable_MotKH_TT_SDDV;
	private JLabel lbl_txt_TongTienDV;
	protected JPanel panel_KHChuaTT_SDDV;
	private JTable jtable_KHchuaThanhToanSDDV;
	private JLabel label_1_maphieu_txt;
	private KH_CHUA_TT_DVDAO notDVDAO;
	private DefaultTableModel model_KH_ChuaThanhToanSDDV;
	private DefaultTableModel model_MotKH_TT_SDDV;
	private DungDichVu_DAO dv_dao;
	protected JPanel panel_HoaDon_And_KHChuaTT_SDDV;
	private ResultSet rs;

	public ThanhToanDichVu() {
		// TODO Auto-generated constructor stub
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		notDVDAO = new KH_CHUA_TT_DVDAO();
		dv_dao = new DungDichVu_DAO();
		GUI_ThanhToanDichVu();
	}

	public void GUI_ThanhToanDichVu() {
		panel_HoaDon_And_KHChuaTT_SDDV = new JPanel(new BorderLayout());

		panel_HoaDonTTDV = new JPanel();
		panel_HoaDon_And_KHChuaTT_SDDV.add(panel_HoaDonTTDV, BorderLayout.NORTH);
		panel_HoaDonTTDV.setLayout(null);
		panel_HoaDonTTDV.setPreferredSize(new Dimension(1000, 460));

		JLabel lblHanThanh = new JLabel("Hóa đơn thanh toán dịch vụ");
		lblHanThanh.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblHanThanh.setBounds(400, 0, 250, 40);
		panel_HoaDonTTDV.add(lblHanThanh);

		JLabel lbl_MHD_SDDV = new JLabel("Mã hóa đơn DV: ");
		lbl_MHD_SDDV.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		lbl_MHD_SDDV.setBounds(100, 50, 110, 30);
		panel_HoaDonTTDV.add(lbl_MHD_SDDV);

		JLabel lblMPhiuSddv = new JLabel("Mã phiếu SDDV:");
		lblMPhiuSddv.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		lblMPhiuSddv.setBounds(100, 90, 110, 30);
		panel_HoaDonTTDV.add(lblMPhiuSddv);

		txt_MaHD_HDTTDV = new JTextField();
		txt_MaHD_HDTTDV.setBounds(210, 50, 200, 30);
		panel_HoaDonTTDV.add(txt_MaHD_HDTTDV);
		txt_MaHD_HDTTDV.setColumns(10);

		txt_phieuSDDV = new JTextField();
		txt_phieuSDDV.setEnabled(false);
		txt_phieuSDDV.setBounds(210, 90, 200, 30);
		panel_HoaDonTTDV.add(txt_phieuSDDV);
		txt_phieuSDDV.setColumns(10);

		JLabel lbl_MaKHach_SDDV = new JLabel("Mã khách:");
		lbl_MaKHach_SDDV.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		lbl_MaKHach_SDDV.setBounds(100, 130, 110, 30);
		panel_HoaDonTTDV.add(lbl_MaKHach_SDDV);

		lbl_txt_MaKhach = new JLabel("");
		lbl_txt_MaKhach.setBounds(210, 130, 200, 30);
		panel_HoaDonTTDV.add(lbl_txt_MaKhach);
		lbl_txt_MaKhach.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));

		JLabel lblMDv = new JLabel("Mã DV:");
		lblMDv.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		lblMDv.setBounds(100, 170, 110, 30);
		panel_HoaDonTTDV.add(lblMDv);

		lbl_txt_MaDV = new JLabel("");
		lbl_txt_MaDV.setBounds(210, 170, 200, 30);
		panel_HoaDonTTDV.add(lbl_txt_MaDV);
		lbl_txt_MaDV.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));

		JLabel lblTin = new JLabel("Tổng tiền dịch vụ ");
		lblTin.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		lblTin.setBounds(100, 250, 150, 30);
		panel_HoaDonTTDV.add(lblTin);

		JLabel lblTnPhng = new JLabel("Tên DV:");
		lblTnPhng.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		lblTnPhng.setBounds(170, 300, 100, 30);
		panel_HoaDonTTDV.add(lblTnPhng);

		lbl_txt_TenDV = new JLabel("");
		lbl_txt_TenDV.setBounds(290, 300, 100, 30);
		panel_HoaDonTTDV.add(lbl_txt_TenDV);
		lbl_txt_TenDV.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));

		JLabel lblTngTin = new JLabel("Tổng tiền:");
		lblTngTin.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		lblTngTin.setBounds(170, 340, 100, 30);
		panel_HoaDonTTDV.add(lblTngTin);

		lbl_txt_TongTienDV = new JLabel("");
		lbl_txt_TongTienDV.setBounds(290, 340, 100, 30);
		panel_HoaDonTTDV.add(lbl_txt_TongTienDV);
		lbl_txt_TongTienDV.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));

		JLabel lblThngTinKhch = new JLabel("Thông tin khách hàng");
		lblThngTinKhch.setFont(new Font("Times New Roman", Font.ITALIC | Font.BOLD, 14));
		lblThngTinKhch.setBounds(600, 40, 200, 30);
		panel_HoaDonTTDV.add(lblThngTinKhch);

		JLabel lblTnKhch = new JLabel("Tên khách:");
		lblTnKhch.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		lblTnKhch.setBounds(600, 80, 100, 30);
		panel_HoaDonTTDV.add(lblTnKhch);

		JLabel lblNgySinh = new JLabel("Ngày sinh:");
		lblNgySinh.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		lblNgySinh.setBounds(600, 120, 100, 30);
		panel_HoaDonTTDV.add(lblNgySinh);

		JLabel lblGiiTnh = new JLabel("Giới tính:");
		lblGiiTnh.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		lblGiiTnh.setBounds(600, 160, 100, 30);
		panel_HoaDonTTDV.add(lblGiiTnh);

		JLabel lblSCmnn = new JLabel("Số CCCD:");
		lblSCmnn.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		lblSCmnn.setBounds(600, 200, 100, 30);
		panel_HoaDonTTDV.add(lblSCmnn);

		JLabel lblSt = new JLabel("Số ĐT:");
		lblSt.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		lblSt.setBounds(900, 80, 100, 30);
		panel_HoaDonTTDV.add(lblSt);

		JLabel lblQuQun = new JLabel("Quê quán:");
		lblQuQun.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		lblQuQun.setBounds(900, 120, 100, 30);
		panel_HoaDonTTDV.add(lblQuQun);

		JLabel lblQucTich = new JLabel("Quốc tịch: ");
		lblQucTich.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		lblQucTich.setBounds(900, 160, 100, 30);
		panel_HoaDonTTDV.add(lblQucTich);

		lbl_txt_TenKH = new JLabel("");
		lbl_txt_TenKH.setBounds(700, 80, 200, 30);
		panel_HoaDonTTDV.add(lbl_txt_TenKH);
		lbl_txt_TenKH.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));

		lbl_txt_ngaySinh = new JLabel("");
		lbl_txt_ngaySinh.setBounds(700, 120, 110, 30);
		panel_HoaDonTTDV.add(lbl_txt_ngaySinh);
		lbl_txt_ngaySinh.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));

		lbl_txt_GioiTinh = new JLabel("");
		lbl_txt_GioiTinh.setBounds(700, 160, 110, 30);
		panel_HoaDonTTDV.add(lbl_txt_GioiTinh);
		lbl_txt_GioiTinh.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));

		lbl_txt_SoCMNN = new JLabel("");
		lbl_txt_SoCMNN.setBounds(700, 200, 110, 30);
		panel_HoaDonTTDV.add(lbl_txt_SoCMNN);
		lbl_txt_SoCMNN.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));

		lbl_txt_SoDT = new JLabel("");
		lbl_txt_SoDT.setBounds(1000, 80, 110, 30);
		panel_HoaDonTTDV.add(lbl_txt_SoDT);
		lbl_txt_SoDT.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));

		lbl_txt_QueQuan = new JLabel("");
		lbl_txt_QueQuan.setBounds(1000, 120, 110, 30);
		panel_HoaDonTTDV.add(lbl_txt_QueQuan);
		lbl_txt_QueQuan.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));

		lbl_txt_QuocTich = new JLabel("");
		lbl_txt_QuocTich.setBounds(1000, 160, 110, 30);
		panel_HoaDonTTDV.add(lbl_txt_QuocTich);
		lbl_txt_QuocTich.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));

		JLabel lblNewLabel = new JLabel("Chi tiết tên dịch vụ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC | Font.BOLD, 14));
		lblNewLabel.setBounds(600, 250, 200, 30);
		panel_HoaDonTTDV.add(lblNewLabel);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(600, 290, 500, 120);
		panel_HoaDonTTDV.add(scrollPane_1);

		String[] colsMotKH_TT_SDDV = { "Mã KH", "Ngày SD", "Mã DV", "Đơn Giá" };
		model_MotKH_TT_SDDV = new DefaultTableModel(colsMotKH_TT_SDDV, 0);

		Jtable_MotKH_TT_SDDV = new JTable(model_MotKH_TT_SDDV);
		scrollPane_1.setViewportView(Jtable_MotKH_TT_SDDV);

		JButton btnThanhTon = new JButton("Thanh toán");
		btnThanhTon.setIcon(new ImageIcon("item\\1490863900_paypal.png"));
		btnThanhTon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addnewHoaDonTT_SDDV();

				try {
					ConnectDB.getInstance();
					Connection con = ConnectDB.getConnection();
					PreparedStatement stmt = null;
					String sql = "insert into HDDV (HDDV) values(?) ";
					stmt = con.prepareStatement(sql);
					stmt.setString(1, txt_MaHD_HDTTDV.getText());
					stmt.executeQuery();
				} catch (SQLException ex) {

					// e.printStackTrace();
				}
			}
		});
		btnThanhTon.setBounds(120, 380, 140, 30);
		panel_HoaDonTTDV.add(btnThanhTon);

		JButton btnInHoaDon = new JButton("In hóa đơn");
		btnInHoaDon.setIcon(new ImageIcon("item\\1490863938_office-19.png"));
		btnInHoaDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame_InHoaDon_SDDV don_SDDV = new Frame_InHoaDon_SDDV();
				don_SDDV.setVisible(true);

				try {
					String sql = "delete from HDDV where HDDV = ?";
					Connection con = ConnectDB.getConnection();
					PreparedStatement statement = con.prepareStatement(sql);
					statement.setString(1, txt_MaHD_HDTTDV.getText());
					statement.executeUpdate();
				} catch (SQLException ex) {
				}

			}
		});
		btnInHoaDon.setBounds(270, 380, 140, 30);
		panel_HoaDonTTDV.add(btnInHoaDon);

		panel_KHChuaTT_SDDV = new JPanel();
		panel_HoaDon_And_KHChuaTT_SDDV.add(panel_KHChuaTT_SDDV, BorderLayout.CENTER);
		panel_KHChuaTT_SDDV.setLayout(null);

		JLabel lblKhchHngCha = new JLabel("Khách Hàng Chưa Thanh Toán Sử Dụng Dịch Vụ");
		lblKhchHngCha.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblKhchHngCha.setBounds(400, 0, 400, 30);
		panel_KHChuaTT_SDDV.add(lblKhchHngCha);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(400, 40, 700, 150);
		panel_KHChuaTT_SDDV.add(scrollPane);

		String[] colsKH_ChuaThanhToanSDDV = { "Mã Khách", "Tên KH", "Mã phiếu SDDV", "Mã DV", "Ngày SD" };
		model_KH_ChuaThanhToanSDDV = new DefaultTableModel(colsKH_ChuaThanhToanSDDV, 0);

		jtable_KHchuaThanhToanSDDV = new JTable(model_KH_ChuaThanhToanSDDV);
//			load dịch vụ chưa thanh toán
		loadall_KH_CHUA_THANHTOAN_SDDV();

		jtable_KHchuaThanhToanSDDV.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = jtable_KHchuaThanhToanSDDV.getSelectedRow();
				if (row != -1) {
					label_1_maphieu_txt.setText(jtable_KHchuaThanhToanSDDV.getValueAt(row, 2).toString());
				}
			}
		});
		scrollPane.setViewportView(jtable_KHchuaThanhToanSDDV);

		JLabel label_MaPhieu_txt = new JLabel("Mã phiếu: ");
		label_MaPhieu_txt.setBounds(100, 70, 100, 30);
		label_MaPhieu_txt.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		panel_KHChuaTT_SDDV.add(label_MaPhieu_txt);

		label_1_maphieu_txt = new JLabel("");
		label_1_maphieu_txt.setBounds(220, 70, 100, 30);
		panel_KHChuaTT_SDDV.add(label_1_maphieu_txt);
		label_1_maphieu_txt.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));

		JButton button = new JButton("Chọn");
		button.setIcon(new ImageIcon("item\\1490860016_ok_16x16.gif"));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_phieuSDDV.setText(label_1_maphieu_txt.getText());
				doDuLieuLable();
				doDuLieuLable_KhachHang_TTSDDV();
				loadallBangTTSDDV();
			}
		});
		button.setBounds(160, 120, 110, 30);
		panel_KHChuaTT_SDDV.add(button);
	}

	public void loadall_KH_CHUA_THANHTOAN_SDDV() {
		model_KH_ChuaThanhToanSDDV.setRowCount(0);
		ArrayList<KH_CHUA_TT_DV> list = notDVDAO.loadNotDV();
		for (KH_CHUA_TT_DV notDV : list) {
			model_KH_ChuaThanhToanSDDV.addRow(new Object[] { notDV.getMaKhach(), notDV.getTenKhach(),
					notDV.getMaPhieuThue(), notDV.getMaDV(), notDV.getNgaySD(), });
		}
		jtable_KHchuaThanhToanSDDV.setModel(model_KH_ChuaThanhToanSDDV);
	}

	/*------------------------THANH TOÁN SỬ DỤNG DỊCH VỤ---------------------------------*/
	public void doDuLieuLable() {
		String maPhieuSDDV = txt_phieuSDDV.getText().trim();
		// tính tiền dịch vụ = đơn giá * số ngày (tính toán trực tiếp trên sql)
		String sql = "select tbl_SDDV.MaKH,tbl_SDDV.MaDV,tbl_DichVu.TenDV,DATEDIFF(DAY,tbl_SDDV.NgaySD,getDate())*tbl_DichVu.DonGia AS 'TienDV'"
				+ "from tbl_SDDV,tbl_DichVu where tbl_SDDV.MaPhieuSDDV ='" + maPhieuSDDV
				+ "'  AND (tbl_SDDV.MaDV = tbl_DichVu.MaDV)";
		Connection con = ConnectDB.getConnection();
		Statement statement;
		ResultSet rs = null;
		try {
			statement = con.createStatement();
			rs = statement.executeQuery(sql);
			if (rs != null) {
				if (rs.next()) {
					lbl_txt_MaKhach.setText(rs.getString("MaKH"));
					lbl_txt_MaDV.setText(rs.getString("MaDV"));
					lbl_txt_TenDV.setText(rs.getString("TenDV"));
					lbl_txt_TongTienDV.setText(rs.getString("TienDV"));
				}
			} else {
				JOptionPane.showMessageDialog(null, "Trong!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void doDuLieuLable_KhachHang_TTSDDV() {
		String maPhieuSDDV = txt_phieuSDDV.getText().trim();
		//
		String sql = "select TenKH,NgaySinh,GioiTinh,SoCCCD,SoDienThoai,QueQuan,QuocTich from tbl_KhachHang ,tbl_SDDV "
				+ "where tbl_SDDV.MaPhieuSDDV = '" + maPhieuSDDV + "'" + "AND tbl_SDDV.MaKH = tbl_KhachHang.MaKH";
		Connection con = ConnectDB.getConnection();
		Statement statement;
		rs = null;
		try {
			statement = con.createStatement();
			rs = statement.executeQuery(sql);
			if (rs != null) {
				if (rs.next()) {
					lbl_txt_TenKH.setText(rs.getString("TenKH"));
					lbl_txt_ngaySinh.setText(rs.getString("NgaySinh"));
					if (rs.getString("GioiTinh").equals("1"))
						lbl_txt_GioiTinh.setText("Nam");
					else
						lbl_txt_GioiTinh.setText("Nữ");
					lbl_txt_SoCMNN.setText(rs.getString("SoCCCD"));
					lbl_txt_SoDT.setText(rs.getString("SoDienThoai"));
					lbl_txt_QueQuan.setText(rs.getString("QueQuan"));
					lbl_txt_QuocTich.setText(rs.getString("QuocTich"));

				}
			} else {
				JOptionPane.showMessageDialog(null, "Trong!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// load dữ liệu lên bảng khách hàng sử dụng các dịch vụ
	public void loadallBangTTSDDV() {
		model_MotKH_TT_SDDV.setRowCount(0);
		String text1 = txt_phieuSDDV.getText();
		ArrayList<motDV_TT> list = dv_dao.loadMotDV(text1);
		for (motDV_TT motDV_TT : list) {
			model_MotKH_TT_SDDV.addRow(new Object[] { motDV_TT.getMaKH(), motDV_TT.getNgaySDDV(), motDV_TT.getMaDV(),
					motDV_TT.getTenDV(), motDV_TT.getDonGia(), });
		}
		Jtable_MotKH_TT_SDDV.setModel(model_MotKH_TT_SDDV);
	}
	// thêm hóa đơn dịch vụ

	public void addnewHoaDonTT_SDDV() {

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String s = dateFormat.format(date);

		String text1 = txt_MaHD_HDTTDV.getText();
		String text2 = txt_phieuSDDV.getText();

		if (text1 != null && !text1.isEmpty() && text2 != null && !text2.isEmpty()) {

			try {
				ConnectDB.getInstance();
				Connection con = ConnectDB.getConnection();
				PreparedStatement stmt = null;
				String sqlquery = "select * from HoaDonTTSDDV where MaHD = ?";
				stmt = con.prepareStatement(sqlquery);
				stmt.setString(1, text1);
				rs = stmt.executeQuery();
				if (rs.next()) {
					JOptionPane.showMessageDialog(null, "Đã có mã hóa đơn này.");
				} else {
					String sql = "INSERT INTO HoaDonTTSDDV(MaHD,MaPhieuSDDV,MaKH,MaDV,NgayThanhToan,TongTien) VALUES (?,?,?,?,?,?)";
					stmt = con.prepareStatement(sql);
					stmt.setString(1, text1);
					stmt.setString(2, text2);
					stmt.setString(3, lbl_txt_MaKhach.getText());
					stmt.setString(4, lbl_txt_MaDV.getText());
					stmt.setString(5, s.toString());
					stmt.setString(6, lbl_txt_TongTienDV.getText());
					int rowinsert = stmt.executeUpdate();
					if (rowinsert > 0) {
						JOptionPane.showMessageDialog(null, "Thanh Toan Thanh Cong!");
					} else {
						JOptionPane.showMessageDialog(null, "Lỗi !Xem Lai Thanh Toan!");
					}
				}
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Error!");

			}

		} else {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đử thông tin.");
		}
	}
}
