package practica2;

public class Nodo {
    private int l;
    private int r;

    public Nodo(int izq, int der){
        this.l = izq;
        this.r = der;
    }

    public Nodo(){
        this.l = 0;
        this.r = 0;
    }

    public int getL(){
        return this.l;
    }

    public int getR(){
        return this.r;
    }

    public void setL(int izq){
        this.l = izq;
    }

    public void setR(int der){
        this.r = der;
    }

    public String toString(){
        return "Lado izq: "+ getL() + " .Lado der: " + getR(); 
    }
}
