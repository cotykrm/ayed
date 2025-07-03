package parciales;

/*Defina una clase ParcialArboles que contenga el siguiente método:
public static List<Integer> caminoParidadAlternante(GeneralTree<Integer> arbol)
que recibe un árbol general de valores enteros y devuelve una lista con los valores de 
los nodos del camino más largo (máxima cantidad de nodos) desde la raíz hasta una hoja 
tal que los valores alternen entre par e impar en cada paso.
Esto significa que cada nodo del camino debe tener paridad distinta a la de su padre 
(por ejemplo, si un nodo es par, su hijo inmediato debe ser impar y viceversa).

Si existen varios caminos con la misma longitud máxima que cumplen con la alternancia de 
paridad, se debe devolver el primer camino encontrado en un recorrido de izquierda a derecha.

En caso de no existir ningún camino desde la raíz hasta una hoja que cumpla con esta 
condición, el método debe devolver una lista vacía.

Nota: El número 0 es par.*/

import practica3.GeneralTree;
import java.util.LinkedList;
import java.util.List;


public class ParcialArboless {

    private static boolean paridad(int a, int b){
        if((b % 2 == 0 && a % 2 != 0)||(b % 2 != 0 && a % 2 == 0))
            return true;
        return false;
    }

    private static List<Integer> metodoPriv(GeneralTree<Integer> arbol, List<Integer> lista, 
        List<Integer> camino){
        int data = arbol.getData();
        boolean sigo;
        if(!lista.isEmpty()){
            int ant = lista.get(lista.size()-1);
            sigo = paridad(data,ant);
        }
        else
            sigo = true;
        lista.add(data);
        System.out.println(sigo);
        if(arbol.isLeaf() && sigo && lista.size()>camino.size()){
            camino.clear();
            camino.addAll(lista);
        }
        else if(sigo){
            for(GeneralTree<Integer> child : arbol.getChildren())
                metodoPriv(child, lista, camino);
        }
        lista.remove(lista.size()-1);
        return camino;

    }

    public static List<Integer> caminoParidadAlternante(GeneralTree<Integer> arbol){
        List<Integer> camino = new LinkedList<Integer>();
        if(arbol!=null && !arbol.isEmpty()){
            List<Integer> lista = new LinkedList<Integer>();
            camino = metodoPriv(arbol, lista, camino);
        }

        return camino;
    }

    public static void main(String []args){
        /*// Nivel 0 (raíz)
        GeneralTree<Integer> root = new GeneralTree<>(2); // par

        // Nivel 1
        GeneralTree<Integer> n1 = new GeneralTree<>(3); // impar
        GeneralTree<Integer> n2 = new GeneralTree<>(4); // par

        // Nivel 2
        GeneralTree<Integer> n11 = new GeneralTree<>(6); // par
        GeneralTree<Integer> n12 = new GeneralTree<>(8); // impar
        GeneralTree<Integer> n21 = new GeneralTree<>(7); // impar

        // Nivel 3
        GeneralTree<Integer> n111 = new GeneralTree<>(10); // par
        GeneralTree<Integer> n121 = new GeneralTree<>(9); // impar
        GeneralTree<Integer> n211 = new GeneralTree<>(11); // par

        // Armar el árbol
        n1.addChild(n11);
        n1.addChild(n12);
        n2.addChild(n21);

        n11.addChild(n111);
        //n12.addChild(n121);
        n21.addChild(n211);

        root.addChild(n1);
        root.addChild(n2);

        // Ejemplo de uso del método
        root.porNiveles();
        List<Integer> camino = caminoParidadAlternante(root);
        System.out.println(camino);
        */
        GeneralTree<Integer> arbol = new GeneralTree<>(2);

        // Hijo izquierdo de la raíz: 3
        GeneralTree<Integer> nodo3 = new GeneralTree<>(3);
        nodo3.addChild(new GeneralTree<>(1));
        nodo3.addChild(new GeneralTree<>(4));
        GeneralTree<Integer> nodo6A = new GeneralTree<>(6);
        nodo6A.addChild(new GeneralTree<>(8)); // 6 -> 8
        nodo3.addChild(nodo6A);

        // Hijo derecho de la raíz: 5
        GeneralTree<Integer> nodo5 = new GeneralTree<>(5);
        nodo5.addChild(new GeneralTree<>(6));

        // Agregar hijos a la raíz
        arbol.addChild(nodo3);
        arbol.addChild(nodo5);

        arbol.porNiveles();
        List<Integer> camino = caminoParidadAlternante(arbol);
        System.out.println(camino);
    }
}

