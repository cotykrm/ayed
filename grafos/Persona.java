package practica5.ejercicio5;

/*la persona puede ser un jubilado o un empleado del banco que llevará el dinero.
Se necesita armar la cartera de jubilados para cada empleado repartidor del banco, incluyendo en cada lista, los
jubilados que vivan un radio cercano a su casa y no hayan percibido la jubilación del mes.
Para ello, implemente un algoritmo que dado un Grafo<Persona> retorne una lista de jubilados que se
encuentren a una distancia menor a un valor dado del empleado Itaú (grado de separación del empleado Itaú).
El método recibirá un Grafo<Persona>, un empleado y un grado de separación/distancia y debe retornar una
lista de hasta 40 jubilados que no hayan percibido la jubilación del mes y se encuentre a una distancia menor a
recibido como parámetro. */

public class Persona {
    private String nombre;
    private String direccion;
    private boolean esJubilado;
    private boolean yaCobro;

    public Persona(String nombre, String apellido, String direccion, boolean esJubilado, boolean yaCobro) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.esJubilado = esJubilado;
        this.yaCobro = yaCobro;
    }

    public boolean getEsJubilado(){
        return this.esJubilado;
    }

    public boolean getYaCobro(){
        return this.yaCobro;
    }

    public void setYaCobro(boolean cobro){
        this.yaCobro = cobro;
    }

    public String getNombre(){
        return this.nombre;
    }


    public String toString(){
        return "Nombre: "+this.nombre+" . Es jubilado: "+this.esJubilado + ". Ya cobro: "+this.yaCobro;
    }
}
