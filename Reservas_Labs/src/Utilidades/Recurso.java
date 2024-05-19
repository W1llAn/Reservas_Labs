/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;

import javax.swing.JOptionPane;

/**
 *
 * @author William
 */
public class Recurso {
        public void aviso(String mensaje){
          JOptionPane.showMessageDialog(null, mensaje);
        }    
        public boolean ConfirmarAccion(String mensaje) {
        int opcionSeleccionada = JOptionPane.showConfirmDialog(null, 
                                                              mensaje, 
                                                              "Confirmar acción", 
                                                              JOptionPane.YES_NO_OPTION, 
                                                              JOptionPane.QUESTION_MESSAGE);

        return opcionSeleccionada == JOptionPane.YES_OPTION;
    }
}
