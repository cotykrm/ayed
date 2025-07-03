package parciales;
import practica2.BinaryTree;

public class prueba {

    public static void recorrido(BinaryTree<Character> arbol){
        if(!arbol.isEmpty()){
            System.out.println(arbol.getData());
            if(arbol.hasLeftChild())
                recorrido(arbol.getLeftChild());
            if(arbol.hasRightChild())
                recorrido(arbol.getRightChild());
            System.out.println(arbol.getData());
        }
    }

    public static void main (String [] args){
        BinaryTree<Character> c = new BinaryTree<Character>('c');
        BinaryTree<Character> a = new BinaryTree<Character>('a');
        BinaryTree<Character> e = new BinaryTree<Character>('e');
        a.addLeftChild(new BinaryTree<Character>('b'));
        e.addLeftChild(new BinaryTree<Character>('d'));
        a.addRightChild(new BinaryTree<Character>('f'));
        c.addLeftChild(a);
        c.addRightChild(e);
        recorrido(c);
    }

}