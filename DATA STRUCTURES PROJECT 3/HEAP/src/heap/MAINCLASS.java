
package heap;

public class MAINCLASS {

    static final int numbers[] = {13,21,16,24,30,19,68,65,26,32};
    
    //OLUSTURDUGUM BU HEAP MIN HEAPTIR. A MADDESINE CALISIRKEN BU KISMI OLUSTURDUM
    //RAPOR KISMINDA MAX HEAP ICIN RAPOR DOLDURACAGIM
    
    public static void main(String[] args) {
        
        HEAP heap = new HEAP(); //HEAP CLASSINDAN NESNE OLUSTURDUM
        
        for(int number : numbers){  //FOR EACH DONGUSUYLE SAYILARI EKLEDIM
            heap.add(number);
        }
        
        System.out.println("HEAP PEEK: "+ heap.peek()); //OLUSTURULAN METODLARIN TEST EDILMESI

        
        System.out.println("HEAP BOS MU: "+ heap.isEmpty());
        
        while(!heap.isEmpty()){
            System.out.println("ELEMANLAR;");
            heap.heapElemanlariYazdirma();
            
            System.out.println("SİLİNEN ELEMAN: " + heap.delete());
        }
        
        System.out.println("HEAP BOS MU: " + heap.isEmpty());
        
        System.out.println("HEAP PEEK: "+ heap.peek());
        
        
        
    }
    
    
    
}
