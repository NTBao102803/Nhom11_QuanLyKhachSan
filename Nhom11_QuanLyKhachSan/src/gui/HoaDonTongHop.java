package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import connectDB.ConnectDB;
import dao.KH_CHUA_TT_PhongDAO;
import dao.loadallBangTT_TongHop_DVDAO;
import dao.loadallBangTT_TongHop_PhongDAO;
import entity.KH_CHUA_TT_Phong;
import entity.motPhongTT_TongHop_DV;
import entity.motPhongTT_TongHop_PHONG;

public class HoaDonTongHop extends JFrame {

	protected JPanel panel_HoaDonTongHop;
	private JTextField txt_MaHoaDon_TT_TH;
	private JTextField txt_MaPhieuThue_TT_TH;
	private JTextField txt_MaPhong_TT_TH;
	private JTextField txt_MaKhachHang_TT_TH;
	private JTextField txt_MaDichVu_TT_TH;
	private JLabel lbl_txt_TienPhong_TT_TH;
	private JLabel lbl_txt_TienDichVu_TT_TH;
	private JLabel lbl_txt_TongTien_TT_TH;
	private JLabel lbl_txt_TenKH_TT_TH;
	private JLabel lbl_txt_NgaySinh_TT_TH;
	private JLabel lbl_txt_GioiTinh_TT_TH;
	private JLabel lbl_txt_SoCMND_TT_TH;
	private JLabel lbl_txt_SoDT_TT_TH;
	private JLabel lbl_txt_QueQuan_TT_TH;
	private JLabel lbl_txt_QuocTich_TT_TH;
	private JTable jtable_ChiTietPhong_TT_TH;
	private JTable jtable_ChitietDichVu_TT_TH;
	private JLabel lbl_txt_DatCoc_TT_TH;
	protected JPanel panel_KHChuaTT_PHONG;
	private JLabel lbl_txt_MaPHIEU_KHCHUATT_PHONG;
	private JTable jtable_KHchuaThanhToanPHONG;
	private JLabel lbl_KH_CHUA_TT_P_1;
	private JLabel lbl_KH_CHUA_TT_P_2;
	private JLabel lbl_KH_CHUA_TT_P_3;
	private JLabel lbl_KH_CHUA_TT_P_4;
	private JTextField txt_TimKiem_KH_CHUA_TTPHONG;
	private KH_CHUA_TT_PhongDAO KH_CHUA_TT_Phongdao;
	private DefaultTableModel defaultTableModel;
	private ResultSet rs;

	public HoaDonTongHop() throws SQLException {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		KH_CHUA_TT_Phongdao = new KH_CHUA_TT_PhongDAO();
		GUI_ThanhToan();
		GUI_KH_Chua_TT_Phong();
	}

