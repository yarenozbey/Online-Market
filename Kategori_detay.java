package Proje;

import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import java.awt.Label;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.ScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Kategori_detay extends JPanel {

	private Panel panel;
	private JTable table;
	private DefaultTableModel tableModel;
	private Urun[] urunler;

	/**
	 * Create the panel.
	 */
	public Kategori_detay(String kategori, final Musteri musteri) {
		
		panel = new Panel();		
		panel.setBackground(new Color(250, 235, 215));
		panel.setBounds(0, 0, 800, 520);
		add(panel);
		panel.setLayout(null);
		
		Label label = new Label(kategori);
		label.setBounds(46, 10, 197, 47);
		label.setAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Calibri", Font.PLAIN, 30));
		panel.add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(46, 102, 524, 360);
		panel.add(scrollPane);
	
		table = new JTable();
		//table.setBackground(new Color(250, 235, 215));
		tableModel = new DefaultTableModel() {

			   @Override
			   public boolean isCellEditable(int row, int column) {
			       //Only the third column
			       return column == 3;
			   }
			};
		Object[] column = {"Ürün", "Fiyat", "Puan"};
		Object[] row = new Object[3];
		tableModel.setColumnIdentifiers(column);
		table.setModel(tableModel);
		database liste =new database();
		try {
			liste.kategoriliste(tableModel,kategori);
		} catch (Exception e1) {
			e1.printStackTrace();
		}


		
	/*	for(int i = 0;i<urunler.length; i++) {
				row[0] = urunler[i].getAd();
				row[1] = urunler[i].getFiyat();
				row[2] = urunler[i].getPuan();
				tableModel.addRow(row);
				System.out.println( urunler[i].getAd());
			}
*/
		//panel.add(table);
		scrollPane.setViewportView(table);	
		
		
		
		JButton sepete_ekle = new JButton("<html>Seçilen ürünü<br />sepete ekle</html>");
	    //final JLabel label2 = new JLabel();
		sepete_ekle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String urun_adi = tableModel.getValueAt(table.getSelectedRow(), 0).toString();
				String result = (String)JOptionPane.showInputDialog(
			               panel,
			               "Sepetinize eklemek istediðiniz " + tableModel.getValueAt(table.getSelectedRow(), 0).toString()+ " Sayisi", 
			               "Sepete Ekle",            
			               JOptionPane.PLAIN_MESSAGE,
			               null,            
			               null, 
			               ""
			            );
						int adet = (int) Double.parseDouble(result);
			            if(adet != 0 ){
			            	database detay =new database();
							try {
								detay.obje(urun_adi,musteri,adet);
								
							} catch (Exception e1) {
								e1.printStackTrace();
							}
			            
			            }		}
		});
		sepete_ekle.setFont(new Font("Tahoma", Font.PLAIN, 13));
		sepete_ekle.setBounds(580, 412, 130, 50);
		panel.add(sepete_ekle);
		
		
	}
	public Panel getPanel() {
		return panel;
	}
}
