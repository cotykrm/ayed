package practica5.ejercicio2;
import practica5.ejercicio1.Edge;
import practica5.ejercicio1.Graph;
import practica5.ejercicio1.Vertex;
import practica1.ejercicio8.Queue;
import java.util.List; 

public class Recorridos<T> {

    
    public void dfs(Graph<T> grafo) {
        boolean[] marca = new boolean[grafo.getSize()];
        for (int i = 0; i < grafo.getSize(); i++) {
            if (!marca[i]) {
                System.out.println("largo con: "+grafo.getVertex(i).getData());
                dfs(i, grafo, marca);
            }
        }
    }
    private void dfs(int i, Graph<T> grafo, boolean[] marca) {
        marca[i] = true;
        Vertex<T> v = grafo.getVertex(i);
        System.out.println(v);
        List<Edge<T>> adyacentes = grafo.getEdges(v); //adyacentes
        for (Edge<T> e: adyacentes){
            int j = e.getTarget().getPosition();
            if (!marca[j]) {
                dfs(j, grafo, marca);
            }
        }
        
    }

    public void bfs(Graph<T> grafo) {
        boolean[] marca = new boolean[grafo.getSize()];
        for (int i = 0; i < grafo.getSize(); i++) {
            if (!marca[i]) {
                this.bfs(i, grafo, marca);
            }
        }
    }

    private void bfs(int i, Graph<T> grafo, boolean[] marca) {
        Queue<Vertex<T>> q = new Queue<Vertex<T>>();
        q.enqueue(grafo.getVertex(i));
        marca[i] = true;
        while (!q.isEmpty()) {
            Vertex<T> w = q.dequeue();
            System.out.println(w);
            // para todos los vecinos de w:
            List<Edge<T>> adyacentes = grafo.getEdges(w);
            for (Edge<T> e: adyacentes) {
                int j = e.getTarget().getPosition();
                if (!marca[j]) {
                    marca[j] = true;
                    //Vertex<T> v = e.getTarget();
                    q.enqueue(e.getTarget());
                }
            }
        }
    }


}

