
package bubblesort;

import java.util.Random;
//SIMPLE SORTING DEN BUBBLE SORT UN KODUNU YAZDIM 


public class MAINCLASS {

    static final int diziBoyutu =10;    //ISTEDIGIMIZ DEGERLER GIRILEBILIR BEN BU DEGERLERI GIRDIM
    static final int sayiAraligi = 100;
    
    public static void main(String[] args) {
        
        int[] array = new int[diziBoyutu];  //DIZI BOYUTUNDA YANI KAC TANE SAYI OLACAKSA ONLARIN BOYUTUNDA DIZI OLUSTURULDU
        
        Random r = new Random();
        
        for(int a=0 ; a<array.length ;a++){ //RANDOM SAYILAR OLUSTURULARAK FOR DONGUSUYLE DIZIYE EKLENDI
            array[a] = r.nextInt(sayiAraligi);
        }
        
        System.out.println("-----DIZI SIRALANMADAN ONCEKI GOSTERIMI-----"); 
        printTheArray(array);
        bubbleSort(array);
        System.out.println("-----DIZI SIRALANDIKTAN SONRAKI GOSTERIMI-----");
        printTheArray(array);
        
        
    }
    
    public static void printTheArray(int[] array){  //DIZININ FOR DONGUSU KULLANILARAK ELEMANLARININ YAZDIRILMASI
        for(int a=0; a<array.length ;a++){
            System.out.println("DİZİNİN "+(a+1)+". ELEMANI: " + array[a]);
        }
    }
    
    public static void bubbleSort(int[] array){ //BUBBLE SORTTA ELEMANLAR IKILI OLARAK KARSILASTIRILIR VE 1 TUR SONUCUNDA 1 ELEMAN GITMESI GEREKEN YERE YANI SONA GIDER BU DURUMDA CHANGED TRUE OLUR
        //CHANGED YANI LISTE SIRALI OLDUGUNDA FALSE VERECEGI ICIN WHILE DONGUSUYLE ELEMANLAR SIRALANISA KADAR CALISIR VE SONUCUNDA SIRALANMIS OLURLAR
        
        boolean isChanged =true;
        
        while(isChanged){   //TRUE OLDUGU SURECE CALISACAK WHILE DONGUSU
            isChanged =false;   //FOR DONGUSUNE GIRMEDEN ONCE FALSE ATANIR DONGUDEKI IF BLOGUNA GIRMEZSE SIRALANMIS OLUR FALSE AYNEN KALIR VE WHILE DONGUSU DE BITMIS OLUR
            for(int a=0 ; a<array.length-1 ;a++){   //ELEMANLARIN DOLASILMASI FAKAT UZUNLUGUN 1 KUCUGU KADAR CALISIR CUNKU SON KARSILASTIRMADA SONDAN BIR ONCEKI VE SONUNCU ELEMAN KARSILASTIRILIR TEKRAR KARSILASTIRILMASI YAPILIRSA SONUNCU ELEMANLA HERHANGI BIRISI KARSILASTIRILAMAZ BUNDAN DOLAYI 1 EKSIGI
                if(array[a] > array[a+1]){  //EN KUCUK ELEMANIN SOLDA OLMASINI ISTEDIGIM ICIN SOLDAKI ELEMAN BUYUKSE SAGDAKINDEN BLOK CALISIR
                    int temp = array[a+1];
                    array[a+1] = array[a];  //YER DEGISTIRME ICIN SAGDAKI ELEMANIN KAYBOLMAMASI ICIN SAGDAKI ELEMAN DEGISKENE ATANDI VE SOLDAKI SAGA GECIRILDI SOLDAKININ YERINE DE DEGISKENDEKI VERI KULLANILARAK GECIRILIR
                    array[a] = temp;
                    isChanged =true;    //YER DEGISTIRME GERCEKLESTIGI ICIN TRUE YA DONER
                    

                }
            }
            //printTheArray(array);   //DEBUG ICIN KULLANIYORUM

        }
        
    }
    
    
}
