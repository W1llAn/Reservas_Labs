/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;
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
    private String  hora_inicio,hora_final, nombre_dia,materia,nombre_responsable,descripcion ;
    private LocalDate fecha_dia; 
    private int id_laboratorio;
    private Recursos rec = new Recursos();
    private boolean esReserva;
    private int id_laboratorio,id_responsable;  

    public Horario(String hora_inicio, String hora_final, String nombre_dia, String materia,String nombre_responsable, LocalDate fecha_dia, int id_laboratorio) {
        this.hora_inicio = hora_inicio;
        this.hora_final = hora_final;
        this.nombre_dia = nombre_dia;
        this.nombre_responsable=nombre_responsable;
        this.materia = materia;
        this.fecha_dia = fecha_dia;
        this.id_laboratorio = id_laboratorio;
    }

    public Horario(String fecha_dia, String hora_inicio, String hora_final, String nombre_dia, String materia, int id_laboratorio, int id_responsable,String descripcion) {
        this.fecha_dia = fecha_dia;
        this.hora_inicio = hora_inicio;
        this.hora_final = hora_final;
        this.nombre_dia = nombre_dia;
        this.materia = materia;
        this.id_laboratorio = id_laboratorio;
        this.id_responsable = id_responsable;
        this.descripcion= descripcion;
    }
    

    public Horario() {
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMateria() {
        return this.materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public int getId_laboratorio() {
        return this.id_laboratorio;
    }

    public void setId_laboratorio(int id_laboratorio) {
        this.id_laboratorio = id_laboratorio;
    }

    public int getId_responsable() {
        return this.id_responsable;
    }

    public void setId_responsable(int id_responsable) {
        this.id_responsable = id_responsable;
    }
    

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getNombre_responsable() {
        return nombre_responsable;
    }

    public void setNombre_responsable(String nombre_responsable) {
        this.nombre_responsable = nombre_responsable;
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

   
      public String decifrarDia(String fecha) {
          // Formato de la fecha de entrada
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Parsear la fecha
        LocalDate fechaLocalDate = LocalDate.parse(fecha, formatter);

        // Obtener el día de la semana
        String diaDeLaSemana = fechaLocalDate.getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("es", "ES"));

       System.out.println("El dia de la fecha:"+fecha.toString()+"es:"+diaDeLaSemana);
        return diaDeLaSemana;
        
    }
      
      private boolean busquedaCedula(String cedula) {
          for (int i = 0; i < Almacen.getInstance().listResponsables.size(); i++) {
              if (Almacen.getInstance().listResponsables.get(i).getCedula().equals(cedula)) {
                  return true;
              }
          }
        return false;
      }
    public ArrayList<Horario> contultaHorarios(int id_laboratorio, String fechaInicio, String fechaFin) throws SQLException{

        ArrayList<Horario> horarios = new ArrayList<>();
        Conexion conexion = new Conexion();
        Connection con = conexion.Conectar();
        if (con == null) {
            rec.aviso("No tiene conexion RECUERDE cada accion que realize en el programa no se va a guardar");
        } else {
            Statement st = con.createStatement();
            ResultSet rs = null;
            String consulta = "SELECT id_horario_PK, ID_laboratorio, fecha_dia,hora_inicio, hora_final, materia, nombre_dia, nombre, apellido FROM Horarios " +
                                        "JOIN responsables ON Horarios.id_responsable = responsables.id_responsable "
                                        + "WHERE id_laboratorio ="+id_laboratorio+" AND fecha_dia BETWEEN '"+fechaInicio+"' AND '"+fechaFin+"' ;";
            rs = st.executeQuery(consulta);
            while (rs.next()) {
                Horario hor = new Horario();
                java.sql.Date fecha = rs.getDate("fecha_dia");
                hor.setFecha_dia(fecha.toLocalDate());
                hor.setHora_inicio(rs.getString("hora_inicio"));
                hor.setHora_final(rs.getString("hora_final"));
                hor.setId_laboratorio(rs.getInt("ID_laboratorio"));
                hor.setMateria(rs.getString("materia"));
                hor.setNombre_dia(rs.getString("nombre_dia"));
                hor.setNombre_responsable(rs.getString("nombre")+" "+rs.getString("apellido"));
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
    @Override
    public String toString() {
        return this.materia + "\n" + this.nombre_responsable;
    }
}
