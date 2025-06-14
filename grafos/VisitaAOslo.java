package practica5.ejercicio4;
import java.util.List;
import java.util.LinkedList;
import practica5.ejercicio1.Graph;
import practica5.ejercicio1.Vertex;
import practica5.ejercicio1.Edge;


/*Se quiere realizar un paseo en bicicleta por lugares emblemáticos de Oslo. Para esto se cuenta con un grafo de
bicisendas. Partiendo desde el “Ayuntamiento” hasta un lugar destino en menos de X minutos, sin pasar por un
conjunto de lugares que están restringidos.
Escriba una clase llamada VisitaOslo e implemente su método:
paseoEnBici(Graph<String> lugares, String destino, int maxTiempo, List<String> lugaresRestringidos) :
List<String>
 */

public class VisitaAOslo {

    /*private boolean paseoEnBici(Vertex<String> v, Graph<String> lugares, Vertex<String> destino, 
        int maxTiempo, List<String> lista, List<String> camino, boolean[] marca){
        int pos = v.getPosition(); //tomo la posicion
        //boolean sigo = true;
        marca[pos] = true;  //marco como visitado
        lista.add(v.getData());  //agrego el dato a la lista
        if(v.getData().equals(destino)){ //si llegue al destino
            camino.addAll(lista);  //copio la lista en el camino y 
            return true; //retorno asi no sigue recorriendo sus adyacentes
        }
        if(camino.isEmpty()){ //si todavia no encontre el destino
            List<Edge<String>> adyacentes = lugares.getEdges(v); //tomo los adyacentes
            for(Edge<String> e : adyacentes ){ //por cada adyacente
                int peso = e.getWeight(); //tomo el peso
                if(maxTiempo - peso >= 0){ //si el tiempo menos el peso es mayor que 0
                    v = e.getTarget(); //tomo el vertice que apunta el adyacente
                    if(!marca[v.getPosition()]) //si no esta marcado como visitado
                        paseoEnBici(v,lugares, destino, maxTiempo-peso, lista, camino, marca);
                }
            }
        }
        lista.remove(lista.size()-1);
        marca[v.getPosition()] = false;
        return false;
            
    }*/

    private boolean paseoEnBici(Vertex<String> v, Graph<String> lugares, Vertex<String> destino, 
        int maxTiempo, List<String> lista, List<String> camino, boolean[] marca){
        int pos = v.getPosition(); //tomo la posicion
        boolean sigo = false;
        marca[pos] = true;  //marco como visitado
        lista.add(v.getData());  //agrego el dato a la lista
        if(v.getData().equals(destino.getData())){ //si llegue al destino
            sigo = true;
        }
        else{
            List<Edge<String>> adyacentes = lugares.getEdges(v); //tomo los adyacentes
            for(Edge<String> e : adyacentes ){ //por cada adyacente
                if(!sigo){
                    int peso = e.getWeight(); //tomo el peso
                    if(maxTiempo - peso >= 0){ //si el tiempo menos el peso es mayor que 0
                        v = e.getTarget(); //tomo el vertice que apunta el adyacente
                        if(!marca[v.getPosition()]) //si no esta marcado como visitado
                            paseoEnBici(v,lugares, destino, maxTiempo-peso, lista, camino, marca);
                    }
                }
            }
        }
        if(!sigo){
            lista.remove(lista.size()-1);
            marca[v.getPosition()] = false;
        }
        return sigo;
            
    }

    public List<String> paseoEnBici(Graph<String> lugares, String destino, 
        int maxTiempo, List<String> lugaresRestringidos){
            List<String> camino = new LinkedList<String>();
            List<String> lista = new LinkedList<>();
            if(lugares != null && !lugares.isEmpty()){
                Vertex<String> ayunt = lugares.search("Tokio");
                Vertex<String> dest = lugares.search(destino);
                if(ayunt != null && dest != null){
                    boolean[] marca = new boolean[lugares.getSize()];
                    for(String p : lugaresRestringidos){
                        Vertex<String> a = lugares.search(p);
                        marca[a.getPosition()] = true;
                    }
                    paseoEnBici(ayunt,lugares,dest,maxTiempo,lista,camino,marca);
                }
            }
            return lista;
        }
}
