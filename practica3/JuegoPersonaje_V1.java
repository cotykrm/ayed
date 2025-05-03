package practica3;

import java.util.LinkedList;
import java.util.List;

public class JuegoPersonaje_V1 {


    public static List<Personaje> encontrarPrincesa(GeneralTree<Personaje> arbol) {
        List<Personaje> lista = new LinkedList<Personaje>();
        lista.add(arbol.getData());
        List<Personaje> camino = new LinkedList<Personaje>();
        encontrarPrincesa(arbol, lista, camino);
        return camino;
    }
    private static void encontrarPrincesa(GeneralTree<Personaje> arbol, List<Personaje> lista,
        List<Personaje> camino) {
        Personaje p = arbol.getData();
        if (p.esPrincesa()) {
            camino.addAll(lista);
        }
        if (camino.isEmpty()) {
            List<GeneralTree<Personaje>> children = arbol.getChildren();
            for (GeneralTree<Personaje> child: children) {
                if (!child.getData().esDragon()) {
                    lista.add(child.getData());
                    encontrarPrincesa(child, lista, camino);
                    if (lista.get(lista.size()-1).esPrincesa()) break;
                    lista.remove(lista.size() - 1);
                }
            }
        }
    }
}