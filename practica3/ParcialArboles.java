package practica3;
import practica1.ejercicio8.Queue;
import java.util.LinkedList;
import java.util.List;

public class ParcialArboles {



    /*Implemente en la clase ParcialArboles el método:
public static boolean esDeSeleccion (GeneralTree<Integer> arbol)
que devuelve true si el árbol recibido por parámetro es de selección, falso sino lo es.
Un árbol general es de selección si cada GeneralTree<Integer> tiene en su raíz el valor del menor de sus hijos
*/  
    private static boolean esDeSeleccionP(GeneralTree<Integer> arbol){
        if(arbol.isLeaf())
            return true;
        int min = Integer.MAX_VALUE;
        boolean hijosCumplen = true;
        for(GeneralTree<Integer> child: arbol.getChildren()){
            if(child.getData()<min)
                min = child.getData();
        
        hijosCumplen = hijosCumplen && esDeSeleccionP(child);
        }
        return arbol.getData() == min && hijosCumplen;
    }

    public static boolean esDeSeleccion(GeneralTree<Integer> arbol){
        if(arbol!=null && !arbol.isEmpty()){
            return esDeSeleccionP(arbol);
        }
        return false;
    }


/*Implemente la clase ParcialArboles, y el método:
public static List<Integer> caminoFiltradoMaximo(GeneralTree<Integer> arbol)
que recibe un árbol general de valores enteros, que solo pueden ser 0 o 1 y devuelve una lista con los
valores que componen el “camino filtrado de valor máximo”, se llama “filtrado” porque sólo se agregan al
camino los valores iguales a 1 (los 0 no se agregan), mientras que es “de valor máximo” porque se obtiene
de realizar el siguiente cálculo: es la suma de los valores de los GeneralTree<Integer>s multiplicados por 
su nivel. De haber más de uno, devolver el primero que se encuentre. */
    

    private static void caminoFiltradoMaximoP(GeneralTree<Integer> arbol, List<Integer> camino, 
        List<Integer> lista, int[] valorMaximo, int nivel){

            if(arbol!=null){
            
                if(arbol.getData() == 1)
                    lista.add(arbol.getData());
            
                if(arbol.isLeaf()){
                    int valor = 0;
                    for (int i = 0; i < lista.size(); i++) {
                        valor += lista.get(i) * nivel;
                    }
                    if(valor>valorMaximo[0]){
                        valorMaximo[0] = valor;
                        camino.clear();
                        camino.addAll(lista);
                    }

                } else {
                    for (GeneralTree<Integer> child : arbol.getChildren()) {
                        caminoFiltradoMaximoP(child, camino, lista, valorMaximo, nivel + 1); // Incrementar el nivel al descender
                    }
                }
                lista.remove(lista.size() - 1);
            }
    }

    public static List<Integer> caminoFiltradoMaximo(GeneralTree<Integer> arbol){
        
        if(arbol != null && !arbol.isEmpty()){
            List<Integer> camino = new LinkedList<Integer>();
            List<Integer> lista = new LinkedList<Integer>();
            int[] valorMaximo = {0};
            caminoFiltradoMaximoP(null, camino, lista, valorMaximo, 0);
            return camino;
        }
        return new LinkedList<>();
        
    }




    /*public static boolean resolver(GeneralTree<Integer> arbol) que devuelve true si el árbol es creciente,
falso sino lo es.
Un árbol general es creciente si para cada nivel del árbol la cantidad de GeneralTree<Integer>s que hay en ese nivel es
exactamente igual a la cantidad de GeneralTree<Integer>s del nivel anterior + 1.
 */

