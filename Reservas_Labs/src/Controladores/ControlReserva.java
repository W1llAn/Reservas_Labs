/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.Almacen;
import Modelos.Block;
import Modelos.BlockDB;
import Modelos.Carrera;
import Modelos.Conexion;
import Modelos.Recursos;
import Modelos.Reserva;
import Modelos.Lab;
import Modelos.LabDB;
import Modelos.Responsable;
import Modelos.UsuarioSesion;
import Vista.Menu;
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
public class ControlReserva implements ActionListener {

    private Reserva modeloRes;
    private Reservas vistaRes;
    private Recursos rec = new Recursos();
    private Almacen almacen;
    private Responsable responsable;
//CONSTRUCTOR PARA GUARDAR LAS RESERVAS DE LABORATORIOS

    public ControlReserva(Reservas vistRes, Reserva modeloRes) throws SQLException, ClassNotFoundException {
        this.modeloRes = modeloRes;
        this.vistaRes = vistRes; // Asegúrate de que esta asignación sea una de las primeras líneas en tu constructor.

        // Inicializa y configura componentes que dependen de vistaRes
        this.vistaRes.btReservas.addActionListener(this);
        this.vistaRes.btCancelar.addActionListener(this);

        this.responsable = new Responsable();
        LabDB labs = new LabDB();
        labs.labList();

        // Llenar datos que dependen de los componentes de vistaRes
        this.llenarDatosCarreas();
        this.llenarDatosBloques();
        this.llenarDatosUsuario();

        // Llenamos la lista de responsables
        responsable.consultaResponsables();
        this.vistaRes.cbCarreras.setSelectedIndex(-1);
        this.vistaRes.cbLaboratorios.setSelectedIndex(-1);
        this.vistaRes.cbEdificios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (vistaRes.cbEdificios.getSelectedIndex() != -1) {
                    int id_bloque = vistaRes.cbEdificios.getItemAt(vistaRes.cbEdificios.getSelectedIndex()).getId();

                    consultarLaboratoriosEdificio(id_bloque);
                }
            }
        });
    }

    //GUARDAR INFORMACION DE LA RESERVA
    @Override
    public void actionPerformed(ActionEvent e) {
        Reserva r = new Reserva();
        if (e.getSource() == this.vistaRes.btReservas) {
            if (comprobarEleccion(this.vistaRes) == 1 && comprobarCamposVacios(this.vistaRes)) {
                int id_responsable = consultarIdResponsableAlmacen(this.vistaRes.txtCedulaResponsable.getText());
                if (id_responsable == 0) {//significa que no esta registrado
                    try {
                        enviarDatosResponsable(vistaRes);
                        Almacen.getInstance().listResponsables.clear();
                        responsable.consultaResponsables();
                    } catch (SQLException ex) {
                        rec.aviso("Fallo en la inserccion del responsable");
                    } catch (ClassNotFoundException ex) {
                        rec.aviso("Fallo en la consulta del responsable");
                    }
                }
                r.setResponsable(id_responsable);
                System.out.println("El id del usuario es: " + UsuarioSesion.getIdUsuario());
                r.setUsuario(UsuarioSesion.getIdUsuario());
                r.setHoraInicio(obtenerHoraMinutosDesdeSpinner(this.vistaRes.JspinerHoraInicio));
                r.setHorafin(obtenerHoraMinutosDesdeSpinner(this.vistaRes.JspinerHoraFin));
                r.setFechaReserva(obtenerFechaNumerica(this.vistaRes.jFecha.getDate()));
                r.setLaboratorio(this.vistaRes.cbLaboratorios.getItemAt(this.vistaRes.cbLaboratorios.getSelectedIndex()).getId());
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
         if (e.getSource() == this.vistaRes.btCancelar) {
             MenuControlador menu = new MenuControlador();
             borrarDatos(vistaRes);
             this.vistaRes.dispose();
             menu.iniciar();
             
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
            String consulta = "INSERT INTO reservas (id_usuario,id_responsable,nombre_piso,hora_inicio,hora_fin,fecha_reserva,id_laboratorio,descripcion) VALUES('" + r.getUsuario() + "','" + r.getResponsable() + "','e','" + r.getHoraInicio() + "','" + r.getHorafin() + "','" + r.getFechaReserva() + "','" + r.getLaboratorio() + "','" + r.getDescripcion() + "');";
            stmt.executeUpdate(consulta);
            stmt.close();
            con.close();
        }
    }

    //LLENAR COMBO BOX BLOQUE
    public void llenarDatosBloques() {
        BlockDB bloq = new BlockDB();
        ArrayList<Block> bloquesAgg = new ArrayList<>();
        try {
            bloquesAgg = bloq.blockList();
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
        String nombreUsuario = UsuarioSesion.getNombreUsuario();
        this.vistaRes.txtUsuario.setText(nombreUsuario.toUpperCase());
    }
    //LLENAR COMBOBOX EDIFICIOS

    private void consultarLaboratoriosEdificio(int id_bloque) {
        this.vistaRes.cbLaboratorios.removeAllItems();
        for (int i = 0; i < Almacen.getInstance().listaLabo.size(); i++) {
            if (id_bloque == Almacen.getInstance().listaLabo.get(i).getIdBlock()) {
                this.vistaRes.cbLaboratorios.addItem(Almacen.getInstance().listaLabo.get(i));
            }
        }
    }

    private int comprobarEleccion(Reservas vistareser) {
        if (vistareser.cbEdificios.getSelectedIndex() == -1
                || vistareser.cbCarreras.getSelectedIndex() == -1
                || vistareser.cbLaboratorios.getSelectedIndex() == -1) {
            rec.aviso("Porfavor llene todos los campos para validar su reserva.");
            return -1;

        }
        return 1;
    }
//COMPROBAMOS QUE TODOS LOS CAMPOS ESTEN LLENOS

    private boolean comprobarCamposVacios(Reservas vistareser) {
        if (vistareser.textAreaAsunto.getText().isBlank()
                || vistareser.jFecha.getDate() == null
                || vistareser.JspinerHoraInicio.getValue() == null
                || vistareser.JspinerHoraFin.getValue() == null
                || vistareser.txtNombreResponsable.getText().isBlank()
                || vistareser.txtApellidoResponsable.getText().isBlank()
                || vistareser.txtCedulaResponsable.getText().isBlank()
                || vistareser.txtCargoResponsable.getText().isBlank()) {

            rec.aviso("Por favor llene todos los campos para validar su reserva.");
            return false;
        }
        return true;
    }
//LLENAMOS LOS COMBOBOX DE CARRERAS

    private void llenarDatosCarreas() throws SQLException {
        Carrera carrera = new Carrera();
        ArrayList<Carrera> carre = new ArrayList<>();
        try {
            carre = carrera.consultaCarrera();
        } catch (ClassNotFoundException ex) {
            rec.aviso("Fallo al cargar el cbbox de carreras");
        }
        for (int i = 0; i < carre.size(); i++) {
            this.vistaRes.cbCarreras.addItem(carre.get(i));
        }
    }

    //BORRAMOS TODOS LOS DATOS PARA INGRESAR UNA NUEVA RESERVA
    private void borrarDatos(Reservas vistaRes) {
        vistaRes.jFecha.setDate(null);
        this.vistaRes.cbLaboratorios.setSelectedIndex(-1);
        this.vistaRes.cbEdificios.setSelectedIndex(-1);    
        this.vistaRes.cbCarreras.setSelectedIndex(-1);
        this.vistaRes.textAreaAsunto.setText("");
        this.vistaRes.txtNombreResponsable.setText("");  
        this.vistaRes.txtApellidoResponsable.setText("");
        this.vistaRes.txtCedulaResponsable.setText("");    
        this.vistaRes.txtCargoResponsable.setText("");
    }
//Inserccion de los datos del usuario en la base 

    private void enviarDatosResponsable(Reservas vistaRes) throws SQLException {
        Conexion conec = new Conexion();
        Connection con = conec.Conectar();
        String cedula = vistaRes.txtCedulaResponsable.getText();
        String nombre = vistaRes.txtNombreResponsable.getText();
        String apellido = vistaRes.txtApellidoResponsable.getText();
        String cargo = vistaRes.txtCargoResponsable.getText();
        int id_carrera = vistaRes.cbCarreras.getItemAt(vistaRes.cbCarreras.getSelectedIndex()).getId_carrera();
        if (con == null) {
            rec.aviso("No tiene conexion RECUERDE cada accion que realize en el programa no se va a guardar");
        } else {
            Statement stmt = con.createStatement();
            String consulta = "INSERT INTO responsables (cedula"
                    + ",nombre,apellido,cargo,id_carrera) "
                    + "VALUES('" + cedula + "','" + nombre + "','" + apellido + "','" + cargo + "','" + id_carrera + "');";
            stmt.executeUpdate(consulta);
            stmt.close();
            con.close();
        }
    }

    private int consultarIdResponsableAlmacen(String cedula) {
        for (int i = 0; i < Almacen.getInstance().listResponsables.size(); i++) {
            if (Almacen.getInstance().listResponsables.get(i).getCedula().equals(cedula)) {
                return Almacen.getInstance().listResponsables.get(i).getId_responsable();
            }
        }
        return 0;
    }

}
