/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.Conexion;
import Modelos.laboratorio;
import Modelos.Recursos;
import Modelos.Reserva;
import Modelos.bloque;
import Modelos.docente;
import Modelos.usuario;
import Vista.Reservas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JSpinner;

/**
 *
 * @author ASUS
 */
public class guardarReserva implements ActionListener {

    private Reserva modeloRes;
    private Reservas vistaRes;
    private Recursos rec = new Recursos();
//CONSTRUCTOR PARA GUARDAR LAS RESERVAS DE LABORATORIOS

    public guardarReserva(Reservas vistRes, Reserva modeloRes) throws SQLException, ClassNotFoundException {
        this.modeloRes = modeloRes;
        this.vistaRes = vistRes;
        this.vistaRes.btReservas.addActionListener(this);
        this.vistaRes.btCancelar.addActionListener(this);
        //LLENAR EL CBBOX DE EDIFICIOS,DOCENTES,USUARIO
        this.llenarDatosBloques();
        this.llenarDatosDocentes();
        this.llenarDatosUsuario();
        this.vistaRes.cbResponsables.setSelectedIndex(-1);
        this.vistaRes.cbLaboratorios.setSelectedIndex(-1);
        this.vistaRes.cbEdificios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vistRes.cbLaboratorios.removeAllItems();
                int id_bloque = vistRes.cbEdificios.getItemAt(vistRes.cbEdificios.getSelectedIndex()).getId_bloque();
                System.out.println("id de edificio" + id_bloque);
                llenarCbLaboratorios(id_bloque);
            }
        });

    }

    //GUARDAR INFORMACION DE LA RESERVA
    @Override
    public void actionPerformed(ActionEvent e) {
        Reserva r = new Reserva();
        if (e.getSource() == this.vistaRes.btReservas) {
            if (comprobarEleccion(this.vistaRes) == 1 && comprobarCamposVacios(this.vistaRes)) {
                r.setUsuario(1);
                r.setDocente(this.vistaRes.cbResponsables.getItemAt(this.vistaRes.cbResponsables.getSelectedIndex()).getId_responsable());
                r.setHoraInicio(obtenerHoraMinutosDesdeSpinner(this.vistaRes.JspinerHoraInicio));
                r.setHorafin(obtenerHoraMinutosDesdeSpinner(this.vistaRes.JspinerHoraFin));
                System.out.println(obtenerFechaNumerica(this.vistaRes.jFecha.getDate()));
                r.setFechaReserva(obtenerFechaNumerica(this.vistaRes.jFecha.getDate()));
                r.setLaboratorio(this.vistaRes.cbLaboratorios.getItemAt(this.vistaRes.cbLaboratorios.getSelectedIndex()).getId_laboratorio());
                r.setDescripcion(this.vistaRes.textAreaAsunto.getText());
                try {
                    guardarReserva(r);
                    borrarDatos(this.vistaRes);
                    rec.aviso("Su reserva se ha realizado con éxito");
                    
                } catch (SQLException ex) {
                    rec.aviso("Fallo en la inserción de la reserva " + ex);
                }
            }
        }
    }
//TRANSFORMAR EL SPINNER A HORAS Y MINUTOS 

    private String obtenerHoraMinutosDesdeSpinner(JSpinner spinner) {
        Date date = (Date) spinner.getValue();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        return dateFormat.format(date);
    }
    private String obtenerFechaNumerica(Date fecha) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(fecha);
    }
