package practica5.ejercicio5;

import java.util.List;

import practica5.ejercicio1.Graph;
import practica5.ejercicio1.Vertex;
import practica5.ejercicio1.adjList.AdjListGraph;

public class RepartirJubilacionTest {

    public static void main (String []args){
        // Crear personas
        Persona empleado = new Persona("Juan", "Perez", "Calle 1", false, false);
        Persona jubilado1 = new Persona("Ana", "Gomez", "Calle 2", true, false);
        Persona jubilado2 = new Persona("Luis", "Lopez", "Calle 3", true, false);
        Persona jubilado3 = new Persona("Maria", "Diaz", "Calle 4", true, true); // Ya cobró
        Persona jubilado4 = new Persona("Carlos", "Sosa", "Calle 5", true, false);

        // Crear grafo
        Graph<Persona> grafo = new AdjListGraph<>();
        Vertex<Persona> vEmpleado = grafo.createVertex(empleado);
        Vertex<Persona> vJub1 = grafo.createVertex(jubilado1);
        Vertex<Persona> vJub2 = grafo.createVertex(jubilado2);
        Vertex<Persona> vJub3 = grafo.createVertex(jubilado3);
        Vertex<Persona> vJub4 = grafo.createVertex(jubilado4);

        // Conectar vértices (empleado conectado a todos los jubilados)
        grafo.connect(vEmpleado, vJub1, 1);
        grafo.connect(vEmpleado, vJub2, 2);
        grafo.connect(vEmpleado, vJub3, 3);
        grafo.connect(vEmpleado, vJub4, 4);

        // Instanciar la clase y probar el método
        RepartirJubilacion rj = new RepartirJubilacion();
        List<String> lista = rj.repartir(grafo, vEmpleado, 3);

        System.out.println("Jubilados a repartir:");
        System.out.println(lista);
    }
}
