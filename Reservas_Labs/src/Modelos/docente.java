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
public class docente {
    private int id_responsable;
    private String nombre_responsable;
    private Recursos rec= new Recursos();
    public docente(int id_responsable, String nombre_responsable) {
        this.id_responsable = id_responsable;
        this.nombre_responsable = nombre_responsable;
    }

    public docente() {
    }

    public int getId_responsable() {
        return this.id_responsable;
    }

    public void setId_responsable(int id_responsable) {
        this.id_responsable = id_responsable;
    }

    public String getNombre_responsable() {
        return this.nombre_responsable;
    }

    public void setNombre_responsable(String nombre_responsable) {
        this.nombre_responsable = nombre_responsable;
    }
    //CONSULTA DE RESPONSABLES EN LA BASE DE DATOS
     public ArrayList<docente> consultaDocente() throws SQLException, ClassNotFoundException {
        ArrayList<docente> Responsable = new ArrayList<>();
        Conexion conexion = new Conexion();
        Connection con = conexion.Conectar();
        if (con == null) {
            rec.aviso("No tiene conexion RECUERDE cada accion que realize en el programa no se va a guardar");
        } else {
            con = conexion.Conectar();
            Statement st = con.createStatement();
            ResultSet rs = null;
            String consulta = "SELECT * FROM responsables;";
            rs = st.executeQuery(consulta);
            while (rs.next()) {
               docente docent= new docente();
               docent.setId_responsable(rs.getInt("id_responsable"));
               docent.setNombre_responsable(rs.getString("nombre"));
               Responsable.add(docent);
            }
            st.close();
            rs.close();
        }
        return Responsable;
    }
    
    
}
