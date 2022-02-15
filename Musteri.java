package Proje;

public class Musteri {
	
		private String kullanciAdi;
		private final String sifre;
		private String adres;
		private Sepet sepet;
		private double bakiye;
		
		
		public Musteri(String kullanciAdi, String sifre, String adres, double bakiye) {
			
			this.kullanciAdi = kullanciAdi;
			this.sifre = sifre;
			this.adres = adres;
			this.sepet = new Sepet();
			this.sepet.setMusteri(this);
			this.bakiye = bakiye;
		}

		public String getKullanciAdi() {
			return kullanciAdi;
		}
		public void setKullanciAdi(String kullanciAdi) {
			this.kullanciAdi = kullanciAdi;
		}
		public String getSifre() {
			return sifre;
		}
		
		public String getAdres() {
			return adres;
		}
		public void setAdres(String adres) {
			this.adres = adres;
		}
		public Sepet getSepet() {
			return sepet;
		}
		public void setSepet(Sepet sepet) {
			this.sepet = sepet;
		}
		public double getBakiye() {
			return bakiye;
		}
		public void setBakiye(double bakiye) {
			this.bakiye = bakiye;
		}
		
		public void urunEkle(Urun urun,int adet) {
			
			sepet.urunEkle(urun,adet);
		}
		public void urunCikar(Urun urun) {
		
			sepet.urunCikar(urun.getID());
		}
		public void urunDegerlendir(Urun urun,double puan) {
			
			int i=0;
			while(sepet.getUrunler()[i] != null && sepet.getUrunler()[i]!=urun)
	            i++;
			if(sepet.getUrunler()[i]==urun) {
				
				urun.setPuan((urun.getPuan()* urun.getPuanlayanSayisi()+puan)/ (urun.getPuanlayanSayisi()+1) );
				urun.setPuanlayanSayisi(urun.getPuanlayanSayisi()+1);
				
				
			}else {
				System.out.println("Urunu henuz satin almadiniz.");
			}
			
			
		}
		
}
