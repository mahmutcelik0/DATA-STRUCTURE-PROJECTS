
package kurye;

/*

KODLARIN KARISMAMASI ICIN 4 ADET MAIN METODU BULUNUYOR HER MAIN METODU 
CALISTIRILDIGINDA DOGRU SEKILDE CALISIYOR TEK MAIN ICERSINDE ALT ALTA YAPMAK 
YERINE BU SEKILDE YAPTIM


*/


import java.util.ArrayList;

public class DENEMEwithSTACK {  //2. SORU ICIN YIGIT OLUSTURULMASI DENEME CLASSI GIBI ICINDE ARRAYLIST VAR VE STACK ELEMANLARI BU ARRAYLISTTEN CEKILIYOR
    
    static final String[] MahalleAdi = {"Özkanlar", "Evka 3", "Atatürk", "Erzene", "Kazımdirik", "Mevlana","Doğanlar", "Ergene" };  //ORNEK VERILEN MAHALLELER
    static final int[] TeslimatSayisi = {5,2,7,2,7,3,0,1};  //ORNEK VERILEN TESLIMAT SAYILARI
    
    public static void main(String[] args){ //MAIN METODU
        ArrayList<Mahalle> MotoKurye = new ArrayList<>();   //ARRAYLIST OLUSTURULDU VE DENEME CLASSINDAKI GIBI FOR DONGUSUYLE MAHALLELER EKLENECEK
        
        for(int a = 0 ; a<MahalleAdi.length;a++){
            MotoKurye.add(new Mahalle(MahalleAdi[a],TeslimatSayisi[a]));
            
        }
        
        Stack stack = new Stack(MahalleAdi.length); //STACK CLASSINDAN OLUSTURULAN stack adlı NESNE MAHALLE SAYISI KADAR UZUNLUKTADIR
        for(Mahalle mahalle : MotoKurye){   //ARRAYLISTTEKI ELEMANLARIN FOR EACH DONGUSUYLE STACK E PUSHLANMASI
            stack.push(mahalle);
        }
        
        while(!stack.isEmpty()){    //STACKTEKI ELEMANLARIN ISEMPTY KULLANARAK TUM YIGITIN POP KULLANILARAK CIKARTILIP YAZDIRILMASI
            System.out.println(stack.pop().toString());
        }
        
    }  
}
class Stack{    //STACK CLASSI
        private int maxSize; //STACK CLASSI ICIN GEREKLI OZELLIKLER
        private Mahalle[] stackList;
        private int top;
        
        public Stack(int maxSize){  //STACK CONSTRUCTOR U DIZI KULLANARAK YAPTIGIM ICIN (DIZI KULLANMAMA 3. SORU ICIN ANLADIM) MAX SIZE GELIR VE ATAMA YAPILIR
            this.maxSize = maxSize;
            stackList = new Mahalle[maxSize];
            top = -1;   //TOP -1 OLARAK BASLAR
        }
        
        
        public void push(Mahalle eklenecekMahalle){ //OLUSTURULAN STACK IN EN USTUNE ELEMAN EKLENIR ONCESINDE TOP 1 ARTTIRILIR
            if(top == maxSize-1){
                return;
            }
            
            stackList[++top] = eklenecekMahalle;
        }
        public Mahalle pop(){   // OLUSTURULAN STACKIN EN USTUNDEKI ELEMAN CIKARTILIR VE TOP 1 EKSILTILIR
            if(top>=0){
                return stackList[top--];
            }
            return null;
        }
        public Mahalle peek(){  //ODEV ICIN GEREKLI DEGIL FAKAT YAZDIM PEEK METODU ILE STACKIN EN USTUNDEKI ELEMANI CIKARMADAN GOREBILIRIZ
            return stackList[top];
        }
        public boolean isEmpty(){   //IS EMPTY KULLANILARAK STACKIN BOS OLUP OLMADIGINI ANLAYABILIRIZ. TOP -1 OLUYOR ISE RETURN TRUE GONDERIR
            return (top ==-1);
        }
        
    }
    
