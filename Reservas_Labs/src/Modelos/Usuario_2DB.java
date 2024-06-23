package Modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

        String sql = "INSERT INTO Usuarios (nombre_usuario, contraseña, correo_electronico, rol, nombre, apellido) VALUES (?,?,?,?,?,?)";
        try {
            Connection cn = con.Conectar();
            ps = cn.prepareStatement(sql);
            ps.setString(1, user.getNombreUsuario());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getCorreo());
            ps.setString(4, user.getRol());
            ps.setString(5, user.getNombre());
            ps.setString(6, user.getApellido());

            ps.execute();
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;

        }
    }

    public boolean modificarUsuario(Usuario_2 user) {

        String sql = "UPDATE Usuarios SET nombre_usuario=?, contraseña=?, correo_electronico=?, rol=?, nombre=?, apellido=? WHERE id_usuario_PK=?";
        try {
            Connection cn = con.Conectar();
            ps = cn.prepareStatement(sql);
            ps.setInt(7, user.getId());
            ps.setString(1, user.getNombreUsuario());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getCorreo());
            ps.setString(4, user.getRol());
            ps.setString(5, user.getNombre());
            ps.setString(6, user.getApellido());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return false;
        }

    }

    public boolean eliminarUsuario(int id) {

        String sql = "DELETE FROM Usuarios WHERE id_usuario_PK=?";
        try {
            Connection cn = con.Conectar();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }

    public List listaUsuarios() {

        List<Usuario_2> listaUsuarios = new ArrayList();
        String sql = "SELECT * FROM Usuarios";

        try {
            Connection cn = con.Conectar();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuario_2 user = new Usuario_2();
                user.setId(rs.getInt("id_usuario_PK"));
                user.setNombreUsuario(rs.getString("nombre_usuario"));
                user.setPassword(rs.getString("contraseña"));
                user.setCorreo(rs.getString("correo_electronico"));
                user.setNombre(rs.getString("nombre"));
                user.setRol(rs.getString("rol"));
                user.setApellido(rs.getString("apellido"));

                listaUsuarios.add(user);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        return listaUsuarios;
    }

    public List<Usuario_2> buscarUsuariosPor(String filtro, String coincidencia) {
        List<Usuario_2> listaUsuarios = new ArrayList<>();
        String sql = "SELECT * FROM Usuarios WHERE " + filtro + " LIKE ?";

        try ( Connection cn = con.Conectar();  PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, "%" + coincidencia + "%");

            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Usuario_2 user = new Usuario_2();
                    user.setId(rs.getInt("id_usuario_PK"));
                    user.setNombreUsuario(rs.getString("nombre_usuario"));
                    user.setPassword(rs.getString("contraseña"));
                    user.setCorreo(rs.getString("correo_electronico"));
                    user.setNombre(rs.getString("nombre"));
                    user.setRol(rs.getString("rol"));
                    user.setApellido(rs.getString("apellido"));
                    listaUsuarios.add(user);
                }
            }
        } catch (SQLException e) {
            // Considera usar un logger en lugar de System.out.println
            System.err.println("Error al buscar usuarios: " + e.getMessage());
            // Considera lanzar una excepción personalizada aquí
        }

        return listaUsuarios;
    }

}
