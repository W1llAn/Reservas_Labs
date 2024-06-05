/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author William
 */
public class Horario {
    private String  hora_inicio,hora_final, nombre_dia,materia,nombre_responsable ;
    private LocalDate fecha_dia; 
    private int id_laboratorio;
    private Recursos rec = new Recursos();
    private boolean esReserva;

    public Horario(String hora_inicio, String hora_final, String nombre_dia, String materia, String nombre_responsable, LocalDate fecha_dia, int id_laboratorio, boolean esReserva) {
        this.hora_inicio = hora_inicio;
        this.hora_final = hora_final;
        this.nombre_dia = nombre_dia;
        this.materia = materia;
        this.nombre_responsable = nombre_responsable;
        this.fecha_dia = fecha_dia;
        this.id_laboratorio = id_laboratorio;
        this.esReserva = esReserva;
    }

    public int getId_laboratorio() {
        return this.id_laboratorio;
    }

    public void setId_laboratorio(int id_laboratorio) {
        this.id_laboratorio = id_laboratorio;
    }

  

    public Horario() {
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getNombre_profesor() {
        return nombre_responsable;
    }

    public void setNombre_responsable(String nombre_profesor) {
        this.nombre_responsable = nombre_profesor;
    }
    
    public LocalDate getFecha_dia() {
        return this.fecha_dia;
    }

    public void setFecha_dia(LocalDate fecha_dia) {
        this.fecha_dia = fecha_dia;
    }

    public String getHora_inicio() {
        return this.hora_inicio;
    }

    public void setHora_inicio(String hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public String getHora_final() {
        return this.hora_final;
    }

    public void setHora_final(String hora_final) {
        this.hora_final = hora_final;
    }

    public String getNombre_dia() {
        return this.nombre_dia;
    }

    public void setNombre_dia(String nombre_dia) {
        this.nombre_dia = nombre_dia;
    }

    public boolean isEsReserva() {
        return this.esReserva;
    }

    public void setEsReserva(boolean esReserva) {
        this.esReserva = esReserva;
    }
    
    public ArrayList<Horario> contultaHorarios() throws SQLException{
        ArrayList<Horario> horarios = new ArrayList<>();
        Conexion conexion = new Conexion();
        Connection con = conexion.Conectar();
        if (con == null) {
            rec.aviso("No tiene conexion RECUERDE cada accion que realize en el programa no se va a guardar");
        } else {
            Statement st = con.createStatement();
            ResultSet rs = null;
            String consulta = "SELECT * FROM Horarios";
            rs = st.executeQuery(consulta);
            while (rs.next()) {
                Horario hor = new Horario();
                java.sql.Date fecha = rs.getDate("fecha_dia");
                hor.setFecha_dia(fecha.toLocalDate());
                hor.setEsReserva(rs.getInt("ID_reserva")== 1?true:false);
                hor.setHora_inicio(rs.getString("hora_inicio"));
                hor.setHora_final(rs.getString("hora_final"));
                hor.setId_laboratorio(rs.getInt("ID_laboratorio"));
                hor.setMateria(rs.getString("materia"));
                hor.setNombre_dia(rs.getString("nombre_dia"));
                hor.setNombre_responsable(rs.getString("nombre_responsable"));
                horarios.add(hor);
            }
            st.close();
            rs.close();
        }
        this.asignarHorarios(horarios);
        return horarios;
    }
    public void asignarHorarios(ArrayList<Horario> horarios) throws SQLException{
            for(Horario h: horarios){
                 this.obtenerLaboratorio(h.id_laboratorio).setHorarios(h);
        }
    }
    
    private Lab obtenerLaboratorio(int idLab){
        ArrayList<Block> bloques = UsuarioSesion.getBloques();
        
        for(Block block : bloques){
            for(Lab lab : block.getLaboratorios()){
                if (lab.getId()==idLab) {
                    return lab;
                }
            }
        }
        return null;
    }
}
