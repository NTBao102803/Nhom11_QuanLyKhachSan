package gui;

import java.awt.Color;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.toedter.calendar.JDateChooser;

import connectDB.ConnectDB;
import dao.DungDichVu_DAO;
import dao.KhachHang_DAO;
import dao.Phong_DAO;
import dao.SuDungDichVu_DAO;
import dao.ThuePhong_DAO;
import entity.DichVu;
import entity.KhachHang;
import entity.Phong;
import entity.SuDungDichVu;
import entity.ThuePhong;

public class QuanLyThuePhong extends JFrame {
	protected JPanel panel_KhachHang;
	private JTextField txt_MaKH_KhachHang;
	private JTextField txt_TenKH_KhachHang;
	private JTextField txt_SoCMNN_KhachHang;
	private JTextField txt_SoDT_KhachHang;
	private JTextField txt_Quenquan_KhachHang;
	private JTextField txt_QuocTich_KhachHang;
	private JDateChooser txt_dateChooser_NgaySInh_KhachHang;
	private JRadioButton rbtn_radioNam_KhachHang;
	private ButtonGroup buttonGroup;
	private JRadioButton rbtn_radioNu_KhachHang;
	private JTextArea txt_textArea_GhiChu_KhachHang;
	private DefaultTableModel model_KhachHang;
	private JTable jtable_KhachHang;
	private JTextField txt_TimKiem_KhachHang;
	private KhachHang_DAO KhachHang_dao;
	private ArrayList<KhachHang> listKhachHang;
	private DungDichVu_DAO dv_dao;
	private Phong_DAO phong_dao;
	private ThuePhong_DAO thuePhong_dao;
	protected JPanel panel_DatPhong;
	private JTextField txt_MaKH_ThuePhong;
	private JComboBox<String> txt_comboBox_MaPhong_ThuePhong;
	private JComboBox<String> txt_comboBox_MaDichVu_ThuePhong;
	private JDateChooser txt_dateChooser_NgayDen_ThuePhong;
	private JDateChooser txt_dateChooser_NgayDi_ThuePhong;
	private JTextField txt_DatCoc_ThuePhong;
	private JTextArea txt_textArea_GhiChu_ThuePhong;
	private DefaultTableModel modelPhong;
	private JTable jtable_PhongTrong_DatPhong;
	private DefaultTableModel modelDichVu;
	private JTable jtable_DichVu_ThuePhong;
	private DefaultTableModel model_ThuePhong;
	private JTextField txt_TimKiem_ThuePhong;
	private JTable jtable_ThuePhong;
	private SuDungDichVu_DAO suDungDichVu_dao;
	protected JPanel panel_SDDV;
	private JTextField txt_MaSDDV_SDDV;
	private JComboBox<String> txt_MaDV_SDDV;
	private ArrayList<DichVu> listDV;
	private JTextField txt_MaKH_SDDV;
	private JDateChooser txt_dateChooser_SDDV;
	private JTextField txt_TimKiem_SDDV;
	private DefaultTableModel model_SDDV;
	private JTable jtable_DanhsachDV;
	private ArrayList<SuDungDichVu> listSDDV;

