/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Utilidades.Recurso;
import java.sql.SQLException;

/**
 *
 * @author William
 */
public class Usuario {
    private int id_usuario;
    private String nombre_usuario,contraseña;

    public Usuario(int id_usuario, String nombre_usuario, String contraseña) {
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.contraseña = contraseña;
    }

    public int getId_usuario() {
        return this.id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_usuario() {
        return this.nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getContraseña() {
        return this.contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    public ArrayList<Usuario> DataUsuarios () throws SQLException{
    ArrayList<Usuario> usuario= new ArrayList<>();
    Conexion conexion = new Conexion();   
    Recurso rec = new Recurso();
    Connection con=conexion.Conectar();
     if (con==null) {
             rec.aviso("No tiene conexion RECUERDE cada accion que realize en el programa no se va a guardar");
     }else{
        Statement st = con.createStatement();
        ResultSet rs = null;
        String consulta = "SELECT usuario.*,permisos.* FROM usuario JOIN permisos ON usuario.permisosID=permisos.id_user;";
        rs = st.executeQuery(consulta);
        while (rs.next()) {
            try {
                Usuario user = new Usuario(rs.getInt("id_usuario"),
                                                          rs.getString("nombre_usuario") ,
                                                          rs.getString("contraseña"));
                usuario.add(user);
            } catch (Exception ex) {
                Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        st.close();
        rs.close();}
    return usuario;
    }
    
}
