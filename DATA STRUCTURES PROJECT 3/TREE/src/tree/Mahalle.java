
package tree;

import java.util.ArrayList;
import java.util.Random;


public class Mahalle {  //MAHALLE NESNELERININ OLUSTURULACAGI CLASS
    
    private String mahalleAdi;  //MAHALLE CLASSININ 2 OZELLIGI VAR 1 MAHALLE ADI IKINCI OLARAK SIPARIS BILGILERININ TUTULACAGI SIPARISLER LISTESI
    private ArrayList<SiparisBilgileri> siparislerListesi = new ArrayList<>();  //SIPARISBILGILERINI TUTMAK ICIN ARRAYLIST KULLANDIM
    
    public Mahalle(String mahalleAdi){  //CONSTRUCTOR
        this.mahalleAdi = mahalleAdi;
        
        Random r = new Random();    //5 ILE 11 ARASI RANDOM SAYI OLUSTURMAK ICIN RANDOM KULLANILACAK
        int sayi = r.nextInt(6)+5;
        
        for(int a=0 ; a<sayi ; a++){    //RANDOM OLUSAN SAYI KADAR DONECEK FOR DONGUSUYLE SIPARISLISTESI ARRAYLISTINE SIPARISBILGILERINDEN NESNE OLUSTURULUP ADD METODU ILE EKLENIR
            siparislerListesi.add(new SiparisBilgileri());
        }
        
    }

    public String getMahalleAdi() { //GETTER SETTER
        return mahalleAdi;
    }

    public void setMahalleAdi(String mahalleAdi) {
        this.mahalleAdi = mahalleAdi;
    }

    public ArrayList<SiparisBilgileri> getSiparislerListesi() {
        return siparislerListesi;
    }

    public void setSiparislerListesi(ArrayList<SiparisBilgileri> siparislerListesi) {
        this.siparislerListesi = siparislerListesi;
    }
    
    public void mahalleBilgiYazdir(){   //MAHALLE BILGILERININ YAZDIRILMASI MAHALLE ADI VE FOR EACH DONGUSU ILE SIPARISBILGILERILISTERI ARRAYLISTI DOLASILARAK YAZDIRMA GERCEKLESIR
        System.out.println("Mahalle Adi: "+ mahalleAdi + "\n");
        
        
        int siparisIndex =1;
        for(SiparisBilgileri siparis : siparislerListesi){
            System.out.println(siparisIndex+". sipariş: ");
            siparis.siparisBilgileriYazdir();
            siparisIndex++;
        }
        
        
    }
    
    
}
