/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *Clase para el manejo de XML de los paquetes
 *@author Santiago Bernal
 * @author Manuel Pacheco
 * 
 */
public class XMLPaquetes {
    /**
     * Metodo para leer los paquetes del xml
     * @return String array con los paquetes del xml
     * @throws excepciones de lectura de archivos
     * 
     */
    public static String[] leerPaquetesDeXML(){
        Document doc;
        Element root, child;
        List <Element> rootChildrens;
        int pos = 0;
        int i = 0;
        String[] paquetesEncontrados = new String[500] ;

        SAXBuilder builder = new SAXBuilder();

        try
        {
            doc = builder.build(Util.DIR_XML_PAQUETES);

            root = doc.getRootElement();
            rootChildrens = root.getChildren();

            while (pos < rootChildrens.size())
            {
                child = rootChildrens.get(pos);           
                
                if (child.getAttributeValue(Util.TAG_ID_DESTINO) != null )
                {
                    paquetesEncontrados[i] = child.getAttributeValue(Util.TAG_ID_ORIGEN);
                    paquetesEncontrados[i++] = child.getAttributeValue(Util.TAG_ID_DESTINO);
                    paquetesEncontrados[i+2] = child.getAttributeValue(Util.TAG_TIEMPO);
                    paquetesEncontrados[i+3] = child.getAttributeValue(Util.TAG_TIEMPO_ENVIO);
                    paquetesEncontrados[i+4] = child.getAttributeValue(Util.TAG_TIEMPO_RECEPCION);
                    paquetesEncontrados[i+5] = child.getAttributeValue(Util.TAG_TIEMPO_CREADO);
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
        
        return paquetesEncontrados;
    }
    /**
     * Metodo para guardar los paquetes en el xml
     * @return booleano true si se pudo completar
     * @param String array con el paquete a guardar 
     * @throws excepciones de lectura de archivos
     * 
     */
    public static boolean guardarPaqueteEnXML(String[] paquete){
        Document doc;
        Element root, newChild;

        SAXBuilder  builder = new SAXBuilder();

        try
        {
            doc = builder.build(Util.DIR_XML_PAQUETES);
            root = doc.getRootElement();

            newChild = new Element(Util.TAG_PAQUETE);

            newChild.setAttribute(Util.TAG_ID_ORIGEN, paquete[0]);
            newChild.setAttribute(Util.TAG_ID_DESTINO, paquete[1]);
            newChild.setAttribute(Util.TAG_TIEMPO, paquete[2]);
            newChild.setAttribute(Util.TAG_TIEMPO_ENVIO, paquete[3]);
            newChild.setAttribute(Util.TAG_TIEMPO_RECEPCION, paquete[4]);
            newChild.setAttribute(Util.TAG_TIEMPO_CREADO, paquete[5]);
            

            root.addContent(newChild);

            try
            {
                Format format = Format.getPrettyFormat();

                XMLOutputter out = new XMLOutputter(format);

                FileOutputStream file = new FileOutputStream(Util.DIR_XML_PAQUETES);

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
     * Metodo para borrar todos los paquetes del XML
     * @return boolean true si se pudo completar
     * @throws excepciones de lectura de archivos
     * 
     */
    public static boolean borrarTodosLosPaquetes(){
        Document doc;
        Element root;

        SAXBuilder  builder = new SAXBuilder();

        try
        {
            doc = builder.build(Util.DIR_XML_PAQUETES);
            root = doc.getRootElement();
            
            root.removeChildren(Util.TAG_PAQUETE);

            try
            {
                Format format = Format.getPrettyFormat();

                XMLOutputter out = new XMLOutputter(format);

                FileOutputStream file = new FileOutputStream(Util.DIR_XML_PAQUETES);

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
     * Metodo para guardar una lista de paquetes en un xml
     * @return boolean true si se pudo completar
     * @param String array con la lista de paquetes
     * @throws excepciones de lectura de archivos
     * 
     */
     public static boolean guardarListaDePaquetesEnXML(String[] listaPaquetes){
        Document doc;
        Element root, newChild;
        int pos = 0;
        int i = 0;

        SAXBuilder builder = new SAXBuilder();

        try
        {
            doc = builder.build(Util.DIR_XML_CLIENTES);
            root = doc.getRootElement();
            
            while (i<listaPaquetes.length)
            {

                newChild = new Element(Util.TAG_PAQUETE);

            newChild.setAttribute(Util.TAG_ID_ORIGEN, listaPaquetes[0]);
            newChild.setAttribute(Util.TAG_ID_DESTINO, listaPaquetes[1]);
            newChild.setAttribute(Util.TAG_TIEMPO, listaPaquetes[2]);
            newChild.setAttribute(Util.TAG_TIEMPO_ENVIO, listaPaquetes[3]);
            newChild.setAttribute(Util.TAG_TIEMPO_RECEPCION, listaPaquetes[4]);
            newChild.setAttribute(Util.TAG_TIEMPO_CREADO, listaPaquetes[5]);

                root.addContent(newChild);
                i+=6;
            }

            try
            {
                Format format = Format.getPrettyFormat();

                XMLOutputter out = new XMLOutputter(format);

                FileOutputStream file = new FileOutputStream(Util.DIR_XML_PAQUETES);

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
}
