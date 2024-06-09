/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.Block;
import Modelos.BlockDB;
import Modelos.Horario;
import Modelos.Lab;
import Modelos.LabDB;
import Vista.Horarios;
import Vista.Reservas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author William
 */
public class Cont_Horarios implements ActionListener, MouseListener{
    
    private Horarios vista_horarios = new Horarios();
    private Horario horarios = new Horario();
    private LabDB lab = new LabDB();

    public Cont_Horarios(Horarios vista_horarios, Horario horarios, ArrayList<Lab> laboratorios) throws SQLException {
        this.vista_horarios = vista_horarios;
        this.horarios = horarios;
        this.vista_horarios.btnRegresar.addActionListener(this);
        this.vista_horarios.btnReserva.addMouseListener(this);
        this.llenarComboBloques();
        this.vista_horarios.fechaDia.addMouseListener(this);
        LocalDate fechaActual = LocalDate.now();
        Instant instant = fechaActual.atStartOfDay(ZoneId.systemDefault()).toInstant();
        this.vista_horarios.fechaDia.setDate(Date.from(instant));
        LocalDate [] fechaSemana = this.obtenerFechasSemana(fechaActual);
        this.vista_horarios.tablaHorarios.addMouseListener(this);
        this.vista_horarios.comboBloque.setSelectedIndex(-1);
       this.vista_horarios.comboBloque.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int itemSeleccionado = vista_horarios.comboBloque.getSelectedIndex();
                if (itemSeleccionado != -1) {
                    vista_horarios.comboLaboratorio.removeAllItems();
                    borrarTabla();
                    llenarLaboratorios(laboratorios,vista_horarios.comboBloque.getItemAt(itemSeleccionado).getId());
                }
            }
        });
       this.vista_horarios.btnRegresar.addActionListener(this);
         this.vista_horarios.comboLaboratorio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int itemSeleccionado = vista_horarios.comboLaboratorio.getSelectedIndex();
                if (itemSeleccionado != -1) {
                    try {                
                        borrarTabla();
                        ArrayList<Horario> hora = horarios.contultaHorarios(vista_horarios.comboLaboratorio.getItemAt(itemSeleccionado).getId(),fechaSemana[0].toString(),fechaSemana[1].toString());
                        asignarDias(hora);
                    } catch (SQLException ex) {
                        Logger.getLogger(Cont_Horarios.class.getName()).log(Level.SEVERE, null, ex);
                    }  
                }
            }
        });
         
          this.vista_horarios.fechaDia.addPropertyChangeListener("date", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if ("date".equals(evt.getPropertyName())) {
                    Instant instant = vista_horarios.fechaDia.getDate().toInstant();
                    LocalDate localDate1 = instant.atZone(ZoneId.systemDefault()).toLocalDate();
                    vista_horarios.txt_fechas.setText(obtenerFechasSemana(localDate1)[0].toString() + " - " + obtenerFechasSemana(localDate1)[1].toString());
                    LocalDate [] fechaNueva = obtenerFechasSemana(localDate1);
                     int itemSeleccionado = vista_horarios.comboLaboratorio.getSelectedIndex();
                        if (itemSeleccionado != -1) {
                            try {                
                                borrarTabla();
                                ArrayList<Horario> hora = horarios.contultaHorarios(vista_horarios.comboLaboratorio.getItemAt(itemSeleccionado).getId(),fechaNueva[0].toString(),fechaNueva[1].toString());
                                asignarDias(hora);
                            } catch (SQLException ex) {
                                Logger.getLogger(Cont_Horarios.class.getName()).log(Level.SEVERE, null, ex);
                            }  
                        }
                }
            }
        });
         
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
            for (int j = 1; j <= 10; j++) {
                this.vista_horarios.tablaHorarios.setValueAt(null, j, i);
            }
        }
    }
    private void llenarComboBloques(){
        this.vista_horarios.comboBloque.addItem( new Block(1, "Bloque1"));
         this.vista_horarios.comboBloque.addItem( new Block(2, "Bloque2"));
         this.vista_horarios.comboBloque.addItem(new Block(3, "Ciencias Aplicadas" ));
         this.vista_horarios.comboBloque.addItem (new Block(3, " Talleres Tecnológicos"));
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
            switch(hor.getNombre_dia()){
                case "lunes":
                    this.asignarHoras(hor, 1);
                break;
                case "martes":
                    this.asignarHoras(hor, 2);
                break;
                case "miercoles":
                    this.asignarHoras(hor, 3);
                break;
                case "jueves":
                    this.asignarHoras(hor, 4);
                break;
                case "viernes":
                    this.asignarHoras(hor, 5);
                break;
                case "sabado":
                    this.asignarHoras(hor, 6);
                break;
            }
        }
    }
    
    private void asignarHoras(Horario horario, int dia){
            int horaInicio=this.obtenerHoras(horario.getHora_inicio()),horaFin=this.obtenerHoras(horario.getHora_final());
            for (int i = horaInicio; i < horaFin; i++) {
                 this.vista_horarios.tablaHorarios.setValueAt(horario, i-7, dia);
        }
     }
    
     public int obtenerHoras(String hora) {
        // Obtener los primeros dos caracteres y convertirlos a entero
        String hoursString = hora.substring(0, 2);
        return Integer.parseInt(hoursString);
    }
     
     private String armarHoraInicio(int hora){
         hora = hora+7;
         return hora+":00";
     }
     
     private String armarHoraFin(int hora){
         hora = hora+8;
         return hora+":00";
     }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==vista_horarios.btnRegresar) {
            MenuControlador menu = new MenuControlador();
            menu.iniciar();
            this.vista_horarios.dispose();
        }            
    }

    @Override
    public void mouseClicked(MouseEvent e) {
         if (e.getSource()==this.vista_horarios.btnReserva) {
             if (this.vista_horarios.tablaHorarios.getValueAt(this.vista_horarios.tablaHorarios.getSelectedRow(), this.vista_horarios.tablaHorarios.getSelectedColumn()) == null) {
              Instant instant = this.vista_horarios.fechaDia.getDate().toInstant();
             LocalDate localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();
            Horario horario = new Horario();
            Reservas vistReser = new Reservas();
            try {
                ControlReserva contr= new ControlReserva(vistReser, 
                        horario,this.vista_horarios.comboLaboratorio.getItemAt(this.vista_horarios.comboLaboratorio.getSelectedIndex()).getBlockName(),
                        this.vista_horarios.comboLaboratorio.getItemAt(this.vista_horarios.comboLaboratorio.getSelectedIndex()).getName(),
                        localDate.toString(),
                        this.armarHoraInicio(this.vista_horarios.tablaHorarios.getSelectedRow()),
                        this.armarHoraFin(this.vista_horarios.tablaHorarios.getSelectedRow())
                        ,this.vista_horarios.comboLaboratorio.getItemAt(this.vista_horarios.comboLaboratorio.getSelectedIndex()).getId());// Mostrar la ventana de reserva cuando se hace clic en lblReservas
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
    public void mousePressed(MouseEvent e) {
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
