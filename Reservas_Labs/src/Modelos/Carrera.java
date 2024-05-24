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
public class Carrera {
    private String nombre_carrera;
    private int id_carrera;
    private Recursos rec;

    public Carrera() {
    }

    public Carrera(String nombre_carrera, int id_carrera) {
        this.nombre_carrera = nombre_carrera;
        this.id_carrera = id_carrera;
    }

    public String getNombre_carrera() {
        return this.nombre_carrera;
    }

    public void setNombre_carrera(String nombre_carrera) {
        this.nombre_carrera = nombre_carrera;
    }

    public int getId_carrera() {
        return this.id_carrera;
    }

    public void setId_carrera(int id_carrera) {
        this.id_carrera = id_carrera;
    }
    
    @Override
    public String toString(){
    return this.nombre_carrera;
    }
    //CONSULTA DE CARRERAS EN LA BASE DE DATOS
     public ArrayList<Carrera> consultaCarrera() throws SQLException, ClassNotFoundException {
        ArrayList<Carrera> carreras = new ArrayList<>();
        Conexion conexion = new Conexion();
        Connection con = conexion.Conectar();
        if (con == null) {
            rec.aviso("No tiene conexion RECUERDE cada accion que realize en el programa no se va a guardar");
        } else {
            con = conexion.Conectar();
            Statement st = con.createStatement();
            ResultSet rs = null;
            String consulta = "SELECT * FROM carreras;";
            rs = st.executeQuery(consulta);
            while (rs.next()) {
               Carrera carrera= new Carrera();
               carrera.setId_carrera(rs.getInt("id_carrera"));
               carrera.setNombre_carrera(rs.getString("nombre"));
               carreras.add(carrera);
            }
            st.close();
            rs.close();
        }
        return carreras;
    }
    
}
