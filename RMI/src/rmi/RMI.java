package rmi;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Santiago Bernal
 */
public interface RMI extends Remote{
    public String getData(String data) throws RemoteException;
    public String getId() throws RemoteException;   
    public List<Cliente> getSucursals() throws RemoteException;
    public Cliente getClienteNuevo() throws RemoteException;
    public String[] getVecinos(String idVecino, String idCliente) throws RemoteException;
}
