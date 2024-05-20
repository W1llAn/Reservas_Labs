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
public class bloque {
    private int id_bloque;
    private String nombre_bloque;
    private Recursos rec= new Recursos();
    public bloque() {
    }

    public bloque(int id_bloque, String nombre_bloque) {
        this.id_bloque = id_bloque;
        this.nombre_bloque = nombre_bloque;
    }

    public int getId_bloque() {
        return this.id_bloque;
    }

    public void setId_bloque(int id_bloque) {
        this.id_bloque = id_bloque;
    }

    public String getNombre_bloque() {
        return this.nombre_bloque;
    }

    public void setNombre_bloque(String nombre_bloque) {
        this.nombre_bloque = nombre_bloque;
    }
    @Override
    public String toString(){
    return this.nombre_bloque;
    }
    
    //CONSULTAR bloque -------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public ArrayList<bloque> consultaBloques() throws SQLException, ClassNotFoundException {
        ArrayList<bloque> bloques = new ArrayList<>();
        Conexion conexion = new Conexion();
        Connection con = conexion.Conectar();
        if (con == null) {
            rec.aviso("No tiene conexion RECUERDE cada accion que realize en el programa no se va a guardar");
        } else {
            con = conexion.Conectar();
            Statement st = con.createStatement();
            ResultSet rs = null;
            String consulta = "SELECT * FROM bloques;";
            rs = st.executeQuery(consulta);
            while (rs.next()) {
               bloque blo= new bloque();
               blo.setId_bloque(rs.getInt("id"));
               blo.setNombre_bloque(rs.getString("nombre_bloque"));
               bloques.add(blo);
            }
            st.close();
            rs.close();
        }
        return bloques;
    }

}
