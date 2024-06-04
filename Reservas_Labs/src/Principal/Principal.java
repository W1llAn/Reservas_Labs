/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;
import Controladores.Cont_login;
import Modelos.Usuario;
import Vista.Login;
import java.sql.SQLException;

/**
 *
 * @author William
 */
public class Principal {
    public static void main(String[] args) throws SQLException {
        
        try {
                    Login log = new Login();
        Usuario user = new Usuario();
        Cont_login controlador = new Cont_login(log, user);
        log.setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
        }
        

    }
}
