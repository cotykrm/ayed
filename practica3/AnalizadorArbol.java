/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3;

/**
 *
 * @author Constanza
 */
import practica1.ejercicio8.Queue;
import java.util.LinkedList;
import java.util.List;

/*El esquema de comunicación de una empresa está organizado en una estructura jerárquica, en donde
cada nodo envía el mensaje a sus descendientes. Cada nodo posee el tiempo que tarda en transmitir el
mensaje
Se debe devolver el mayor promedio entre todos los valores promedios de los niveles.
Para el ejemplo presentado, el promedio del nivel 0 es 14, el del nivel 1 es 16 y el del nivel 2 es 10. Por
lo tanto, debe devolver 16.*/

public class AnalizadorArbol {
    
    public static double devolverMaximoPromedio (GeneralTree<AreaEmpresa>arbol){
        if(arbol != null && !arbol.isEmpty()){
            GeneralTree<AreaEmpresa> tree_aux;
            Queue<GeneralTree<AreaEmpresa>> queue = new Queue<GeneralTree<AreaEmpresa>>();
            double promedio;
            int cantNodos = 0;
            int suma = 0;       
            double max = -1;
            queue.enqueue(arbol);
            queue.enqueue(null);
            while (!queue.isEmpty()) {
                tree_aux = queue.dequeue();
                if(tree_aux!=null){
                    suma += tree_aux.getData().getTardanza();
                    cantNodos++;
                    if(tree_aux.hasChildren()){
                        for(GeneralTree<AreaEmpresa> child : tree_aux.getChildren()){
                            queue.enqueue(child);
                        }
                    }
                }
                else{
                    if(!queue.isEmpty()){
                        promedio = (double)suma/cantNodos;
                        if(promedio>max){
                            max = promedio;
                        }
                        cantNodos = 0;
                        suma = 0; 
                        queue.enqueue(null);
                    }
                }
            }
            promedio = (double)suma/cantNodos;
            if(promedio>max)
                max = promedio;
           
            return max;
        }
        return -1;
    }
    
    public static void main(String []args){
        GeneralTree<AreaEmpresa> a = new GeneralTree<AreaEmpresa>(new AreaEmpresa("A", 4));
        GeneralTree<AreaEmpresa> b = new GeneralTree<AreaEmpresa>(new AreaEmpresa("B", 7));
        GeneralTree<AreaEmpresa> c = new GeneralTree<AreaEmpresa>(new AreaEmpresa("C", 5));
        GeneralTree<AreaEmpresa> d = new GeneralTree<AreaEmpresa>(new AreaEmpresa("D", 6));
        GeneralTree<AreaEmpresa> e = new GeneralTree<AreaEmpresa>(new AreaEmpresa("E", 10));
        GeneralTree<AreaEmpresa> f = new GeneralTree<AreaEmpresa>(new AreaEmpresa("F", 18));
        GeneralTree<AreaEmpresa> g = new GeneralTree<AreaEmpresa>(new AreaEmpresa("G", 9));
        GeneralTree<AreaEmpresa> h = new GeneralTree<AreaEmpresa>(new AreaEmpresa("H", 12));
        GeneralTree<AreaEmpresa> i = new GeneralTree<AreaEmpresa>(new AreaEmpresa("I", 19));

        // Crear los nodos intermedios
        List<GeneralTree<AreaEmpresa>> hijosJ = new LinkedList<>();
        hijosJ.add(a);
        hijosJ.add(b);
        hijosJ.add(c);
        GeneralTree<AreaEmpresa> j = new GeneralTree<AreaEmpresa>(new AreaEmpresa("J", 13), hijosJ);

        List<GeneralTree<AreaEmpresa>> hijosK = new LinkedList<>();
        hijosK.add(d);
        hijosK.add(e);
        hijosK.add(f);
        GeneralTree<AreaEmpresa> k = new GeneralTree<AreaEmpresa>(new AreaEmpresa("K", 25), hijosK);

        List<GeneralTree<AreaEmpresa>> hijosL = new LinkedList<>();
        hijosL.add(g);
        hijosL.add(h);
        hijosL.add(i);
        GeneralTree<AreaEmpresa> l = new GeneralTree<AreaEmpresa>(new AreaEmpresa("L", 10), hijosL);

        // Crear el nodo raíz
        List<GeneralTree<AreaEmpresa>> hijosM = new LinkedList<>();
        hijosM.add(j);
        hijosM.add(k);
        hijosM.add(l);
        GeneralTree<AreaEmpresa> m = new GeneralTree<AreaEmpresa>(new AreaEmpresa("M", 14), hijosM);
        
        System.out.println("mayor promedio: "+ devolverMaximoPromedio(m));
    }
}
