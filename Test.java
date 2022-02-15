package Proje;

import Proje.Anasayfa;

public class Test {
	
	public static void main(String[] args) {
		
		Urun ur1= new Urun(1,"cikolata","gida",3,10);
		Urun ur2= new Urun(2,"elma","gida",2,4);
		Urun ur3= new Urun(3,"peynir","sarkuteri",25,6);
		Musteri mus1= new Musteri("yaren","12345","A mah B sokak",50);
		Musteri mus2= new Musteri("feyza","12346","A mah B sokak",100);
		mus1.urunEkle(ur1,5);
		
		mus1.urunEkle(ur1,2);
		
		mus1.urunEkle(ur2,5);
		//mus1.getSepet().sepetGoster();
		
		mus2.urunEkle(ur1,5);
		
		
		//mus1.getSepet().urunEkle(ur3,1);
		//mus1.getSepet().sepetGoster();
		/*
		System.out.println(mus1.getSepet().mevcutFiyat());
		mus1.getSepet().urunCikar(ur1);
		System.out.println("\n");
		mus1.getSepet().sepetGoster();
		System.out.println(mus1.getSepet().mevcutFiyat());
		*/
		mus1.getSepet().setOnay(1);
		//System.out.println(mus1.getBakiye());
		mus1.getSepet().odemeYap();
		//System.out.println(mus1.getBakiye());
		//System.out.println(ur1.getStok());
		//System.out.println(ur2.getStok());
		mus2.getSepet().setOnay(1);
		mus2.getSepet().odemeYap();
		mus1.urunDegerlendir(ur3,3);
		mus2.urunDegerlendir(ur1,4);
		System.out.println(ur1.getPuan());
		
		Anasayfa anasayfa = new Anasayfa();
		
	}

}
