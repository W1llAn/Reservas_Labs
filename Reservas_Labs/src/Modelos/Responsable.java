package Modelos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Responsable {

    private int id_responsable, id_carrera;
    private String cedula, nombre, apellido, cargo, carrera;
    private Recursos rec;

    public Responsable() {
    }

    public int getId_carrera() {
        return this.id_carrera;
    }

    public void setId_carrera(int id_carrera) {
        this.id_carrera = id_carrera;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCargo() {
        return this.cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCarrera() {
        return this.carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getId_responsable() {
        return this.id_responsable;
    }

    public void setId_responsable(int id_responsable) {
        this.id_responsable = id_responsable;
    }

    public String getCedula() {
        return this.cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    //CONSULTA LISTA DE RESPONSABLES
    public void consultaResponsables() throws SQLException, ClassNotFoundException {
        Conexion conexion = new Conexion();
        Connection con = conexion.Conectar();
        if (con == null) {
            rec.aviso("No tiene conexion RECUERDE cada accion que realize en el programa no se va a guardar");
        } else {
            con = conexion.Conectar();
            Statement st = con.createStatement();
            ResultSet rs = null;
            // Modificando la consulta para seleccionar todos los atributos de la tabla responsables
            String consulta = "SELECT * FROM responsables;";
            rs = st.executeQuery(consulta);
            while (rs.next()) {
                Responsable responsable = new Responsable();
                // Asumiendo que Responsable tiene setters para todos los campos que quieres obtener
                responsable.setId_responsable(rs.getInt("id_responsable"));
                responsable.setCedula(rs.getString("cedula"));
                responsable.setNombre(rs.getString("nombre"));
                responsable.setApellido(rs.getString("apellido"));
                responsable.setCargo(rs.getString("cargo"));
                responsable.setId_carrera(rs.getInt("id_carrera"));
                Almacen.getInstance().listResponsables.add(responsable);
            }
            st.close();
            rs.close();
        }
    }

}
