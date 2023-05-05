package gui;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import connectDB.ConnectDB;
import dao.NhanVien_DAO;
import entity.NhanVien;

/**
 *
 * @author Vu
 */
public class Frame_Login extends javax.swing.JFrame {
	private javax.swing.JButton btnDangNhap;
	private javax.swing.JButton btnXoaTrang;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JLabel lbIconPass;
	private javax.swing.JLabel lbIconTaiKhoan;
	private javax.swing.JPasswordField txtPassword;
	private javax.swing.JTextField txtTaiKhoan;
	Connection conn;
	private NhanVien_DAO nhanVien_dao;

	public Frame_Login() {
		try {
			ConnectDB.getInstance().connect();
		} catch (Exception e) {
			// TODO: handle exception
		}
		initComponents();
		setLocationRelativeTo(null);

	}

	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jPanel2 = new javax.swing.JPanel();
		btnXoaTrang = new javax.swing.JButton();
		btnDangNhap = new javax.swing.JButton();
		lbIconTaiKhoan = new javax.swing.JLabel();
		txtTaiKhoan = new javax.swing.JTextField();
		lbIconPass = new javax.swing.JLabel();
		txtPassword = new javax.swing.JPasswordField();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setBackground(new java.awt.Color(242, 147, 255));
		setResizable(false);
		getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

		jPanel1.setBackground(new java.awt.Color(232, 245, 252));

		jLabel1.setIcon(new javax.swing.ImageIcon("item/logo170.png")); // NOI18N

		jLabel2.setFont(new java.awt.Font("Viner Hand ITC", 1, 48)); // NOI18N
		jLabel2.setText("BVTL");

