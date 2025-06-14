package practica5.ejercicio3;

import java.util.List;
import java.util.LinkedList;
import practica5.ejercicio1.Graph;
import practica5.ejercicio1.Vertex;
import practica5.ejercicio1.Edge;

public class Mapa {
    private Graph<String> mapaCiudades;


    public Mapa(Graph<String> data){
        this.mapaCiudades = data;
    }

    /*Retorna la lista de ciudades que se deben atravesar para ir de ciudad1 a ciudad2 en caso de que se
pueda llegar, si no retorna la lista vacía. (Sin tener en cuenta el combustible). */

    private boolean devolverCamino(Vertex<String> v, Graph<String> grafo, boolean[] marca, 
        String ciudad2, List<String> lista, List<String> camino) {
        int pos = v.getPosition();
        marca[pos] = true; //marco como visitado
        //Vertex<String> v = grafo.getVertex(i); //tomo el vertice del grafo que recibi
        lista.add(v.getData());
        System.out.println(v.getData());
        if(v.getData().equals(ciudad2)){
            camino.addAll(lista);
            return true;
        }
        if(camino.isEmpty()){
            List<Edge<String>> adyacentes = grafo.getEdges(v); //adyacentes
            for (Edge<String> e: adyacentes){ //por cada adyacente
                int j = e.getTarget().getPosition(); //tomo la posicion del vertice al que apunta esa arista
                if (!marca[j]) { //si no esta marcado
                    //System.out.println(grafo.getVertex(j).getData());
                    devolverCamino(grafo.getVertex(j),grafo, marca,ciudad2,lista,camino); //continuo el recorrido con ese grafo
                }
            }
        }
        lista.remove(lista.size()-1);
        return false;
    }    

    public List<String> devolverCamino (String ciudad1, String ciudad2){
        List<String> camino = new LinkedList<>();
        if(!this.mapaCiudades.isEmpty()){
            List<String> lista = new LinkedList<>();
            boolean[] marca = new boolean[this.mapaCiudades.getSize()]; //array con los visitados
            Vertex<String>c1 = this.mapaCiudades.search(ciudad1);
            devolverCamino(c1, this.mapaCiudades, marca, ciudad2,lista,camino); //largo busqueda
        }
        return camino;
    }



    /*Retorna la lista de ciudades que forman un camino desde ciudad1 a ciudad2, sin pasar por las ciudades
que están contenidas en la lista ciudades pasada por parámetro, si no existe camino retorna la lista
vacía. (Sin tener en cuenta el combustible).  contains para saber si la ciudad esta en la lista*/

    private boolean devolverCaminoExceptuando (Vertex<String> v, Graph<String> grafo, boolean[] marca, 
        String ciudad2, List<String> lista, List<String> camino, List<String> ciudades){
        int pos = v.getPosition();
        marca[pos] = true;
        //boolean sigo = false;
        String data = v.getData();
        System.out.println(data);
        lista.add(data);
        if(data.equals(ciudad2)){
            camino.addAll(lista);
            return true;
        }
        if(camino.isEmpty()){
            List<Edge<String>> adyacentes = grafo.getEdges(v);
            for(Edge<String> e: adyacentes){
                int j = e.getTarget().getPosition(); //tomo la posicion del vertice al que apunta esa arista
                if (!marca[j]) { //si no esta marcado
                    //System.out.println(grafo.getVertex(j).getData());
                    devolverCaminoExceptuando(grafo.getVertex(j),grafo, marca,ciudad2,lista,camino,ciudades); //continuo el recorrido con ese grafo
                }
            }
        }
        lista.remove(lista.size()-1);
        return false;

    }
    
    public List<String> devolverCaminoExceptuando (String ciudad1, String ciudad2, List<String> ciudades){
        List<String> camino = new LinkedList<String>();
        if(!this.mapaCiudades.isEmpty()){
            List<String> lista = new LinkedList<String>();
            boolean[] marca = new boolean[this.mapaCiudades.getSize()];
            for(String c : ciudades){
                Vertex<String> aux = this.mapaCiudades.search(c);
                marca[aux.getPosition()] = true;
            }
            Vertex<String> c1 = this.mapaCiudades.search(ciudad1);
            devolverCaminoExceptuando(c1, mapaCiudades, marca, ciudad2, lista, camino, ciudades);
        }
        return camino;
    }


    /*Retorna la lista de ciudades que forman el camino más corto para llegar de ciudad1 a ciudad2, si no
existe camino retorna la lista vacía. (Las rutas poseen la distancia). */

    private int caminoMasCorto(Vertex<String> v, Graph<String> grafo, boolean[] marca, 
        String ciudad2, List<String> lista, List<String> camino, int distancia) {
        int pos = v.getPosition();
        marca[pos] = true;
        lista.add(v.getData());
        int min = 9999;

        if (v.getData().equals(ciudad2)) {
            // Si llegué, actualizo el camino más corto
            camino.clear();
            camino.addAll(lista);
            min = distancia;
        } else {
            List<Edge<String>> ady = grafo.getEdges(v);
            for (Edge<String> e : ady) {
                Vertex<String> j = e.getTarget();
                int jpos = j.getPosition();
                if (!marca[jpos]) {
                    int peso = e.getWeight();
                    int res = caminoMasCorto(j, grafo, marca, ciudad2, lista, camino, distancia + peso);
                    if (res < min) {
                        min = res;
                    }
                }
            }
        }
        lista.remove(lista.size() - 1);
        marca[pos] = false; // backtracking
        return min;
    }

    public List<String> caminoMasCorto(String ciudad1, String ciudad2){
        List<String> camino = new LinkedList<String>();
        if(!this.mapaCiudades.isEmpty()){
            List<String> lista = new LinkedList<String>();
            boolean [] marca = new boolean[this.mapaCiudades.getSize()];
            Vertex<String> c1 = this.mapaCiudades.search(ciudad1);
            caminoMasCorto(c1, mapaCiudades, marca, ciudad2, lista, camino,0);
        }
        return camino;
    }

    /*Retorna la lista de ciudades que forman un camino para llegar de ciudad1 a ciudad2. El auto no debe
quedarse sin combustible y no puede cargar. Si no existe camino retorna la lista vacía. 
    
    public static List<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto){

    }

    /*Retorna la lista de ciudades que forman un camino para llegar de ciudad1 a ciudad2 teniendo en cuenta
que el auto debe cargar la menor cantidad de veces. El auto no se debe quedar sin combustible en
medio de una ruta, además puede completar su tanque al llegar a cualquier ciudad. Si no existe camino
retorna la lista vacía. 

    public static List<String> caminoConMenorCargaDeCombustible (String ciudad1, String ciudad2, int tanqueAuto){

    }
*/
}
