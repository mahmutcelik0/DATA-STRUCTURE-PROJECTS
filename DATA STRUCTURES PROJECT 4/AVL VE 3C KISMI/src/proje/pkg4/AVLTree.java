package proje.pkg4;
// AVL AĞACINA Ekleme Yapılan Java Programı
class Node {
    int key, height;
    Node left, right;

    Node(int d) {
        key = d;
        height = 1;
    }

    // Daha güzel bir bastırılma için toString metodu tanımlanmıştır.
    @Override
    public String toString() {
        return "Key: " +key ; 
    }
    
}

class AVLTree {

    Node root;

    // Ağacın boyunu döndüren metot tanımlanmıştır.
    int height(Node N) {
        if (N == null)
            return 0;

        return N.height;
    }

    // İki adet tamsayıdan maksimum olanı döndüren metot tanımlanmıştır.
    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // y köküne sahip olan ağacın sağ kısmını dengeleyen metottur.
    Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        
        
        // Dönüştürmenin yapılması (dengelenme).
        x.right = y;
        y.left = T2;

        // Yüksekliklerin güncellenmesi.
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;
        

        // Yeni kökü döndür.
        return x;
    }

    // y köküne sahip olan ağacın sağ kısmını dengeleyen metottur.
    Node leftRotate(Node y) {
        Node x = y.right;
        Node T2 = x.left;

        
        // Dönüştürmenin yapılması (dengelenme).
        x.left = y;
        y.right = T2;

        // Yüksekliklerin güncellenmesi.
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        // Yeni kökü döndür.
        return x;
    }

    // N köküne sahip ağacın dengesini bulan metottur. 
    // (SOL YÜKSEKLİK - SAĞ YÜKSEKLİK)
    int getBalance(Node N) {
        if (N == null)
            return 0;

        return height(N.left) - height(N.right);
    }

    // AVL Ağacına ekleme yapılabilen metot tanımlanmıştır.
    // Kendisine verilen ağaca ekleme yapılır ve yeni ağaç döndürülür.
    Node insert(Node rootNode, int key) {

        // 1.  Kök boş ise, yeni kök oluştur ve döndür (Köke ekle). 
        if (rootNode == null)
            return (new Node(key));

        // Kök boş değilse uygun çocuğa ekleme yap.
        if (key < rootNode.key)
            rootNode.left = insert(rootNode.left, key);
        else if (key > rootNode.key)
            rootNode.right = insert(rootNode.right, key);
        else // Eşit anahtar için ekleme yapılmaz, aynı ağaç döndürülür.
            return rootNode;

        /* 2. Eklenme olduğu için yüksekliği güncelle. */
        rootNode.height = 1 + max(height(rootNode.left),
                              height(rootNode.right));

        /* 3. Dengesizlik durumunu kontrol et. Sol, sağ yükseklik arasında
        bir birimden fazla fark varsa dengeleme yap. (AVL TREE)*/
        int balance = getBalance(rootNode);

       // Eklenme durumunda dengesizlik olduysa dört durum olabilir.
       // 1- Solun soluna ekleme yapılması.
       if (balance > 1 && key < rootNode.left.key) 
       {System.out.println(rootNode);
           return rightRotate(rootNode);
       }
        // 2- Sağın sağına ekleme yapılması.
        if (balance < -1 && key > rootNode.right.key)
            return leftRotate(rootNode);

        // 3- Solun sağına ekleme yapılması.
        if (balance > 1 && key > rootNode.left.key) {
            rootNode.left = leftRotate(rootNode.left);
            return rightRotate(rootNode);
        }

        // 4- Sağın soluna ekleme yapılması.
        if (balance < -1 && key < rootNode.right.key) {
            rootNode.right = rightRotate(rootNode.right);
            return leftRotate(rootNode);
        }

        // Düğümü döndür. 
        return rootNode;
    }

    // Ağacın preorder dolaşılarak bastırılması.
    void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }
}





