
package kurye;

import java.util.ArrayList;

public class DENEMEwithPRIORITYQUEUE {  //3.soru ıcın gereklı class ICINDE PRIORITYQUEUE ADLI CLASS BULUNDURUR VE BU CLASSTA NESNELER ARRAYLISTE EKLENIR ISTENILDIGI GIBI EKLENIRKEN HERHANGI SIRALAMA YOK CIKARILIRKEN AZALAN SIRADA OLACAK SEKILDE CIKARILIR
    static final String[] MahalleAdi = {"Özkanlar", "Evka 3", "Atatürk", "Erzene", "Kazımdirik", "Mevlana","Doğanlar", "Ergene"};   //ORNEK VERILEN MAHALLELER
    static final int[] TeslimatSayisi = {5,2,7,2,7,3,0,1};  //ORNEK VERILEN TESLIMAT SAYILARI
    
    public static void main(String[] args){ //MAIN METODU
        
        PriorityQUEUE priorityQueue = new PriorityQUEUE();  //PRIORITYQUEUE CLASSINDAN NESNE OLUSTURULUYOR
        for(int a = 0 ; a<MahalleAdi.length ; a++){ //ONCEKILERDE ARRAYLISTTEN CEKILEREK YAPIYORDUM FAKAT BUNDA BU SEKILDE YAPTIM FOR DONGUSUYLE MAHALLELER DOLASILIYOR VE TESLIMAT SAYILARIYLA BIRLIKTE ONCELIKLI KUYRUK YAPISINA ENQUEUE KULLANILARAK EKLENIYOR
            priorityQueue.enQueue(new Mahalle(MahalleAdi[a],TeslimatSayisi[a]));
        }
        
        while(!priorityQueue.isEmpty()){    //OLUSTURULAN PRIORITYQUEUE DA ELEMAN KALMAYASIYA KADAR DONECEK WHILE DONGUSU ICINDEKI DEQUEUE ILE ELEMANLAR CIKARTILIR VE YAZDIRILIR
            System.out.println(priorityQueue.deQueue().toString());
        }   
    }  
}

class PriorityQUEUE{    //PRIORITYQUEUE CLASSI 
    ArrayList<Mahalle> priorityQUEUEList ;  //ISTENILDIGI GIBI ICINDE C# TAKI LIST JAVADAKI ARRAYLIST HAZIR VERI YAPISI KULLANILMISTIR LISTENIN DEGISKEN ADI ATANIYOR VE GEREKLI OZELLIKLER BELIRLENIYOR
    private int head;   //kullanılmadı
    private int tail;   //gerek kalmadı
    private int elementNumber;
    
    
    
    public PriorityQUEUE(){ //CLASSIN CONSTRUCTORU QUEUE A BENZER ATAMALAR YAPILIYOR OLUSTURULAN priorityQUEUEList NESNESİ DE BELLEKTE ARRAYLIST OLUSTURULUP ATANIYOR
        this.priorityQUEUEList = new ArrayList<>();
        this.head = 0;
        this.tail = -1;
        this.elementNumber =0;
        
    }
    
    public void enQueue(Mahalle eklenecekMahalle){  //ENQUEUE METODU ILE OLUSTURULAN ARRAYLISTE ELEMAN EKLENECEK GELEN ELEMAN OLUSTURULAN ARRAYLISTIN SONUNA EKLENIR
        priorityQUEUEList.add(eklenecekMahalle);
        tail++;
        elementNumber++;
    }
    
    public Mahalle deQueue(){   //OLUSTURULAN ARRAYLISTTEN EN COK TESLIMAT YAPILAN MAHALLEYI BULUP ARRAYLISTTEN CIKARAN METOD
        Mahalle silinecekMahalle = priorityQUEUEList.get(0);    //ARRAYLISTIN ILK ELEMANINI ALIR EGER 1DEN FAZLA ELEMAN VARSA IF CALISIR VE IF ICINDEKI FOR DONGUSUYLE ARRAYLIST DOLASILIR. GET GENERIC LIST ILE KARSILASTIRMA YAPILARAK EN COK TESLIMAT YAPILAN MAHALLE BULUNUR
        if(priorityQUEUEList.size()>1){
            int maxTeslimatSayi =0;
            for(Mahalle mahalleler : priorityQUEUEList){
                if(mahalleler.getGenericList().size()>maxTeslimatSayi){
                    silinecekMahalle = mahalleler;
                    maxTeslimatSayi = mahalleler.getGenericList().size();
                    
                }
            }
        }
        priorityQUEUEList.remove(silinecekMahalle); // EN COK TESLIMAT YAPILAN MAHALLE ARRAYLISTTEN SILINIR
        //System.out.println("SİLİNEN MAHALLEYE YAPILAN TESLIMAT ADEDI: "+silinecekMahalle.getGenericList().size()); BENIM ICIN GEREKLIYDI
        return silinecekMahalle;    //EN COK TESLIMAT YAPILAN MAHALLE GERI GONDERILIR
        
    }
    
    public boolean isEmpty(){   //ARRAYLISTIN BOS OLUP OLMADIGINI OGRENMEMIZI SAGLAYAN METOD
        return (priorityQUEUEList.size()==0);
    }  
}
