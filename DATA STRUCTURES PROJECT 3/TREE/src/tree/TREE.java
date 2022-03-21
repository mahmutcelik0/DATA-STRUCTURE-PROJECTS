
package tree;


public class TREE {
    
    private TreeNode root;
    private int derinlik = -1;  //AGACIN ILK DERINLIGININ 0 OLMASI ICIN -1 ATADIM. AGAC DOLASILIRKEN HER YENI RECURSION FONK GIRILDIGINDE 1 ARTACAK VE BU DEGERDE TUTULACAK
    private int maxDerinlik =0; //MAXDERINLIGI TUTMAK ICIN GEREKLI DEGISKEN
    private int toplamYemekSayisi =0;   //VERILEN YEMEGIN AGACTAKI TOPLAM SIPARIS SAYISINI BULMAK ICIN GEREKLI DEGISKEN
    private int yemeginEskiFiyati =0;   //BUNLAR GEREKLI DEGIL FAKAT FIYAT DEGISIMINI GOREBİLMEK ICIN YEMEGIN ESKI VE YENI FIYATINI TUTUYORLAR
    private int yemeginYeniFiyati =0;
    
    public void add(String stringToAddTree){    //AGACA ELEMAN EKLEMEYE SAGLAYAN METOD ICINDE RECURSION FONKSIYONU CAGIRIYOR
        root = addWithRecursion(root, stringToAddTree);
    }
    
    private TreeNode addWithRecursion(TreeNode node , String stringToAddTree){  //RECURSION BIR METOD NODE NULLSA ELEMAN ELEMAN EKLENIR KARSILASTIRMA DURUMUNA GORE AGACTA ILERLENIR
        
        if(node ==null){    //NODE NULL A ESIT OLDUGUNDA CALISACAK BLOK EKLENECEK MAHALLENIN ADINDA MAHALLE NESNESI OLUSTURULUR VE AGACA EKLENIR
            node = new TreeNode(new Mahalle(stringToAddTree));
            return node;
        }

        //  IKI STRINGIN COMPARETO METOD SONUCU
        //  SAYI 0 CIKIYORSA AYNI STRINGLERDIR
        //  SAYI 1 CIKIYORSA SOLDAKI SAGDAKINDEN ALFABETIK SIRADA DAHA BUYUKTUR F > A MESELA
        //  SAYI -1 CIKIYORSA SOLDAKI SAGDAKINDEN ALFABETIK SIRADA DAHA KUCUKTUR N < S MESELA
        
        if(stringToAddTree.compareTo(node.mahalleNesnesi.getMahalleAdi()) <0){ //SAYI -1 SE SOLA GİDİLİR 
            node.leftChild = addWithRecursion(node.leftChild, stringToAddTree);
            return node;
            
        }
        else{   //SAYI 1SE SAGA GIDILIR
            node.rightChild = addWithRecursion(node.rightChild, stringToAddTree);
            return node;
        }
    }
    
    public void preOrder(TreeNode node){    //AGACIN ILK OLARAK SOL ELEMANI SONRA PARENT EN SON SAG ELEMANIN YAZDIRILDIGI RECURSION DOLASMA YONTEMI
        if(node !=null){    //NODE NULL OLMADIGI SURECE ILERLEYECEK
            node.displayNode();
            preOrder(node.leftChild);
            preOrder(node.rightChild);
        }
    }
    
    public void inOrder (TreeNode node){    //AGACIN ILK OLARAK PARENT SONRA SOL ELEMANI EN SON SAG ELEMANIN YAZDIRILDIGI RECURSION DOLASMA YONTEMI
        if(node!=null){  //NODE NULL OLMADIGI SURECE ILERLEYECEK
            inOrder(node.leftChild);
            node.displayNode();
            inOrder(node.rightChild);
        }
    }

    public void postOrder (TreeNode node){  //AGACIN ILK OLARAK SOL ELEMANI SONRA SAG ELEMANI EN SON PARENT ELEMANIN YAZDIRILDIGI RECURSION DOLASMA YONTEMI
        if(node!=null){  //NODE NULL OLMADIGI SURECE ILERLEYECEK
            postOrder(node.leftChild);
            postOrder(node.rightChild);
            node.displayNode();
        }
    }
    
    public boolean isEmpty(){   //ROOT NULL A ESITSE AGAC BOSTUR BU DURUMDA METOD TRUE DONDURUR
        return (root ==null);
    }
    
    
    public void dolasmaVeFiyatUstuYazdirma(String arananMahalleAdi , int fiyat){    //1.C KISMI ICIN CALISACAK METOD
        //ADI GELEN MAHALLE BASKA BIR METODA GIDILEREKK ORADA KULLANILIR
        dolasmaVeYazdirma(getRoot(), arananMahalleAdi, fiyat);
    }
    
