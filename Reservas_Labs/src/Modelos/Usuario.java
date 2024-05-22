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
import Utilidades.Recurso;

/**
 *
 * @author ASUS
 */
public class Usuario {

     private int id_usuario;
    private String nombre_usuario,contraseña,pregunta_seguridad,respuesta;

    public Usuario(int id_usuario, String nombre_usuario, String contraseña, String pregunta_seguridad, String respuesta) {
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.contraseña = contraseña;
        this.pregunta_seguridad = pregunta_seguridad;
        this.respuesta = respuesta;
    }

    public String getPregunta_seguridad() {
        return this.pregunta_seguridad;
    }

    public void setPregunta_seguridad(String pregunta_seguridad) {
        this.pregunta_seguridad = pregunta_seguridad;
    }

    public String getRespuesta() {
        return this.respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
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
    public int getId_usuario() {
        return this.id_usuario;
    }
    public ArrayList<Usuario> DataUsuarios() throws SQLException, ClassNotFoundException{
    ArrayList<Usuario> Usuarios = new ArrayList<>();
    Recurso rec = new Recurso();
    Conexion conexion = new Conexion();    
    Connection con=conexion.Conectar();
     if (con==null) {
             rec.aviso("No tiene conexion RECUERDE cada accion que realize en el programa no se va a guardar");
         }else{
        Statement st = con.createStatement();
        ResultSet rs = null;
        String consulta = "SELECT id_usuario_PK,nombre_usuario,contraseña,respuesta, descripcion_pregunta FROM Usuarios"
                                + " JOIN Preguntas_Seguridad ON Usuarios.ID_pregunta=Preguntas_Seguridad.id_pregunta;";
        rs = st.executeQuery(consulta);
        while (rs.next()) {
            try {
                Usuario user = new Usuario(rs.getInt("id_usuario_PK"),
                                                          rs.getString("nombre_usuario") ,
                                                          rs.getString("contraseña"),
                                                          rs.getString("descripcion_pregunta"),
                                                          rs.getString("respuesta"));
                Usuarios.add(user);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        st.close();
        rs.close();
     }
     return Usuarios;
    }

    public Usuario() {
    }

    public void RegistroUsuarios(String nombre_usuario, String contraseña, int pregunta_seguridad, String respuesta)throws SQLException{
    Conexion conexion = new Conexion();   
    Recurso rec = new Recurso();
    Connection con=conexion.Conectar();
     if (con==null) {
             rec.aviso("No tiene conexion RECUERDE cada accion que realize en el programa no se va a guardar");
     }else{
        Statement st = con.createStatement();
        String consulta = "INSERT INTO Usuarios(nombre_usuario,contraseña,respuesta,id_pregunta)"
                                     + "VALUES('"+nombre_usuario+"','"+contraseña+"','"+respuesta+"',"+pregunta_seguridad+");";
        st.executeUpdate(consulta);
        st.close();
        con.close();
     }

    }

    public ArrayList<PreguntasS> DataPreguntas() throws SQLException{
        ArrayList<PreguntasS> preguntas = new ArrayList<>();
        Conexion conexion = new Conexion();   
        Recurso rec = new Recurso();
        Connection con=conexion.Conectar();
        if (con==null) {
             rec.aviso("No tiene conexion RECUERDE cada accion que realize en el programa no se va a guardar");
        }else{
            Statement st = con.createStatement();
            ResultSet rs = null;
            String consulta = "SELECT * FROM Preguntas_Seguridad;";
            rs = st.executeQuery(consulta);
            while (rs.next()) {
                try {
                    PreguntasS pregunta = new PreguntasS(rs.getInt("id_pregunta"),
                                                          rs.getString("descipcion_pregunta"));
                    preguntas.add(pregunta);
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        st.close();
        rs.close();
     }
        return preguntas;
    }
}
