
package developıng.a.sımple.artıfıcıal.neuron.and.classıfıcatıon;


public class DEMO {

    static final int[] x1veriSeti = {6,2,-3,-1,1,-2,-4,-6}; //PROJE BOYUNCA KULLANILACAK VERILERIN UYGUNLUK ACISINDAN STATIC FINAL OLARAK TANIMLADIM HERHANGI BIR DEGISIKLIK ICIN BURADAN DEGISTIRILMESI GEREKIYOR
    static final int[] x2veriSeti = {5,4,-5,-1,1,7,-2,3};
    
    static final int[] x1TestVeriSeti = {-2,-3,7,6,-2};
    static final int[] x2TestVeriSeti = {-5,-1,4,-1,3};
    
    static final double lambda = 0.05;
    
    static final int EPOCH = 10;   
    
    
   
    public static void main(String[] args) {    //MAIN CLASSI
        
        Neuron noron = new Neuron();    //NEURON SINIFINDAN BIR TANE NORON NESNESI OLUSTURDUM
        
        
        
        System.out.println(noron.toString());   //RASTGELE URETILEN ILK AGIRLIKLARI GORMEK ICIN KULLANILABILIR
        

        for(int a = 0; a<EPOCH ; a++){  //DOKUMANDA VERILEN EPOCH DEGERI KADAR DONECEK FOR DONGUSU VE HER EPOCH ICERISINDE DE VERI SETININ UZUNLUGU KADAR DONECEK BIR FOR DONGUSU BULUNUYOR
            noron.setDogruTahminSayisi(0);  //HER EPOCH TURUNDA KAC TANE VERININ DOGRU OLDUGUNU SAYABILMEK ICIN NORON NESNESININ ICINDEKI DOGRU TAHMIN SAYISI 0 LANIR VE EPOCH SONUCUNDA BU SAYI O EPOCH ICIN DOGRU TAHMIN SAYISINI VERIR

            System.out.println((a+1)+".EPOCH ICIN CIKAN SONUCLAR\n");   //zorunlu DEGIL

            
        //VERI SETINDEN NORONA GONDERILECEK INPUT DEGERLERININ BULUNMASI ICIN VERI SETINDEN ELEMANI IKI TANE DOUBLE DEGISKENE ATAMA

            
            for(int b=0; b<x1veriSeti.length ; b++){    // VERI SETININ UZUNLUGU KADAR DONECEK FOR DONGUSU HER VERI ICIN INPUTLAR AYARLANIR VE TARGET OUTPUT KARSILASITIRILIP UYGUN ISLEMLER ESIK FONKSIYONUNA GORE YAPILIR
                System.out.println((a+1)+".EPOCH "+" TUR: " + (b+1));

        
                double firstInputDeger = (double)x1veriSeti[b]/10;    //VERI SETINDEN GELECEK INPUT DEGERLERININ NORONA 0, LU SEKILDE AKTARILMASI
                double secondInputDeger = (double)x2veriSeti[b]/10;

                noron.noronVeriSetiAyarlama(firstInputDeger,secondInputDeger);  //NORON ICINDEKI METOD SAYESINDE NORONUN TUR ICINDEKI INPUT DEGERLERI DEGISTIRILIR

                noron.noronEsikFonksiyonu(targetHesaplama(x1veriSeti[b], x2veriSeti[b]),lambda);    //NORONUN ESIK FONKSIYONUNUN GERCEKLESITIRILMESI


                
                 //GEREKSIZ KISIM

                    noron.targetVeOutputYazdirma(targetHesaplama(x1veriSeti[b], x2veriSeti[b]) , lambda);   
                    System.out.println(noron.toString());


                    System.out.println("");
                    //**GEREKSIZ BITIS
     
            }  
            //HER EPOCH SONUNDA CALISMASINI ISTEDIM VERILERI DAHA IYI INCELEYEBILMEK ICIN    
            System.out.println("\nYUZDELIK ORAN");

            ACCYAZDIRMA(noron.getDogruTahminSayisi(), x1veriSeti.length);
            System.out.println("");

            

        }

        testKismi(noron);   //NORON EGITIM ASAMASI BITTIKTEN SONRA NORONA TEST VERILERI GONDERILMESI VE BU VERILERE GORE DOGRULUK YUZDESI YAZDIRILMASI ICIN METODA GIDIS

    }
    
    
    public static void testKismi(Neuron noron){ //NORON EGITIMI BITTIKTEN SONRA KENDI OLUSTURDUGUMUZ TEST VERILERINI ESIK FONKSIYONUNA GIRMEYECEK SEKILDE SADECE TARGET VE OUTPUTLARI KARSILASTIRARAK TEST VERILERINDEKI ACC YUZDELIGINI HESAPLAYACAK METOD
        
        int testVerileriDogruSayisi = 0;
        
        for(int a =0; a<x1TestVeriSeti.length;a++){ //TEST VERILERININ UZUNLUGU KADAR CALISACAK FOR DONGUSU

            double firstInputDeger = (double)x1TestVeriSeti[a]/10;    
            double secondInputDeger = (double)x2TestVeriSeti[a]/10;
            
            noron.noronVeriSetiAyarlama(firstInputDeger,secondInputDeger);  //NORON ICINDEKI METOD SAYESINDE NORONUN TUR ICINDEKI INPUT DEGERLERI DEGISTIRILIR
            
            /*
            //ZORUNLU OLMAYAN KISIM
            System.out.println("**************TEST****************");
            System.out.println(noron.toString());
            noron.targetVeOutputYazdirma(targetHesaplama(x1TestVeriSeti[a], x2TestVeriSeti[a]), lambda);
            
            //**
            */
            int testSayi;   //NORONUN KAC TANE VERI ICIN SONUCU OUTPULAR TARGETLA AYNI OLDUGUNDA 1 OLACAK SAYI
            testSayi = noron.noronTestKismi(targetHesaplama(x1TestVeriSeti[a], x2TestVeriSeti[a]));
            
            if(testSayi ==1){   //TARGET OUTPUT A ESIT OLDUGUNDA TEST VERILERI DOGRU SAYISIN ++ OLUR YANI TEST SAYISI 1 OLDUGUNA CALISACAK BLOK
                testVerileriDogruSayisi++;
            }
        }
        System.out.println("TEST VERILERI DOGRULUK ORANI: %"+ ACCHESAPLAMA(testVerileriDogruSayisi, x1TestVeriSeti.length) ); //TEST VERILERI DOGRULUK ORANI YAZDIRILMASI
    }
    
    
    
    
    
