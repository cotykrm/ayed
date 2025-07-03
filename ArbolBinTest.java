package parciales;

import practica2.BinaryTree;

public class ArbolBinTest {
    public static void main(String[] args) {
        BinaryTree<Integer> raiz = new BinaryTree<>(1);
        BinaryTree<Integer> n2 = new BinaryTree<>(2);
        BinaryTree<Integer> n3 = new BinaryTree<>(3);
        BinaryTree<Integer> n4 = new BinaryTree<>(4);
        BinaryTree<Integer> n5 = new BinaryTree<>(5);
        BinaryTree<Integer> n6 = new BinaryTree<>(6);
        BinaryTree<Integer> n7 = new BinaryTree<>(7);

        raiz.addLeftChild(n2);
        raiz.addRightChild(n3);
        n2.addLeftChild(n4);
        n3.addLeftChild(n5);
        n3.addRightChild(n6);
        n5.addLeftChild(n7);
        ArbolBin ar = new ArbolBin(raiz);
        BinaryTree<Integer> nuevo = ar.nuevoTree();
        ar.getData().printLevelTraversal();
        nuevo.printLevelTraversal();
    }
}
