package Modelos;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.TextStyle;
import java.util.Date;
import java.util.Locale;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

/**
 *
 * @author ASUS
 */
public class Reserva {

    private String descripcion,nombreResponsable;
    private String horafin, horaInicio,fechaReserva;
    private int usuario, responsable, laboratorio;
    private Recursos rec = new Recursos();

    
    
    public String getNombreResponsable() {
        return this.nombreResponsable;
    }

    public void setNombreResponsable(String nombreResponsable) {
        this.nombreResponsable = nombreResponsable;
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


}





//  //GUARDAR CLIENTE-------------------------------------------------------------------------------------------------------------------------------------------------------------------------
