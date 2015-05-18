/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmicliente;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import rmi.Cliente;
import rmi.RMI;

/**
 *
 * @author Santiago Bernal
 */
public class ConexionRMI {
    
    private ConexionRMI conexion;
    
    public ConexionRMI() {
        
    }
    
    private void conectar() {
        try {
            Registry reg = LocateRegistry.getRegistry("127.0.0.1", 1099);
            RMI rmi  = (RMI) reg.lookup("server");
            System.out.println("conectado con el servidor");
        }
        catch (Exception e){
            System.out.println();
        }
   }
    
    public rmi.Cliente getMyId()
    {            
        try {
            Cliente cliente = new Cliente();
            Registry reg = LocateRegistry.getRegistry("127.0.0.1", 1099);
            RMI rmi  = (RMI) reg.lookup("server");
            cliente = rmi.getClienteNuevo();
            return cliente;
            
        } catch (RemoteException ex) {
            System.out.println(ex);
        } catch (NotBoundException ex) {
            System.out.println(ex);
        }
        return null;
    }
    
}
