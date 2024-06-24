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
import java.util.stream.Collectors;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
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
    private String codeSelect;
    private List<Lab> labs;

    public ControllerPanelLabs(Laboratorios vista) {
        this.view = vista;
        table = new DefaultTableModel(new String[]{"Codigo", "Nombre", "Bloque", "Tipo"}, 0);
        combo = new DefaultComboBoxModel();
        labdb = new LabDB();
        blockDB = new BlockDB();
        events();
        fillTable();
        fillCombo();
        this.view.setVisible(true);

    }

    private void events() {

        view.btnAdd.addActionListener(this);
        view.btnClean.addActionListener(this);
        view.btnEdit.addActionListener(this);
        view.btnDelete.addActionListener(this);
        view.btnCancelar.addActionListener(this);
        view.tbLabs.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                fillFields(e);
            }
        });
       view.txtSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                search();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                search();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                search();
            }
        });
    }

    private void fillFields(MouseEvent e) {
        JTable target = (JTable) e.getSource();
        select = true;
        codeSelect = getRowTable(target.getSelectedRow(), 0);
        view.txtName.setText(getRowTable(target.getSelectedRow(), 1));
        seleccionarPorCoincidencia(view.cbxBlock, getRowTable(target.getSelectedRow(), 2));
        seleccionarPorCoincidenciaLaboratorios(view.cbxTipo, getRowTable(target.getSelectedRow(), 3));
    }

    private void seleccionarPorCoincidencia(JComboBox<Block> comboBox, String seleccion) {
        for (int i = 0; i < comboBox.getItemCount(); i++) {
            String item = comboBox.getItemAt(i).getName();
            if (item.contains(seleccion)) {
                comboBox.setSelectedIndex(i);
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
        this.labs = labdb.labList();
        this.labs.forEach(lab
                -> table.addRow(new Object[]{lab.getCode(), lab.getName(), lab.getBlockName(), lab.isType()})
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
        return !(view.txtName.getText().equals(""));
    }

    private void cleanFields() {
        view.txtName.setText("");
        this.select=false;
        view.cbxTipo.setSelectedIndex(0);
        view.cbxBlock.setSelectedIndex(0);
        codeSelect = null;

    }

    private void addLabs() {
        ArrayList<String> codes = new ArrayList<>();
        this.labs.forEach(lab -> codes.add(lab.getCode()));

        if (validateFields()) {
            Lab lb = new Lab.LabBuilder()
                    .Name(view.txtName.getText())
                    .BlockName(((Block) view.cbxBlock.getSelectedItem()).getName())
                    .IdBlock(((Block) view.cbxBlock.getSelectedItem()).getId())
                    .Type(view.cbxTipo.getSelectedItem().toString())
                    .build();
            lb.generateCode(codes);
            if (labdb.addLab(lb)) {
                JOptionPane.showMessageDialog(view, "El laboratorio " + view.txtName.getText() + " se creo Exitosamente", "LABORATORIO", JOptionPane.INFORMATION_MESSAGE);
                cleanFields();
                fillTable();
            } else {
                JOptionPane.showMessageDialog(view, "El laboratorio " + view.txtName.getText() + " se creo Exitosamente", "LABORATORIO", JOptionPane.YES_OPTION);
            }
        } else {
            JOptionPane.showMessageDialog(view, "Campos Para CREAR el Laboratorio Incompletos", "LABORATORIO", JOptionPane.YES_OPTION);
        }
    }

    private void editLabs() {
        if (validateFields() && select) {
            Lab lb = new Lab.LabBuilder()
                    .Name(view.txtName.getText())
                    .Code(codeSelect)
                    .Floor(0)
                    .BlockName(((Block) view.cbxBlock.getSelectedItem()).getName())
                    .IdBlock(((Block) view.cbxBlock.getSelectedItem()).getId())
                    .Type(view.cbxTipo.getSelectedItem().toString())
                    .build();
            if (labdb.editLab(lb)) {
                JOptionPane.showMessageDialog(view, "El laboratorio con codigo" + codeSelect + " se edito Exitosamente", "LABORATORIO", JOptionPane.INFORMATION_MESSAGE);
                cleanFields();
                fillTable();
            } else {
                JOptionPane.showMessageDialog(view, "El laboratorio con codigo" + codeSelect + " no se Edito", "LABORATORIO", JOptionPane.YES_OPTION);

            }
        } else {
            JOptionPane.showMessageDialog(view, "Campos Para EDITAR el Laboratorio Incompletos o Seleccione una fila", "LABORATORIO", JOptionPane.YES_OPTION);
        }
    }

    private void deleteLabs() {
        if (select) {
            if (labdb.deleteLab(codeSelect)) {
                JOptionPane.showMessageDialog(view, "El laboratorio con codigo" + codeSelect + " se BORRO Exitosamente", "LABORATORIO", JOptionPane.INFORMATION_MESSAGE);
                cleanFields();
                fillTable();
            } else {
                JOptionPane.showMessageDialog(view, "El laboratorio tiene una reserva, no se puede borrar", "LABORATORIO", JOptionPane.YES_OPTION);
            }
        } else {
            JOptionPane.showMessageDialog(view, "Seleccione una fila", "LABORATORIO", JOptionPane.YES_OPTION);

        }
    }

    
private void search() {
        String searchText = view.txtSearch.getText().toLowerCase();

        // Filtrar la lista de labs
        List<Lab> filteredLabs = labs.stream()
            .filter(lab -> lab.getCode().toLowerCase().contains(searchText) ||
                           lab.getName().toLowerCase().contains(searchText))
            .collect(Collectors.toList());

        // Actualizar la tabla con los datos filtrados
        updateTable(filteredLabs);
    }

    private void updateTable(List<Lab> labsToShow) {
        DefaultTableModel model = (DefaultTableModel) view.tbLabs.getModel();
        model.setRowCount(0); // Limpiar la tabla

        // Agregar filas a la tabla
        for (Lab lab : labsToShow) {
            model.addRow(new Object[]{lab.getCode(), lab.getName(), lab.getBlockName(), lab.isType()});
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
        }
        if (e.getSource() == view.btnDelete) {
            deleteLabs();
        }
        if (e.getSource() == view.btnEdit) {
            editLabs();
        }
        if (e.getSource() == view.btnCancelar) {
            MenuControlador menu = new MenuControlador();
            view.setVisible(false);
            menu.iniciar();
        }
    }

}
