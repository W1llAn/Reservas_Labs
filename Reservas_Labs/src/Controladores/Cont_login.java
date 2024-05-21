/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;
import Modelos.Usuario;
import Utilidades.Recurso;
import Vista.Login;
import Vista.Menu;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author William
 */
public class Cont_login implements ActionListener{
    ArrayList<Usuario> usuario = new ArrayList<>();
    Login vista_login = new Login();
    Recurso rec = new Recurso();
    Usuario user;

    public Cont_login( Login vista_login, Usuario user) throws SQLException {
        this.ingresoImagenes( vista_login);
        this.llenarUsuarios();
        this.vista_login=vista_login;
        this.user=user;
        vista_login.txt_usuario.addActionListener(this);
        vista_login.btn_ingresar.addActionListener(this);
        vista_login.txt_contraseña.addActionListener(this);
        vista_login.btn_salir.addActionListener(this);
    }
    
    private void ingresoImagenes(Login vista_login){
        ImageIcon fondo = new ImageIcon("src\\imagenes\\Fondo.png");
        int ancho=vista_login.panel_fondo.getWidth(), largo = vista_login.panel_fondo.getHeight();
         Image imagenEscalada = fondo.getImage().getScaledInstance(ancho, largo, Image.SCALE_SMOOTH);
         ImageIcon imagenFinal = new ImageIcon(imagenEscalada);
         vista_login.JP_fondo.setIcon(imagenFinal);
         ImageIcon logo = new ImageIcon("src\\imagenes\\LogoUniversidad.png");
        int anchoLogo=vista_login.Lb_logoUta.getWidth(), largoLogo = vista_login.Lb_logoUta.getHeight();
         Image logoEscalada = logo.getImage().getScaledInstance(anchoLogo, largoLogo, Image.SCALE_SMOOTH);
         ImageIcon logoFinal = new ImageIcon(logoEscalada);
         vista_login.Lb_logoUta.setIcon(logoFinal);
    }
    
    private void llenarUsuarios() throws SQLException {
        try {
            this.usuario= new Usuario().DataUsuarios();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Cont_login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private boolean VerificacionCredenciales(String username, String contraseña) throws SQLException{
        for(Usuario user : this.usuario){
            System.out.println(username +"  "+contraseña+"---"+user.getNombre_usuario()+"  "+user.getContraseña());
            if (user.getNombre_usuario().equals(username) && user.getContraseña().equals(contraseña) ) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==vista_login.btn_ingresar) {
            String username = vista_login.txt_usuario.getText(), contraseña = String.valueOf(vista_login.txt_contraseña.getPassword());
            try {
                if (this.VerificacionCredenciales(username, contraseña)) {
                MenuControlador menu = new MenuControlador();
                this.vista_login.dispose();
                menu.iniciar();
                }else{
                    rec.aviso("Nombre de usuario o contraseña incorrecta");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Cont_login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource()==vista_login.btn_salir) {
            vista_login.dispose();
        }
    }
    
}
