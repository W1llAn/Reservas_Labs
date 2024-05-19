/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.Lab;
import Modelos.LabDB;
import Vista.JPanelLaboratorios;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kiwar
 */
public final class ControllerPanelLabs {

    private final JPanelLaboratorios view;
    private final DefaultTableModel table;
    private DefaultComboBoxModel combo;
    private final LabDB labdb;

    public ControllerPanelLabs(JPanelLaboratorios vista) {
        this.view = vista;
        table = new DefaultTableModel(new String[]{"Codigo", "Nombre", "Bloque", "Piso", "Tipo"}, 0);
        labdb = new LabDB();
        fillTable();
    }
    
    public void fillTable() {
        table.setRowCount(0);
        view.tbLabs.setModel(table);
        labdb.labList().forEach(lab -> 
                    table.addRow(new Object[]{lab.getCode(),lab.getName(),lab.getBlockName(),lab.isLab()})
                );
    }

    public boolean addLabs(Lab l) {
        
        return true;
    }

    public boolean editLabs() {
        return true;
    }

    public boolean deleteLabs() {
        return true;
    }

}
