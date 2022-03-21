
package tree;


public class MAINCLASS {
    
    static final int istenilenFiyat = 150;  //C SIKKI ICIN GEREKLI OLDUGUNDAN BURADA TANIMLADIM
    static final String[] mahalleAdlari = {"Evka 3","Özkanlar","Atatürk","Erzene","Kazımdirik"};    //DOKUMANDA VERILEN ORNEK MAHALLELERI DIZIYE EKLEDIM
    
    
    public static void main(String[] args) {
        TREE myTree = new TREE();   //TREE CLASSINDAN NESNE OLUSTURDUM
        
        for(String eklenecekMahalle : mahalleAdlari){   //OLUSTURULAN TREE YE ADD METODU KULLANILARAK MAHALLELER EKLENIYOR
            myTree.add(eklenecekMahalle);
        }
        
        
        
        System.out.println("----------DOKUMANDAKİ B MADDESİ İÇİN GEREKLİ ÇIKTILAR----------\n");
        myTree.agactakiTumBilgilerinYazdirilmasi(); //DERINLIK + TUM VERILER B  maddersi
        System.out.println("\n----------DOKUMANDAKI C MADDESİ İÇİN GEREKLİ ÇIKTILAR----------\n");
        myTree.dolasmaVeFiyatUstuYazdirma("Evka 3", istenilenFiyat);    //C maddesi mahalle adı girilebilir
        System.out.println("\n----------DOKUMANDAKİ D MADDESİ İÇİN GEREKLİ ÇIKTILAR----------\n");
        myTree.arananYemeginToplamSayisiveFiyatinGuncellenmesi("Burger");
                
    }
    
}
