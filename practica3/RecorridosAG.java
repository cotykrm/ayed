/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Constanza
 */
package practica3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import practica1.ejercicio8.Queue;

public class RecorridosAG {


    /*
    Método que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n”
    pasados como parámetros, recorrido en preorden.*/
		
    private static boolean esImpar(Integer n) {
	    if(n%2 != 0)
            return true;
	    else
            return false;
	}
		
		
		
    private void nimqpo(GeneralTree <Integer> a, Integer n, List<Integer> impares) {
	    if(esImpar(a.getData()) && a.getData()>n)
            impares.add(a.getData());
        List<GeneralTree<Integer>> children = a.getChildren();
	    for (GeneralTree<Integer> child: children) {
            nimqpo(child,n,impares);	
	    }
    }
		
    public List<Integer> numerosImparesMayoresQuePreOrden (GeneralTree <Integer> a,
	    Integer n){
	    List<Integer> impares = new ArrayList<Integer>();
	    if(a == null || a.isEmpty())
            return impares;
        nimqpo(a,n,impares);
		
	return impares;
    }
	
    private void nimqio(GeneralTree <Integer> a, Integer n, List<Integer> impares) {
	    if(esImpar(a.getData()) && a.getData()>n)
            impares.add(a.getData());
        List<GeneralTree<Integer>> children = a.getChildren();
	    for (GeneralTree<Integer> child: children) {
            nimqpo(child,n,impares);	
	    }
    }
		
    public List<Integer> numerosImparesMayoresQueInOrden (GeneralTree <Integer> a,Integer n){
		List<Integer> impares = new ArrayList<Integer>();
		if(a == null || a.isEmpty())
			return impares;
		nimqio(a,n,impares);
		
		return impares;
	}
		
	
	private void nimqpto(GeneralTree <Integer> a, Integer n, List<Integer> impares) {
		List<GeneralTree<Integer>> children = a.getChildren();
		for (GeneralTree<Integer> child: children) {
			nimqpo(child,n,impares);	
		}
		if(esImpar(a.getData()) && a.getData()>n)
			impares.add(a.getData());
	}
		
	public List<Integer> numerosImparesMayoresQuePostOrden (GeneralTree <Integer> a,
			Integer n){
		List<Integer> impares = new ArrayList<Integer>();
		if(a == null || a.isEmpty())
			return impares;
		nimqpto(a,n,impares);
		
		return impares;
	}
        
        public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree<Integer> tree,
                Integer n) {
            List<Integer> impares = new LinkedList<Integer>();
            GeneralTree<Integer> tree_aux;
            Queue<GeneralTree<Integer>> queue = new Queue<GeneralTree<Integer>>();
            queue.enqueue(tree);
            while (!queue.isEmpty()) {
                tree_aux = queue.dequeue();
                if(esImpar(tree_aux.getData()) && tree_aux.getData()>n)
                    impares.add(tree_aux.getData());
                List<GeneralTree<Integer>> children = tree_aux.getChildren();
                for (GeneralTree<Integer> child: children) {
                    queue.enqueue(child);
                }
            }
            return impares;
        }
}
