/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.BlockDB;
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
    private final BlockDB blockDB;

    public ControllerPanelLabs(JPanelLaboratorios vista) {
        this.view = vista;
        table = new DefaultTableModel(new String[]{"Codigo", "Nombre", "Bloque", "Piso", "Tipo"}, 0);
        combo = new DefaultComboBoxModel();
        labdb = new LabDB();
        blockDB = new BlockDB();
        fillTable();
        fillCombo();
    }
    
    private void fillTable() {
        table.setRowCount(0);
        labdb.labList().forEach(lab -> 
                    table.addRow(new Object[]{lab.getCode(),lab.getName(),lab.getBlockName(),lab.isLab()})
                );
        view.tbLabs.setModel(table);
    }
    private void fillCombo() {
        combo.removeAllElements();
        
        table.setRowCount(0);
        blockDB.blockList().forEach(lab -> 
                    table.addRow(new Object[]{lab})
                );
    }
      

    public void addLabs(Lab l) {
        
    }

    public boolean editLabs() {
        return true;
    }

    public boolean deleteLabs() {
        return true;
    }

}
