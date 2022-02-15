package Proje;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Satici_panel extends JPanel {
	private JPanel ekle_panel;
	private JTextField urunID;
	private JTextField urunAdi;
	private JTextField urunFiyat;
	private JTextField urunAdet;
	private JTextField urunKategori;
	private JTable table;
	private JPanel ekle_panel_1;
	private JComboBox<String> comboBox;

	public Satici_panel() {
		setLayout(null);

		ekle_panel_1 = new JPanel();
		ekle_panel_1.setBackground(new Color(244, 164, 96));
		ekle_panel_1.setBounds(0, 0, 800, 520);
		add(ekle_panel_1, "panel");
		ekle_panel_1.setLayout(null);
		
		
		JLabel lblNewLabel_3 = new JLabel("�r�n Ekleme");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(39, 10, 184, 44);
		ekle_panel_1.add(lblNewLabel_3);
		

		JLabel lblNewLabel_9 = new JLabel("Kategori");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_9.setBounds(43, 69, 74, 24);
		ekle_panel_1.add(lblNewLabel_9);
		
		JLabel lblNewLabel_4 = new JLabel("�r�n ad�");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(43, 168, 89, 24);
		ekle_panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Fiyat");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(43, 220, 54, 16);
		ekle_panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Adet");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(43, 271, 54, 16);
		ekle_panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("�r�n ID");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(43, 122, 74, 16);
		ekle_panel_1.add(lblNewLabel_7);
		
		urunID = new JTextField();
		urunID.setBounds(127, 123, 96, 19);
		ekle_panel_1.add(urunID);
		urunID.setColumns(10);
		
		urunAdi = new JTextField();
		urunAdi.setBounds(127, 173, 96, 19);
		ekle_panel_1.add(urunAdi);
		urunAdi.setColumns(10);
		
		urunFiyat = new JTextField();
		urunFiyat.setBounds(127, 221, 96, 19);
		ekle_panel_1.add(urunFiyat);
		urunFiyat.setColumns(10);
		
		urunAdet = new JTextField();
		urunAdet.setBounds(127, 272, 96, 19);
		ekle_panel_1.add(urunAdet);
		urunAdet.setColumns(10);
		
		comboBox = new JComboBox<String>();
        comboBox.setBounds(127, 74, 96, 19);
        comboBox.addItem("�ark�teri");
        comboBox.addItem("Abur-Cubur");
        comboBox.addItem("Manav");
        comboBox.addItem("Temizlik");
        comboBox.addItem("Ki�isel-Bak�m");
        comboBox.addItem("K�rtasiye");

        ekle_panel_1.add(comboBox);
		
		//�R�N EKLEME
		
		table = new JTable();
		table.setBackground(new Color(245, 245, 245));
		table.setFont(new Font("Tahoma", Font.BOLD, 13));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"KATEGOR\u0130", "\u00DCR\u00DCN ID", "\u00DCR\u00DCN ADI", "F\u0130YAT", "ADET"},
			},
			new String[] {
				"tKat", "tID", "tAd", "tFiyat", "tAdet"
			}
		));
		table.setBounds(289, 69, 409, 218);
		ekle_panel_1.add(table);
		
		JButton eklebtn = new JButton("EKLE");
		eklebtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		eklebtn.setBounds(39, 339, 100, 44);
		ekle_panel_1.add(eklebtn);
		eklebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					if(urunID.getText().equals("") || urunAdi.getText().equals("") || urunFiyat.getText().equals("") || urunAdet.getText().equals("") || comboBox.getSelectedItem().toString().equals("")) {
						JOptionPane.showMessageDialog(null, "L�tfen bilgileri eksiksiz giriniz!!");
					}
					else {
						String urunDizi[] = {comboBox.getSelectedItem().toString(), urunID.getText(), urunAdi.getText(), urunFiyat.getText(), urunAdet.getText()};
						
						DefaultTableModel tblModel = (DefaultTableModel)table.getModel();
						tblModel.addRow(urunDizi);
								
						JOptionPane.showMessageDialog(null, "�r�n ba�ar�yla eklendi.");
						
						urunID.setText("");
						urunAdi.setText("");
						urunFiyat.setText("");
						urunAdet.setText("");
						database urunek =new database();
						try {
							urunek.urunekle(Integer.parseInt(urunDizi[1]),urunDizi[2],urunDizi[0],Double.parseDouble(urunDizi[3]),Integer.parseInt(urunDizi[4]));
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					
				}
					
					
			}
		});
			
		JButton silbtn = new JButton("�IKAR");
		silbtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		silbtn.setBounds(149, 339, 100, 44);
		ekle_panel_1.add(silbtn);
		silbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tblModel = (DefaultTableModel)table.getModel();
				
				if(table.getSelectedRowCount() == 1) {
					database uruns =new database();
					int i=Integer.parseInt(tblModel.getValueAt(table.getSelectedRow(), 1).toString());
					try {
						uruns.urunsil(i);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					tblModel.removeRow(table.getSelectedRow());
					JOptionPane.showMessageDialog(null, "�r�n marketten kald�r�ld�.");
					
					
				}
				else {
					if(table.getSelectedRowCount() == 0) {
						JOptionPane.showMessageDialog(null, "Markette �r�n bulunmamakta.");
					}else {
						JOptionPane.showMessageDialog(null, "L�tfen kald�r�lacak �r�n� se�iniz.");
					}
				}
			}
		});
		
		
		
		JButton guncellebtn = new JButton("G�NCELLE");
		guncellebtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		guncellebtn.setBounds(259, 339, 111, 44);
		ekle_panel_1.add(guncellebtn);
		guncellebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tblModel = (DefaultTableModel)table.getModel();
				
				if(table.getSelectedRowCount() == 1) {
					
					String tKat = tblModel.getValueAt(table.getSelectedRow(), 0).toString();
					String tID = tblModel.getValueAt(table.getSelectedRow(), 1).toString();
					String tAd = tblModel.getValueAt(table.getSelectedRow(), 2).toString();
					String tFiyat = tblModel.getValueAt(table.getSelectedRow(), 3).toString();
					String tAdet = tblModel.getValueAt(table.getSelectedRow(), 4).toString();
					
					tblModel.setValueAt(tKat, table.getSelectedRow(), 0);
					tblModel.setValueAt(tID, table.getSelectedRow(), 1);
					tblModel.setValueAt(tAd, table.getSelectedRow(), 2);
					tblModel.setValueAt(tFiyat, table.getSelectedRow(), 3);
					tblModel.setValueAt(tAdet, table.getSelectedRow(), 4);
					
					JOptionPane.showMessageDialog(null, "�r�n g�ncellendi.");
					database urungun =new database();
					try {
						urungun.urunupdate(Integer.parseInt(tID),tAd,tKat,Double.parseDouble(tFiyat),Integer.parseInt(tAdet));
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					
				}
				else {
					if(table.getSelectedRowCount() == 0) {
						JOptionPane.showMessageDialog(null, "Markette �r�n bulunmamakta.");
					}else {
						JOptionPane.showMessageDialog(null, "G�ncellenecek �r�n� se�iniz.");
					}
				}
				
			}
		});
	}
	

	public JPanel getEkle_panel() {
		return ekle_panel_1;
	}
}
