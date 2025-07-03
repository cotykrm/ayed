package parciales;
import practica2.BinaryTree;
import practica3.GeneralTree;
import practica1.ejercicio8.Queue;
import java.util.LinkedList;
import java.util.List;

/* Defina una clase ParcialArboles con: (i) una unica variable de instancia 
de tipo ArbolGeneral de enteros y (ii) un metodo publico con la siguiente 
firma: public ListaGenerica <Integer> camino (int num). el metodo debe 
devolver un camino desde la raiz hasta una hoja en donde cada nodo (no hoja) 
tenga al menos la cantidad num de hijos. Debe retornar el primer camino que 
encuentre que cumpla la condicion. En el caso de no encontrar ninguno, retornar 
la lista vacia.

*/

public class ParcialArboles {
    private GeneralTree<Integer> arbol;

    public ParcialArboles(GeneralTree<Integer> arbol){
        this.arbol = arbol;
    }

    public static boolean camino (GeneralTree<Integer> arbol,List<Integer> lista, int num){
        lista.add(arbol.getData());
        
        if(arbol.isLeaf()){
            return true;
        }
        
        List<GeneralTree<Integer>> children = arbol.getChildren();
        if(children.size()>= num){
            for(GeneralTree<Integer> child : children){
                if(camino(child,lista,num))
                  return true;
            }
        }
        lista.remove(lista.size() - 1);
        return false;
    }

    public List<Integer> camino (int num){
        if(this.arbol != null && !this.arbol.isEmpty()){
            List<Integer> lista = new LinkedList<>();
            if(camino(this.arbol, lista, num))
                return lista;
        }
        return new LinkedList<>();
        
    }


    public static List<Integer> nivel (GeneralTree<Integer> arbol, int num){
        if(arbol != null && !arbol.isEmpty()){
            List<Integer> nodos = new LinkedList<Integer>();
            Queue<GeneralTree<Integer>> queue = new Queue<GeneralTree<Integer>>();
            GeneralTree<Integer> tree_aux;
            queue.enqueue(arbol);
            queue.enqueue(null);
            boolean sirve = true;
            while(!queue.isEmpty()){
                tree_aux = queue.dequeue();
                if(tree_aux != null){
                    if(tree_aux.hasChildren()){
                        List<GeneralTree<Integer>> children = tree_aux.getChildren();
                        nodos.add(tree_aux.getData());
                        if(children.size() < num){
                            sirve = false;
                        }
                        for(GeneralTree<Integer> child : children)
                            queue.enqueue(child);
                        
                    }
                }
                else {
                    if(!queue.isEmpty()){
                        if(sirve)
                            return nodos;
                        nodos.clear();
                        sirve = true;
                        queue.enqueue(null);
                    }
                }
            }
        }
        return new LinkedList<Integer>();
    }

    /*Implemente en la clase Parcial el metodo resolver que recibe un arbol binario de enteros
     * positivos y un numero entero y devuleve un camino que cumple con la siguiente condicion:
     * la cantidad de numeros pares que contenga dicho camino debe ser mayor o igual al
     * parametro "min". Si existen varios caminos que cumplen la condicion, el metodo debe
     * devolver el primer camino que encuentre.
     *      public ListaGenerica<Integer> resolver(ArbolBinario<Integer> ab, int min)
     */
    
     private static boolean resolverPriv(BinaryTree<Integer> ab, List<Integer> camino, int min, int pares) {
        // Agregar el nodo actual al camino
        camino.add(ab.getData());

        // Incrementar el contador de pares si el nodo actual es par
        if (ab.getData() % 2 == 0) {
            pares++;
        }

        // Caso base: si el nodo es una hoja
        if (ab.isLeaf()) {
            // Verificar si el número de pares es mayor o igual a `num`
            if (pares >= min) {
                return true; // Camino válido encontrado
            }
            camino.remove(camino.size() - 1); // Backtracking
            return false; // No cumple la condición
        }

        // Caso recursivo: explorar los hijos izquierdo y derecho
        if (ab.hasLeftChild()) {
            if (resolverPriv(ab.getLeftChild(), camino, min, pares)) {
                return true; // Detener la búsqueda si se encuentra un camino válido
            }
        }
        if (ab.hasRightChild()) {
            if (resolverPriv(ab.getRightChild(), camino, min, pares)) {
                return true; // Detener la búsqueda si se encuentra un camino válido
            }
        }

        // Backtracking: eliminar el nodo actual del camino
        camino.remove(camino.size() - 1);
        return false; // No se encontró un camino válido en esta rama
    }


    public static List<Integer> resolver(BinaryTree<Integer> ab, int min){
        List<Integer> camino = new LinkedList<Integer>();
        if(ab != null && !ab.isEmpty()){
            resolverPriv(ab,camino,min,0);
        }
        return camino;
    }

