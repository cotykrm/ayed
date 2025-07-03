package parciales;

import practica2.BinaryTree;

/*Definí en ParcialArboles el método:
public BinaryTree<Integer> promedio()
Este método debe crear un nuevo árbol con la misma estructura que el original, pero en cada nodo:

Si tiene ambos hijos, el valor será el promedio (entero) entre el valor del hijo izquierdo y el del derecho.

Si tiene solo un hijo, el valor del nodo será el mismo que el de ese hijo.

Si es hoja, se mantiene igual. */


public class ParcialArboles3 {

    private static void promedio(BinaryTree<Integer> arbol,BinaryTree<Integer> nuevo){
        if(arbol.hasLeftChild() && arbol.hasRightChild()){
            int data;
            data = arbol.getRightChild().getData() + arbol.getLeftChild().getData();
            data = data/2;
            nuevo.setData(data);
            BinaryTree<Integer> l = new BinaryTree<>();
            nuevo.addLeftChild(l);
            BinaryTree<Integer> r = new BinaryTree<>();
            nuevo.addRightChild(r);
            promedio(arbol.getLeftChild(),nuevo.getLeftChild());
            promedio(arbol.getRightChild(),nuevo.getRightChild());
        }
        else if(arbol.hasLeftChild()){
            int data = arbol.getLeftChild().getData();
            nuevo.setData(data);
            BinaryTree<Integer> l = new BinaryTree<>();
            nuevo.addLeftChild(l);
            promedio(arbol.getLeftChild(),nuevo.getLeftChild());
        }
        else if (arbol.hasRightChild()){
            int data = arbol.getRightChild().getData();
            nuevo.setData(data);
            BinaryTree<Integer> r = new BinaryTree<>();
            nuevo.addRightChild(r);
            promedio(arbol.getRightChild(),nuevo.getRightChild());
        }
        else {
            int data = arbol.getData();
            nuevo.setData(data);
        }

    }

    public static BinaryTree<Integer> promedio(BinaryTree<Integer> arbol){
        BinaryTree<Integer> p = new BinaryTree<>();
        if(arbol != null && !arbol.isEmpty()){
            promedio(arbol,p);
        }
        return p;
    }

    public static void main(String []args){
        BinaryTree<Integer> raiz = new BinaryTree<>(10);
        BinaryTree<Integer> nodo4 = new BinaryTree<>(4);
        BinaryTree<Integer> nodo6 = new BinaryTree<>(6);
        BinaryTree<Integer> nodo8 = new BinaryTree<>(8);
        BinaryTree<Integer> nodo2 = new BinaryTree<>(2);
        BinaryTree<Integer> nodo9 = new BinaryTree<>(9);
        BinaryTree<Integer> nodo5 = new BinaryTree<>(5);

        raiz.addLeftChild(nodo4);
        raiz.addRightChild(nodo6);
        nodo4.addLeftChild(nodo8);
        nodo6.addLeftChild(nodo2);
        nodo6.addRightChild(nodo9);
        nodo2.addRightChild(nodo5);

        raiz.printLevelTraversal();
        BinaryTree<Integer> prom = promedio(raiz);
        System.out.println();
        System.out.println();
        System.out.println("otro");
        System.out.println();
        prom.printLevelTraversal();

    }
}
