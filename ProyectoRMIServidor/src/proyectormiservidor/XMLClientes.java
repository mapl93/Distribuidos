package proyectormiservidor;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.JDOMParseException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import rmi.Cliente;
/** 
 * Clase para el manejo del XML de los clientes
 * @author Santiago Bernal
 * @author Manuel Pacheco
 */
public class XMLClientes {
    
    /**
     * Metodo para leer los clientes del xml
     * @return String array con los clientes del xml
     * @throws excepciones de lectura de archivos
     * 
     */
    public static List<Cliente> leerClientesDeXML(){
        Document doc;
        Element root, child;
        List <Element> rootChildrens;
        int pos = 0;
        List<Cliente> clientesEncontrados = new ArrayList<>() ;

        SAXBuilder builder = new SAXBuilder();

        try
        {
            doc = builder.build(Util.DIR_XML_CLIENTES);

            root = doc.getRootElement();
            rootChildrens = root.getChildren();

            while (pos < rootChildrens.size())
            {
                child = rootChildrens.get(pos);           
                
                if (child.getAttributeValue(Util.TAG_ID_CLIENTE) != null )
                {
                    Cliente clienteEncontrado = new Cliente();
                    clienteEncontrado.setId(child.getAttributeValue(Util.TAG_ID_CLIENTE));
                    clienteEncontrado.setPuerto(child.getAttributeValue(Util.TAG_PUERTO_CLIENTE));
                    clienteEncontrado.setIdVecinoDerecha(child.getAttributeValue(Util.TAG_ID_CLIENTE_VECINO_DERECHA));
                    clienteEncontrado.setIdVecinoIzquierda(child.getAttributeValue(Util.TAG_ID_CLIENTE_VECINO_IZQUIERDA)); 
                    clienteEncontrado.setPuertoVecinoDerecha(child.getAttributeValue(Util.TAG_PUERTO_CLIENTE_DERECHA)); 
                    clienteEncontrado.setPuertoVecinoIzquierda(child.getAttributeValue(Util.TAG_PUERTO_CLIENTE_IZQUIERDA)); 
                    clientesEncontrados.add(clienteEncontrado);
                }
                pos++;
            }
        }
        catch(JDOMParseException e)
        {
            System.out.println(Util.ERROR_XML_VACIO);
            e.printStackTrace();
        }
        catch(JDOMException e)
        {
            System.out.println(Util.ERROR_XML_CARGANDO);
            e.printStackTrace();
        }
        catch(IOException e)
        {
            System.out.println(Util.ERROR_XML_CARGANDO);
            e.printStackTrace();
        }
        
        return clientesEncontrados;
    }
    /**
     * Metodo para guardar los clientes en el xml
     * @return booleano true si se pudo completar
     * @param String array con el cliente a guardar 
     * @throws excepciones de lectura de archivos
     * 
     */
    public static boolean guardarClienteEnXML(Cliente cliente){
        Document doc;
        Element root, newChild;

        SAXBuilder  builder = new SAXBuilder();
        try
        {
            doc = builder.build(Util.DIR_XML_CLIENTES);
            root = doc.getRootElement();

            newChild = new Element(Util.TAG_CLIENTE);
            newChild.setAttribute(Util.TAG_ID_CLIENTE, cliente.getId());
            newChild.setAttribute(Util.TAG_PUERTO_CLIENTE, cliente.getPuerto());
            newChild.setAttribute(Util.TAG_ID_CLIENTE_VECINO_DERECHA, cliente.getIdVecinoDerecha());
            newChild.setAttribute(Util.TAG_ID_CLIENTE_VECINO_IZQUIERDA, cliente.getIdVecinoIzquierda());
            newChild.setAttribute(Util.TAG_PUERTO_CLIENTE_DERECHA, cliente.getPuertoVecinoDerecha());
            newChild.setAttribute(Util.TAG_PUERTO_CLIENTE_IZQUIERDA, cliente.getPuertoVecinoIzquierda());
            
            root.addContent(newChild);

            try
            {
                Format format = Format.getPrettyFormat();

                XMLOutputter out = new XMLOutputter(format);

                FileOutputStream file = new FileOutputStream(Util.DIR_XML_CLIENTES);

                out.output(doc,file);

                file.flush();
                file.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        catch(JDOMParseException e)
        {
            System.out.println(Util.ERROR_XML_VACIO);
            e.printStackTrace();
        }
        catch(JDOMException e)
        {
            System.out.println(Util.ERROR_XML_CARGANDO);
            e.printStackTrace();
        }
        catch(IOException e)
        {
            System.out.println(Util.ERROR_XML_CARGANDO);
            e.printStackTrace();
        }

        return true;
    }
    
    /**
     * Metodo para borrar todos los clientes del XML
     * @return boolean true si se pudo completar
     * @throws excepciones de lectura de archivos
     * 
     */
    public static boolean borrarTodosLosClientes(){
        Document doc;
        Element root;

        SAXBuilder  builder = new SAXBuilder();

        try
        {
            doc = builder.build(Util.DIR_XML_CLIENTES);
            root = doc.getRootElement();
            
            root.removeChildren(Util.TAG_CLIENTE);

            try
            {
                Format format = Format.getPrettyFormat();

                XMLOutputter out = new XMLOutputter(format);

                FileOutputStream file = new FileOutputStream(Util.DIR_XML_CLIENTES);

                out.output(doc,file);

                file.flush();
                file.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        catch(JDOMParseException e)
        {
            System.out.println(Util.ERROR_XML_VACIO);
            e.printStackTrace();
        }
        catch(JDOMException e)
        {
            System.out.println(Util.ERROR_XML_CARGANDO);
            e.printStackTrace();
        }
        catch(IOException e)
        {
            System.out.println(Util.ERROR_XML_CARGANDO);
            e.printStackTrace();
        }

        return true;
    }
    /**
     * Metodo para borrar un cliente del xml
     * @return boolean true si se pudo completar
     * @param String del id del cliente a eliminar
     * @throws excepciones de lectura de archivos
     * 
     */
   public static boolean borrarClienteDelXML(String clienteId){
        Document doc;
        Element root, child;
        List <Element> rootChildrens;
        int pos = 0;
        int c = 0;
        int i =0;
        List<Cliente> clientesEncontrados = new ArrayList<>() ;
        List<Cliente> clientesAGuardar = new ArrayList<>();

        SAXBuilder builder = new SAXBuilder();

        try
        {
            doc = builder.build(Util.DIR_XML_CLIENTES);

            root = doc.getRootElement();
            rootChildrens = root.getChildren();

            while (pos < rootChildrens.size())
            {
                child = rootChildrens.get(pos);           
                
                if (child.getAttributeValue(Util.TAG_ID_CLIENTE) != null )
                {
                    Cliente clienteEncontrado = new Cliente();
                    clienteEncontrado.setId(child.getAttributeValue(Util.TAG_ID_CLIENTE));
                    clienteEncontrado.setPuerto(child.getAttributeValue(Util.TAG_PUERTO_CLIENTE));
                    clienteEncontrado.setIdVecinoDerecha(child.getAttributeValue(Util.TAG_ID_CLIENTE_VECINO_DERECHA));
                    clienteEncontrado.setIdVecinoIzquierda(child.getAttributeValue(Util.TAG_ID_CLIENTE_VECINO_IZQUIERDA)); 
                    clienteEncontrado.setPuertoVecinoDerecha(child.getAttributeValue(Util.TAG_PUERTO_CLIENTE_DERECHA)); 
                    clienteEncontrado.setPuertoVecinoIzquierda(child.getAttributeValue(Util.TAG_PUERTO_CLIENTE_IZQUIERDA)); 
                    clientesEncontrados.add(clienteEncontrado);
                }
                pos++;
            }
            for (Cliente cliente : clientesEncontrados)
            {
                if (cliente.getId().equals(clienteId))
                {
                    clientesEncontrados.remove(cliente);
                }
            }
            borrarTodosLosClientes();
            guardarListaDeClientesEnXML(clientesEncontrados);
        }
        catch(JDOMParseException e)
        {
            System.out.println(Util.ERROR_XML_VACIO);
            e.printStackTrace();
        }
        catch(JDOMException e)
        {
            System.out.println(Util.ERROR_XML_CARGANDO);
            e.printStackTrace();
        }
        catch(IOException e)
        {
            System.out.println(Util.ERROR_XML_CARGANDO);
            e.printStackTrace();
        }
        
        return true;
    }
   
   /**
     * Metodo para guardar una lista de clientes en un xml
     * @return boolean true si se pudo completar
     * @param String array con la lista de clientes
     * @throws excepciones de lectura de archivos
     * 
     */
     public static boolean guardarListaDeClientesEnXML(List<Cliente> listaClientes){
        Document doc;
        Element root, newChild;
        int pos = 0;
        int i = 0;

        SAXBuilder builder = new SAXBuilder();

        try
        {
            doc = builder.build(Util.DIR_XML_CLIENTES);
            root = doc.getRootElement();
            for (Cliente cliente : listaClientes)
            {
                newChild = new Element(Util.TAG_CLIENTE);

                newChild.setAttribute(Util.TAG_ID_CLIENTE, cliente.getId());
                newChild.setAttribute(Util.TAG_PUERTO_CLIENTE, cliente.getPuerto());
                newChild.setAttribute(Util.TAG_ID_CLIENTE_VECINO_DERECHA, cliente.getIdVecinoDerecha());
                newChild.setAttribute(Util.TAG_ID_CLIENTE_VECINO_IZQUIERDA, cliente.getIdVecinoIzquierda());
                newChild.setAttribute(Util.TAG_PUERTO_CLIENTE_DERECHA, cliente.getPuertoVecinoDerecha());
                newChild.setAttribute(Util.TAG_PUERTO_CLIENTE_IZQUIERDA, cliente.getPuertoVecinoIzquierda());
                root.addContent(newChild);
            }

            try
            {
                Format format = Format.getPrettyFormat();

                XMLOutputter out = new XMLOutputter(format);

                FileOutputStream file = new FileOutputStream(Util.DIR_XML_CLIENTES);

                out.output(doc,file);

                file.flush();
                file.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        catch(JDOMParseException e)
        {
            System.out.println(Util.ERROR_XML_VACIO);
            e.printStackTrace();
        }
        catch(JDOMException e)
        {
            System.out.println(Util.ERROR_XML_CARGANDO);
            e.printStackTrace();
        }
        catch(IOException e)
        {
            System.out.println(Util.ERROR_XML_CARGANDO);
            e.printStackTrace();
        }
        
        return true;
    }
     
     public static String asignarId()
     {
         Document doc;
        Element root, child;
        List <Element> rootChildrens;
        int pos = 0;
        int i = 0;
        int c = 0;
        int length = 0;
        int idNuevo = 0;
        boolean existe = false;
        String[] clientesEncontrados = new String[500] ;
        

        SAXBuilder builder = new SAXBuilder();
        try
        {
            doc = builder.build(Util.DIR_XML_CLIENTES);

            root = doc.getRootElement();
            rootChildrens = root.getChildren();
            if (rootChildrens!=null)
            {
                while (pos < rootChildrens.size())
                {
                    child = rootChildrens.get(pos);           

                    if (child.getAttributeValue(Util.TAG_ID_CLIENTE) != null)
                    {
                        clientesEncontrados[i] = child.getAttributeValue(Util.TAG_ID_CLIENTE);
                        i++;
                    }
                    pos++;
                }
            }
            length = i++;
                
                while (c<=length)
                {
                    i = 0;
                    while (i<length)
                    {
                        if (clientesEncontrados[i].equals(Integer.toString(c))){
                            existe = true;
                            break;
                        }
                        i++;
                    }
                    if (!existe)
                    {
                        idNuevo = c;
                        break;
                    }
                    c++;
                    existe = false;
                }
            
        }
        catch(JDOMParseException e)
        {
            System.out.println(Util.ERROR_XML_VACIO);
            e.printStackTrace();
        }
        catch(JDOMException e)
        {
            System.out.println(Util.ERROR_XML_CARGANDO);
            e.printStackTrace();
        }
        catch(IOException e)
        {
            System.out.println(Util.ERROR_XML_CARGANDO);
            e.printStackTrace();
        }
        
        return Integer.toString(idNuevo);
     }
     
     /**
      * Acomoda los vecinos cuando hay un cliente nuevo y selecciona su vecino
      *@param vecino cliente vecino nuevo
      *@param vecinoIzquieda cliente vecino nuevo a la izquierda
      *@param cliente Cliente cliente a colocar los vecinos
      * 
      */
     public static void acomodarVecinos (Cliente vecino, Cliente vecinoIzquierda, 
             Cliente cliente , List<Cliente> listaClientes)
     {
         listaClientes.remove(vecino);
         listaClientes.remove(vecinoIzquierda);
         listaClientes.remove(cliente);
         cliente.setIdVecinoDerecha(vecino.getId());
         cliente.setPuertoVecinoDerecha(vecino.getPuerto());
         cliente.setIdVecinoIzquierda(vecino.getIdVecinoIzquierda());
         cliente.setPuertoVecinoIzquierda(vecino.getPuertoVecinoIzquierda());
         vecino.setIdVecinoIzquierda(cliente.getId());
         vecino.setPuertoVecinoIzquierda(cliente.getPuerto());
         if (!vecino.equals(vecinoIzquierda))
         {
            vecinoIzquierda.setIdVecinoDerecha(cliente.getId());
            vecinoIzquierda.setPuertoVecinoDerecha(cliente.getPuerto());    
            listaClientes.add(vecinoIzquierda);
         }
         else
         {
             vecino.setIdVecinoDerecha(cliente.getId());
             vecino.setPuertoVecinoDerecha(cliente.getPuerto());
             cliente.setIdVecinoIzquierda(vecino.getId());
             cliente.setPuertoVecinoIzquierda(vecino.getPuerto());
         }
         
         listaClientes.add(vecino);
         listaClientes.add(cliente);
         borrarTodosLosClientes();
         guardarListaDeClientesEnXML(listaClientes);
         
     }
     

     
     /**
      * Metodo para asignarle los vecinos a un cliente nuevo
      * @param idVecino id del vecino solicitado
      * @param idCliente que solicito el cambio
      * @return String array con los datos de los vecinos con el formato:
      * { id vecino derecha, puerto vecino derecha, id vecino izquierda
      *   puerto vecino izquierda}
      */
     public static String[] buscarVecino(String idVecino, String idCliente)
     {
         Document doc;
        Element root, child;
        List <Element> rootChildrens;
        int pos = 0;
        int c = 0;
        int i =0;
        List<Cliente> clientesEncontrados = new ArrayList<>() ;
        String[] vecinos = new String[6];
        

        SAXBuilder builder = new SAXBuilder();

        try
        {
            Cliente vecino = new Cliente();
            Cliente cliente = new Cliente();
            Cliente vecinoIzquierda = new Cliente();
            doc = builder.build(Util.DIR_XML_CLIENTES);

            root = doc.getRootElement();
            rootChildrens = root.getChildren();

            while (pos < rootChildrens.size())
            {
                child = rootChildrens.get(pos);           
                
                if (child.getAttributeValue(Util.TAG_ID_CLIENTE) != null )
                {
                    Cliente clienteEncontrado = new Cliente();
                    clienteEncontrado.setId(child.getAttributeValue(Util.TAG_ID_CLIENTE));
                    clienteEncontrado.setPuerto(child.getAttributeValue(Util.TAG_PUERTO_CLIENTE));
                    clienteEncontrado.setIdVecinoDerecha(child.getAttributeValue(Util.TAG_ID_CLIENTE_VECINO_DERECHA));
                    clienteEncontrado.setIdVecinoIzquierda(child.getAttributeValue(Util.TAG_ID_CLIENTE_VECINO_IZQUIERDA)); 
                    clienteEncontrado.setPuertoVecinoDerecha(child.getAttributeValue(Util.TAG_PUERTO_CLIENTE_DERECHA)); 
                    clienteEncontrado.setPuertoVecinoIzquierda(child.getAttributeValue(Util.TAG_PUERTO_CLIENTE_IZQUIERDA)); 
                    clientesEncontrados.add(clienteEncontrado);
                }
                pos++;
            }

            for (Cliente clienteActual : clientesEncontrados)
            {
                if (clienteActual.getId().equals(idVecino))
                {
                    vecino = clienteActual;
                }
                if (clienteActual.getId().equals(idCliente))
                {
                    cliente = clienteActual;
                }               
            }
            
            if (vecino.getIdVecinoIzquierda().equals("N/A"))
            {
                vecinoIzquierda = vecino;
            }
            else
            {
                for (Cliente clienteActual : clientesEncontrados)
                {
                    if (clienteActual.getId().equals(vecino.getIdVecinoIzquierda()))
                    {
                        vecinoIzquierda = clienteActual;
                    }
                }
            }
            
                vecinos[0] = vecino.getId();
                vecinos[1] = vecino.getPuerto();
                vecinos[2] = vecinoIzquierda.getId();
                vecinos[3] = vecinoIzquierda.getPuerto();
                
            acomodarVecinos(vecino, vecinoIzquierda, cliente, clientesEncontrados);
        }
        catch(JDOMParseException e)
        {
            System.out.println(Util.ERROR_XML_VACIO);
            e.printStackTrace();
        }
        catch(JDOMException e)
        {
            System.out.println(Util.ERROR_XML_CARGANDO);
            e.printStackTrace();
        }
        catch(IOException e)
        {
            System.out.println(Util.ERROR_XML_CARGANDO);
            e.printStackTrace();
        }
        
        return vecinos;
     }
}