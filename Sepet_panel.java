package Proje;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


public class Sepet_panel extends JPanel {

	private Panel panel;
	private Musteri musteri;		
	private JTable table;
	private Urun urun;
	private DefaultTableModel tableModel;
	private JTable table_1;
	/**
	 * Create the panel.
	 */
	private JTable oneri_table;
	private JTextField toplam_fiyat;
	public Sepet_panel(final Musteri musteri) {
		this.setMusteri(musteri);

		panel = new Panel();		
		panel.setBackground(new Color(250, 235, 215));
		panel.setBounds(0, 0, 800, 520);
		add(panel);
		panel.setLayout(null);		
		

		//musteri.getSepet().sepetGoster();
		System.out.println("sepet_panel"+musteri.getKullanciAdi());
		
	
		
		Label label = new Label("SEPET");
		label.setFont(new Font("Dialog", Font.PLAIN, 36));
		label.setBounds(10, 23, 183, 69);
		panel.add(label);
		
		JButton btnNewButton = new JButton("\u00D6deme Yap");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				musteri.getSepet().setOnay(1);			
				musteri.getSepet().odemeYap();		
				System.out.println("bakiye: "+" "+musteri.getKullanciAdi()+" "+musteri.getSifre()+" "+musteri.getAdres()+" ");
				musteri.getSepet().sepetGoster();
				PrintStream stream = new PrintStream(System.out);
				stream.print(musteri.getBakiye());
				JOptionPane.showMessageDialog(null, "Ödeme iþlemi baþarýlý. Puan sayfasýna yönlendirileceksiniz.");
				Puanlama puan = new Puanlama(musteri);
				panel.removeAll();
				panel.add(puan.getPanel());
				panel.repaint();
				panel.revalidate();
				
				
			}
		});
		btnNewButton.setBounds(480, 396, 130, 40);
		panel.add(btnNewButton);
		
		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 102, 450, 360);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(250, 235, 215));
		tableModel = new DefaultTableModel() {

			   @Override
			   public boolean isCellEditable(int row, int column) {
			       //Only the third column
			       return column == 3;
			   }
			};
		Object[] column = {"Ürün", "Adet", "Fiyat"};
		Object[] row = new Object[3];
		tableModel.setColumnIdentifiers(column);
		table.setModel(tableModel);

		
		for(int i = 0;i<musteri.getSepet().getUrunCesit(); i++) {
			Urun urun = musteri.getSepet().getUrunler()[i];
			if( urun != null) {
				row[0] = urun.getAd();
				row[1] = musteri.getSepet().getUrunSayi()[i];
				row[2] = urun.getFiyat() * musteri.getSepet().getUrunSayi()[i];

				tableModel.addRow(row);
				System.out.println(urun.getAd());
			}
			
		}
		
		
		
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("\u00DCr\u00FCn \u00C7\u0131kar");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//table.getValueAt(table.getSelectedRow(), table.getSelectedColumn());
				int urun_id = musteri.getSepet().getUrunler()[table.getSelectedRow()].getID();
				System.out.println(urun_id);
				System.out.println(musteri.getSepet().getUrunSayi()[table.getSelectedRow()]);
				musteri.getSepet().urunCikar(urun_id);
				String foo = table.getValueAt(table.getSelectedRow(), 1).toString();
				int adet = (int) Double.parseDouble(foo);
				if( adet != 1) {
					adet = adet-1;
					table.setValueAt(adet,table.getSelectedRow(), 1);
				}
				else {
					tableModel.removeRow(table.getSelectedRow());
					//musteri.getSepet().getUrunler()[table.getSelectedColumn()]
				}
			}
		});
		btnNewButton_1.setBounds(480, 348, 130, 40);
		panel.add(btnNewButton_1);
		
		//Ürünler dizisi veritabanýndan çekilecek
		
		//Random rnd = new Random();
		//int sayi = rnd.nextInt(3);
		//final Urun urun1 = musteri.getSepet().getUrunler()[sayi];
		Urun urun123 =new Urun(178,"ayva","Manav",8,100);
		urun123.setPuan(4.2);
		urun123.setPuanlayanSayisi(34);
		oneri_table = new JTable();
		//oneri.setBackground(new Color(245, 245, 245));
		oneri_table.setFont(new Font("Tahoma", Font.BOLD, 14));
		oneri_table.setModel(new DefaultTableModel(
			new Object[][] {
				{"\u00DCr\u00FCn", "Fiyat", "Puan"},
				{urun123.getAd(), urun123.getFiyat(), urun123.getPuan()}, //Urünler dizisinden random ürün bilgileri
			},
			new String[] {
				"New column", "New column", "New column"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		oneri_table.getColumnModel().getColumn(0).setResizable(false);
		oneri_table.getColumnModel().getColumn(1).setResizable(false);
		oneri_table.getColumnModel().getColumn(2).setResizable(false);
		oneri_table.setBounds(519, 145, 243, 32);
		panel.add(oneri_table);
		
		Label label_1 = new Label("Bu \u00FCr\u00FCn ilginizi \u00E7ekebilir:");
		label_1.setFont(new Font("Dialog", Font.BOLD, 15));
		label_1.setBounds(519, 102, 243, 26);
		panel.add(label_1);
		
		toplam_fiyat = new JTextField();
        toplam_fiyat.setText("Sepetin toplam fiyatý: " + musteri.getSepet().mevcutFiyat());
        toplam_fiyat.setBounds(620, 396, 142, 40);
        panel.add(toplam_fiyat);
        toplam_fiyat.setColumns(10);
		JButton oneri_butonu = new JButton("Sepete ekle");
		
		oneri_butonu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				database detay1 =new database();
				try {
					detay1.obje(urun123.getAd(),musteri,1);
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				Object[] row = new Object[3];
                row[0] = urun123.getAd();
                row[1] = 1;
                row[2] = urun123.getFiyat();

                tableModel.addRow(row);
				scrollPane.setViewportView(table);
				toplam_fiyat.setText("Sepetin toplam fiyatý: " + musteri.getSepet().mevcutFiyat());

			}
		});
		oneri_butonu.setFont(new Font("Tahoma", Font.PLAIN, 11));
		oneri_butonu.setBounds(594, 187, 100, 30);
		panel.add(oneri_butonu);
		


	}

	public Panel getPanel() {
		return panel;
	}

	public Musteri getMusteri() {
		// TODO Auto-generated method stub
		return this.musteri;
	}

	public void setMusteri(Musteri musteri) {
		this.musteri = musteri;
	}
}
