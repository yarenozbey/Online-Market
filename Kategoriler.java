package Proje;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class Kategoriler extends JPanel {
	
	
	private JLayeredPane layeredPane;
	private Panel panel;
	private JButton b_sarkuteri;
	private Panel panel_detay;
	private Musteri musteri;

	public Kategoriler(Musteri musterii) {
		this.musteri = musterii;
		setLayout(null);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBackground(new Color(250, 235, 215));
		layeredPane.setBounds(0, 0, 800, 520);
		add(layeredPane);
		layeredPane.setLayout(null);		

		panel = new Panel();		
		panel.setBackground(new Color(250, 235, 215));
		panel.setBounds(0, 0, 800, 520);
		layeredPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Kategoriler");
		lblNewLabel.setBounds(46, 10, 197, 47);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 30));


		
		final JButton btnNewButton_1 = new JButton("Abur-Cubur");
		btnNewButton_1.setBounds(330, 225, 130, 21);
		btnNewButton_1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				Kategori_detay kategoriDetay = new Kategori_detay(btnNewButton_1.getLabel(),musteri);
				System.out.println(btnNewButton_1.getLabel());
				layeredPane.removeAll();
				layeredPane.add(kategoriDetay.getPanel());
				layeredPane.repaint();
				layeredPane.revalidate();
				}
		});
		
		final JButton btnNewButton_2 = new JButton("Manav");
		btnNewButton_2.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				Kategori_detay kategoriDetay = new Kategori_detay(btnNewButton_2.getLabel(),musteri);
				System.out.println(btnNewButton_2.getLabel());
				layeredPane.removeAll();
				layeredPane.add(kategoriDetay.getPanel());
				layeredPane.repaint();
				layeredPane.revalidate();				
			}
		});
		btnNewButton_2.setBounds(590, 220, 130, 21);
		
		final JButton btnNewButton_3 = new JButton("Temizlik");
		btnNewButton_3.setBounds(79, 412, 130, 21);
		btnNewButton_3.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				Kategori_detay kategoriDetay = new Kategori_detay(btnNewButton_3.getLabel(),musteri);
				System.out.println(btnNewButton_3.getLabel());
				layeredPane.removeAll();
				layeredPane.add(kategoriDetay.getPanel());
				layeredPane.repaint();
				layeredPane.revalidate();
				}
		});
		
		final JButton btnNewButton_4 = new JButton("Ki\u015Fisel Bak\u0131m");
		btnNewButton_4.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				Kategori_detay kategoriDetay = new Kategori_detay(btnNewButton_4.getLabel(),musteri);
				System.out.println(btnNewButton_4.getLabel());
				layeredPane.removeAll();
				layeredPane.add(kategoriDetay.getPanel());
				layeredPane.repaint();
				layeredPane.revalidate();
				}
		});
		btnNewButton_4.setBounds(330, 412, 130, 21);
		
		final JButton btnNewButton_5 = new JButton("K\u0131rtasiye");
		btnNewButton_5.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				Kategori_detay kategoriDetay = new Kategori_detay(btnNewButton_5.getLabel(),musteri);
				System.out.println(btnNewButton_5.getLabel());
				layeredPane.removeAll();
				layeredPane.add(kategoriDetay.getPanel());
				layeredPane.repaint();
				layeredPane.revalidate();
				}
		});
		btnNewButton_5.setBounds(590, 412, 130, 21);
		
		b_sarkuteri = new JButton("\u015Eark\u00FCteri");
		b_sarkuteri.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				Kategori_detay kategoriDetay = new Kategori_detay(b_sarkuteri.getLabel(),musteri);
				System.out.println(b_sarkuteri.getLabel());
				layeredPane.removeAll();
				layeredPane.add(kategoriDetay.getPanel());
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		b_sarkuteri.setBounds(79, 225, 130, 21);


		
		ImageIcon icon_sarkuteri = new ImageIcon(new ImageIcon(Login.class.getResource("/sarkuteri.jpg")).getImage().getScaledInstance(130, 130, Image.SCALE_DEFAULT));
		JLabel sarkuteri = new JLabel(icon_sarkuteri);
		sarkuteri.setBounds(80, 84, 130, 116);
		
		ImageIcon icon_aburcubur = new ImageIcon(new ImageIcon(Login.class.getResource("/aburcubur.jpg")).getImage().getScaledInstance(130, 130, Image.SCALE_DEFAULT));
		JLabel aburcubur = new JLabel(icon_aburcubur);
		aburcubur.setBounds(330, 84, 130, 116);
		
		ImageIcon icon_manav = new ImageIcon(new ImageIcon(Login.class.getResource("/manav.jpg")).getImage().getScaledInstance(130, 130, Image.SCALE_DEFAULT));	
		JLabel manav = new JLabel(icon_manav);
		manav.setBounds(590, 84, 130, 116);
		
		ImageIcon icon_temizlik = new ImageIcon(new ImageIcon(Login.class.getResource("/temizlik.jpg")).getImage().getScaledInstance(130, 130, Image.SCALE_DEFAULT));	
		JLabel temizlik = new JLabel(icon_temizlik);
		temizlik.setBounds(79, 283, 130, 116);
		
		ImageIcon icon_kisiselbakim = new ImageIcon(new ImageIcon(Login.class.getResource("/kisiselbakim.jpg")).getImage().getScaledInstance(130, 130, Image.SCALE_DEFAULT));	
		JLabel kisiselbakim = new JLabel(icon_kisiselbakim);
		kisiselbakim.setBounds(330, 283, 130, 116);
		
		ImageIcon icon_kirtasiye = new ImageIcon(new ImageIcon(Login.class.getResource("/kirtasiye.jpg")).getImage().getScaledInstance(130, 130, Image.SCALE_DEFAULT));
		JLabel kirtasiye = new JLabel(icon_kirtasiye);
		kirtasiye.setBounds(590, 283, 130, 116);
		panel.setLayout(null);
		panel.add(lblNewLabel);
		panel.add(btnNewButton_1);
		panel.add(btnNewButton_2);
		panel.add(btnNewButton_3);
		panel.add(btnNewButton_4);
		panel.add(btnNewButton_5);
		panel.add(b_sarkuteri);
		panel.add(sarkuteri);
		panel.add(aburcubur);
		panel.add(manav);
		panel.add(temizlik);
		panel.add(kisiselbakim);
		panel.add(kirtasiye);
		
	}

	public Musteri getMusteri() {
		return musteri;
	}

	public JLayeredPane getLayeredPane() {
		return layeredPane;
	}
}
