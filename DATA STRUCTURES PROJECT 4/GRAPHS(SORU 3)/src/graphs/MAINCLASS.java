
package graphs;


class Edge {    //OKLARIN YANI GECISLER ICIN GEREKLI CLASS
    public int srcVert;     // EDGE IN BASLADIGI YANI HANGI DUGUMDEN CIKILDIGINI TUTAN DEGISKEN DUGUMUN INDEXINI TUTAR
    public int destVert;    //EDGE IN BITTIGI YANI HANGI DUGUME GIDILGINITUTAN DEGISKEN DUGUMUN INDEXINI TUTAR
    public int distance;    //IKI KOSE ARASI MESAFEYI TUTAR
    
    public Edge(int srcVert , int destVert , int distance){ //CONSTRUCTOR ICINDE ESITLEMELER YAPILDI
        this.srcVert = srcVert;
        this.destVert = destVert;
        this.distance = distance;
    }
}

class Vertex {   //Node ları olusturmak için gerekli class vertex de denebilir
    public char label;  //node ların adını tutmak için değişken
    public boolean isInTree;    //AGACTA BULUNUP NULUNMADIGINI BILMEK ICIN BOOLEAN DEGISKEN
    
    public Vertex(char labelName){  //CONSTRUCTOR
        label = labelName;
        isInTree = false;
    }
}

class PriorityQueue{    //ONCELIK KUYRUGUNUN AVANTAJINI PRIMS MINIMUM SPANNING TREEDE KULLANABILMEMIZ ICIN GEREKLI PQ 
    private final int SIZE = 20;    //GEREKLI DEGISKENLER
    private Edge[] queArray;
    private int size;
    
    public PriorityQueue(){ //CONSTRUCTOR
        queArray = new Edge[SIZE];
        size = 0;
    }
    
    public void insert(Edge item){  //ELEMAN EKLEME METODU  AZALAN PQ KULLANILACAGI ICIN GEREKLI FOR DONGULERINI BARINDIRIYOR
        int j;
        
        for(j=0 ; j<size ; j++){    //DIZI DOLASILIYOR VE YENI EKLENECEK ELEMANIN MESAFESI BUYUKSE FOR DONGUSUNDEN BREAK ILE CIKILIYOR
            if(item.distance >= queArray[j].distance) break;
        }
        
        for(int k = size-1 ; k>=j; k--){    //DIZI OTELENIYOR 1SAGA
            queArray[k+1] = queArray[k];
        }
        
        queArray[j] = item; //J.INDEXE YENI GELECEK ELEMAN EKLENIYOR
        size++;
    }
    
    public Edge removeMin(){    //EN SONDAKI ELEMAN EN KUCUK OLDUGUNDAN EN SONDAKI SILINIR VE SIZE KOSELI PARANTEZ ICINDE 1 AZALTILIR SONRA SILINIR
        return queArray[--size];
    }
    
    public void removeN(int n){ //GELEN INDEXTEKI ELEMANI SILEN VE SONRASINDA DIZIDEKI ELEMANLARI OTELEYEN METOD
        for(int j=n ; j<size-1 ;j++){
            queArray[j] = queArray[j+1];
        }
        size--;
    }
    
    public Edge peekMin(){  //EN KUCUK ELEMANI GONDERECEK METOD AZALAN ONCELIKTE YANI BUYUKTEN KUCUGE BIR PQ KULLANILACAGI ICIN SONUNCU ELEMAN GONDERILIR
        return queArray[size-1];
    }
    
    public int size(){  //SIZE I GONDERECEK METOD
        return size;
    }
    
    public boolean isEmpty(){   //ISEMPTY METODU
        return (size==0);
    }
    
    public Edge peekN(int n){   //GELEN INDEX DEGERINDEKI ELEMANIN GERI GONDERILMESI SILME YAPILMAZ
        return queArray[n];
    }
    
