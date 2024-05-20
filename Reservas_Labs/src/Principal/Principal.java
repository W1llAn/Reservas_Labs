/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

import Controladores.guardarReserva;
import Modelos.Conexion;
import Modelos.Reserva;
import Vista.Reservas;
import javax.swing.JFrame;

/**
 *
 * @author William
 */
public class Principal {

    public static void main(String[] args) {
        try {
            new Conexion().Conectar();
            Reservas visualDeReserva = new Reservas();
            Reserva mres= new Reserva();
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(930, 600);  // Ajusta el tamaño según necesites
            frame.add(visualDeReserva);  // 'res' es tu JInternalFrame
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
            guardarReserva gr = new guardarReserva(visualDeReserva,mres);
            visualDeReserva.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();  // Esto mostrará el error en la consola
        }

    }
}
