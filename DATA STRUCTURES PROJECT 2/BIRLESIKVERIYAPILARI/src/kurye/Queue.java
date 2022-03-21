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
public class Queue {
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
