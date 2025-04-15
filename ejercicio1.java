/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;
/**
 *
 * @author Constanza
 */
public class ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BinaryTree<Integer> ab = new BinaryTree<Integer>(40);
        BinaryTree<Integer> hijoIzquierdo = new BinaryTree<Integer>(25);
        hijoIzquierdo.addLeftChild(new BinaryTree<Integer>(10));
        hijoIzquierdo.addRightChild(new BinaryTree<Integer>(32));
        BinaryTree<Integer> hijoDerecho= new BinaryTree<Integer>(78);
        ab.addLeftChild(hijoIzquierdo);
        ab.addRightChild(hijoDerecho);
        //ab.preOrden();
        //ab.inOrden();
        //ab.postOrden();
        //System.out.println("Cantidad de hojas: "+ab.contarHojas());
        //ab.printLevelTraversal();
        BinaryTree<Integer> ab2 = new BinaryTree<Integer>(1);
        BinaryTree<Integer> hi = new BinaryTree<Integer>(2);
        hi.addLeftChild(new BinaryTree<Integer>(4));
        BinaryTree<Integer> hd= new BinaryTree<Integer>(3);
        BinaryTree<Integer> hi2 = new BinaryTree<Integer>(5); 
        hd.addRightChild(new BinaryTree<Integer>(3));
        hi2.addLeftChild(new BinaryTree<Integer>(7));
        hi2.addRightChild(new BinaryTree<Integer>(8));
        hd.addLeftChild(hi2);
        hd.addRightChild(new BinaryTree<Integer>(6));
        ab2.addLeftChild(hi);
        ab2.addRightChild(hd);
        //ab2.postOrden();
        //ab2.preOrden();
        ab2.printLevelTraversal();
    }
    
    
    
}
