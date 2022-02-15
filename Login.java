package Proje;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Login extends JPanel {

	private Panel panel;

	/**
	 * Create the panel.
	 */
	public Login() {
		panel = new Panel();		
		panel.setBackground(new Color(255, 140, 0));
		panel.setBounds(0, 0, 800, 520);
		add(panel);
		panel.setLayout(null);	

		JTextField textField = new JTextField();
		textField.setBounds(225, 257, 198, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		final JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(225, 288, 198, 20);
		panel.add(passwordField);
		
		JButton btnNewButton = new JButton("GIRIS YAP");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//burada anasayfa acýlmalý ama satýcý ve musteri farklý
			}
		});
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBounds(225, 346, 95, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("KAYIT OL");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//dispose();
			}
		});
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(328, 346, 95, 23);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("GIRIS");
		
		lblNewLabel.setForeground(new Color(25, 140, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(213, 145, 210, 47);
		panel.add(lblNewLabel);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Kullanýcý Adý :");
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/user3.png")));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(96, 257, 119, 20);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Sifre :");
		lblNewLabel_2.setIcon(new ImageIcon(Login.class.getResource("/Lock22.jpg")));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(96, 291, 119, 14);
		panel.add(lblNewLabel_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		comboBox.setBounds(225, 223, 198, 23);
		comboBox.addItem("Admin");
		comboBox.addItem("Kullanici");
		panel.add(comboBox);
		
		JLabel lblNewLabel_3 = new JLabel("Rolunuzu Secin :");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(96, 228, 119, 18);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(541, 128, 259, 291);
		lblNewLabel_4.setIcon(new ImageIcon(Login.class.getResource("/araba2.png")));
		panel.add(lblNewLabel_4);
		
		final JCheckBox chckbxNewCheckBox = new JCheckBox("SIFRE GOSTER");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(chckbxNewCheckBox.isSelected()) {
					passwordField.setEchoChar((char)0);
				}else {
					passwordField.setEchoChar('*');
				}
				
			}
		});
		chckbxNewCheckBox.setBounds(297, 316, 126, 23);
		panel.add(chckbxNewCheckBox);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setForeground(new Color(0, 100, 0));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setOpaque(true);
		lblNewLabel_5.setBackground(new Color(255, 255, 255));
		lblNewLabel_5.setBounds(541, 0, 259, 524);
		panel.add(lblNewLabel_5);
	
	
	}

	public Panel getPanel() {
		return panel;
	}
}
