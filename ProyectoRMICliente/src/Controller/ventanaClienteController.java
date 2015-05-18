/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import rmi.Cliente;
import rmi.Paquete;
import rmicliente.ConexionRMI;
import rmicliente.RMICliente;
import rmicliente.RMIClienteListener;

/**
 *Clase para controlar la ventana de cliente
 * @author Santiago Bernal
 * @author Manuel Pacheco
 */
public class ventanaClienteController {
    
    private static JLabel JLabelID;
    private static JLabel JLabelPuerto;
    private static JTextArea JTAMensaje;
    private static JButton JButtonEnviar;
    private static JButton JButtonSalir;
    private static JComboBox CBSurcursales;
    private static  JButton JButtonSeleccionarVecino;  
    private static Paquete[] paquete = new Paquete[2];
    private static Cliente cliente;
    /**
     * Metodo inicializador de componentes
     * @param JLabelID
     * @param JLabelPuerto
     * @param JTAMensaje
     * @param JButtonEnviar
     * @param JButtonSalir
     * @param CBSucursales 
     */
    public static void initComponentes (JLabel JLabelID, JLabel JLabelPuerto, JTextArea JTAMensaje, JButton JButtonEnviar,JButton JButtonSalir, JComboBox CBSucursales, JButton JButtonSeleccionarVecino)
    {
        ventanaClienteController.JLabelID = JLabelID;
        ventanaClienteController.JLabelPuerto = JLabelPuerto;
        ventanaClienteController.JTAMensaje = JTAMensaje;
        ventanaClienteController.JButtonEnviar = JButtonEnviar;
        ventanaClienteController.JButtonSalir = JButtonSalir;
        ventanaClienteController.CBSurcursales = CBSucursales;
        ventanaClienteController.JButtonSeleccionarVecino = JButtonSeleccionarVecino;
        
        try {
            
        
            ventanaClienteController.cliente = new Cliente();
            ventanaClienteController.cliente = ConexionRMI.getMyId();
            ventanaClienteController.JLabelID.setText("Mi ID: " + ventanaClienteController.cliente.getId());
            ventanaClienteController.JLabelPuerto.setText("Mi puerto: " + ventanaClienteController.cliente.getPuerto());
            llenarComboSurcursales();
            RMIClienteListener RMICL = new RMIClienteListener(Integer.parseInt(ventanaClienteController.cliente.getPuerto()));
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
    }
    /**
     * Metodo para llenar el combobox del cliente
     *@throws Remote Exception
     */
    public static void llenarComboSurcursales()
    {
            List<Cliente> sucursales;
            sucursales = ConexionRMI.buscarInfoCB();
            String idSucursal = ventanaClienteController.cliente.getId();
            for (Cliente clienteEncontrado : sucursales)
            {
                if (!clienteEncontrado.getId().equals(idSucursal))
                {
                    ventanaClienteController.CBSurcursales.addItem(clienteEncontrado.getId());
                   
                }
            }
    }

    /**
     * Metodo para escoger el vecino al que se le mandara los mensajes
     * y colocar el cliente en el anillo
     * 
     */
    public static void clickSeleccionarVecino() {
        CBSurcursales.setEnabled(false);
        ventanaClienteController.JButtonSeleccionarVecino.setEnabled(false);        
        /*
         * El string que me regresa el servidor tendra el siguiente formato:
         * { id vecino derecha, puerto vecino derecha, id vecino izquierda
         *   puerto vecino izquierda}
         */
        String[] vecinos = ConexionRMI.solicitarVecino(CBSurcursales.getSelectedItem().toString(), cliente.getId());
        cliente.setIdVecinoDerecha(vecinos[0]);
        cliente.setIdVecinoIzquierda(vecinos[2]);
        cliente.setPuertoVecinoDerecha(vecinos[1]);
        cliente.setPuertoVecinoIzquierda(vecinos[3]);
        System.out.println("Mi vecino a la derecha: " + 
                cliente.getIdVecinoDerecha() +
                " puerto: " + cliente.getPuertoVecinoDerecha());
        System.out.println("Mi vecino a la izquierda: " + 
                cliente.getIdVecinoIzquierda() + " puerto: "
                + cliente.getPuertoVecinoIzquierda());
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
