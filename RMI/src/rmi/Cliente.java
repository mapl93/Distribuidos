/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Clase de manejo de los clientes
 *@author Manuel Pacheco
 * @author Santiago Bernal
 */
public class Cliente implements Serializable {
    private String id;
    private String puerto;
    private String idVecinoDerecha;
    private String idVecinoIzquierda;
    private String puertoVecinoDerecha;
    private String puertoVecinoIzquierda;
    
    public Cliente() throws RemoteException
    {
        
    }
    
    public Cliente(String id, String puerto, String idVecinoDerecha, String idVecinoIzquierda, String puertoVecinoDerecha, String puertoVecinoIzquierda) throws RemoteException {
        this.id = id;
        this.puerto = puerto;
        this.idVecinoDerecha = idVecinoDerecha;
        this.idVecinoIzquierda = idVecinoIzquierda;
        this.puertoVecinoDerecha = puertoVecinoDerecha;
        this.puertoVecinoIzquierda = puertoVecinoIzquierda;
    }

    public String getId() {
        return id;
    }

    public String getPuerto() {
        return puerto;
    }

    public String getIdVecinoDerecha() {
        return idVecinoDerecha;
    }

    public String getIdVecinoIzquierda() {
        return idVecinoIzquierda;
    }

    public String getPuertoVecinoDerecha() {
        return puertoVecinoDerecha;
    }

    public String getPuertoVecinoIzquierda() {
        return puertoVecinoIzquierda;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }

    public void setIdVecinoDerecha(String idVecinoDerecha) {
        this.idVecinoDerecha = idVecinoDerecha;
    }

    public void setIdVecinoIzquierda(String idVecinoIzquierda) {
        this.idVecinoIzquierda = idVecinoIzquierda;
    }

    public void setPuertoVecinoDerecha(String puertoVecinoDerecha) {
        this.puertoVecinoDerecha = puertoVecinoDerecha;
    }

    public void setPuertoVecinoIzquierda(String puertoVecinoIzquierda) {
        this.puertoVecinoIzquierda = puertoVecinoIzquierda;
    }
        
}
