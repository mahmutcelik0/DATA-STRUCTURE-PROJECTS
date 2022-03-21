
package tree;

import java.util.Random;

public class YemekSinifi {  //YEMEKSINIFI CLASSI AGACTAKI EN KUCUK BIRIMIN OLUSTURUŞACAGI CLASS
    
    private String yemekAdi;    //YEMEKADI SIPARIS ADEDI VE BIRIM FIYATI OZELLIKLERI BULUNUYOR
    private int yemekSiparisAdedi;
    private int yemekBirimFiyati;
    
    public YemekSinifi(String yemekAdi , int yemekBirimFiyati){ //CONSTRUCTORDA YEMEKADI VE BIRIM FIYATI GELIYOR AYNI YEMEKTEN 1 SIPARISTE 2 DEFA OLMAMASI ICIN BOYLE YAPTIM YEMEKSIPARISADEDI DE 1LE 8 ARASI RANDOM SAYI SECILIYOR
        Random r = new Random();
        
        this.yemekAdi = yemekAdi;
        this.yemekSiparisAdedi = r.nextInt(8)+1;
        this.yemekBirimFiyati = yemekBirimFiyati;
        
    }

    public String getYemekAdi() {   //GETTER VE SETTERLAR
        return yemekAdi;
    }

    public void setYemekAdi(String yemekAdi) {
        this.yemekAdi = yemekAdi;
    }

    public int getYemekSiparisAdedi() {
        return yemekSiparisAdedi;
    }

    public void setYemekSiparisAdedi(int yemekSiparisAdedi) {
        this.yemekSiparisAdedi = yemekSiparisAdedi;
    }

    public int getYemekBirimFiyati() {
        return yemekBirimFiyati;
    }

    public void setYemekBirimFiyati(int yemekBirimFiyati) {
        this.yemekBirimFiyati = yemekBirimFiyati;
    }
    
    public int yemekToplamFiyat(){  //1 YEMEK NESNESININ TOPLAM FIYATINI HESAPLAYAN METOD ORNEK VERECEK OLURSAK SALATA ADET 5TL VE SIPARIS ADEDI 4 TANE 20TL YI HESAPLAR
        return yemekSiparisAdedi*yemekBirimFiyati;
    }
    
    @Override
    public String toString(){   //YEMEKSINIFININ TOSTRING METODU
        return "Yemek ADI: "+ yemekAdi +"\n"+
                "Sipariş Adedi: " + yemekSiparisAdedi + "\n"+
                "Birim Fiyatı: " + yemekBirimFiyati + "TL";
    }
}
