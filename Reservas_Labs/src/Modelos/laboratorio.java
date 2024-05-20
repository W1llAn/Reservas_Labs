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
public class laboratorio {

    private int id_laboratorio;
    private String nombreLaboratorio;
    private Recursos rec= new Recursos();
    public laboratorio() {
    }

    public laboratorio(int id_laboratorio, String nombreLaboratorio) {
        this.id_laboratorio = id_laboratorio;
        this.nombreLaboratorio = nombreLaboratorio;
    }

    public int getId_laboratorio() {
        return this.id_laboratorio;
    }

    public void setId_laboratorio(int id_laboratorio) {
        this.id_laboratorio = id_laboratorio;
    }

    public String getNombreLaboratorio() {
        return this.nombreLaboratorio;
    }

    public void setNombreLaboratorio(String nombreLaboratorio) {
        this.nombreLaboratorio = nombreLaboratorio;
    }
    //CONSULTAR LABORATORIOS -------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    @Override
    public String toString(){
    return this.nombreLaboratorio;
    }
    public ArrayList<laboratorio> consultaLaboratorio(int id_bloque) throws SQLException, ClassNotFoundException {
        ArrayList<laboratorio> laboratorios = new ArrayList<>();
        Conexion conexion = new Conexion();
        Connection con = conexion.Conectar();
        if (con == null) {
            rec.aviso("No tiene conexion RECUERDE cada accion que realize en el programa no se va a guardar");
        } else {
            con = conexion.Conectar();
            Statement st = con.createStatement();
            ResultSet rs = null;
            String consulta = "SELECT * from laboratorios where id_bloque='"+id_bloque+"';";
            rs = st.executeQuery(consulta);
            while (rs.next()) {
                laboratorio labs=  new laboratorio();
                labs.setId_laboratorio(rs.getInt("id_laboratorio"));
                labs.setNombreLaboratorio(rs.getString("nombre_laboratorio"));
                laboratorios.add(labs);
            }
            st.close();
            rs.close();
        }
        return laboratorios;
    }

}
