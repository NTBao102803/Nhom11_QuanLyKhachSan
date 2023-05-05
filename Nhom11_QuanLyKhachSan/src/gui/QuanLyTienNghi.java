package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import connectDB.ConnectDB;
//import dao.DungDichVu_DAO;
import dao.Phong_DAO;
//import dao.ThuePhong_DAO;
import dao.TienNghi_DAO;
//import entity.DichVu;
import entity.Phong;
import entity.TienNghi;

/**
 *
 * @author Vu
 */
public class QuanLyTienNghi extends JPanel {
	// Variables declaration - do not modify//GEN-BEGIN:variables
	private JButton btn_Clear_TienNghi;
	private JButton btn_Sua_TienNghi;
	private JButton btn_Them_TienNghi;
	private JButton btn_Xoa_TienNghi;
	private JPanel jPanel1;
	private JPanel jPanel2;
	private JTable jtable_TienNghi__TienNghi;
	private JLabel lblTmkiem__TienNghi;
	private JLabel lbl_MaTienNghi_TienNghi;
	private JLabel lbl_SoLuong_TienNghi;
	private JLabel lbl_TenTN_TienNghi;
	private JLabel lbl_Tinhtrang_TienNghi;
	private JLabel lbl_danhmuctiennghi;
	private JLabel lbl_maPhong_TienNghi;
	private JScrollPane scrollPane_TienNghi;
	private JTextField txt_MaTN_TienNghi;
	private JTextField txt_SoLuong_TienNghi;
	private JTextField txt_TenTN_TienNghi;
	private JTextField txt_TimKiem_TienNghi;
	private JComboBox<String> txt_TinhTrang_TienNghi;
	private JComboBox<String> txt_comboboxMaPhong_TienNghi;
//	private DungDichVu_DAO dv_dao;
	private Phong_DAO phong_dao;
//	private ThuePhong_DAO thuePhong_dao;
	private TienNghi_DAO tienNghi_dao;

	private DefaultTableModel modelTienNghi;
	private ArrayList<Phong> listPhong;
	private JComboBox<String> cbo_TinhTrang_TienNghi;
	private ArrayList<TienNghi> listTN;

	/**
	 * Creates new form PanelQuanLyTienNghi
	 */
	public QuanLyTienNghi() {
		// khởi tạo kết nối đến CSDL
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		tienNghi_dao = new TienNghi_DAO();
		phong_dao = new Phong_DAO();
		initComponents();

	}

	// đọc dữ liệu vào table dịch vụ
	private void loadTienNghi() {
		listTN = tienNghi_dao.getAllTienNghi();
		for (TienNghi tn : listTN) {
			modelTienNghi.addRow(new Object[] { tn.getMaTienNghi(), tn.getPhong().getMaPhong(), tn.getTenTienNghi(),
					tn.getTinhTrang(), tn.getSoLuong() });
		}
	}

	private void initComponents() {
		cbo_TinhTrang_TienNghi = new JComboBox<>();
		lbl_danhmuctiennghi = new JLabel();
		jPanel1 = new JPanel();
		lbl_MaTienNghi_TienNghi = new JLabel();
		lbl_maPhong_TienNghi = new JLabel();
		lbl_TenTN_TienNghi = new JLabel();
		lbl_Tinhtrang_TienNghi = new JLabel();
		lbl_SoLuong_TienNghi = new JLabel();
		txt_TinhTrang_TienNghi = new JComboBox<String>();
		txt_MaTN_TienNghi = new JTextField();
		txt_TenTN_TienNghi = new JTextField();
		txt_SoLuong_TienNghi = new JTextField();
		txt_comboboxMaPhong_TienNghi = new JComboBox<String>();
		btn_Them_TienNghi = new JButton();
		btn_Clear_TienNghi = new JButton();
		btn_Sua_TienNghi = new JButton();
		btn_Xoa_TienNghi = new JButton();
		jPanel2 = new JPanel();
		lblTmkiem__TienNghi = new JLabel();
		txt_TimKiem_TienNghi = new JTextField();

		scrollPane_TienNghi = new JScrollPane();
		jtable_TienNghi__TienNghi = new JTable();

		setPreferredSize(new Dimension(1295, 634));

		lbl_danhmuctiennghi.setFont(new Font("Segoe UI", 1, 36)); // NOI18N
		lbl_danhmuctiennghi.setText("Danh mục tiện nghi");
		lbl_danhmuctiennghi.setPreferredSize(new Dimension(305, 48));

		jPanel1.setBorder(
				BorderFactory.createTitledBorder(null, "Thông tin tiện nghi", javax.swing.border.TitledBorder.CENTER,
						javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18))); // NOI18N

