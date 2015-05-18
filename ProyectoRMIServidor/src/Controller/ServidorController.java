/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.List;
import javax.swing.JButton;
import javax.swing.JTextArea;
import proyectormiservidor.XMLClientes;
import rmi.Cliente;

/**
 *
 * @author Santiago Bernal
 */
public class ServidorController {
    
    private static JButton JBAnillo;
    private static JButton JBPaquetes;
    private static JTextArea JTAInformacion;
    
    public static void initComponents(JButton JBAnillo, JButton JBPaquetes, JTextArea JTAInformacion) {
            ServidorController.JBAnillo = JBAnillo;
            ServidorController.JBPaquetes = JBPaquetes;
            ServidorController.JTAInformacion = JTAInformacion;
            ServidorController.JTAInformacion.setEnabled(false);
            ServidorController.JBPaquetes.setEnabled(false);
    }

    public static void clickMostrarPaquetes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void clickMostrarAnillo() {
        List<Cliente> listaCliente = XMLClientes.leerClientesDeXML();
        int i = 0;
        String informacion = "Estado actual: \n";
        for (Cliente cliente : listaCliente)
        {
            i++;
            informacion = informacion + cliente.getId() + " -> " + cliente.getIdVecinoDerecha() + "\n";
        }
        informacion = informacion + "Cantidad de clientes: " + String.valueOf(i);
        JTAInformacion.setText(informacion);
    }

    
    
}
