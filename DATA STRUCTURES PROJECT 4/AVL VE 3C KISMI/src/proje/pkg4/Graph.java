/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje.pkg4;

/**
 *
 * @author Özgür Bayraşa
 */
// Graph sınıfı tanımlanmıştır.
class Graph
   {
   private final int MAX_VERTS = 20; // Maksimum 20 verteks.
   private Vertex vertexList[]; // Vertekslerin dizisi.
   private int adjMat[][];      // Komşuluk matriksi
   private int nVerts;          // Anlık verteks sayısı.
   private StackX theStack;     // Stack
// ------------------------------------------------------------
   public Graph()               // Yapılandırıcı metot.
      {
      vertexList = new Vertex[MAX_VERTS]; // Vertex listesi oluşturlur.
                                          
      adjMat = new int[MAX_VERTS][MAX_VERTS]; // Komşuluk matrisi oluşturulur.
      nVerts = 0;
      for(int y=0; y<MAX_VERTS; y++)       
         for(int x=0; x<MAX_VERTS; x++)   
            adjMat[x][y] = 0; // Komşuluk Matrisi 0'dır.
      theStack = new StackX();
      }  
// ------------------------------------------------------------
// Verteks ekleme metodu tanımlanmıştır.
   public void addVertex(char lab)
      {
    
          // Verkex listesine eleman eklenir. Eleman sayısı arttırılır.
          vertexList[nVerts++] = new Vertex(lab);
      }
// ------------------------------------------------------------
   // Kenar ekleme metodu tanımlanmıştır.
   public void addEdge(int start, int end)
      {
            // İki kenar arası 1 olarak değiştirilir.
            adjMat[start][end] = 1;
            adjMat[end][start] = 1;
      }
// ------------------------------------------------------------
// Verteksin bastırıldığı metot tanımlanmıştır.   
   public void displayVertex(int v)
      {
          System.out.print(vertexList[v].label);
      }
// ------------------------------------------------------------
// dfs ile dolaşma metodu tanımlanmıştır. 
   public void dfs()  
      { 
            // 0. Verteksten başlanır.
            vertexList[0].wasVisited = true;  // Verteks işaretlenir.
            displayVertex(0);                 // Bastırılır.
            theStack.push(0);                 // Verteks stack'e eklenir.

            while( !theStack.isEmpty() )      // Stack dolu iken...
               {
               // Stack'in tepesindeki verteksin komşusu akınır.
               int v = getAdjUnvisitedVertex( theStack.peek() );
               if(v == -1)                    // İlgili verteks yoksa...
                  theStack.pop();
               else                           // İlgili verteks varsa...
                  {
                  vertexList[v].wasVisited = true;  // İşaretle.
                  displayVertex(v);                 // Bastır.
                  theStack.push(v);                 // Stack'e Ekle.
                  }
               }  

            // Stack boş olunca resetleme yap.
            for(int j=0; j<nVerts; j++)         
               vertexList[j].wasVisited = false;
      }  
   // ------------------------------------------------------------
   // Verteksin komşusunu döndüren metot.
   public int getAdjUnvisitedVertex(int v)
      {
      // Verteksin komşusu bulunursa ve işaretlenmemişse verteksi döndür.
      // Bulunmazsa veya ziyaret edilmişse -1 döndür.
      for(int j=0; j<nVerts; j++)
         if(adjMat[v][j]==1 && vertexList[j].wasVisited==false)
            return j;
      return -1;
      }  
// ------------------------------------------------------------
   }  // Graph sınıfının sonu.
////////////////////////////////////////////////////////////////
 
