package Proje;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.Action;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Label;

public class Anasayfa extends JFrame {
	private JPanel contentPane;
	private Login login_panel;
	private JLayeredPane layeredPane = new JLayeredPane();		
	private Panel panel;
	private JMenu giris_menu;
	private JMenuItem admin;
	private int giris_tipi;
	private Kategoriler kategoriler;
	private Kayit kayit;
	private JComboBox<String> comboBox;
	private JButton kayitButonu;
	private JButton cikisButonu;
	private JButton sepetButonu;
	private JButton kategoriButonu;
	private Musteri musteri;

	public int getGiris_tipi() {
		return giris_tipi;
	}

	public void setGiris_tipi(int giris_tipi) {
		this.giris_tipi = giris_tipi;
	}

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Anasayfa frame = new Anasayfa();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Anasayfa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 797, 657);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cikisButonu = new JButton("Çýkýþ Yap");
		cikisButonu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(panel);
				layeredPane.repaint();
				layeredPane.revalidate();	
				cikisButonu.setVisible(false);
				sepetButonu.setVisible(false);
				kategoriButonu.setVisible(false);
			}
		});
		
		sepetButonu = new JButton("Sepetim");

		
		kategoriButonu = new JButton("Kategoriler");
		kategoriButonu.setBounds(675, 60, 100, 21);
		contentPane.add(kategoriButonu);
		sepetButonu.setBounds(675, 35, 100, 21);
		contentPane.add(sepetButonu);
		
		cikisButonu.setBounds(675, 10, 100, 21);
		contentPane.add(cikisButonu);		
		cikisButonu.setVisible(false);
		sepetButonu.setVisible(false);
		kategoriButonu.setVisible(false);
		
		
		panel = new Panel();		
		panel.setBackground(new Color(255, 140, 0));
		panel.setBounds(0, 0, 800, 520);
		panel.setLayout(null);	
		layeredPane.setBounds(0, 103, 789, 610);
		
		contentPane.add(layeredPane);
		JTextField textField = new JTextField();
		layeredPane.add(panel);

		textField.setBounds(191, 256, 200, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		final JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(191, 287, 200, 20);
		panel.add(passwordField);		
		
		
		kayitButonu = new JButton("KAYIT OL");
		kayitButonu.addMouseListener(new MouseAdapter() {

		});
		kayitButonu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		kayitButonu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kayit = new Kayit(layeredPane, panel);
				layeredPane.removeAll();
				layeredPane.add(kayit.getPanel());
				layeredPane.repaint();
				layeredPane.revalidate();
				
				/*if() {
					layeredPane.removeAll();
					layeredPane.add(panel);
					layeredPane.repaint();
					layeredPane.revalidate();					
				}*/
			}
		});
		kayitButonu.setBounds(296, 317, 95, 23);
		panel.add(kayitButonu);
		
		JLabel lblNewLabel = new JLabel("GIRIS");
		
		lblNewLabel.setForeground(new Color(47, 79, 79));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(180, 145, 210, 47);
		panel.add(lblNewLabel);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Kullanýcý Adý :");
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/user3.png")));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(62, 256, 119, 20);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Sifre :");
		lblNewLabel_2.setIcon(new ImageIcon(Login.class.getResource("/Lock22.jpg")));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(62, 290, 119, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Rolunuzu Secin :");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(62, 227, 119, 18);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(541, 128, 259, 291);
		lblNewLabel_4.setIcon(new ImageIcon(Login.class.getResource("/araba2.png")));
		panel.add(lblNewLabel_4);
		
		final JCheckBox chckbxNewCheckBox = new JCheckBox("SIFRE GOSTER");
		chckbxNewCheckBox.setBackground(new Color(255, 140, 0));

		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(chckbxNewCheckBox.isSelected()) {
					passwordField.setEchoChar((char)0);
				}else {
					passwordField.setEchoChar('*');
				}
				
			}
		});
		chckbxNewCheckBox.setBounds(397, 284, 138, 23);
		panel.add(chckbxNewCheckBox);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setForeground(new Color(0, 100, 0));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setOpaque(true);
		lblNewLabel_5.setBackground(new Color(255, 255, 255));
		lblNewLabel_5.setBounds(541, 0, 259, 524);
		panel.add(lblNewLabel_5);
		
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(191, 222, 198, 23);
		comboBox.addItem("Kullanici");
		comboBox.addItem("Admin");
		panel.add(comboBox);
				
		JButton girisButonu = new JButton("GIRIS YAP");
		girisButonu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(comboBox.getSelectedItem().toString().equalsIgnoreCase("Kullanici")) {
					database girisyap =new database();
					try {
						musteri = girisyap.giris(textField,passwordField,layeredPane);
						sepetButonu.setVisible(true);
						kategoriButonu.setVisible(true);
						cikisButonu.setVisible(true);
						
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					
				}
				else if(comboBox.getSelectedItem().toString().equalsIgnoreCase("Admin")){
					database girisyap1 =new database();
					try {
						girisyap1.giris1(textField,passwordField,cikisButonu,layeredPane);
						
					} catch (Exception e1) {
						e1.printStackTrace();
					}

				}
				
			}
		});
		girisButonu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		girisButonu.setBounds(191, 317, 95, 23);
		panel.add(girisButonu);
		
		
		sepetButonu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(musteri.getSepet().getOnay()==1) {
					int i=0;
					while(musteri.getSepet().getUrunler()[i] != null) {
						musteri.getSepet().getUrunler()[i] = null;
						musteri.getSepet().getUrunSayi()[i] = 0;
						i++;
						
					}
					musteri.getSepet().setOnay(0);
				}
				Sepet_panel sepet_panel = new Sepet_panel(musteri);
				layeredPane.removeAll();
				layeredPane.add(sepet_panel.getPanel());
				layeredPane.repaint();
				layeredPane.revalidate();
			
			}
		});
		
		
		
		kategoriButonu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(musteri.getSepet().getOnay()==1) {
					int i=0;
					while(musteri.getSepet().getUrunler()[i] != null) {
						musteri.getSepet().getUrunler()[i] = null;
						musteri.getSepet().getUrunSayi()[i] = 0;
						i++;
						
					}
					musteri.getSepet().setOnay(0);
				}
				kategoriler = new Kategoriler(musteri);
				layeredPane.removeAll();
				layeredPane.add(kategoriler.getLayeredPane());
				layeredPane.repaint();
				layeredPane.revalidate();
			
				
				}
		});	
		
		
		
		
		
		Label label = new Label("ONLINE MARKET SISTEMI");
		label.setAlignment(Label.CENTER);
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("Arial Unicode MS", Font.BOLD, 40));
		label.setBounds(0, 0, 789, 97);
		contentPane.add(label);

		
		
	}
	public JLayeredPane getLayeredPane() {
		return layeredPane;
	}
	public Panel getPanel() {
		return panel;
	}
}
