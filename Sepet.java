package Proje;
public class Sepet {
	
	
	private Urun[] urunler;
	private int urunCesit;
	private int onay;
	private int[] urunSayi;
	private Musteri musteri;
	
	
	

	public Sepet() {
		
		this.urunler = new Urun[10];
		this.urunSayi= new int[10];
		urunCesit=0;
		onay=0;
	}
	public void setMusteri(Musteri musteri) {
		this.musteri = musteri;
	}
	public int[] getUrunSayi() {
		return urunSayi;
	}
	
	public Urun[] getUrunler() {
		return urunler;
	}
	
	public int getUrunCesit() {
		return urunCesit;
	}
	
	public int getOnay() {
		return onay;
	}
	public void setOnay(int onay){
		this.onay = onay;
	}
	
	public void urunEkle(Urun urun, int adet){
				
		int i=0;
		
		if(urunCesit<10 && urun.getStok()-adet>=0){
			
			while(urunler[i] != null && urunler[i]!=urun)
	            i++;
			
			if(urunler[i]==urun) {
				urunSayi[i]+=adet;
				
			}else {
				
				urunler[i]=urun;
				urunSayi[i]=adet;
				urunCesit++;
			}
			
		}else if(urunCesit >=10 ){
			
			System.out.println("Sepet dolu!");
		}else {
			System.out.println(urun.getAd()+" Stokta bulunmamaktadır.");
		}
		
		
	}
	public void urunCikar(int Id){
		
		int i=0;
		
		while(urunler[i].getID()!=Id && i<urunler.length) {
			i++;
		}
		
		if(urunler[i].getID()==Id) {
				
				if(urunSayi[i]==1) {
					
					int j = i;
					while(urunler[j+1] != null) {
						urunler[j] = urunler[j+1];
						urunSayi[j] = urunSayi[j+1];
						j++;
					}					
					urunler[j]=null;
					urunSayi[j]=0;
					urunCesit--;		
				}
				else
					urunSayi[i]--;
				
		}else {
			System.out.println("Urun bulunamadi");
			
			
		}

		
	}
	public double mevcutFiyat() {
		int i=0;
		double toplam=0;
		for(;i<urunler.length;i++) {
			
			if(urunler[i]!=null) {
				
				toplam+= urunler[i].getFiyat() * urunSayi[i];
				
			}
			
			
		}
		return toplam;
	}
	public void sepetGoster() {
		
		int i=0;
		for(Urun birUrun: urunler) {
			if(birUrun!=null) {
				
				System.out.println(birUrun.toString()+" "+urunSayi[i]+" tane");
				i++;
			}	
		}
		
	}
	
	public void odemeYap() {
		
		if(onay==1) {
			
			
			if(mevcutFiyat() <= musteri.getBakiye()) {
				
				musteri.setBakiye(musteri.getBakiye()-mevcutFiyat());
				int i=0;
				for(;i<urunler.length;i++) {
				
					if(urunler[i]!=null) {
						
						urunler[i].setStok(urunler[i].getStok()-urunSayi[i]);
						System.out.println(musteri.getKullanciAdi());
						database odeme =new database();
						try {
							odeme.odemeyap(musteri,urunler[i]);
							
						} catch (Exception e1) {
							e1.printStackTrace();
						}
						
					}
				
				}
				
				
				
			}else {
				System.out.println("Bakiye yetersiz!");
			}
			
			
		}else {
			System.out.println("Sepeti onaylamadiniz!");
		}
		
	}
	

}
