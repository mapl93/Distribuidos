/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmicliente;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Santiago Bernal
 */
public class RMIClienteListener extends UnicastRemoteObject{
    
    private static int serverClientPort;
    
    public RMIClienteListener(int serverClientPorta) throws RemoteException {
        serverClientPort = serverClientPorta; 
        Listen();
    }
    
    public RMIClienteListener() throws RemoteException {
        super();    
    }
    
    public static void Listen() {
        try {
            Registry reg = LocateRegistry.createRegistry(serverClientPort);
            reg.rebind("server", new RMIClienteListener());
            System.out.println("Cliente esta escuchando");
        } catch (Exception e){
            System.out.println(e);
        }
    }
    
}
