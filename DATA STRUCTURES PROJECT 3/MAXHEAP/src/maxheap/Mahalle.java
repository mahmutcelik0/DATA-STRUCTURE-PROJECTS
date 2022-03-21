
package maxheap;


public class Mahalle {  //HEAP E EKLENECEK MAHALLE NESNELERININ OLUSTURULDUGU CLASS
    
    private String mahalleAdi;  //MAHALLE ADI VE NUFUSU VERILERI BULUNUYOR
    private int mahalleNufusu;
    
    public Mahalle(String mahalleAdi , int mahalleNufusu){  //CONSTRUCTOR 
        this.mahalleAdi = mahalleAdi;
        this.mahalleNufusu = mahalleNufusu;
    }

    public String getMahalleAdi() { //GETTER SETTER VE TOSTRING METODLARI
        return mahalleAdi;
    }

    public void setMahalleAdi(String mahalleAdi) {
        this.mahalleAdi = mahalleAdi;
    }

    public int getMahalleNufusu() {
        return mahalleNufusu;
    }

    public void setMahalleNufusu(int mahalleNufusu) {
        this.mahalleNufusu = mahalleNufusu;
    }
    
    @Override
    public String toString(){
        return "Mahalle ADI: " + mahalleAdi+
                " Mahalle NÜFUSU: " + mahalleNufusu;
    }
    
    
}
