/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.Block;
import Modelos.BlockDB;
import Modelos.Lab;
import Modelos.LabDB;
import Vista.JPanelLaboratorios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kiwar
 */
public final class ControllerPanelLabs implements ActionListener{

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
        labdb.labList().forEach(lab
                -> table.addRow(new Object[]{lab.getCode(), lab.getName(), lab.getBlockName(), lab.isLab()})
        );
        view.tbLabs.setModel(table);
    }

    private void fillCombo() {
        combo.removeAllElements();
        blockDB.blockList().forEach(lab
                -> combo.addElement(lab)
        );
    }

    private boolean validateFields() {
        return (view.txtCode.getText().equals("")
                || view.txtfloor.getText().equals("")
                || view.txtName.getText().equals(""));
    }
    
    private void cleanFields(){
        view.txtCode.setText("");
        view.txtfloor.setText("");
        view.txtName.setText("");
        view.chkLab.setSelected(false);
        view.cbxBlock.setSelectedIndex(0);
    }

    private void addLabs() {
        if (validateFields()) {
            Lab lb = new Lab.LabBuilder()
                    .Name(view.txtName.getText())
                    .Code(view.txtCode.getText())
                    .Floor(Integer.getInteger(view.txtfloor.getText()))
                    .BlockName(((Block) view.cbxBlock.getSelectedItem()).getName())
                    .IdBlock(((Block) view.cbxBlock.getSelectedItem()).getId())
                    .Type(view.chkLab.isSelected())
                    .build();
            if (labdb.addLab(lb)) {
                JOptionPane.showMessageDialog(view, "Se guardo");
                cleanFields();
            } else {
                JOptionPane.showMessageDialog(view, "No se guardo");
            }
        } else {
            JOptionPane.showMessageDialog(view, "Campos Incompletos");
        }
    }

    private boolean editLabs() {
        return true;
    }

    private boolean deleteLabs() {
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==view.btnAdd) {
            addLabs();
        }
    }

}
