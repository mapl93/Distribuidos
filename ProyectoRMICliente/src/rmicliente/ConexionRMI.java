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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import rmi.Cliente;
import rmi.RMI;

/**
 *Clase para el manejo de las conexiones del cliente con el servidor a traves de
 * RMI
 * @author Santiago Bernal
 * @author Manuel Pacheco
 */
public class ConexionRMI {
    
    private ConexionRMI conexion;
    
    public ConexionRMI() {
        
    }
    /**
     * Metodo para la conexion con el servidor
     * @exception Remote Exception
     */
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
    /**
     * Metodo para obtener el id del cliente que se creo
     * @return Objeto Cliente correspondiente al cliente creado
     * @throws Remote Exception si no se logra conectar con el servidor
     */
    public static rmi.Cliente getMyId()
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
    /**
     * Busca la informacion de posible clientes vecinos
     * @return String[] con los posibles clientes
     * @throws Remote Exception si no se logra conectar con el servidor
     */
    public static List<Cliente> buscarInfoCB(){
        List<Cliente> vecinosPosibles = new ArrayList<>();
        try {
            Registry reg = LocateRegistry.getRegistry("127.0.0.1", 1099);
            RMI rmi  = (RMI) reg.lookup("server");
            vecinosPosibles = rmi.getSucursals();
        }
        catch (Exception e){
            System.out.println(e);
        }
        return vecinosPosibles;
    }  
    
   public static String[] solicitarVecino(String idVecino, String idCliente) {
       try {
            Registry reg = LocateRegistry.getRegistry("127.0.0.1", 1099);
            RMI rmi  = (RMI) reg.lookup("server");
            String[] vecinos = rmi.getVecinos(idVecino, idCliente);
            return vecinos;
        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
}