    /*------------------------------------------------------------------------------------------------------ 
     * Parcial Programacion III 28/04/2025
    */

    private static void caminoPriv(GeneralTree<String> camaras ,List<GeneralTree<String>> camino, 
        List<GeneralTree<String>> lista){
            if(camaras.getData().equals("Tesoro")){
                lista.add(camaras);
                if(camino.isEmpty())
                    camino.addAll(lista);
                if(lista.size() < camino.size()){
                    camino.clear();
                    camino.addAll(lista);
                }
            }
            if(camaras.hasChildren()){
                List<GeneralTree<String>> children = camaras.getChildren();
                for(GeneralTree<String> child : children){
                    if(!child.getData().equals("Bloqueo")){
                        lista.add(child);
                        caminoPriv(child,camino,lista);
                    }
                }
            }
            lista.remove(lista.size()-1);

        }

    public static GeneralTree<String> tesoroMasAccesibleMasCercano(GeneralTree<String> camaras){
        GeneralTree<String> tesoro = new GeneralTree<>();
        if(camaras != null && !camaras.isEmpty()){
            List<GeneralTree<String>> camino = new LinkedList<GeneralTree<String>>();
            List<GeneralTree<String>> lista = new LinkedList<GeneralTree<String>>();
            caminoPriv(camaras,camino,lista);
            if(!camino.isEmpty())
                return camino.get(camino.size()-1);
        }
        return tesoro;
    }

    /*si hay que devolver el primer camino que cumple x condicion: 

    private List<GeneralTree<T>> resolver(GeneralTree<T> arbol, List<GeneralTree<T>> camino){
        if(se cumple la condicion)
            camino.add(arbol.getData());
        if(arbol.isLeaf())
            return camino;
        for(GeneralTree<T> child : arbol.getChildren())
            resolver(child,camino);
        camino.remove(camino.size()-1);
        return camino;
    }
    */

    /*Un arbol general a1 se considera "profundamente inferior" a otro arbol general a2 cuando se cumplen las
     * siguientes dos reglas en todos los nodos coincidentes en posicion en ambos arboles:
     * 1. el valor de cada nodo en a1 debe ser menor que el valor del nodo correspondiente en a2.
     * a) si ambos nodos tienen hijos, la suma de los valores de los hijos de cada nodo de a1 debe ser menor
     * que la suma de los valores de los hijos del nodo correspondiente en a2.
     * b) si ambos nodos son hojas: la condicion se considera cumplida para esos nodos si se cumple la condicion 1.
     * 
     * si uno es hoja y el otro no:
     * c1) si un nodo de a1 es hoja y el nodo correspondiente en a2 no es hoja, entonces la condicion se considera 
     * cumplida para esos nodos si se cumple la condicion 1.
     * c2) si un nodo de a1 no es hoja y el nodo correspondiente en a2 es hoja, entonces a1 NO es profundamente
     * inferior y el metodo debe devolver false.
      */

      private boolean esInferiorProfundoPriv(GeneralTree<Integer> a1, GeneralTree<Integer> a2) {
    // Condición 1: El valor del nodo de a1 debe ser menor que el valor del nodo correspondiente en a2
    if (a1.getData() >= a2.getData()) {
        return false;
    }

    // Caso 2b: Ambos nodos son hojas
    if (a1.isLeaf() && a2.isLeaf()) {
        return true; // Cumple la condición 1
    }

    // Caso 2c1: a1 es hoja y a2 no es hoja
    if (a1.isLeaf() && !a2.isLeaf()) {
        return true; // Cumple la condición 1
    }

    // Caso 2c2: a1 no es hoja y a2 es hoja
    if (!a1.isLeaf() && a2.isLeaf()) {
        return false; // No cumple la condición
    }

    // Caso 2a: Ambos nodos tienen hijos
    if (a1.hasChildren() && a2.hasChildren()) {
        List<GeneralTree<Integer>> hijosA1 = a1.getChildren();
        List<GeneralTree<Integer>> hijosA2 = a2.getChildren();

        // Calcular la suma de los valores de los hijos de a1
        int sumaA1 = 0;
        for (GeneralTree<Integer> hijo : hijosA1) {
            sumaA1 += hijo.getData();
        }

        // Calcular la suma de los valores de los hijos de a2
        int sumaA2 = 0;
        for (GeneralTree<Integer> hijo : hijosA2) {
            sumaA2 += hijo.getData();
        }

        // Verificar que la suma de los valores de los hijos de a1 sea menor que la suma de los hijos de a2
        if (sumaA1 >= sumaA2) {
            return false;
        }

        // Verificar recursivamente para cada par de hijos correspondientes
        int minSize = Math.min(hijosA1.size(), hijosA2.size());
        for (int i = 0; i < minSize; i++) {
            if (!esInferiorProfundoPriv(hijosA1.get(i), hijosA2.get(i))) {
                return false;
            }
        }
    }

    return true; // Si pasa todas las condiciones, a1 es profundamente inferior a a2
}

