/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.util.Iterator;
import java.util.Set;

/**
 *Clase manejadora de la lista de clientes
 * @author Santiago Bernal
 * @author Manuel Pacheco
 */
public class ListaClientes {
     private Set<Cliente> ListaClientes;
    
    public Iterator iterator(){
        return this.ListaClientes.iterator();
    }
    
    public Set<Cliente> getClienteList() {
        return ListaClientes;
    }
    
    public boolean addCliente (Cliente cliente)
    {
        return this.ListaClientes.add(cliente);
    }
    
    public Cliente getCliente (String id){
        
        Iterator listIterator = this.iterator(); 
        
        while (listIterator.hasNext()){
            Cliente actualCliente = (Cliente) listIterator.next(); 
            if (actualCliente.getId().equals((String) id)){
                return actualCliente; 
            }
        }
        return null;
    }
}