    public int find(int findDex){   //GELEN ELEMANIN INDEXINI GONDERECEK FIND METODU
        for(int a = 0 ; a<size ; a++){
            if(queArray[a].destVert == findDex) return a;
        }
        return -1;
    }
    
    
}

class DistPar             // distance and parent
   {                      // items stored in sPath array
   public int distance;   // distance from start to this vertex
   public int parentVert; // current parent of this vertex
// -------------------------------------------------------------
   public DistPar(int pv, int d)  // constructor
      {
      distance = d;
      parentVert = pv;
      }
// -------------------------------------------------------------
   }  // end class DistPar

class Graph {
    private final int MAX_VERTS = 20;   //OLUSABILECEK EN FAZLA NODE SAYISINI YANI VERTEX SAYISI 20 OLARAK ATANDI
    private final int INFINITY = 1000000;   //SONSUZLUK DEGERI OLUSTURULMASI
    private Vertex vertexList[];    //NODELARI KOSELERI TUTACAK VE ICINDE VERTEX CLASSINDAN OLUSTURULMUS NESNELERI BARINDIRACAK DIZI
    private int adjMat[][];         //KOMSULUK MATRISI
    private int nVerts;         // KAC TANE KOSE OLDUGUNU TUTACAK DEGISKEN
    private int currentVert;     //SUANKI KOSENIN INDEXI
    
    private DistPar sPath[];     // array for shortest-path data
    private int startToCurrent;  // distance to currentVert

    
    //MINIMUM SPANNING TREE ICIN GEREKLILER
    private PriorityQueue thePQ;
    private int nTree;
    
    public Graph(){  //GRAPH CLASS I ICIN CONSTRUCTOR OLUSTURDUM
        vertexList = new Vertex[MAX_VERTS];  //KOSELERI TUTACAK DIZININ UZUNLUGU BELIRLENEREK BELLEKTE OLUSTURULDU
        adjMat = new int[MAX_VERTS][MAX_VERTS]; //KOMSULUK MATRISI KOSELER ARASINDA KOMSULUK OLUP OLMADIGINI TUTMAK ICIN GEREKLI OLDUGUNDAN KOSE SAYISININ KARESI KADAR OLACAK
        nVerts = 0; // TOPLAM KOSE SAYISINI ILK BASTA 0 ATADIM
        
        for(int a = 0 ; a <MAX_VERTS ; a++){    //IKI TANE FOR DONGUSUYLE KOMSULUK MATRISINDEKI ELEMANLARI DOLASIP SONSUZ ATADIM ATADIM
            for(int b = 0 ; b <MAX_VERTS ; b++){
                adjMat[a][b] = INFINITY;
            }
        }
        
        //MINIMUM SPANNING TREE ICIN GEREKLI
        thePQ = new PriorityQueue();
        
        //Dijkstra’s Shortest Path 
        sPath = new DistPar[MAX_VERTS];    // shortest paths

    }
    
    public void addVertex(char charToAddGraph){
        //VERTEX LISTE ELEMAN EKLENIR VE ELEMAN SAYISINI TUTAN DEGISKEN 1 ARTTIRILIR
        vertexList[nVerts++] = new Vertex(charToAddGraph); //VERTEXTEN NESNE(KOSE) OLUSTURULUP EKLENIYOR
        
    }
    
    public void addEdge(int startVertex , int endVertex , int weight){  //EDGELERIN AGIRLIKLARI EKLENIYOR
        adjMat[startVertex][endVertex] = weight;
        adjMat[endVertex][startVertex] = weight;
    }
    
    public void displayVertex(int index){
        System.out.print(vertexList[index].label);
    }
    //AGIRLIKLI GRAPH OLUSTURMA ICIN GEREKLI KISIM BITTI
    
    
    //BUNDAN SONRASI DOLASMA ICIN GERKELI METODLAR
    
