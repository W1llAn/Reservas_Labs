/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.laboratorio;
import Modelos.Recursos;
import Modelos.Reserva;
import Modelos.bloque;
import Modelos.docente;
import Modelos.usuario;
import Vista.Reservas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class guardarReserva implements ActionListener {

    private Reserva modeloRes;
    private Reservas vistRes;
    private Recursos rec;
    private laboratorio lab;
    private docente doce;
    private usuario user;
//CONSTRUCTOR PARA GUARDAR LAS RESERVAS DE LABORATORIOS

    public guardarReserva(Reservas vistRes, Reserva modeloRes) throws SQLException, ClassNotFoundException {
        this.modeloRes = modeloRes;
        this.vistRes = vistRes;
        this.rec = new Recursos();
        this.vistRes.btReservas.addActionListener(this);
        this.vistRes.btCancelar.addActionListener(this);
        this.vistRes.cbEdificios.setSelectedIndex(-1);
        //LLENAR EL CBBOX DE EDIFICIOS,DOCENTES,USUARIO
        this.llenarDatosBloques();
        this.llenarDatosDocentes();
        this.llenarDatosUsuario();
        this.vistRes.cbLaboratorios.setSelectedIndex(-1);
        this.vistRes.cbLaboratorios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id_bloque = vistRes.cbEdificios.getItemAt(vistRes.cbEdificios.getSelectedIndex()).getId_bloque();
                llenarCbLaboratorios();
            }

        });
    }
    //LLENAR COMBO BOX BLOQUE
    private void llenarDatosBloques() {
        ArrayList<bloque> bloquesAgg = new ArrayList<>();
        try {
            bloquesAgg = new bloque().consultaBloques();
        } catch (ClassNotFoundException | SQLException e) {
            rec.aviso("Error al momento de llenar el combo de Bloques");
        }
        this.vistRes.cbEdificios.removeAllItems();
        for (int i = 0; i < bloquesAgg.size(); i++) {
            this.vistRes.cbEdificios.addItem(bloquesAgg.get(i));
        }
    }
   //LLENAR TXT USUARIO
    private void llenarDatosUsuario() {
        ArrayList<usuario> usuarios = new ArrayList<>();
        try {
            usuarios = user.consultaUsuarios();
        } catch (Exception e) {
            rec.aviso("Error al momento de llenar el combo de Bloques");
        }
        for (int i = 0; i < usuarios.size(); i++) {
            this.vistRes.txtUsuario.setText(usuarios.get(i).getNombre_usuario());
        }
    }
   //LLENAR COMBO BOX DOCENTES
    private void llenarDatosDocentes() {
        ArrayList<docente> docentesAgg = new ArrayList<>();
        try {
            docentesAgg = doce.consultaDocente();
        } catch (Exception e) {
            rec.aviso("Error al momento de llenar el combo de Bloques");
        }
        for (int i = 0; i < docentesAgg.size(); i++) {
            this.vistRes.cbResponsables.addItem(docentesAgg.get(i));
        }
    }
       //LLENAR COMBOBOX EDIFICIOS
    private void llenarCbLaboratorios() {
    ArrayList<laboratorio> labs= new ArrayList<>();
        try {
            labs= lab.consultaLaboratorio();
        } catch (Exception e) {
        }
        for (int i = 0; i < labs.size(); i++) {
            this.vistRes.cbLaboratorios.addItem(labs.get(i));
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
