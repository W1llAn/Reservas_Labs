/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author William
 */
public class Horario {
    private String fecha_dia, hora_inicio,hora_final, nombre_dia ;
    private boolean esReserva;

    public Horario(String fecha_dia, String hora_inicio, String hora_final, String nombre_dia, boolean esReserva) {
        this.fecha_dia = fecha_dia;
        this.hora_inicio = hora_inicio;
        this.hora_final = hora_final;
        this.nombre_dia = nombre_dia;
        this.esReserva = esReserva;
    }

    public Horario() {
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
    
    
}
