
package kurye;


import java.util.ArrayList;
public class DENEME {   //SORU 1.B ICIN YAZILMIS CLASS  ** ARRAYLIST OLUSTURULUYOR VE ORNEKTE VERILEN MAHALLE VE TESLIMAT SAYILARI VEYA HERHANGI MAHALLE SAYISI KADAR ICINE MAHALLE NESNESI EKLENIYOR VE ISTENENLERI GERCEKLESTIRIYOR

    static final String[] MahalleAdi = {"Özkanlar", "Evka 3", "Atatürk", "Erzene", "Kazımdirik", "Mevlana","Doğanlar", "Ergene" };  //VERILEN ORNEK MAHALLELER
    static final int[] TeslimatSayisi = {5,2,7,2,7,3,0,1};  //VERILEN ORNEK TESLIMAT SAYILARI
    
    public static void main(String[] args) {    //MAIN METODU
        
        //GENEL KULLANIM ICIN ARRAYLISTI OLUSTURDUM
        
        ArrayList<Mahalle> MotoKurye = new ArrayList<>();   //ARRAYLIST OLUSTURULMASI
        
        for(int a = 0 ; a<MahalleAdi.length;a++){   //MAHALLENIN UZUNLUGU KADAR DONECEK BIR FOR DONGUSU HER BIR DONMEDE SIRAYLA MAHALLE ADI VE TESLIMAT SAYISI DIZIDEN ALINIR VE ARRAYLISTE YENI MAHALLE NESNESI OLUSTURULARAK EKLENIR
            MotoKurye.add(new Mahalle(MahalleAdi[a],TeslimatSayisi[a]));
            
        }
        
        //SORU 1B VE 1C ICIN GEREKLI KISIMLAR

        System.out.println("*********SORU 1.B VE 1.C İÇİN ÇÖZÜMLER**********");
        bilesikVeriYapisindakiElemanlarinYazdirilmasi(MotoKurye);   //VERI YAPISININ YAZDIRILMASI 1.C ICIN GEREKLI
        elemanSayisi(MotoKurye);    //ELEMAN SAYISININ YAZDIRILMASI 1.C ICIN GEREKLI
        toplamTeslimatSayisi(MotoKurye);    //TOPLAM YAPILAN TESLIMAT SAYISININ YAZDIRILMASI 1.C ICIN GEREKLI
  
        
        
        System.out.println("\n\n");
        System.out.println("************SORU 2.A İÇİN ÇÖZÜMLER*************");
        
        Stack stack = new Stack(MahalleAdi.length); //STACK CLASSINDAN OLUSTURULAN stack adlı NESNE MAHALLE SAYISI KADAR UZUNLUKTADIR
        for(Mahalle mahalle : MotoKurye){   //ARRAYLISTTEKI ELEMANLARIN FOR EACH DONGUSUYLE STACK E PUSHLANMASI
            stack.push(mahalle);
        }
        
        while(!stack.isEmpty()){    //STACKTEKI ELEMANLARIN ISEMPTY KULLANARAK TUM YIGITIN POP KULLANILARAK CIKARTILIP YAZDIRILMASI
            System.out.println(stack.pop().toString());
        }
        
        System.out.println("\n\n");
        System.out.println("************SORU 2.B İÇİN ÇÖZÜMLER*************");
        
        Queue queue = new Queue(MahalleAdi.length); //QUEUE CLASSI KULLANILARAK OLUSTURULAN queue adlı KUYRUK (3.SORUDA DIZI KULLANILMAMASI GEREKTIGINI DUSUNEREK BURADA DIZI KULLANABILECEGIMI VARSAYARAK YAZDIM) DIZI KULLANARAK YAPTIGIM ICIN MAHALLE SAYISI UZUNLUGUNDA BI KUYRUK OLUSTURDUM
        
        for(Mahalle mahalle : MotoKurye){   //FOREACH DONGUUSYLE MOTOKURYE ARRAYLISTINDEKI ELEMANLAR DOLASILARAK KUYRUGA ENQUEUE METODU SAYESINDE EKLENIRLER
            queue.enQueue(mahalle);
        }
        
        while(!queue.isEmpty()){ // KUYRUKTA ELEMAN KALMADIGINI ISEMPTY ILE KONTROL EDEREK ELEMANLAR CIKARILIR VE YAZDIRILIR
            System.out.println(queue.deQueue().toString());
        }
        
        
        System.out.println("\n\n");
        System.out.println("************SORU 3 İÇİN ÇÖZÜMLER*************");
        
        PriorityQUEUE priorityQueue = new PriorityQUEUE();  //PRIORITYQUEUE CLASSINDAN NESNE OLUSTURULUYOR
        for(Mahalle mahalle : MotoKurye){ //FOREACH DONGUSUYLE MOTOKURYE ARRAYLISTINDEKI ELEMANLAR DOLASILARAK PRIORITYQUEUE YA ENQUEUE METODU İLE EKLENİYOR
            priorityQueue.enQueue(mahalle);
        }
        
        while(!priorityQueue.isEmpty()){    //OLUSTURULAN PRIORITYQUEUE DA ELEMAN KALMAYASIYA KADAR DONECEK WHILE DONGUSU ICINDEKI DEQUEUE ILE ELEMANLAR CIKARTILIR VE YAZDIRILIR
            System.out.println(priorityQueue.deQueue().toString());
        }   
        
    }
    
    //SORU 1B VE 1C ICIN GEREKLI METODLAR
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
    
