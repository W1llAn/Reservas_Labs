/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.Recursos;
import Modelos.Usuario;
import Utilidades.Recurso;
import Vista.Login;
import Vista.Restablecer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class Contr_RecContra implements ActionListener {

    Restablecer contraVista;
    Usuario user;
    ArrayList<Usuario> usuarios = new ArrayList<>();
    Recurso rec = new Recurso();

    public Contr_RecContra(ArrayList<Usuario> user) {
        contraVista = new Restablecer();
        contraVista.btn_Aceptar.addActionListener(this);
        contraVista.btn_Volver.addActionListener(this);
        usuarios = user;
    }

    public void iniciar() {
        this.contraVista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == contraVista.btn_Volver) {
            try {
                Login log = new Login();
                Usuario user = new Usuario();
                Cont_login controlador = new Cont_login(log, user);
                log.setVisible(true);
                contraVista.dispose();
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(Contr_RecContra.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == contraVista.btn_Aceptar) {
            Seguridad seg = new Seguridad();
            boolean encontrado = false; // Variable para controlar si se ha encontrado el usuario

            for (Usuario user : this.usuarios) {
                System.out.println(user.getCorreo() + "-" + user.getNombre_usuario());

                if (user.getNombre_usuario().equals(this.contraVista.txt_usuario_validar.getText())
                        && user.getCorreo().equals(this.contraVista.txt_correo_validar.getText())) {
                    seg.crearEmail(user.getCorreo(), user.getContraseña());
                    seg.enviarMensaje();
                    this.contraVista.btn_Aceptar.setEnabled(false);
                    encontrado = true; // Se encontró el usuario
                    break; // Detiene el bucle
                }
            }

            if (!encontrado) {
                rec.aviso("El usuario o correo son inválidos. Ingrese nuevamente");
            }
        }

    }

}
