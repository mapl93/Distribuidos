/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectormiservidor;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import rmi.Cliente;
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
 public String getId() throws RemoteException {
     String[] clienteNuevo = new String [6];
     clienteNuevo[0] = XMLClientes.asignarId();
     System.out.println("10000");
     clienteNuevo[1] = Integer.toString(Integer.parseInt(clienteNuevo[0]) + 56000);
     System.out.println("10000");
     clienteNuevo[2] = "N/A";
     clienteNuevo[3] = "N/A";
     clienteNuevo[4] = "N/A";
     clienteNuevo[5] = "N/A";
     System.out.println("10000");
     XMLClientes.guardarClienteEnXML(clienteNuevo);
     return clienteNuevo[0];
 }
 
  @Override
 public String[] getSucursals() throws RemoteException {
     String[] sucursales = XMLClientes.leerClientesDeXML();
     return sucursales;
 }
  
 @Override
 public Cliente getClienteNuevo()
 {
     try {
        Cliente clienteNuevo = new Cliente();
        clienteNuevo.setId(XMLClientes.asignarId());
        clienteNuevo.setPuerto(Integer.toString(Integer.parseInt(clienteNuevo.getId()) + 56000));
        System.out.println(clienteNuevo.getId());
        return clienteNuevo;
     }
     catch (Exception e)
     {
         System.out.println(e);
         return null;
     }
      
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