	public QuanLyThuePhong() {
		// TODO Auto-generated constructor stub
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		KhachHang_dao = new KhachHang_DAO();
		dv_dao = new DungDichVu_DAO();
		phong_dao = new Phong_DAO();
		thuePhong_dao = new ThuePhong_DAO();
		suDungDichVu_dao = new SuDungDichVu_DAO();
		GUI_QuanLyKhachHang();
		GUI_DatPhong();
		GUI_SDDichVu();

	}

// =============== Quản lý khách hàng ===============================
	public void GUI_QuanLyKhachHang() {
		panel_KhachHang = new JPanel();
		panel_KhachHang.setLayout(null);

		JLabel lblDanhMcKhch = new JLabel("Danh mục khách hàng");
		lblDanhMcKhch.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblDanhMcKhch.setBounds(450, 20, 350, 30);
		panel_KhachHang.add(lblDanhMcKhch);

		JLabel lbl_MaKH_KhachHang = new JLabel("Mã KH: ");
		lbl_MaKH_KhachHang.setBounds(100, 80, 100, 30);
		lbl_MaKH_KhachHang.setFont(new Font("Arial", Font.BOLD, 15));
		panel_KhachHang.add(lbl_MaKH_KhachHang);

		JLabel lbl_TenKH_KhachHang = new JLabel("Tên KH: ");
		lbl_TenKH_KhachHang.setBounds(100, 130, 100, 30);
		lbl_TenKH_KhachHang.setFont(new Font("Arial", Font.BOLD, 15));
		panel_KhachHang.add(lbl_TenKH_KhachHang);

		JLabel lbl_NgaySinh_KhachHang = new JLabel("Ngày sinh: ");
		lbl_NgaySinh_KhachHang.setBounds(100, 180, 100, 30);
		lbl_NgaySinh_KhachHang.setFont(new Font("Arial", Font.BOLD, 15));
		panel_KhachHang.add(lbl_NgaySinh_KhachHang);

		JLabel lbl_GioiTinh_KhachHang = new JLabel("Giới tính: ");
		lbl_GioiTinh_KhachHang.setBounds(100, 230, 100, 30);
		lbl_GioiTinh_KhachHang.setFont(new Font("Arial", Font.BOLD, 15));
		panel_KhachHang.add(lbl_GioiTinh_KhachHang);

		JLabel lbl_SoCMNN_KhachHang = new JLabel("Số CCCD: ");
		lbl_SoCMNN_KhachHang.setBounds(100, 280, 100, 30);
		lbl_SoCMNN_KhachHang.setFont(new Font("Arial", Font.BOLD, 15));
		panel_KhachHang.add(lbl_SoCMNN_KhachHang);

		JLabel lbl_SoDT_KhachHang = new JLabel("Số ĐT: ");
		lbl_SoDT_KhachHang.setBounds(700, 80, 100, 30);
		lbl_SoDT_KhachHang.setFont(new Font("Arial", Font.BOLD, 15));
		panel_KhachHang.add(lbl_SoDT_KhachHang);

		JLabel lbl_QueQuan_KhachHang = new JLabel("Quê quán: ");
		lbl_QueQuan_KhachHang.setBounds(700, 130, 100, 30);
		lbl_QueQuan_KhachHang.setFont(new Font("Arial", Font.BOLD, 15));
		panel_KhachHang.add(lbl_QueQuan_KhachHang);

		JLabel lbl_QuocTich_KhachHang = new JLabel("Quốc tịch: ");
		lbl_QuocTich_KhachHang.setBounds(700, 180, 100, 30);
		lbl_QuocTich_KhachHang.setFont(new Font("Arial", Font.BOLD, 15));
		panel_KhachHang.add(lbl_QuocTich_KhachHang);

		JLabel lbl_GhiChu_KhachHang = new JLabel("Ghi chú: ");
		lbl_GhiChu_KhachHang.setBounds(700, 230, 100, 30);
		lbl_GhiChu_KhachHang.setFont(new Font("Arial", Font.BOLD, 15));
		panel_KhachHang.add(lbl_GhiChu_KhachHang);

		txt_MaKH_KhachHang = new JTextField();
		txt_MaKH_KhachHang.setBounds(200, 80, 350, 30);
		panel_KhachHang.add(txt_MaKH_KhachHang);
		txt_MaKH_KhachHang.setColumns(10);

		txt_TenKH_KhachHang = new JTextField();
		txt_TenKH_KhachHang.setColumns(10);
		txt_TenKH_KhachHang.setBounds(200, 130, 350, 30);
		panel_KhachHang.add(txt_TenKH_KhachHang);

		txt_SoCMNN_KhachHang = new JTextField();
		txt_SoCMNN_KhachHang.setColumns(10);
		txt_SoCMNN_KhachHang.setBounds(200, 280, 350, 30);
		panel_KhachHang.add(txt_SoCMNN_KhachHang);

		txt_SoDT_KhachHang = new JTextField();
		txt_SoDT_KhachHang.setColumns(10);
		txt_SoDT_KhachHang.setBounds(800, 80, 350, 30);
		panel_KhachHang.add(txt_SoDT_KhachHang);

		txt_Quenquan_KhachHang = new JTextField();
		txt_Quenquan_KhachHang.setColumns(10);
		txt_Quenquan_KhachHang.setBounds(800, 130, 350, 30);
		panel_KhachHang.add(txt_Quenquan_KhachHang);

		txt_QuocTich_KhachHang = new JTextField();
		txt_QuocTich_KhachHang.setColumns(10);
		txt_QuocTich_KhachHang.setBounds(800, 180, 350, 30);
		panel_KhachHang.add(txt_QuocTich_KhachHang);

		txt_dateChooser_NgaySInh_KhachHang = new JDateChooser();
		txt_dateChooser_NgaySInh_KhachHang.setDateFormatString("yyyy-MM-dd");
		txt_dateChooser_NgaySInh_KhachHang.setBounds(200, 180, 350, 30);
		panel_KhachHang.add(txt_dateChooser_NgaySInh_KhachHang);

		buttonGroup = new ButtonGroup();
		rbtn_radioNam_KhachHang = new JRadioButton("Nam");
		rbtn_radioNam_KhachHang.setSelected(true);
		buttonGroup.add(rbtn_radioNam_KhachHang);
		rbtn_radioNam_KhachHang.setBounds(200, 230, 100, 30);
		rbtn_radioNam_KhachHang.setFont(new Font("Arial", Font.BOLD, 15));
		panel_KhachHang.add(rbtn_radioNam_KhachHang);

		rbtn_radioNu_KhachHang = new JRadioButton("Nữ");
		buttonGroup.add(rbtn_radioNu_KhachHang);
		rbtn_radioNu_KhachHang.setBounds(310, 230, 100, 30);
		rbtn_radioNu_KhachHang.setFont(new Font("Arial", Font.BOLD, 15));
		panel_KhachHang.add(rbtn_radioNu_KhachHang);

		JScrollPane scrollPane_GhiChu_KhachHang = new JScrollPane();
		scrollPane_GhiChu_KhachHang.setBounds(800, 230, 350, 90);
		panel_KhachHang.add(scrollPane_GhiChu_KhachHang);
		txt_textArea_GhiChu_KhachHang = new JTextArea();
		scrollPane_GhiChu_KhachHang.setViewportView(txt_textArea_GhiChu_KhachHang);
		txt_textArea_GhiChu_KhachHang.setLineWrap(true);

		JScrollPane scrollPane_KhachHang = new JScrollPane();
		scrollPane_KhachHang.setBounds(100, 480, 1100, 170);
		panel_KhachHang.add(scrollPane_KhachHang);

		String[] colsKH = { "Mã khách hàng", "Tên khách hàng", "Ngày sinh", "Giới tính", "Số CCCD", "Số điện thoại",
				"Quê quán", "Quốc tịch", "Ghi chú" };
		model_KhachHang = new DefaultTableModel(colsKH, 0);
		jtable_KhachHang = new JTable(model_KhachHang);
		scrollPane_KhachHang.setViewportView(jtable_KhachHang);

		jtable_KhachHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = jtable_KhachHang.getSelectedRow();
				if (row != -1) {
					txt_MaKH_KhachHang.setText(model_KhachHang.getValueAt(row, 0).toString());
					txt_MaKH_KhachHang.setEnabled(false);
					txt_TenKH_KhachHang.setText(model_KhachHang.getValueAt(row, 1).toString());
					try {
						Date date;
						date = new SimpleDateFormat("yyyy-MM-dd")
								.parse((String) model_KhachHang.getValueAt(row, 2).toString());
						txt_dateChooser_NgaySInh_KhachHang.setDate(date);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					if (model_KhachHang.getValueAt(row, 3).equals("Nam")) {
						rbtn_radioNam_KhachHang.setSelected(true);
					} else {
						rbtn_radioNu_KhachHang.setSelected(true);
					}

					txt_SoCMNN_KhachHang.setText(model_KhachHang.getValueAt(row, 4).toString());
					txt_SoDT_KhachHang.setText(model_KhachHang.getValueAt(row, 5).toString());
					txt_Quenquan_KhachHang.setText(model_KhachHang.getValueAt(row, 6).toString());
					txt_QuocTich_KhachHang.setText(model_KhachHang.getValueAt(row, 7).toString());
					txt_textArea_GhiChu_KhachHang.setText(model_KhachHang.getValueAt(row, 8).toString());
				}
			}
		});

		//
		JLabel lbl_Timkiem_KhachHang = new JLabel("Tìm kiếm: ");
		lbl_Timkiem_KhachHang.setBounds(100, 430, 100, 30);
		lbl_Timkiem_KhachHang.setFont(new Font("Arial", Font.BOLD, 15));
		panel_KhachHang.add(lbl_Timkiem_KhachHang);

		txt_TimKiem_KhachHang = new JTextField();
		txt_TimKiem_KhachHang.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				TableRowSorter<DefaultTableModel> s = new TableRowSorter<DefaultTableModel>(model_KhachHang);
				jtable_KhachHang.setRowSorter(s);
				s.setRowFilter(RowFilter.regexFilter(txt_TimKiem_KhachHang.getText()));
			}
		});
		txt_TimKiem_KhachHang.setBounds(200, 430, 350, 30);
		panel_KhachHang.add(txt_TimKiem_KhachHang);
		txt_TimKiem_KhachHang.setColumns(10);

		JButton btn_Them_KhachHang = new JButton("Thêm");
		btn_Them_KhachHang.setIcon(new ImageIcon("item//add-24.png"));
		btn_Them_KhachHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					addNewKhachHang();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btn_Them_KhachHang.setBounds(250, 350, 140, 40);
		panel_KhachHang.add(btn_Them_KhachHang);

		JButton btn_Sua_KhachHang = new JButton("Cập nhật");
		btn_Sua_KhachHang.setIcon(new ImageIcon("item//update-24.png"));
		btn_Sua_KhachHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					updateKhachHang();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
		});
		btn_Sua_KhachHang.setBounds(420, 350, 140, 40);
		panel_KhachHang.add(btn_Sua_KhachHang);

		JButton btn_Xoa_KhachHang = new JButton("Xóa");
		btn_Xoa_KhachHang.setIcon(new ImageIcon("item//remove-24.png"));
		btn_Xoa_KhachHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteKhachHang();
			}

		});
		btn_Xoa_KhachHang.setBounds(590, 350, 140, 40);
		panel_KhachHang.add(btn_Xoa_KhachHang);

		JButton btn_Clear_KhachHang = new JButton("Làm lại");
		btn_Clear_KhachHang.setIcon(new ImageIcon("item//refresh-24.png"));
		btn_Clear_KhachHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear_KhachHang();
			}
		});
		btn_Clear_KhachHang.setBounds(760, 350, 140, 40);
		panel_KhachHang.add(btn_Clear_KhachHang);

		JButton btn_KhachHang_DatPhong = new JButton("Đặt Phòng");
		btn_KhachHang_DatPhong.setIcon(new ImageIcon("item\\1490863141_database_table_(add)_16x16.gif"));
		btn_KhachHang_DatPhong.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				txt_MaKH_ThuePhong.setText(txt_MaKH_KhachHang.getText());
				if ((txt_MaKH_KhachHang.getText()).equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn một khách hàng!");
				} else {
					panel_DatPhong.setVisible(true);
					panel_KhachHang.setVisible(false);
					panel_SDDV.setVisible(false);
				}
			}
		});
		btn_KhachHang_DatPhong.setBounds(800, 430, 130, 30);
		panel_KhachHang.add(btn_KhachHang_DatPhong);

		JButton btn_KhachHang_SDDV = new JButton("Dùng DV");
		btn_KhachHang_SDDV.setIcon(new ImageIcon("item\\1490863141_database_table_(add)_16x16.gif"));
		btn_KhachHang_SDDV.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				txt_MaKH_SDDV.setText(txt_MaKH_KhachHang.getText());
				if ((txt_MaKH_KhachHang.getText()).equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn một khách hàng!");
				} else {
					panel_DatPhong.setVisible(false);
					panel_KhachHang.setVisible(false);
					panel_SDDV.setVisible(true);

				}
			}

		});
		btn_KhachHang_SDDV.setBounds(950, 430, 130, 30);
		panel_KhachHang.add(btn_KhachHang_SDDV);
		loadKhachHang();

		// tooltip các nút chức năng quan lý khách hàng
		btn_Them_KhachHang.setToolTipText("Atl + A");
		btn_Xoa_KhachHang.setToolTipText("Atl + R");
		btn_Sua_KhachHang.setToolTipText("Atl + U");
		btn_Clear_KhachHang.setToolTipText("Atl + C");

		// sử dụng phím tắt
		btn_Them_KhachHang.setMnemonic(KeyEvent.VK_A);
		btn_Xoa_KhachHang.setMnemonic(KeyEvent.VK_R);
		btn_Sua_KhachHang.setMnemonic(KeyEvent.VK_U);
		btn_Clear_KhachHang.setMnemonic(KeyEvent.VK_C);

		btn_KhachHang_DatPhong.setMnemonic(KeyEvent.VK_B);
		btn_KhachHang_SDDV.setMnemonic(KeyEvent.VK_D);
	}

	public void addNewKhachHang() throws ParseException {
		if (validData()) {
			KhachHang kh = revertKhachHang();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String ns = sdf.format(kh.getNgaySinhKH());
			model_KhachHang.addRow(new Object[] { kh.getMaKH(), kh.getTenKH(), ns, kh.getGioiTinhKH(), kh.getSoCMTKH(),
					kh.getSoDienThoaiKH(), kh.getQueQuanKH(), kh.getQuocTichKH(), kh.getGhiChuKH() });
			KhachHang_dao.create_KhachHang(kh);
			JOptionPane.showMessageDialog(null, "Thêm thành công!");
			clear_KhachHang();
		}
	}

	private KhachHang revertKhachHang() throws ParseException {
		// TODO Auto-generated method stub
		String ma = txt_MaKH_KhachHang.getText().trim();
		String ten = txt_TenKH_KhachHang.getText().trim();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String ns = ((JTextField) txt_dateChooser_NgaySInh_KhachHang.getDateEditor().getUiComponent()).getText();
		Date ngaysinh = sdf.parse(ns);
		String gt = rbtn_radioNam_KhachHang.isSelected() ? "Nam" : "Nữ";
		String cccd = txt_SoCMNN_KhachHang.getText().trim();
		String sdt = txt_SoDT_KhachHang.getText().trim();
		String qq = txt_Quenquan_KhachHang.getText().trim();
		String qt = txt_QuocTich_KhachHang.getText().trim();
		String ghichu = txt_textArea_GhiChu_KhachHang.getText().trim();
		return new KhachHang(ma, ten, ngaysinh, gt, cccd, sdt, qq, qt, ghichu);
	}

	// Check dữ liệu
	Border bdFalse = BorderFactory.createLineBorder(Color.red);
	Border bdTrue = BorderFactory.createLineBorder(Color.green);

	private boolean validData() throws ParseException {
		int trung = 0;
		String ma = txt_MaKH_KhachHang.getText().trim();
		String ten = txt_TenKH_KhachHang.getText().trim();
		String ns = ((JTextField) txt_dateChooser_NgaySInh_KhachHang.getDateEditor().getUiComponent()).getText();
		String CCCD = txt_SoCMNN_KhachHang.getText().trim();
		String soDT = txt_SoDT_KhachHang.getText().trim();
		String qq = txt_Quenquan_KhachHang.getText().trim();
		String qt = txt_QuocTich_KhachHang.getText().trim();
		for (KhachHang kh : listKhachHang) {
			if (ma.equals(kh.getMaKH())) {
				trung = 1;
			}
		}
		// check mã khách hàng
		if (trung == 1) {
			JOptionPane.showMessageDialog(this, "Error: Trùng mã!");
			txt_MaKH_KhachHang.requestFocus(true);
			txt_MaKH_KhachHang.setBorder(bdFalse);
			return false;
		}
		if ((ma.length() > 0) || !ma.equals("")) {
			if (!ma.matches("(KH)([0-9]+)")) {
				JOptionPane.showMessageDialog(this, "Error: Mã phải theo mẫu: KH theo sau là số");
				txt_MaKH_KhachHang.requestFocus(true);
				txt_MaKH_KhachHang.setBorder(bdFalse);
				return false;
			} else {
				txt_MaKH_KhachHang.setBorder(bdTrue);
			}
		} else {
			JOptionPane.showMessageDialog(this, "Error: Chưa nhập mã khách hàng!");
			txt_MaKH_KhachHang.requestFocus(true);
			txt_MaKH_KhachHang.setBorder(bdFalse);
			return false;
		}

		// check tên khách hàng
		if (ten.length() > 0 || !ten.equals("")) {
			if (!ten.matches("(^[A-Z])[a-z]+([ ][A-Z][a-z]+)*")) {
				JOptionPane.showMessageDialog(this, "Error: Phải viết hoa chữ cái đầu của tên");
				txt_TenKH_KhachHang.requestFocus(true);
				txt_TenKH_KhachHang.setBorder(bdFalse);
				return false;
			} else {
				txt_TenKH_KhachHang.setBorder(bdTrue);
			}
		} else {
			JOptionPane.showMessageDialog(this, "Chưa nhập tên!");
			txt_TenKH_KhachHang.requestFocus(true);
			txt_TenKH_KhachHang.setBorder(bdFalse);
			return false;
		}

		// check ngày sinh
		if (ns.equals("")) {
			JOptionPane.showMessageDialog(this, "Error: Chưa nhập ngày sinh!");
			txt_dateChooser_NgaySInh_KhachHang.requestFocus(true);
			return false;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date ngaysinh = sdf.parse(ns);
		Date today = new Date();
		@SuppressWarnings("deprecation")
		Date eighteenYearsAgo = new Date(ngaysinh.getYear() + 18, ngaysinh.getMonth(), ngaysinh.getDate());
		if (!eighteenYearsAgo.before(today)) {
			JOptionPane.showMessageDialog(this, "Error: Khách hàng chưa đủ 18 tuổi!");
			txt_dateChooser_NgaySInh_KhachHang.requestFocus(true);
			txt_dateChooser_NgaySInh_KhachHang.setBorder(bdFalse);
			return false;
		} else {
			txt_dateChooser_NgaySInh_KhachHang.setBorder(bdTrue);
		}
		// check CMND
		if (CCCD.length() > 0 || !CCCD.equals("")) {
			if (!CCCD.matches("\\d{12}")) {
				JOptionPane.showMessageDialog(this, "Error: Số chứng minh thư phải đủ 12 số");
				txt_SoCMNN_KhachHang.requestFocus(true);
				txt_SoCMNN_KhachHang.setBorder(bdFalse);
				return false;
			} else {
				txt_SoCMNN_KhachHang.setBorder(bdTrue);
			}
		} else {
			JOptionPane.showMessageDialog(this, "Chưa nhập số căn cước công dân!");
			txt_SoCMNN_KhachHang.requestFocus(true);
			txt_SoCMNN_KhachHang.setBorder(bdFalse);
			return false;
		}

		// check số điện thoại
		if (soDT.length() > 0 || !soDT.equals("")) {
			if (!soDT.matches("\\d{10}")) {
				JOptionPane.showMessageDialog(this, "Error: Số điện thoại phải đủ 10 số");
				txt_SoDT_KhachHang.requestFocus(true);
				txt_SoDT_KhachHang.setBorder(bdFalse);
				return false;
			} else if (!soDT.matches("(0)[1-9]\\d{8}")) {
				JOptionPane.showMessageDialog(this, "Error: Số điện thoại phải bắt đầu bằng 0");
				txt_SoDT_KhachHang.requestFocus(true);
				txt_SoDT_KhachHang.setBorder(bdFalse);
				return false;
			} else {
				txt_SoDT_KhachHang.setBorder(bdTrue);
			}
		} else {
			JOptionPane.showMessageDialog(this, "Chưa nhập số điện thoại!");
			txt_SoDT_KhachHang.requestFocus(true);
			txt_SoDT_KhachHang.setBorder(bdFalse);
			return false;
		}

		// check quê quán
		if (!(qq.length() > 0) || qq.equals("")) {
			JOptionPane.showMessageDialog(this, "Chưa nhập quê quán!");
			txt_Quenquan_KhachHang.requestFocus(true);
			txt_Quenquan_KhachHang.setBorder(bdFalse);
			return false;
		} else {
			txt_Quenquan_KhachHang.setBorder(bdTrue);
		}
		// check quốc tịch
		if (!(qt.length() > 0) || qt.equals("")) {
			JOptionPane.showMessageDialog(this, "Chưa nhập quốc tịch!");
			txt_QuocTich_KhachHang.requestFocus(true);
			txt_QuocTich_KhachHang.setBorder(bdFalse);
			return false;
		} else {
			txt_QuocTich_KhachHang.setBorder(bdTrue);
		}
		return true;
	}

	public void updateKhachHang() throws ParseException {
		int row = jtable_KhachHang.getSelectedRow();
		if (txt_MaKH_KhachHang.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn một khách hàng!");
		} else {
			String ns = ((JTextField) txt_dateChooser_NgaySInh_KhachHang.getDateEditor().getUiComponent()).getText();

			int choice = JOptionPane.showConfirmDialog(null, "Ban có chắc chắn muốn cập nhật khong ?");
			if (choice == JOptionPane.YES_OPTION) {
				if (validDataUpDate()) {
					KhachHang kh = revertKhachHang();
					model_KhachHang.setValueAt(kh.getTenKH(), row, 1);
					model_KhachHang.setValueAt(ns, row, 2);
					model_KhachHang.setValueAt(kh.getGioiTinhKH(), row, 3);
					model_KhachHang.setValueAt(kh.getSoCMTKH(), row, 4);
					model_KhachHang.setValueAt(kh.getSoDienThoaiKH(), row, 5);
					model_KhachHang.setValueAt(kh.getQueQuanKH(), row, 6);
					model_KhachHang.setValueAt(kh.getQuocTichKH(), row, 7);
					model_KhachHang.setValueAt(kh.getGhiChuKH(), row, 8);
					KhachHang_dao.capNhat_KhachHang(kh);
					JOptionPane.showMessageDialog(null, "Cập nhật hoàn tất!");
					clear_KhachHang();
				}
			} else {
				JOptionPane.showMessageDialog(null, "Error!");
			}
		}
	}

	private boolean validDataUpDate() throws ParseException {
		String ten = txt_TenKH_KhachHang.getText().trim();
		String ns = ((JTextField) txt_dateChooser_NgaySInh_KhachHang.getDateEditor().getUiComponent()).getText();
		String CCCD = txt_SoCMNN_KhachHang.getText().trim();
		String soDT = txt_SoDT_KhachHang.getText().trim();
		String qq = txt_Quenquan_KhachHang.getText().trim();
		String qt = txt_QuocTich_KhachHang.getText().trim();

		// check tên khách hàng
		if (ten.length() > 0 || !ten.equals("")) {
			if (!ten.matches("(^[A-Z])[a-z]+([ ][A-Z][a-z]+)+")) {
				JOptionPane.showMessageDialog(this, "Error: Phải viết hoa chữ cái đầu của tên");
				txt_TenKH_KhachHang.requestFocus(true);
				txt_TenKH_KhachHang.setBorder(bdFalse);
				return false;
			} else {
				txt_TenKH_KhachHang.setBorder(bdTrue);
			}
		} else {
			JOptionPane.showMessageDialog(this, "Chưa nhập tên!");
			txt_TenKH_KhachHang.requestFocus(true);
			txt_TenKH_KhachHang.setBorder(bdFalse);
			return false;
		}

		// check ngày sinh
		if (ns.equals("")) {
			JOptionPane.showMessageDialog(this, "Error: Chưa nhập ngày sinh!");
			txt_dateChooser_NgaySInh_KhachHang.requestFocus(true);
			return false;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date ngaysinh = sdf.parse(ns);
		Date today = new Date();
		@SuppressWarnings("deprecation")
		Date eighteenYearsAgo = new Date(ngaysinh.getYear() + 18, ngaysinh.getMonth(), ngaysinh.getDate());
		if (!eighteenYearsAgo.before(today)) {
			JOptionPane.showMessageDialog(this, "Error: Khách hàng chưa đủ 18 tuổi!");
			txt_dateChooser_NgaySInh_KhachHang.requestFocus(true);
			txt_dateChooser_NgaySInh_KhachHang.setBorder(bdFalse);
			return false;
		} else {
			txt_dateChooser_NgaySInh_KhachHang.setBorder(bdTrue);
		}
		// check CMND
		if (CCCD.length() > 0 || !CCCD.equals("")) {
			if (!CCCD.matches("\\d{12}")) {
				JOptionPane.showMessageDialog(this, "Error: Số chứng minh thư phải đủ 12 số");
				txt_SoCMNN_KhachHang.requestFocus(true);
				txt_SoCMNN_KhachHang.setBorder(bdFalse);
				return false;
			} else {
				txt_SoCMNN_KhachHang.setBorder(bdTrue);
			}
		} else {
			JOptionPane.showMessageDialog(this, "Chưa nhập số căn cước công dân!");
			txt_SoCMNN_KhachHang.requestFocus(true);
			txt_SoCMNN_KhachHang.setBorder(bdFalse);
			return false;
		}

		// check số điện thoại
		if (soDT.length() > 0 || !soDT.equals("")) {
			if (!soDT.matches("\\d{10}")) {
				JOptionPane.showMessageDialog(this, "Error: Số điện thoại phải đủ 10 số");
				txt_SoDT_KhachHang.requestFocus(true);
				txt_SoDT_KhachHang.setBorder(bdFalse);
				return false;
			} else if (!soDT.matches("(0)[1-9]\\d{8}")) {
				JOptionPane.showMessageDialog(this, "Error: Số điện thoại phải bắt đầu bằng 0");
				txt_SoDT_KhachHang.requestFocus(true);
				txt_SoDT_KhachHang.setBorder(bdFalse);
				return false;
			} else {
				txt_SoDT_KhachHang.setBorder(bdTrue);
			}
		} else {
			JOptionPane.showMessageDialog(this, "Chưa nhập số điện thoại!");
			txt_SoDT_KhachHang.requestFocus(true);
			txt_SoDT_KhachHang.setBorder(bdFalse);
			return false;
		}

		// check quê quán
		if (!(qq.length() > 0) || qq.equals("")) {
			JOptionPane.showMessageDialog(this, "Chưa nhập quê quán!");
			txt_Quenquan_KhachHang.requestFocus(true);
			txt_Quenquan_KhachHang.setBorder(bdFalse);
			return false;
		} else {
			txt_Quenquan_KhachHang.setBorder(bdTrue);
		}
		// check quốc tịch
		if (!(qt.length() > 0) || qt.equals("")) {
			JOptionPane.showMessageDialog(this, "Chưa nhập quốc tịch!");
			txt_QuocTich_KhachHang.requestFocus(true);
			txt_QuocTich_KhachHang.setBorder(bdFalse);
			return false;
		} else {
			txt_QuocTich_KhachHang.setBorder(bdTrue);
		}
		return true;
	}

	public void deleteKhachHang() {
		int row = jtable_KhachHang.getSelectedRow();
		String ma = txt_MaKH_KhachHang.getText();
		if (ma.equals("")) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn một khách hàng để xóa");
		} else {
			int choice = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa không ?");
			if (choice == JOptionPane.YES_OPTION) {
				model_KhachHang.removeRow(row);
				KhachHang_dao.delete_KhachHang(ma);
				JOptionPane.showMessageDialog(null, "Xóa xong!");
				clear_KhachHang();
			} else {
				JOptionPane.showMessageDialog(null, "Xóa thất bại!");
			}
		}
	}

	public void clear_KhachHang() {
		txt_MaKH_KhachHang.setText("");
		txt_MaKH_KhachHang.setBorder(null);
		txt_MaKH_KhachHang.setEnabled(true);

		txt_TenKH_KhachHang.setText("");
		txt_TenKH_KhachHang.setBorder(null);

		txt_dateChooser_NgaySInh_KhachHang.setDate(null);
		txt_dateChooser_NgaySInh_KhachHang.setBorder(null);

		txt_SoDT_KhachHang.setText("");
		txt_SoDT_KhachHang.setBorder(null);

		txt_SoCMNN_KhachHang.setText("");
		txt_SoCMNN_KhachHang.setBorder(null);

		txt_Quenquan_KhachHang.setText("");
		txt_Quenquan_KhachHang.setBorder(null);

		txt_QuocTich_KhachHang.setText("");
		txt_QuocTich_KhachHang.setBorder(null);

		txt_textArea_GhiChu_KhachHang.setText("");
		txt_textArea_GhiChu_KhachHang.setBorder(null);

		txt_MaKH_SDDV.requestFocus(true);

	}

	// Đọc dữ liệu vào table khách hàng
	public void loadKhachHang() {
		listKhachHang = KhachHang_dao.getAllKhachHang();
		for (KhachHang kh : listKhachHang) {
			model_KhachHang.addRow(new Object[] { kh.getMaKH(), kh.getTenKH(), kh.getNgaySinhKH(), kh.getGioiTinhKH(),
					kh.getSoCMTKH(), kh.getSoDienThoaiKH(), kh.getQueQuanKH(), kh.getQuocTichKH(), kh.getGhiChuKH() });
		}
	}
// =================== Quản lý đặt phòng ==================================

	public void GUI_DatPhong() {

		panel_DatPhong = new JPanel();
		panel_DatPhong.setLayout(null);

		JLabel lbl_MaKH = new JLabel("Mã KH: ");
		lbl_MaKH.setBounds(100, 30, 65, 30);
		panel_DatPhong.add(lbl_MaKH);

		txt_MaKH_ThuePhong = new JTextField();
		txt_MaKH_ThuePhong.setEnabled(false);
		txt_MaKH_ThuePhong.setBounds(180, 30, 400, 30);
		panel_DatPhong.add(txt_MaKH_ThuePhong);
		txt_MaKH_ThuePhong.setColumns(10);

		JLabel lbl_MaPhong = new JLabel("Mã phòng: ");
		lbl_MaPhong.setBounds(100, 70, 65, 30);
		panel_DatPhong.add(lbl_MaPhong);

		txt_comboBox_MaPhong_ThuePhong = new JComboBox<String>();
		txt_comboBox_MaPhong_ThuePhong.setModel(new DefaultComboBoxModel<String>(new String[] { "--Select--" }));

		/* Đổ dữ liệu lên comboBox */
		ArrayList<Phong> listPhong = phong_dao.getAllPhongTrong();
		for (Phong p : listPhong) {
			txt_comboBox_MaPhong_ThuePhong.addItem(p.getMaPhong());
		}

		txt_comboBox_MaPhong_ThuePhong.setBounds(180, 70, 400, 30);
		panel_DatPhong.add(txt_comboBox_MaPhong_ThuePhong);
		JLabel lbl_MaDichVu = new JLabel("Mã DV: ");
		lbl_MaDichVu.setBounds(100, 110, 65, 30);
		panel_DatPhong.add(lbl_MaDichVu);

		txt_comboBox_MaDichVu_ThuePhong = new JComboBox<String>();
		txt_comboBox_MaDichVu_ThuePhong.setModel(new DefaultComboBoxModel<String>(new String[] { "--Select--" }));
		/* Đổ dữ liệu lên comboBox */
		ArrayList<DichVu> listDV = dv_dao.getAllDichVu();
		for (DichVu dv : listDV) {
			txt_comboBox_MaDichVu_ThuePhong.addItem(dv.getMaDichVu());
		}
		txt_comboBox_MaDichVu_ThuePhong.setBounds(180, 110, 400, 30);
		panel_DatPhong.add(txt_comboBox_MaDichVu_ThuePhong);

		JLabel lbl_NgayDen = new JLabel("Ngày đến: ");
		lbl_NgayDen.setBounds(100, 150, 65, 30);
		panel_DatPhong.add(lbl_NgayDen);

		txt_dateChooser_NgayDen_ThuePhong = new JDateChooser();
		txt_dateChooser_NgayDen_ThuePhong.setDateFormatString("yyyy-MM-dd");
		txt_dateChooser_NgayDen_ThuePhong.setBounds(180, 150, 400, 30);
		panel_DatPhong.add(txt_dateChooser_NgayDen_ThuePhong);

		JLabel lblNgyi = new JLabel("Ngày đi: ");
		lblNgyi.setBounds(100, 190, 65, 30);
		panel_DatPhong.add(lblNgyi);

		txt_dateChooser_NgayDi_ThuePhong = new JDateChooser();
		txt_dateChooser_NgayDi_ThuePhong.setDateFormatString("yyyy-MM-dd");
		txt_dateChooser_NgayDi_ThuePhong.setBounds(180, 190, 400, 30);
		panel_DatPhong.add(txt_dateChooser_NgayDi_ThuePhong);

		JLabel lbl_DatCoc = new JLabel("Đặt cọc: ");
		lbl_DatCoc.setBounds(100, 230, 65, 30);
		panel_DatPhong.add(lbl_DatCoc);

		txt_DatCoc_ThuePhong = new JTextField();
		txt_DatCoc_ThuePhong.setToolTipText("vnđ");
		txt_DatCoc_ThuePhong.setBounds(180, 230, 400, 30);
		panel_DatPhong.add(txt_DatCoc_ThuePhong);
		txt_DatCoc_ThuePhong.setColumns(10);

		JLabel lbl_GhiChu = new JLabel("Ghi chú: ");
		lbl_GhiChu.setBounds(100, 270, 65, 30);
		panel_DatPhong.add(lbl_GhiChu);

		JScrollPane scrollPane_GhiChu_DatPhong = new JScrollPane();
		scrollPane_GhiChu_DatPhong.setBounds(180, 270, 400, 80);
		panel_DatPhong.add(scrollPane_GhiChu_DatPhong);

		txt_textArea_GhiChu_ThuePhong = new JTextArea();
		scrollPane_GhiChu_DatPhong.setViewportView(txt_textArea_GhiChu_ThuePhong);
		txt_textArea_GhiChu_ThuePhong.setLineWrap(true);

		JLabel lblDanhSachPhong = new JLabel("Danh sách phòng trống");
		lblDanhSachPhong.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblDanhSachPhong.setBounds(850, 20, 180, 30);
		panel_DatPhong.add(lblDanhSachPhong);

		JScrollPane scrollPane_DanhSachPhongTrong = new JScrollPane();
		scrollPane_DanhSachPhongTrong.setBounds(700, 70, 500, 150);
		panel_DatPhong.add(scrollPane_DanhSachPhongTrong);

		String[] colsP = { "Mã Phòng", "Loại Phòng", "Tình trạng", "Đơn giá" };
		modelPhong = new DefaultTableModel(colsP, 0);

		jtable_PhongTrong_DatPhong = new JTable(modelPhong);
		scrollPane_DanhSachPhongTrong.setViewportView(jtable_PhongTrong_DatPhong);
//		==========Load dữ liệu từ sql lên Table==========
		loadPhongTrong();

		JLabel lblDanhSachDichVu = new JLabel("Danh sách dịch vụ");
		lblDanhSachDichVu.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblDanhSachDichVu.setBounds(850, 240, 180, 30);
		panel_DatPhong.add(lblDanhSachDichVu);

		JScrollPane scrollPane_DanhSachDV = new JScrollPane();
		scrollPane_DanhSachDV.setBounds(700, 290, 500, 150);
		panel_DatPhong.add(scrollPane_DanhSachDV);

		String[] colsDV = { "Mã dịch vụ", "Tên dịch vụ", "Đơn giá" };
		modelDichVu = new DefaultTableModel(colsDV, 0);

		jtable_DichVu_ThuePhong = new JTable(modelDichVu);
		scrollPane_DanhSachDV.setViewportView(jtable_DichVu_ThuePhong);
//		==========Load dữ liệu từ sql lên Table==========
		loadDichVu();

		JButton btn_DatPhong_ThuePhong = new JButton("Đặt Phòng");
		btn_DatPhong_ThuePhong.setIcon(new ImageIcon("item\\1490860016_ok_16x16.gif"));
		btn_DatPhong_ThuePhong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addNew_ThuePhong();
			}
		});
		btn_DatPhong_ThuePhong.setBounds(50, 390, 140, 50);
		panel_DatPhong.add(btn_DatPhong_ThuePhong);

		JButton btn_SuaPhong_ThuePhong = new JButton("Cập nhật");
		btn_SuaPhong_ThuePhong.setIcon(new ImageIcon("item//update-24.png"));
		btn_SuaPhong_ThuePhong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update_ThuePhong();
			}
		});
		btn_SuaPhong_ThuePhong.setBounds(210, 390, 140, 50);
		panel_DatPhong.add(btn_SuaPhong_ThuePhong);

		JButton btn_Xoa_ThuePhong = new JButton("Xóa");
		btn_Xoa_ThuePhong.setIcon(new ImageIcon("item//remove-24.png"));
		btn_Xoa_ThuePhong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete_ThuePhong();
			}
		});
		btn_Xoa_ThuePhong.setBounds(370, 390, 140, 50);
		panel_DatPhong.add(btn_Xoa_ThuePhong);

		JButton btn_Clear_ThuePhong = new JButton("Làm lại");
		btn_Clear_ThuePhong.setIcon(new ImageIcon("item//refresh-24.png"));
		btn_Clear_ThuePhong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clear_ThuePhong();
			}
		});
		btn_Clear_ThuePhong.setBounds(530, 390, 140, 50);
		panel_DatPhong.add(btn_Clear_ThuePhong);

		JLabel lbl_TimKiem_ThuePhong = new JLabel("Tìm kiếm: ");
		lbl_TimKiem_ThuePhong.setBounds(100, 480, 65, 30);
		panel_DatPhong.add(lbl_TimKiem_ThuePhong);

		String[] colsThuePhong = { "Mã Phiếu Thuê Phòng", "Mã khách hàng", "Tên khách hàng", "Mã phòng", "Mã dịch vụ",
				"Tên dịch vụ", "Ngày đến", "Ngày đi", "Đặt cọc", "Ghi chú" };
		model_ThuePhong = new DefaultTableModel(colsThuePhong, 0);

		txt_TimKiem_ThuePhong = new JTextField();
		txt_TimKiem_ThuePhong.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				String text = txt_TimKiem_ThuePhong.getText().toLowerCase();
				TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(model_ThuePhong);
				jtable_ThuePhong.setRowSorter(sorter);
				sorter.setRowFilter(RowFilter.regexFilter(text));
				if (text.trim().length() == 0) {
					sorter.setRowFilter(null);
				} else {
					sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
					model_ThuePhong.setRowCount(0);
					loadThuePhong();
				}
			}
		});
		txt_TimKiem_ThuePhong.setBounds(190, 480, 300, 30);
		panel_DatPhong.add(txt_TimKiem_ThuePhong);
		txt_TimKiem_ThuePhong.setColumns(10);

		jtable_ThuePhong = new JTable(model_ThuePhong);
		// load dữ liệu bảng thuê phòng
		loadThuePhong();

		JScrollPane scrollPane_ThuePhong = new JScrollPane();
		scrollPane_ThuePhong.setBounds(100, 530, 1100, 120);
		panel_DatPhong.add(scrollPane_ThuePhong);
		scrollPane_ThuePhong.setViewportView(jtable_ThuePhong);
