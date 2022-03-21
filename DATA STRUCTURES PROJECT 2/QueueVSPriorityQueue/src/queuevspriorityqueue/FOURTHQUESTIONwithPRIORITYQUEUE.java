
package queuevspriorityqueue;

import java.util.ArrayList;

public class FOURTHQUESTIONwithPRIORITYQUEUE {  //4.SORUNUN B SIKKI ICIN GEREKLI CLASS.
    static final int[] musteriSepetleri = {6,7,2,1,12,5,3,7,4,2};   //ORNEK VERILEN MUSTERI SEPETLERININ DIZISI 
    static int urunOkumaSuresi = 3; //VERILEN URUN OKUMA SURE SABITI
    
    public static void main(String[] args){ //MAIN METODU ICERISINDE PRIORITYQUEUE CLASSINDAN NESNE OLUSTURULUR VE MUSTERILER EKLENIR SONRASINDA ARTAN SEKILDE CIKARILIRLAR
        PRIORITYQUEUE priorityQueue = new PRIORITYQUEUE();  //CLASSTAN NESNE OLUSTURULMASI
        
        for(int eklenecekSayi : musteriSepetleri){  //FOREACH DONGUSU ILE MUSTERILER DOLASILARAK ENQUEUE METODU ILE PRIORITYQUEUE YAPISINA EKLENIRLER
            priorityQueue.enQueue(eklenecekSayi);
        }
        
        urunlerinOkutulmasi(priorityQueue); //URUNLERIN OKUTULMASI METODUYLA HER MUSTERININ BEKLEME SURESI VE TOPLAM BEKLEME SURESI ORTALAMASI HESAPLANILARAK YAZDIRILIR
        
    }
    
    public static void urunlerinOkutulmasi(PRIORITYQUEUE priorityQueue){    //BU METODDA TUM ELEMANLAR ARTAN SIRAYLA OLACAK SEKILDE YAPIDAN CIKARILIR VE HESAPLAMALAR YAPILIR
        int toplamMusteri =0;
        int herMusteriBeklemeSuresi =0; //GEREKLI DEGISKENLER
        int toplamIslemTamamlanmaSuresi =0;
        
        while(!priorityQueue.isEmpty()){    //PRIORITYQUEUE NESNESI BOS OLASIYA KADAR CALISACAK WHILE DONGUSU ICINDE DEQUEUE METODU ILE ELEMANLAR CIKARILIR
            toplamMusteri++;
            
            int silinecekMusteridekiToplamUrunSayisi = priorityQueue.deQueue();
            
            herMusteriBeklemeSuresi += (silinecekMusteridekiToplamUrunSayisi*urunOkumaSuresi ); //VERILEN SABIT VE MUSTERIDEKI URUN SAYISI ILE CARPILARAK MUSTERININ KENDI MALZEMELERI ICIN BEKLEME SURESI EKLENIR
            toplamIslemTamamlanmaSuresi+= herMusteriBeklemeSuresi;  //MUSTERILERIN BEKLEME SURELERI EKLENIR
            
            System.out.println(toplamMusteri+".Müşterinin işlem tamamlanma süresi: " + (herMusteriBeklemeSuresi));  //HER MUSTERININ TOPLAM BEKLEME SURESI YAZDIRILIR. KENDI URUNLERI ICIN BEKLEMESI VE ONCEKI MUSTERILERIN ISLEMLERININ TAMAMLANMASI ICIN BEKLEMESI HESAPLANMISTI

        }
        ortalamaIslemTamamlanmaYazdirilmasi(toplamIslemTamamlanmaSuresi, toplamMusteri); 
    }
    
    public static void ortalamaIslemTamamlanmaYazdirilmasi(int toplamIslemTamamlanmaSuresi, int toplamMusteri){ //TUM MUSTERILERIN BEKLEME SURELERI TOPLANIP BUNU TOPLAM MUSTERI SAYISINA BOLDUGUMUZDE ORTALAMASINI BULMUS OLURUZ
        double ortalamaIslemTamamlanmaSuresi = (toplamIslemTamamlanmaSuresi/(double)toplamMusteri);
        
        System.out.println("BU KASADAKI MUSTERILERIN ORTALAMA ISLEM TAMAMLANMA SURESI: " + ortalamaIslemTamamlanmaSuresi);
    } 
}

class PRIORITYQUEUE{    //PRIORITYQUEUE CLASSI ILE ARTAN SEKILDE CIKARILMAYI SAGLARIZ BU SEKILDE YAZILDI
    ArrayList<Integer> queueList;   //ICINDE ARRAYLIST KULLANARAK YAZDIM HEAD VE TAIL ASLINDA GEREKLI DEGIL 
    private int head;
    private int tail;
    private int elementNumber;
    
    public PRIORITYQUEUE(){ //CLASSIN CONSTRUCTORU GEREKLI ATAMALAR YAPILDI
        this.head = 0;
        this.tail = -1;
        this.elementNumber= 0;
        this.queueList = new ArrayList<>();
    }
    
    public void enQueue(int eklenecekSayi){ //ENQUEUE METODU ILE YAPININ SONUNA ELEMAN EKLENIR VE ARTTIRMALAR YAPILIR
        queueList.add(eklenecekSayi);
        elementNumber++;
        tail++;
    }
    
    public int deQueue(){   //ARRAYLISTIN ILK ELEMANI ALINIR VE EGER ARRAYLISTIN UZUNLUGU 1 DEN FAZLAYSA ARRAYLISTTEKI TUM ELEMANLAR DOLASILARAK EN KUCUK URUN SAYISINA SAHIP MUSTERI BULUNUR VE DEGISIKLIKLER YAPILIR
        int silinecekSayi = queueList.get(0);
        if(queueList.size()>1){
            int enKucukSayi = silinecekSayi;
            
            for(int kuyruktakiSayilar: queueList){  //ARRAYLISTIN DOLASILMASI
                if(kuyruktakiSayilar<enKucukSayi){
                    silinecekSayi = kuyruktakiSayilar;
                    enKucukSayi = kuyruktakiSayilar;
                }
            }
        }
        
        queueList.remove(queueList.indexOf(silinecekSayi)); //EN KUCUK SAYIYA SAHIP MUSTERI ARRAYLISTTEN INDEX KULLANILARAK SILINIR
        elementNumber--;
        
        return silinecekSayi;   //SILINECEK MUSTERININ URUN SAYISI GERI GONDERILIR
        
    }
    
    public boolean isEmpty(){   //ELEMAN SAYISI 0 OLDUGUNDA TRUE GONDERECEK ISEMPTY METODU
        return (elementNumber==0);
        
    }
}
