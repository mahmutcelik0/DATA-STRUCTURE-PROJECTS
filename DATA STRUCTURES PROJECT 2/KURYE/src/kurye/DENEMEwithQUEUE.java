
package kurye;

import java.util.ArrayList;

public class DENEMEwithQUEUE {  //2. SORU ICIN GERKELI KUYRUK ILE GERCEKLESTIRIM . ARRAYLIST STACKTEKI OLDUGU GIBI BURADA DA CLASS ICINDE TEKRAR DOLDURULUYOR VE ELEMANLAR SONRASINDA CIKARITLARAK KUYRUGA EKLENIYOR
    static final String[] MahalleAdi = {"Özkanlar", "Evka 3", "Atatürk", "Erzene", "Kazımdirik", "Mevlana","Doğanlar", "Ergene" };  //ORNEK VERILEN MAHALLE ADLARI
    static final int[] TeslimatSayisi = {5,2,7,2,7,3,0,1};  //ORNEK VERILEN TESLIMAT SAYILARI
    
    public static void main(String[] args){ //MAIN METODU
        ArrayList<Mahalle> MotoKurye = new ArrayList<>();   //MOTOKURYE ARRAYLISTI OLUSTURULDU VE FOR DONGUSU ILE MAHALLELER DOLDURULACAK
        
        for(int a = 0 ; a<MahalleAdi.length;a++){
            MotoKurye.add(new Mahalle(MahalleAdi[a],TeslimatSayisi[a]));
            
        }
        
        Queue queue = new Queue(MahalleAdi.length); //QUEUE CLASSI KULLANILARAK OLUSTURULAN queue adlı KUYRUK (3.SORUDA DIZI KULLANILMAMASI GEREKTIGINI DUSUNEREK BURADA DIZI KULLANABILECEGIMI VARSAYARAK YAZDIM) DIZI KULLANARAK YAPTIGIM ICIN MAHALLE SAYISI UZUNLUGUNDA BI KUYRUK OLUSTURDUM
        
        for(Mahalle mahalle : MotoKurye){   //FOREACH DONGUUSYLE MOTOKURYE ARRAYLISTINDEKI ELEMANLAR DOLASILARAK KUYRUGA ENQUEUE METODU SAYESINDE EKLENIRLER
            queue.enQueue(mahalle);
        }
        
        while(!queue.isEmpty()){ // KUYRUKTA ELEMAN KALMADIGINI ISEMPTY ILE KONTROL EDEREK ELEMANLAR CIKARILIR VE YAZDIRILIR
            System.out.println(queue.deQueue().toString());
        }
        
    }  
}

class Queue{    //QUEUE CLASSI
    private int maxSize;    //QUEUE CLASSI ICIN GEREKLI OZELLIKLER
    private int head;
    private int tail;
    private Mahalle[] queueList;
    private int elementCount;
    
    public Queue(int maxSize){  //DIZI KULLANARAK OLUSTURDUGUM ICIN MAXSIZE GELIR VE GEREKLI ATAMALAR YAPILIR
        this.maxSize = maxSize;
        head = 0;
        tail = -1;
        elementCount = 0;
        queueList = new Mahalle[maxSize];
    }
    
    public void enQueue(Mahalle eklenecekMahalle){  // ENQUEUE KULLANARAK KUYRUGUN SONUNA ELEMAN EKLEMESI YAPILIR DAIRESEL KUYRUK SEKLINDE YAZDIM FAKAT DIZI ELEMAN UZUNLUGUNDA OLUSTURULDUGU ICIN OLMASA DA CALISABILIR
        if(tail == maxSize-1){
            tail = -1;
        }
        queueList[++tail] = eklenecekMahalle;   //KUYRUK 1 ARTTILIR VE EKLEME YAPILIR
        elementCount++; //ELEMAN SAYISI 1 ARTTIRILIR
    }
    
    
    public Mahalle deQueue(){   // DEQUEUE KULLANARAK KUYRUGUN BASINDAN ELEMAN CIKARILIR DAIRESEL MANTIKTA YAZDIM FAKAT DIZI ELEMAN SAYISI UZUNLUGUNDA OLUSTURULACAGI ICIN GEREKLI DEGIL
        Mahalle temp = queueList[head++];   //ELEMAN ALINIR VE HEAD 1 ARTTIRILIR
        if(head == maxSize){    //DAIRESEL OLMAYI SAGLAYAN IF KISMI
            head =0;
        }
        elementCount--; //ELEMAN SAYISI 1 AZALTILIR VE ALINAN ELEMAN RETURNLE GERI GONDERILIR
        return temp;
    }
    
    
    public boolean isEmpty(){   //ISEMPTY KULLANARAK KUYRUKTA ELEMAN OLUP OLMADIGI OGRENILIR ELEMAN SAYISI 0 SA KUYRUK BOSTUR RETURN TRUE OLUR
        return (elementCount ==0);
    }
    
    
    public boolean isFull(){    //IS FULL GEREKLI DEGIL FAKAT YAZDIM ELEMAN SAYISI MAXSIZE A ULASTIGINDA KUYRUK TAMAMEN DOLMUSTUR RETURN TRUE GONDERIR
        return (elementCount ==maxSize);
    }
    
    public int size(){  //SIZE IZE ELEMAN SAYISINI DONDURUR
        return elementCount;
    }
            
    
    
}
