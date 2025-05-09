package parciales;
import practica3.GeneralTree;
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

    public static void main(String []args){
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
        

    }
}
