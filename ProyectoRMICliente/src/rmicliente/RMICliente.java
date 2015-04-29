/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmicliente;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import rmi.RMI;
import View.ventanaCliente;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Santiago Bernal
 */
public class RMICliente extends UnicastRemoteObject {
    
    private static String[] idAndServerPort = new String[4];

    public RMICliente() throws RemoteException {
    }
    
    public static void main (String arg[]) throws RemoteException{
        RMICliente cliente = new RMICliente();
        idAndServerPort = cliente.conectar();
        System.out.println("Pase el Conectar");
        System.out.println(idAndServerPort[1]);
        //clientServer(Integer.parseInt(idAndServerPort[1]));
        System.out.println("Pase el clientSever");
        ventanaCliente newVentanaCliente = new ventanaCliente();
        newVentanaCliente.setVisible(true);
    }

    private String[] conectar() throws RemoteException {
        try {
            Registry reg = LocateRegistry.getRegistry("127.0.0.1", 1099);
            RMI rmi  = (RMI) reg.lookup("server");
            System.out.println("conectado con el servidor");
            String id[] = new String[4];
            id = rmi.getId();
            return id;
        }
        catch (Exception e){
            System.out.println();
            return null;
        }
   }
    
    private static void clientServer (int serverPort) throws RemoteException{
        try {
            Registry reg = LocateRegistry.createRegistry(serverPort);
            reg.rebind("client", new RMICliente());
            System.out.println("Cliente esta corriendo");
        } catch (Exception e){
            System.out.println(e);
        }
    }
  
}