    public void MinimumSpanningTree(){  //PRIMS MINIMUM SPANNING TREE ICIN GEREKLI METOD
        currentVert = 0;    //0.VERTEXTEN BASLANIR ALGORITMANIN MANTIGINDA HERHANGI BIR DUGUM SECILIR VE BU DUGUME EN YAKIN KOMSU SECILIR VE ADA OLUSUR. SONRASINDA OLUSAN ADAYA SIMDILIK 2VERTEXLIK KISIM ICIN EN YAKIN VERTEX 
        //BULUNUR EGER BULUNAN VERTEX CYCLE OLUSTURMUYORSA GECIS YAPILIR VE ADAYA EKLENMIS OLUR BU SEKILDE ILERLEYEREK TUM GRAPH ADA SEKLINE GETIRILIR VE GRAPHTAKI TUM VERTEXLERE ULASABILECEGIMIZ UYGUN EN KISA YOLLARDAN OLUSAN AGAC ELDE ETMIS OLURUZ
        
        while(nTree < nVerts -1 ){  //TREEDEKI ELEMAN SAYISI VERTEX SAYISINDAN KUCUK OLDUKCA CALISACAK WHILE DONGUSU
            
            vertexList[currentVert].isInTree = true;    //AGACTA OLUP OLMADIGI KONTROL EDILIR
            nTree++;
            
            
            for(int a = 0 ; a<nVerts ; a++){    //VERTEXLER DOLASILIR VE UYGUN VERTEX IF BLOKLARINDA CONTINUE KULLANILARAK BULUNUR VE PRIORITYQUEUE A EKLENIR
                if(a==currentVert)  //SUANKI VERTEXE ESITSE GECILIR
                    continue;
                if(vertexList[a].isInTree)  //AGACTA VARSA GECILIR
                    continue;
                int distance = adjMat[currentVert][a];  //SUANKI VERTEXLE ARASINDAKI MESAFE ALINIR
                
                if(distance ==INFINITY) //SONSUZ MESAFEDEYSE ARALARINDA BAGLANTI YOKTUR GECILIR
                    continue;
                putInPQ(a,distance);    //TUM KOSULLARI SAGLADIGI ICIN PQ A EKLENIR
                
            }
            
            if(thePQ.size()==0){    //PQ NUN UZUNLUGU 0 SA HICBIR ELEMAN EKLENEMEMISTIR TUM VERTEXLER AYRI SEKILDEDIR
                System.out.println("GRAPH BAGLI DEGIL");
                return;
            }
            
            Edge theEdge = thePQ.removeMin();   //OLUSTURULAN PRIORITYQUEUE DEN EN KUCUK ELEMAN CEKILIR VE EDGE CLASSINDAN OLUSTURULMUS NESNEYE ATANIR
            int sourceVert = theEdge.srcVert;   //OKUN ARKA KISMI
            currentVert = theEdge.destVert; //OKUN UC KISMI
            
            
            System.out.print(vertexList[sourceVert].label); //YAZDIRILMA ISLEMI
            System.out.print(vertexList[currentVert].label);
            System.out.print(" ");
            
            
            
        }   //WHILE BITIS
        
        for(int a = 0 ; a<nVerts ; a++){    //ISARETLER KALDIRILIYOR
            vertexList[a].isInTree = false;
        }
        
        
    }   //MINIMUM SPANNING TREE BITIS
    
    
    //
    public void putInPQ(int newVert , int newDist){ //PRIMS MINIMUM SPANNING TREE ICIN GEREKLI METODUN BASLANGICI PRIORITYQUEUEA YERLESTIRILMESI
        int queueIndex = thePQ.find(newVert);   //INDEX BULMA ISLEMI
        
        if(queueIndex != -1){   //ONCELIK KUYRUGUNA DAHA ONCE KELENMIS BIR ELEMANSA CALISACAK BLOK
            Edge tempEdge = thePQ.peekN(queueIndex);    //ELEMAN DEGISKENE ATANIR
            int oldDist = tempEdge.distance;    //ESKI MESAFE SAKLANIR
            if(oldDist > newDist){  //UYGUN KOSULDA CALISACAK IF BLOGU ELEMAN SILINIR VE ESKI ELEMAN YENI UZUNUNLUKLA EKLENIR
                thePQ.removeN(queueIndex);
                Edge theEdge = new Edge(currentVert , newVert , newDist);
                thePQ.insert(theEdge);
            }
        }
        
        else{   //ONCELIKLI KUYRUKTA YOKSA YENI ELEMAN OLUSTURULUR VE ONCELIK KUYRUGUNA EKLENIR
            Edge theEdge = new Edge(currentVert , newVert , newDist);
            thePQ.insert(theEdge);
        }
    }   //PRIMS MINIMUM SPANNING TREE ICIN GEREKLI METODUN BITIMI
    
    
    //DIJKTRAS SHORTEST PATH
    
