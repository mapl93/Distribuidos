
package proyectormiservidor;

/**
 *Clase con constantes del sistema
 * @author Santiago Bernal
 * @author Manuel Pacheco
 */
public class Util {
    public static final String DIR_XML_CLIENTES = "src/proyectormiservidor/XMLServidor.xml";
    
    public static final String TAG_CLIENTE = "cliente";
    public static final String TAG_ID_CLIENTE = "id";
    public static final String TAG_ID_CLIENTE_VECINO = "vecino";
    
    public static final String DIR_XML_PAQUETES = "src/proyectormiservidor/XMLPaquetes.xml";
    
    public static final String TAG_PAQUETE = "paquete";
    public static final String TAG_ID_ORIGEN = "origen";
    public static final String TAG_ID_DESTINO = "destino";
    public static final String TAG_TIEMPO = "tiempo";
    public static final String TAG_TIEMPO_ENVIO = "envio";
    public static final String TAG_TIEMPO_RECEPCION = "recepcion";
    public static final String TAG_TIEMPO_CREADO = "creado";
    
    public static final String ERROR_XML_VACIO = "Error cargando XML, archivo vacio";
    public static final String ERROR_XML_CARGANDO = "Error cargando el arhivo XML -  No es posible el procesamiento del archivo";
   
    public static final int PUERTO_SERVIDOR = 15000;
}
