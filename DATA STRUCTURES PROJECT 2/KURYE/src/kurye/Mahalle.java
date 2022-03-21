
package kurye;

import java.util.ArrayList;
import java.util.List;

public class Mahalle {  //ARRAYLISTE DOLDURULACAK NESNELER BURADA OLUSTURULUR. ICINDE TESLIMATLARDAN OLUSAN GENERIC LIST VE MAHALLE ADI BULUNUR
    
    private String mahalleAdi;  //MAHALLE CLASSINA AIT DEGISKENLER
    private ArrayList<Teslimat> genericList = new ArrayList<>(); //JAVADA GENERIC LIST ARRAYLIST KULLANILARAK YAPILDIGI ICIN BU SEKILDE YAPTIM FORUMDA DA AYBARS HOCA BU SEKILDE YAPABILRSINIZ DEMISTI
    
    public Mahalle(String mahalleAdi , int teslimatSayisi){ //MAHALLE CLASSINA AIT CONSTRUCTOR. ICINDE MAHALLE ADI ATAMASI YAPILIR VE TESLIMAT SAYISI KADAR TESLIMAT CLASSINDAN NESNE OLUSTURULUP GENERIC LISTE EKLENIR
        this.mahalleAdi = mahalleAdi;
        
        for(int a = 0 ; a<teslimatSayisi;a++){
            genericList.add(new Teslimat());
        }
        
        
    }

    public String getMahalleAdi() { //GETTER VE SETTER
        return mahalleAdi;
    }

    public void setMahalleAdi(String mahalleAdi) {
        this.mahalleAdi = mahalleAdi;
    }

    public List<Teslimat> getGenericList() {
        return genericList;
    }

    public void setGenericList(ArrayList<Teslimat> genericList) {
        this.genericList = genericList;
    }

    
    
    public String teslimatYazdirilmasi(){   //HER MAHALLENIN TESLIMAT NESNELERININ YAZDIRILMASI TO STRING METODUNDA KULLANILIYOR
        String metin= "";
        for(Teslimat teslimat : genericList){
            metin +=teslimat.toString()+" ";
        }
        return metin;
    }
        
    
    @Override
    public String toString(){   // TO STRING METODU
        return "Mahalle Adi: " + mahalleAdi + "\nYemekler;\n" +teslimatYazdirilmasi();
                
                
                
        
            
        }
        
}
