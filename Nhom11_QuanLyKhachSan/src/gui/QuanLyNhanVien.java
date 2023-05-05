package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.toedter.calendar.JDateChooser;

import connectDB.ConnectDB;
import dao.NhanVien_DAO;
import entity.NhanVien;

/**
 *
 * @author Vu
 */
public class QuanLyNhanVien extends JPanel {
	private JButton btnClear_NhanVien;
	private JButton btn_Sua_NhanVien;
	private JButton btn_Them_NhanVien;
	private JButton btn_Xoa_NhanVien;
	private ButtonGroup buttonGroup11;
	private JScrollPane jScrollPane1;
	private JTable jtable_NhanVien;
	private JLabel lblEmail__NhanVien;
	private JLabel lblNote_NhanVien;
	private JLabel lblPassword;
	private JLabel lblTenND_NhanVien;
	private JLabel lblUsername;
	private JLabel lbl_CHucVu_NhanVien;
	private JLabel lbl_DanhMucNhanVien;
	private JLabel lbl_DiaChi__NhanVien;
	private JLabel lbl_GioiTInh_NhanVien;
	private JLabel lbl_MaNV_NhanVien;
	private JLabel lbl_NgaySinh_NhanVien;
	private JLabel lbl_SDT_NhanVien;
	private JLabel lbl_timkiem_NhanVien;
	private JRadioButton rbtn_radioNu_NhanVien;
	private JScrollPane scrollPane_NhanVien;
	private JComboBox<String> txt_ChucVu_NhanVien;
	private JTextField txt_DiaChi_NhanVien;
	private JTextField txt_Email__NhanVien;
	private JTextField txt_MaNV_NhanVien;
	private JPasswordField txt_Password_NhanVien;
	private JTextField txt_SDT_NhanVien;
	private JTextField txt_TenNV_NhanVien;
	private JTextField txt_TimKiem_NhanVien;
	private JTextField txt_Username_NhanVien;
	private JDateChooser txt_dateChooser_Ngaysinh__NhanVien;
	private JRadioButton rbtn_radioNam_NhanVien;
	private JPanel txt_radioNu_NhanVien;
	private JTextArea txt_textArea_NhanVien;
	private NhanVien_DAO NhanVien_dao;
	private DefaultTableModel model_NhanVien;
	private ArrayList<NhanVien> listNhanVien;

	/**
	 * Creates new form PanelHoaDonThanhToan
	 */
	public QuanLyNhanVien() {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		NhanVien_dao = new NhanVien_DAO();
		listNhanVien = NhanVien_dao.getAllNhanVien();
		initComponents();
	}

