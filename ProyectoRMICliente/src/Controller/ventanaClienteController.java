/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
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
    private static Cliente cliente;
    
    public static void initComponentes (JLabel JLabelID, JLabel JLabelPuerto, JTextArea JTAMensaje, JButton JButtonEnviar,JButton JButtonSalir, JComboBox CBSucursales)
    {
        ventanaClienteController.JLabelID = JLabelID;
        ventanaClienteController.JLabelPuerto = JLabelPuerto;
        ventanaClienteController.JTAMensaje = JTAMensaje;
        ventanaClienteController.JButtonEnviar = JButtonEnviar;
        ventanaClienteController.JButtonSalir = JButtonSalir;
        ventanaClienteController.CBSurcursales = CBSucursales;
        
        try {
            
        
            ventanaClienteController.cliente = new Cliente();
            ConexionRMI con = new ConexionRMI();
            ventanaClienteController.cliente = con.getMyId();
            System.out.println("1");
            ventanaClienteController.JLabelID.setText("Mi ID:" + ventanaClienteController.cliente.getId());
            System.out.println("2");
            ventanaClienteController.JLabelPuerto.setText("Mi puerto" + ventanaClienteController.cliente.getPuerto());
            System.out.println("3");
            RMIClienteListener RMICL = new RMIClienteListener(Integer.parseInt(ventanaClienteController.cliente.getPuerto()));
            System.out.println("4");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
    }
    
    
    
    public static void llenarComboSurcursales()
    {
        throw new NoSuchMethodError();
        /*try {
            Registry reg = LocateRegistry.getRegistry("127.0.0.1", 1099);
            RMI rmi  = (RMI) reg.lookup("server");
            String[] sucursales = rmi.getSucursals();
            String idSucursal = RMICliente.getId();
            for (int i=0;i<=sucursales.length;i++){
                if (idSucursal.equals(sucursales[i])){
                    //No hace nada
                }
                else{
                    ventanaClienteController.CBSurcursales.addItem(sucursales[i]);
                }
                
            }
        }
        catch (Exception e){
            System.out.println();
        }*/
    }
}
