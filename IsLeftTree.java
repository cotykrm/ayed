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
public class ParcialArboles {
    
    private BinaryTree <Integer> arbol;
    
    public BinaryTree<Integer> getData(){
        return this.arbol;
    }
    
    public void setData(BinaryTree<Integer> ab){
        this.arbol = ab;
    }
    
    /*public BinaryTree<Integer> buscar(BinaryTree <Integer> ab,int n){
    	BinaryTree<Integer> retorno = new BinaryTree<Integer>();
    	if(ab.getData()== n) {
            return ab;
    	}       
        if(ab.hasLeftChild())
        	buscar(ab.getLeftChild(),n);
        if(ab.hasRightChild())
        	buscar(ab.getRightChild(),n);
        return retorno;
    }*/
    public BinaryTree<Integer> buscar(BinaryTree<Integer> ab, int n) {
    if (ab == null) 
        return null;
    if (ab.getData() == n) 
        return ab;

    BinaryTree<Integer> encontrado = null;

    if (ab.hasLeftChild()) {
        encontrado = buscar(ab.getLeftChild(), n);
    }
    if (encontrado == null && ab.hasRightChild()) {
        encontrado = buscar(ab.getRightChild(), n);
    }
    return encontrado;
}
    
    public int sumar(BinaryTree<Integer> ab) {
        int cant = 0;
    	if(ab.hasLeftChild()^ab.hasRightChild())
            cant++;
    	if(ab.hasLeftChild())
            sumar(ab.getLeftChild());
    	if(ab.hasRightChild())
            sumar(ab.getRightChild());
        return cant;
    	    
    }
    
    public boolean isLeftTree(int num){
        boolean aux = false;
        int cantI = 0;
        int cantD = 0;
        BinaryTree<Integer> ab = buscar(this.arbol,num);
        if(ab == null || ab.isLeaf())
            return false;
        if(ab.hasLeftChild()&&ab.hasRightChild()) {
            cantI = sumar(ab.getLeftChild());
            cantD = sumar(ab.getRightChild());
        } else if(ab.hasLeftChild()) {
            cantI = sumar(ab.getLeftChild());
            cantD = -1;
        } else {
            cantD = sumar(ab.getRightChild());
            cantI = -1;
        }
        System.out.println("canti:"+cantI);
        System.out.println("cantd:"+cantD);
        if(cantI>cantD)
            aux = true;
        return aux;
     }

    public static void main(String [] args){
        ParcialArboles arbol = new ParcialArboles();
        BinaryTree<Integer> raiz = new BinaryTree<Integer>(2);
        BinaryTree<Integer> hi = new BinaryTree<Integer>(7);
        BinaryTree<Integer> hi2 = new BinaryTree<Integer>(23);
        hi2.addLeftChild(new BinaryTree<Integer>(-3));
        BinaryTree<Integer> hd2 = new BinaryTree<Integer>(8);
        hd2.addLeftChild(new BinaryTree<Integer>(55));
        hd2.addRightChild(new BinaryTree<Integer>(11));
        hi.addLeftChild(hi2);
        hi.addRightChild(hd2);
        BinaryTree<Integer> hd= new BinaryTree<Integer>(-5);
        BinaryTree<Integer> hdi= new BinaryTree<Integer>(19);
        BinaryTree<Integer> hdd= new BinaryTree<Integer>(4);
        hdd.addLeftChild(new BinaryTree<Integer>(18));
        hdi.addRightChild(hdd);
        hd.addLeftChild(hdi);
        raiz.addLeftChild(hi);
        raiz.addRightChild(hd);
        raiz.preOrden();
        arbol.setData(raiz);
        System.out.println(arbol.isLeftTree(7));
        
    }
    
}
