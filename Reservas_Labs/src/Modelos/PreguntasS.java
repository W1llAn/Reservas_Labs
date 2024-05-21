/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import Utilidades.Recurso;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author William
 */
class PreguntasS {
    private int id_pregunta;
    private String descripcion;

    public PreguntasS(int id_pregunta, String descripcion) {
        this.id_pregunta = id_pregunta;
        this.descripcion = descripcion;
    }

    public int getId_pregunta() {
        return this.id_pregunta;
    }

    public void setId_pregunta(int id_pregunta) {
        this.id_pregunta = id_pregunta;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
                    Logger.getLogger(PreguntasS.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        st.close();
        rs.close();
     }
        return preguntas;
    }
    
}
