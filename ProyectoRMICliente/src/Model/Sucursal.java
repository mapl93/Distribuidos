/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author MAPL
 */
public class Sucursal {
    
    private int id;
    private Paquete[] paquetes = new Paquete[2];

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Paquete[] getPaquetes() {
        return paquetes;
    }

    public void setPaquetes(Paquete[] paquetes) {
        this.paquetes = paquetes;
    }
    
    
    
}
