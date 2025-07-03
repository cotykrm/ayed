package practica2;
import practica1.ejercicio8.Queue;


public class BinaryTree <T> {
	
    private T data;
    private BinaryTree<T> leftChild;   
    private BinaryTree<T> rightChild; 

	
    public BinaryTree() {
	super();
    }

    public BinaryTree(T data) {
    	this.data = data;
    }

    public T getData() {
	return data;
    }

    public void setData(T data) {
    	this.data = data;
    }
    /**
     * Preguntar antes de invocar si hasLeftChild()
     * @return
     */
    public BinaryTree<T> getLeftChild() {
	return leftChild;
    }
    /**
     * Preguntar antes de invocar si hasRightChild()
     * @return
     */
    public BinaryTree<T> getRightChild() {
	return this.rightChild;
    }

    public void addLeftChild(BinaryTree<T> child) {
    	this.leftChild = child;
    }

    public void addRightChild(BinaryTree<T> child) {
    	this.rightChild = child;
    }

    public void removeLeftChild() {
    	this.leftChild = null;
    }

    public void removeRightChild() {
	this.rightChild = null;
    }

    public boolean isEmpty(){
	return (this.isLeaf() && this.getData() == null);
    }

    public boolean isLeaf() {
	return (!this.hasLeftChild() && !this.hasRightChild());
    }
		
    public boolean hasLeftChild() {
    	return this.leftChild!=null;
    }

    public boolean hasRightChild() {
    	return this.rightChild!=null;
    }
    @Override
    public String toString() {
	return this.getData().toString();
    }

    public  int contarHojas() {
        if(this.isLeaf())
            return 1;
        int hojas = 0;
        if(this.hasLeftChild())
            hojas+= getLeftChild().contarHojas();
        if(this.hasRightChild())
            hojas+= getRightChild().contarHojas();
        return hojas;
    }
		
    public void preOrden(){
        System.out.println(this.getData());
        if(this.hasLeftChild())
            getLeftChild().preOrden();
        if(this.hasRightChild())
            getRightChild().preOrden();
    }
    	 
    public void inOrden(){
        if(this.hasLeftChild())
            getLeftChild().inOrden();
        System.out.println(this.getData());
        if(this.hasRightChild())
            getRightChild().inOrden();
    }
        
    public void postOrden(){
        if(this.hasLeftChild())
            getLeftChild().postOrden();
        if(this.hasRightChild())
            getRightChild().postOrden();
        System.out.println(this.getData());
    }
        
        
    public BinaryTree<T> espejo(BinaryTree<T> ab){
        Queue <T> cola  = new Queue<T>(); 
        if(!ab.isEmpty()){
            espejo_private(ab,cola);
            BinaryTree <T> espejado = new BinaryTree<T>();
            espejo_private(espejado,cola);
            return espejado;
        }else
 	   return null;
    }
    
    private void espejo_private(BinaryTree<T> ab, Queue<T> cola){
        cola.enqueue(ab.getData());
        if(ab.hasLeftChild())
            espejo_private(ab.getLeftChild(),cola);
        if(ab.hasRightChild())
            espejo_private(ab.getRightChild(),cola); 
    }

    // 0<=n<=m
    public void entreNiveles(int n, int m){
    	BinaryTree<T> ab = null;
        Queue<BinaryTree<T>> cola = new Queue<BinaryTree<T>>();
        int soygay = 0;
        cola.enqueue(this);
        cola.enqueue(null);
        while (!cola.isEmpty()) {
            ab = cola.dequeue();
            if (ab != null) {
        	if(soygay>=n && soygay<=m) {
                    System.out.print(ab.getData());
                    if (ab.hasLeftChild()) {
        		cola.enqueue(ab.getLeftChild());
                    }
                    if (ab.hasRightChild()) {
        		cola.enqueue(ab.getRightChild());
                    }
                }
            } else if (!cola.isEmpty()) {
        	System.out.println();
        	cola.enqueue(null);
		soygay++;
            }
        }
    }
   
    public void printLevelTraversal() {
    	BinaryTree<T> ab = null;
    	Queue<BinaryTree<T>> cola = new Queue<BinaryTree<T>>();
    	cola.enqueue(this);
    	cola.enqueue(null);
    	while (!cola.isEmpty()) {
            ab = cola.dequeue();
            if (ab != null) {
    		System.out.print(ab.getData()+" nivel ");
    		if (ab.hasLeftChild()) {
                    cola.enqueue(ab.getLeftChild());
    		}
    		if (ab.hasRightChild()) {
                    cola.enqueue(ab.getRightChild());
    		}
            } else if (!cola.isEmpty()) {
    		System.out.println();
    		cola.enqueue(null);
            }
        }
    }
    
    public boolean lleno() {
        BinaryTree<T> ab = null;
        Queue<BinaryTree<T>> cola = new Queue<BinaryTree<T>>();
        boolean lleno = true;
        int cant_nodos = 0;
        int nivel = 0;
        cola.enqueue(this);
        cola.enqueue(null);
        while (!cola.isEmpty() && lleno) {
            ab = cola.dequeue();
            if (ab != null) {
                if (ab.hasLeftChild()) {
                    cola.enqueue(ab.getLeftChild());
                    cant_nodos++;
                }
                if (ab.hasRightChild()) {
                    cola.enqueue(ab.getRightChild());
                    cant_nodos++;
                }
            } else if (!cola.isEmpty()) {
                if (cant_nodos == Math.pow(2, ++nivel)) {
                    cola.enqueue(null);
                    cant_nodos = 0;
                } else
                    lleno = false;
            }
        }
        return lleno;
    }
}

