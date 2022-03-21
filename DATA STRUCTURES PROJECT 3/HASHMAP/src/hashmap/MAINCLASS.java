
package hashmap;

import java.util.HashMap;
import java.util.Scanner;

public class MAINCLASS {
    
    //SECTİGİM MAHALLE ADLARI VE NUFUSLARINI BIRLESTIRMEDEN ONCE DIZI ICERISINDE SAKLADIM ELEMANLARI BURADAN ALACAGIM
    static final String[] mahalleAdlari = {"ERZENE", "KAZIMDİRİK","YEŞİLOVA","ATATÜRK","İNÖNÜ","MEVLANA","EVKA 3","ERGENE","KIZILAY","MERİÇ"};
    static final int[] mahalleNufuslari ={35135,33934,31008,28912,25778,25492,20445,11245,15795,8394};
    static int nufusArttirmaMiktari = 1;    //DOKUMANDA NUFUS ARTTIRMA MIKTARINI BURAYA ATADIM
    
    
    //MAIN METODU
    public static void main(String[] args){
        
        //HASHMAP TEN KEY I STRING VALUE SU INTEGER OLACAK NESNE OLUSTURDUM
        HashMap<String,Integer> myHashMap = new HashMap<>();
        
        //HASHMAP E ELEMANLARIN EKLENDIGI METOD
        hashmapElemanlariEkleme(myHashMap);
        
        //HASHMAPIN NUFUS DEGISTIRILMEDEN ONCE YAZDIRILMASI
        System.out.println("VERILEN BAS HARFE GORE ILGILI MAHALLELERIN NUFUSLARININ 1'ER ARTTIRILMADAN ONCEKI NUFUSLARI");
        hashMapElemanlariYazdirma(myHashMap);
        
        //HASHMAPTE KONSOLDAN ALINAN BAS HARFE GORE BULUNAN MAHALLELERIN NUFUSLARININ 1 ARTTIRILDIGI METOD
        basHarfeGoreNufusArttirma(myHashMap);
        

        
        
    }
    
    
    // FOR DONGUSUYLE ILK BASTA OLUSTURULAN MAHALLELERIN SAKLI OLDUGU DIZIDEKI ELEMANLARI HASHMAP E PUT METODU ILE EKLEYEN METOD
    public static void hashmapElemanlariEkleme(HashMap<String,Integer> myHashMap){
        for(int a = 0; a<mahalleAdlari.length ;a++){    //FOR DONGUSU
            myHashMap.put(mahalleAdlari[a],mahalleNufuslari[a]);
        }
    }
    
    
    //KONSOLDAN SCANNER YARDIMIYLA HARF ALIP BU HARFI BUYULTUP SONRASINDA FOREACH DONGUSUYLE HASHMAPTEKI KEY DEGERLERINI DOLASARAK UYGUN MAHALLELERIN NUFUSLARINI 1 ARTTIRAN METOD
    public static void basHarfeGoreNufusArttirma(HashMap<String,Integer> myHashMap){
        
        //SCANNER
        Scanner scanner = new Scanner(System.in);
        
        //HARF ALIMI
        System.out.print("UYGUN MAHALLELERIN NUFUSLARINI ARTTIRMAK ICIN HARF GIRINIZ: ");
        char basHarf = scanner.next().toUpperCase().charAt(0);  //BAS HARFIN OLUSTURULMASI
        

        
        int arttirilanSehirSayisi =0;
        for(String keys : myHashMap.keySet()){  //FOR EACH DONGUSUYLE HASHMAPTEKI KEYSET DOLASILIR VE OLUSTURULAN BAS HARF KEYSETTEKI MAHALLELERIN ILK HARFLERINE ESITSE O MAHALLENIN NUFUSU 1 ARTTIRILIR
            if(keys.charAt(0) ==basHarf){
                myHashMap.replace(keys, myHashMap.get(keys)+nufusArttirmaMiktari);
                arttirilanSehirSayisi++;
            }
        }
        if(arttirilanSehirSayisi ==0){  //SEHIR NUFUSU ARTTIRILMAMISSA 
            System.out.println("HashMap'te GİRDİĞİNİZ BAS HARFTE MAHALLE BULUNMAMAKTADIR.");
        }
        else{   //SEHIR NUFUSU ARTTIRILMISSA SEHIRLER YAZDIRILIR
            System.out.println("VERILEN BAS HARFE GORE ILGILI MAHALLELERIN NUFUSLARININ 1'ER ARTTIRILDIKTAN SONRAKI NUFUSLARI");
            hashMapElemanlariYazdirma(myHashMap);


        }
        
    }
    
    public static void hashMapElemanlariYazdirma(HashMap<String,Integer> myHashMap){    //FOR EACH DONGUSUYLE HASH MAPTEKI KEY VE VALUE DEGERLERI YAZDIRILIR
        for(String keys: myHashMap.keySet()){
            System.out.print("Mahalle ADI: "+ keys+"\t");
            System.out.println("NUFUSU: "+ myHashMap.get(keys));
        }
    }
}
