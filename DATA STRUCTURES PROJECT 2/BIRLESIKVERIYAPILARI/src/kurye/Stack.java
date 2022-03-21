package kurye;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mahmut
 */
public class Stack {
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
