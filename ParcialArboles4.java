package parciales;

import practica2.BinaryTree;

/*public BinaryTree<Integer> reemplazarConMaximo()
Este método devuelve un nuevo árbol donde cada nodo contiene el valor máximo entre él mismo 
y todos sus descendientes.*/

public class ParcialArboles4 {

    private static int reemplazarConMaximo(BinaryTree<Integer> arbol, BinaryTree<Integer> nuevo){
        int data = arbol.getData();
        if(arbol.isLeaf()){
            nuevo.setData(data);
            return data;
        }
        int der = 0;
        int iz = 0;
        if(arbol.hasLeftChild()){
            BinaryTree<Integer> l = new BinaryTree<>();
            nuevo.addLeftChild(l);
            iz = reemplazarConMaximo(arbol.getLeftChild(), nuevo.getLeftChild());
        }   
        if(arbol.hasRightChild()){
            BinaryTree<Integer> r = new BinaryTree<>();
            nuevo.addRightChild(r);
            der = reemplazarConMaximo(arbol.getRightChild(), nuevo.getRightChild());
        }
        int out = 0;
        if(iz >= der){
            if(iz >= data){
                out = iz;
            } else {
                out = data;
            }
        } else if(der >= iz){
            if(der >= data){
                out = der;
            } else {
                out = data;
            }
        }
        nuevo.setData(out);
        return out;

    }

    public static BinaryTree<Integer> reemplazarConMaximo(BinaryTree<Integer> arbol){
        BinaryTree<Integer> nuevo = new BinaryTree<>();
        if(arbol != null && !arbol.isEmpty()){
            reemplazarConMaximo(arbol,nuevo);
        }
        return nuevo;
    }

    public static void main(String[] args){
        BinaryTree<Integer> raiz = new BinaryTree<>(15);
        BinaryTree<Integer> nodo10 = new BinaryTree<>(10);
        BinaryTree<Integer> nodo20 = new BinaryTree<>(20);
        BinaryTree<Integer> nodo8 = new BinaryTree<>(8);
        BinaryTree<Integer> nodo12 = new BinaryTree<>(12);
        BinaryTree<Integer> nodo25 = new BinaryTree<>(25);
        BinaryTree<Integer> nodo14 = new BinaryTree<>(14);

        // Armar árbol
        raiz.addLeftChild(nodo10);
        raiz.addRightChild(nodo20);
        nodo10.addLeftChild(nodo8);
        nodo10.addRightChild(nodo12);
        nodo12.addRightChild(nodo14);
        nodo20.addRightChild(nodo25);

        raiz.printLevelTraversal();
        BinaryTree<Integer> nuevo = reemplazarConMaximo(raiz);
        System.out.println();
        System.out.println();
        System.out.println("otro");
        System.out.println();
        nuevo.printLevelTraversal();
    }
}
