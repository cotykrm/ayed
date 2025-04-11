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
/*Los nodos que conforman una red binaria llena tiene la particularidad de que todos ellos conocen
cuál es su retardo de reenvío. El retardo de reenvío se define como el período comprendido entre
que un nodo recibe un mensaje y lo reenvía a sus dos hijos.
Su tarea es calcular el mayor retardo posible, en el camino que realiza un mensaje desde la raíz
hasta llegar a las hojas en una red binaria llena. En el ejemplo, debería retornar 10+3+9+12=34
(Si hay más de un máximo retorne el último valor hallado).
Nota: asuma que cada nodo tiene el dato de retardo de reenvío expresado en cantidad de
segundos.
a) Indique qué estrategia (recorrido en profundidad o por niveles) utilizará para resolver el
problema.
b) Cree una clase Java llamada RedBinariaLlena donde implementará lo solicitado en el
método retardoReenvio():int*/

public class RedBinariaLlena {
    


    public static int retardoReenvio(BinaryTree<Integer> dis) {
    	BinaryTree<Integer> ab = null;
    	Queue<BinaryTree<Integer>> cola = new Queue<BinaryTree<Integer>>();
    	cola.enqueue(dis);
    	cola.enqueue(null);
        int max = -1;
        int total = 0;
    	while (!cola.isEmpty()) {
            ab = cola.dequeue();
            if (ab != null) {
    		System.out.print(ab.getData());
                if(ab.getData()>max)
                    max = ab.getData();
    		if (ab.hasLeftChild()) {
                    cola.enqueue(ab.getLeftChild());
    		}
    		if (ab.hasRightChild()) {
                    cola.enqueue(ab.getRightChild());
    		}
            } else if (!cola.isEmpty()) {
                total += max;
                max = -1;
    		System.out.println();
    		cola.enqueue(null);
            }
        }
        return total;
    }
    
    
    public static void main(String[] args){
        BinaryTree<Integer> ab = new BinaryTree<Integer>(40);
        BinaryTree<Integer> hijoIzquierdo = new BinaryTree<Integer>(25);
        hijoIzquierdo.addLeftChild(new BinaryTree<Integer>(10));
        hijoIzquierdo.addRightChild(new BinaryTree<Integer>(32));
        BinaryTree<Integer> hijoDerecho= new BinaryTree<Integer>(78);
        ab.addLeftChild(hijoIzquierdo);
        ab.addRightChild(hijoDerecho);
        System.out.println("\nTotal de retardo: "+retardoReenvio(ab));
    }
}