		lbl_MaTienNghi_TienNghi.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
		lbl_MaTienNghi_TienNghi.setText("Mã tiện nghi:");

		lbl_maPhong_TienNghi.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
		lbl_maPhong_TienNghi.setText("Mã phòng:");

		lbl_TenTN_TienNghi.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
		lbl_TenTN_TienNghi.setText("Tên tiện nghi:");

		lbl_Tinhtrang_TienNghi.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
		lbl_Tinhtrang_TienNghi.setText("Tình trạng:");

		lbl_SoLuong_TienNghi.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
		lbl_SoLuong_TienNghi.setText("Số lượng:");

		txt_TinhTrang_TienNghi.setFont(new Font("Segoe UI", 0, 14)); // NOI18N

		txt_MaTN_TienNghi.setFont(new Font("Segoe UI", 0, 14)); // NOI18N

		txt_TenTN_TienNghi.setFont(new Font("Segoe UI", 0, 14)); // NOI18N

		txt_SoLuong_TienNghi.setFont(new Font("Segoe UI", 0, 14)); // NOI18N

		txt_comboboxMaPhong_TienNghi.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
		listPhong = phong_dao.getAllPhong();
		for (Phong p : listPhong) {
			txt_comboboxMaPhong_TienNghi.addItem(p.getMaPhong());
		}

		cbo_TinhTrang_TienNghi.setModel(new DefaultComboBoxModel<String>(new String[] { "Tot", "Kha", "Kem" }));

		// tooltip các nút chức năng của quản lý tiện nghi
		btn_Them_TienNghi.setToolTipText("Atl + A");
		btn_Xoa_TienNghi.setToolTipText("Atl + R");
		btn_Sua_TienNghi.setToolTipText("Atl + U");
		btn_Clear_TienNghi.setToolTipText("Atl + C");

		// sử dụng phím tắt
		btn_Them_TienNghi.setMnemonic(KeyEvent.VK_A);
		btn_Xoa_TienNghi.setMnemonic(KeyEvent.VK_R);
		btn_Sua_TienNghi.setMnemonic(KeyEvent.VK_U);
		btn_Clear_TienNghi.setMnemonic(KeyEvent.VK_C);

