package parciales.grafos;

public class Sitio {
    private String nombre;
    private int tiempo;

    public Sitio(String nombre, int tiempo){
        this.nombre = nombre;
        this.tiempo = tiempo;
    }

    public int getTiempo(){
        return this.tiempo;
    }
    
    public String getNombre(){
        return this.nombre;
    }
}
