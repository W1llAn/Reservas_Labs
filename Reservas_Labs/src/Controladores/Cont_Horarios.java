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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.time.format.TextStyle;
import java.util.ArrayList;
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
    private BlockDB bloque = new BlockDB();
    private LabDB lab = new LabDB();

    public Cont_Horarios(Horarios vista_horarios, Horario horarios) throws SQLException {
        this.vista_horarios = vista_horarios;
        this.horarios = horarios;
        this.vista_horarios.btnRegresar.addActionListener(this);
        this.vista_horarios.btnReserva.addActionListener(this);
        this.llenarComboBloques();
        this.vista_horarios.tablaHorarios.addMouseListener(this);
        this.vista_horarios.comboBloque.setSelectedIndex(-1);
       this.vista_horarios.comboBloque.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int itemSeleccionado = vista_horarios.comboBloque.getSelectedIndex();
                if (itemSeleccionado != -1) {
                    vista_horarios.comboLaboratorio.removeAllItems();
                    borrarTabla();
                    llenarLaboratorios(vista_horarios.comboBloque.getItemAt(itemSeleccionado).getId());
                }
                vista_horarios.comboLaboratorio.setSelectedIndex(-1);
            }
        });
       this.vista_horarios.btnRegresar.addActionListener(this);
         this.vista_horarios.comboLaboratorio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int itemSeleccionado = vista_horarios.comboLaboratorio.getSelectedIndex();
                if (itemSeleccionado != -1) {
                    try {                
                        borrarTabla();
                        asignarDias(horarios.contultaHorarios(vista_horarios.comboLaboratorio.getItemAt(itemSeleccionado).getId()));
                    } catch (SQLException ex) {
                        Logger.getLogger(Cont_Horarios.class.getName()).log(Level.SEVERE, null, ex);
                    }  
                }
            }
        });
         
        }
    
    private void llenarLaboratorios(int codigo){
        ArrayList<Lab> laboratorios = new ArrayList<>();
        laboratorios= this.lab.laboratoriosBloque(codigo);
        for (int i = 0; i < laboratorios.size(); i++) {
            this.vista_horarios.comboLaboratorio.addItem(laboratorios.get(i));
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
        ArrayList<Block> bloques = new ArrayList<>();
        bloques= this.bloque.blockList();
        for (int i = 0; i < bloques.size(); i++) {
            this.vista_horarios.comboBloque.addItem(bloques.get(i));
        }
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
        if (e.getSource()==this.vista_horarios.tablaHorarios) {
            int fila = this.vista_horarios.tablaHorarios.rowAtPoint(e.getPoint());
           
            
        }
        if (e.getSource()==this.vista_horarios.btnRegresar) {
            
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
