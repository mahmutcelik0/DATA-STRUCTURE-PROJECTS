import networkx as nx   #GEREKLI KUTUPHANELERIN IMPORT EDILMESI
import matplotlib.pyplot as plt

def addNodes(G1):   #NODE LARI VE EDGELERI AYRI SEKILDE EKLEDIM CUNKU BU SEKILDE NODE LARIN KOORDINAT DEGERLERINI BELIRLEYEBILIYORUM EDGE EKLEYEREK OLUSAN NODELARDA KOORDINAT BELIRLEMEDE SIKINTI OLUSTU
    G1.add_node(0, pos=(3, 2))  #NODELAR EKLENIR VE POS ICERISINDE KOORDINAT DEGERLERI ICERIR
    G1.add_node(1, pos=(6, 0.5))
    G1.add_node(2, pos=(4.5, -2))
    G1.add_node(3, pos=(1.5, -2))
    G1.add_node(4, pos=(0, 0.5))

def addEdges(G1):   # NODELAR ARASINDAKI OKLARIN OLUSTURULMASI VE AGIRLIK ATTRIBUTELERININ EKLENMESI
    G1.add_edges_from([(0, 4)], weight=2)
    G1.add_edges_from([(0, 1)], weight=5)
    G1.add_edges_from([(0, 2)], weight=3)
    G1.add_edges_from([(1, 2)], weight=2)
    G1.add_edges_from([(1, 3)], weight=6)
    G1.add_edges_from([(2, 1)], weight=1)
    G1.add_edges_from([(2, 3)], weight=2)
    G1.add_edges_from([(4, 1)], weight=6)
    G1.add_edges_from([(4, 2)], weight=10)
    G1.add_edges_from([(4, 3)], weight=4)

""" # YUKARIDA EDGE EKLERKEN CURWED ATTRIBUTE EKLEYIP BIRBIRLERI ARASINDA 1 DEN FAZLA OK VARSA CURWED TRUE YAPMAYI VE ONA GORE YAZDIRMAYI DUSUNDUM
    #FAKAT ASAGIDAKI DONGU BEKLEDIGIM GIBI CALISMADI OKLAR UST USTE DENK GELIYOR 
    for edge in G1.edges.items():
        for edge2 in G1.edges.items():
            if(edge[0][0] == edge2[0][1] & edge[0][1] == edge2[0][0]):
                
"""


def makeChanges(G1):    #NODELAR GECISLER VE OKLARLA ILGILI OZELLIKLERIN BILGILERIN OLUSTURULDUGU KISIM
    options = { #BURADA OKLA ILGILI OZELLIKLER BELIRLENIR
        'node_color': 'blue',
        'node_size': 1000,
        'width': 1,
        'arrowstyle': '-|>',
        'arrowsize': 10,
    }

    node_pos = nx.get_node_attributes(G1, 'pos')    #OLUSAN NODE UN KOORDINAT DEGERI ICIN GEREKLI DEGISKENIN ALINMASI

    edge_labels = dict([((u, v,), d['weight'])
                        for u, v, d in G1.edges(data=True)])    # GECISLERDEKI BILGILERIN DICTIONARY E AKTARILMASI

    show(G1 , node_pos , edge_labels , options) #BASKIYA GECILMESI ICIN GEREKLI METOD

def show(G1 , node_pos , edge_labels , options):    #BASKININ YAPILACAGI METOD
    nx.draw_networkx_nodes(G1, node_pos)    #NODE LAR BASTILIR
    nx.draw_networkx_labels(G1, node_pos)   #ETIKETLERI EKLENIR 0 1 2 3 4
    nx.draw_networkx_edges(G1, node_pos, connectionstyle="arc3,rad = 0.0", arrows=True, **options)  # OKLAR EKLENIR rad ı 0.3 yaparak denedim fakat hepsi bukuldugu ıcın attribute tanımlamam gerekli o kısmı yapamadım
    nx.draw_networkx_edge_labels(G1, node_pos, edge_labels=edge_labels, arrows=True, **options) #OKLARIN AGIRLIK DEGERLERI EKLENIR
    plt.show()  #KULLANICIYA GOSTERILMESI ICIN

def draw(G1):   #NODELARIN EDGELERIN DEGISIKLIKLERIN YAPILIP SONRASINDA BASKININ YAPILMAYA GECILMESINI SAGLAYAN METOD
    addNodes(G1)
    addEdges(G1)
    makeChanges(G1) #METODLARA GIDILIR VE ISLEMLER GERCEKLESTIRILIR
    return G1

def findShortestPath(G1):   # EN KISA YOLUN BULUNMASI ICIN METOD
    number = 4  #DOKUMANDA 4 SAYISI ICIN ISTENDIGI ICIN YAPTIM KODUN EN BASINDA DA YAPABILIRDIM AMA BURADA TANIMLADIM

    for node in G1.nodes:   #NODELAR FOR DONGULERIYLE DOLASILIR
        if(node != number): #G1 ICINDEN GELEN NODE SAYIYA ESIT DEGILSE YANI KENDISI DEGILSE CALISACAK IF BLOGU
            try:    #TRY CATCH KULLANDIM CUNKU 2 NODE ARASI YOL YOKSA NETWORKXNOPATH HATASI VERDIGI ICIN BUNU ONLEDIM
                print("4.NODE ILE ",node,".NODE ARASINDAKI EN KISA YOL: ",nx.dijkstra_path(G1, source=number, target=node, weight='weight'))    # EN KISA YOLUN DIJKSTRA_PATH KULLANILARAK HESAPLANMASI
            except nx.NetworkXNoPath :
                print("4.NODE ILE ",node,".NODE ARASINDA GIDILEBILECEK YOL YOK")    #IKI NODE ARASI YOL OLMAYINCA CALISACAK METOD


def delete(G1): #NODE SILMEK ICIN GEREKLI ISLEMLERI YAPAN METOD
    number = 1  #DOKUMANDA SILINMESI ICIN 1.NODE ISTENMIS BURADA TANIMLADIM DOKUMANIN ENBASINDA DA TANIMLAYABILIRDIM

    G1.remove_node(1)   # G1 DEN 1 NODE UNUN SILINMESI

    makeChanges(G1) #YUKARIDA YAPILAN CIZIM ICIN GEREKLI ISLEMLER TEKRAR YAPILIR VE METOD ICINDEKI SHOW ILE BASTIRILIR


def main(): #MAIN METODU
    G1 = nx.DiGraph()   #KUTUPHANEDEN DIGRAPH OLUSTURULDU

    draw(G1)    #CIZDIRILMESI 4.SORU 1.BOLUM ICIN

    findShortestPath(G1)    # EN KISA YOLUN BULUNMASI 4.SORU 2.BOLUM ICIN

    delete(G1)  # NODE UN SILINMESI 4.SORU 3.BOLUM ICIN
    




main()  #MAIN METODUNUN CAGIRILMASI