    public void path()                // SHORTEST PATH ALGORITMASININ GERCEKLESTIRILMESI ICIN GERKELI METOD
      {
      int startTree = 0;             // 0.INDEXTEKI NODE DAN BASLAMASI ICIN DEGISKENE 0 ATADIM
      vertexList[startTree].isInTree = true;    //AGACIN BOS OLUP OLMADIGINI KONTROL ETME
      nTree = 1;                     

      // transfer row of distances from adjMat to sPath
      for(int j=0; j<nVerts; j++)   //ILK NODE ICIN UZAKLIK MATRISINDEKI UZAKLIKLAR SPATH ADINDAKI DIZIYE AKTARILIR
         {
         int tempDist = adjMat[startTree][j];   //MESAFE
         sPath[j] = new DistPar(startTree, tempDist);   //ESITLEME ISLEMI
         }

      // until all vertices are in the tree
      while(nTree < nVerts) //BASTA OLUSTURULAN DEGISKENIN KOSE SAYISINDAN KUCUK OLDUGU DURUM KADAR CALISACAK WHILE DONGUSU
         {
         int indexMin = getMin();    
         int minDist = sPath[indexMin].distance;    //YUKARIDA BELLI NODE ICIN EKLENMIS UZAKLIKLARDAN EN KUCUK OLANIN INDEXI ALINIR VE EN KUCUK MESAFEYI TUTACAK DEGISKENE ATANIR

         if(minDist == INFINITY)     //HEPSI SONSUZSA YANI NODE VAR FAKAT HICBIR NODELA BAGLANTISI YOKSA
            {                        
            System.out.println("BAGLANTI YOK");
            break;                   
            }
         else
            {                        
            currentVert = indexMin;  //YENI NODE A GECILDI
            startToCurrent = sPath[indexMin].distance;  //SUANKI NODE ICIN MIN MESAFE BULUNUR
            }
         // put current vertex in tree
         vertexList[currentVert].isInTree = true;   //BULUNAN YENI NODE GRAPHTA OLUP OLMADIGI KONTROL EDILIR VARSA DEGISKEN 1 ARTTIRILIR
         nTree++;
         adjust_sPath();             //YOLDA DEGISIKLIKLER ICIN GUNCELLEME YAPILIR HER DONGGU SONUNDA GERCEKLESIR
         }  

      displayPaths();                

      nTree = 0;                     
      for(int j=0; j<nVerts; j++)
         vertexList[j].isInTree = false;    //DEGERLER FALSE A CEVRILIR
      }  

    
   public int getMin()            //EN KISA UZAKLIKTAKI KOSEYI BULMAMIZI SAGLAYAN METOD
      {                             
      int minDist = INFINITY;        
      int indexMin = 0;
      for(int j=1; j<nVerts; j++)    // TUM KOSELER DOLASILIR
         {                           
         if( !vertexList[j].isInTree &&  
                               sPath[j].distance < minDist )    //GRAPHTA YOKSA VEYA DAHA KUCUKSE EN KISA MESAFE GUNCELLENIR
            {
            minDist = sPath[j].distance;
            indexMin = j;            
            }
         }  
      return indexMin;               // MINIMUM UZAKLIGIN INDEXI GERI DONDURULUR
      } 

   
   public void adjust_sPath()   //SUTUNLAR ICIN GUNCELLEME YAPAR
      {
      // adjust values in shortest-path array sPath
      int column = 1;                // skip starting vertex
      while(column < nVerts)         // go across columns
         {
         // if this column's vertex already in tree, skip it
         if( vertexList[column].isInTree )
            {
            column++;
            continue;
            }
         // calculate distance for one sPath entry
                       // get edge from currentVert to column
         int currentToFringe = adjMat[currentVert][column];
                       // add distance from start
         int startToFringe = startToCurrent + currentToFringe;
                       // get distance of current sPath entry
         int sPathDist = sPath[column].distance;

         // compare distance from start with sPath entry
         if(startToFringe < sPathDist)   // if shorter,
            {                            // update sPath
            sPath[column].parentVert = currentVert;
            sPath[column].distance = startToFringe;
            }
         column++;
         }  // end while(column < nVerts)
   }  // end adjust_sPath()

   
   public void displayPaths()   //BULUNAN EN KISA YOLLARIN GOSTERIMI SECILEN 1 NODE DAN DIGER TUM NODELARA OLAN EN KISA YOLLAR GOSTERILIR
      {
      for(int j=0; j<nVerts; j++) 
         {
         System.out.print(vertexList[j].label + "="); 
         if(sPath[j].distance == INFINITY)  //BAGLANTI YOKSA YANI UZAKLIK SONSUZSA
            System.out.print("inf");                
         else
            System.out.print(sPath[j].distance);        //MESAFENIN YAZDIRILMASI
         char parent = vertexList[ sPath[j].parentVert ].label;
         System.out.print("(" + parent + ") ");      
         }
      System.out.println("");
      }

  
}   //GRAPH BITIMI




