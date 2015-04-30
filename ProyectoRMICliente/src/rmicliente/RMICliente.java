/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmicliente;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import rmi.RMI;
import View.ventanaCliente;

/**
 *
 * @author Santiago Bernal
 */
public class RMICliente {
    
    
    
    public static void main (String arg[]){
        ventanaCliente newVentanaCliente = new ventanaCliente();
        newVentanaCliente.setVisible(true);  
    }
  
}
