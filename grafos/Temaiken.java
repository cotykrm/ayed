package parciales.grafos;
import practica5.ejercicio1.Graph;
import practica5.ejercicio1.Vertex;

import java.util.Iterator;
import java.util.List;

import practica5.ejercicio1.Edge;

public class Temaiken {

    private Vertex<Sitio> buscar(Graph<Sitio> sitios, String lugar, boolean []marca){
        List<Vertex<Sitio>> l = sitios.getVertices();
        Iterator<Vertex<Sitio>> iter = l.iterator();
        Vertex<Sitio> entrada = null;
        Vertex<Sitio> aux = null;
        while(iter.hasNext() && entrada == null){
            aux = iter.next();
            if(aux.getData().getNombre().equals(lugar))
                entrada = aux;
        }
        return entrada;
    }   

    public int resolver(Graph<Sitio> sitios, Vertex<Sitio> entrada, boolean [] marca, int tiempo){
        int pos = entrada.getPosition();
        marca[pos] = true;
        int ret;
        if(tiempo < entrada.getData().getTiempo())
            ret = 0;
        else {
            tiempo = tiempo - entrada.getData().getTiempo();
            List<Edge<Sitio>> ady= sitios.getEdges(entrada);  
            int lugaresMax = 0, lugares = 0;
            for(Edge<Sitio> a : ady){
                int peso = a.getWeight();
                Vertex<Sitio> v = a.getTarget();
                int tiempoV = v.getData().getTiempo();
                if(tiempoV + peso <= tiempo && !marca[v.getPosition()]){
                    lugares = resolver(sitios, entrada, marca, tiempo-peso);
                    if(lugares>lugaresMax)
                        lugaresMax = lugares;
                }
            }
            ret = lugaresMax + 1;
        }
        marca[entrada.getPosition()] = false;
        return ret;
    }

    public int resolver(Graph<Sitio> sitios, int tiempo){
        int cantLugares = 0;
        if(sitios != null && !sitios.isEmpty()){
            boolean [] marca = new boolean [sitios.getSize()];
            Vertex<Sitio> entrada = buscar(sitios, "Entrada", marca);
            if(entrada != null){
                cantLugares = resolver(sitios, entrada, marca,tiempo);
            }
        }
        return cantLugares;
    }

}
