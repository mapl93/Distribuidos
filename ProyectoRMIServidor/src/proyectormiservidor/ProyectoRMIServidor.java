/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectormiservidor;

import View.Servidor;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import rmi.Cliente;
import rmi.RMI;

/**
 * Clase principal del servidor
 * @author Santiago Bernal
 * @author Manuel Pacheco
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
     throw new RemoteException();
    /* String[] clienteNuevo = new String [6];
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
     return clienteNuevo[0];*/
 }
 /**
  * Retorna los clientes que estan logeados en el servidor
  * @return Lista de clientes conectados
  * @throws RemoteException 
  */
  @Override
 public List<Cliente> getSucursals() throws RemoteException {
     List<Cliente> sucursales = XMLClientes.leerClientesDeXML();
      System.out.println("Cliente Solicita sucursales");
     return sucursales;
 }
  /**
   * Crea el objeto cliente y le asigna los datos
   * @return Cliente con los datos del cliente nuevo
   */
 @Override
 public Cliente getClienteNuevo()
 {
     try {
        Cliente clienteNuevo = new Cliente();
        clienteNuevo.setId(XMLClientes.asignarId());
        clienteNuevo.setPuerto(Integer.toString(Integer.parseInt(clienteNuevo.getId()) + 56000));
        clienteNuevo.setIdVecinoDerecha("N/A");
        clienteNuevo.setIdVecinoIzquierda("N/A");
        clienteNuevo.setPuertoVecinoDerecha("N/A");
        clienteNuevo.setPuertoVecinoIzquierda("N/A");
        XMLClientes.guardarClienteEnXML(clienteNuevo);
        System.out.println("Cliente nuevo conectado");
        System.out.println("ID: " + clienteNuevo.getId());
        System.out.println("Puerto: " + clienteNuevo.getPuerto());
        return clienteNuevo;
     }
     catch (Exception e)
     {
         System.out.println(e);
         return null;
     }
      
 }
 /**
  * Le asigna el vecino requerido al cliente y acomoda el anillo
  * @param idVecino id del vecino solicitado
  * @param idCliente id del cliente solicitado
  * @return String array con la informacion de los vecinos
  * @throws RemoteException 
  */
  @Override
    public String[] getVecinos(String idVecino, String idCliente) throws RemoteException {
      System.out.println("Cliente Solicita vecino");
           String[] vecinos = XMLClientes.buscarVecino(idVecino, idCliente);      
           System.out.println("vecino: " + vecinos[0] + " puerto: " + vecinos[1] +
                     " izq: " + vecinos[2] + " puerto: " + vecinos[3]);
           return vecinos;
       }
   /**
    * Metodo main para correr el servidor
    * @param args 
    */  
    public static void main(String[] args) {
        try {
            Registry reg = LocateRegistry.createRegistry(1099);
            reg.rebind("server", new ProyectoRMIServidor());
            System.out.println("Servidor esta corriendo");
             Servidor newServidor = new Servidor();
            newServidor.setVisible(true);  
        } catch (Exception e){
            System.out.println(e);
        }
    }

   
}