		jLabel3.setFont(new java.awt.Font("Viner Hand ITC", 0, 36)); // NOI18N
		jLabel3.setText("Hotel");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						jPanel1Layout.createSequentialGroup()
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 103,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(117, 117, 117))
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(79, 79, 79)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabel2).addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										jPanel1Layout.createSequentialGroup().addComponent(jLabel1).addGap(9, 9, 9)))
						.addContainerGap(75, Short.MAX_VALUE)));
		jPanel1Layout
				.setVerticalGroup(
						jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel1Layout.createSequentialGroup().addGap(39, 39, 39)
										.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 138,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 56,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 45,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(71, Short.MAX_VALUE)));

		getContentPane().add(jPanel1);

		jPanel2.setBackground(new java.awt.Color(35, 142, 241));
		jPanel2.setPreferredSize(new java.awt.Dimension(340, 431));

		btnXoaTrang.setBackground(new java.awt.Color(35, 142, 241));
		btnXoaTrang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		btnXoaTrang.setForeground(new java.awt.Color(255, 255, 255));
		btnXoaTrang.setText("Xóa ");
		btnXoaTrang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
		btnXoaTrang.setPreferredSize(new java.awt.Dimension(60, 18));
		btnXoaTrang.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnXoaTrangActionPerformed(evt);
			}
		});

		btnDangNhap.setBackground(new java.awt.Color(35, 142, 241));
		btnDangNhap.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		btnDangNhap.setForeground(new java.awt.Color(255, 255, 255));
		btnDangNhap.setText("Đăng nhập");
		btnDangNhap.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
		btnDangNhap.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnDangNhapActionPerformed(evt);
			}
		});

		lbIconTaiKhoan.setBackground(new java.awt.Color(255, 255, 255));
		lbIconTaiKhoan.setForeground(new java.awt.Color(255, 255, 255));
		lbIconTaiKhoan.setIcon(new javax.swing.ImageIcon("item/user40.png")); // NOI18N

		txtTaiKhoan.setBackground(new java.awt.Color(35, 142, 241));
		txtTaiKhoan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		txtTaiKhoan.setForeground(new java.awt.Color(255, 255, 255));
		txtTaiKhoan.setText("ThaiBao");
		txtTaiKhoan
				.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));

		lbIconPass.setForeground(new java.awt.Color(255, 255, 255));
		lbIconPass.setIcon(new javax.swing.ImageIcon("item/password.png")); // NOI18N

		txtPassword.setBackground(new java.awt.Color(35, 142, 241));
		txtPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		txtPassword.setForeground(new java.awt.Color(255, 255, 255));
		txtPassword.setText("123456");
		txtPassword
				.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
						.addGroup(jPanel2Layout.createSequentialGroup().addGap(35, 35, 35)
								.addGroup(jPanel2Layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(lbIconPass, javax.swing.GroupLayout.PREFERRED_SIZE, 37,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(lbIconTaiKhoan, javax.swing.GroupLayout.DEFAULT_SIZE, 43,
												Short.MAX_VALUE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(txtTaiKhoan).addComponent(txtPassword)))
						.addGroup(jPanel2Layout.createSequentialGroup().addGap(76, 76, 76)
								.addComponent(btnXoaTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 115,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(btnDangNhap, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)))
						.addGap(25, 25, 25)));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup().addGap(63, 63, 63)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lbIconTaiKhoan).addComponent(txtTaiKhoan,
										javax.swing.GroupLayout.PREFERRED_SIZE, 40,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(32, 32, 32)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel2Layout.createSequentialGroup()
										.addComponent(lbIconPass, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGap(256, 256, 256))
								.addGroup(jPanel2Layout.createSequentialGroup()
										.addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(49, 49, 49)
										.addGroup(jPanel2Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(btnXoaTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 37,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(btnDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 37,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))));

		getContentPane().add(jPanel2);

		setBounds(0, 0, 699, 368);
	}// </editor-fold>

	private void btnDangNhapActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDangNhapActionPerformed
		nhanVien_dao = new NhanVien_DAO();
		String taiKhoan = txtTaiKhoan.getText().trim();
		NhanVien nv = nhanVien_dao.timNhanVienTheoTaiKhoan(taiKhoan);
		if (nv != null) {
			if (nv.getPassWord().equals(String.valueOf(txtPassword.getPassword()))) {
				if (nv.getChucVu().equalsIgnoreCase("Quan Ly")) {
					App frm_QuanLy = new App(nv);
					frm_QuanLy.setLocationRelativeTo(null);
					frm_QuanLy.setVisible(true);
					frm_QuanLy.setTitle("QLKS");
					frm_QuanLy.setResizable(false);
					frm_QuanLy.setDefaultCloseOperation(EXIT_ON_CLOSE);
					frm_QuanLy.setIconImage(Toolkit.getDefaultToolkit().getImage("item\\1490859831_home_16x16.gif"));
					this.dispose();
				} else {
					App_NhanVien frm_NhanVien = new App_NhanVien(nv);
					frm_NhanVien.setLocationRelativeTo(null);
					frm_NhanVien.setVisible(true);
					frm_NhanVien.setTitle("QLKS");
					frm_NhanVien.setResizable(false);
					frm_NhanVien.setDefaultCloseOperation(EXIT_ON_CLOSE);
					frm_NhanVien.setIconImage(Toolkit.getDefaultToolkit().getImage("item\\1490859831_home_16x16.gif"));
					this.dispose();
				}

			} else
				JOptionPane.showMessageDialog(this, "Sai tai khoan hoac mat khau", "Lỗi", JOptionPane.ERROR_MESSAGE);
		} else
			JOptionPane.showMessageDialog(this, "Sai tai khoan ", "Lỗi", JOptionPane.ERROR_MESSAGE);
	}// GEN-LAST:event_btnDangNhapActionPerformed

	/**
	 * @param args the command line arguments
	 */
	private void btnXoaTrangActionPerformed(java.awt.event.ActionEvent evt) {
		txtTaiKhoan.setText("");
		txtPassword.setText("");
		txtTaiKhoan.requestFocus();
	}

}