//INSERTAR RESERVA--------------------------------------------------------------------------

    public void guardarReserva(Reserva r) throws SQLException {
        Conexion conec = new Conexion();
        Connection con = conec.Conectar();
        if (con == null) {
            rec.aviso("No tiene conexion RECUERDE cada accion que realize en el programa no se va a guardar");
        } else {
            Statement stmt = con.createStatement();
            String consulta = "INSERT INTO reservas (id_usuario,id_responsable,nombre_piso,hora_inicio,hora_fin,fecha_reserva,id_laboratorio,descripcion) VALUES('" + r.getUsuario() + "','" + r.getDocente() + "','e','" + r.getHoraInicio() + "','" + r.getHorafin() + "','" + r.getFechaReserva() + "','" + r.getLaboratorio() + "','" + r.getDescripcion() + "');";
            stmt.executeUpdate(consulta);
            stmt.close();
            con.close();
        }
    }

    //LLENAR COMBO BOX BLOQUE
    public void llenarDatosBloques() {
        bloque bloq = new bloque();
        ArrayList<bloque> bloquesAgg = new ArrayList<>();
        try {
            bloquesAgg = bloq.consultaBloques();
        } catch (Exception e) {
            System.out.println(e);
            rec.aviso("Error al momento de llenar el combo de Bloques");
        }
        for (int i = 0; i < bloquesAgg.size(); i++) {
            this.vistaRes.cbEdificios.addItem(bloquesAgg.get(i));
        }
    }
    //LLENAR TXT USUARIO

    private void llenarDatosUsuario() {
        usuario user = new usuario();
        ArrayList<usuario> usuarios = new ArrayList<>();
        try {
            usuarios = user.consultaUsuarios();
        } catch (Exception e) {
            System.out.println(e);
            rec.aviso("Error al momento de llenar el combo de Usuario");
        }
        for (int i = 0; i < usuarios.size(); i++) {
            this.vistaRes.txtUsuario.setText(usuarios.get(i).getNombre_usuario());
        }
    }
    //LLENAR COMBO BOX DOCENTES

    private void llenarDatosDocentes() {
        docente doce = new docente();
        ArrayList<docente> docentesAgg = new ArrayList<>();
        try {
            docentesAgg = doce.consultaDocente();
        } catch (Exception e) {
            rec.aviso("Error al momento de llenar el combo de Docentes");
        }
        for (int i = 0; i < docentesAgg.size(); i++) {
            this.vistaRes.cbResponsables.addItem(docentesAgg.get(i));
        }
    }
    //LLENAR COMBOBOX EDIFICIOS

    private void llenarCbLaboratorios(int id_bloque) {
        laboratorio lab = new laboratorio();
        ArrayList<laboratorio> labs = new ArrayList<>();
        try {
            labs.clear();
            labs = lab.consultaLaboratorio(id_bloque);
        } catch (Exception e) {
        }
        for (int i = 0; i < labs.size(); i++) {
            this.vistaRes.cbLaboratorios.addItem(labs.get(i));
        }
    }

    private int comprobarEleccion(Reservas vistareser) {
        if (vistareser.cbEdificios.getSelectedIndex() == -1
                || vistareser.cbResponsables.getSelectedIndex() == -1
                || vistareser.cbLaboratorios.getSelectedIndex() == -1) {
            rec.aviso("Porfavor llene todos los campos para validar su reserva.");
            return -1;

        }
        return 1;
    }
//COMPROBAMOS QUE TODOS LOS CAMPOS ESTEN LLENOS
    private boolean comprobarCamposVacios(Reservas vistareser) {
        if (vistareser.textAreaAsunto.getText().isEmpty()
                || vistareser.jFecha.getDate() == null
                || vistareser.JspinerHoraInicio.getValue() == null
                || vistareser.JspinerHoraFin.getValue() == null) {

            rec.aviso("Por favor llene todos los campos para validar su reserva.");
            return false;
        }
        return true;
    }
//BORRAMOS TODOS LOS DATOS PARA INGRESAR UNA NUEVA RESERVA
    private void borrarDatos(Reservas vistaRes) {
        vistaRes.jFecha.setDate(null);
        this.vistaRes.cbResponsables.setSelectedIndex(-1);
        this.vistaRes.cbLaboratorios.setSelectedIndex(-1);
        vistaRes.textAreaAsunto.setText("");
    }

}
