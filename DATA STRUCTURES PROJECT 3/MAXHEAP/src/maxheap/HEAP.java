
package maxheap;

import java.util.ArrayList;

//MAXHEAP CLASSI
//PROJE ICIN GEREKLI OLAN KISIM BURASI
//MIN HEAP I KONUYU ANLAMAYA CALISIRKEN OLUSTURMUSTUM

public class HEAP { //HEAP CLASSI
    
    private ArrayList<Node> heapList;   //HEAPTEKI VERILERI ARRAYLISTTE SAKLAYARAK YAPTIM
    
    public HEAP(){  //CONSTRUCTOR
        heapList = new ArrayList<>();
    }
    
    
    public void add(Mahalle mahalle){   //HEAP E GELEN MAHALLE CLASSINDAN NESNENIN EKLENMESI
        Node newNode = new Node(mahalle);
        
        if(heapList.isEmpty()){ //LISTE BOSSA 0.INDEXE NULL 1.INDEXE GELEN MAHALLE NESNESI ARRAYLISTTE ADD METODU ILE EKLENIR
            heapList.add(null);
            heapList.add(1,newNode);
        }
        
        else{   //HEAPLIST BOS DEGILSE CALISACAK KISIM
            heapList.add(newNode);  //ARRAYLISTE ADD METODU ILE SONA DOGRU ELEMANLAR EKLENIR VE EKLENEN ELEMANLARIN HEAP YAPISINI BOZMAMASI ICIN YAPRAKTAN ROOT A DOGRU DUZENLENMESI GEREKIR
            yukariyaDogruDuzenleme();   //HEAPIN YUKARIYA DOGRU DUZENLENMESI
        }
        
    }
    
    public Mahalle delete(){    //HEAPTEN ELEMAN SILMEYI SAGLAYAN METOD
        
        if(heapList.size() ==2){    //HEAPTE 1 TANE ELEMAN VARSA CUNKU 0.INDEXE NULL ATAMISTIK CALISACAK METOD
            Node nodeToDelete = heapList.get(1);    //SILINECEK ELEMAN DEGISKENE ATANIR VE 1.INDEXTE ELEMAN SILINIP VERISI GONDERILIR
            heapList.remove(1);
            return nodeToDelete.getMahalle();
        }
        else if(heapList.size()<2){ //SIZE 2DEN KUCUKSE ELEMAN YOKTUR
            System.out.println("NO ELEMENT IN THE HEAP");
            return null;
        }
        
        Node nodeToDelete = heapList.get(1);    //YUKARIDAKI BLOKLARDAN RETURNLE CIKIS YAPMAZSA CALISACAK KISIMLAR
        int lastElementIndex = heapList.size()-1;   //SON EKLENEN ELEMANIN INDEXI ALINIR
        
        heapList.set(1,heapList.get(lastElementIndex) );    //ILK YANI ROOTTAKI ELEMAN DEGISKENE ATANMISTI BURADA ONUN YERINE SON YAPRAKTAKI ELEMAN GELIR
        heapList.remove(lastElementIndex);  //SON YAPRAKTAKI ELEMAN SUAN ROOTTA OLDUGU ICIN O KISIM SILINIR
        
        asagiyaDogruDuzenleme();    //HEAP YAPISI BOZULMAMASI ICIN ROOTTAKI ELEMAN COCUKLARIYLA KARSILASTIRILIP GEREKLI DEGISIKLIKLER YAPILARAK UYGUN DUZEN SAGLANIR
        
        return nodeToDelete.getMahalle();   //SILINEN ELEMANIN GONDERILMESI
        
    }
    
    private void yukariyaDogruDuzenleme(){  //ELEMAN EKLENDIGINDE MAXHEAP YAPISININ KORUNMASI ICIN GEREKLI OLAN METOD
        
        int lastElementIndex = heapList.size()-1;   //SON ELEMANIN INDEXI BULUNUR
        
        int parentIndex =lastElementIndex/2;    //PARENTININ INDEXI BULUNUR
        
        Node lastElement = heapList.get(lastElementIndex);
        
        while(lastElementIndex>0 && parentIndex>0 && heapList.get(parentIndex).getMahalle().getMahalleNufusu() < lastElement.getMahalle().getMahalleNufusu()){  //INDEXLER ARRAYLISTTEN TASMIYORSA VE YAPRAKTAKI ELEMANIN NUFUSU PARENTINDAN BUYUK OLDUGU SURECE CALISACAK WHILE DONGUSU
            //BUYUK OLDUKCA CALISACAK OLMASININ SEBEBI MAXHEAP YAPISINDA ROOTTA EN BUYUK ELEMAN BULUNUR
            heapList.set(lastElementIndex , heapList.get(parentIndex)); //PARENT ASAGI INDIRILIR VE INDEX DEGERLERI GUNCELLENIR
            lastElementIndex = parentIndex;
            parentIndex = parentIndex/2;
            
        }
        heapList.set(lastElementIndex, lastElement);    //WHILE DONGUSUNDEN CIKILNCA BULUNAN INDEX E YAPRAKTAKI ELEMAN EKLENIR
        
        
    }
    
