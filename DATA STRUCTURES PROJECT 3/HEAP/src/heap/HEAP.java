
package heap;

import java.util.ArrayList;

//HEAPLERE CALISIRKEN MIN HEAPLE BASLAMISTIM BU CLASSI OLUSTURDUM FAKAT PROJEDE MAXHEAP ISTEDIGI ICIN 
//MAXHEAP CLASSI DA OLUSTURDUM.

public class HEAP { //HEAP CLASS I
    
    private ArrayList<Node> heapList ;  //HEAP I ARRAYLIST KULLANARAK OLUSTURDUM
    
    public HEAP(){  //CONSTRUCTOR 
        heapList = new ArrayList<>();
    }
    
    public void add(int sayi){  //ADD METODUNDA ARRAYLIST E ELEMAN EKLENIR
        Node newNode = new Node(sayi);
        
        if(heapList.isEmpty()){ //ARRAYLISTTE ELEMAN YOKSA 0. ELEMAN NULL OLARAK EKLENIR. 1. ELEMANA DA GELEN SAYI DEGERI EKLENIR
            heapList.add(null);
            heapList.add(1, newNode);
            
        }
        
        else{   //ARRAYLISTTE ELEMAN VARSA ARRAYLISTTTEKI ADD METODU KULLANILARAK SONA DOGRU EKLEME YAPILIR VE SONRASINDA MAX HEAP YAPISINI SAGLAMAK ICIN YUKARIYA DOGRU DUZENLEME YAPILIR
            heapList.add(newNode);
            yukariyaDogruDuzenleme();
        }
        
    }
    
    public int delete(){    //HEAPTEN ELEMAN SILMEYI SAGLAYAN METOD
        
        if(heapList.size() ==2){    //HEAPIN SIZE I 2 ISE YANI 0. VE 1. INDEXLER DOLUYSA BU KISIM CALISIR
                                    //0.INDEXTE NULL 1.INDEXTE ELEMAN OLUR YANI HEAPTEKI SON ELEMANI CIKARMA KISMINI YAPAR
            Node nodeToDelete = heapList.get(1);    //1.INDEXTEKI ELEMANI ALIR VE ARRAYLISTTEN SILER
            heapList.remove(1);
            return nodeToDelete.data;   //SILINEN ELEMANIN GERI GONDERILMESI
        }
        
        Node nodeToDelete = heapList.get(1) ;   //HEAPTEN ELEMAN SILME MANTIGI OLARAK HER ZAMAN ROOTTAKI ELEMAN YANI EN TEPEDEKI ELEMAN SILINECEGI ICIN EN USTTEKI ELEMAN ARRAYLISTTEN ALINIR
        int lastElementIndex = heapList.size()-1;   //SON YAPRAKTAKI ELEMANIN INDEXI ATANIR

        heapList.set(1, heapList.get(lastElementIndex));    //SON YAPRAKTAKI ELEMAN HEAP MANTIGINA GORE ELEMAN SILINDIKTEN SONRA EN BASA GECER VE ASAGIYA DOGRU DUZENLEME YAPILARAK HEAP YAPISI TEKRARDAN OLUSTURULUR
        heapList.remove(lastElementIndex);  //YAPRAK BASA GECTIKTEN SONRA YAPRAKTAKI BILGI SILINIR
        
        asagiyaDogruDuzenleme();    //ASAGIYYA DOGRU DUZENLEME
        
        return nodeToDelete.data;   //SILINEN ELEMANIN VERISININ GONDERILMESI
    }
    
    private void asagiyaDogruDuzenleme(){   //ELEMAN SILINDIKTEN SONRA HEAP YAPISININ TEKRAR DUZENLENMESI ICIN KULLANILIR DUZENSIZ HEAPTE EN USTTEKI ELEMAN COCUKLARIYLA KARSILASTIRILIR VE MIN HEAPTE DAHA KUCUK OLAN COCUKLA YER DEGISTIRIR
        int firstElementIndex = 1;
        
        Node firstElement = heapList.get(firstElementIndex);    //ILK ELEMANIN ALINMASI
        
        Node smallerChild = kucukCocukBulma(firstElementIndex); // ILK ELEMANIN COCUKLARININ KARSILASTIRILIP DAHA KUCUK OLANIN BULUNMASI VE ATANMASI
        
        int smallerChildIndex = heapList.indexOf(smallerChild);    //DAHA KUCUK COCUGUN INDEXI
        
        while(smallerChild!=null &&firstElement.data > smallerChild.data){  // KUCUK COCUK NULL OLMADIGI SURECE YANI YAPRAGA GELINMEDIGI SURECE VE MIN HEAPTE PARENT NODE DATASI COCUGUN DATASINDAN BUYUK OLDUGU SURECE DONECEK WHILE DONGUSU
            heapList.set(firstElementIndex, smallerChild);  //PARENTLA UYGUN CHILD YER DEGISTIRIR
            heapList.set(smallerChildIndex,firstElement);

            firstElementIndex = heapList.indexOf(firstElement); //ILK BASTA ROOTTA OLAN ELEMAN SIMDI YER DEGISTIRDIGI ICIN TEKRARDAN INDEX DEGERI BULUNUR
            firstElement = heapList.get(firstElementIndex);

            smallerChild = kucukCocukBulma(firstElementIndex);  //YERI DEGISTIRILEN ELEMANIN COCUKLARI TEKRAR BULUNUR VE UYGUN DURUMSA WHILE DONGUSUYLE TEKRAR EDER BU DURUM
            smallerChildIndex = heapList.indexOf(smallerChild);
        }
    }
    