		btn_Them_TienNghi.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
		btn_Them_TienNghi.setIcon(new ImageIcon("item/add-24.png")); // NOI18N
		btn_Them_TienNghi.setText("Thêm");
		btn_Them_TienNghi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addTienNghi();
			}

			private void addTienNghi() {
				if (validData_TienNghi()) {
					TienNghi tn = TaoMoiTN();
					if (tienNghi_dao.themTienNghi(tn)) {
						modelTienNghi.addRow(new Object[] { tn.getMaTienNghi(), tn.getPhong().getMaPhong(),
								tn.getTenTienNghi(), tn.getTinhTrang(), tn.getSoLuong() });
						JOptionPane.showMessageDialog(null, "Thêm thành công!");
					} else {
						JOptionPane.showMessageDialog(null, "Thêm thất bại!");
					}
				}

			}
		});

		btn_Clear_TienNghi.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
		btn_Clear_TienNghi.setIcon(new ImageIcon("item//refresh-24.png")); // NOI18N
		btn_Clear_TienNghi.setText("Làm lại");
		btn_Clear_TienNghi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				clearTienNghi();
			}
		});

		// sửa tiện nghi
		btn_Sua_TienNghi.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
		btn_Sua_TienNghi.setIcon(new ImageIcon("item//update-24.png")); // NOI18N
		btn_Sua_TienNghi.setText("Cập nhật");
		btn_Sua_TienNghi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = jtable_TienNghi__TienNghi.getSelectedRow();
				if (row < 0) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn tiện nghi để cập nhật!");
				} else {
					TienNghi tn = TaoMoiTN();
					int choice = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn cập nhật không ?");
					if (choice == JOptionPane.YES_OPTION) {
						if (validDataEdit_TienNghi()) {
							if (tienNghi_dao.capNhat_TienNghi(tn)) {
								modelTienNghi.setValueAt(tn.getPhong().getMaPhong(), row, 0);
								modelTienNghi.setValueAt(tn.getPhong().getMaPhong(), row, 1);
								modelTienNghi.setValueAt(tn.getTenTienNghi(), row, 2);
								modelTienNghi.setValueAt(tn.getTinhTrang(), row, 3);
								modelTienNghi.setValueAt(tn.getSoLuong(), row, 4);
								tienNghi_dao.capNhat_TienNghi(tn);
								clearTienNghi();
								JOptionPane.showMessageDialog(null, "Cập nhật hoàn tất!");
							} else {
								JOptionPane.showMessageDialog(null, "Cập nhật thất bại!");
							}
						} else {
							JOptionPane.showMessageDialog(null, "Cập nhật thất bại!");
						}
					}
				}
			}
		});

		// xóa tiện nghi
		btn_Xoa_TienNghi.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
		btn_Xoa_TienNghi.setIcon(new ImageIcon("item//remove-24.png")); // NOI18N
		btn_Xoa_TienNghi.setText("Xóa");
		btn_Xoa_TienNghi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (txt_MaTN_TienNghi.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn dòng cần xóa");
				} else {
					int choose = jtable_TienNghi__TienNghi.getSelectedRow();
					TienNghi tn = tienNghi_dao.getAllTienNghi().get(choose);
					String ma = tn.getMaTienNghi();
					if ((JOptionPane.showConfirmDialog(null,
							"Bạn có chắc muốn xóa dịch vụ " + tn.getMaTienNghi() + " không?", "Lựa chọn",
							JOptionPane.YES_NO_OPTION)) == JOptionPane.YES_OPTION) {
						// xóa trong table model
						modelTienNghi.removeRow(choose);
						// xóa trong ArrayList
						try {
							tienNghi_dao.deleteTienNghi(ma);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
						clearTienNghi();
						JOptionPane.showMessageDialog(null, "Xóa thành công!!!!");
					}
				}

			}
		});

		GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(34, 34, 34).addGroup(jPanel1Layout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
								.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(lbl_Tinhtrang_TienNghi, GroupLayout.DEFAULT_SIZE, 85,
												Short.MAX_VALUE)
										.addComponent(lbl_SoLuong_TienNghi, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGap(18, 18, 18)
								.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
										.addComponent(txt_SoLuong_TienNghi, GroupLayout.PREFERRED_SIZE, 223,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(cbo_TinhTrang_TienNghi, GroupLayout.PREFERRED_SIZE, 223,
												GroupLayout.PREFERRED_SIZE)))
						.addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGroup(
								jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout
										.createSequentialGroup()
										.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addComponent(lbl_MaTienNghi_TienNghi, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(lbl_maPhong_TienNghi, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGap(18, 18, 18))
										.addGroup(jPanel1Layout.createSequentialGroup().addComponent(lbl_TenTN_TienNghi)
												.addGap(18, 18, 18)))
								.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
										.addComponent(txt_TenTN_TienNghi).addComponent(txt_MaTN_TienNghi)
										.addComponent(txt_comboboxMaPhong_TienNghi, 0, 223, Short.MAX_VALUE)))
						.addGroup(jPanel1Layout.createSequentialGroup()
								.addComponent(btn_Clear_TienNghi, GroupLayout.PREFERRED_SIZE, 117,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btn_Xoa_TienNghi, GroupLayout.PREFERRED_SIZE, 117,
										GroupLayout.PREFERRED_SIZE))
						.addGroup(jPanel1Layout.createSequentialGroup()
								.addComponent(btn_Them_TienNghi, GroupLayout.PREFERRED_SIZE, 117,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btn_Sua_TienNghi, GroupLayout.PREFERRED_SIZE, 117,
										GroupLayout.PREFERRED_SIZE)))
						.addGap(34, 34, 34)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(26, 26, 26)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lbl_MaTienNghi_TienNghi, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(txt_MaTN_TienNghi, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(lbl_maPhong_TienNghi, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(txt_comboboxMaPhong_TienNghi, javax.swing.GroupLayout.DEFAULT_SIZE, 32,
										Short.MAX_VALUE))
						.addGap(18, 18, 18)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lbl_TenTN_TienNghi, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(txt_TenTN_TienNghi, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lbl_Tinhtrang_TienNghi, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(cbo_TinhTrang_TienNghi))
						.addGap(18, 18, 18)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lbl_SoLuong_TienNghi, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(txt_SoLuong_TienNghi, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(35, 35, 35)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(btn_Them_TienNghi, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_Sua_TienNghi, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(btn_Clear_TienNghi, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_Xoa_TienNghi, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(69, Short.MAX_VALUE)));

		lblTmkiem__TienNghi.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
		lblTmkiem__TienNghi.setText("Tìm kiếm tiện nghi:");

		txt_TimKiem_TienNghi.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String text = txt_TimKiem_TienNghi.getText().toLowerCase();
				TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(modelTienNghi);
				jtable_TienNghi__TienNghi.setRowSorter(sorter);
				sorter.setRowFilter(RowFilter.regexFilter(text));
				if (text.trim().length() == 0) {
					sorter.setRowFilter(null);
				} else {
					sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
					modelTienNghi.setRowCount(0);
					loadTienNghi();
				}
			}
		});

		// table tiện nghi
		String[] colsDV = { "Mã tiện nghi", "Mã phòng", "Tên tiện nghi", "Tình trạng", "Số lượng" };
		modelTienNghi = new DefaultTableModel(colsDV, 0);
		jtable_TienNghi__TienNghi = new JTable(modelTienNghi);
		scrollPane_TienNghi.setViewportView(jtable_TienNghi__TienNghi);
		loadTienNghi();
		jtable_TienNghi__TienNghi.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stubs
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int pos = jtable_TienNghi__TienNghi.getSelectedRow();
				txt_MaTN_TienNghi.setText(modelTienNghi.getValueAt(pos, 0).toString());
				txt_MaTN_TienNghi.setEnabled(false);
				txt_comboboxMaPhong_TienNghi.setSelectedItem(modelTienNghi.getValueAt(pos, 1));
				txt_TenTN_TienNghi.setText(modelTienNghi.getValueAt(pos, 2).toString());
				cbo_TinhTrang_TienNghi.setSelectedItem(modelTienNghi.getValueAt(pos, 3));
				txt_SoLuong_TienNghi.setText(modelTienNghi.getValueAt(pos, 4).toString());
			}
		});

		GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup()
						.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
								.addComponent(scrollPane_TienNghi, javax.swing.GroupLayout.PREFERRED_SIZE, 667,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(GroupLayout.Alignment.LEADING,
										jPanel2Layout.createSequentialGroup()
												.addComponent(lblTmkiem__TienNghi, GroupLayout.PREFERRED_SIZE, 133,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(txt_TimKiem_TienNghi)))
						.addContainerGap(61, Short.MAX_VALUE)));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lblTmkiem__TienNghi, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(txt_TimKiem_TienNghi, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(scrollPane_TienNghi, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
						.addContainerGap()));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(43, 43, 43)
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(70, 70, 70)
						.addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(50, Short.MAX_VALUE))
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lbl_danhmuctiennghi, javax.swing.GroupLayout.PREFERRED_SIZE, 360,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(459, 459, 459)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(18, 18, 18)
						.addComponent(lbl_danhmuctiennghi, javax.swing.GroupLayout.PREFERRED_SIZE, 57,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(45, Short.MAX_VALUE)));
	}// </editor-fold>//GEN-END:initComponents

	private void clearTienNghi() {
		txt_MaTN_TienNghi.setText("");
		txt_MaTN_TienNghi.setEnabled(true);
		txt_TenTN_TienNghi.setText("");
		txt_comboboxMaPhong_TienNghi.setSelectedIndex(0);
		txt_comboboxMaPhong_TienNghi.setEnabled(true);
		cbo_TinhTrang_TienNghi.setSelectedIndex(0);
		txt_SoLuong_TienNghi.setText("");
		txt_MaTN_TienNghi.requestFocus();
	}

	// tạo tiện nghi mới
	private TienNghi TaoMoiTN() {
		String ma = txt_MaTN_TienNghi.getText();
		String maPhong = (String) txt_comboboxMaPhong_TienNghi.getSelectedItem();
		Phong p = phong_dao.timPhongTheoMa(maPhong);
		String ten = txt_TenTN_TienNghi.getText();
		String tinhTrang = cbo_TinhTrang_TienNghi.getSelectedItem().toString().trim();
		int soLuong = Integer.parseInt(txt_SoLuong_TienNghi.getText());
		return new TienNghi(ma, p, ten, tinhTrang, soLuong);
	}

	// check regex tiện nghi
	Border bdTrue = BorderFactory.createLineBorder(Color.green);
	Border bdFalse = BorderFactory.createLineBorder(Color.red);

	private boolean validData_TienNghi() {
		String ma = txt_MaTN_TienNghi.getText().trim();
		String maP = txt_comboboxMaPhong_TienNghi.getSelectedItem().toString().trim();
		String tenTN = txt_TenTN_TienNghi.getText().trim();
		String soluong = txt_SoLuong_TienNghi.getText().trim();

		// check mã tiện nghi
		int t = 0;
		for (TienNghi tn : listTN) {
			if (ma.equals(tn.getMaTienNghi()) && maP.equals(tn.getPhong().getMaPhong()))
				t = 1;
		}
		if (t == 1) {
			JOptionPane.showMessageDialog(null, "Error: Phòng " + maP
					+ " đã có mã tiện nghi này! Bạn có thể chọn phòng khác hoặc thay đổi mã tiện nghi!");
			return false;
		}
		if (ma.length() > 0 && !ma.equals("")) {
			if (!ma.matches("^(TN)[0-9]+")) {
				JOptionPane.showMessageDialog(null,
						"Error: Mã tiện nghi phải theo mẫu: Bắt đầu bằng TN và theo sau là dãy số!");
				txt_MaTN_TienNghi.requestFocus(true);
				txt_MaTN_TienNghi.setBorder(bdFalse);
				return false;
			} else {
				txt_MaTN_TienNghi.setBorder(bdTrue);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Error: Chưa nhập mã tiện nghi!");
			txt_MaTN_TienNghi.setBorder(bdFalse);
			return false;
		}

		// check ten tiện nghi
		if (tenTN.length() > 0 && !tenTN.equals("")) {
			if (!tenTN.matches("(^[A-Za-z])[a-z]+([ ][A-Za-z][a-z]+)*")) {
				JOptionPane.showMessageDialog(null, "Tên không chứ số!");
				txt_TenTN_TienNghi.requestFocus(true);
				txt_TenTN_TienNghi.setBorder(bdFalse);
				return false;
			} else {
				txt_TenTN_TienNghi.setBorder(bdTrue);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Chưa nhập tên tiện nghi!");
			txt_TenTN_TienNghi.requestFocus(true);
			txt_TenTN_TienNghi.setBorder(bdFalse);
			return false;
		}

		// Check số lượng
		if (soluong.length() > 0 && !soluong.equals("")) {
			if (!soluong.matches("[0-9]+")) {
				JOptionPane.showMessageDialog(null, "Error: Số lượng phải là kiểu số nguyên!");
				txt_SoLuong_TienNghi.requestFocus(true);
				txt_SoLuong_TienNghi.setBorder(bdFalse);
				return false;
			} else {
				txt_SoLuong_TienNghi.setBorder(bdTrue);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Error: Chưa nhập số lượng!");
			txt_SoLuong_TienNghi.requestFocus(true);
			txt_SoLuong_TienNghi.setBorder(bdFalse);
			return false;
		}
		return true;
	}

	// Kiểm tra dữ liệu cập nhật
	private boolean validDataEdit_TienNghi() {
		String tenTN = txt_TenTN_TienNghi.getText().trim();
		String soluong = txt_SoLuong_TienNghi.getText().trim();

		// check ten tiện nghi
		if (tenTN.length() > 0 && !tenTN.equals("")) {
			if (!tenTN.matches("(^[A-Za-z])[a-z]+([ ][A-Za-z][a-z]+)*")) {
				JOptionPane.showMessageDialog(null, "Tên không chứ số!");
				txt_TenTN_TienNghi.requestFocus(true);
				txt_TenTN_TienNghi.setBorder(bdFalse);
				return false;
			} else {
				txt_TenTN_TienNghi.setBorder(bdTrue);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Chưa nhập tên tiện nghi!");
			txt_TenTN_TienNghi.requestFocus(true);
			txt_TenTN_TienNghi.setBorder(bdFalse);
			return false;
		}

		// Check số lượng
		if (soluong.length() > 0 && !soluong.equals("")) {
			if (!soluong.matches("[0-9]+")) {
				JOptionPane.showMessageDialog(null, "Error: Số lượng phải là kiểu số nguyên!");
				txt_SoLuong_TienNghi.requestFocus(true);
				txt_SoLuong_TienNghi.setBorder(bdFalse);
				return false;
			} else {
				txt_SoLuong_TienNghi.setBorder(bdTrue);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Error: Chưa nhập số lượng!");
			txt_SoLuong_TienNghi.requestFocus(true);
			txt_SoLuong_TienNghi.setBorder(bdFalse);
			return false;
		}
		return true;
	}
}
