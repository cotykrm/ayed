/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

import java.util.*;
/*Defina una clase Java denominada ContadorArbol cuya función principal es proveer métodos de
validación sobre árboles binarios de enteros. Para ello la clase tiene como variable de instancia un
BinaryTree<Integer>. Implemente en dicha clase un método denominado numerosPares() que
devuelve en una estructura adecuada (sin ningún criterio de orden) todos los elementos pares del
árbol (divisibles por 2).
a) Implemente el método realizando un recorrido InOrden.
b) Implemente el método realizando un recorrido PostOrden.*/
/**
 *
 * @author Constanza
 */
public class ContadorArbol {
    private BinaryTree<Integer> arbol;
    
    public ContadorArbol(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }
    
    public List<Integer> validarInOrden(){
        List <Integer> pares = new ArrayList<>();
        validarInOrden_p(pares,arbol);
        return pares;
    }
    
    private void validarInOrden_p(List<Integer> lista, BinaryTree<Integer> ab){
        if(ab.hasLeftChild())
            validarInOrden_p(lista,ab.getLeftChild());
        if(ab.getData()%2==0)
            lista.add(ab.getData());
        if(ab.hasRightChild())
            validarInOrden_p(lista,ab.getRightChild());
   
    }
    
    public List<Integer> validarPostOrden(){
        List <Integer> pares = new ArrayList<>();
        validarPostOrden_p(pares,arbol);
        return pares;
    }
    
    private void validarPostOrden_p(List<Integer> lista, BinaryTree<Integer> ab){
        if(ab.hasLeftChild())
            validarPostOrden_p(lista,ab.getLeftChild());
        if(ab.hasRightChild())
            validarPostOrden_p(lista,ab.getRightChild());
        if(ab.getData()%2==0)
            lista.add(ab.getData());
   
    }
    
    
    public static void main(String[] args){
        BinaryTree<Integer> ab = new BinaryTree<Integer>(40);
        BinaryTree<Integer> hijoIzquierdo = new BinaryTree<Integer>(25);
        hijoIzquierdo.addLeftChild(new BinaryTree<Integer>(10));
        hijoIzquierdo.addRightChild(new BinaryTree<Integer>(32));
        BinaryTree<Integer> hijoDerecho= new BinaryTree<Integer>(78);
        ab.addLeftChild(hijoIzquierdo);
        ab.addRightChild(hijoDerecho);
        ContadorArbol cont = new ContadorArbol(ab);
        List <Integer> pares = cont.validarInOrden();
        for(int i = 0; i<pares.size(); i++)
            System.out.println(pares.get(i));
        pares = cont.validarPostOrden();
        for(int i = 0; i<pares.size(); i++)
            System.out.println(pares.get(i));
        
    }
}