//		click vào table
		jtable_ThuePhong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = jtable_ThuePhong.getSelectedRow();
				if (row != -1) {
					txt_MaKH_ThuePhong.setText(model_ThuePhong.getValueAt(row, 1).toString()); // dữ liệu chạy từ 0
																								// nhưng vì có mã thuê
																								// phòng lên dữ liệu
																								// chạy từ 1
					txt_MaKH_ThuePhong.setEnabled(false);
					txt_comboBox_MaPhong_ThuePhong.setSelectedItem(model_ThuePhong.getValueAt(row, 3).toString());
					txt_comboBox_MaDichVu_ThuePhong.setSelectedItem(model_ThuePhong.getValueAt(row, 4).toString());
					try {
						Date date_1 = new SimpleDateFormat("yyyy-MM-dd")
								.parse((String) model_ThuePhong.getValueAt(row, 6).toString());
						txt_dateChooser_NgayDen_ThuePhong.setDate(date_1);
						Date date_2 = new SimpleDateFormat("yyyy-MM-dd")
								.parse((String) model_ThuePhong.getValueAt(row, 7).toString());
						txt_dateChooser_NgayDi_ThuePhong.setDate(date_2);
					} catch (ParseException e) {
						e.printStackTrace();
					}
					txt_DatCoc_ThuePhong.setText(model_ThuePhong.getValueAt(row, 8).toString());
					txt_textArea_GhiChu_ThuePhong.setText(model_ThuePhong.getValueAt(row, 9).toString());
				}
			}
		});

		JButton btn_dangKiKH_ThuePhong = new JButton("Đăng ký khách hàng");
		btn_dangKiKH_ThuePhong.setIcon(new ImageIcon("item\\1490860138_user9_(add)_16x16.gif"));
		btn_dangKiKH_ThuePhong.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel_DatPhong.setVisible(false);
				panel_KhachHang.setVisible(true);
				panel_SDDV.setVisible(false);

			}
		});
		btn_dangKiKH_ThuePhong.setBounds(900, 480, 185, 30);
		panel_DatPhong.add(btn_dangKiKH_ThuePhong);

		// tooltip các nút chức năng của quản lý đặt phòng
		btn_DatPhong_ThuePhong.setToolTipText("Atl + D");
		btn_Xoa_ThuePhong.setToolTipText("Atl + R");
		btn_SuaPhong_ThuePhong.setToolTipText("Atl + U");
		btn_Clear_ThuePhong.setToolTipText("Atl + C");
		btn_dangKiKH_ThuePhong.setToolTipText("Alt + K");

		// sử dụng phím tắt
		btn_DatPhong_ThuePhong.setMnemonic(KeyEvent.VK_D);
		btn_Xoa_ThuePhong.setMnemonic(KeyEvent.VK_R);
		btn_SuaPhong_ThuePhong.setMnemonic(KeyEvent.VK_U);
		btn_Clear_ThuePhong.setMnemonic(KeyEvent.VK_C);
		btn_dangKiKH_ThuePhong.setMnemonic(KeyEvent.VK_K);
	}

	// đọc dữ liệu vào table phòng trống
	public void loadPhongTrong() {
		ArrayList<Phong> listPhong = phong_dao.getAllPhongTrong();
		for (Phong p : listPhong) {
			modelPhong.addRow(new Object[] { p.getMaPhong(), p.getLoaiPhong(), p.getTinhTrang(), p.getGiaPhong() });
		}
	}

	// đọc dữ liệu vào table thuê phòng
	public void loadThuePhong() {
		ArrayList<ThuePhong> listThuePhong = thuePhong_dao.getAll_ThuePhong();
		for (ThuePhong tp : listThuePhong) {
			model_ThuePhong.addRow(new Object[] { tp.getMaThuePhong(), tp.getMaKH(), tp.getTenKH(), tp.getMaPhong(),
					tp.getMaDV(), tp.getTenDV(), tp.getNgayDen(), tp.getNgayDi(), tp.getDatCoc(), tp.getGhiChu() });
		}
	}

	// làm mới thuê phòng
	public void clear_ThuePhong() {
		txt_MaKH_ThuePhong.setText("");
		txt_comboBox_MaDichVu_ThuePhong.setSelectedItem(null);
		txt_comboBox_MaPhong_ThuePhong.setSelectedItem(null);
		txt_DatCoc_ThuePhong.setText("");
		txt_dateChooser_NgayDen_ThuePhong.setDate(null);
		txt_dateChooser_NgayDi_ThuePhong.setDate(null);
		txt_textArea_GhiChu_ThuePhong.setText("");
	}

	// Đặt phòng
	public void addNew_ThuePhong() {
		String text1 = txt_MaKH_ThuePhong.getText();
		String text2 = txt_DatCoc_ThuePhong.getText();
		if (text1 != null && !text1.isEmpty() && text2 != null && !text2.isEmpty()) {
			String sqlquery = "SELECT * FROM tbl_ThuePhong WHERE MaPhong= ?";
			try {
				ConnectDB.getInstance();
				Connection con = ConnectDB.getConnection();
				PreparedStatement stmt = null;
				stmt = con.prepareStatement(sqlquery);
				stmt.setString(1, txt_comboBox_MaPhong_ThuePhong.getSelectedItem().toString());
				ResultSet rs = stmt.executeQuery();
				if (rs.next()) {
					JOptionPane.showMessageDialog(this, "Đã có mã phòng này rồi!");
				} else {
					String sql = "INSERT INTO tbl_ThuePhong(MaKH,MaPhong,MaDV,NgayDen,NgayDi,DatCoc,GhiChu) VALUES (?,?,?,?,?,?,?)";
					stmt = con.prepareStatement(sql);
					stmt.setString(1, txt_MaKH_ThuePhong.getText());
					stmt.setString(2, txt_comboBox_MaPhong_ThuePhong.getSelectedItem().toString());
					stmt.setString(3, txt_comboBox_MaDichVu_ThuePhong.getSelectedItem().toString());
					stmt.setString(4, ((JTextField) txt_dateChooser_NgayDen_ThuePhong.getDateEditor().getUiComponent())
							.getText());
					stmt.setString(5,
							((JTextField) txt_dateChooser_NgayDi_ThuePhong.getDateEditor().getUiComponent()).getText());
					stmt.setString(6, txt_DatCoc_ThuePhong.getText());
					stmt.setString(7, txt_textArea_GhiChu_ThuePhong.getText());
					int rowIsert = stmt.executeUpdate();
					if (rowIsert > 0) {
						JOptionPane.showMessageDialog(null, "Đặt phòng thành công.");

						model_ThuePhong.setRowCount(0);
						loadThuePhong();
						clear_ThuePhong();
					} else {
						JOptionPane.showMessageDialog(null, "Error!");
					}
					ArrayList<Phong> listPhong = phong_dao.getAllPhongTrong();
					for (Phong p : listPhong) {
						txt_comboBox_MaPhong_ThuePhong.addItem(p.getMaPhong());
					}
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Bạn phải đăng ký khách hàng trước!");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!");
		}
	}

	// cập nhật đặt phòng
	public void update_ThuePhong() {
		String sql = "UPDATE tbl_ThuePhong SET MaPhong=?,MaDV=?,NgayDen=?,NgayDi=?,DatCoc=?,GhiChu=? WHERE MaKH=?";
		try {
			String maKH = txt_MaKH_ThuePhong.getText();
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			PreparedStatement stmt = null;
			stmt = con.prepareStatement(sql);
			stmt.setString(1, txt_comboBox_MaPhong_ThuePhong.getSelectedItem().toString());
			stmt.setString(2, txt_comboBox_MaDichVu_ThuePhong.getSelectedItem().toString());
			stmt.setString(3,
					((JTextField) txt_dateChooser_NgayDen_ThuePhong.getDateEditor().getUiComponent()).getText());
			stmt.setString(4,
					((JTextField) txt_dateChooser_NgayDi_ThuePhong.getDateEditor().getUiComponent()).getText());
			stmt.setString(5, txt_DatCoc_ThuePhong.getText());
			stmt.setString(6, txt_textArea_GhiChu_ThuePhong.getText());
			stmt.setString(7, maKH);

			int rowUpdate = stmt.executeUpdate();
			if (rowUpdate > 0) {
				model_ThuePhong.setRowCount(0);
				loadThuePhong();
				clear_ThuePhong();
				JOptionPane.showMessageDialog(null, "Cập nhật thành công!");
			} else {
				JOptionPane.showMessageDialog(null, "Error!");
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Chọn một khách hàng trước khi sửa!");
		}
	}

	// xóa một khách hàng đặt phòng
	public void delete_ThuePhong() {
		String sql = "DELETE FROM tbl_ThuePhong WHERE MaPhong =?";
		int choice = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa không?");
		if (choice == JOptionPane.YES_OPTION) {
			try {
				String maPhong = txt_comboBox_MaPhong_ThuePhong.getSelectedItem().toString();
				ConnectDB.getInstance();
				Connection con = ConnectDB.getConnection();
				PreparedStatement stmt = null;
				stmt = con.prepareStatement(sql);
				stmt.setString(1, maPhong);
				int rowDelete = stmt.executeUpdate();
				if (rowDelete > 0) {
					model_ThuePhong.setRowCount(0);
					loadThuePhong();
					clear_ThuePhong();
					JOptionPane.showMessageDialog(null, "Xóa thành công.");
				} else {
					JOptionPane.showMessageDialog(null, "Error!");
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Lỗi ! Vui lòng kiểm tra lại!");
			}
		}
	}

//	=================== Quản lý sử dụng dịch vụ =================================
	public void GUI_SDDichVu() {
		panel_SDDV = new JPanel();
		panel_SDDV.setLayout(null);

		JLabel lbl_MaSDDV_SDDV = new JLabel("Mã phiếu SDDV: ");
		lbl_MaSDDV_SDDV.setBounds(100, 30, 100, 30);
		panel_SDDV.add(lbl_MaSDDV_SDDV);

		txt_MaSDDV_SDDV = new JTextField();
		txt_MaSDDV_SDDV.setBounds(200, 30, 400, 30);
		panel_SDDV.add(txt_MaSDDV_SDDV);
		txt_MaSDDV_SDDV.setColumns(10);

		JLabel lbl_MaKH_SDDV = new JLabel("Mã KH: ");
		lbl_MaKH_SDDV.setBounds(100, 80, 100, 30);
		panel_SDDV.add(lbl_MaKH_SDDV);

		JLabel lbl_NgaySD_SDDV = new JLabel("Ngày SD: ");
		lbl_NgaySD_SDDV.setBounds(100, 130, 100, 30);
		panel_SDDV.add(lbl_NgaySD_SDDV);

		JLabel lbl_MaDV_SDDV = new JLabel("Mã DV: ");
		lbl_MaDV_SDDV.setBounds(100, 180, 100, 30);
		panel_SDDV.add(lbl_MaDV_SDDV);

		txt_MaDV_SDDV = new JComboBox<String>();
		txt_MaDV_SDDV.setModel(new DefaultComboBoxModel<String>(new String[] { "--Select--" }));
		txt_MaDV_SDDV.setBounds(200, 180, 400, 30);
		panel_SDDV.add(txt_MaDV_SDDV);

		/* Đổ dữ liệu lên comboBox */
		listDV = dv_dao.getAllDichVu();
		for (DichVu dv : listDV) {
			txt_MaDV_SDDV.addItem(dv.getMaDichVu());
		}

		txt_MaKH_SDDV = new JTextField();
		txt_MaKH_SDDV.setBounds(200, 80, 400, 30);
		txt_MaKH_SDDV.setEnabled(false);
		panel_SDDV.add(txt_MaKH_SDDV);
		txt_MaKH_SDDV.setColumns(10);

		txt_dateChooser_SDDV = new JDateChooser();
		txt_dateChooser_SDDV.setDateFormatString("yyyy-MM-dd");
		txt_dateChooser_SDDV.setBounds(200, 130, 400, 30);
		panel_SDDV.add(txt_dateChooser_SDDV);

		JPanel panel_HinhAnhDV = new JPanel();
		panel_HinhAnhDV.setBorder(BorderFactory.createTitledBorder("Các dịch vụ chính của khách sạn"));
		// panel_HinhAnhDV.setLayout(null);
		panel_HinhAnhDV.setBounds(180, 400, 900, 220);
		JLabel lblAnh1 = new JLabel();
		lblAnh1.setIcon(new ImageIcon("item//anh1.jpg"));
		panel_HinhAnhDV.add(lblAnh1);

		JLabel lblAnh2 = new JLabel();
		lblAnh2.setIcon(new ImageIcon("item//anh2.jpg"));
		panel_HinhAnhDV.add(lblAnh2);

		JLabel lblAnh3 = new JLabel();
		lblAnh3.setIcon(new ImageIcon("item//anh3.jpg"));
		panel_HinhAnhDV.add(lblAnh3);
		panel_SDDV.add(panel_HinhAnhDV);

		JButton btn_Them_SDDV = new JButton("Thêm");
		btn_Them_SDDV.setIcon(new ImageIcon("item//add-24.png"));
		btn_Them_SDDV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addnew_SDDV();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
		});
		btn_Them_SDDV.setBounds(100, 250, 110, 40);
		panel_SDDV.add(btn_Them_SDDV);

		JButton btn_Sua_SDDV = new JButton("Cập nhật");
		btn_Sua_SDDV.setIcon(new ImageIcon("item//update-24.png"));
		btn_Sua_SDDV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					update_SDDV();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
		});
		btn_Sua_SDDV.setBounds(230, 250, 110, 40);
		panel_SDDV.add(btn_Sua_SDDV);

		JButton btn_Xoa_SDDV = new JButton("Xóa");
		btn_Xoa_SDDV.setIcon(new ImageIcon("item//remove-24.png"));
		btn_Xoa_SDDV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete_SDDV();
			}
		});
		btn_Xoa_SDDV.setBounds(360, 250, 110, 40);
		panel_SDDV.add(btn_Xoa_SDDV);

		JButton btn_Clear_SDDV = new JButton("Làm lại");
		btn_Clear_SDDV.setIcon(new ImageIcon("item//refresh-24.png"));
		btn_Clear_SDDV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear_SDDV();
			}
		});
		btn_Clear_SDDV.setBounds(490, 250, 110, 40);
		panel_SDDV.add(btn_Clear_SDDV);

		JButton btn_SDDV_KhachHang = new JButton("Đăng ký KH");
		btn_SDDV_KhachHang.setIcon(new ImageIcon("item\\1490860138_user9_(add)_16x16.gif"));
		btn_SDDV_KhachHang.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel_DatPhong.setVisible(false);
				panel_KhachHang.setVisible(true);
				panel_SDDV.setVisible(false);

			}
		});
		btn_SDDV_KhachHang.setBounds(100, 320, 150, 30);
		panel_SDDV.add(btn_SDDV_KhachHang);

