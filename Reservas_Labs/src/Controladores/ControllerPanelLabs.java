/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.Block;
import Modelos.BlockDB;
import Modelos.Lab;
import Modelos.LabDB;
import Vista.Laboratorios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Kiwar
 */
public final class ControllerPanelLabs implements ActionListener {

    private final Laboratorios view;
    private final DefaultTableModel table;
    private final DefaultComboBoxModel combo;
    private final LabDB labdb;
    private final BlockDB blockDB;
    private boolean select = false;

    public ControllerPanelLabs(Laboratorios vista) {
        this.view = vista;
        table = new DefaultTableModel(new String[]{"Codigo", "Nombre", "Bloque", "Tipo"}, 0);
        combo = new DefaultComboBoxModel();
        labdb = new LabDB();
        blockDB = new BlockDB();
        fillTable();
        fillCombo();
        events();
        this.view.setVisible(true);
        
    }

    private void events() {

        view.btnAdd.addActionListener(this);
        view.btnClean.addActionListener(this);
        view.btnEdit.addActionListener(this);
        view.btnDelete.addActionListener(this);
        view.btnSearch.addActionListener(this);
        view.tbLabs.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                fillFields(e);
            }
        });
    }

    private void fillFields(MouseEvent e) {
        JTable target = (JTable) e.getSource();
        select = true;
        view.txtCode.setText(getRowTable(target.getSelectedRow(), 1));
        view.txtName.setText(getRowTable(target.getSelectedRow(), 2));
        seleccionarPorCoincidencia(view.cbxBlock, getRowTable(target.getSelectedRow(), 3));
        seleccionarPorCoincidenciaLaboratorios(view.cbxTipo, getRowTable(target.getSelectedRow(), 2));
    }

    private void seleccionarPorCoincidencia(JComboBox<Block> comboBox, String seleccion) {
        for (int i = 0; i < comboBox.getItemCount(); i++) {
            String item = comboBox.getItemAt(i).getName();
            if (item.contains(seleccion)) {
                comboBox.setSelectedItem(item);
                break;
            }
        }
    }
private void seleccionarPorCoincidenciaLaboratorios(JComboBox<String> comboBox, String seleccion) {
    for (int i = 0; i < comboBox.getItemCount(); i++) {
        String item = comboBox.getItemAt(i);
        if (item != null && item.contains(seleccion)) {
            comboBox.setSelectedItem(item);
            break;
        }
    }
}

    private String getRowTable(int row, int column) {
        return view.tbLabs.getModel().getValueAt(row, column).toString();
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
        this.view.cbxBlock.setModel(combo);
    }

    private boolean validateFields() {
        return !(view.txtCode.getText().equals("")
                || view.txtName.getText().equals(""));
    }

    private void cleanFields() {
        view.txtCode.setText("");
        view.txtName.setText("");
        view.cbxTipo.setSelectedIndex(0);
        view.cbxBlock.setSelectedIndex(0);
       
    }

    private void addLabs() {
        if (validateFields()) {
boolean valor = (view.cbxTipo.getSelectedIndex() != 0);
            Lab lb = new Lab.LabBuilder()
                    .Name(view.txtName.getText())
                    .Code(view.txtCode.getText())
                    .BlockName(((Block) view.cbxTipo.getSelectedItem()).getName())
                    .IdBlock(((Block) view.cbxTipo.getSelectedItem()).getId())
                    .Type(valor)
                    .build();
            if (labdb.addLab(lb)) {
                JOptionPane.showMessageDialog(view, "Se guardo");
                cleanFields();
                fillTable();
            } else {
                JOptionPane.showMessageDialog(view, "No se guardo");
            }
        } else {
            JOptionPane.showMessageDialog(view, "Campos Incompletos");
        }
    }
    private int buscarCodigoEnColumna(JTable tabla, String codigo) {
    int columna = 1; // La columna 2 tiene índice 1 (las columnas comienzan en 0)
    DefaultTableModel model = (DefaultTableModel) tabla.getModel();

    for (int fila = 0; fila < model.getRowCount(); fila++) {
        String valorCelda = (String) model.getValueAt(fila, columna);
        if (valorCelda != null && valorCelda.equals(codigo)) {
            return fila; // Devuelve el índice de la fila donde se encontró el código
        }
    }

    return -1; // Si no se encontró el código, devuelve -1
}

    private void editLabs() {
        if (validateFields() && select) {
            
boolean valor = (view.cbxTipo.getSelectedIndex() != 0);
            Lab lb = new Lab.LabBuilder()
                    .Name(view.txtName.getText())
                    .Code(view.txtCode.getText())
                    .Floor(0)
                    .BlockName(((Block) view.cbxTipo.getSelectedItem()).getName())
                    .IdBlock(((Block) view.cbxTipo.getSelectedItem()).getId())
                    .Type(valor)
                    .build();
            if (labdb.editLab(lb)) {
                JOptionPane.showMessageDialog(view, "Se Actualizo");
                cleanFields();
                fillTable();
            } else {
                JOptionPane.showMessageDialog(view, "No se Actualizo");
            }
        } else {
            JOptionPane.showMessageDialog(view, "Seleccione una fila");
        }
    }


    private void deleteLabs() {
        if (select) {

            if (labdb.deleteLab(view.txtCode.getText())) {
                JOptionPane.showMessageDialog(view, "Se Borro");
                cleanFields();
                fillTable();
            } else {
                JOptionPane.showMessageDialog(view, "No se Borro");
            }
        } else {
            JOptionPane.showMessageDialog(view, "Seleccione una fila");
        }
    }
    
    private void search(){
        int row = buscarCodigoEnColumna(view.tbLabs, view.txtCode.getText());
        if (row!=-1) {
             TableRowSorter<TableModel> sorter = new TableRowSorter<>(view.tbLabs.getModel());
        view.tbLabs.setRowSorter(sorter);

        // Establecer el filtro para mostrar solo la fila encontrada
            List<RowFilter<Object, Object>> filters = new ArrayList<>();
        filters.add(RowFilter.regexFilter(view.txtCode.getText(), 1)); // Columna 2 (índice 1)
        sorter.setRowFilter(RowFilter.andFilter(filters));
        }else{
            JOptionPane.showMessageDialog(view, "No se encontro el laboratorio");
        }
    }
    
    public static void main(String[] args) {
        Laboratorios l = new Laboratorios();
        ControllerPanelLabs v = new ControllerPanelLabs(l);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.btnAdd) {
            addLabs();
        }
        if (e.getSource() == view.btnClean) {
            cleanFields();
            fillTable();
        }
        if (e.getSource() == view.btnDelete) {
            deleteLabs();
        }
        if (e.getSource() == view.btnEdit) {
            editLabs();
        }
        if (e.getSource()==view.btnSearch) {
            search();
        }
    }

}