    public static double ACCHESAPLAMA(int sayi , int veriSetiLength){   //yüzdelik olarak veri setindeki elemanları test ettıkten sonra dogru sayısına oranını yüzdelik olarak hesaplar
        return ((double)sayi/veriSetiLength)*100;   //dogru bilinen veri sayısının veri sayısına yuzdelik oranı
    }
    
    
    public static void ACCYAZDIRMA(int sayi , int veriSetiLength){  //yuzdelik olarak hesaplanan acc değerini yazdırır
        double yuzdelikDeger = ACCHESAPLAMA(sayi, veriSetiLength);
        System.out.println("ACC YUZDELIK ORANI: %" + yuzdelikDeger);
    }
    
    
    public static int targetHesaplama(int a , int b){   //VERI SETINDEKI ORNEK VERILERIN TARGETLARINI HESAPLAYAN METOD BURADA METODDA HESAPLANIYOR VE NORON CLASSINA GONDERILIYOR 
        // TOPLAMLARI 0DAN BUYUK OLDUGUNDA 1 KUCUK OLDUGUNDA -1 HERHANGİ BİR HATA DURUMUNDA 0 GONDERIYOR
        
        if(a+b >0){
            return 1;
            
        }
        else if(a+b <0){
            return -1;
        }
        
        return 0; 
        
        
        
    }
    
    
    
    
}