    private void dolasmaVeYazdirma(TreeNode node , String arananMahalleAdi ,int fiyat){ //TUM AGAC DOLASILIR VE ISTENEN MAHALLEDEKI SIPARISBILGILERI GELEN FIYAT UZERIYSE YAZDIRILIR
        //  BURADA MAHALLENIN TREE DE BULUNMAMA DURUMUNU KONTROL ETMEDIM DOKUMANDA DA OLMAYINCA KODU YAZARKEN AKLIMA GELMEDI
        //  SONDAKI ELSE BLOGUNU ELSE IF YAPIP COMPARETO = 0 YAPILIP EN SONA ELSE EKLENIRSE MAHALLENIN AGACTA OLMAMA DURUMUNDA HATALI CALISMA DURUMUNUN ONUNE GECILMIS OLUNUR
        
        
        
        if(node!= null){    //NODE NULL OLMADIGI SURECE CALISACAK RECURSION
            
            //  IKI STRINGIN COMPARETO METOD SONUCU
        //  SAYI 0 CIKIYORSA AYNI STRINGLERDIR
        //  SAYI 1 CIKIYORSA SOLDAKI SAGDAKINDEN ALFABETIK SIRADA DAHA BUYUKTUR F > A MESELA
        //  SAYI -1 CIKIYORSA SOLDAKI SAGDAKINDEN ALFABETIK SIRADA DAHA KUCUKTUR N < S MESELA
            
            if(arananMahalleAdi.compareTo(node.mahalleNesnesi.getMahalleAdi())<0){  //ARANAN MAHALLE VE AGAC DOLASILIRKEN MEVCUT NODE KARSILASTIRMA SONUCU SOLA VEYA SAGA GIDILIR
                dolasmaVeYazdirma(node.leftChild, arananMahalleAdi , fiyat);
                
            }
            else if(arananMahalleAdi.compareTo(node.mahalleNesnesi.getMahalleAdi())>0){
                dolasmaVeYazdirma(node.rightChild, arananMahalleAdi , fiyat);
            }
            
            else{   //MAHALLEYE GELINDIGINDE MAHALLE ADI YAZDIRILIR
                //SONRASINDA SIPARISLERLISTESI DOLASILIR ICINDE SIPARISBILGILERI SAKLIYORDU O CLASSIN TOPLAM FIYAT METODU KULLANILARAK KARSILASTIRMA FIYATIMIZDAN BUYUKSE BILGILERI YAZDIRILIR
                
                System.out.println("MAHALLE ADI: "+node.mahalleNesnesi.getMahalleAdi());
                for(SiparisBilgileri siparisBilgileri : node.mahalleNesnesi.getSiparislerListesi()){    // SIPARISLERLISTESININ FOREACH ILE DOLASILMASI
                    
                    if(siparisBilgileri.siparisBilgileriToplamFiyat()>fiyat){   //SIPARISBILGILERI TOPLAM FIYATI BUYUKSE CALISACAK BLOK
                        System.out.println("SİPARİŞ TOPLAM FİYAT: "+siparisBilgileri.siparisBilgileriToplamFiyat() + "TL ");
                        siparisBilgileri.siparisBilgileriYazdir();
                    }
                    
                }
            } 
        }
    }
    
    
    public void arananYemeginToplamSayisiveFiyatinGuncellenmesi(String arananYemeginAdi){   //1.D ICIN CALISACK METOD BASKA BIR METODA GIDER YAZDIRMA KISIMLARINI VE MAINDE YAPILACAK GETROOT YERINE O ISLEMI BURADA YAPAR
        yemekAramaVeFiyatGuncelleme(arananYemeginAdi, root);    //GIDILECEK RECURSION METOD
        System.out.println("AĞACTAKİ TOPLAM "+arananYemeginAdi + " SAYISI: "+ toplamYemekSayisi);   //DEGISKENDE TUTULAN SAYI GIDILEN METODDA DEGISIR VE BURADA O DEGISKEN KULLANILARAK SAYI YAZDIRILIR

        
        System.out.println("İSTENEN YEMEGİN ESKİ FİYATI: "+ yemeginEskiFiyati+"\nİSTENEN YEMEĞİN YENİ FİYATI: "+ yemeginYeniFiyati);    //BURASI GEREKLI DEGIL FAKAT GORME ACISINDAN DAHA IYI OLACAGINI DUSUNDUGUM ICIN YAZDIM
    }
    
