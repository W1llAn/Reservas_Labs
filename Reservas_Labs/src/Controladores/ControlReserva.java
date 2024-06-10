package Controladores;

import Modelos.Almacen;
import Modelos.Carrera;
import Modelos.Conexion;
import Modelos.Horario;
import Modelos.LabDB;
import Modelos.Recursos;
import Modelos.Responsable;
import Modelos.UsuarioSesion;
import Vista.Horarios;
import Vista.Reservas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ControlReserva implements ActionListener {

    private Horario modelohorario;
    private Reservas vistaRes;
    private Recursos rec = new Recursos();
    private Responsable responsable;
    private int id_responsable = 0;
    private int id_laboratorio = 0;
    private String tipo_reserva = null;
//CONSTRUCTOR PARA GUARDAR LAS RESERVAS DE LABORATORIOS

    public ControlReserva(Reservas vistRes, Horario modelohorario, String Edificio,
            String Laboratorio, String Fecha, String hInicio, String hFin,
            int id_laboratorio) throws SQLException, ClassNotFoundException {
        this.modelohorario = modelohorario;
        this.vistaRes = vistRes;
        this.responsable = new Responsable();
        // Inicializa y configura componentes que dependen de vistaRes
        this.vistaRes.btReservas.addActionListener(this);
        this.vistaRes.btCancelar.addActionListener(this);
        this.id_laboratorio = id_laboratorio;
        // Llenar datos de carreras
        this.llenarDatosCarreas();
        //Usuario que maneja el sistema
        this.llenarDatosUsuario();

        //Llenamos la lista de responsables para futuras comprobaciones
        responsable.consultaResponsables();

        //Marcamos los combos sin seleccion
        this.vistaRes.cbCarreras.setSelectedIndex(-1);
        this.vistaRes.cbCargo.setSelectedIndex(-1);

        //Mandamos los datos necesarios sobre  INFORMACION de reserva a la interfaz
        this.vistaRes.txtLaboratorio.setText(Laboratorio);
        this.vistaRes.txtEdificio.setText(Edificio);
        this.vistaRes.txtFechaReserva.setText(Fecha);
        this.vistaRes.txtHoraInicio.setText(hInicio);
        this.vistaRes.txtHoraFin.setText(hFin);

        //Metodo de consulta de cedula al momento
        this.vistaRes.txtCedulaResponsable.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                buscarCedula();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                buscarCedula();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                buscarCedula();
            }
        });
        // Agregar ActionListener al JComboBox para habilitar/deshabilitar txtMateria
        this.vistaRes.cbTipo_Reserva.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (vistaRes.cbTipo_Reserva.getSelectedIndex() == 0) { // Reserva
                    vistaRes.txtMateria.setText("No debe ingresar nada");
                    vistaRes.txtMateria.setEnabled(false);
                    tipo_reserva = "Reserva";
                } else { // Horario
                    vistaRes.txtMateria.setText("");
                    vistaRes.txtMateria.setEnabled(true);
                    tipo_reserva = null;
                }
            }
        });
        this.vistaRes.cbCargo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (vistRes.cbCargo.getSelectedIndex() == 1) {
                    vistRes.cbTipo_Reserva.setEnabled(false);
                    vistaRes.txtMateria.setText("No debe ingresar nada");
                    vistRes.cbTipo_Reserva.setSelectedIndex(0);
                } else {
                    vistRes.cbTipo_Reserva.setEnabled(true);
                    vistaRes.txtMateria.setEnabled(true);
                    vistRes.cbTipo_Reserva.setSelectedIndex(-1);
                }

            }
        });

    }

    //GUARDAR INFORMACION DE LA RESERVA
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vistaRes.btReservas) {
            if (comprobarEleccion(this.vistaRes) == 1 && comprobarCamposVacios(this.vistaRes)) {
                System.out.println("El id de responsable fue:" + id_responsable);
                String tipo_ReservaFinal = (tipo_reserva == null) ? vistaRes.txtMateria.getText() : tipo_reserva;
                //significa que en la busqueda dinamica no se encontro a la persona de la cedula
                if (id_responsable == 0) {
                    try {
                        System.out.println("No existe responsable se envian los datos del nuevo responsable a la base");
                        enviarDatosResponsable(vistaRes);
                        Almacen.getInstance().listResponsables.clear();
                        responsable.consultaResponsables();
                    } catch (SQLException ex) {
                        rec.aviso("Fallo en la inserccion del responsable");
                    } catch (ClassNotFoundException ex) {
                        rec.aviso("Fallo en la consulta del responsable");
                    }
                    //guardamos el horario  en la base
                    int id_responsable_guardado = consultarIdResponsableAlmacen(this.vistaRes.txtCedulaResponsable.getText());
                    guardarHorario(id_responsable_guardado, id_laboratorio, tipo_ReservaFinal);
                } else {
                    guardarHorario(id_responsable, id_laboratorio, tipo_ReservaFinal);
                }
            }
        }
        if (e.getSource() == this.vistaRes.btCancelar) {
            borrarDatos();
        }
    }
    //INSERTAR RESERVA en la Tabla de HORARIO--------------------------------------------------------------------------

    public void guardarHorario(Horario h) throws SQLException {
        Conexion conec = new Conexion();
        Connection con = conec.Conectar();
        if (con == null) {
            rec.aviso("No tiene conexión RECUERDE cada accion que realize en el programa no se va a guardar");
        } else {
            Statement stmt = con.createStatement();
            ResultSet rs = null;
            // Insercción en la tabla horario
            String consultaHorario = "INSERT INTO Horarios (ID_laboratorio, fecha_dia, hora_inicio, hora_final, materia, nombre_dia, id_responsable,descripcion) VALUES("
                    + h.getId_laboratorio() + ", '"
                    + h.getFecha_dia() + "', '"
                    + h.getHora_inicio() + "', '"
                    + h.getHora_final() + "', '"
                    + h.getMateria() + "', '"
                    + h.getNombre_dia() + "', "
                    + h.getId_responsable() + ",'"
                    + h.getDescripcion() + "');";

            stmt.executeUpdate(consultaHorario);

            stmt.close();
            con.close();
        }
    }

    //LLENAR TXT USUARIO
    private void llenarDatosUsuario() {
        String nombreUsuario = UsuarioSesion.getNombreUsuario();
        this.vistaRes.txtUsuario.setText(nombreUsuario.toUpperCase());
    }

    private int comprobarEleccion(Reservas vistareser) {
        if (vistareser.cbCarreras.getSelectedIndex() == -1
                || vistareser.cbCargo.getSelectedIndex() == -1
                || vistareser.cbTipo_Reserva.getSelectedIndex() == -1) {
            rec.aviso("Por favor ELIJA todos los campos para validar su reserva.");
            return -1;
        }
        return 1;
    }
