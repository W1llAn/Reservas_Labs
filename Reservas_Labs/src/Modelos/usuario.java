/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class usuario {

    private int id_usuario;
    private String nombre_usuario;
    private Recursos rec = new Recursos();

    public usuario() {
    }

    public usuario(int id_usuario, String nombre_usuario) {
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
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

    //CONSULTAR USUARIO
    public ArrayList<usuario> consultaUsuarios() throws SQLException, ClassNotFoundException {
        ArrayList<usuario> usuarios = new ArrayList<>();
        Conexion conexion = new Conexion();
        Connection con = conexion.Conectar();
        if (con == null) {
            rec.aviso("No tiene conexion RECUERDE cada accion que realize en el programa no se va a guardar");
        } else {
            con = conexion.Conectar();
            Statement st = con.createStatement();
            ResultSet rs = null;
            String consulta = "SELECT * FROM usuario;";
            rs = st.executeQuery(consulta);
            while (rs.next()) {
                usuario user = new usuario();
                user.setId_usuario(rs.getInt("id_usuario_PK"));
                user.setNombre_usuario(rs.getString("nombre_usuario"));
                usuarios.add(user);
            }
            st.close();
            rs.close();
        }
        return usuarios;
    }
}