      public boolean esInferiorProfundo(GeneralTree<Integer> a1, GeneralTree<Integer> a2){
            if(a1 != null && a2 != null && !a1.isEmpty() && a2.isEmpty()){
                return esInferiorProfundoPriv(a1, a2);
            }
            return false;
      }





    public static void main(String []args){
        /*
        GeneralTree<Integer> n10 = new GeneralTree<Integer>(10);

        GeneralTree<Integer> n8 = new GeneralTree<Integer>(8);
        GeneralTree<Integer> n42 = new GeneralTree<Integer>(42);
        GeneralTree<Integer> n_5 = new GeneralTree<Integer>(-5);

        GeneralTree<Integer> n5 = new GeneralTree<Integer>(5);
        GeneralTree<Integer> n22 = new GeneralTree<Integer>(22);
        GeneralTree<Integer> n19 = new GeneralTree<Integer>(19);
        GeneralTree<Integer> n_9 = new GeneralTree<Integer>(-9);

        GeneralTree<Integer> n6 = new GeneralTree<Integer>(6);
        GeneralTree<Integer> n28 = new GeneralTree<Integer>(28);
        GeneralTree<Integer> n55 = new GeneralTree<Integer>(55);
        GeneralTree<Integer> n18 = new GeneralTree<Integer>(18);
        GeneralTree<Integer> n4 = new GeneralTree<Integer>(4);

        n10.addChild(n8);
        n10.addChild(n42);
        n10.addChild(n_5);

        n8.addChild(n5);
        n8.addChild(n22);

        n_5.addChild(n19);
        n_5.addChild(n_9);

        n5.addChild(n6);

        n22.addChild(n28);
        n22.addChild(n55);
        n22.addChild(n18);

        n19.addChild(n4);


        ParcialArboles prueba = new ParcialArboles(n10);
        System.out.println(prueba.camino(1));
        */

        /*
        GeneralTree<Integer> raiz = new GeneralTree<Integer>(10);

        // Nivel 1
        GeneralTree<Integer> n8 = new GeneralTree<Integer>(8);
        GeneralTree<Integer> nMenos5 = new GeneralTree<Integer>(-5);
        raiz.addChild(n8);
        raiz.addChild(nMenos5);

        // Nivel 2
        GeneralTree<Integer> n5 = new GeneralTree<Integer>(5);
        GeneralTree<Integer> n22 = new GeneralTree<Integer>(22);
        GeneralTree<Integer> n19 = new GeneralTree<Integer>(19);
        n8.addChild(n5);
        n8.addChild(n22);
        nMenos5.addChild(n19);

        // Nivel 3 (hijos de 5)
        n5.addChild(new GeneralTree<Integer>(-6));
        n5.addChild(new GeneralTree<Integer>(2));
        n5.addChild(new GeneralTree<Integer>(6));

        // Nivel 3 (hijos de 22)
        n22.addChild(new GeneralTree<Integer>(28));
        n22.addChild(new GeneralTree<Integer>(55));
        n22.addChild(new GeneralTree<Integer>(18));

        // Nivel 3 (hijos de 19)
        n19.addChild(new GeneralTree<Integer>(4));
        n19.addChild(new GeneralTree<Integer>(2));
        n19.addChild(new GeneralTree<Integer>(8));
    
        System.out.println(nivel(raiz,1));

        

        BinaryTree<Integer> root = new BinaryTree<>(10);
        BinaryTree<Integer> left = new BinaryTree<>(5);
        BinaryTree<Integer> right = new BinaryTree<>(15);
        BinaryTree<Integer> leftLeft = new BinaryTree<>(3);
        BinaryTree<Integer> leftRight = new BinaryTree<>(6);
        BinaryTree<Integer> rightRight = new BinaryTree<>(20);

        root.addLeftChild(left);
        root.addRightChild(right);
        left.addLeftChild(leftLeft);
        left.addRightChild(leftRight);
        right.addRightChild(rightRight);

        System.out.println(resolver(root, 2));

        */

        GeneralTree<String> root = new GeneralTree<>("Inicio");
        GeneralTree<String> sala1 = new GeneralTree<>("Bloqueo");
        GeneralTree<String> sala2 = new GeneralTree<>("Sala2");
        GeneralTree<String> tesoro1 = new GeneralTree<>("Tesoro");
        GeneralTree<String> sala3 = new GeneralTree<>("Sala3");
        GeneralTree<String> tesoro2 = new GeneralTree<>("Tesoro");

        root.addChild(sala1);
        root.addChild(sala2);
        root.addChild(tesoro1);
        sala1.addChild(tesoro2);
        sala1.addChild(sala3);

        System.out.println(tesoroMasAccesibleMasCercano(root).getData());
    }
}
