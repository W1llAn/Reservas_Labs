/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class Recursos {
    public void aviso(String mensaje){
        JOptionPane.showMessageDialog(null,mensaje,"AVISO",JOptionPane.INFORMATION_MESSAGE);
    }
    public void exito(String mensaje) {
        // Cargar el icono personalizado
        ImageIcon iconoExito = new ImageIcon(getClass().getResource("/imagenes/exito-icon.png"));

        // Mostrar el mensaje con el icono personalizado
        JOptionPane.showMessageDialog(null, 
                                      mensaje, 
                                      "Éxito", 
                                      JOptionPane.INFORMATION_MESSAGE, 
                                      iconoExito);
    }
}
