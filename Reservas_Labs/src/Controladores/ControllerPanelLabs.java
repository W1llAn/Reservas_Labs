/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.LabDB;
import Vista.JPanelLaboratorios;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kiwar
 */
public class ControllerPanelLabs {

    private JPanelLaboratorios vista;
    private DefaultTableModel table;
    private DefaultComboBoxModel combo;

    public ControllerPanelLabs(JPanelLaboratorios vista) {
        this.vista = vista;
        table = new DefaultTableModel(new String[]{"Codigo", "Bloque", "Piso", "Nombre"}, 0);
    }

    public void fillTable() {
        
    }

    public boolean addLabs() {
        
        return true;
    }

    public boolean editLabs() {
        return true;
    }

    public boolean deleteLabs() {
        return true;
    }

}
