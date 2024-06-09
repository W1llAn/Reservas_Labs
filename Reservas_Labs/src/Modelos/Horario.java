/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

/**
 *
 * @author William
 */
public class Horario {
    private String fecha_dia, hora_inicio,hora_final, nombre_dia,materia,descripcion;
    private boolean esReserva;
    private int id_laboratorio,id_responsable;
    

    public Horario(String fecha_dia, String hora_inicio, String hora_final, String nombre_dia, boolean esReserva) {
        this.fecha_dia = fecha_dia;
        this.hora_inicio = hora_inicio;
        this.hora_final = hora_final;
        this.nombre_dia = nombre_dia;
        this.esReserva = esReserva;
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
    
    

    public String getFecha_dia() {
        return this.fecha_dia;
    }

    public void setFecha_dia(String fecha_dia) {
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
}
