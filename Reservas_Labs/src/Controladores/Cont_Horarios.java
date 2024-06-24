/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.Block;
import Modelos.Festivo;
import Modelos.FestivosDB;
import Modelos.Horario;
import Modelos.Lab;
import Modelos.LabDB;
import Utilidades.Recurso;
import Vista.Festivos;
import Vista.Horarios;
import Vista.Login;
import Vista.Reservas;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author William
 */
public class Cont_Horarios implements ActionListener, MouseListener{
    
    private Horarios vista_horarios = new Horarios();
    private Horario horarios = new Horario();
    private LabDB lab = new LabDB();
    private Recurso rec = new Recurso();
    private int semana=8;
    

    public Cont_Horarios(Horarios vista_horarios, Horario horarios, ArrayList<Lab> laboratorios, LocalDate diaP, int idBlock, int idLab, boolean Reserv) throws SQLException {
        this.vista_horarios = vista_horarios;
        this.horarios = horarios;
        this.vista_horarios.btnRegresar.addActionListener(this);
        this.vista_horarios.jitmReserva.addActionListener(this);
        this.vista_horarios.btnSiguienteS.addActionListener(this);
        this.vista_horarios.btnAnteriorS.addActionListener(this);
        this.vista_horarios.fechaDia.setEnabled(false);        
        this.vista_horarios.fechaDia.addMouseListener(this);
        this.vista_horarios.txt_semana.setText("Semana ");
        this.vista_horarios.fechaDia.addMouseListener(this);
        this.ingresoImagenes();
        Instant instant = diaP.atStartOfDay(ZoneId.systemDefault()).toInstant();
         LocalDate localDate1 = instant.atZone(ZoneId.systemDefault()).toLocalDate();
         vista_horarios.txt_fechas.setText(obtenerFechasSemana(localDate1)[0].toString() + " - " + obtenerFechasSemana(localDate1)[1].toString());
        this.vista_horarios.fechaDia.setDate(Date.from(instant));
        this.vista_horarios.tablaHorarios.addMouseListener(this);
        this.vista_horarios.btnRegresar.addActionListener(this);
       this.vista_horarios.comboBloque.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int itemSeleccionado = vista_horarios.comboBloque.getSelectedIndex();
                    vista_horarios.comboLaboratorio.removeAllItems();
                    borrarTabla();
                    llenarLaboratorios(laboratorios,vista_horarios.comboBloque.getItemAt(itemSeleccionado).getId());
            }
        });
       
         this.vista_horarios.comboLaboratorio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (vista_horarios.comboLaboratorio.getSelectedIndex() >=0) {
                    consultaHorarios();
                }       
            }
        });
         System.out.println(idBlock+"  "+idLab);  
        if (Reserv) {
                this.llenarComboBloques();
                 this.vista_horarios.comboBloque.setSelectedIndex(idBlock);
                  llenarLaboratorios(laboratorios,vista_horarios.comboBloque.getItemAt(idBlock).getId());
                  this.vista_horarios.comboLaboratorio.setSelectedIndex(idLab);
                  this.consultaHorarios();
             }else{
                this.llenarComboBloques();
                this.vista_horarios.comboBloque.setSelectedIndex(0);
                this.llenarLaboratorios(laboratorios,vista_horarios.comboBloque.getItemAt(this.vista_horarios.comboBloque.getSelectedIndex()).getId());
                this.vista_horarios.comboLaboratorio.setSelectedIndex(0);
                this.consultaHorarios();
             }    
          
        }
    private void ingresoImagenes(){
        ImageIcon fondo = new ImageIcon("src\\imagenes\\FondoN.png");
        int ancho=this.vista_horarios.lblFondo.getWidth(), largo = this.vista_horarios.lblFondo.getHeight();
         Image imagenEscalada = fondo.getImage().getScaledInstance(ancho, largo, Image.SCALE_SMOOTH);
         ImageIcon imagenFinal = new ImageIcon(imagenEscalada);
         this.vista_horarios.lblFondo.setIcon(imagenFinal);
         ImageIcon btnS = new ImageIcon("src\\iconos\\flechaDerecha.png");
         int anchoBtnS=this.vista_horarios.btnSiguienteS.getWidth(), largoBtnS = this.vista_horarios.btnSiguienteS.getHeight();
         Image btnSEscalada = btnS.getImage().getScaledInstance(anchoBtnS, largoBtnS, Image.SCALE_SMOOTH);
         ImageIcon btnSFinal = new ImageIcon(btnSEscalada);
         this.vista_horarios.btnSiguienteS.setIcon(btnSFinal);
         ImageIcon logo = new ImageIcon("src\\iconos\\flechaIzquierda.png");
         int anchoLogo=this.vista_horarios.btnAnteriorS.getWidth(), largoLogo = this.vista_horarios.btnAnteriorS.getHeight();
         Image btnA = logo.getImage().getScaledInstance(anchoLogo, largoLogo, Image.SCALE_SMOOTH);
         ImageIcon btnAFinal = new ImageIcon(btnA);
         this.vista_horarios.btnAnteriorS.setIcon(btnAFinal);
         int anchoBtnR=this.vista_horarios.btnRegresar.getWidth(), largoBtnR = this.vista_horarios.btnRegresar.getHeight();
         Image btnREscalada = logo.getImage().getScaledInstance(anchoBtnR, largoBtnR, Image.SCALE_SMOOTH);
         ImageIcon btnRFinal = new ImageIcon(btnREscalada);
         this.vista_horarios.btnRegresar.setIcon(btnRFinal);
    }
    
    private void llenarLaboratorios(ArrayList<Lab> laboratorios,int codigo){
        for (int i = 0; i < laboratorios.size(); i++) {
            if (laboratorios.get(i).getIdBlock()==codigo) {
                this.vista_horarios.comboLaboratorio.addItem(laboratorios.get(i));
            }
        }
    }
    
    private void borrarTabla(){
        for (int i = 1; i <= 6; i++) {
            for (int j = 0; j <= 11; j++) {
                this.vista_horarios.tablaHorarios.setValueAt(null, j, i);
            }
        }
    }
    
    public static boolean comprarIntervalo(LocalDate fechaAComparar, LocalDate fechaInicio, LocalDate fechaFin) {
        return (fechaAComparar.isEqual(fechaInicio) || fechaAComparar.isAfter(fechaInicio)) &&
               (fechaAComparar.isEqual(fechaFin) || fechaAComparar.isBefore(fechaFin));
    }
    
    private void asignarDiaFestivo(ArrayList<Festivo> dias, LocalDate[] fechas){
        for (Festivo dia: dias) {
            LocalDate fechaInicio = LocalDate.parse(dia.getFechaInicio());
            LocalDate fechaFin = LocalDate.parse(dia.getFechaFin());
             boolean fechaInicioIntervalo = comprarIntervalo(fechaInicio, fechas[0],  fechas[1]);
             boolean fechaFinIntervalo = comprarIntervalo(fechaFin, fechas[0],  fechas[1]);
            if (fechaInicioIntervalo && !fechaFinIntervalo) {
                for (int i = fechaInicio.getDayOfWeek().getValue(); i <=6; i++) {
                    for (int j = 0; j <= 11; j++) {
                        this.vista_horarios.tablaHorarios.setValueAt(dia, j, i);
                    }
                }
                break;
            }
            if (fechaInicioIntervalo && fechaFinIntervalo) {
                for (int i = fechaInicio.getDayOfWeek().getValue(); i <=fechaFin.getDayOfWeek().getValue(); i++) {
                    for (int j = 0; j <= 11; j++) {
                        this.vista_horarios.tablaHorarios.setValueAt(dia, j, i);
                    }
                }
                break;
            }
            if (!fechaInicioIntervalo && fechaFinIntervalo) {
                for (int i = 1; i <=fechaFin.getDayOfWeek().getValue(); i++) {
                    for (int j = 0; j <= 11; j++) {
                        this.vista_horarios.tablaHorarios.setValueAt(dia, j, i);
                    }
                }
            }
            break;
        }
    }
    private void llenarComboBloques(){
        this.vista_horarios.comboBloque.addItem( new Block(1, "Bloque1"));
         this.vista_horarios.comboBloque.addItem( new Block(2, "Bloque2"));
         this.vista_horarios.comboBloque.addItem(new Block(3, "Ciencias Aplicadas" ));
         this.vista_horarios.comboBloque.addItem (new Block(4, " Talleres Tecnológicos"));
    }
    
    private LocalDate[] obtenerFechasSemana(LocalDate fecha) {
        // Obtener el día de la semana para la fecha proporcionada
        DayOfWeek diaDeLaSemana = fecha.getDayOfWeek();

        // Calcular la diferencia de días hasta el lunes (inicio de la semana)
        int diasHastaLunes = diaDeLaSemana.getValue() - DayOfWeek.MONDAY.getValue();
        LocalDate inicioDeSemana = fecha.minusDays(diasHastaLunes);

        // Calcular la diferencia de días hasta el sábado
        int diasHastaSabado = DayOfWeek.SATURDAY.getValue() - diaDeLaSemana.getValue();
        LocalDate finDeSemana = fecha.plusDays(diasHastaSabado);

        // Devolver un arreglo con las dos fechas
        return new LocalDate[]{inicioDeSemana, finDeSemana};
    }
    
    private void asignarDias (ArrayList<Horario> horarios){
        for (Horario hor: horarios) {
            System.out.println(hor.getMateria()+" "+hor.getNombre_responsable());
            switch(hor.getNombre_dia()){
                case "lunes":
                    this.asignarHoras(hor, 1);
                break;
                case "martes":
                    this.asignarHoras(hor, 2);
                break;
                case "miércoles":
                    this.asignarHoras(hor, 3);
                break;
                case "jueves":
                    this.asignarHoras(hor, 4);
                break;
                case "viernes":
                    this.asignarHoras(hor, 5);
                break;
                case "sábado":
                    this.asignarHoras(hor, 6);
                break;
            }
        }
    }
    private boolean ControlesReserva(){
        
       if (this.vista_horarios.tablaHorarios.getSelectedRow()==-1) {
            this.rec.aviso("Seleccione la hora que quiere reservar");
            return false;
        }
        
        if (this.vista_horarios.tablaHorarios.getValueAt(this.vista_horarios.tablaHorarios.getSelectedRow(), this.vista_horarios.tablaHorarios.getSelectedColumn()) != null) {
            this.rec.aviso("El laboratorio a esa hora se encuntra ocupado");
            return false;
        }
        if (this.vista_horarios.comboBloque.getSelectedIndex()==-1 || this.vista_horarios.comboLaboratorio.getSelectedIndex()==-1) {
            this.rec.aviso("Debe seleccionar un Laboratorio");
            return false;
        }
        LocalDate localDate = this.vista_horarios.fechaDia.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE", new Locale("es", "ES"));
        String DiaF = localDate.format(formatter);
        if (DiaF.toLowerCase().equals("domingo")) {
            this.rec.aviso("No puede reservar en día domingo");
            return false;
        }
        
        
    return true;
    }
    
    private void asignarHoras(Horario horario, int dia){
            int horaInicio=this.obtenerHoras(horario.getHora_inicio()),horaFin=this.obtenerHoras(horario.getHora_final());
            for (int i = horaInicio; i < horaFin; i++) {
                if (horaInicio<=12) {
                    this.vista_horarios.tablaHorarios.setValueAt(horario, i-7, dia);   
                }else{
                    this.vista_horarios.tablaHorarios.setValueAt(horario, i-8, dia);
                }
                 
        }
     }
    
    public  boolean reservaFutura(int hour, int minute, LocalDate date) {
        // Obtener la fecha y hora actuales
        LocalDateTime now = LocalDateTime.now();

        // Combinar la fecha proporcionada con la hora y minuto
        LocalDateTime dateTimeToCompare = LocalDateTime.of(date, LocalTime.of(hour, minute));

        // Comparar la fecha y hora combinadas con la fecha y hora actuales
        return dateTimeToCompare.isAfter(now);
    }
    
     public int obtenerHoras(String hora) {
        // Obtener los primeros dos caracteres y convertirlos a entero
        String hoursString = hora.substring(0, 2);
        return Integer.parseInt(hoursString);
    }
     
     private String armarHoraInicio(int hora){
         if (hora<=5) {
            hora = hora+7;
         }else{
             hora = hora+8;
         }
         return hora+":00";
     }
     
     private String armarHoraFin(int hora){
         if (hora<=5) {
             hora = hora+8;
         }else{
             hora=hora+9;
         }
         return hora+":00";
     }
     
     // Método para obtener la fecha del mismo día en la semana siguiente
    private Date semanaSiguiente(Date date) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.WEEK_OF_YEAR, 1);
            this.semana++;
            return calendar.getTime();
    }

    // Método para obtener la fecha del mismo día en la semana anterior
    private Date semanaAnterior(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.WEEK_OF_YEAR, -1);
        this.semana--;
        return calendar.getTime();
    }
    
    private void consultaHorarios(){
        int itemSeleccionado = vista_horarios.comboLaboratorio.getSelectedIndex();
        System.out.println(itemSeleccionado);
                    try {                
                        borrarTabla();
                         Instant instant = vista_horarios.fechaDia.getDate().toInstant();
                         LocalDate localDate1 = instant.atZone(ZoneId.systemDefault()).toLocalDate();
                         LocalDate [] fechas = obtenerFechasSemana(localDate1);
                         System.out.println("intervalo de fechas" + fechas[0]+ " "+fechas[1]);
                         ArrayList<Festivo> diasFestivos = null;
                         diasFestivos = new FestivosDB().listaFestivosSemana(fechas[0].toString(), fechas[1].toString());
                        ArrayList<Horario> hora = null;
                        hora = horarios.contultaHorarios(vista_horarios.comboLaboratorio.getItemAt(itemSeleccionado).getId(),fechas[0].toString(),fechas[1].toString());
                        System.out.println("Horarios en el controlador "+hora.size());    
                        asignarDias(hora);
                        asignarDiaFestivo(diasFestivos, fechas);
                    } catch (SQLException ex) {
                        Logger.getLogger(Cont_Horarios.class.getName()).log(Level.SEVERE, null, ex);
                    }  
    }
     // Método para convertir Date a LocalDate
    private LocalDate convertDateToLocalDate(Date date) {
        return date.toInstant()
                   .atZone(ZoneId.systemDefault())
                   .toLocalDate();
    }

    // Método para convertir LocalDate a Date
    private Date convertLocalDateToDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
    
    private Date fechaDiaT(Date date, int daysToAdd) {
        LocalDate localDate = this.convertDateToLocalDate(date);
        
        // Obtener el lunes de la semana que contiene la fecha
        LocalDate monday = localDate.with(DayOfWeek.MONDAY);
        
        // Sumar los días especificados al lunes
        LocalDate modifiedDate = monday.plusDays(daysToAdd);
        
        // Convertir de vuelta a Date
        return this.convertLocalDateToDate(modifiedDate);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==vista_horarios.btnRegresar) {
            MenuControlador menu = new MenuControlador();
            menu.iniciar();
            this.vista_horarios.dispose();
        }            
        if (e.getSource() == this.vista_horarios.btnAnteriorS) {
            if (semana>=1) {
                this.vista_horarios.fechaDia.setDate(this.semanaAnterior(this.vista_horarios.fechaDia.getDate()));
                this.borrarTabla();
                this.consultaHorarios();
               this.vista_horarios.txt_semana.setText("Semana " + semana);
            }
        }
        
        if (e.getSource() == this.vista_horarios.btnSiguienteS) {
            if (semana<8) {
                  this.vista_horarios.fechaDia.setDate(this.semanaSiguiente(this.vista_horarios.fechaDia.getDate()));
                  this.borrarTabla();
                 this.consultaHorarios();
                 this.vista_horarios.txt_semana.setText("Semana " + semana);
            }
        }
        
        if (e.getSource() == this.vista_horarios.jitmReserva) {
            if (this.ControlesReserva()) {               
              Instant instant = this.vista_horarios.fechaDia.getDate().toInstant();
             LocalDate localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();
            Horario horario = new Horario();
            Reservas vistReser = new Reservas();
            int hora = this.vista_horarios.tablaHorarios.getSelectedRow()<=5 ?this.vista_horarios.tablaHorarios.getSelectedRow()+8:this.vista_horarios.tablaHorarios.getSelectedRow()+9;
            if (!(this.reservaFutura(hora, 0,localDate))) {
                    rec.mensajeError("No puede reservar en una fecha pasada");
                     return;
            }
            try {
                ControlReserva contr= new ControlReserva(vistReser, 
                        horario,this.vista_horarios.comboLaboratorio.getItemAt(this.vista_horarios.comboLaboratorio.getSelectedIndex()).getBlockName(),
                        this.vista_horarios.comboLaboratorio.getItemAt(this.vista_horarios.comboLaboratorio.getSelectedIndex()).getName(),
                        localDate.toString(),
                        this.armarHoraInicio(this.vista_horarios.tablaHorarios.getSelectedRow()),
                        this.armarHoraFin(this.vista_horarios.tablaHorarios.getSelectedRow())
                        ,this.vista_horarios.comboBloque.getSelectedIndex()
                        , this.vista_horarios.comboLaboratorio.getItemAt(this.vista_horarios.comboLaboratorio.getSelectedIndex()).getId()
                        , this.vista_horarios.comboLaboratorio.getSelectedIndex());// Mostrar la ventana de reserva cuando se hace clic en lblReservas
                vistReser.setVisible(true);
            } catch (SQLException ex) {
                System.out.println("es en inicar reserva");
            } catch (ClassNotFoundException ex) {
                System.out.println("es en inicar reserva");
            }
            this.vista_horarios.dispose();
            
        }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        /* if (e.getSource()==this.vista_horarios.btnReserva) {
            
            }   */
        }           

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == this.vista_horarios.tablaHorarios) {
             int col = this.vista_horarios.tablaHorarios.getSelectedColumn();
            this.vista_horarios.fechaDia.setDate(this.fechaDiaT(this.vista_horarios.fechaDia.getDate(), col-1));
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    

    
}
