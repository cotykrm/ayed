package practica5.ejercicio6;
import java.util.LinkedList;
import java.util.List;
import practica5.ejercicio1.Graph;
//import practica5.ejercicio1.adjList.AdjListGraph;
import practica5.ejercicio1.Vertex;
import practica5.ejercicio1.Edge;


/*Un día, Caperucita Roja decide ir desde su casa hasta la de su abuelita, recolectando frutos del bosque del
camino y tratando de hacer el paseo de la manera más segura posible. La casa de Caperucita está en un claro
del extremo oeste del bosque, la casa de su abuelita en un claro del extremo este, y dentro del bosque entre
ambas hay algunos otros claros.
El bosque está representado por un grafo, donde los vértices representan los claros (identificados por un
String) y las aristas los senderos que los unen. Cada arista informa la cantidad de árboles frutales que hay en el
sendero. Caperucita sabe que el lobo es muy goloso y le gustan mucho las frutas, entonces para no ser
capturada por el lobo, desea encontrar todos los caminos que no pasen por los senderos con cantidad de
frutales >= 5 y lleguen a la casa de la abuelita.
Su tarea es definir una clase llamada BuscadorDeCaminos, con una variable de instancia llamada "bosque" de
tipo Graph, que representa el bosque descrito e implementar un método de instancia con la siguiente firma:
public List < List <String>> recorridosMasSeguro()
que devuelva un listado con TODOS los caminos que cumplen con las condiciones mencionadas anteriormente.
Nota: La casa de Caperucita debe ser buscada antes de comenzar a buscar el recorrido */

public class BuscadorDeCaminos {
    private Graph<String> bosque;

    public BuscadorDeCaminos(Graph<String> bosque){
        this.bosque = bosque;
    }

   
    private boolean recorridosMasSeguro(Graph<String> bosque, Vertex<String> claro, boolean [] marca, 
        List<List<String>> listas, List<String> lista){
        int pos = claro.getPosition();
        marca[pos] = true;
        lista.add(claro.getData());
        if(claro.getData().equals("Casa Abuelita")){
            listas.add(new LinkedList<>(lista));
            return true;
        }
        List<Edge<String>> ady = bosque.getEdges(claro);
        for(Edge<String> e: ady){
            Vertex<String> c = e.getTarget();
            int j = c.getPosition();
            if(e.getWeight() < 5 && !marca[j]){
                recorridosMasSeguro(bosque, c, marca, listas, lista);
            }
        }
        marca[pos] = false;
        lista.remove(lista.size()-1);
        return false;
        

    }

     /*
    private void recorridosMasSeguro(Graph<String> bosque, Vertex<String> origen, boolean [] marca, 
        List<List<String>> listas, List<String> lista){

            List<Edge<String>> ady = bosque.getEdges(origen);
            int j, p;
            for(Edge<String> e: ady){
                j = e.getTarget().getPosition();
                if(!marca[j]){
                    p = e.getWeight();
                    if(p < 5){
                        Vertex<String> claro = e.getTarget();
                        lista.add(claro.getData());
                        marca[j] = true;
                        if(claro.getData().equals("Casa Abuelita")){
                            listas.add(lista);
                        }
                        else{
                            recorridosMasSeguro(bosque, claro, marca, listas, lista);
                        }
                        lista.remove(lista.size()-1);
                        marca[j] = false;

                    }
                }
            }
    }

    public List<List<String>> recorridosMasSeguro(){
        List<List<String>> listas = new LinkedList<>();
        if(this.bosque != null){
            List<String> lista = null;
            Vertex<String> caperucita = this.bosque.search("Casa Caperucita");
            if(caperucita != null){
                List<Edge<String>> ady = this.bosque.getEdges(caperucita);
                boolean[] marca = new boolean[this.bosque.getSize()];
                //marca[caperucita.getPosition()] = true;
                for(Edge<String> e : ady){
                    lista = new LinkedList<>();
                    List<String> camino = new LinkedList<>();
                    lista.add(caperucita.getData());
                    //listas.add(lista);
                    recorridosMasSeguro(this.bosque,e.getTarget(),marca,listas,lista,camino);
                    //marca[e.getTarget().getPosition()] = false;

                }
            }
        }
        return listas;
    }*/
    public List<List<String>> recorridosMasSeguro() {
    List<List<String>> listas = new LinkedList<>();
    if (this.bosque != null) {
        Vertex<String> caperucita = this.bosque.search("Casa Caperucita");
        if (caperucita != null) {
            boolean[] marca = new boolean[this.bosque.getSize()];
            List<String> lista = new LinkedList<>();
            recorridosMasSeguro(this.bosque, caperucita, marca, listas, lista);
        }
    }
    return listas;
}
}