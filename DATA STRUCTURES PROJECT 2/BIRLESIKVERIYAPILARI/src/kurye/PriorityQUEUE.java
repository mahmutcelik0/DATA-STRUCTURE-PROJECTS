package kurye;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mahmut
 */
public class PriorityQUEUE {
    ArrayList<Mahalle> priorityQUEUEList ;  //ISTENILDIGI GIBI ICINDE C# TAKI LIST JAVADAKI ARRAYLIST HAZIR VERI YAPISI KULLANILMISTIR LISTENIN DEGISKEN ADI ATANIYOR VE GEREKLI OZELLIKLER BELIRLENIYOR
    
    private int elementNumber;
    
    
    
    public PriorityQUEUE(){ //CLASSIN CONSTRUCTORU QUEUE A BENZER ATAMALAR YAPILIYOR OLUSTURULAN priorityQUEUEList NESNESİ DE BELLEKTE ARRAYLIST OLUSTURULUP ATANIYOR
        this.priorityQUEUEList = new ArrayList<>();
        
        this.elementNumber =0;
        
    }
    
    public void enQueue(Mahalle eklenecekMahalle){  //ENQUEUE METODU ILE OLUSTURULAN ARRAYLISTE ELEMAN EKLENECEK GELEN ELEMAN OLUSTURULAN ARRAYLISTIN SONUNA EKLENIR
        priorityQUEUEList.add(eklenecekMahalle);
        elementNumber++;
    }
    
    public Mahalle deQueue(){   //OLUSTURULAN ARRAYLISTTEN EN COK TESLIMAT YAPILAN MAHALLEYI BULUP ARRAYLISTTEN CIKARAN METOD
        Mahalle silinecekMahalle = priorityQUEUEList.get(0);    //ARRAYLISTIN ILK ELEMANINI ALIR EGER 1DEN FAZLA ELEMAN VARSA IF CALISIR VE IF ICINDEKI FOR DONGUSUYLE ARRAYLIST DOLASILIR. GET GENERIC LIST ILE KARSILASTIRMA YAPILARAK EN COK TESLIMAT YAPILAN MAHALLE BULUNUR
        if(priorityQUEUEList.size()>1){
            int maxTeslimatSayi =0;
            for(Mahalle mahalleler : priorityQUEUEList){
                if(mahalleler.getGenericList().size()>maxTeslimatSayi){
                    silinecekMahalle = mahalleler;
                    maxTeslimatSayi = mahalleler.getGenericList().size();
                    
                }
            }
        }
        priorityQUEUEList.remove(silinecekMahalle); // EN COK TESLIMAT YAPILAN MAHALLE ARRAYLISTTEN SILINIR
        //System.out.println("SİLİNEN MAHALLEYE YAPILAN TESLIMAT ADEDI: "+silinecekMahalle.getGenericList().size()); BENIM ICIN GEREKLIYDI
        return silinecekMahalle;    //EN COK TESLIMAT YAPILAN MAHALLE GERI GONDERILIR
        
    }
    
    public boolean isEmpty(){   //ARRAYLISTIN BOS OLUP OLMADIGINI OGRENMEMIZI SAGLAYAN METOD
        return (priorityQUEUEList.size()==0);
    }  
}
