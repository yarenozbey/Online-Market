package Proje;

public class Urun {
	
	private int ID;
	private String ad;
	private String kategori;
	private double fiyat;
	private double puan;
	private int stok;
	private int puanlayanSayisi;

	public Urun(int iD, String ad, String kategori, double fiyat, int stok) {
		
		ID = iD;
		this.ad = ad;
		this.kategori = kategori;
		this.fiyat = fiyat;
		puan=0;
		this.stok = stok;
		this.puanlayanSayisi=0;
	}
	
/*
	public Urun(String ad, double fiyat, double puan, int stok) {
		this.ad = ad;
		this.fiyat = fiyat;
		this.puan=puan;
		this.stok = stok;
	}
*/

	public int getPuanlayanSayisi() {
		return puanlayanSayisi;
	}
	

	public void setPuanlayanSayisi(int puanlayanSayisi) {
		this.puanlayanSayisi = puanlayanSayisi;
	}


	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getKategori() {
		return kategori;
	}

	public void setKategori(String kategori) {
		this.kategori = kategori;
	}

	public double getFiyat() {
		return fiyat;
	}

	public void setFiyat(double fiyat) {
		this.fiyat = fiyat;
	}

	public double getPuan() {
		return puan;
	}

	public void setPuan(double puan) {
		this.puan = puan;
	}

	public int getStok() {
		return stok;
	}

	public void setStok(int stok) {
		this.stok = stok;
	}

	@Override
	public String toString() {
		return "Urun [ad=" + ad + ", kategori=" + kategori + ", fiyat=" + fiyat + "]";
	}
	
	

}
