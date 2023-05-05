package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import dao.NhanVien_DAO;
import entity.NhanVien;

public class Frame_DoiPass extends javax.swing.JFrame {
	private javax.swing.JButton btnHuy;
	private javax.swing.JButton btnXacNhan;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel11;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JPanel jPanel5;
	private javax.swing.JLabel jlbMKCu;
	private javax.swing.JLabel jlbMKMoi;
	private javax.swing.JLabel jlbMKXacNhan;
	private javax.swing.JPasswordField tfMKCu;
	private javax.swing.JPasswordField tfMKMoi;
	private javax.swing.JPasswordField tfMKXacNhan;
	private NhanVien nv;
	private NhanVien_DAO nhanvien_dao;

	public Frame_DoiPass(NhanVien nv) {
		setResizable(false);
		this.nv = nv;
		nhanvien_dao = new NhanVien_DAO();
		setUndecorated(true); // tắt thanh tiêu đề
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initComponents();
		addControls();
	}

	private void addControls() {
		btnHuy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnXacNhan.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String mkCu = String.valueOf(tfMKCu.getPassword());
				String mkMoi = String.valueOf(tfMKMoi.getPassword());
				String mkXacNhan = String.valueOf(tfMKXacNhan.getPassword());
				if (!mkMoi.equals(mkXacNhan)) {

					JOptionPane.showMessageDialog(null, "Mật khẩu xác nhận không trùng!!!", "Lỗi",
							JOptionPane.ERROR_MESSAGE);
				} else if (!mkCu.equals(nv.getPassWord())) {
					JOptionPane.showMessageDialog(null, "Mật khẩu cũ không chính xác!!", "Lỗi",
							JOptionPane.ERROR_MESSAGE);
				} else {
					nv.setPassWord(mkMoi);
					;
					try {
						JOptionPane.showMessageDialog(null, "Đổi mật khẩu thành công!!");
						nv = nhanvien_dao.timNhanVienTheoTaiKhoan(nv.getUserName());
						nv.setPassWord(mkMoi);
						nhanvien_dao.doiMatKhau(nv);

					} catch (Exception e1) {
						e1.printStackTrace();
					}
					setVisible(false);
				}
			}
		});
	}

	private void initComponents() {

		jPanel2 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jPanel1 = new javax.swing.JPanel();
		jPanel3 = new javax.swing.JPanel();
		jLabel2 = new javax.swing.JLabel();
		jPanel4 = new javax.swing.JPanel();
		jlbMKCu = new javax.swing.JLabel();
		tfMKCu = new javax.swing.JPasswordField();
		jPanel5 = new javax.swing.JPanel();
		jlbMKMoi = new javax.swing.JLabel();
		tfMKMoi = new javax.swing.JPasswordField();
		jPanel11 = new javax.swing.JPanel();
		jlbMKXacNhan = new javax.swing.JLabel();
		tfMKXacNhan = new javax.swing.JPasswordField();
		btnHuy = new javax.swing.JButton();
		btnXacNhan = new javax.swing.JButton();

		jPanel2.setBackground(new java.awt.Color(255, 204, 204));
		jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
		jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

		jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
		jLabel1.setText("Đổi mật khẩu");

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup().addGap(267, 267, 267).addComponent(jLabel1)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(jLabel1)
						.addContainerGap(13, Short.MAX_VALUE)));

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jPanel1.setBackground(new java.awt.Color(35, 142, 241));
		jPanel1.setPreferredSize(new java.awt.Dimension(678, 488));

		jPanel3.setBackground(new java.awt.Color(35, 142, 241));
		jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
		jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

		jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
		jLabel2.setForeground(new java.awt.Color(255, 255, 255));
		jLabel2.setText("Đổi mật khẩu");

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup().addGap(258, 258, 258).addComponent(jLabel2)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(jLabel2)
						.addContainerGap(13, Short.MAX_VALUE)));

		jPanel4.setBackground(new java.awt.Color(35, 142, 241));
		jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));

		jlbMKCu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		jlbMKCu.setForeground(new java.awt.Color(255, 255, 255));
		jlbMKCu.setText("Mật khẩu cũ:");

		tfMKCu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		tfMKCu.setBorder(null);

		javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
		jPanel4.setLayout(jPanel4Layout);
		jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addComponent(jlbMKCu)
						.addGap(113, 113, 113)
						.addComponent(tfMKCu, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)));
		jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel4Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jlbMKCu).addComponent(tfMKCu, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(9, Short.MAX_VALUE)));

		jPanel5.setBackground(new java.awt.Color(35, 142, 241));
		jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));

		jlbMKMoi.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		jlbMKMoi.setForeground(new java.awt.Color(255, 255, 255));
		jlbMKMoi.setText("Mật khẩu mới:");

		tfMKMoi.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		tfMKMoi.setBorder(null);

		javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
		jPanel5.setLayout(jPanel5Layout);
		jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addComponent(jlbMKMoi)
						.addGap(99, 99, 99).addComponent(tfMKMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 427,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, Short.MAX_VALUE)));
		jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel5Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(tfMKMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jlbMKMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 31,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(11, Short.MAX_VALUE)));

		jPanel11.setBackground(new java.awt.Color(35, 142, 241));
		jPanel11.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));

		jlbMKXacNhan.setBackground(new java.awt.Color(35, 142, 241));
		jlbMKXacNhan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		jlbMKXacNhan.setForeground(new java.awt.Color(255, 255, 255));
		jlbMKXacNhan.setText("Xác nhận mật khẩu mới:");

		tfMKXacNhan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		tfMKXacNhan.setBorder(null);

		javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
		jPanel11.setLayout(jPanel11Layout);
		jPanel11Layout.setHorizontalGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel11Layout.createSequentialGroup().addContainerGap()
						.addComponent(jlbMKXacNhan, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
						.addGap(18, 18, 18).addComponent(tfMKXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 425,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, 0)));
		jPanel11Layout.setVerticalGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel11Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jlbMKXacNhan).addComponent(tfMKXacNhan,
										javax.swing.GroupLayout.PREFERRED_SIZE, 29,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(9, Short.MAX_VALUE)));

		btnHuy.setBackground(new java.awt.Color(255, 102, 0));
		btnHuy.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
		btnHuy.setForeground(new java.awt.Color(255, 255, 255));
		btnHuy.setText("Hủy");

		btnXacNhan.setBackground(new java.awt.Color(255, 102, 0));
		btnXacNhan.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
		btnXacNhan.setForeground(new java.awt.Color(255, 255, 255));
		btnXacNhan.setText("Xác nhận");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
						.addContainerGap(27, Short.MAX_VALUE)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										jPanel1Layout.createSequentialGroup()
												.addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 165,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(32, 32, 32)
												.addComponent(btnXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 165,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(156, 156, 156))
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										jPanel1Layout.createSequentialGroup()
												.addGroup(jPanel1Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGap(40, 40, 40)))));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 39,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(btnXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 39,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(35, 35, 35)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 719, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE));

		pack();
	}

}
