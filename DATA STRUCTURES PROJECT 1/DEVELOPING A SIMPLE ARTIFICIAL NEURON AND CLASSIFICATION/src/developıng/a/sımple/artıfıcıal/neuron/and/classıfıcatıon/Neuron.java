
package developıng.a.sımple.artıfıcıal.neuron.and.classıfıcatıon;

public class Neuron {
    
    private double firstInput;  //VERI SETINDEN GELICEK VERILERIN TUTULACAGI DEGISKENLER
    private double secondInput;
    
    private double firstWeight; //ILK BASTA RANDOM METODUYLA OLUSTURULACAK VE SONRASINDA ESIK FONKSIYONUNA GORE ARTIP AZALACAK NORONUN AGIRLIK DEGISKENLERI
    private double secondWeight;
    
    private int dogruTahminSayisi;  //HER EPOCH TURU SONUNDA 0 LANACAK VE HER TURDA NORONUN KAC DEFA DOGRU BULDUGUNU TUTACAK DEGISKEN
            
    public Neuron(){    //NORON CONSTRUCTOR U NORONA BASLANGICTA INPUT DEGERLERI OLARAK 0 AGIRLIK OLARAK 1 İLE -1 ARASINDA RANDOM BIR DEGER ATANIR
        firstInput = 0.0;
        secondInput = 0.0;
        
        firstWeight = (Math.random()*2 -1);
        secondWeight = (Math.random()*2 -1);
        
        dogruTahminSayisi = 0;
        
    }
    
    public double noronToplamaIslevi(){//NORONA GELEN VERILERDEN OLUSAN INPUTLAR VE AGIRLIKLARI CARPILARAK DEGERLER URETILIP TOPLANIYOR VE CIKAN SONUC NEGATIFSE OUTPUT -1 POZITIFSE OUTPUT 1 OLUYOR
        double deger1;
        double deger2;
        
        deger1 = getFirstInput()*getFirstWeight();
        deger2 = getSecondInput()*getSecondWeight();
        
        return deger1+deger2;
    }
    
    //NORONDAN CIKAN OUTPU DEGER METODU
    public int noronOutputDegeri(){     //TOPLAMAISLEVINDEN CIKAN DEGERLER ILE OUTPUT UN DURUMU RETURNLE GONDERILIYOR
        if(noronToplamaIslevi()<0){
            return -1;
        }
        else if(noronToplamaIslevi()>0){
            return 1;
        }
        else{
            return 0;
        } 
    }
    
    //AGIRLIK DEGISTIRME MIKTAR FORMULU
    public double agirlikDegistirmeMiktari(int target, int output , double lambda , double input){  //DOKUMANDA VERILEN AGIRLIK DEGISTIRME MIKTARININ HESAPLANMASI
        return (lambda * (target - output) * input);
    }
    
    //NORON VERI SETI AYARLAMA METODU
    public void noronVeriSetiAyarlama(double x1, double x2){    //2nci for dongusunde gelen verilerin nörondaki değişkene aktarılması
        setFirstInput(x1);
        setSecondInput(x2);
        
    }
    
    //NORON ESIK FONKSIYONU
    public void noronEsikFonksiyonu(int target , double lambda){    //NORONDA HESAPLANAN OUTPUT DEGERI VE GELEN TARGET DEGERININ SONUCLARINA GORE BIRBIRLERINE ESITSE DOGRU TAHMIN SAYISI 1 ARTTILIR BIRBIRLERINDEN FARKLIYSA AGIRLIK DEGISTIRME MIKTARI KADAR NORON AGILIRIGI ARTTIRILIR
       int outputDegeri = noronOutputDegeri();
       if((outputDegeri==-1 && target ==1)|| (outputDegeri ==1 && target ==-1)){
           setFirstWeight((getFirstWeight()+agirlikDegistirmeMiktari(target, outputDegeri, lambda, getFirstInput())));
           setSecondWeight((getSecondWeight() + agirlikDegistirmeMiktari(target, outputDegeri,lambda, getSecondInput() )));
       }

       else if(target ==1 && outputDegeri==1 || target ==-1&& outputDegeri==-1){
           dogruTahminSayisi++;
       }   
    }
    
    //TEST KISMI
    public int noronTestKismi(int target){  //NORON TEST KISMI ICIN GEREKLI METOD TARGET VE OUTPUT ESIT OLUDUGUNDA 1 GERI GONDERIR BU  METODDA ESIK FONKSIYONU KULLANILMAZ YANI AGIRLIKLARDA HERHANGI BIR DEGISIKLIK YAPILMAZ
        int outputDegeri = noronOutputDegeri();
        
        int sayi =0;
        
        if(outputDegeri ==-1&&target==1){
            sayi= 0;
        }
        else if(outputDegeri ==1&& target ==-1){
            sayi= 0;
        }
        else if(target == outputDegeri){
            sayi= 1;
        }
        
        return sayi;
    }
    
    
    public double getFirstInput() { //GETTER VE SETTERLAR
        return firstInput;
    }

    public void setFirstInput(double firstInput) {
        this.firstInput = firstInput;
    }

    public double getSecondInput() {
        return secondInput;
    }

    public void setSecondInput(double secondInput) {
        this.secondInput = secondInput;
    }

    public double getFirstWeight() {
        return firstWeight;
    }

    public void setFirstWeight(double firstWeight) {
        this.firstWeight = firstWeight;
    }

    public double getSecondWeight() {
        return secondWeight;
    }

    public void setSecondWeight(double secondWeight) {
        this.secondWeight = secondWeight;
    }

    public int getDogruTahminSayisi() {
        return dogruTahminSayisi;
    }

    public void setDogruTahminSayisi(int dogruTahminSayisi) {
        this.dogruTahminSayisi = dogruTahminSayisi;
    }
    
    public String toString(){   //NORON CLASSI TOSTRING METODU
        return "INPUT 1: " +getFirstInput() + " AGIRLIK 1: " + getFirstWeight() +
                "\nINPUT 2: " + getSecondInput() + " AGIRLIK 2: " + getSecondWeight();
    }
    
    
    
    //ZORUNLU OLMAYAN KISIM
    public void targetVeOutputYazdirma(int target ,double lambda){  //TARGET VE OUTPUT YAZDIRMA
        
        System.out.println("TARGET: "+ target + " OUTPUT: " + noronOutputDegeri());
        System.out.println("BIRINCI ICIN AGIRLIK DEGISTIRME MIKTARI: " + agirlikDegistirmeMiktari(target, noronOutputDegeri(),lambda,getFirstInput()));
        System.out.println("IKINCI ICIN AGIRLIK DEGISTIRME MIKTARI: " + agirlikDegistirmeMiktari(target, noronOutputDegeri(), lambda, getSecondInput()));
    }  
    //**ZORUNLU OLMAYAN KISIM BITIS
    
    
    
    
    
    
    
}
