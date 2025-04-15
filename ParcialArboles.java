package practica2;

import java.util.*;

public class ParcialArboles {
    private BinaryTree <Integer> arbol;


    public BinaryTree<Integer> buscar(BinaryTree <Integer> ab,int n){
    	BinaryTree<Integer> retorno = new BinaryTree<Integer>();
    	if(ab.getData()== n) {
    		retorno = ab;
    		return retorno;
    	}       
        if(ab.hasLeftChild())
        	buscar(ab.getLeftChild(),n);
        if(ab.hasRightChild())
        	buscar(ab.getRightChild(),n);
        return retorno;
    }
    
    public void sumar(BinaryTree<Integer> ab, int cant) {
    	if(ab.hasLeftChild()^ab.hasRightChild())
    		cant++;
    	if(ab.hasLeftChild())
    	  	sumar(ab.getLeftChild(),cant);
    	if(ab.hasRightChild())
    	    sumar(ab.getRightChild(),cant);
    	    
    }
    
    public boolean isLeftTree(int num){
        boolean aux = false;
        int cantI = 0;
        int cantD = 0;
        BinaryTree<Integer> ab = buscar(this,num);
        if(ab.isLeaf())
        	return false;
        if(ab.hasLeftChild()&&ab.hasRightChild()) {
        	sumar(ab.getLeftChild(),cantI);
            sumar(ab.getRightChild(),cantD);
        } else if(ab.hasLeftChild()) {
        	sumar(ab.getLeftChild(),cantI);
        	cantD = -1;
        } else {
        	sumar(ab.getRightChild(),cantD);
        	cantI = -1;
        }
        if(cantI>cantD)
        	aux = true;
        return aux;
     }

    
}