    private void asagiyaDogruDuzenleme(){   //ROOTTAKI YANI MAXHEAPTEKI EN BUYUK ELEMAN SILININCE YERINE YAPRAKTAKI ELEMAN GETIRILIR VE YAPI TEKRARDAN DUZENLENIR
        int firstElementIndex =1;
        
        Node firstElement = heapList.get(firstElementIndex);    //ILK ELEMAN SUAN YAPRAKTAKI ELEMAN
        
        Node biggerChild = buyukCocukBulma(firstElementIndex);  //MAX HEAP YAPISINDA DAHA BUYUK OLAN  YUKARIDA OLACAGI ICIN BUYUK COCUK YUKARIYA GECER ONUN ICIN BUYUK COCUK BULUNUR
        
        int biggerChildIndex = heapList.indexOf(biggerChild);   //BUYUK COCUGUN INDEXI
        
        while(biggerChild !=null && firstElement.getMahalle().getMahalleNufusu() < biggerChild.getMahalle().getMahalleNufusu()){    //YAPRAGA GIDILMEMISSE VE BUYUK COCUGUN NUFUSU PARENTTAN BUYUK OLDUGU SURECE YER DEGISTIRILIR
            heapList.set(firstElementIndex, biggerChild);       //BUYUK COCUK YUKARIYA CIKTI
            heapList.set(biggerChildIndex, firstElement);       //PARENTI COCUGUN ESKI YERINE GECTI
            
            firstElementIndex = heapList.indexOf(firstElement);     //YENI INDEX DEGERLERINE GORE ILK BASTAKI PARENT TEKRAR COCUKLARIYLA KARSILASTIRILACAK BUNUN ICIN TEKRARDAN COCUKLARIN BUYUK OLANI BULUNUR
            firstElement = heapList.get(firstElementIndex);
            
            biggerChild = buyukCocukBulma(firstElementIndex);
            biggerChildIndex = heapList.indexOf(biggerChild);
        }
        
        
        
        
    }
    
    private Node buyukCocukBulma(int parentIndex){  //BUYUK COCUGUN BULUNDUGU METOD
        int leftChildIndex = 2*parentIndex; //FORMULE UYGUN SEKILDE COCUKLARIN INDEXLERININ BULUNMASI
        int rightChildIndex = 2*parentIndex +1;
        
        Node biggerChild;
        
        if((leftChildIndex >=heapList.size() || rightChildIndex >=heapList.size())) //ARRAYLISTTEN TASIYORSA NULL DONDURUR
            return null;
        
        if(heapList.get(leftChildIndex).getMahalle().getMahalleNufusu() > heapList.get(rightChildIndex).getMahalle().getMahalleNufusu()){   //SOLDAKI COCUGUN NUFUSU DAHA BUYUKSE BUYUK COCUK SOLDAKI OLUR
            biggerChild = heapList.get(leftChildIndex);
        }
        else if(heapList.get(leftChildIndex).getMahalle().getMahalleNufusu() < heapList.get(rightChildIndex).getMahalle().getMahalleNufusu()){  //SAGDAKI COCUGUN NUFUSU DAHA BUYUKSE BUYUK COCUK SAGDAKI OLUR
            biggerChild = heapList.get(rightChildIndex);
        }
        else{   //ELSE DURUMUNDE NULL DONDURUR
            return null;
        }
        
        return biggerChild; //BUYUK COCUGUN GONDERILMESI
    }
    
    
    
    
    public void heapElemanlariYazdirma(){   //FOR DONGUSUYLE HEAPTEKI ELEMANLAR ARRAYLISTTE DOLASILARAK YAZDIRILIR
        for(int a=1 ; a<heapList.size() ; a++){
            System.out.println(heapList.get(a).getMahalle().toString());
        }
        
    }
    
    
    public boolean isEmpty(){   //ARRAYLISTIN SIZE I 1E ESIT VE KUCUKSE TRUE DONDURUR CUNKU 0.INDEXE NULL EKLEMISTIK
        return (heapList.size()<=1);
    }
    
    public Mahalle peek(){  //ROOTTAKI ELEMANIN VERILERI GONDERILIR AMA DEGISIKLIK YAPILMAZ
        if(!isEmpty()) return heapList.get(1).getMahalle();
        else return null;
    }
    

    public class Node{  //NODE CLASSI
        private Mahalle mahalle;    //MAHALLE NESNESI
        
        public Node(Mahalle mahalle){   //CONSTRUCTOR VE GETTER SETTER
            this.mahalle = mahalle;
        }

        public Mahalle getMahalle() {
            return mahalle;
        }

        public void setMahalle(Mahalle mahalle) {
            this.mahalle = mahalle;
        }
        
        
    }
    
}
