/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;
import Controladores.Cont_login;
import Modelos.usuario;
import Vista.Login;
import java.sql.SQLException;

/**
 *
 * @author William
 */
public class Principal {
<<<<<<< HEAD
    public static void main(String[] args) throws SQLException {
        
        try {
                    Login log = new Login();
        Usuario user = new Usuario();
=======
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Login log = new Login();
        usuario user = new usuario();
>>>>>>> 37d9e6845de1ae3d00de708c100c2a35c536a864
        Cont_login controlador = new Cont_login(log, user);
        log.setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
        }
        

    }
}
