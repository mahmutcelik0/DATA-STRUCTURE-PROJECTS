
package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class SiparisBilgileri { //SIPARIS BILGILERI CLASSI
    //AYNI YEMEKTEN 2 TANE OLMAMASI ICIN BU CLASSTAN YEMEKLER RASTGELE OLARAK SECILIR VE YEMEKSINIFINDAN NESNE OLUSTURULUR
    //VERILERIN SAKLANMASI ICIN DIZILERE KENDI BELIRLEDIGIM FIYAT VE SAYIDA YEMEKLER VE FIYATLARINI EKLEDIM
    //AYNI SIPARISLISTESINDE 2 DEFA OLMASINI ONLEMEK ICIN GECICI 2 TANE ARRAYLIST OLUSTURDUM.
    //BU ARRAYLISTLERE DIZILER COLLECTIONS UN ADDALL METODU ILE EKLENIYOR VE 1 YEMEK SECILIP YOLLANDIGINDA ARRAYLISTTEN SILINIYOR
    
    private final String[] yemekAdlari ={"Pizza","Burger","Döner","Pide","Waffle","Çiğ Köfte","Lahmacun","Sütlaç","Kazandibi","Kabak Tatlısı","Börek","Cola","Sprite","Espresso","Ayran","Fanta","Yoğurt Çorbası"}; //KENDI BELIRLEDIGIM YEMEKLER VE FIYATLARI
    private final Integer[] yemekFiyatlari ={50,40,40,35,35,10,10,5,5,5,20,15,10,20,10,8,6};
        
    private ArrayList<YemekSinifi> siparisBilgileriListesi = new ArrayList<>(); //YEMEKLERIN TUTULACAGI ARRAYLIST
    //NOT: BURADA YANLIS ADLANDIRMA YAPMISIM KARISIKLIK OLMAMASI ICIN ACIKLAMA GEREKSINIMI DUYDUM. SIPARIS BILGILERI LISTESI PROJEDE MAHALLE NESNESININ OZELLIGI OLARAK GOZUKMEKTEDIR BURADA YAPMAM GEREKEN ADLANDIRMA siparisBilgileri olması gerekiyordu kod dogru calısıyor fakat siz incelerken yanlış anlaşılma olmasın diye bunu yazdım.
    
    
    
    public SiparisBilgileri(){  //CONSTRUCTOR
        Random r = new Random();
        
        int sayi = r.nextInt(3)+3;  //SIPARISBILGILERINDE KAC TANE YEMEK SINIFINDAN NESNE OLACAKSA RANDOM SEKILDE 3ILE 6 ARASINDA BELIRLENIR
        
        ArrayList<String> geciciYemekAdlari = new ArrayList<>();    //GECICI YEMEK ARRAYLISTLERI BURADAN SECILEN ELEMAN SONRASINDA SILINECEK
        ArrayList<Integer> geciciYemekFiyatlari = new ArrayList<>();
        
        Collections.addAll(geciciYemekAdlari, yemekAdlari); //ARRAYLISTE DIZILERIN EKLENMESI
        Collections.addAll(geciciYemekFiyatlari, yemekFiyatlari);
            
        for(int a=0 ; a<sayi ; a++){    //FOR DONGUSUYLE BELIRLENEN SAYI KADAR YEMEKSINIFI NESNESI EKLENIR
            int sayi2 = r.nextInt(geciciYemekAdlari.size());
            
            siparisBilgileriListesi.add(new YemekSinifi(geciciYemekAdlari.get(sayi2), geciciYemekFiyatlari.get(sayi2)));    //ARRAYLISTTEN ELEMAN SECILIR VE YENI NESNE OLUSTURULUP ARRAYLISTE EKLENIR
       
            geciciYemekAdlari.remove(sayi2);    //SECILEN YEMEK ARRAYLISTTEN SILINIR
            geciciYemekFiyatlari.remove(sayi2);
        }
    }

    public ArrayList<YemekSinifi> getSiparisBilgileriListesi() {    //GETTER SETTER
        return siparisBilgileriListesi;
    }

    public void setSiparisBilgileriListesi(ArrayList<YemekSinifi> siparisBilgileriListesi) {
        this.siparisBilgileriListesi = siparisBilgileriListesi;
    }
    
    public void siparisBilgileriYazdir(){   //SIPARIS BILGILERININ YAZDIRILMASI
        for(YemekSinifi yemekler : siparisBilgileriListesi){
            System.out.println(yemekler.toString() + "\n");
        }
    }
    
    public int siparisBilgileriToplamFiyat(){   //SIPARISBILGILERININ TOPLAM FIYATININ FOR EACH DONGUSUYLE ILK BASTA OLUSTURDUGUMUZ ARRAYLISTIN DOLASILIP YEMEKSINIFINDAKI TOPLAMA METODUNU KULLANARAK SIPARISBILGILERINDEKI TOPLAM FIYAT HESAPLANIR
        int toplamFiyat = 0;
        for(YemekSinifi yemekler : siparisBilgileriListesi){
            toplamFiyat += yemekler.yemekToplamFiyat();
        }
        
        return toplamFiyat;
    }
}
