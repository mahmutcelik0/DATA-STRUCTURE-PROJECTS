
package queuevspriorityqueue;

/*
4.sorunun a ve b şıkları için 2 adet main metodu olusturdum tek tek calıstırıldıklarında dogru cevapları vermektedirler 

AYBARS HOCAYLA KONUSTUGUMDA DA BIRDEN FAZLA MAIN METODU KULLANILARAK YAPILABILECEGINI SOYLEMISTI. ANLASILMAMISSA VIDEO KAYDINDA DA BAHSEDECEGIM. TESEKKURLER 
*/



public class FOURTHQUESTIONwithQUEUE {  //4.sorunun QUEUE ILE GERCEKLESTIRILMESI YANI A SIKKI

    static final int[] musteriSepetleri = {6,7,2,1,12,5,3,7,4,2};   //ORNEK VERILEN MUSTERILERIN SEPETLERI DIZISI
    static int urunOkumaSuresi = 3; //VERILEN URUN OKUMA SURESI 3 SN
    
    public static void main(String[] args) {    //MAIN METODU
        QUEUE queue = new QUEUE(musteriSepetleri.length);   //QUEUE CLASSINDAN NESNE OLUSTURULUYOR OLUSTURULAN QUEUE DIZIDEN OLUSTUGU ICIN MUSTERI SAYISI KADAR UZUNLUKTA OLUSTURDUM
        
        for(int sayi: musteriSepetleri){    //MUSTERILERIN SEPETLERI FOR EACH DONGUSUYLE DOLASILARAK KUYRUK YAPISINA EKLENIR
            queue.enQueue(sayi);
        }

        urunlerınOkutulmasi(queue); //URUNLERIN OKUTULMASI METODU ILE HER MUSTERININ NE KADAR BEKLEDIGI VE ORTALAMA BEKLEME SURESI HESAPLANIR
          
    }
    
    public static void urunlerınOkutulmasi(QUEUE queue){    //KAC TANE MUSTERI OLDUGU HER BIRININ BEKLEME SURESI VE TOPLAM BEKLEME SURELERI HESAPLANIR
        int kacinciMusteri =0;  //GEREKLI DEGISKENLER
        int herMusteriBeklemeSuresi =0;
        int toplamIslemTamamlanmaSuresi =0;
        
        System.out.println("QUEUE DIZILIMINE GORE SONUCLAR");

        
        while(!queue.isEmpty()){    //KUYRUKTAKI TUM ELEMANLAR CIKARTILASIYA KADAR CALISACAK WHILE DONGUSU
            kacinciMusteri++;   // HER CIKARTILAN ELEMANDA MUSTERI SAYISI 1 ARTAR
            int musteridekiUrunSayisi = queue.deQueue();    //KUYRUKTAKI ELEMAN CIKARILIR
            
            herMusteriBeklemeSuresi+= (musteridekiUrunSayisi*urunOkumaSuresi ); //CIKARILAN MUSTERININ URUN SAYISI VE URUN OKUMA SURE SABITI CARPILIR VE HER MUSTERI ICIN EKLENEREK ARTAR CUNKU ORNEK OLARAK 3. MUSTERI 1. VE 2. MUSTERIYI BEKLER SONRASINDA KENDI ISLEMLERI BITER
            toplamIslemTamamlanmaSuresi+= herMusteriBeklemeSuresi;  //BURADA DA HER MUSTERININ BEKLEME SURESI TOPLANIR 1.MUSTERI 3 SN 2. MUSTERI ISLEMI 3 TOPLAM 6 SANIYE YANI BURADA 3+6 DAN 9 OLUR ORNEK VERECEK OLURSAK
            System.out.println(kacinciMusteri+".Müşterinin işlem tamamlanma süresi: " + (herMusteriBeklemeSuresi)); //HER MUSTERININ NE KADAR BEKLEDIGI CIKARTILDIKCA YAZDIRILIR
        }
        
        ortalamaIslemTamamlanmaYazdirilmasi(toplamIslemTamamlanmaSuresi, kacinciMusteri);   //MUSTERILERIN ORTALAMA BEKLEME SURESININ YAZDIRILMASI ICIN GEREKLI METOD
        
    }
    
    public static void ortalamaIslemTamamlanmaYazdirilmasi(int toplamIslemTamamlanmaSuresi, int kacinciMusteri){
        double ortalamaIslemTamamlanmaSuresi = (toplamIslemTamamlanmaSuresi/(double)kacinciMusteri);    //HER MUSTERININ BEKLEME SURELERININ TOPLANDIGI DEGISKENI MUSTERI SAYISINA BOLEREK HESAPLANIR
        
        System.out.println("BU KASADAKI MUSTERILERIN ORTALAMA ISLEM TAMAMLANMA SURESI: " + ortalamaIslemTamamlanmaSuresi);
    }
}

class QUEUE{    //DIZI KULLANILARAK OLUSTURULAN QUEUE SINIFI
    
    private int head;   //GEREKLI OZELLIKLER DIZI KULLANDIM AKSI BELIRTILMEMIS
    private int tail;
    private int elementNumber;
    private int[] queueList;
    private int maxSize;
    
    public QUEUE(int maxSize){  //CLASS A AIT CONSTRUCTOR. DIZI KULLANDIGIM ICIN ICINDE MAXSIZE GELECEK VE BU UZUNLUGA GORE KUYRUK DIZISI OLUSTURULACAK
        this.maxSize = maxSize;
        this.head = 0 ;
        this.tail = -1;
        this.elementNumber = 0;
        this.queueList = new int[maxSize];
        
    }
    
    public void enQueue(int eklenecekSayi){ //DIZIYE ELEMAN EKLEME ICIN ENQUEUE METODU. KUYRUGUN SONUNA EKLEME YAPILIR  DAIRESEL KUYRUK YAPISINDA OLUSTURDUM FAKAT ELEMAN SAYISI UZUNLUGUNDA OLACAGI ICIN BU OZELLIGE GEREK KALMAYACAK
        if(tail == maxSize-1){
            tail = -1;
        }
        queueList[++tail] = eklenecekSayi;  //TAIL 1 ARTTIRILIR VE EKLENECEK SAYI EKLENIR ELEMAN SAYISI 1 ARTTIRILIR
        elementNumber++;
    }
    
    public int deQueue(){   //DIZIDEN ELEMAN CIKARMA ICIN DEQUEUE METODU. KUYRUGUN BASINDAN ELEMAN CIKARILIR DAIRESEL KUYRUK YAPISINDA OLUSTURDUM FAKAT ELEMAN SAYISI UZUNLUGUNDA OLACAGI ICIN BU OZELLIGE GEREK KALMAYACAK
        int silinecekSayi = queueList[head++];  //SILINECEK SAYI ICIN HEADDEN ELEMAN ALINIR VE HEAD 1 ARTTIRILIR
        if(head == maxSize){
            head =0;
        }
        elementNumber--;
        return silinecekSayi;
    }
    
    public boolean isEmpty(){   //ELEMAN SAYISI 0 OLDUGUNDA ISEMPTY METODU TRUE DONDURUR
        return (elementNumber==0);
    }
}
