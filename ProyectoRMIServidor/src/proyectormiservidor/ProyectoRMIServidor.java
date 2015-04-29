/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectormiservidor;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import rmi.RMI;

/**
 *
 * @author Santiago Bernal
 */
public class ProyectoRMIServidor extends UnicastRemoteObject implements RMI{

 public ProyectoRMIServidor() throws RemoteException {
     super();
 }
 
 @Override
 public String getData(String text) throws RemoteException {
     text = "Hi " + text;
     return text;
 }
 
 @Override
 public String[] getId() throws RemoteException {
     String[] clienteNuevo = new String [4];
     clienteNuevo[0] = XMLClientes.asignarId();
     clienteNuevo[1] = Integer.toString(Util.PUERTO_SERVIDOR);
     clienteNuevo[2] = "0";
     clienteNuevo[4] = "0";
     XMLClientes.guardarClienteEnXML(clienteNuevo);
     return clienteNuevo;
 }
 
 @Override
 public String[] getSucursals() throws RemoteException {
     String[] sucursales = XMLClientes.leerClientesDeXML();
     return sucursales;
 }
 
 
     
    public static void main(String[] args) {
        try {
            Registry reg = LocateRegistry.createRegistry(1099);
            reg.rebind("server", new ProyectoRMIServidor());
            System.out.println("Servidor esta corriendo");
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
