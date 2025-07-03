package parciales;
import practica3.GeneralTree;
import java.util.LinkedList;
import java.util.List;

public class parcialMio {
    
    public static void metodoPriv(GeneralTree<Integer> arbol, List<Integer> lista, List<Integer> camino){
        int data = arbol.getData();
        boolean sigo = false;
        if(!lista.isEmpty()){
            int ant = lista.get(lista.size()-1);
            if(ant % 2 == 0)
                if(data % 2 != 0)
                    sigo = true;
            else
                if(data % 2 == 0)
                    sigo = true;
        }
        else
            sigo = true;
        lista.add(data);
        if(arbol.isLeaf() && sigo && camino==null){
            camino = new LinkedList<>(lista);
            return;
        }
        if(sigo && camino == null){
            for(GeneralTree<Integer> child : arbol.getChildren())
                metodoPriv(child, lista, camino);
        }
        
        lista.remove(lista.size()-1);
    }

    public static List<Integer> primerCaminoAlternanteParImpar(GeneralTree<Integer> arbol){
        List<Integer> camino = new LinkedList<>();
        if(arbol != null && !arbol.isEmpty()){
            List<Integer> lista = new LinkedList<Integer>();
            metodoPriv(arbol,lista,camino);
        }
        return new LinkedList<>();
    }

    public static void main(String []args){
        // Nivel 0 (raíz)
        GeneralTree<Integer> root = new GeneralTree<>(2); // par

        // Nivel 1
        GeneralTree<Integer> n1 = new GeneralTree<>(3); // impar
        GeneralTree<Integer> n2 = new GeneralTree<>(4); // par

        // Nivel 2
        GeneralTree<Integer> n11 = new GeneralTree<>(6); // par
        GeneralTree<Integer> n12 = new GeneralTree<>(5); // impar
        GeneralTree<Integer> n21 = new GeneralTree<>(7); // impar

        // Nivel 3
        GeneralTree<Integer> n111 = new GeneralTree<>(11); // par
        GeneralTree<Integer> n121 = new GeneralTree<>(9); // impar
        GeneralTree<Integer> n211 = new GeneralTree<>(10); // par

        // Armar el árbol
        n1.addChild(n11);
        n1.addChild(n12);
        n2.addChild(n21);

        n11.addChild(n111);
        n12.addChild(n121);
        n21.addChild(n211);

        root.addChild(n1);
        root.addChild(n2);

        // Ejemplo de uso del método
        root.porNiveles();
        List<Integer> camino = primerCaminoAlternanteParImpar(root);
        System.out.println(camino);
    }
}
