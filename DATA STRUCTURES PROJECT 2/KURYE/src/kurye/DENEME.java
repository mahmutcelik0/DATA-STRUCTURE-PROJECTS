
package kurye;

import java.util.ArrayList;

public class DENEME {   //SORU 1.B ICIN YAZILMIS CLASS  ** ARRAYLIST OLUSTURULUYOR VE ORNEKTE VERILEN MAHALLE VE TESLIMAT SAYILARI VEYA HERHANGI MAHALLE SAYISI KADAR ICINE MAHALLE NESNESI EKLENIYOR VE ISTENENLERI GERCEKLESTIRIYOR

    static final String[] MahalleAdi = {"Özkanlar", "Evka 3", "Atatürk", "Erzene", "Kazımdirik", "Mevlana","Doğanlar", "Ergene" };  //VERILEN ORNEK MAHALLELER
    static final int[] TeslimatSayisi = {5,2,7,2,7,3,0,1};  //VERILEN ORNEK TESLIMAT SAYILARI
    
    public static void main(String[] args) {    //MAIN METODU
        
        ArrayList<Mahalle> MotoKurye = new ArrayList<>();   //ARRAYLIST OLUSTURULMASI
        
        for(int a = 0 ; a<MahalleAdi.length;a++){   //MAHALLENIN UZUNLUGU KADAR DONECEK BIR FOR DONGUSU HER BIR DONMEDE SIRAYLA MAHALLE ADI VE TESLIMAT SAYISI DIZIDEN ALINIR VE ARRAYLISTE YENI MAHALLE NESNESI OLUSTURULARAK EKLENIR
            MotoKurye.add(new Mahalle(MahalleAdi[a],TeslimatSayisi[a]));
            
        }
        

        bilesikVeriYapisindakiElemanlarinYazdirilmasi(MotoKurye);   //VERI YAPISININ YAZDIRILMASI 1.C ICIN GEREKLI
        elemanSayisi(MotoKurye);    //ELEMAN SAYISININ YAZDIRILMASI 1.C ICIN GEREKLI
        toplamTeslimatSayisi(MotoKurye);    //TOPLAM YAPILAN TESLIMAT SAYISININ YAZDIRILMASI 1.C ICIN GEREKLI
  
    }
    
    public static void bilesikVeriYapisindakiElemanlarinYazdirilmasi(ArrayList<Mahalle> MotoKurye){ //MOTOKURYE ARRAYLISTI FOREACH DONGUSUYLE DOLASILIR VE HER ELEMAN MAHALLE CLASSINDAKI TO STRING METODU KULLANILARAK YAZDIRILIR
        for(Mahalle kuryeMahallesi: MotoKurye){
            System.out.println(kuryeMahallesi.toString());
            
        }
    }
    
    public static void elemanSayisi(ArrayList<Mahalle> MotoKurye){  //ELEMAN SAYISI MOTOKURYE ARRAYLISTINDE SIZE A ESIT OLUR
        System.out.println("\nDinamik Dizide Bulunan Eleman Sayisi: " +MotoKurye.size());

    }
    
    public static void toplamTeslimatSayisi(ArrayList<Mahalle> MotoKurye){  //TOPLAM TESLIMAT SAYISI ISE IKI TANE FOR EACH DONGUSU KULLANILARAK YAZDIRILIR ILKINDE ARRAYLIST DOLASILIR IKINCI FOREACH DONGUSU ISE HER MAHALLENIN ICINDEKI TESLIMAT CLASSINDAN OLUSAN NESNELERIN SAYISI ALINIR VE DEGISKENE EKLENIR
        int toplamTeslimatSayisi =0;
        for (Mahalle kuryeMahallesi : MotoKurye){
            
            for(Teslimat siparisİcerik : kuryeMahallesi.getGenericList()){
                toplamTeslimatSayisi++;
            }
        }
        
        System.out.println("Toplam Teslimat Sayısı: "+toplamTeslimatSayisi);
    }
    
}
