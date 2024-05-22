package Modelos;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;
import java.util.Date;

/**
 *
 * @author ASUS
 */
public class Reserva {

    private String descripcion;
    private String horafin, horaInicio,fechaReserva;
    private int usuario, responsable, laboratorio;
    private Recursos rec = new Recursos();

    public Reserva(String descripcion, String horafin, String horaInicio, String fechaReserva, int usuario, int responsable, int laboratorio) {
        this.descripcion = descripcion;
        this.horafin = horafin;
        this.horaInicio = horaInicio;
        this.fechaReserva = fechaReserva;
        this.usuario = usuario;
        this.responsable = responsable;
        this.laboratorio = laboratorio;
    }

    public Reserva() {
    }

    public int getUsuario() {
        return this.usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public int getResponsable() {
        return this.responsable;
    }

    public void setResponsable(int responsable) {
        this.responsable = responsable;
    }

    public int getLaboratorio() {
        return this.laboratorio;
    }

    public void setLaboratorio(int laboratorio) {
        this.laboratorio = laboratorio;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaReserva() {
        return this.fechaReserva;
    }

    public void setFechaReserva(String fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    

    public String getHorafin() {
        return this.horafin;
    }

    public void setHorafin(String horafin) {
        this.horafin = horafin;
    }

    public String getHoraInicio() {
        return this.horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Recursos getRec() {
        return this.rec;
    }

    public void setRec(Recursos rec) {
        this.rec = rec;
    }


}





//  //GUARDAR CLIENTE-------------------------------------------------------------------------------------------------------------------------------------------------------------------------