    private Node kucukCocukBulma(int parentIndex){  //KUCUK COCUGUN BULUNDUGU METOD
        int leftChildIndex = 2*parentIndex; //SOL COCUK VE SAG COCUK UYGUN INDEX FORMULLERI
        int rightChildIndex = 2*parentIndex +1;
        
        Node smallerChild ;
        
        if((leftChildIndex >=heapList.size() || rightChildIndex >=heapList.size())) //ARRAYLISTIN ICINDEKI ELEMANLARIN SIZE INI TASIYORSA NULL DONDURUR
            return null;
        if(heapList.get(leftChildIndex).data < heapList.get(rightChildIndex).data ){    //SOLDAKI COCUGUN VERISI DAHA KUCUKSE KUCUK COCUK SOLDAKI OLUR
            smallerChild = heapList.get(leftChildIndex);
        }
        else if(heapList.get(leftChildIndex).data > heapList.get(rightChildIndex).data){    //SAGDAKI COCUGUN VERISI DAHA KUCUKSE KUCUK COCUK SAGDAKI OLUR
            smallerChild = heapList.get(rightChildIndex);
        }
        else{   //ELSE DURUMUNDA NULL DONDURUR
            return null;
        }
        
        return smallerChild;    //KUCUK COCUK GONDERILIR
        
    }
    
    
    private void yukariyaDogruDuzenleme(){  //YUKARIYA DOGRU DUZENLEME ISE ELEMAN EKLENDIKTEN SONRA YAPRAKTAN YUKARIYA DOGRU KARSILASTIRILARAK EKLENEN ELEMANIN HEAP YAPISINA UYGUNLUGU SAGLANIR
        
        int lastElementIndex = heapList.size() -1;  //SON EKLENEN ELEMANIN INDEXI
                
        int parentIndex = lastElementIndex /2;  //PARENTIN FORMULE UYGUN INDEXI
                
        Node lastElement = heapList.get(lastElementIndex);  //SON ELEMANIN DEGISKENE ATANMASI
                
        while(lastElementIndex>0 &&parentIndex >0 && heapList.get(parentIndex).getData()> lastElement.getData()){   //INDEX DEGERLERI VE VERILERIN KARSILASTIRMA SONUCLARI UYGUN OLDUGU SURECE DONECEK WHILE DONGUSU
            
            heapList.set(lastElementIndex, heapList.get(parentIndex));  //PARENTIN ASAGIYA INDIRILMESI
            lastElementIndex = parentIndex; //YENI INDEXLER
            parentIndex = parentIndex/2;
            
        }
        heapList.set(lastElementIndex, lastElement);    //YAPRAGIN EN SON BULUNAN INDEXE YERLESTIRILMESI
        
    }
    
    public void heapElemanlariYazdirma(){   //FOR DONGUSUYLE 1.INDEXTEN BASLAYARAK ARRAYLISTTEKI ELEMANLAR YAZDIRILIR
        
        for(int a =1 ;a< heapList.size() ; a++){
            System.out.println(heapList.get(a).data);
        }
        
        
    }
    
    public boolean isEmpty(){   //ARRAYLISTIN SIZE I 1 E ESIT VE KUCUKSE CUNKU 0.INDEXTE NULL VAR ISEMPTY TRUE DONDURUR
        return (heapList.size()<=1);
    }
    
    public int peek(){  //HEAP YAPISINDAKI ROOT UN VERISI GONDERILIR UYGUN DURUMDA
        if(!isEmpty()) return heapList.get(1).getData();
        else return -1;
    }
    
    public class Node{  //NODE CLASSI
        private int data;       //INT YAPISINDA VERI   
        
        public Node(int data){  //CONSTRUCTOR
            this.data = data;
        }

        public int getData() {  //GETTER SETTER VE TO STRING METODLARI
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }
        
        @Override
        public String toString(){
            return String.valueOf(data);
        }

    }
    
    
}
