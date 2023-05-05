package gui;

import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TrangChu extends JFrame {
	protected JPanel panel_WellCome;

	public TrangChu() {
		GUI_TrangChu();

	}

	public void GUI_TrangChu() {
		panel_WellCome = new JPanel();
		panel_WellCome.setBackground(SystemColor.info);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("item\\lobby3.jpg"));
		lblNewLabel_3.setBounds(10, 30, 970, 800);
		panel_WellCome.add(lblNewLabel_3);
	}
}
