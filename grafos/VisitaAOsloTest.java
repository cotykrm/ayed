package practica5.ejercicio4;
import java.util.LinkedList;
import java.util.List;
import practica5.ejercicio1.Graph;
import practica5.ejercicio1.adjList.AdjListGraph;
import practica5.ejercicio1.Vertex;

public class VisitaAOsloTest {

    public static void main(String[]args){
        Graph<String> grafo = new AdjListGraph<String>();
        // Crear vértices (ciudades)
        Vertex<String> caba = grafo.createVertex("CABA");
        Vertex<String> laPlata = grafo.createVertex("La Plata");
        Vertex<String> ny = grafo.createVertex("New York");
        Vertex<String> tokio = grafo.createVertex("Tokio");
        Vertex<String> amsterdam = grafo.createVertex("Amsterdam");
        Vertex<String> paris = grafo.createVertex("Paris");
       

        // Conectar ciudades
        grafo.connect(caba, laPlata,5);
        grafo.connect(caba, ny,5);
        grafo.connect(caba, amsterdam,10);
        grafo.connect(ny, paris,10);
        grafo.connect(ny, laPlata,6);
        grafo.connect(ny, tokio,10);
        grafo.connect(tokio, amsterdam,4);
        grafo.connect(tokio, paris,2);
        grafo.connect(paris, amsterdam,3);

        grafo.connect(laPlata,caba,5);
        grafo.connect(ny,caba,5);
        grafo.connect(amsterdam,caba,10);
        grafo.connect(paris,ny,10);
        grafo.connect(laPlata,ny,6);
        grafo.connect(tokio,ny,10);
        grafo.connect(amsterdam,tokio,4);
        grafo.connect(paris,tokio,2);
        grafo.connect(amsterdam,paris,3);

        List<String> lugaresRestringidos = new LinkedList<>();
        lugaresRestringidos.add("Amsterdam");
        VisitaAOslo paseo = new VisitaAOslo(); 
        List<String> camino = paseo.paseoEnBici(grafo,"La Plata",23,lugaresRestringidos);
        System.out.println("camino de tokio a la plata sin amsterdam en 16 horas o menos: \n"+camino);
    }
}