//COMPROBAMOS QUE TODOS LOS CAMPOS ESTEN LLENOS

    private boolean comprobarCamposVacios(Reservas vistareser) {
        if (vistareser.textDescripcion.getText().isBlank()
                || vistareser.txtNombreRespon.getText().isBlank()
                || vistareser.txtApellidoResponsable.getText().isBlank()
                || vistareser.txtCedulaResponsable.getText().isBlank()) {

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
    private void borrarDatos() {
        this.vistaRes.cbCarreras.setSelectedIndex(-1);
        this.vistaRes.textDescripcion.setText("");
        this.vistaRes.txtCedulaResponsable.setText("");
        this.vistaRes.txtNombreRespon.setText("");
        this.vistaRes.txtApellidoResponsable.setText("");
        this.vistaRes.cbCargo.setSelectedIndex(-1);
        this.vistaRes.jlMensaje.setText("");
    }
//Inserccion de los datos del usuario en la base 

    private void enviarDatosResponsable(Reservas vistaRes) throws SQLException {
        Conexion conec = new Conexion();
        Connection con = conec.Conectar();
        String cedula = vistaRes.txtCedulaResponsable.getText();
        String nombre = vistaRes.txtNombreRespon.getText();
        String apellido = vistaRes.txtApellidoResponsable.getText();
        String cargo = vistaRes.cbCargo.getSelectedItem().toString();
        System.out.println("El cargos es: " + cargo);
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

    private void guardarHorario(int id_responsable, int id_laboratorio, String tipo_ReservaFinal) {
        Horario horario = new Horario();
        horario.setId_responsable(id_responsable);
        System.out.println("El id del responsable es: " + id_responsable);
        horario.setHora_inicio(this.vistaRes.txtHoraInicio.getText());
        horario.setHora_final(this.vistaRes.txtHoraFin.getText());
        horario.setFecha_dia(LocalDate.parse(this.vistaRes.txtFechaReserva.getText()));
        horario.setNombre_dia(horario.decifrarDia(this.vistaRes.txtFechaReserva.getText()));
        horario.setMateria(tipo_ReservaFinal);
        horario.setId_laboratorio(id_laboratorio);
        horario.setDescripcion(this.vistaRes.textDescripcion.getText());
        try {
            guardarHorario(horario);
            borrarDatos();
            rec.aviso("Su reserva se ha realizado con éxito");
            //Volver al menu
            MenuControlador menu = new MenuControlador();
            Horarios vista_horarios = new Horarios();
            try {
                Cont_Horarios ctrl_horario = new Cont_Horarios(vista_horarios, horario, new LabDB().labList());
            } catch (SQLException ex) {
                Logger.getLogger(MenuControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.vistaRes.dispose();
            vista_horarios.setVisible(true);

        } catch (SQLException ex) {
            rec.aviso("Fallo en la inserción de la reserva " + ex);
        }
    }

    private void buscarCedula() {
        String cedula = vistaRes.txtCedulaResponsable.getText();
        boolean cedulaEncontrada = busquedaCedula(cedula);
        if (cedulaEncontrada) {
            vistaRes.jlMensaje.setText("Cédula encontrada.");
            Responsable responsable = obtenerResponsablePorCedula(cedula);
            if (responsable != null) {
                vistaRes.txtNombreRespon.setText(responsable.getNombre());
                vistaRes.txtApellidoResponsable.setText(responsable.getApellido());
                vistaRes.cbCargo.setSelectedItem(responsable.getCargo());
                // Suponiendo que cbCarreras contiene objetos Carrera
                for (int i = 0; i < vistaRes.cbCarreras.getItemCount(); i++) {
                    Carrera carrera = vistaRes.cbCarreras.getItemAt(i);
                    System.out.println("El id_responsable es:" + responsable.getId_responsable());
                    if (carrera.getId_carrera() == responsable.getId_carrera()) {
                        vistaRes.cbCarreras.setSelectedItem(carrera);
                        break;
                    }
                }
                id_responsable = responsable.getId_responsable();
            }
        } else {
            vistaRes.jlMensaje.setText("Cédula no encontrada, debe registrarse.");
            vistaRes.txtNombreRespon.setText("");
            vistaRes.txtApellidoResponsable.setText("");
            vistaRes.cbCargo.setSelectedIndex(-1);
            vistaRes.cbCarreras.setSelectedIndex(-1);
            id_responsable = 0;
        }
    }

    private Responsable obtenerResponsablePorCedula(String cedula) {
        for (Responsable responsable : Almacen.getInstance().listResponsables) {
            if (responsable.getCedula().equals(cedula)) {
                return responsable;
            }
        }
        return null;
    }

    private boolean busquedaCedula(String cedula) {
        for (Responsable responsable : Almacen.getInstance().listResponsables) {
            if (responsable.getCedula().equals(cedula)) {
                return true;
            }
        }
        return false;
    }
}
