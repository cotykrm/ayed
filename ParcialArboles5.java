package parciales;

import practica2.BinaryTree;

/*Prefijos acumulados
Implementá este método en ParcialArboles:

public BinaryTree<String> arbolPrefijos()
Dado un árbol binario de cadenas (BinaryTree<String>), construí un nuevo árbol donde cada nodo 
contiene la concatenación de todos los valores desde la raíz hasta ese nodo.

Ejemplo: si la ruta es "A" -> "B" -> "C", entonces el nodo "C" del nuevo árbol tiene "ABC". */

public class ParcialArboles5 {

    private static void arbolPrefijos(BinaryTree<String> arbol, BinaryTree<String> nuevo, String conc){
        String data = arbol.getData();
        String nuevoData = conc+data;
        nuevo.setData(nuevoData);
        if(arbol.hasLeftChild()){
            BinaryTree<String> iz = new BinaryTree<>();
            nuevo.addLeftChild(iz);
            arbolPrefijos(arbol.getLeftChild(), nuevo.getLeftChild(), nuevoData);
        }
        if(arbol.hasRightChild()){
            BinaryTree<String> der = new BinaryTree<>();
            nuevo.addRightChild(der);
            arbolPrefijos(arbol.getRightChild(), nuevo.getRightChild(), nuevoData);
        }
    }

    public static BinaryTree<String> arbolPrefijos(BinaryTree<String> arbol){
        BinaryTree<String> nuevo = new BinaryTree<>();
        if(arbol != null && !arbol.isEmpty()){
            arbolPrefijos(arbol, nuevo, "");
        }
        return nuevo;
    }

    public static void main(String[] args){
        BinaryTree<String> raiz = new BinaryTree<>("A");
        BinaryTree<String> nodoB = new BinaryTree<>("B");
        BinaryTree<String> nodoC = new BinaryTree<>("C");
        BinaryTree<String> nodoD = new BinaryTree<>("D");
        BinaryTree<String> nodoE = new BinaryTree<>("E");
        BinaryTree<String> nodoF = new BinaryTree<>("F");

        // Armar el árbol
        raiz.addLeftChild(nodoB);
        raiz.addRightChild(nodoC);
        nodoB.addLeftChild(nodoD);
        nodoC.addLeftChild(nodoE);
        nodoC.addRightChild(nodoF);

        raiz.printLevelTraversal();
        BinaryTree<String> nuevo = arbolPrefijos(raiz);
        System.out.println();
        System.out.println();
        System.out.println("otro");
        System.out.println();
        nuevo.printLevelTraversal();
    }
}
