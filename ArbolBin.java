package parciales;

import practica2.BinaryTree;

/*Defina una clase ParcialArboles con:
(i) una única variable de instancia de tipo BinaryTree<Integer>, y
(ii) un método público con la siguiente firma:

public BinaryTree<Integer> nuevoTree()
El método debe devolver un nuevo árbol, construido de la siguiente forma:

Si el árbol dado tiene hijo izquierdo, el nuevo árbol tendrá hijo izquierdo cuyo 
valor será la suma del valor del hijo izquierdo y el valor del padre del árbol dado.
Si el árbol dado no tiene hijo izquierdo, tampoco lo tendrá el nuevo.
Los hijos derechos del nuevo árbol son iguales que los del árbol dado.
Las hojas del árbol dado serán hojas en el nuevo. */

public class ArbolBin {

    private BinaryTree<Integer> arbol;

    public ArbolBin(BinaryTree<Integer> arbol){
        this.arbol = arbol;
    }

    public BinaryTree<Integer> getData(){
        return this.arbol;
    }
    
    private void privado(BinaryTree<Integer> viejo, BinaryTree<Integer> nuevo){
        if(viejo.hasLeftChild()){
            int iz = viejo.getLeftChild().getData();
            BinaryTree<Integer> izq = new BinaryTree<>(viejo.getData()+iz);
            nuevo.addLeftChild(izq);
            privado(viejo.getLeftChild(), nuevo.getLeftChild());
        }

        if(viejo.hasRightChild()){
            int de = viejo.getRightChild().getData();
            BinaryTree<Integer> der = new BinaryTree<>(de);
            nuevo.addRightChild(der);
            privado(viejo.getRightChild(), nuevo.getRightChild());
        }
    }

    public BinaryTree<Integer> nuevoTree(){
        BinaryTree<Integer> nuevo = new BinaryTree<>();
        if(this.arbol != null && !this.arbol.isEmpty()){
            nuevo.setData(this.arbol.getData());
            privado(this.arbol,nuevo);
        }
        return nuevo;
    }

}
