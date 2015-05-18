/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import rmi.Paquete;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import rmi.Cliente;
import rmi.RMI;
import rmicliente.ConexionRMI;
import rmicliente.RMICliente;
import rmicliente.RMIClienteListener;

/**
 *
 * @author Santiago Bernal
 */
public class ventanaClienteController {
    
    private static JLabel JLabelID;
    private static JLabel JLabelPuerto;
    private static JTextArea JTAMensaje;
    private static JButton JButtonEnviar;
    private static JButton JButtonSalir;
    private static JComboBox CBSurcursales;
    private static JLabel JLID;
    private static JLabel JLPuerto;
    private static Cliente cliente;
    private static Paquete[] paquete = new Paquete[2];
    
    public static void initComponentes (JTextArea JTAMensaje, JButton JButtonEnviar,JButton JButtonSalir, JComboBox CBSucursales, JLabel JLID, JLabel JLPuerto)
    {
        ventanaClienteController.JLabelID = JLabelID;
        ventanaClienteController.JLabelPuerto = JLabelPuerto;
        ventanaClienteController.JTAMensaje = JTAMensaje;
        ventanaClienteController.JButtonEnviar = JButtonEnviar;
        ventanaClienteController.JButtonSalir = JButtonSalir;
        ventanaClienteController.CBSurcursales = CBSucursales;
        ventanaClienteController.JLID = JLID;
        ventanaClienteController.JLPuerto = JLPuerto;
        
        try {
            settearPaquetes();
        
            ventanaClienteController.cliente = new Cliente();
            ConexionRMI con = new ConexionRMI();
            ventanaClienteController.cliente = con.getMyId();
            ventanaClienteController.JLID.setText(ventanaClienteController.cliente.getId());
            ventanaClienteController.JLPuerto.setText(ventanaClienteController.cliente.getPuerto());
            RMIClienteListener RMICL = new RMIClienteListener(Integer.parseInt(ventanaClienteController.cliente.getPuerto()));
            llenarComboSurcursales();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
    }
    
    public static void settearPaquetes(){
        paquete[0].setOrigen(null);
        paquete[0].setDestino(null);
        paquete[0].setMensaje(null);
        paquete[0].setFechaCreacion(null);
        paquete[0].setFechaEnviado(null);
        paquete[0].setFechaRecibido(null);
        paquete[0].setTiempo(0);
        
        paquete[1].setOrigen(null);
        paquete[1].setDestino(null);
        paquete[1].setMensaje(null);
        paquete[1].setFechaCreacion(null);
        paquete[1].setFechaEnviado(null);
        paquete[1].setFechaRecibido(null);
        paquete[1].setTiempo(0);
    }
    
    
    public static void llenarComboSurcursales()
    {
        try{
            Registry reg = LocateRegistry.getRegistry("127.0.0.1", 1099);
            RMI rmi  = (RMI) reg.lookup("server");
            String[] sucursales = rmi.getSucursals();
            String idSucursal = ventanaClienteController.cliente.getId();
            int i=0;
            int j=0;
            while (i <= sucursales.length) {
                if (idSucursal.equals(sucursales[i])){
                    i++;
                    j = j + 6;
                }
                else{
                    ventanaClienteController.CBSurcursales.addItem(sucursales[j]);
                    i++;
                    j = j + 6;
                }
            }
        }
        catch (Exception e){
            System.out.println();
        }
    }
    
    public static void saveMessage(String[] mensaje){
        //DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaCreacion = new Date();
        boolean saved  = false;
        if (JTAMensaje.getText().trim()!=""){
            int i = 0;
            while (i < 2){
                if (paquete[i].getMensaje().isEmpty()){
                    paquete[i].setOrigen(mensaje[0]);
                    paquete[i].setDestino(mensaje[1]);
                    paquete[i].setMensaje(mensaje[2]);
                    paquete[i].setFechaCreacion(fechaCreacion);
                    saved = true;
                }
                i++;
                if (saved == true) break;
            }
        }
        else{
            System.out.println("El campo de mensajes esta vacio");
        }
    }
}
