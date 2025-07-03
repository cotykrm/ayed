package parciales.grafos;

import practica5.ejercicio1.Graph;
import practica5.ejercicio1.Vertex;
import practica5.ejercicio1.adjList.AdjListGraph;

public class TemaikenTest {

    public static void main (String []args){
        Graph<Sitio> zoo = new AdjListGraph<>();

        // Crear vértices
        Sitio ent = new Sitio("Entrada",15);
        Vertex<Sitio> entrada = zoo.createVertex(ent);
        Sitio c = new Sitio("Cebras",10);
        Vertex<Sitio> cebras = zoo.createVertex(c);
        Sitio ti = new Sitio("Tigres",10);
        Vertex<Sitio> tigres = zoo.createVertex(ti);
        Sitio t = new Sitio("Tortugas",10);
        Vertex<Sitio> tortugas = zoo.createVertex(t);
        Sitio p = new Sitio("Pumas",10);
        Vertex<Sitio> pumas = zoo.createVertex(p);
        Sitio w = new Sitio("Wallabies",30);
        Vertex<Sitio> wallabies = zoo.createVertex(w);
        Sitio m = new Sitio("Murciélagos",20);
        Vertex<Sitio> murcielagos = zoo.createVertex(m);
        Sitio f = new Sitio("Flamencos",10);
        Vertex<Sitio> flamencos = zoo.createVertex(f);

        // Conectar vértices en ambos sentidos

        zoo.connect(entrada, cebras, 10);
        zoo.connect(cebras, entrada, 10);

        zoo.connect(entrada, tigres, 15);
        zoo.connect(tigres, entrada, 15);

        zoo.connect(entrada, murcielagos, 20);
        zoo.connect(murcielagos, entrada, 20);

        zoo.connect(entrada, flamencos, 25);
        zoo.connect(flamencos, entrada, 25);

        zoo.connect(cebras, tortugas, 5);
        zoo.connect(tortugas, cebras, 5);

        zoo.connect(tigres, cebras, 8);
        zoo.connect(cebras, tigres, 8);

        zoo.connect(wallabies, tortugas, 10);
        zoo.connect(tortugas, wallabies, 10);

        zoo.connect(wallabies, murcielagos, 10);
        zoo.connect(murcielagos, wallabies, 10);

        zoo.connect(murcielagos, flamencos, 25);
        zoo.connect(flamencos, murcielagos, 25);

        zoo.connect(tortugas, pumas, 15);
        zoo.connect(pumas, tortugas, 15);

        Temaiken temaiken = new Temaiken();
        System.out.println(temaiken.resolver(zoo,100));
    }
}
