package Proje;

public class Siparis {
	
		private Sepet sepet;
		private int siparisID;
		private static int count;
		private Musteri musteri;
		
		public Siparis(Sepet sepet,Musteri musteri) {
			this.sepet = sepet;
			this.siparisID = count++;
			this.musteri=musteri;
			
		}
		public Sepet getSepet() {
			return sepet;
		}
		public void setSepet(Sepet sepet) {
			this.sepet = sepet;
		}
		public int getSiparisID() {
			return siparisID;
		}
		public void setSiparisID(int siparisID) {
			this.siparisID = siparisID;
		}
		
		
		
		

}
