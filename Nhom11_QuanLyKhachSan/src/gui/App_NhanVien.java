/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.AncestorListener;

import entity.NhanVien;

/**
 *
 * @author Vu
 */
public class App_NhanVien extends javax.swing.JFrame{

    private MenuItem menuHomePage,menuDatPhong,menuDungDichVu,menuHoaDon,menuHoaDonThanhToan,menuHoaDonThanhToanSDDV, menuQuanLy ,
            menuQLKHang ,menuQLDVu,menuQLTNghi;

	private CardLayout cardLayout;
	private QuanLyThuePhong ql_ThuePhong;
	private ThanhToanDichVu hd_DichVu;
	private HoaDonTongHop hd_TongHop;
	private TrangChu trangChu;
	private JPanel mainPanel;
	private QuanLyDichVu ql_DichVu;
	private QuanLyTienNghi ql_tienNghi;

	private NhanVien nv;

	private Frame_DoiPass frmDoiPass;
	
    private javax.swing.JButton btnChangePass;
    private javax.swing.JButton btnLogout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel menus;
    private javax.swing.JPanel panelBody;
    private javax.swing.JPanel panelHeader;
    private javax.swing.JPanel panelMenu;
    
    public App_NhanVien(NhanVien nv) {
        initComponents(nv);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        trangChu = new TrangChu();
        ql_ThuePhong = new QuanLyThuePhong();
		hd_DichVu = new ThanhToanDichVu();
		try {
			hd_TongHop = new HoaDonTongHop();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        ql_DichVu = new QuanLyDichVu();
		ql_tienNghi = new QuanLyTienNghi();
		cardLayout = new CardLayout();
		mainPanel = new JPanel(cardLayout);
		mainPanel.add(trangChu.panel_WellCome, "Trang chủ");
		mainPanel.add(ql_ThuePhong.panel_DatPhong, "Đặt phòng");
		mainPanel.add(ql_ThuePhong.panel_SDDV, "Dùng dịch vụ");
		mainPanel.add(ql_ThuePhong.panel_KhachHang, "Quản lý khách hàng");
		mainPanel.add(hd_DichVu.panel_HoaDon_And_KHChuaTT_SDDV, "Thanh toán sử dụng dịch vụ");
		mainPanel.add(hd_TongHop.panel_HoaDonTongHop, "Thanh toán");
		mainPanel.add(hd_TongHop.panel_KHChuaTT_PHONG, "Khách hàng chưa thanh toán phòng");
		mainPanel.add(ql_DichVu, "Quản lý dịch vụ");
		mainPanel.add(ql_tienNghi, "Quản lý tiện nghi");
        
        execute();
        panelBody.add(mainPanel, BorderLayout.CENTER);
    }
    private void execute(){
          //icon
          ImageIcon iconHomePage = new ImageIcon("item/homeColor.png");
          ImageIcon iconBookRoom = new ImageIcon("item/bookColor.png");
          ImageIcon iconRoom = new ImageIcon("item/roomColor.png");
          ImageIcon iconBill = new ImageIcon("item/billColor.png");
          ImageIcon iconCustomer = new ImageIcon("item/customerColor.png");
//          ImageIcon iconThongKe = new ImageIcon("item/analytics.png");
          ImageIcon iconBill1 = new ImageIcon("item/dot.png");
          ImageIcon iconBill2 = new ImageIcon("item/dot.png");
          ImageIcon iconService = new ImageIcon("item/service-40.png");
          //menu trang chủ
          menuHomePage = new MenuItem(iconHomePage, "Trang chủ", new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  menuHomePage.setBackground(Color.cyan);
                  menuQuanLy.setBackground(menus.getBackground());
                  menuDatPhong.setBackground(menus.getBackground()); 
                  menuDungDichVu.setBackground(menus.getBackground()); 
                  menuHoaDon.setBackground(menus.getBackground()); 
                  menuHoaDonThanhToan.setBackground(Color.white);
                  menuHoaDonThanhToanSDDV.setBackground(Color.white);
                  menuQLKHang.setBackground(Color.white);
                  menuQLDVu.setBackground(Color.white);
                  menuQLTNghi.setBackground(Color.white);
                  
                  cardLayout.show(mainPanel, "Trang chủ");
              }
          });
          //menu đặt phòng
          menuDatPhong = new MenuItem(iconRoom, "Đặt phòng", new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  menuDatPhong.setBackground(Color.cyan);
                  menuQuanLy.setBackground(menus.getBackground());
                  menuHomePage.setBackground(menus.getBackground()); 
                  menuDungDichVu.setBackground(menus.getBackground()); 
                  menuHoaDon.setBackground(menus.getBackground()); 
                  menuHoaDonThanhToan.setBackground(Color.white);
                  menuHoaDonThanhToanSDDV.setBackground(Color.white);
                  menuQLKHang.setBackground(Color.white);
                  menuQLDVu.setBackground(Color.white);
                  menuQLTNghi.setBackground(Color.white);
                  
                  cardLayout.show(mainPanel, "Đặt phòng");
              }
          });
          menuDungDichVu = new MenuItem(iconService, "Dùng dịch vụ", new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  menuDungDichVu.setBackground(Color.cyan);
                  menuQuanLy.setBackground(menus.getBackground());
                  menuHomePage.setBackground(menus.getBackground()); 
                  menuDatPhong.setBackground(menus.getBackground()); 
                  menuHoaDon.setBackground(menus.getBackground()); 
                  menuHoaDonThanhToan.setBackground(Color.white);
                  menuHoaDonThanhToanSDDV.setBackground(Color.white);
                  menuQLKHang.setBackground(Color.white);
                  menuQLDVu.setBackground(Color.white);
                  menuQLTNghi.setBackground(Color.white);
                  
                  cardLayout.show(mainPanel, "Dùng dịch vụ");
              }
          });
          menuHoaDonThanhToan = new MenuItem(iconBill1, "Thanh toán", new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  menuHoaDonThanhToan.setBackground(new Color(255, 195, 174));
                  menuQLKHang.setBackground(Color.white);
                  menuHoaDonThanhToanSDDV.setBackground(Color.white);
                  menuQLDVu.setBackground(Color.white);
                  menuQLTNghi.setBackground(Color.white);
                  
                  cardLayout.show(mainPanel, "Thanh toán");
              }
          });
          menuHoaDonThanhToanSDDV = new MenuItem(iconBill2, "Thanh toán sử dụng dịch vụ", new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  menuHoaDonThanhToanSDDV.setBackground(new Color(255, 195, 174));
                  menuQLKHang.setBackground(Color.white);
                  menuHoaDonThanhToan.setBackground(Color.white);
                  menuQLDVu.setBackground(Color.white);
                  menuQLTNghi.setBackground(Color.white);
                  
                  cardLayout.show(mainPanel, "Thanh toán sử dụng dịch vụ");
              }
          });
          //menu hóa đơn
          menuHoaDon = new MenuItem(iconBill, "Hóa đơn", new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  menuHoaDon.setBackground(Color.cyan);
                  menuQuanLy.setBackground(menus.getBackground());
                  menuDatPhong.setBackground(menus.getBackground()); 
                  menuDungDichVu.setBackground(menus.getBackground()); 
                  menuHomePage.setBackground(menus.getBackground()); 
                  menuHoaDonThanhToan.setBackground(Color.white);
                  menuHoaDonThanhToanSDDV.setBackground(Color.white);
                  menuQLKHang.setBackground(Color.white);
                  menuQLDVu.setBackground(Color.white);
                  menuQLTNghi.setBackground(Color.white);
              }
          }, menuHoaDonThanhToan, menuHoaDonThanhToanSDDV);
          //menu quản lý khách hàng
          menuQLKHang = new MenuItem(iconBill1, "Quản lý khách hàng", new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  menuQLKHang.setBackground(new Color(255, 195, 174));
                  menuHoaDonThanhToan.setBackground(Color.white);
                  menuHoaDonThanhToanSDDV.setBackground(Color.white);
                  menuQLDVu.setBackground(Color.white);
                  menuQLTNghi.setBackground(Color.white);
                  
                  cardLayout.show(mainPanel, "Quản lý khách hàng");
              }
          });

          menuQLDVu = new MenuItem(iconBill2, "Quản lý dịch vụ", new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  menuQLDVu.setBackground(new Color(255, 195, 174));
                  menuHoaDonThanhToan.setBackground(Color.white);
                  menuHoaDonThanhToanSDDV.setBackground(Color.white);
                  menuQLKHang.setBackground(Color.white);
                  menuQLTNghi.setBackground(Color.white);
                  
                  cardLayout.show(mainPanel, "Quản lý dịch vụ");
              }
          });
          menuQLTNghi = new MenuItem(iconBill2, "Quản lý tiện nghi", new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  menuQLTNghi.setBackground(new Color(255, 195, 174));
                  menuHoaDonThanhToan.setBackground(Color.white);
                  menuHoaDonThanhToanSDDV.setBackground(Color.white);
                  menuQLKHang.setBackground(Color.white);
                  menuQLDVu.setBackground(Color.white);
                  
                  cardLayout.show(mainPanel, "Quản lý tiện nghi");
              }
          });

          menuQuanLy = new MenuItem(iconCustomer, "Quản lý", new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  menuQuanLy.setBackground(Color.cyan);
                  menuHomePage.setBackground(menus.getBackground());
                  menuDatPhong.setBackground(menus.getBackground()); 
                  menuDungDichVu.setBackground(menus.getBackground()); 
                  menuHoaDon.setBackground(menus.getBackground()); 
                  menuHoaDonThanhToan.setBackground(Color.white);
                  menuHoaDonThanhToanSDDV.setBackground(Color.white);
                  menuQLKHang.setBackground(Color.white);
                  menuQLDVu.setBackground(Color.white);
                  menuQLTNghi.setBackground(Color.white);
                  

              }
          }, menuQLKHang, menuQLDVu, menuQLTNghi);
          
          
          menuHomePage.setBackground(menus.getBackground());
          menuQuanLy.setBackground(menus.getBackground());    
          menuDatPhong.setBackground(menus.getBackground());  
          menuDungDichVu.setBackground(menus.getBackground());  
          menuHoaDon.setBackground(menus.getBackground());  

          
          addMenu(menuHomePage,menuDatPhong, menuDungDichVu, menuHoaDon  ,menuQuanLy);
    }
    
    //add tất cả menu
    private void addMenu(MenuItem...menu){
        for(int i=0;i<menu.length;i++){
            menus.add(menu[i]);
            ArrayList<MenuItem> subMenu = menu[i].getSubMenu();
            for(MenuItem m : subMenu){
                addMenu(m);
            }
        }
        menus.revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents(NhanVien nv) {

        panelHeader = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        panelMenu = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        menus = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnChangePass = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        panelBody = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelHeader.setBackground(new java.awt.Color(35, 142, 241));

        jLabel8.setFont(new java.awt.Font("Cambria", 1, 48)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Chương trình quản lí khách sạn");

        jLabel3.setIcon(new javax.swing.ImageIcon("item/logo70.png")); // NOI18N

        jLabel4.setFont(new java.awt.Font("Viner Hand ITC", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("BVTL");

        jLabel5.setFont(new java.awt.Font("Tempus Sans ITC", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Hotel");

        javax.swing.GroupLayout panelHeaderLayout = new javax.swing.GroupLayout(panelHeader);
        panelHeader.setLayout(panelHeaderLayout);
        panelHeaderLayout.setHorizontalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHeaderLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addContainerGap(1082, Short.MAX_VALUE))
            .addGroup(panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelHeaderLayout.createSequentialGroup()
                    .addGap(501, 501, 501)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 709, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(142, Short.MAX_VALUE)))
        );
        panelHeaderLayout.setVerticalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHeaderLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelHeaderLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelHeaderLayout.createSequentialGroup()
                    .addGap(12, 12, 12)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(41, Short.MAX_VALUE)))
        );

        getContentPane().add(panelHeader, java.awt.BorderLayout.PAGE_START);

        panelMenu.setBackground(new java.awt.Color(255, 255, 255));
        panelMenu.setPreferredSize(new java.awt.Dimension(250, 600));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(0, 0, 0)));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        menus.setBackground(new java.awt.Color(232, 245, 252));
        menus.setLayout(new javax.swing.BoxLayout(menus, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(menus);

        jPanel1.setBackground(new java.awt.Color(232, 245, 252));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setIcon(new javax.swing.ImageIcon("item/nhanVien.png")); // NOI18N

        jLabel2.setText(nv.getFullName());

        btnChangePass.setBackground(new java.awt.Color(35, 142, 241));
        btnChangePass.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnChangePass.setForeground(new java.awt.Color(255, 255, 255));
        btnChangePass.setIcon(new javax.swing.ImageIcon("item/key.png")); // NOI18N
        btnChangePass.setText("Đổi mật khẩu");
        btnChangePass.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnChangePass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangePassActionPerformed(evt);
            }
        });

        btnLogout.setBackground(new java.awt.Color(35, 142, 241));
        btnLogout.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(255, 255, 255));
        btnLogout.setIcon(new javax.swing.ImageIcon("item/doiPass.png")); // NOI18N
        btnLogout.setText("Đăng xuất");
        btnLogout.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnLogout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnDangXuat(e);
			}
		});

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChangePass, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                    .addComponent(btnLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(50, 50, 50))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(btnChangePass)
                .addGap(12, 12, 12)
                .addComponent(btnLogout)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(panelMenu, java.awt.BorderLayout.LINE_START);

        panelBody.setBackground(new java.awt.Color(255, 255, 255));
        panelBody.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelBodyMousePressed(evt);
            }
        });
        panelBody.setLayout(new java.awt.BorderLayout());
        getContentPane().add(panelBody, java.awt.BorderLayout.CENTER);

        setBounds(0, 0, 1366, 782);
    }// </editor-fold>//GEN-END:initComponents

    private void btnChangePassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangePassActionPerformed
    	frmDoiPass = new Frame_DoiPass(nv);
    	frmDoiPass.setLocationRelativeTo(null);
    	frmDoiPass.setVisible(true);
    	frmDoiPass.setIconImage(Toolkit.getDefaultToolkit().getImage("item\\1490859831_home_16x16.gif"));
    	frmDoiPass.setTitle("QLKS");
    	frmDoiPass.setDefaultCloseOperation(EXIT_ON_CLOSE);
    	
    }
    private void btnDangXuat(ActionEvent e) {
    	this.setVisible(false);
    	Frame_Login login = new Frame_Login();
    	login.setVisible(true);
    	login.setLocationRelativeTo(null);
    	login.setIconImage(Toolkit.getDefaultToolkit().getImage("item\\1490859831_home_16x16.gif"));
    	login.setTitle("QLKS");
    	login.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    private void panelBodyMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBodyMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_panelBodyMousePressed


}
