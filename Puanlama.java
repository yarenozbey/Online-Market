package Proje;

import java.awt.Color;
import java.awt.Panel;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Label;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Puanlama extends JPanel {

	private Panel panel;
	private JTable table;
	private DefaultTableModel tableModel;


	public Puanlama(final Musteri musteri) {

		panel = new Panel();		
		panel.setBackground(new Color(47, 79, 79));
		panel.setBounds(0, 0, 800, 520);
		add(panel);
		panel.setLayout(null);
		
		Label label = new Label("\u00DCr\u00FCnleri de\u011Ferlendirmek ister misiniz?");
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("Arial", Font.PLAIN, 30));
		label.setBounds(23, 10, 649, 61);
		panel.add(label);
		
		Label label_1 = new Label("\u00DCr\u00FCnlere 1-5 aras\u0131 puan verebilirsiniz.");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Arial", Font.PLAIN, 15));
		label_1.setBounds(23, 75, 549, 21);
		panel.add(label_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 102, 300, 350);
		panel.add(scrollPane);		
		
/*		table = new JTable();
		DefaultTableModel tableModel = new DefaultTableModel(
				new Object[][] {
					{"\u00DCr\u00FCn", "Puan\u0131n\u0131z"},
				},
				new String[] {
					"New column", "New column"
				}
			);
		table.setModel(tableModel);*/
		
		table = new JTable();
		//table.setBackground(new Color(250, 235, 215));
		tableModel = new DefaultTableModel();
		Object[] column = {"Ürün", "Puanınız"};
		Object[] row = new Object[2];
		tableModel.setColumnIdentifiers(column);
		table.setModel(tableModel);

		
		int i = 0;
		
		while(musteri.getSepet().getUrunler()[i] != null) {
			row[0] = musteri.getSepet().getUrunler()[i].getAd();
			row[1] = " ";
			tableModel.addRow(row);
			i++;
		}

		scrollPane.setViewportView(table);	
		table.setBounds(67, 115, 275, 350);
		
		Button button = new Button("Puan ver");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = 0;
				while(musteri.getSepet().getUrunler()[i] != null) {
					String puan_ = tableModel.getValueAt(i, 1).toString();
					if(!puan_.equalsIgnoreCase(" ")) {
						double puan = Double.parseDouble(puan_);
						if(puan>0 && puan<=5) {
							//System.out.println("önce"+musteri.getSepet().getUrunler()[i].getPuan());
							musteri.urunDegerlendir(musteri.getSepet().getUrunler()[i], puan);
							database puan1 =new database();
							try {
								puan1.puanver(musteri.getSepet().getUrunler()[i]);
								
							} catch (Exception e1) {
								e1.printStackTrace();
							}
							System.out.println("\nsonra: " + musteri.getSepet().getUrunler()[i].getPuan());					
								
						}					
					}
					
					i++;
				}	
            	JOptionPane.showMessageDialog(null, "Puan verdiğiniz için teşekkür ederiz. Anasayfaya yönlendirileceksiniz.");
            	if(musteri.getSepet().getOnay()==1) {
					i=0;
					while(musteri.getSepet().getUrunler()[i] != null) {
						musteri.getSepet().getUrunler()[i] = null;
						musteri.getSepet().getUrunSayi()[i] = 0;
						i++;
						
					}
					musteri.getSepet().setOnay(0);
				}
            	Kategoriler kategoriler = new Kategoriler(musteri);
            	panel.removeAll();
				panel.add(kategoriler.getLayeredPane());
				panel.repaint();
				panel.revalidate();

				
			}
		});
		button.setBounds(362, 344, 133, 44);
		panel.add(button);

		
	}
	public Panel getPanel() {
		return panel;
	}
}
