/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

import practica1.ejercicio8.Queue;

/**
 *
 * @author Constanza
 */
/*Cree una clase Java llamada Transformacion que tenga como variable de instancia un árbol
binario de números enteros y un método de instancia suma (): BinaryTree<Integer> el cuál
devuelve el árbol en el que se reemplazó el valor de cada nodo por la suma de todos los
elementos presentes en su subárbol izquierdo y derecho. Asuma que los valores de los subárboles
vacíos son ceros*/
public class Transformacion {
    private BinaryTree<Integer> arbol;
    
    public Transformacion(BinaryTree<Integer> data){
        this.arbol = data;
    }
    
    public BinaryTree<Integer> suma() {
        transformar(arbol);
        return arbol;
    }
    
    private int transformar(BinaryTree<Integer> ab){
        if(ab == null)
            return 0;
        if(ab.isLeaf()){
            int val = ab.getData();
            ab.setData(0);
            return val;
        }
        int sumaIz = transformar(ab.getLeftChild());        
        int sumaDe = transformar(ab.getRightChild());
        int valorOriginal = ab.getData();
        ab.setData(sumaIz + sumaDe);   

        return ab.getData() + valorOriginal;
       
    }
    
    public static void main(String[] args){
        BinaryTree<Integer> ab2 = new BinaryTree<Integer>(1);
        BinaryTree<Integer> hi = new BinaryTree<Integer>(2);
        hi.addLeftChild(new BinaryTree<Integer>(4));
        BinaryTree<Integer> hd= new BinaryTree<Integer>(3);
        BinaryTree<Integer> hi2 = new BinaryTree<Integer>(5); 
        hi2.addLeftChild(new BinaryTree<Integer>(7));
        hi2.addRightChild(new BinaryTree<Integer>(8));
        hd.addLeftChild(hi2);
        hd.addRightChild(new BinaryTree<Integer>(6));
        ab2.addLeftChild(hi);
        ab2.addRightChild(hd);
        //ab2.preOrden();
        Transformacion ab = new Transformacion(ab2);
        BinaryTree<Integer> resultado = ab.suma();
        resultado.preOrden();
        
    }
    
}
    