public class MAINCLASS {
    public static void main(String[] args) {
        
        Graph theGraph = new Graph();   //GRAPH CLASSINDAN NESNE OLUSTURULMASI
        
        
        
        theGraph.addVertex('Z');    //0     //GRAPH A VERTEX YANI KOSE EKLENMESI
        theGraph.addVertex('Y');    //1
        theGraph.addVertex('T');    //2
        theGraph.addVertex('X');    //3
        theGraph.addVertex('V');    //4
        theGraph.addVertex('W');    //5
        theGraph.addVertex('U');    //6
        theGraph.addVertex('S');    //7
        
        //GRAPH GECISLERININ EKLENMESI
        theGraph.addEdge(0, 1, 5);  //ZY 5  
        theGraph.addEdge(0, 2, 10);  //ZT 10
        theGraph.addEdge(1, 2, 5);  //YT 5
        theGraph.addEdge(1, 3, 3);  //YX 3
        theGraph.addEdge(1, 4, 4);  //YV 4
        theGraph.addEdge(2, 4, 8);  //TV 8
        theGraph.addEdge(2, 6, 3);  //TU 3
        theGraph.addEdge(2, 7, 4);  //TS 4
        theGraph.addEdge(3, 4, 1);  //XV 1
        theGraph.addEdge(3, 5, 2);  //XW 2
        theGraph.addEdge(4, 5, 1);  //VW 1
        theGraph.addEdge(4, 6, 3);  //VU 3
        theGraph.addEdge(5, 6, 1);  //WU 1
        theGraph.addEdge(6, 7, 2);  //US 2
        
        System.out.print("DIJKSTRA'S SHORTEST PATH: ");
        theGraph.path();
        System.out.println("\n");
      
        System.out.print("Minimum spanning tree: ");
        theGraph.MinimumSpanningTree();//   PRIM'S MINIMUM SPANNING TREE
        System.out.println("\n");

    }
    
}
