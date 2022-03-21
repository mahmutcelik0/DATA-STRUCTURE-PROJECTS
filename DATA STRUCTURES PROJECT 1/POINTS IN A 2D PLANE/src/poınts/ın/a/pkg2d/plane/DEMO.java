/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poınts.ın.a.pkg2d.plane;

import java.util.ArrayList;

/**
 *
 * @author Mahmut
 */
public class DEMO {

    /**
     * @param args the command line arguments
     */
    
    //PROJEDE KULLANILACAK DEGERLER ASAGIDA URETILMISTIR
    static final int noktaSayisi= 50;   //proje dokumanındaki n değerine karsılık gelir
    
    static final int tur = 10;  //tur sayisi
    
    static final int width = 100;   //genişlik
    
    static final int height = 100;  //yükseklik
    
    static final int koordinatSayisi = 2; // koordinat sayisi x y koordinatlari
    
    
    static ArrayList<Integer> secilenNoktalar = new ArrayList<Integer>();
    
    
    public static void main(String[] args) {
        
        double[][] MATRIS = new double[noktaSayisi][koordinatSayisi];
        
        //1.a BASLANGIC
        noktaUretipMatriseEkleme(MATRIS);
        matrisYazdirma(MATRIS);
        //1.a BITIS
        
        //1.b BASLANGIC
        double[][] DISTANCEMATRIS = new double[noktaSayisi][noktaSayisi];
        distanceMatrisElemanEkleme(MATRIS, DISTANCEMATRIS);
        uzaklikMatrisiniYazdir(DISTANCEMATRIS);
        
        //1.b BITIS
        
        //1.c BASLANGIC
        
        
        noktalarinNearestNeighorMetoduylaDolas(DISTANCEMATRIS);
        
        
        
        
        //**1.C BITIS
        
        
        
    }
    
    
    public static void noktaUretipMatriseEkleme(double[][] MATRIS ){    //Rastgele nokta üretip matrise ekleyen metod
        for(int a = 0 ; a<noktaSayisi ; a++){
            MATRIS[a][0] = Math.random()*width;
            MATRIS[a][1] = Math.random()*height;
        }
    }
    
    public static void matrisYazdirma(double[][] MATRIS){
        System.out.println("RASTGELE URETILEN NOKTALARIN KOORDINATLARI\n");
        for(int a = 1 ; a<=MATRIS.length;a++){
            
            System.out.print(a);
            System.out.printf(".Noktanın \tX: %2.2f",MATRIS[a-1][0]);
            System.out.printf(" \tY: %2.2f",MATRIS[a-1][1]);
            System.out.println("");
            
            
            
        }
        
    }
    
    
    
    
    public static void distanceMatrisElemanEkleme(double[][] MATRIS , double[][] DISTANCEMATRIS){   //DISTANCEMATRISINE ELEMAN EKLEYEN METOD
        for(int a = 0; a<DISTANCEMATRIS.length;a++){
            for(int b = 0; b< DISTANCEMATRIS.length ; b++){
                DISTANCEMATRIS[a][b] = oklidUzakligi(MATRIS[a][0], MATRIS[b][0], MATRIS[a][1], MATRIS[b][1]);
            }
        }
    }
    
    public static double oklidUzakligi(double x1, double x2 , double y1, double y2){ //OKLID UZAKLIGININ HESAPLANMASI
        double mesafe ;
        mesafe = Math.sqrt((Math.pow((x2-x1),2) + Math.pow((y2-y1),2)));
        return mesafe;  
    }
    
    public static void uzaklikMatrisiniYazdir(double[][] DISTANCEMATRIS){   //MATRISI YAZDIRAN METOD
        System.out.println("\n\n UZAKLIK MATRISI\n");
        for(int a = 0 ; a<DISTANCEMATRIS.length;a++){
           
            if(a==0){
                for(int x=0; x<DISTANCEMATRIS.length ; x++){
                    System.out.printf("%7d",x);  
                }
            }
            System.out.println("");
            
            System.out.printf("%2d",a);
            
            for(int b = 0 ; b<DISTANCEMATRIS.length; b++){
                System.out.printf("%7.1f",DISTANCEMATRIS[a][b]);
            }
        }
        System.out.println("");
        
        
    }
    
    
    
    
    
    public static void noktalarinNearestNeighorMetoduylaDolas(double[][] DISTANCEMATRIS){
        
        for(int a = 1 ; a<= tur ; a++){
            int secilenNokta = rastgeleNoktaSecme();
            
            boolean[] noktayaUgramaKontrol = new boolean[noktaSayisi];  //
            
            double yolUzakligi = 0d;
            
            String yolRotasi = "- TUR ROTASI: " + secilenNokta;
            
            double enYakinNoktayaOlanMesafe = 0d;
            
            for(int kalanNoktalar = noktaSayisi-1; kalanNoktalar>0 ; kalanNoktalar--){
                
                int enYakinNoktaIndex = -1;
                double maxDistance = enUzakMesafe(DISTANCEMATRIS);
             
                
                
                for(int arananNoktaIndex = 0 ; arananNoktaIndex<noktaSayisi;arananNoktaIndex++){
                    double geciciUzaklik = DISTANCEMATRIS[secilenNokta][arananNoktaIndex];
                    
                    
                    if(geciciUzaklik !=0 && !noktayaUgramaKontrol[arananNoktaIndex] && geciciUzaklik<=maxDistance){
                        enYakinNoktaIndex = arananNoktaIndex;
                        enYakinNoktayaOlanMesafe = geciciUzaklik;
                        
                        maxDistance = geciciUzaklik;
                        
                        
                    }
                    
                    
                }
                
                
                yolUzakligi += enYakinNoktayaOlanMesafe;
                noktayaUgramaKontrol[secilenNokta] = true;
                
                yolRotasi += " - " +enYakinNoktaIndex;
                secilenNokta = enYakinNoktaIndex;
                
                
                
            }
            turBilgileriBastir(a ,yolUzakligi, yolRotasi);

            
            
            
        }
           
    }
    
    
    public static int rastgeleNoktaSecme(){
        
        int rastgeleSayiIndex;
        
        do{
            rastgeleSayiIndex = (int)(Math.random()*noktaSayisi);            
        }while(secilenNoktalar.contains(rastgeleSayiIndex));
        
        secilenNoktalar.add(rastgeleSayiIndex);
        
        return rastgeleSayiIndex;
    }
    
    public static double enUzakMesafe(double[][]DISTANCEMATRIS){
        double enUzakMesafe = -1d;
        
        for (int satir = 0; satir < DISTANCEMATRIS.length; satir++){
            for (int sutun = 0; sutun < DISTANCEMATRIS.length; sutun++){
                    
                double suankiMesafe = DISTANCEMATRIS[satir][sutun];
                
                if (suankiMesafe >= enUzakMesafe) {
                    
                    enUzakMesafe = suankiMesafe;
                    
                }
            }
        }
        
        return enUzakMesafe;
    }
    
    
    
    
    public static void turBilgileriBastir(int turNumarasi , double yolUzakligi , String yolRotasi){
        System.out.println("TUR NUMARASI: " + turNumarasi);
        System.out.println(yolRotasi);
        System.out.printf("TOPLAM YOL UZUNLUGU: %.2f" , yolUzakligi);
        System.out.println("");
        
        
        
    }
    
    
    
    
}
