package Proje;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Kayit extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	private Panel panel;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_2;
	private JButton iptalButonu;
	/**
	 * Create the panel.
	 */
	public Kayit(final JLayeredPane pane, final Panel panel2) {

		
		panel = new Panel();		
		panel.setBackground(new Color(250, 235, 215));
		panel.setBounds(0, 0, 800, 520);
		add(panel);
		panel.setLayout(null);	
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(298, 140, 230, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Kullan\u0131c\u0131 Ad\u0131 :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setForeground(new Color(178, 34, 34));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(150, 140, 119, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Sifre :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setForeground(new Color(178, 34, 34));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(179, 187, 90, 14);
		panel.add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(298, 184, 230, 20);
		panel.add(passwordField);
		
		textField_2 = new JTextField();
		textField_2.setBounds(298, 232, 230, 134);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Adres :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setForeground(new Color(178, 34, 34));
		lblNewLabel_4.setBounds(179, 232, 90, 20);
		panel.add(lblNewLabel_4);
		
		iptalButonu = new JButton("IPTAL ET");
		iptalButonu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pane.removeAll();
				pane.add(panel2);
				pane.repaint();
				pane.revalidate();
			}
		});

		iptalButonu.setBounds(298, 394, 89, 23);
		iptalButonu.setBackground(new Color(178, 34, 34));
		iptalButonu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(iptalButonu);
		
		JButton kayýtButonu = new JButton("KAYIT OL");
		kayýtButonu.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String k_ad = textField.getText();	
				String sifre = passwordField.getText();
				String adres = textField_2.getText();
				database kayit =new database();
				try {
					kayit.kayityap(k_ad, sifre, adres);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				pane.removeAll();
				pane.add(panel2);
				pane.repaint();
				pane.revalidate();
				}
		});
		kayýtButonu.setBackground(new Color(135, 206, 250));
		kayýtButonu.setBounds(439, 394, 89, 23);
		kayýtButonu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(kayýtButonu);
		
		JLabel lblNewLabel_5 = new JLabel("KAYIT FORMU");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_5.setBounds(298, 1, 230, 75);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBounds(500, 1, 40, 75);
		lblNewLabel_6.setIcon(new ImageIcon(Login.class.getResource("/kayit2.png")));
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setBackground(new Color(255, 140, 0));
		lblNewLabel_7.setOpaque(true);
		lblNewLabel_7.setForeground(new Color(255, 255, 255));
		lblNewLabel_7.setBounds(0, 0, 800, 75);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Zaten Uye Misiniz?  --->");
		lblNewLabel_8.setLocation(-42, 0);
		lblNewLabel_8.setForeground(new Color(255, 255, 255));
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel.add(lblNewLabel_8);
	}

	public Panel getPanel() {
		return panel;
	}

	public JButton getIptalButonu() {
		return iptalButonu;
	}
}
