package practica5.ejercicio6;
import practica5.ejercicio1.Graph;
import practica5.ejercicio1.adjList.AdjListGraph;
import practica5.ejercicio1.Vertex;
//import java.util.LinkedList;
import java.util.List;

public class BuscadorDeCaminosTest {

    public static void main (String [] args){
        // Crear el grafo
        Graph<String> grafo = new AdjListGraph<>();

        Vertex<String> casaCaperucita = grafo.createVertex("Casa Caperucita");
        Vertex<String> claro1 =  grafo.createVertex("Claro 1");
        Vertex<String> claro2 =  grafo.createVertex("Claro 2");
        Vertex<String> claro3 =  grafo.createVertex("Claro 3");
        Vertex<String> claro4 =  grafo.createVertex("Claro 4");
        Vertex<String> claro5 =  grafo.createVertex("Claro 5");
        Vertex<String> casaAbuelita =  grafo.createVertex("Casa Abuelita");

        // Agregar conexiones (grafo no dirigido)
        grafo.connect(casaCaperucita, claro1, 3);
        grafo.connect(casaCaperucita, claro2, 4);
        grafo.connect(casaCaperucita, claro3, 4);
        grafo.connect(claro1, claro2, 4);
        grafo.connect(claro1, claro5, 3);
        grafo.connect(claro2, claro4, 10);
        grafo.connect(claro2, claro5, 11);
        grafo.connect(claro3, claro5, 15);
        grafo.connect(claro4, casaAbuelita, 9);
        grafo.connect(claro5, casaAbuelita, 4);

        grafo.connect(claro1, casaCaperucita, 3);
        grafo.connect(claro2, casaCaperucita, 4);
        grafo.connect(claro3, casaCaperucita, 4);
        grafo.connect(claro2, claro1, 4);
        grafo.connect(claro5, claro1, 3);
        grafo.connect(claro4, claro2, 10);
        grafo.connect(claro5, claro2, 11);
        grafo.connect(claro5, claro3, 15);
        grafo.connect(casaAbuelita, claro4, 9);
        grafo.connect(casaAbuelita, claro5, 4);

        BuscadorDeCaminos bdc = new BuscadorDeCaminos(grafo);
        List<List<String>> listas = bdc.recorridosMasSeguro();
        for(List<String> lista : listas)
            System.out.println(lista);
    }
}
