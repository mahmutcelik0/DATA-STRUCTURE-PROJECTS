package kurye;

import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mahmut
 */

public class Teslimat { //MAHALLE SINIFINDA BULUNACAK GENERIC LISTLERIN DOLDURULMASI ICIN GEREKLI NESNELER BURADA OLUSTURULUYOR YEMEKLER VE SIPARIS ADEDI BELIRLENIP NESNE OLUSTURULUYOR
    int maxSiparisAdedi = 100;  //MAX SIPARIS ADEDI 100 OLARAK ALDIM
    String[] yemekler = {"Pilav","Suşi","Türlü","Pizza","Tavuk Döner", "Patates Kızartması","Sosis","Baklava","Sütlaç","Hamsi Tava","Salata","Sucuklu Yumurta"};    //RASTGELE YEMEKLER

    private String yemekAdi;    //TESLIMAT CLASSININ DEGISKENLERI
    private int siparisAdedi;
    
    public Teslimat(){  //TESLIMAT CLASSININ CONSTRUCTOR U ICINDE RANDOM SINIFI KULLANILARAK YEMEK LISTESININ UZUNLUGUNDAN RASTGELE VE MAX YEMEK SIPARISINDEN RASTGELE 1 ER TANE SAYI SECILIYOR VE YEMEK, SIPARIS ADEDI BELIRLENMIS OLUYOR
        Random r = new Random();
        this.yemekAdi = yemekler[r.nextInt(yemekler.length)];
        this.siparisAdedi = r.nextInt(maxSiparisAdedi)+1;
        
    }

    public String getYemekAdi() {   //GETTER VE SETTER
        return yemekAdi;
    }

    public void setYemekAdi(String yemekAdi) {
        this.yemekAdi = yemekAdi;
    }

    public int getSiparisAdedi() {
        return siparisAdedi;
    }

    public void setSiparisAdedi(int siparisAdedi) {
        this.siparisAdedi = siparisAdedi;
    }

    @Override
    public String toString(){   //TO STRING METODU
        return "Yemek Adı: " + yemekAdi + " Sipariş Adedi: " + siparisAdedi;
        
        
    }


}
