package practica5.ejercicio3;
import java.util.LinkedList;
import java.util.List;
import practica5.ejercicio1.Graph;
import practica5.ejercicio1.adjList.AdjListGraph;
import practica5.ejercicio1.Vertex;

public class MapaTest {
    
    public static void main(String []args){
        Graph<String> grafo = new AdjListGraph<String>();
        // Crear vértices (ciudades)
        Vertex<String> caba = grafo.createVertex("CABA");
        Vertex<String> laPlata = grafo.createVertex("La Plata");
        Vertex<String> ny = grafo.createVertex("New York");
        Vertex<String> tokio = grafo.createVertex("Tokio");
        Vertex<String> amsterdam = grafo.createVertex("Amsterdam");
        Vertex<String> paris = grafo.createVertex("Paris");
       

        // Conectar ciudades
        grafo.connect(caba, laPlata,2);
        grafo.connect(caba, ny,5);
        grafo.connect(caba, amsterdam,15);
        grafo.connect(ny, paris,11);
        grafo.connect(ny, laPlata,6);
        grafo.connect(ny, tokio,10);
        grafo.connect(tokio, amsterdam,3);
        grafo.connect(tokio, paris,3);
        grafo.connect(paris, amsterdam,3);

        grafo.connect(laPlata,caba,2);
        grafo.connect(ny,caba,5);
        grafo.connect(amsterdam,caba,15);
        grafo.connect(paris,ny,11);
        grafo.connect(laPlata,ny,6);
        grafo.connect(tokio,ny,10);
        grafo.connect(amsterdam,tokio,3);
        grafo.connect(paris,tokio,3);
        grafo.connect(amsterdam,paris,3);

        Mapa mapa = new Mapa(grafo);
        List<String> camino = mapa.devolverCamino(tokio.getData(), laPlata.getData());
        System.out.println("camino simple: "+camino);
        List<String> excepciones = new LinkedList<>();
        excepciones.add("Amsterdam");
        camino = mapa.devolverCaminoExceptuando(tokio.getData(), laPlata.getData(), excepciones);
        System.out.println("camino con excepciones: "+camino);
        camino = mapa.caminoMasCorto(tokio.getData(), amsterdam.getData());
        System.out.println("camino mas corto entre tokio y amsterdam: "+camino);

    }
}

