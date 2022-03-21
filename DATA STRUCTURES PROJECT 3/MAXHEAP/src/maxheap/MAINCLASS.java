
package maxheap;


//PROJEDE ISTENEN MAXHEAP ICIN MAIN CLASSI VE MAXHEAP CLASSI BURADADIR

public class MAINCLASS {    

    //SECTIGIM MAHALLELER VE NUFUSLARI
    static final String[] mahalleAdlari = {"ERZENE", "KAZIMDİRİK","YEŞİLOVA","ATATÜRK","İNÖNÜ","MEVLANA","EVKA 3","ERGENE","KIZILAY","MERİÇ"};
    static final int[] mahalleNufuslari ={35135,33934,31008,28912,25778,25492,20445,11245,15795,8394};
    static final int cikarilacakMahalleSayisi =3;
    
    public static void main(String[] args) {
        
        HEAP heap = new HEAP(); //MAXHEAP CLASSINDAN NESNE OLUSTURDUM
        
        for(int a = 0 ; a<mahalleAdlari.length ; a++){  //FOR DONGUSUYLE DIZI DOLASILARAK ELEMANLAR HEAP E YENI NESNE OLUSTURULARAK EKLENIYOR
            heap.add(new Mahalle(mahalleAdlari[a], mahalleNufuslari[a]));
        }
        
        System.out.println("-----------TUM MAHALLELER EKLENDIKTEN SONRA HEAP-----------");
        heap.heapElemanlariYazdirma();
        
        System.out.println("\n----------- HEAPTEN MAX NUFUSLU 3 MAHALLE CIKARILMASI -----------");
        for(int a= 1 ; a<=cikarilacakMahalleSayisi ;a++){   //MAXHEAPTEKI DELETE METODU KULLANILARAK HEAPTEN ELEMANLAR SILINIR
            System.out.println("HEAPTEN CIKARILAN EN BUYUK "+a+".MAHALLE BILGILERI;");
            System.out.println(heap.delete());
        }
        
        System.out.println("\n-----------3MAHALLE CIKARILDIKTAN SONRA HEAP -----------");
        heap.heapElemanlariYazdirma();

        
        
    }
    
}