	/*------------------------PANEL KH_DungDV_CHuaThanhToan PHÒNG-----------------------------*/
	public void GUI_KH_Chua_TT_Phong() throws SQLException {
		panel_KHChuaTT_PHONG = new JPanel();
		panel_KHChuaTT_PHONG.setLayout(null);

		JLabel lblKhchHngCha_1 = new JLabel("Khách Hàng Chưa Thanh Toán Phòng");
		lblKhchHngCha_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblKhchHngCha_1.setBounds(450, 10, 350, 30);
		panel_KHChuaTT_PHONG.add(lblKhchHngCha_1);

		JButton button_1 = new JButton("Chọn");
		button_1.setIcon(new ImageIcon("item\\1490860016_ok_16x16.gif"));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_KHChuaTT_PHONG.setVisible(false);
				panel_HoaDonTongHop.setVisible(true);
				txt_MaPhieuThue_TT_TH.setText(lbl_txt_MaPHIEU_KHCHUATT_PHONG.getText());
				try {
					doDuLieuLable_THANHTOANTONGHOP();
					doDuLieuLable_KhachHang_TT_PHONG();
					loadallBangTT_TongHop_DV();
					loadallBangTT_TongHop_PHONG();
					load_Bang_KH_CHua_TT_Phong();
				} catch (SQLException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
			}
		});
		button_1.setBounds(800, 500, 150, 50);
		panel_KHChuaTT_PHONG.add(button_1);

		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(100, 100, 1000, 350);
		panel_KHChuaTT_PHONG.add(scrollPane_4);

		jtable_KHchuaThanhToanPHONG = new JTable();
		jtable_KHchuaThanhToanPHONG.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = jtable_KHchuaThanhToanPHONG.getSelectedRow();
				if (row != -1) {
					lbl_txt_MaPHIEU_KHCHUATT_PHONG.setText(jtable_KHchuaThanhToanPHONG.getValueAt(row, 2).toString());
					lbl_KH_CHUA_TT_P_1.setText(jtable_KHchuaThanhToanPHONG.getValueAt(row, 0).toString());
					lbl_KH_CHUA_TT_P_2.setText(jtable_KHchuaThanhToanPHONG.getValueAt(row, 1).toString());
					lbl_KH_CHUA_TT_P_3.setText(jtable_KHchuaThanhToanPHONG.getValueAt(row, 3).toString());
					lbl_KH_CHUA_TT_P_4.setText(jtable_KHchuaThanhToanPHONG.getValueAt(row, 4).toString());
				}
			}
		});
		scrollPane_4.setViewportView(jtable_KHchuaThanhToanPHONG);

		JLabel lblThngTinKhch_1 = new JLabel("Thông tin khách hàng: ");
		lblThngTinKhch_1.setFont(new Font("Times New Roman", Font.ITALIC | Font.BOLD, 18));
		lblThngTinKhch_1.setBounds(100, 480, 200, 30);
		panel_KHChuaTT_PHONG.add(lblThngTinKhch_1);

		JLabel lblNewLabel_4 = new JLabel("Mã khách: ");
		lblNewLabel_4.setBounds(100, 520, 100, 30);
		panel_KHChuaTT_PHONG.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.ITALIC, 16));

		JLabel label_5 = new JLabel("Tên khách: ");
		label_5.setBounds(100, 560, 100, 30);
		panel_KHChuaTT_PHONG.add(label_5);
		label_5.setFont(new Font("Times New Roman", Font.ITALIC, 16));

		JLabel lblPhong = new JLabel("Phòng: ");
		lblPhong.setBounds(100, 600, 100, 30);
		panel_KHChuaTT_PHONG.add(lblPhong);
		lblPhong.setFont(new Font("Times New Roman", Font.ITALIC, 16));

		JLabel lblMPhiuThu = new JLabel("Mã phiếu thuê phòng: ");
		lblMPhiuThu.setBounds(450, 520, 200, 30);
		panel_KHChuaTT_PHONG.add(lblMPhiuThu);
		lblMPhiuThu.setFont(new Font("Times New Roman", Font.ITALIC, 16));

		lbl_txt_MaPHIEU_KHCHUATT_PHONG = new JLabel("");
		lbl_txt_MaPHIEU_KHCHUATT_PHONG.setBounds(650, 520, 100, 30);
		panel_KHChuaTT_PHONG.add(lbl_txt_MaPHIEU_KHCHUATT_PHONG);
		lbl_txt_MaPHIEU_KHCHUATT_PHONG.setFont(new Font("Times New Roman", Font.ITALIC | Font.BOLD, 16));

		JLabel lblNgyn = new JLabel("Ngày đến: ");
		lblNgyn.setBounds(450, 560, 100, 30);
		panel_KHChuaTT_PHONG.add(lblNgyn);
		lblNgyn.setFont(new Font("Times New Roman", Font.ITALIC, 16));

		lbl_KH_CHUA_TT_P_1 = new JLabel("");
		lbl_KH_CHUA_TT_P_1.setBounds(210, 520, 150, 30);
		panel_KHChuaTT_PHONG.add(lbl_KH_CHUA_TT_P_1);
		lbl_KH_CHUA_TT_P_1.setFont(new Font("Times New Roman", Font.ITALIC | Font.BOLD, 16));

		lbl_KH_CHUA_TT_P_2 = new JLabel("");
		lbl_KH_CHUA_TT_P_2.setBounds(210, 560, 150, 30);
		panel_KHChuaTT_PHONG.add(lbl_KH_CHUA_TT_P_2);
		lbl_KH_CHUA_TT_P_2.setFont(new Font("Times New Roman", Font.ITALIC | Font.BOLD, 16));

		lbl_KH_CHUA_TT_P_3 = new JLabel("");
		lbl_KH_CHUA_TT_P_3.setBounds(210, 600, 150, 30);
		panel_KHChuaTT_PHONG.add(lbl_KH_CHUA_TT_P_3);
		lbl_KH_CHUA_TT_P_3.setFont(new Font("Times New Roman", Font.ITALIC | Font.BOLD, 16));

		lbl_KH_CHUA_TT_P_4 = new JLabel("");
		lbl_KH_CHUA_TT_P_4.setBounds(560, 560, 150, 30);
		panel_KHChuaTT_PHONG.add(lbl_KH_CHUA_TT_P_4);
		lbl_KH_CHUA_TT_P_4.setFont(new Font("Times New Roman", Font.ITALIC | Font.BOLD, 16));

		JLabel lblTmKim = new JLabel("Tìm kiếm: ");
		lblTmKim.setBounds(110, 60, 100, 30);
		panel_KHChuaTT_PHONG.add(lblTmKim);

		txt_TimKiem_KH_CHUA_TTPHONG = new JTextField();
		txt_TimKiem_KH_CHUA_TTPHONG.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String text = txt_TimKiem_KH_CHUA_TTPHONG.getText().toLowerCase();
				TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(defaultTableModel);
				jtable_KHchuaThanhToanPHONG.setRowSorter(sorter);
				sorter.setRowFilter(RowFilter.regexFilter(text));
				if (text.trim().length() == 0) {
					sorter.setRowFilter(null);
				} else {
					sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
					try {
						load_Bang_KH_CHua_TT_Phong();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		txt_TimKiem_KH_CHUA_TTPHONG.setBounds(210, 60, 350, 30);
		panel_KHChuaTT_PHONG.add(txt_TimKiem_KH_CHUA_TTPHONG);
		txt_TimKiem_KH_CHUA_TTPHONG.setColumns(10);
		load_Bang_KH_CHua_TT_Phong();
	}

	/*------------------------PANEL HOA DON TONG HOP-----------------------------*/
	public void GUI_ThanhToan() {
		panel_HoaDonTongHop = new JPanel();
		panel_HoaDonTongHop.setLayout(null);

		JLabel lbl_hoaDonTongHop = new JLabel("Hóa đơn thanh toán");
		lbl_hoaDonTongHop.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lbl_hoaDonTongHop.setBounds(400, 10, 300, 30);
		panel_HoaDonTongHop.add(lbl_hoaDonTongHop);

		JLabel lblMHan = new JLabel("Mã hóa đơn: ");
		lblMHan.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		lblMHan.setBounds(100, 70, 100, 30);
		panel_HoaDonTongHop.add(lblMHan);

		txt_MaHoaDon_TT_TH = new JTextField();
		txt_MaHoaDon_TT_TH.setBounds(210, 70, 200, 30);
		panel_HoaDonTongHop.add(txt_MaHoaDon_TT_TH);
		txt_MaHoaDon_TT_TH.setColumns(10);

		JLabel lblMPhiu = new JLabel("Mã phiếu thuê: ");
		lblMPhiu.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		lblMPhiu.setBounds(100, 110, 100, 30);
		panel_HoaDonTongHop.add(lblMPhiu);

		JLabel lblMPhng = new JLabel("Phòng: ");
		lblMPhng.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		lblMPhng.setBounds(100, 150, 100, 30);
		panel_HoaDonTongHop.add(lblMPhng);

		JLabel lblM = new JLabel("Mã khách: ");
		lblM.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		lblM.setBounds(100, 190, 100, 20);
		panel_HoaDonTongHop.add(lblM);

		JLabel lblMDchV = new JLabel("Mã dịch vụ: ");
		lblMDchV.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		lblMDchV.setBounds(100, 230, 100, 30);
		panel_HoaDonTongHop.add(lblMDchV);

		txt_MaPhieuThue_TT_TH = new JTextField();
		txt_MaPhieuThue_TT_TH.setEnabled(false);
		txt_MaPhieuThue_TT_TH.setColumns(10);
		txt_MaPhieuThue_TT_TH.setBounds(210, 110, 200, 30);
		panel_HoaDonTongHop.add(txt_MaPhieuThue_TT_TH);

		txt_MaPhong_TT_TH = new JTextField();
		txt_MaPhong_TT_TH.setEnabled(false);
		txt_MaPhong_TT_TH.setColumns(10);
		txt_MaPhong_TT_TH.setBounds(210, 150, 200, 30);
		panel_HoaDonTongHop.add(txt_MaPhong_TT_TH);

		txt_MaKhachHang_TT_TH = new JTextField();
		txt_MaKhachHang_TT_TH.setEnabled(false);
		txt_MaKhachHang_TT_TH.setColumns(10);
		txt_MaKhachHang_TT_TH.setBounds(210, 190, 200, 30);
		panel_HoaDonTongHop.add(txt_MaKhachHang_TT_TH);

		txt_MaDichVu_TT_TH = new JTextField();
		txt_MaDichVu_TT_TH.setEnabled(false);
		txt_MaDichVu_TT_TH.setColumns(10);
		txt_MaDichVu_TT_TH.setBounds(210, 230, 200, 30);
		panel_HoaDonTongHop.add(txt_MaDichVu_TT_TH);

		JLabel lblTngTinThanh = new JLabel("Tổng tiền thanh toán: ");
		lblTngTinThanh.setFont(new Font("Times New Roman", Font.ITALIC | Font.BOLD, 16));
		lblTngTinThanh.setBounds(100, 310, 300, 30);
		panel_HoaDonTongHop.add(lblTngTinThanh);

		JLabel lblNewLabel_1 = new JLabel("Tiền phòng: ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		lblNewLabel_1.setBounds(180, 350, 100, 30);
		panel_HoaDonTongHop.add(lblNewLabel_1);

		JLabel lblTinDchV = new JLabel("Tiền dịch vụ: ");
		lblTinDchV.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		lblTinDchV.setBounds(180, 390, 100, 30);
		panel_HoaDonTongHop.add(lblTinDchV);

		lbl_txt_TienPhong_TT_TH = new JLabel("");
		lbl_txt_TienPhong_TT_TH.setBounds(300, 350, 300, 30);
		panel_HoaDonTongHop.add(lbl_txt_TienPhong_TT_TH);
		lbl_txt_TienPhong_TT_TH.setFont(new Font("Times New Roman", Font.ITALIC | Font.BOLD, 14));

		lbl_txt_TienDichVu_TT_TH = new JLabel("");
		lbl_txt_TienDichVu_TT_TH.setBounds(300, 390, 300, 30);
		panel_HoaDonTongHop.add(lbl_txt_TienDichVu_TT_TH);
		lbl_txt_TienDichVu_TT_TH.setFont(new Font("Times New Roman", Font.ITALIC | Font.BOLD, 14));

		JLabel lblTngTin_1 = new JLabel("Tổng tiền: ");
		lblTngTin_1.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		lblTngTin_1.setBounds(180, 470, 100, 30);
		panel_HoaDonTongHop.add(lblTngTin_1);

		lbl_txt_TongTien_TT_TH = new JLabel("");
		lbl_txt_TongTien_TT_TH.setBounds(300, 470, 300, 30);
		panel_HoaDonTongHop.add(lbl_txt_TongTien_TT_TH);
		lbl_txt_TongTien_TT_TH.setFont(new Font("Times New Roman", Font.ITALIC | Font.BOLD, 14));

		JLabel lbltCc = new JLabel("Đặt cọc: ");
		lbltCc.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		lbltCc.setBounds(180, 430, 100, 30);
		panel_HoaDonTongHop.add(lbltCc);

		lbl_txt_DatCoc_TT_TH = new JLabel("");
		lbl_txt_DatCoc_TT_TH.setBounds(300, 430, 300, 30);
		panel_HoaDonTongHop.add(lbl_txt_DatCoc_TT_TH);
		lbl_txt_DatCoc_TT_TH.setFont(new Font("Times New Roman", Font.ITALIC | Font.BOLD, 14));

		JButton btn_Tim_TT_TH = new JButton("");
		btn_Tim_TT_TH.setIcon(new ImageIcon("item\\1490860025_zoom_16x16.gif"));
		btn_Tim_TT_TH.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				panel_KHChuaTT_PHONG.setVisible(true);
				panel_HoaDonTongHop.setVisible(false);
				try {
					load_Bang_KH_CHua_TT_Phong();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btn_Tim_TT_TH.setBounds(430, 110, 60, 30);
		panel_HoaDonTongHop.add(btn_Tim_TT_TH);

		JButton btn_ThanhTon_TH = new JButton("Thanh toán");
		btn_ThanhTon_TH.setIcon(new ImageIcon("item\\1490863900_paypal.png"));
		btn_ThanhTon_TH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addnewHoaDonTT_TongHop();

				try {
					ConnectDB.getInstance();
					Connection conn = ConnectDB.getConnection();
					PreparedStatement statement = null;
					String sql = "insert into HDTH (HDTH) values(?) ";
					statement = conn.prepareStatement(sql);
					statement.setString(1, txt_MaHoaDon_TT_TH.getText());
					statement.executeQuery();
				} catch (SQLException ex) {

					// e.printStackTrace();
				}
			}
		});
		btn_ThanhTon_TH.setBounds(100, 550, 140, 50);
		btn_ThanhTon_TH.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		panel_HoaDonTongHop.add(btn_ThanhTon_TH);

		JButton btnInhoaDon_TT_TH = new JButton("In hóa đơn");
		btnInhoaDon_TT_TH.setIcon(new ImageIcon("item\\1490863938_office-19.png"));

		btnInhoaDon_TT_TH.setBounds(290, 550, 140, 50);
		btnInhoaDon_TT_TH.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		panel_HoaDonTongHop.add(btnInhoaDon_TT_TH);

		JLabel label = new JLabel("Thông tin khách hàng");
		label.setFont(new Font("Times New Roman", Font.ITALIC | Font.BOLD, 16));
		label.setBounds(600, 70, 300, 30);
		panel_HoaDonTongHop.add(label);

		JLabel label_1 = new JLabel("Tên khách: ");
		label_1.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		label_1.setBounds(600, 110, 100, 30);
		panel_HoaDonTongHop.add(label_1);

		JLabel label_2 = new JLabel("Ngày sinh: ");
		label_2.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		label_2.setBounds(600, 150, 100, 30);
		panel_HoaDonTongHop.add(label_2);

		JLabel label_3 = new JLabel("Số CCCD: ");
		label_3.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		label_3.setBounds(600, 190, 100, 30);
		panel_HoaDonTongHop.add(label_3);

		JLabel label_4 = new JLabel("Giới tính: ");
		label_4.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		label_4.setBounds(600, 230, 100, 30);
		panel_HoaDonTongHop.add(label_4);

		lbl_txt_TenKH_TT_TH = new JLabel("");
		lbl_txt_TenKH_TT_TH.setBounds(700, 110, 200, 30);
		panel_HoaDonTongHop.add(lbl_txt_TenKH_TT_TH);
		lbl_txt_TenKH_TT_TH.setFont(new Font("Times New Roman", Font.ITALIC | Font.BOLD, 14));

		lbl_txt_NgaySinh_TT_TH = new JLabel("");
		lbl_txt_NgaySinh_TT_TH.setBounds(700, 150, 200, 30);
		panel_HoaDonTongHop.add(lbl_txt_NgaySinh_TT_TH);
		lbl_txt_NgaySinh_TT_TH.setFont(new Font("Times New Roman", Font.ITALIC | Font.BOLD, 14));

		lbl_txt_SoCMND_TT_TH = new JLabel("");
		lbl_txt_SoCMND_TT_TH.setBounds(700, 190, 200, 30);
		panel_HoaDonTongHop.add(lbl_txt_SoCMND_TT_TH);
		lbl_txt_SoCMND_TT_TH.setFont(new Font("Times New Roman", Font.ITALIC | Font.BOLD, 14));

		lbl_txt_GioiTinh_TT_TH = new JLabel("");
		lbl_txt_GioiTinh_TT_TH.setBounds(700, 230, 200, 30);
		panel_HoaDonTongHop.add(lbl_txt_GioiTinh_TT_TH);
		lbl_txt_GioiTinh_TT_TH.setFont(new Font("Times New Roman", Font.ITALIC | Font.BOLD, 14));

		JLabel label_9 = new JLabel("Số ĐT: ");
		label_9.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		label_9.setBounds(900, 110, 100, 30);
		panel_HoaDonTongHop.add(label_9);

		JLabel label_10 = new JLabel("Quê quán: ");
		label_10.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		label_10.setBounds(900, 150, 100, 30);
		panel_HoaDonTongHop.add(label_10);

		JLabel label_11 = new JLabel("Quốc tich: ");
		label_11.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		label_11.setBounds(900, 190, 100, 30);
		panel_HoaDonTongHop.add(label_11);

		lbl_txt_SoDT_TT_TH = new JLabel("");
		lbl_txt_SoDT_TT_TH.setBounds(1000, 110, 300, 30);
		panel_HoaDonTongHop.add(lbl_txt_SoDT_TT_TH);
		lbl_txt_SoDT_TT_TH.setFont(new Font("Times New Roman", Font.ITALIC | Font.BOLD, 14));

		lbl_txt_QueQuan_TT_TH = new JLabel("");
		lbl_txt_QueQuan_TT_TH.setBounds(1000, 150, 300, 30);
		panel_HoaDonTongHop.add(lbl_txt_QueQuan_TT_TH);
		lbl_txt_QueQuan_TT_TH.setFont(new Font("Times New Roman", Font.ITALIC | Font.BOLD, 14));

		lbl_txt_QuocTich_TT_TH = new JLabel("");
		lbl_txt_QuocTich_TT_TH.setBounds(1000, 190, 300, 30);
		panel_HoaDonTongHop.add(lbl_txt_QuocTich_TT_TH);
		lbl_txt_QuocTich_TT_TH.setFont(new Font("Times New Roman", Font.ITALIC | Font.BOLD, 14));

		JLabel lblChiTitPhng = new JLabel("Chi tiết phòng ");
		lblChiTitPhng.setFont(new Font("Times New Roman", Font.ITALIC | Font.BOLD, 16));
		lblChiTitPhng.setBounds(600, 280, 200, 30);
		panel_HoaDonTongHop.add(lblChiTitPhng);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(600, 330, 500, 100);
		panel_HoaDonTongHop.add(scrollPane_2);

		jtable_ChiTietPhong_TT_TH = new JTable();
		scrollPane_2.setViewportView(jtable_ChiTietPhong_TT_TH);

		JLabel lblNewLabel_2 = new JLabel("Chi tiết dịch vụ ");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.ITALIC | Font.BOLD, 16));
		lblNewLabel_2.setBounds(600, 450, 200, 30);
		panel_HoaDonTongHop.add(lblNewLabel_2);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(600, 500, 500, 100);
		panel_HoaDonTongHop.add(scrollPane_3);

		jtable_ChitietDichVu_TT_TH = new JTable();
		scrollPane_3.setViewportView(jtable_ChitietDichVu_TT_TH);

	}

	public void load_Bang_KH_CHua_TT_Phong() throws SQLException {
		KH_CHUA_TT_PhongDAO tt_PhongDAO = new KH_CHUA_TT_PhongDAO();
		defaultTableModel = new DefaultTableModel();
		defaultTableModel.addColumn("Mã khách hàng");
		defaultTableModel.addColumn("Tên khách hàng");
		defaultTableModel.addColumn("Mã phiếu thuê phòng");
		defaultTableModel.addColumn("Phòng");
		defaultTableModel.addColumn("Ngày đến");
		for (KH_CHUA_TT_Phong not_TT_Phong : tt_PhongDAO.loadTTPhong()) {
			defaultTableModel.addRow(new Object[] { not_TT_Phong.getMaKH(), not_TT_Phong.getTenKh(),
					not_TT_Phong.getMaPhieuthuephong(), not_TT_Phong.getMaPhong(), not_TT_Phong.getNgayDen(), });
		}
		jtable_KHchuaThanhToanPHONG.setModel(defaultTableModel);
	}

	public void loadallBangTT_TongHop_DV() throws SQLException {
		loadallBangTT_TongHop_DVDAO tt = new loadallBangTT_TongHop_DVDAO();
		defaultTableModel = new DefaultTableModel();
		defaultTableModel.addColumn("Phiếu");
		defaultTableModel.addColumn("Phòng");
		defaultTableModel.addColumn("Mã DV");
		defaultTableModel.addColumn("Tên DV");
		defaultTableModel.addColumn("Tiền dịch vụ");
		for (motPhongTT_TongHop_DV motPhongTT_TongHop_DV : tt.loadMotPhong_DV()) {
			defaultTableModel.addRow(
					new Object[] { motPhongTT_TongHop_DV.getMaPhieuThuePhong(), motPhongTT_TongHop_DV.getMaPhong(),
							motPhongTT_TongHop_DV.getMaDV(), motPhongTT_TongHop_DV.getTenDV(),
							motPhongTT_TongHop_DV.getDonGia(), });
		}
		jtable_ChitietDichVu_TT_TH.setModel(defaultTableModel);
	}

	public void loadallBangTT_TongHop_PHONG() throws SQLException {
		loadallBangTT_TongHop_PhongDAO tt = new loadallBangTT_TongHop_PhongDAO();
		defaultTableModel = new DefaultTableModel();
		defaultTableModel.addColumn("Phiếu");
		defaultTableModel.addColumn("Phòng");
		defaultTableModel.addColumn("Ngày đến");
		defaultTableModel.addColumn("Ngày trả");
		defaultTableModel.addColumn("Số ngày ở");
		defaultTableModel.addColumn("Tiền phòng");
		for (motPhongTT_TongHop_PHONG motPhongTT_TongHop_Phong : tt.loadMotPhong_Phong()) {
			defaultTableModel
					.addRow(new Object[] { motPhongTT_TongHop_Phong.getPhieu(), motPhongTT_TongHop_Phong.getMaPhong(),
							motPhongTT_TongHop_Phong.getNgayDen(), motPhongTT_TongHop_Phong.getNgayTra(),
							motPhongTT_TongHop_Phong.getSoNgayO(), motPhongTT_TongHop_Phong.getTienPhong(), });
		}
		jtable_ChiTietPhong_TT_TH.setModel(defaultTableModel);
	}

	public void doDuLieuLable_THANHTOANTONGHOP() throws SQLException {
		String maPhieuTT_TH = txt_MaPhieuThue_TT_TH.getText().trim();
		String sql = "select *from view_loadLable_TT_Phong where MaPhieuThuePhong='" + maPhieuTT_TH + "'";
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		if (rs != null) {
			try {
				if (rs.next()) {
					txt_MaPhong_TT_TH.setText(rs.getString("MaPhong"));
					txt_MaKhachHang_TT_TH.setText(rs.getString("MaKH"));
					txt_MaDichVu_TT_TH.setText(rs.getString("MaDV"));
					lbl_txt_TienPhong_TT_TH.setText(rs.getString("TienPhong"));
					lbl_txt_TienDichVu_TT_TH.setText(rs.getString("TienDV"));
					lbl_txt_DatCoc_TT_TH.setText(rs.getString("DatCoc"));
					lbl_txt_TongTien_TT_TH.setText(rs.getString("TongTien"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "Trong!");
		}
	}

	public void doDuLieuLable_KhachHang_TT_PHONG() throws SQLException {
		String maPhieuTT_TH = txt_MaPhieuThue_TT_TH.getText().trim();
		String sql = "select TenKH,NgaySinh,GioiTinh,SoCCCD,SoDienThoai,QueQuan,QuocTich from tbl_KhachHang ,tbl_ThuePhong "
				+ "where tbl_ThuePhong.MaPhieuThuePhong = '" + maPhieuTT_TH + "'"
				+ "AND tbl_ThuePhong.MaKH = tbl_KhachHang.MaKH";
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		if (rs != null) {
			try {
				if (rs.next()) {
					lbl_txt_TenKH_TT_TH.setText(rs.getString("TenKH"));
					lbl_txt_NgaySinh_TT_TH.setText(rs.getString("NgaySinh"));
					if (rs.getString("GioiTinh").equals("1"))
						lbl_txt_GioiTinh_TT_TH.setText("Nam");
					else
						lbl_txt_GioiTinh_TT_TH.setText("Nữ");
					lbl_txt_SoCMND_TT_TH.setText(rs.getString("SoCCCD"));
					lbl_txt_SoDT_TT_TH.setText(rs.getString("SoDienThoai"));
					lbl_txt_QueQuan_TT_TH.setText(rs.getString("QueQuan"));
					lbl_txt_QuocTich_TT_TH.setText(rs.getString("QuocTich"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "Trống!");
		}
	}

	public void addnewHoaDonTT_TongHop() {

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = new java.util.Date();
		String s = dateFormat.format(date);

		String text1 = txt_MaHoaDon_TT_TH.getText();
		String text2 = txt_MaPhieuThue_TT_TH.getText();

		if (text1 != null && !text1.isEmpty() && text2 != null && !text2.isEmpty()) {
			try {
				ConnectDB.getInstance();
				Connection con = ConnectDB.getConnection();
				PreparedStatement statement = null;
				String sqlquery = "select * from HoaDonTTTH where MaHDTH = ?";
				statement = con.prepareStatement(sqlquery);
				statement.setString(1, text1);
				rs = statement.executeQuery();
				if (rs.next()) {
					JOptionPane.showMessageDialog(null, "Đã có mã hóa đơn này.");
				} else {
					String sql = "INSERT INTO HoaDonTTTH (MaHDTH,MaPhieuThuePhong,MaKH,MaPhong,MaDV,NgayThanhToan,TienPhong,TienDV,TongTien) VALUES (?,?,?,?,?,?,?,?,?)";
					statement = con.prepareStatement(sql);
					statement.setString(1, text1);
					statement.setString(2, text2);
					statement.setString(3, txt_MaKhachHang_TT_TH.getText());
					statement.setString(4, txt_MaPhong_TT_TH.getText());
					statement.setString(5, txt_MaDichVu_TT_TH.getText());
					statement.setString(6, s.toString());
					statement.setString(7, lbl_txt_TienPhong_TT_TH.getText());
					statement.setString(8, lbl_txt_TienDichVu_TT_TH.getText());
					statement.setString(9, lbl_txt_TongTien_TT_TH.getText());
					int rowinsert = statement.executeUpdate();
					if (rowinsert > 0) {
						JOptionPane.showMessageDialog(null,
								"Thanh toán thành công! mời bạn in hóa đơn cho khách hàng!");
					} else {
						JOptionPane.showMessageDialog(null, "Lỗi !Xem Lai Thanh Toan!");
					}
				}
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Error!");
				e.printStackTrace();
			}

		} else {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đử thông tin.");
		}
	}

}
