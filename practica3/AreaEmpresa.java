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

/*Donde AreaEmpresa es una clase que representa a un área de la empresa mencionada y que contiene
la identificación de la misma representada con un String y una tardanza de transmisión de mensajes
interna representada con int*/

public class AreaEmpresa {
    String area;
    int tardanza;
    
    public AreaEmpresa(String area, int tardanza){
        this.area = area;
        this.tardanza = tardanza;
    } 
    
    public String getArea(){
        return this.area;
    }
    
    public int getTardanza(){
        return this.tardanza;
    }
}
