package practica3;

import java.util.LinkedList;
import java.util.List;

/*Dada una clase Caminos que contiene una variable de instancia de tipo GeneralTree de números
enteros, implemente un método que retorne el camino a la hoja más lejana. En el caso de haber
más de un camino máximo retorne el primero que encuentre.
El método debe tener la siguiente firma: public List<Integer> caminoAHojaMasLejana ()
 */

public class Caminos {
    private GeneralTree<Integer> arbol;

    public Caminos(GeneralTree<Integer> arbol){
        this.arbol = arbol;
    }

    private void caminoAHojaMasLejana(GeneralTree<Integer> ab, List<Integer> lista, 
        List<Integer> camino){
        lista.add(ab.getData());
        if(ab.isLeaf()){
            if(lista.size()>camino.size()){
                camino.clear();
                camino.addAll(lista);
            }
        }
        List<GeneralTree<Integer>> children = ab.getChildren();
        for(GeneralTree<Integer> child : children){
            caminoAHojaMasLejana(child, lista, camino);
        }
        lista.remove(lista.size() - 1);
    }

    public List<Integer> caminoAHojaMasLejana (){
        if (arbol == null || arbol.isEmpty()) 
            return new LinkedList<>(); 
        List<Integer> camino = new LinkedList<Integer>();
        List<Integer> lista = new LinkedList<Integer>();
        caminoAHojaMasLejana(arbol, lista, camino);
        return camino;
    }

    public static void main(String[] args) {
        // Crear GeneralTree<Integer>s
        GeneralTree<Integer> n12 = new GeneralTree<Integer>(12);
        GeneralTree<Integer> n17 = new GeneralTree<Integer>(17);
        GeneralTree<Integer> n9  = new GeneralTree<Integer>(9);
        GeneralTree<Integer> n15 = new GeneralTree<Integer>(15);
        GeneralTree<Integer> n10 = new GeneralTree<Integer>(10);
        GeneralTree<Integer> n6  = new GeneralTree<Integer>(6);
        GeneralTree<Integer> n8  = new GeneralTree<Integer>(8);
        GeneralTree<Integer> n14 = new GeneralTree<Integer>(14);
        GeneralTree<Integer> n18 = new GeneralTree<Integer>(18);
        GeneralTree<Integer> n1  = new GeneralTree<Integer>(1);
        GeneralTree<Integer> n16 = new GeneralTree<Integer>(16);
        GeneralTree<Integer> n7  = new GeneralTree<Integer>(7);

        // Construir el árbol
        n12.addChild(n17);
        n12.addChild(n9);
        n12.addChild(n15);

        n17.addChild(n10);
        n17.addChild(n6);
        n6.addChild(n1);

        n9.addChild(n8);

        n15.addChild(n14);
        n15.addChild(n18);

        n14.addChild(n16);
        n14.addChild(n7);

        n12.porNiveles();
        Caminos caminos = new Caminos(n12);
        List<Integer> camMasLargo = caminos.caminoAHojaMasLejana();
        System.out.println(camMasLargo);
    }
}
