package Modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

public class Usuario_2DB {

    private Conexion con;
    private PreparedStatement ps;
    private ResultSet rs;

    public Usuario_2DB() {
        this.con = new Conexion();
    }

    public boolean crearUsuario(Usuario_2 user) {

        String sql = "INSERT INTO Usuarios (nombre_usuario, contraseña, correo_electronico, rol, nombre, apellido, cedula) VALUES (?,?,?,?,?,?,?)";
        try {
            Connection cn = con.Conectar();
            ps = cn.prepareStatement(sql);
            ps.setString(1, user.getNombreUsuario());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getCorreo());
            ps.setString(4, user.getRol());
            ps.setString(5, user.getNombre());
            ps.setString(6, user.getApellido());
            ps.setString(7, user.getCedula());

            ps.execute();
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;

        }
    }

    public boolean modificarUsuario(Usuario_2 user) {
        
        String sql = "UPDATE Usuarios SET nombre_usuario=?, contraseña=?, correo_electronico=?, rol=?, nombre=?, apellido=?, cedula=? WHERE id_usuario_PK=?";
        try {
            Connection cn = con.Conectar();
            ps = cn.prepareStatement(sql);
            ps.setInt(8, user.getId());
            ps.setString(1, user.getNombreUsuario());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getCorreo());
            ps.setString(4, user.getRol());
            ps.setString(5, user.getNombre());
            ps.setString(6, user.getApellido());
            ps.setString(7, user.getCedula());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return false;
        }
        
    }

    public boolean eliminarUsuario(int id) {
       
    }

    public List listaUsuarios() {
    }

}
