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
import java.util.LinkedList;
import java.util.List;
import practica1.ejercicio8.Queue;

public class GeneralTree<T>{

	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>(); 

	public GeneralTree() {
		
	}
	public GeneralTree(T data) {
		this.data = data;
	}

	public GeneralTree(T data, List<GeneralTree<T>> children) {
		this(data);
		this.children = children;
	}	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<GeneralTree<T>> getChildren() {
		return this.children;
	}
	
	public void setChildren(List<GeneralTree<T>> children) {
		if (children != null)
			this.children = children;
	}
	
	public void addChild(GeneralTree<T> child) {
		this.getChildren().add(child);
	}

	public boolean isLeaf() {
		return !this.hasChildren();
	}
	
	public boolean hasChildren() {
		return !this.children.isEmpty();
	}
	
	public boolean isEmpty() {
		return this.data == null && !this.hasChildren();
	}

	public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren())
			children.remove(child);
	}
        
    public void porNiveles(){
       if(this != null && !this.isEmpty()){
            GeneralTree<T> tree_aux;
            Queue<GeneralTree<T>> queue = new Queue<GeneralTree<T>>();
            queue.enqueue(this);
            queue.enqueue(null);
            while (!queue.isEmpty()) {
                tree_aux = queue.dequeue();
                if(tree_aux != null){
                    System.out.println(tree_aux.getData());
                    if(tree_aux.hasChildren()){
                        for (GeneralTree<T> child: tree_aux.getChildren()) {
                            queue.enqueue(child);
                        }
                    }
                }    
                else{
                    if(!queue.isEmpty()){
                        System.out.println(" ");
                        queue.enqueue(null);
                    }
                }
            }
        }
	
    }
	
        /*devuelve la altura del árbol, es decir, la longitud del camino más largo
desde el nodo raíz hasta una hoja*/
	public int altura() {	 
        if(this.isEmpty() || this == null)
		    return 0;
        int alt = 0;
        GeneralTree<T> tree_aux;
        Queue<GeneralTree<T>> queue = new Queue<GeneralTree<T>>();
        queue.enqueue(this);
        queue.enqueue(null);
        while (!queue.isEmpty()) {
            tree_aux = queue.dequeue();
            if(tree_aux != null){
                if(tree_aux.hasChildren()){
                    for (GeneralTree<T> child: tree_aux.getChildren()) {
                        queue.enqueue(child);
                    }
                }
            } 
            else{
                if(!queue.isEmpty()){
                    alt++;
                    queue.enqueue(null);
                }
            }
        }
        return alt;
	}
	
        /*devuelve la profundidad o nivel del dato en el árbol. El nivel de un nodo
es la longitud del único camino de la raíz al nodo.*/
	public int nivel(T dato){
        if(this.isEmpty() || this == null)
            return 0;
        int nivel = 0;
        GeneralTree<T> tree_aux;
        Queue<GeneralTree<T>> queue = new Queue<GeneralTree<T>>();
        queue.enqueue(this);
        queue.enqueue(null);
        while (!queue.isEmpty()) {
            tree_aux = queue.dequeue();
            if(tree_aux != null){
                if(tree_aux.getData() == dato)
                    return nivel;
                if(tree_aux.hasChildren()){
                    for (GeneralTree<T> child: tree_aux.getChildren()) {
                        queue.enqueue(child);
                    }
                }
            } 
            else{
                if(!queue.isEmpty()){
                    nivel++;
                    queue.enqueue(null);
                }
            }
        }
        return -1;
	}
	 
           /*la amplitud (ancho) de un árbol se define como la cantidad de nodos que
se encuentran en el nivel que posee la mayor cantidad de nodos.*/
        
	public int ancho(){
        if(this.isEmpty() || this == null)
            return 0;
        int max = -1;
        int nodos = 0;
        GeneralTree<T> tree_aux;
        Queue<GeneralTree<T>> queue = new Queue<GeneralTree<T>>();
        queue.enqueue(this);
        queue.enqueue(null);
        while (!queue.isEmpty()) {
            tree_aux = queue.dequeue();
            if(tree_aux != null){
                nodos++;
                if(tree_aux.hasChildren()){
                    for (GeneralTree<T> child: tree_aux.getChildren()) {
                        queue.enqueue(child);
                    }
                }
            } 
            else{
                if(!queue.isEmpty()){
                    if(nodos>max){
                        max = nodos;
                    }
                    nodos = 0;
                    queue.enqueue(null);
                }
            }
        }
            if (nodos > max) 
                max = nodos;
        return max;
	}
        
        /*Se dice que un nodo n es ancestro de un nodo m si existe un camino desde n a m. Implemente un
método en la clase GeneralTree con la siguiente firma:
public boolean esAncestro(T a, T b): devuelve true si el valor “a” es ancestro del valor “b”.*/
    private GeneralTree<T> buscar (GeneralTree<T> ab, T a){
        if(ab == null  || ab.isEmpty()){
            return null;
        }
        if(ab.getData().equals(a))
            return ab;
        if(ab.hasChildren()){
            List<GeneralTree<T>> children = ab.getChildren(); 
            for(GeneralTree<T> child :  children){
                GeneralTree<T> result = buscar(child, a); // Llamada recursiva
                if (result != null) {
                    return result; // Si se encuentra el nodo, se retorna
                }
            }
        }
        return null;

    }

    public boolean esAncestro(T a, T b){
        if(this == null || !this.hasChildren()){
            return false;
        }
        GeneralTree<T> buscado = buscar(this, a);
        if(buscado == null || !buscado.hasChildren())
            return false;
        GeneralTree<T>buscadoB = buscar(buscado, b);
        
        if(buscadoB == null)
            return false;
        else
            return true;
          
    }
}