//		Danh sách sử dụng dịch vụ
		JScrollPane scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(750, 70, 450, 200);
		panel_SDDV.add(scrollPane_6);

		String[] colsSDDV = { "Mã phiếu SDDV", "Mã Khách hàng", "Mã dịch vụ", "Ngày sử dụng" };
		model_SDDV = new DefaultTableModel(colsSDDV, 0);

		jtable_DanhsachDV = new JTable(model_SDDV);
		scrollPane_6.setViewportView(jtable_DanhsachDV);
		loadDV_SDDV();
		jtable_DanhsachDV.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = jtable_DanhsachDV.getSelectedRow();
				if (row != -1) {
					txt_MaSDDV_SDDV.setText(model_SDDV.getValueAt(row, 0).toString());
					txt_MaSDDV_SDDV.setEnabled(false);
					txt_MaKH_SDDV.setText(model_SDDV.getValueAt(row, 1).toString());
					txt_MaDV_SDDV.setSelectedItem(model_SDDV.getValueAt(row, 2).toString());
					try {
						Date date = new SimpleDateFormat("yyyy-MM-dd")
								.parse((String) model_SDDV.getValueAt(row, 3).toString());
						txt_dateChooser_SDDV.setDate(date);
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
			}
		});

		JLabel lblTmKiem_SDDV = new JLabel("Tìm kiếm: ");
		lblTmKiem_SDDV.setBounds(750, 290, 100, 30);
		panel_SDDV.add(lblTmKiem_SDDV);

		txt_TimKiem_SDDV = new JTextField();
		txt_TimKiem_SDDV.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				String text = txt_TimKiem_SDDV.getText().toLowerCase();
				TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(model_SDDV);
				jtable_DanhsachDV.setRowSorter(sorter);
				sorter.setRowFilter(RowFilter.regexFilter(text));
				if (text.trim().length() == 0) {
					sorter.setRowFilter(null);
				} else {
					sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
					model_SDDV.setRowCount(0);
					loadDV_SDDV();
				}
			}
		});
		txt_TimKiem_SDDV.setBounds(850, 290, 250, 30);
		panel_SDDV.add(txt_TimKiem_SDDV);
		txt_TimKiem_SDDV.setColumns(10);
		JLabel lblNewLabel_5 = new JLabel("Danh sách dịch vụ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.ITALIC | Font.BOLD, 18));
		lblNewLabel_5.setBounds(880, 20, 180, 30);
		panel_SDDV.add(lblNewLabel_5);

		// tooltip các nút chức năng của dùng dịch vụ
		btn_Them_SDDV.setToolTipText("Atl + A");
		btn_Xoa_SDDV.setToolTipText("Atl + R");
		btn_Sua_SDDV.setToolTipText("Atl + U");
		btn_Clear_SDDV.setToolTipText("Atl + C");
		btn_SDDV_KhachHang.setToolTipText("Atl + K");

		// sử dụng phím tắt
		btn_Them_SDDV.setMnemonic(KeyEvent.VK_A);
		btn_Xoa_SDDV.setMnemonic(KeyEvent.VK_R);
		btn_Sua_SDDV.setMnemonic(KeyEvent.VK_U);
		btn_Clear_SDDV.setMnemonic(KeyEvent.VK_C);

		btn_SDDV_KhachHang.setMnemonic(KeyEvent.VK_K);
	}

	// đọc dữ liệu vào table dịch vụ
	public void loadDichVu() {
		ArrayList<DichVu> listDV = dv_dao.getAllDichVu();
		for (DichVu dv : listDV) {
			modelDichVu.addRow(new Object[] { dv.getMaDichVu(), dv.getTenDichVu(), dv.getDonGiaDichVu() });
		}
	}

	// đọc dữ liệu vào table sử dụng dịch vụ
	public void loadDV_SDDV() {
		listSDDV = suDungDichVu_dao.getAll_SuDungDichVu();
		for (SuDungDichVu sddv : listSDDV) {
			model_SDDV.addRow(new Object[] { sddv.getMaSDDV(), sddv.getMaKH(), sddv.getMaDV(), sddv.getNgaySD() });
		}
	}

	// thêm dịch vụ mới
	public void addnew_SDDV() throws ParseException {
		String ma_SDDV = txt_MaSDDV_SDDV.getText().trim();
		String ma_KH = txt_MaKH_SDDV.getText();
		String ma_DV = (String) txt_MaDV_SDDV.getSelectedItem();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String nsd = ((JTextField) txt_dateChooser_SDDV.getDateEditor().getUiComponent()).getText();
		Date ngaySD = sdf.parse(nsd);
		SuDungDichVu sddv = new SuDungDichVu(ma_SDDV, ma_KH, ma_DV, ngaySD);
		if (listSDDV.contains(sddv)) {
			JOptionPane.showMessageDialog(this, "Đã có mã này rồi!!!");
		} else if (suDungDichVu_dao.create(sddv)) {
			model_SDDV.addRow(new Object[] { sddv.getMaSDDV(), sddv.getMaKH(), sddv.getMaDV(), nsd });
			JOptionPane.showMessageDialog(this, "Thêm thành công");
			clear_SDDV();
		}
	}

	// làm mới Sử dụng dịch vụ
	public void clear_SDDV() {
		txt_dateChooser_SDDV.setDate(null);
		txt_MaSDDV_SDDV.setText("");
		txt_MaSDDV_SDDV.setEnabled(true);
		txt_MaDV_SDDV.setSelectedIndex(0);
		txt_MaKH_SDDV.setText("");
	}

	// xóa
	public void delete_SDDV() {
		int r = jtable_DanhsachDV.getSelectedRow();
		if (r < 0)
			JOptionPane.showMessageDialog(this, "Vui lòng chọn dịch vụ muốn xóa!!!");
		else {
			String maPhieu = txt_MaSDDV_SDDV.getText();
			int cauHoi = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa không?", "Lựa chọn",
					JOptionPane.YES_NO_OPTION);
			if (cauHoi == JOptionPane.YES_OPTION) {
				if (suDungDichVu_dao.delete_SDDV(maPhieu)) {
					JOptionPane.showMessageDialog(this, "Xóa thành công");
					model_SDDV.removeRow(r);
					clear_SDDV();
				} else
					JOptionPane.showMessageDialog(this, "Xóa Thất bại");
			}
		}
	}

	// cập nhật sử dụng dịch vụ
	public void update_SDDV() throws ParseException {
		int r = jtable_DanhsachDV.getSelectedRow();
		if (r < 0)
			JOptionPane.showMessageDialog(this, "Chọn một dịch vụ trước khi cập nhật!!!");
		else {
			String ma_SDDV = txt_MaSDDV_SDDV.getText();
			String ma_KH = txt_MaKH_SDDV.getText();
			String ma_DV = (String) txt_MaDV_SDDV.getSelectedItem();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String nsd = ((JTextField) txt_dateChooser_SDDV.getDateEditor().getUiComponent()).getText();
			Date ngaySD = sdf.parse(nsd);

			SuDungDichVu sddv = new SuDungDichVu(ma_SDDV, ma_KH, ma_DV, ngaySD);
			int cauHoi = JOptionPane.showConfirmDialog(this, "Ban có chắc chắn muốn sửa không ?");
			if (cauHoi == JOptionPane.YES_OPTION) {

				model_SDDV.setValueAt(sddv.getMaKH(), r, 1);
				model_SDDV.setValueAt(sddv.getMaDV(), r, 2);
				model_SDDV.setValueAt(nsd, r, 3);
				suDungDichVu_dao.capNhat_SDDV(sddv);
				JOptionPane.showMessageDialog(this, "Cập nhật hoàn tất!");
				clear_SDDV();
			} else {
				JOptionPane.showMessageDialog(this, "Cập nhật thất bại!");
			}
		}
	}
}
