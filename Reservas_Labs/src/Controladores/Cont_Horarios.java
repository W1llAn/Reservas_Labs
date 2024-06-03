/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.Horario;
import Vista.Horarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author William
 */
public class Cont_Horarios implements ActionListener{
    
    private Horarios vista_horarios = new Horarios();
    private Horario horarios = new Horario();

    public Cont_Horarios(Horarios vista_horarios, Horario horarios) {
        this.vista_horarios = vista_horarios;
        this.horarios = horarios;
        vista_horarios.btnRegresar.addActionListener(this);
        vista_horarios.btnReserva.addActionListener(this);
        vista_horarios.comboBloque.addActionListener(this);
        vista_horarios.comboLaboratorio.addActionListener(this);
        
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
