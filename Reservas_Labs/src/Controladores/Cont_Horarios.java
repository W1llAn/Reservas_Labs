/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.Block;
import Modelos.Horario;
import Modelos.Lab;
import Modelos.UsuarioSesion;
import Vista.Horarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author William
 */
public class Cont_Horarios implements ActionListener{
    
    private Horarios vista_horarios = new Horarios();
    private Horario horarios = new Horario();

    public Cont_Horarios(Horarios vista_horarios, Horario horarios) throws SQLException {
        this.vista_horarios = vista_horarios;
        this.horarios = horarios;
        this.vista_horarios.btnRegresar.addActionListener(this);
        this.vista_horarios.btnReserva.addActionListener(this);
        this.llenarComboBloques();
        this.generarTabla();
        this.vista_horarios.comboBloque.setSelectedIndex(-1);
       this.vista_horarios.comboBloque.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int itemSeleccionado = vista_horarios.comboBloque.getSelectedIndex();
                if (itemSeleccionado != -1) {
                    vista_horarios.comboLaboratorio.removeAllItems();
                    llenarLaboratorios(vista_horarios.comboBloque.getItemAt(itemSeleccionado).getId());
                }
            }
        });
         this.vista_horarios.comboLaboratorio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int itemSeleccionado = vista_horarios.comboLaboratorio.getSelectedIndex();
                if (itemSeleccionado != -1) {
                    llenarTabla(vista_horarios.comboLaboratorio.getItemAt(itemSeleccionado));
                }
            }
        });
         
        }
    
    private void llenarLaboratorios(int codigo){
        ArrayList<Lab> laboratorios = new ArrayList<>();
        laboratorios=UsuarioSesion.getBloques().get(codigo-1).getLaboratorios();
        for (int i = 0; i < laboratorios.size(); i++) {
            this.vista_horarios.comboLaboratorio.addItem(laboratorios.get(i));
        }
    }
    private void llenarComboBloques(){
        ArrayList<Block> bloques = new ArrayList<>();
        bloques=UsuarioSesion.getBloques();
        for (int i = 0; i < bloques.size(); i++) {
            this.vista_horarios.comboBloque.addItem(bloques.get(i));
           System.out.println(bloques.get(i).getName()+" "+bloques.get(i).getLaboratorios().size());
        }
    }
    
    private void generarTabla(){
        String []  titulos = {"" ,"Lunes","Martes","Miercoles", "Jueves", "Viernes","Sabado"};
        String [] [] horarios ={ 
            {"07:00-08:00" ,"  ","  ","  ", "  ", "  "},
            {"08:00-09:00" ,"  ","  ","  ", "  ", "  "},
            {"09:00-10:00" ,"  ","  ","  ", "  ", "  "},
            {"10:00-11:00" ,"  ","  ","  ", "  ", "  "},
            {"11:00-12:00" ,"  ","  ","  ", "  ", "  "},
            {"12:00-13:00"," " ," "," "},
            {"13:00-14:00" ,"  ","  ","ALMUERZO  ", "  ", "  "},
            {"14:00-15:00" ,"  ","  ","  ", "  ", "  "},
            {"15:00-16:00" ,"  ","  ","  ", "  ", "  "},
            {"16:00-17:00" ,"  ","  ","  ", "  ", "  "},
            {"17:00-18:00" ,"  ","  ","  ", "  ", "  "},
            {"18:00-19:00" ,"  ","  ","  ", "  ", "  "},
            {"19:00-20:00" ,"  ","  ","  ", "  ", "  "},
        };
        DefaultTableModel tablaH = new DefaultTableModel(horarios,titulos);
        vista_horarios.tablaHorarios.setModel(tablaH);
    }
    
    private void llenarTabla(Lab laboratorio){
        DefaultTableModel tabla = (DefaultTableModel) vista_horarios.tablaHorarios.getModel();
         this.generarTabla();
        for (Horario hor : laboratorio.getHorarios()) {
         switch(hor.getNombre_dia()){
             case "Lunes":
                 this.asignarHoras(hor, 1);
             break;
             case "Martes":
                 this.asignarHoras(hor, 2);
             break;
             case "Miercoles":
                 this.asignarHoras(hor, 3);
             break;
             case "Jueves":
                 this.asignarHoras(hor, 4);
             break;
             case "viernes":
                 this.asignarHoras(hor, 5);
             break;
             case "Sabado":
                 this.asignarHoras(hor, 6);
             break;
         }   
        }
    }
    
    private void asignarHoras(Horario horario, int dia){
            int horaInicio=this.obtenerHoras(horario.getHora_inicio()),horaFin=this.obtenerHoras(horario.getHora_final());
            for (int i = horaInicio; i <= horaFin; i++) {
                  this.vista_horarios.tablaHorarios.setValueAt(horario.getMateria()+" \n "+horario.getNombre_profesor(),i-6, dia);
                 
        }
     }
    
     public int obtenerHoras(String hora) {
        // Obtener los primeros dos caracteres y convertirlos a entero
        String hoursString = hora.substring(0, 2);
        return Integer.parseInt(hoursString);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==vista_horarios.btnRegresar) {
            MenuControlador menu = new MenuControlador();
            menu.iniciar();
            this.vista_horarios.dispose();
        }
        
    }
    
}