    private void yemekAramaVeFiyatGuncelleme(String arananYemeginAdi , TreeNode node ){ //AGACTAKI TUM NESNELER DOLASILIR HER NESNENIN SIPARISLISTERI SIPARISLISTELERININ SIPARISBILGILERI SIPARISBILGILERINDEKI YEMEKSINIFI NESNELERINDEKI METODLAR KULLANILARAK KARSILASTIRMA YAPILIR
        
        if(node !=null){    //NODE NULL OLMADIGI SURECE CALISACAK RECURSION
        

            
            for(SiparisBilgileri siparisBilgileri : node.mahalleNesnesi.getSiparislerListesi()){    //NODE DAKI MAHALLE NESNESININ SIPARISLISTESININ DOLASILMASI
                for(YemekSinifi yemekler : siparisBilgileri.getSiparisBilgileriListesi()){  //SIPARISBILGILERININ DOLASILIP YEMEKSINIFI NESNELERININ INCELENMESI
                    if (yemekler.getYemekAdi().equals(arananYemeginAdi)){   //GELEN YEMEKSINIFI NESNESI ARANANYEMEKLE ESITSE CALISACAK IF BLOGU
                        yemeginEskiFiyati = yemekler.getYemekBirimFiyati();
                        yemekler.setYemekBirimFiyati(yemekler.getYemekBirimFiyati() - (yemekler.getYemekBirimFiyati()*10/100)); //FIYATTA INDIRIM YAPILIR VE DEGISTIRILIR
                        yemeginYeniFiyati = yemekler.getYemekBirimFiyati();
                        
                        
                        int yemekSiparisAdedi = yemekler.getYemekSiparisAdedi();    
                        toplamYemekSayisi += yemekSiparisAdedi; //ARANAN YEMEGIN SIPARIS ADEDI ILK BASTA OLUSTURULAN DEGISKENE EKLENIR
                       
                    }
                }
            }
        
            yemekAramaVeFiyatGuncelleme(arananYemeginAdi, node.leftChild);  //DOLASMAYI SAGLAYAN KISIM
            yemekAramaVeFiyatGuncelleme(arananYemeginAdi, node.rightChild);
        }
        
    }
    
    private void derinligiBulma(TreeNode node , int derinlik){    //AGACIN DERINLIGINI TUM AGACI DOLASARAK VE MEVCUT DERINLIGI MAXDERINLIKLE KARSILASTIRARAK MEVCUT DAHA DERINSE DEGERLERI GUNCELLEYEN RECURSION METOD
        if(node !=null){    //NODE NULL OLMADIGI SURECE CALISACAK RECURSION
          derinlik ++;  //HER 1 KADEME ASAGIYA INILDIGINDA DERINLIK 1 ARTTIRILIR
          
          if(derinlik > maxDerinlik){   //DERINLIGIN KARSILASTIRILIP BLOK CALISIRSA MAXDERINLIGIN GUNCELLENMESI
              maxDerinlik =derinlik;
          }
            derinligiBulma(node.leftChild, derinlik);   //TUM AGACIN DOLASILMASINI SAGLAYAN KISIM
            derinligiBulma(node.rightChild,derinlik);
          
        }
    }
    
    public void agactakiTumBilgilerinYazdirilmasi(){    //1.B MADDESI ICIN CALISACAK METOD
        //AGACIN DERINLIGI VE SONRASINDA TUM AGACTAKI BILGILERIN YAZDIRILMASINI YAPAR
        derinligiBulma(root, derinlik); //DERINLIGI DEGISKEN UZERINE ATAR
        System.out.println("AGACIN DERİNLİGİ: "+ maxDerinlik + "\n");   
        preOrder(root); //AGACIN DOLASILMASI    HERHANGI BIR DOLASMA YONTEMI DE OLABILIRDI BUNU TERCIH ETTIM
        
    }
    
    
    
    public TREE(){  //CONSTRUCTORDA ROOT A NULL ATAMASI YAPTIK AGACI KAYBETMEMEK ICIN ONEMLI ROOT KODUN YUKARISINDA KALMIS 
        this.root =null;
    }

    public TreeNode getRoot() { //ROOT ICIN GETTER VE SETTER
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }
    
    

    public class TreeNode{  //AGAC DUGUMLERININ OLUSTURULDUGU CLASS ICINDE DATA SOL VE SAG COCUK OZELLIKLERI BULUNMAKTA
        private Mahalle mahalleNesnesi; //DATA OLARAK MAHALLE CLASSINDAN NESNELER TUTAR 
        private TreeNode leftChild;
        private TreeNode rightChild;
        
        public TreeNode(Mahalle mahalleNesnesi){    //CONSTRUCTOR
            this.mahalleNesnesi = mahalleNesnesi;
            this.leftChild = null;
            this.rightChild = null;
        }
        
        public void displayNode(){  //OLUSTURULAN TREENODUN GORUNTULENMESI ICIN METOD MAHALLE CLASSINDAKI BILGI YAZDIRMA METODU KULLANARAK YAZDIM
            mahalleNesnesi.mahalleBilgiYazdir();
        }
    }
    
    

    
    
}
