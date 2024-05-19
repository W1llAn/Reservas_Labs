/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

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
    private Lab lab;

    public ControllerPanelLabs(JPanelLaboratorios vista) {
        this.vista = vista;
        table = new DefaultTableModel(new String []{"Codigo","Bloque","Piso","Nombre"}, 0);
    }

    public void fillTable() {

    }

    public boolean addLabs() {

    }

    public boolean editLabs() {

    }

    public boolean deleteLabs() {

    }

}
