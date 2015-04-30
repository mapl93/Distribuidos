package proyectormiservidor;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.JDOMParseException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
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
    public static String[] leerClientesDeXML(){
        Document doc;
        Element root, child;
        List <Element> rootChildrens;
        int pos = 0;
        int i = 0;
        String[] clientesEncontrados = new String[500] ;

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
                    clientesEncontrados[i] = child.getAttributeValue(Util.TAG_ID_CLIENTE);
                    clientesEncontrados[i++] = child.getAttributeValue(Util.TAG_PUERTO_CLIENTE);
                    clientesEncontrados[i+2] = child.getAttributeValue(Util.TAG_ID_CLIENTE_VECINO_DERECHA);
                    clientesEncontrados[i+3] = child.getAttributeValue(Util.TAG_ID_CLIENTE_VECINO_IZQUIERDA);
                    clientesEncontrados[i+4] = child.getAttributeValue(Util.TAG_PUERTO_CLIENTE_DERECHA);
                    clientesEncontrados[i+5] = child.getAttributeValue(Util.TAG_PUERTO_CLIENTE_IZQUIERDA);
                    i = i+6;
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
    public static boolean guardarClienteEnXML(String[] cliente){
        Document doc;
        Element root, newChild;

        SAXBuilder  builder = new SAXBuilder();
        System.out.println("1");
        try
        {
            doc = builder.build(Util.DIR_XML_CLIENTES);
            root = doc.getRootElement();

            newChild = new Element(Util.TAG_CLIENTE);
            System.out.println("10");
            newChild.setAttribute(Util.TAG_ID_CLIENTE, cliente[0]);
            newChild.setAttribute(Util.TAG_PUERTO_CLIENTE, cliente[1]);
            newChild.setAttribute(Util.TAG_ID_CLIENTE_VECINO_DERECHA, cliente[2]);
            newChild.setAttribute(Util.TAG_ID_CLIENTE_VECINO_IZQUIERDA, cliente[3]);
            newChild.setAttribute(Util.TAG_PUERTO_CLIENTE_DERECHA, cliente[4]);
            newChild.setAttribute(Util.TAG_PUERTO_CLIENTE_IZQUIERDA, cliente[5]);
            
            System.out.println("100");
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
        int i = 0;
        int c = 0;
        String[] clientesEncontrados = new String[500] ;
        String [] clientesAGuardar = new String[500];

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
                    clientesEncontrados[i] = child.getAttributeValue(Util.TAG_ID_CLIENTE);
                    clientesEncontrados[i++] = child.getAttributeValue(Util.TAG_PUERTO_CLIENTE);
                    clientesEncontrados[i+2] = child.getAttributeValue(Util.TAG_ID_CLIENTE_VECINO_DERECHA);
                    clientesEncontrados[i+3] = child.getAttributeValue(Util.TAG_ID_CLIENTE_VECINO_IZQUIERDA);
                    clientesEncontrados[i+4] = child.getAttributeValue(Util.TAG_PUERTO_CLIENTE_DERECHA);
                    clientesEncontrados[i+5] = child.getAttributeValue(Util.TAG_PUERTO_CLIENTE_IZQUIERDA);
                    i = i+6;
                }
                pos++;
            }
            
            i = 0;
            while (i<clientesEncontrados.length)
            {
                if (!clientesEncontrados[i].equals(clienteId)){
                    clientesAGuardar[c] = clientesEncontrados[i];
                    clientesAGuardar[c++] = clientesEncontrados[i++];
                    c+=2;
                }

                i+=2;
            }
            guardarClienteEnXML(clientesAGuardar);
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
     public static boolean guardarListaDeClientesEnXML(String[] listaClientes){
        Document doc;
        Element root, newChild;
        int pos = 0;
        int i = 0;

        SAXBuilder builder = new SAXBuilder();

        try
        {
            doc = builder.build(Util.DIR_XML_CLIENTES);
            root = doc.getRootElement();
            
            while (i<listaClientes.length)
            {

                newChild = new Element(Util.TAG_CLIENTE);

                newChild.setAttribute(Util.TAG_ID_CLIENTE, listaClientes[i]);
                newChild.setAttribute(Util.TAG_PUERTO_CLIENTE, listaClientes[i++]);
                newChild.setAttribute(Util.TAG_ID_CLIENTE_VECINO_DERECHA, listaClientes[i+2]);
                newChild.setAttribute(Util.TAG_ID_CLIENTE_VECINO_IZQUIERDA, listaClientes[i+3]);
                newChild.setAttribute(Util.TAG_PUERTO_CLIENTE_DERECHA, listaClientes[i+4]);
                newChild.setAttribute(Util.TAG_PUERTO_CLIENTE_IZQUIERDA, listaClientes[i+5]);
                root.addContent(newChild);
                i+=6;
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
                    System.out.println("while");
                    while (i<length)
                    {
                        if (clientesEncontrados[i].equals(Integer.toString(c))){
                            existe = true;
                            break;
                        }
                            System.out.println(existe);
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
}