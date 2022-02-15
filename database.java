package Proje;

import java.awt.TextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class database {
	public void kayityap (String Ad, String sifre,String Adres )throws Exception {
		String url ="jdbc:mysql://localhost:3306/online";
		String username ="root";
		String password="ytüytüytü";
		
		 try {
			Connection connection = DriverManager.getConnection(url,username,password);
			String sql="INSERT INTO musteri(kullaniciAdi,SIFRE,adres,bakiye) VALUES (?,?,?,?)";
			 PreparedStatement statement =connection.prepareStatement(sql);
			 statement.setString(1,Ad);
			 statement.setString(2,sifre);
			 statement.setString(3,Adres);
			 statement.setInt(4,200);
			 int rows =statement.executeUpdate();
			 if (rows >0) {
				 System.out.println("oldu");
			 }
			 else {
				 System.out.println("olmadý");
				 
			 }
			
		} catch (SQLException e) {
			System.out.println("Oops,error!");
			e.printStackTrace();
		}

	}
	
	public void urunekle(int ID,String Ad, String kategori, double fiyat,int stok)throws Exception {
		String url ="jdbc:mysql://localhost:3306/online";
		String username ="root";
		String password="ytüytüytü";
		
		 try {
			 Connection connection = DriverManager.getConnection(url,username,password);
			 String sql="INSERT INTO urun(ID,ad,kategori,fiyat,puan,stok,puanlayansayisi) VALUES (?,?,?,?,?,?,?)";
			 PreparedStatement statement =connection.prepareStatement(sql);
			 statement.setString(1,String.valueOf(ID));
			 statement.setString(2,Ad);
			 statement.setString(3,kategori);
			 statement.setDouble(4,fiyat);
			 statement.setDouble(5,0);
			 statement.setInt(6,stok);
			 statement.setInt(7,0);
			 int rows =statement.executeUpdate();
				 if (rows >0) {
					 System.out.println("oldu");
				 }
				 else {
					 System.out.println("olmadý");
					 
				 }
			
			
		} catch (SQLException e) {
			System.out.println("Oops,error!");
			e.printStackTrace();
		}

		
	}


public void urunupdate(int ID,String Ad, String kategori, double fiyat,int stok)throws Exception {
	String url ="jdbc:mysql://localhost:3306/online";
	String username ="root";
	String password="ytüytüytü";
	
	 try {
		 Connection connection = DriverManager.getConnection(url,username,password);
		 String sql="UPDATE urun SET ad=?,kategori=?,fiyat=?, stok=? WHERE ID=?";
		 PreparedStatement statement =connection.prepareStatement(sql);
		 statement.setString(1,Ad);
		 statement.setString(2,kategori);
		 statement.setDouble(3,fiyat);
		 statement.setInt(4,stok);
		 statement.setString(5,String.valueOf(ID));
		 int rows =statement.executeUpdate();
			 if (rows >0) {
				 System.out.println("oldu");
			 }
			 else {
				 System.out.println("olmadý");
				 
			 }
		
		
	} catch (SQLException e) {
		System.out.println("Oops,error!");
		e.printStackTrace();
	}

	
}


public void urunsil(int ID)throws Exception {
	String url ="jdbc:mysql://localhost:3306/online";
	String username ="root";
	String password="ytüytüytü";
	
	 try {
		 Connection connection = DriverManager.getConnection(url,username,password);
		 String sql="DELETE FROM urun WHERE id=? ";
		 PreparedStatement statement =connection.prepareStatement(sql);
		 statement.setString(1,String.valueOf(ID));
		 int rows =statement.executeUpdate();
			 if (rows >0) {
				 System.out.println("oldu");
			 }
			 else {
				 System.out.println("olmadý");
				 
			 }
		
		
	} catch (SQLException e) {
		System.out.println("Oops,error!");
		e.printStackTrace();
	}

	
}


public void kategoriliste(DefaultTableModel model,String kategori )throws Exception {
	String url ="jdbc:mysql://localhost:3306/online";
	String username ="root";
	String password="ytüytüytü";
	
	 try {
		 Connection connection = DriverManager.getConnection(url,username,password);
		 PreparedStatement ps = connection.prepareStatement("SELECT *FROM urun WHERE kategori=?");
		 ps.setString(1,kategori);
		 ResultSet rs = ps.executeQuery();
		 while(rs.next()) {
			 model.addRow(new Object[] {rs.getString(2),rs.getString(4),rs.getString(5)});
			 
		 }
		 connection.close();
		
		
	} catch (SQLException e) {
		System.out.println("Oops,error!");
		e.printStackTrace();
	}

	
}


public void obje(String ad, Musteri musteri,int adet)throws Exception {
	String url ="jdbc:mysql://localhost:3306/online";
	String username ="root";
	String password="ytüytüytü";
	
	
	 try {
		 Connection connection = DriverManager.getConnection(url,username,password);
		 PreparedStatement ps = connection.prepareStatement("SELECT *FROM urun WHERE ad=?");
		 ps.setString(1,ad);
		 ResultSet rs = ps.executeQuery();
		 while(rs.next()) {
			 Urun urun =new Urun(Integer.parseInt(rs.getString(1)),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getInt(6));
			 PreparedStatement ps1 = connection.prepareStatement("SELECT *FROM urun WHERE ID=?");
			 ps1.setString(1,String.valueOf(urun.getID()));
			 ResultSet rs1 = ps1.executeQuery();
			 while(rs1.next()) {
				urun.setPuan(rs1.getDouble(5));
				urun.setPuanlayanSayisi(rs1.getInt(7));
				 
			 }
			
			 musteri.getSepet().urunEkle(urun, adet);
			 if(urun.getStok()<adet) {
				 JOptionPane.showMessageDialog(null,"Stokta yeterli urun yok!!");
			 }
			 else {
	            JOptionPane.showMessageDialog(null, "Sepete " + adet + " adet " + urun.getAd()+ " eklendi");

			 }
			 
		 }
		 connection.close();
		
		
	}  catch (SQLException e) {
		System.out.println("Oops,error!");
		e.printStackTrace();
	}
	
 }

public void odemeyap(Musteri musteri,Urun urun)throws Exception {
	String url ="jdbc:mysql://localhost:3306/online";
	String username ="root";
	String password="ytüytüytü";
	
	 try {
		 Connection connection = DriverManager.getConnection(url,username,password);
		 String sql="UPDATE musteri SET bakiye=? WHERE kullaniciAdi=?";
		 PreparedStatement statement =connection.prepareStatement(sql);
		 statement.setDouble(1,musteri.getBakiye());
		 statement.setString(2,musteri.getKullanciAdi());
		 int rows =statement.executeUpdate();
		 sql="UPDATE urun SET stok=? WHERE ID=?";
		 statement =connection.prepareStatement(sql);
		 statement.setInt(1,urun.getStok());
		 statement.setString(2,String.valueOf(urun.getID()));
		 rows =statement.executeUpdate();
		
		
	} catch (SQLException e) {
		System.out.println("Oops,error!");
		e.printStackTrace();
	}
	 
	 

	
}

public void puanver(Urun urun)throws Exception {
	String url ="jdbc:mysql://localhost:3306/online";
	String username ="root";
	String password="ytüytüytü";
	
	 try {
		 Connection connection = DriverManager.getConnection(url,username,password);
		 String sql="UPDATE urun SET puan=?,puanlayanSayisi=? WHERE ID=?";
		 PreparedStatement statement =connection.prepareStatement(sql);
		 statement.setDouble(1,urun.getPuan());
		 statement.setInt(2,urun.getPuanlayanSayisi());
		 statement.setString(3,String.valueOf(urun.getID()));
		 int rows =statement.executeUpdate();
		
		 
		
		
		
	} catch (SQLException e) {
		System.out.println("Oops,error!");
		e.printStackTrace();
	}
	 
	 

	
}

public Musteri giris(JTextField textField,JPasswordField passwordField,JLayeredPane layeredPane)throws Exception {
	String url ="jdbc:mysql://localhost:3306/online";
	String username ="root";
	String password="ytüytüytü";
	
	 try {
		 Connection connection = DriverManager.getConnection(url,username,password);
		 PreparedStatement ps = connection.prepareStatement("SELECT *FROM musteri WHERE kullaniciAdi=? AND SIFRE=?");
		 ps.setString(1,textField.getText());
		 ps.setString(2,passwordField.getText());
		 ResultSet rs = ps.executeQuery();
		 if(!rs.next()) {
			 JOptionPane.showMessageDialog(null, "Hata! Kullanýcý adý veya þifre hatalý.") ;
			 textField.setText("");
			 passwordField.setText("");
			 return null;
			 }
		 else {
			 Musteri m=new Musteri(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDouble(4));
			
			
			  Kategoriler kategoriler = new Kategoriler(m);
			  layeredPane.removeAll();
			  layeredPane.add(kategoriler.getLayeredPane());
			  layeredPane.repaint();
			  layeredPane.revalidate();
			  connection.close();		

			  return m;
			 
		 }
		
	} catch (SQLException e) {
		System.out.println("Oops,error!");
		e.printStackTrace();
	}
	return null;
	 
	
}

public void giris1(JTextField textField,JPasswordField passwordField,JButton cikisButonu,JLayeredPane layeredPane)throws Exception {
	String url ="jdbc:mysql://localhost:3306/online";
	String username ="root";
	String password="ytüytüytü";
	
	 try {
		 Connection connection = DriverManager.getConnection(url,username,password);
		 PreparedStatement ps = connection.prepareStatement("SELECT *FROM satici WHERE kullaniciAdi=? AND sifre=?");
		 ps.setString(1,textField.getText());
		 ps.setString(2,passwordField.getText());
		 ResultSet rs = ps.executeQuery();
		 if(!rs.next()) {
			 JOptionPane.showMessageDialog(null, "Hata! Kullanýcý adý veya þifre hatalý.") ;
			 textField.setText("");
			 passwordField.setText("");
			 }
		 else {
			  Satici_panel panel = new Satici_panel();
			  layeredPane.removeAll();
			  layeredPane.add(panel.getEkle_panel());
			  layeredPane.repaint();
			  layeredPane.revalidate();
			  cikisButonu.setVisible(true);
			 
		 }
		 connection.close();
		
		
	} catch (SQLException e) {
		System.out.println("Oops,error!");
		e.printStackTrace();
	}
	 
	
}


}


