package proje.pkg4;


public class Proje4 {


    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        /* AVL AĞACINA Ekelemeler yapılarak test yapılmaktadır. 
        İlk soruda önce 3 sonra da 2 eklenen ağacın da eklenmesi test 
        edilmektedir.
        */
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 5);
        tree.root = tree.insert(tree.root, 15);
        tree.root = tree.insert(tree.root, 4);
        tree.root = tree.insert(tree.root, 7);
        tree.root = tree.insert(tree.root, 12);
        tree.root = tree.insert(tree.root, 1);
        tree.root = tree.insert(tree.root, 6);
        tree.root = tree.insert(tree.root, 3); // Denge bozuluyor.
        
        
        /* Eklenme sonrasında ilk soruda çizilen AVL Ağacına göre çıkması
        gereken sonuç, ağaç preOrder dolaşıldığında;
             
        10 5 3 1 4 7 6 15 12 olacaktır.
        
        */
        System.out.println("Ağacın preorder dolaşılması" +
                        " sonucunda ortaya çıkan AVL Ağacı: ");
        tree.preOrder(tree.root);
        
        
        Graph theGraph = new Graph(); // Graph oluştulur.
        theGraph.addVertex('A');    // 0  
        theGraph.addVertex('B');    // 1
        theGraph.addVertex('C');    // 2
        theGraph.addVertex('D');    // 3
        theGraph.addVertex('E');    // 4

        theGraph.addEdge(0, 1);     // AB
        theGraph.addEdge(1, 2);     // BC
        theGraph.addEdge(0, 3);     // AD
        theGraph.addEdge(3, 4);     // DE

        System.out.print("\nVisits: ");
        theGraph.dfs();             // DFS
        System.out.println();
        
        }
    }
    

