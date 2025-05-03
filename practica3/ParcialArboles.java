package practica3;
import practica1.ejercicio8.Queue;

public class ParcialArboles {



    /*Implemente en la clase ParcialArboles el método:
public static boolean esDeSeleccion (GeneralTree<Integer> arbol)
que devuelve true si el árbol recibido por parámetro es de selección, falso sino lo es.
Un árbol general es de selección si cada nodo tiene en su raíz el valor del menor de sus hijos.Por
ejemplo, para el siguiente árbol se debería retornar:  

    public static boolean esDeSeleccion (GeneralTree<Integer> arbol){

    }

*/
    /*public static boolean resolver(GeneralTree<Integer> arbol) que devuelve true si el árbol es creciente,
falso sino lo es.
Un árbol general es creciente si para cada nivel del árbol la cantidad de nodos que hay en ese nivel es
exactamente igual a la cantidad de nodos del nivel anterior + 1.
 */

    public static boolean resolver(GeneralTree<Integer> arbol){
        if(arbol != null && !arbol.isEmpty()){
            GeneralTree<Integer> tree_aux;
            Queue<GeneralTree<Integer>> queue = new Queue<GeneralTree<Integer>>();
            int nodosAc = 0; int nodosAnt = 0;
            boolean esCreciente = true;
            queue.enqueue(arbol);
            queue.enqueue(null);
            while((!queue.isEmpty())&&(esCreciente)){
                tree_aux = queue.dequeue();
                if(tree_aux != null){
                    nodosAc++;
                    if(tree_aux.hasChildren()){
                        for(GeneralTree<Integer> child : tree_aux.getChildren())
                            queue.enqueue(child);
                    }
                }
                else{
                    if(!queue.isEmpty()){
                        queue.enqueue(null);
                        if(nodosAnt != 0)
                            if(nodosAc - nodosAnt != 1)
                              esCreciente = false;
                        nodosAnt = nodosAc;
                        nodosAc = 0;
                    }
                }
                
            }
            return esCreciente;
        }
        return false;
    }

    public static void main(String [] args){
        GeneralTree<Integer> n2  = new GeneralTree<Integer>(2);
        GeneralTree<Integer> n1  = new GeneralTree<Integer>(1);
        GeneralTree<Integer> n25 = new GeneralTree<Integer>(25);
        GeneralTree<Integer> n13 = new GeneralTree<Integer>(13);
        GeneralTree<Integer> n5  = new GeneralTree<Integer>(5);
        GeneralTree<Integer> n4  = new GeneralTree<Integer>(4);
        GeneralTree<Integer> n18 = new GeneralTree<Integer>(18);
        GeneralTree<Integer> n7  = new GeneralTree<Integer>(7);
        GeneralTree<Integer> n11 = new GeneralTree<Integer>(11);
        GeneralTree<Integer> n3  = new GeneralTree<Integer>(3);
        GeneralTree<Integer> n83 = new GeneralTree<Integer>(83);
        GeneralTree<Integer> n33 = new GeneralTree<Integer>(33);
        GeneralTree<Integer> n12 = new GeneralTree<Integer>(12);
        GeneralTree<Integer> n17 = new GeneralTree<Integer>(17);
        GeneralTree<Integer> n9  = new GeneralTree<Integer>(9);

        // Construcción del árbol
        n2.addChild(n1);
        n2.addChild(n25);
        n25.addChild(n13);

        n1.addChild(n5);
        n1.addChild(n4);

        n5.addChild(n18);
        n18.addChild(n83);

        n4.addChild(n7);
        n4.addChild(n11);
        n4.addChild(n3);

        n3.addChild(n33);
        n3.addChild(n12);
        n3.addChild(n17);
        n3.addChild(n9);

        System.out.println("es creciente? "+ resolver(n2));
    }
}