	/*
	 * Phương thức này được gọi từ bên trong hàm tạo để khởi tạo biểu mẫu. CẢNH BÁO:
	 * KHÔNG sửa đổi mã này. Nội dung của phương thức này luôn được Trình chỉnh sửa
	 * biểu mẫu tạo lại.
	 */
	private void initComponents() {

		buttonGroup11 = new ButtonGroup();
		lbl_DanhMucNhanVien = new JLabel();
		txt_radioNu_NhanVien = new JPanel();
		lbl_MaNV_NhanVien = new JLabel();
		lblTenND_NhanVien = new JLabel();
		lblUsername = new JLabel();
		lbl_GioiTInh_NhanVien = new JLabel();
		lbl_NgaySinh_NhanVien = new JLabel();
		txt_SDT_NhanVien = new JTextField();
		txt_TenNV_NhanVien = new JTextField();
		rbtn_radioNam_NhanVien = new JRadioButton();
		rbtn_radioNu_NhanVien = new JRadioButton();
		lbl_SDT_NhanVien = new JLabel();
		lbl_DiaChi__NhanVien = new JLabel();
		lblEmail__NhanVien = new JLabel();
		lblNote_NhanVien = new JLabel();
		txt_MaNV_NhanVien = new JTextField();
		txt_Email__NhanVien = new JTextField();
		txt_DiaChi_NhanVien = new JTextField();
		jScrollPane1 = new JScrollPane();
		txt_textArea_NhanVien = new JTextArea();
		txt_Username_NhanVien = new JTextField();
		lblPassword = new JLabel();
		txt_Password_NhanVien = new JPasswordField();
		txt_dateChooser_Ngaysinh__NhanVien = new JDateChooser();
		lbl_CHucVu_NhanVien = new JLabel();
		txt_ChucVu_NhanVien = new JComboBox<>();
		btn_Them_NhanVien = new JButton();
		btn_Sua_NhanVien = new JButton();
		btn_Xoa_NhanVien = new JButton();
		btnClear_NhanVien = new JButton();
		lbl_timkiem_NhanVien = new JLabel();
		txt_TimKiem_NhanVien = new JTextField();
		scrollPane_NhanVien = new JScrollPane();
		jtable_NhanVien = new JTable();

		setPreferredSize(new Dimension(1295, 634));

		txt_dateChooser_Ngaysinh__NhanVien.setDateFormatString("yyyy-MM-dd");

		lbl_DanhMucNhanVien.setFont(new Font("Segoe UI", 1, 36)); // NOI18N
		lbl_DanhMucNhanVien.setText("Danh mục nhân viên");

		txt_radioNu_NhanVien.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(0, 0, 0)));

		lbl_MaNV_NhanVien.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
		lbl_MaNV_NhanVien.setText("Mã nhân viên:");

		lblTenND_NhanVien.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
		lblTenND_NhanVien.setText("Tên nhân viên:");

		lblUsername.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
		lblUsername.setText("Username:");

		lbl_GioiTInh_NhanVien.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
		lbl_GioiTInh_NhanVien.setText("Giới tính:");

		lbl_NgaySinh_NhanVien.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
		lbl_NgaySinh_NhanVien.setText("Ngày sinh:");

		txt_SDT_NhanVien.setFont(new Font("Segoe UI", 0, 14)); // NOI18N

		txt_TenNV_NhanVien.setFont(new Font("Segoe UI", 0, 14)); // NOI18N

		buttonGroup11.add(rbtn_radioNam_NhanVien);
		rbtn_radioNam_NhanVien.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
		rbtn_radioNam_NhanVien.setText("Nam");
		rbtn_radioNam_NhanVien.setSelected(true);

		buttonGroup11.add(rbtn_radioNu_NhanVien);
		rbtn_radioNu_NhanVien.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
		rbtn_radioNu_NhanVien.setText("Nữ");

		lbl_SDT_NhanVien.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
		lbl_SDT_NhanVien.setText("Số điện thoại:");

		lbl_DiaChi__NhanVien.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
		lbl_DiaChi__NhanVien.setText("Địa chỉ:");

		lblEmail__NhanVien.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
		lblEmail__NhanVien.setText("Email:");

		lblNote_NhanVien.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
		lblNote_NhanVien.setText("Ghi chú:");

		txt_MaNV_NhanVien.setFont(new Font("Segoe UI", 0, 14)); // NOI18N

		txt_Email__NhanVien.setFont(new Font("Segoe UI", 0, 14)); // NOI18N

		txt_DiaChi_NhanVien.setFont(new Font("Segoe UI", 0, 14)); // NOI18N

		jScrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jScrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

		txt_textArea_NhanVien.setColumns(20);
		txt_textArea_NhanVien.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
		txt_textArea_NhanVien.setRows(5);
		jScrollPane1.setViewportView(txt_textArea_NhanVien);

		txt_Username_NhanVien.setFont(new Font("Segoe UI", 0, 14)); // NOI18N

		lblPassword.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
		lblPassword.setText("Password:");

		txt_Password_NhanVien.setFont(new Font("Segoe UI", 0, 14)); // NOI18N

		lbl_CHucVu_NhanVien.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
		lbl_CHucVu_NhanVien.setText("Chức vụ:");

		txt_ChucVu_NhanVien.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
		// tooltip các nút chức năng của quản lý nhân viên
		btn_Them_NhanVien.setToolTipText("Atl + A");
		btn_Xoa_NhanVien.setToolTipText("Atl + R");
		btn_Sua_NhanVien.setToolTipText("Atl + U");
		btnClear_NhanVien.setToolTipText("Atl + C");

		// sử dụng phím tắt
		btn_Them_NhanVien.setMnemonic(KeyEvent.VK_A);
		btn_Xoa_NhanVien.setMnemonic(KeyEvent.VK_R);
		btn_Sua_NhanVien.setMnemonic(KeyEvent.VK_U);
		btnClear_NhanVien.setMnemonic(KeyEvent.VK_C);

		btn_Them_NhanVien.setIcon(new ImageIcon("item/add-24.png")); // NOI18N
		btn_Them_NhanVien.setText("Thêm");
		btn_Them_NhanVien.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				try {
					addNewNhanVien();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});
		btn_Sua_NhanVien.setIcon(new ImageIcon("item/update-24.png")); // NOI18N
		btn_Sua_NhanVien.setText("Cập nhật");
		btn_Sua_NhanVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					updateNhanVien();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});
		btn_Xoa_NhanVien.setIcon(new ImageIcon("item/remove-24.png")); // NOI18N
		btn_Xoa_NhanVien.setText("Xóa");
		btn_Xoa_NhanVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteNhanVien();
			}
		});
		btnClear_NhanVien.setIcon(new ImageIcon("item/refresh-24.png")); // NOI18N
		btnClear_NhanVien.setText("Làm lại");
		btnClear_NhanVien.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				clear_NhanVien();
			}
		});

		javax.swing.GroupLayout txt_radioNu_NhanVienLayout = new javax.swing.GroupLayout(txt_radioNu_NhanVien);
		txt_radioNu_NhanVien.setLayout(txt_radioNu_NhanVienLayout);
		txt_radioNu_NhanVienLayout.setHorizontalGroup(txt_radioNu_NhanVienLayout
				.createParallelGroup(
						javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(txt_radioNu_NhanVienLayout.createSequentialGroup().addGap(151, 151, 151)
						.addGroup(txt_radioNu_NhanVienLayout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lblTenND_NhanVien).addComponent(lbl_MaNV_NhanVien)
								.addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 91,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lbl_GioiTInh_NhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 91,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lbl_NgaySinh_NhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 91,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 91,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(31, 31, 31)
						.addGroup(txt_radioNu_NhanVienLayout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(txt_Password_NhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 295,
										Short.MAX_VALUE)
								.addGroup(txt_radioNu_NhanVienLayout.createSequentialGroup()
										.addGroup(txt_radioNu_NhanVienLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addComponent(txt_TenNV_NhanVien, javax.swing.GroupLayout.DEFAULT_SIZE,
														295, Short.MAX_VALUE)
												.addComponent(txt_MaNV_NhanVien, javax.swing.GroupLayout.DEFAULT_SIZE,
														295, Short.MAX_VALUE)
												.addGroup(txt_radioNu_NhanVienLayout.createSequentialGroup()
														.addComponent(rbtn_radioNam_NhanVien)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(rbtn_radioNu_NhanVien).addGap(96, 96, 96))
												.addComponent(txt_Username_NhanVien,
														javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE))
										.addGap(0, 0, Short.MAX_VALUE))
								.addComponent(txt_dateChooser_Ngaysinh__NhanVien, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGap(114, 114, 114)
						.addGroup(txt_radioNu_NhanVienLayout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(txt_radioNu_NhanVienLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addGroup(txt_radioNu_NhanVienLayout.createSequentialGroup()
												.addComponent(lbl_DiaChi__NhanVien,
														javax.swing.GroupLayout.PREFERRED_SIZE, 91,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(54, 54, 54).addComponent(txt_DiaChi_NhanVien))
										.addGroup(txt_radioNu_NhanVienLayout.createSequentialGroup()
												.addComponent(lblNote_NhanVien, javax.swing.GroupLayout.PREFERRED_SIZE,
														91, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(54, 54, 54).addComponent(jScrollPane1,
														javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE))
										.addGroup(txt_radioNu_NhanVienLayout.createSequentialGroup()
												.addComponent(lblEmail__NhanVien,
														javax.swing.GroupLayout.PREFERRED_SIZE, 91,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(54, 54, 54).addComponent(txt_Email__NhanVien))
										.addGroup(txt_radioNu_NhanVienLayout.createSequentialGroup()
												.addComponent(lbl_SDT_NhanVien, javax.swing.GroupLayout.PREFERRED_SIZE,
														103, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(42, 42, 42).addComponent(txt_SDT_NhanVien)))
								.addGroup(txt_radioNu_NhanVienLayout.createSequentialGroup()
										.addComponent(lbl_CHucVu_NhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 91,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(54, 54, 54).addComponent(txt_ChucVu_NhanVien,
												javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)))
						.addGap(162, 162, 162))
				.addGroup(txt_radioNu_NhanVienLayout.createSequentialGroup().addGap(323, 323, 323)
						.addComponent(btn_Them_NhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 109,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(91, 91, 91)
						.addComponent(btn_Sua_NhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 109,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(84, 84, 84)
						.addComponent(btn_Xoa_NhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 109,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(78, 78, 78)
						.addComponent(btnClear_NhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 109,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		txt_radioNu_NhanVienLayout.setVerticalGroup(txt_radioNu_NhanVienLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(txt_radioNu_NhanVienLayout.createSequentialGroup().addGap(10, 10, 10)
						.addGroup(txt_radioNu_NhanVienLayout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(txt_radioNu_NhanVienLayout.createSequentialGroup()
										.addGroup(txt_radioNu_NhanVienLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(lbl_MaNV_NhanVien, javax.swing.GroupLayout.PREFERRED_SIZE,
														28, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(txt_MaNV_NhanVien, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(txt_radioNu_NhanVienLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(lblTenND_NhanVien, javax.swing.GroupLayout.PREFERRED_SIZE,
														28, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(txt_TenNV_NhanVien,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(txt_radioNu_NhanVienLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(txt_Username_NhanVien,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(txt_radioNu_NhanVienLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(txt_Password_NhanVien,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(txt_radioNu_NhanVienLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(lbl_GioiTInh_NhanVien,
														javax.swing.GroupLayout.PREFERRED_SIZE, 28,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(rbtn_radioNam_NhanVien)
												.addComponent(rbtn_radioNu_NhanVien))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(txt_radioNu_NhanVienLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addComponent(lbl_NgaySinh_NhanVien,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(txt_dateChooser_Ngaysinh__NhanVien,
														javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)))
								.addGroup(txt_radioNu_NhanVienLayout.createSequentialGroup()
										.addGroup(txt_radioNu_NhanVienLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(lbl_SDT_NhanVien, javax.swing.GroupLayout.PREFERRED_SIZE,
														28, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(txt_SDT_NhanVien, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(txt_radioNu_NhanVienLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(lblEmail__NhanVien,
														javax.swing.GroupLayout.PREFERRED_SIZE, 28,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(txt_Email__NhanVien,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(txt_radioNu_NhanVienLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(lbl_DiaChi__NhanVien,
														javax.swing.GroupLayout.PREFERRED_SIZE, 28,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(txt_DiaChi_NhanVien,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(txt_radioNu_NhanVienLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(lbl_CHucVu_NhanVien,
														javax.swing.GroupLayout.PREFERRED_SIZE, 28,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(txt_ChucVu_NhanVien,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(txt_radioNu_NhanVienLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 74,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(lblNote_NhanVien, javax.swing.GroupLayout.PREFERRED_SIZE,
														28, javax.swing.GroupLayout.PREFERRED_SIZE))))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
						.addGroup(txt_radioNu_NhanVienLayout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(btn_Them_NhanVien).addComponent(btn_Sua_NhanVien)
								.addComponent(btn_Xoa_NhanVien).addComponent(btnClear_NhanVien))
						.addGap(10, 10, 10)));

		lbl_timkiem_NhanVien.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
		lbl_timkiem_NhanVien.setText("Tìm kiếm:");

		// tìm kiếm nhân viên
		txt_TimKiem_NhanVien.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
		txt_TimKiem_NhanVien.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String text = txt_TimKiem_NhanVien.getText().toLowerCase();
				TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(model_NhanVien);
				jtable_NhanVien.setRowSorter(sorter);
				sorter.setRowFilter(RowFilter.regexFilter(text));
				if (text.trim().length() == 0) {
					sorter.setRowFilter(null);
				} else {
					sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
					model_NhanVien.setRowCount(0);
					loadNhanVien();
				}
			}
		});

		// table nhân viên
		String[] header_NhanVien = { "Mã nhân viên", "Họ Tên", "User", "Password", "Ngày sinh", "Địa chỉ", "Email",
				"Số điện thoại", "Giới tính", "Chức vụ", "Ghi chú" };
		model_NhanVien = new DefaultTableModel(header_NhanVien, 0);
		jtable_NhanVien = new JTable(model_NhanVien);
		jtable_NhanVien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = jtable_NhanVien.getSelectedRow();
				if (row != -1) {
					txt_MaNV_NhanVien.setText(jtable_NhanVien.getValueAt(row, 0).toString());
					txt_MaNV_NhanVien.setEnabled(false);
					txt_TenNV_NhanVien.setText(jtable_NhanVien.getValueAt(row, 1).toString());
					txt_Username_NhanVien.setText(jtable_NhanVien.getValueAt(row, 2).toString());
					txt_Password_NhanVien.setText(jtable_NhanVien.getValueAt(row, 3).toString());
					try {
						Date date;
						date = (Date) new SimpleDateFormat("yyyy-MM-dd")
								.parse((String) model_NhanVien.getValueAt(row, 4).toString());
						txt_dateChooser_Ngaysinh__NhanVien.setDate(date);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					// txt_dateChooser_Ngaysinh__NhanVien.setDate(Date.valueOf(jtable_NhanVien.getValueAt(row,
					// 4).toString()));
					txt_DiaChi_NhanVien.setText(model_NhanVien.getValueAt(row, 5).toString());
					txt_Email__NhanVien.setText(model_NhanVien.getValueAt(row, 6).toString());
					txt_SDT_NhanVien.setText(model_NhanVien.getValueAt(row, 7).toString());

					if (model_NhanVien.getValueAt(row, 8).equals("Nam")) {
						rbtn_radioNam_NhanVien.setSelected(true);
					} else {
						rbtn_radioNu_NhanVien.setSelected(true);
					}
					txt_ChucVu_NhanVien.setSelectedItem(model_NhanVien.getValueAt(row, 9));
					txt_textArea_NhanVien.setText(jtable_NhanVien.getValueAt(row, 10).toString());
				}
			}
		});
		scrollPane_NhanVien.setViewportView(jtable_NhanVien);
		loadNhanVien();

		txt_ChucVu_NhanVien.setModel(new DefaultComboBoxModel<String>(new String[] { "Quan ly", "Nhan vien" }));
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup().addContainerGap()
								.addComponent(txt_radioNu_NhanVien, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addContainerGap())
				.addGroup(layout.createSequentialGroup().addGroup(layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(103, 103, 103).addComponent(scrollPane_NhanVien,
								javax.swing.GroupLayout.PREFERRED_SIZE, 1070, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createSequentialGroup().addGap(409, 409, 409)
								.addComponent(lbl_timkiem_NhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 91,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18).addComponent(txt_TimKiem_NhanVien,
										javax.swing.GroupLayout.PREFERRED_SIZE, 352,
										javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lbl_DanhMucNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 421,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(391, 391, 391)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(lbl_DanhMucNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 42,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, 0)
						.addComponent(txt_radioNu_NhanVien, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lbl_timkiem_NhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(txt_TimKiem_NhanVien, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addComponent(scrollPane_NhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
						.addContainerGap()));
	}// </editor-fold>//GEN-END:initComponents

	public void loadNhanVien() {
		listNhanVien = NhanVien_dao.getAllNhanVien();
		for (NhanVien nv : listNhanVien) {
			model_NhanVien.addRow(new Object[] { nv.getMaNV(), nv.getFullName(), nv.getUserName(), nv.getPassWord(),
					nv.getDOB(), nv.getAddress(), nv.getEmail(), nv.getPhoneNumber(), nv.getPhai(), nv.getChucVu(),
					nv.getNote() });
		}
	}

	public void clear_NhanVien() {
		txt_ChucVu_NhanVien.setSelectedIndex(0);
		txt_dateChooser_Ngaysinh__NhanVien.setCalendar(null);
		txt_DiaChi_NhanVien.setText("");
		rbtn_radioNam_NhanVien.setSelected(true);
		txt_Email__NhanVien.setText("");
		txt_MaNV_NhanVien.setText("");
		txt_MaNV_NhanVien.setEnabled(true);
		txt_Password_NhanVien.setText("");
		txt_SDT_NhanVien.setText("");
		txt_TenNV_NhanVien.setText("");
		txt_textArea_NhanVien.setText("");
		txt_Username_NhanVien.setText("");
	}

	// thêm nhân viên mới
	private void addNewNhanVien() throws ParseException {
		if (check_NhanVien()) {
			String ma = txt_MaNV_NhanVien.getText();
			String fullName = txt_TenNV_NhanVien.getText();

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String ns = ((JTextField) txt_dateChooser_Ngaysinh__NhanVien.getDateEditor().getUiComponent()).getText();
			Date ngaysinh = (Date) sdf.parse(ns);
			String userName = txt_Username_NhanVien.getText();
			String passWord = txt_Password_NhanVien.getText();
			String address = txt_DiaChi_NhanVien.getText();
			String email = txt_Email__NhanVien.getText();
			String phoneNumber = txt_SDT_NhanVien.getText();
			String chucVu = txt_ChucVu_NhanVien.getSelectedItem().toString();
			String note = txt_textArea_NhanVien.getText();
			boolean sex = rbtn_radioNam_NhanVien.isSelected() ? true : false;
			NhanVien nv = new NhanVien(ma, fullName, userName, passWord, ngaysinh, address, email, phoneNumber, sex,
					chucVu, note);
			try {
				NhanVien_dao.create_NhanVien(nv);
				model_NhanVien.addRow(new Object[] { nv.getMaNV(), nv.getFullName(), nv.getUserName(), nv.getPassWord(),
						ns, nv.getAddress(), nv.getEmail(), nv.getPhoneNumber(), nv.getPhai(), nv.getChucVu(),
						nv.getNote() });
				JOptionPane.showMessageDialog(null, "Thêm thành công!");
				clear_NhanVien();
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "Trùng");
			}
		}
	}

	// kiểm tra điều kiện
	private boolean check_NhanVien() throws ParseException {
		String ma = txt_MaNV_NhanVien.getText();
		String fullName = txt_TenNV_NhanVien.getText();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String ns = ((JTextField) txt_dateChooser_Ngaysinh__NhanVien.getDateEditor().getUiComponent()).getText();
		String userName = txt_Username_NhanVien.getText();
		String passWord = txt_Password_NhanVien.getText();
		String address = txt_DiaChi_NhanVien.getText();
		String email = txt_Email__NhanVien.getText();
		String phoneNumber = txt_SDT_NhanVien.getText();
		String chucVu = txt_ChucVu_NhanVien.getSelectedItem().toString();
		String note = txt_textArea_NhanVien.getText();
		boolean sex = rbtn_radioNam_NhanVien.isSelected() ? true : false;

		// check mã nhân viên
		int n = 0;
		for (NhanVien nv : listNhanVien)
			if (ma.equals(nv.getMaNV()))
				n = 1;
		if (n == 1) {
			JOptionPane.showMessageDialog(null, "Error: Mã nhân viên đã tồn tại!");
			txt_MaNV_NhanVien.requestFocus(true);
			return false;
		}

		if (ma.length() > 0 || !ma.equals("")) {
			if (!ma.matches("^(NV)[0-9]+")) {
				JOptionPane.showMessageDialog(null,
						"Error: Mã nhân viên phải theo mẫu: Bắt đầu bằng NV theo sau là dãy số");
				txt_MaNV_NhanVien.requestFocus(true);
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(null, "Error: Chưa nhập mã nhân viên!");
			txt_MaNV_NhanVien.requestFocus(true);
			return false;
		}
		// check tên nhân viên
		if (fullName.length() > 0 || !fullName.equals("")) {
			if (!fullName.matches("(^[A-Z])[a-z]+([ ][A-Z][a-z]+)+")) {
				JOptionPane.showMessageDialog(null, "Error: Phải viết hoa chữ cái đầu của tên nhân viên ");
				txt_TenNV_NhanVien.requestFocus(true);
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(null, "Chưa nhập tên nhân viên !");
			txt_TenNV_NhanVien.requestFocus(true);
			return false;
		}
		// Check username
		n = 0;
		for (NhanVien nv : listNhanVien)
			if (userName.equals(nv.getUserName()))
				n = 1;
		if (n == 1) {
			JOptionPane.showMessageDialog(null, "Error: Username nhân viên đã tồn tại!");
			txt_Username_NhanVien.requestFocus(true);
			return false;
		}
		if (userName.equals("") || userName.length() == 0) {
			JOptionPane.showMessageDialog(null, "Error: Chưa nhập userName nhân viên!");
			txt_Username_NhanVien.requestFocus(true);
			return false;
		}
		// Check password
		if (passWord.equals("") || passWord.length() == 0) {
			JOptionPane.showMessageDialog(null, "Error: Chưa nhập password nhân viên!");
			txt_Password_NhanVien.requestFocus(true);
			return false;
		}
		// check ngày sinh
		if (ns.equals("")) {
			JOptionPane.showMessageDialog(null, "Error: Chưa nhập ngày sinh!");
			txt_dateChooser_Ngaysinh__NhanVien.requestFocus(true);
			return false;
		}

		Date ngaysinh = (Date) sdf.parse(ns);
		Date today = new Date();
		@SuppressWarnings("deprecation")
		Date eighteenYearsAgo = new Date(ngaysinh.getYear() + 18, ngaysinh.getMonth(), ngaysinh.getDate());
		if (!eighteenYearsAgo.before(today)) {
			JOptionPane.showMessageDialog(null, "Error: Nhân viên chưa đủ 18 tuổi!");
			txt_dateChooser_Ngaysinh__NhanVien.requestFocus(true);
			return false;
		}
		// check số điện thoại
		if (phoneNumber.length() > 0 || !phoneNumber.equals("")) {
			if (!phoneNumber.matches("(\\+84|0)[1-9]\\d{8}")) {
				JOptionPane.showMessageDialog(null, "Error: Số điện thoại phải đủ 10 số và bắt đầu bằng số 0");
				txt_SDT_NhanVien.requestFocus(true);
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(null, "Chưa nhập số điện thoại!");
			txt_SDT_NhanVien.requestFocus(true);
			return false;
		}
		// check email
		if (email.length() > 0 || !email.equals("")) {
			if (!email.matches("^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$")) {
				JOptionPane.showMessageDialog(null, "Error: Email sai định dạng ");
				txt_Email__NhanVien.requestFocus(true);
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(null, "Chưa nhập email !");
			txt_Email__NhanVien.requestFocus(true);
			return false;
		}
		// Check dia chi
		if (address.equals("") || address.length() == 0) {
			JOptionPane.showMessageDialog(null, "Error: Chưa nhập đia chỉ nhân viên!");
			txt_DiaChi_NhanVien.requestFocus(true);
			return false;
		}
		return true;
	}

//    Xóa nhân viên
	private void deleteNhanVien() {
		int row = jtable_NhanVien.getSelectedRow();
		String ma = txt_MaNV_NhanVien.getText();
		if (row < 0) {
			JOptionPane.showMessageDialog(null, "Chọn dòng cần xoá!");
		} else {
			int choice = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa không ?");
			if (choice == JOptionPane.YES_OPTION) {
				model_NhanVien.removeRow(row);
				NhanVien_dao.delete_NhanVien(ma);
				JOptionPane.showMessageDialog(null, "Xóa xong!");
				clear_NhanVien();
			} else {
				JOptionPane.showMessageDialog(null, "Error!");
			}
		}
	}

//	Cập nhật nhân viên
	private void updateNhanVien() throws ParseException {
		int row = jtable_NhanVien.getSelectedRow();
		if (row < 0) {
			JOptionPane.showMessageDialog(null, "Chọn dòng cần cập nhật!");
		} else {
			String ma = txt_MaNV_NhanVien.getText();
			String fullName = txt_TenNV_NhanVien.getText();

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String ns = ((JTextField) txt_dateChooser_Ngaysinh__NhanVien.getDateEditor().getUiComponent()).getText();
			Date ngaysinh = (Date) sdf.parse(ns);
			String userName = txt_Username_NhanVien.getText();
			String passWord = txt_Password_NhanVien.getText();
			String address = txt_DiaChi_NhanVien.getText();
			String email = txt_Email__NhanVien.getText();
			String phoneNumber = txt_SDT_NhanVien.getText();
			String chucVu = txt_ChucVu_NhanVien.getSelectedItem().toString();
			String note = txt_textArea_NhanVien.getText();
			boolean sex = rbtn_radioNam_NhanVien.isSelected() ? true : false;
			NhanVien nv = new NhanVien(ma, fullName, userName, passWord, ngaysinh, address, email, phoneNumber, sex,
					chucVu, note);
			int choice = JOptionPane.showConfirmDialog(null, "Ban có chắc chắn muốn cập nhật không ?");
			if (choice == JOptionPane.YES_OPTION) {
				model_NhanVien.setValueAt(nv.getFullName(), row, 1);
				model_NhanVien.setValueAt(nv.getUserName(), row, 2);
				model_NhanVien.setValueAt(nv.getPassWord(), row, 3);
				model_NhanVien.setValueAt(ns, row, 4);
				model_NhanVien.setValueAt(nv.getAddress(), row, 5);
				model_NhanVien.setValueAt(nv.getEmail(), row, 6);
				model_NhanVien.setValueAt(nv.getPhoneNumber(), row, 7);
				model_NhanVien.setValueAt(nv.getPhai(), row, 8);
				model_NhanVien.setValueAt(nv.getChucVu(), row, 9);
				model_NhanVien.setValueAt(nv.getNote(), row, 10);
				NhanVien_dao.capNhat_KhachHang(nv);
				clear_NhanVien();
				JOptionPane.showMessageDialog(null, "Cập nhật hoàn tất!");
			} else {
				JOptionPane.showMessageDialog(null, "Error!");
			}
		}
	}
}