    public static boolean resolver1(GeneralTree<Integer> arbol){
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
                        if(nodosAc - nodosAnt != 1)
                            esCreciente = false;
                        nodosAnt = nodosAc;
                        nodosAc = 0;
                    }
                }
            
            }
            
            if(nodosAc - nodosAnt != 1)
                esCreciente = false;


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

        System.out.println("es creciente? "+ resolver1(n2));

        
        /*
        GeneralTree<Integer> n12_root = new GeneralTree<Integer>(12);

        GeneralTree<Integer> n12_left = new GeneralTree<Integer>(35);
        GeneralTree<Integer> n25_right = new GeneralTree<Integer>(25);

        GeneralTree<Integer> n35_left = new GeneralTree<Integer>(35);
        GeneralTree<Integer> n12_middle = new GeneralTree<Integer>(12);

        GeneralTree<Integer> n35_left_child = new GeneralTree<Integer>(35);
        GeneralTree<Integer> n14 = new GeneralTree<Integer>(14);
        GeneralTree<Integer> n12_leaf = new GeneralTree<Integer>(12);
        GeneralTree<Integer> n33 = new GeneralTree<Integer>(33);

        GeneralTree<Integer> n35_leaf = new GeneralTree<Integer>(35);
        GeneralTree<Integer> n83 = new GeneralTree<Integer>(83);
        GeneralTree<Integer> n90 = new GeneralTree<Integer>(90);
        GeneralTree<Integer> n33_leaf = new GeneralTree<Integer>(33);

        GeneralTree<Integer> n25_leaf = new GeneralTree<Integer>(25);
        GeneralTree<Integer> n35_leaf_child = new GeneralTree<Integer>(35);

        // Construir el árbol
        n12_root.addChild(n12_left);
        n12_root.addChild(n12_middle);
        n12_root.addChild(n25_right);

        n12_left.addChild(n35_left);
        n35_left.addChild(n35_left_child);
        n35_left_child.addChild(n35_leaf_child);

        n12_middle.addChild(n14);
        n12_middle.addChild(n12_leaf);
        n12_middle.addChild(n33);

        n33.addChild(n35_leaf);
        n33.addChild(n83);
        n33.addChild(n90);
        n33.addChild(n33_leaf);

        n25_right.addChild(n25_leaf);

        System.out.println("Es de seleccion? "+esDeSeleccion(n12_root));

            *//*

        GeneralTree<Integer> root = new GeneralTree<Integer>(1);

        GeneralTree<Integer> h1_1 = new GeneralTree<Integer>(0);
        GeneralTree<Integer> h1_2 = new GeneralTree<Integer>(1);
        GeneralTree<Integer> h1_3 = new GeneralTree<Integer>(1);

        GeneralTree<Integer> h2_1 = new GeneralTree<Integer>(1);
        GeneralTree<Integer> h2_2 = new GeneralTree<Integer>(1);
        GeneralTree<Integer> h2_3 = new GeneralTree<Integer>(1);
        GeneralTree<Integer> h2_4 = new GeneralTree<Integer>(0);
        GeneralTree<Integer> h2_5 = new GeneralTree<Integer>(0);

        GeneralTree<Integer> h3_1 = new GeneralTree<Integer>(1);
        GeneralTree<Integer> h3_2 = new GeneralTree<Integer>(1);
        GeneralTree<Integer> h3_3 = new GeneralTree<Integer>(1);
        GeneralTree<Integer> h3_4 = new GeneralTree<Integer>(0);
        GeneralTree<Integer> h3_5 = new GeneralTree<Integer>(0);

        GeneralTree<Integer> h4_1 = new GeneralTree<Integer>(1);
        GeneralTree<Integer> h4_2 = new GeneralTree<Integer>(0);
        GeneralTree<Integer> h4_3 = new GeneralTree<Integer>(0);
        
        root.addChild(h1_1);
        root.addChild(h1_2);
        root.addChild(h1_3);

        h1_1.addChild(h2_1);
        h1_1.addChild(h2_2);

        h1_2.addChild(h2_3);
        h1_2.addChild(h2_4);

        h1_3.addChild(h2_5);

        h2_1.addChild(h3_1);
        h2_1.addChild(h3_2);
        h2_1.addChild(h3_3);

        h2_4.addChild(h3_4);

        h2_5.addChild(h3_5);

        h3_4.addChild(h4_1);

        h3_5.addChild(h4_2);
        h3_5.addChild(h4_3);

        root.porNiveles();
         
        List<Integer> camino = caminoFiltradoMaximo(root);

        System.out.println(camino);
        
        
        */
    }
}
