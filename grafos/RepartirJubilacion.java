package practica5.ejercicio5;

import java.util.LinkedList;
import java.util.List;
import practica5.ejercicio1.Graph;
//import practica5.ejercicio1.adjList.AdjListGraph;
import practica5.ejercicio1.Vertex;
import practica5.ejercicio1.Edge;
import practica1.ejercicio8.Queue;

/*El Banco Itaú se suma a las campañas "QUEDATE EN CASA" lanzando un programa para acercar el sueldo a los
jubilados hasta sus domicilios. Para ello el banco cuenta con información que permite definir un grafo de
personas donde la persona puede ser un jubilado o un empleado del banco que llevará el dinero.
Se necesita armar la cartera de jubilados para cada empleado repartidor del banco, incluyendo en cada lista, los
jubilados que vivan un radio cercano a su casa y no hayan percibido la jubilación del mes.
Para ello, implemente un algoritmo que dado un Grafo<Persona> retorne una lista de jubilados que se
encuentren a una distancia menor a un valor dado del empleado Itaú (grado de separación del empleado Itaú).
El método recibirá un Grafo<Persona>, un empleado y un grado de separación/distancia y debe retornar una
lista de hasta 40 jubilados que no hayan percibido la jubilación del mes y se encuentre a una distancia menor a
recibido como parámetro. 

recorrer el grafo de personas 
puede haber jubilados que reciben su sueldo o empleados que lo llevan
se debe realizar una lista con los jubilados que vivan en un radio cercano a su casa 
y no hayan recibido la jubilacion(vector de marcas) (hasta 40)

*/


public class RepartirJubilacion {


    public List<String> repartir(Graph<Persona> grafo, Vertex<Persona> empleado, int distancia){
        List<String> radio = new LinkedList<>();
        if(grafo != null && !grafo.isEmpty()){
            boolean visitados[] = new boolean[grafo.getSize()];
            Queue<Vertex<Persona>> cola = new Queue<Vertex<Persona>>();
            visitados[empleado.getPosition()] = true;   
            cola.enqueue(empleado);
            cola.enqueue(null);
            while (!cola.isEmpty()) {
                Vertex<Persona> v = cola.dequeue();
                if (v != null) {
                    List<Edge<Persona>> adyacentes = grafo.getEdges(v);
                    for (Edge<Persona> e : adyacentes) {
                        int peso = e.getWeight();
                        Vertex<Persona> w = e.getTarget();
                        Persona p = w.getData();
                        if(radio.size()<40 && peso<=distancia && p.getEsJubilado() && !p.getYaCobro()){
                            if (!visitados[w.getPosition()]) {
                                radio.add(p.getNombre());
                                visitados[w.getPosition()] = true;
                                cola.enqueue(w);
                            }
                        }
                    }
                } else if (!cola.isEmpty()) {
                    cola.enqueue(null);
                }
            }
            
        }
        return radio;
    }
}
