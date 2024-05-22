
package Modelos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Responsable {
   private int id_responsable;
   private String cedula;
  private Recursos rec;
    public Responsable() {
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
    //CONSULTA DE CARRERAS EN LA BASE DE DATOS
     public void consultaResponsables() throws SQLException, ClassNotFoundException {
        Conexion conexion = new Conexion();
        Connection con = conexion.Conectar();
        if (con == null) {
            rec.aviso("No tiene conexion RECUERDE cada accion que realize en el programa no se va a guardar");
        } else {
            con = conexion.Conectar();
            Statement st = con.createStatement();
            ResultSet rs = null;
            String consulta = "SELECT id_responsable,cedula FROM responsables;";
            rs = st.executeQuery(consulta);
            while (rs.next()) {
               Responsable responsable = new Responsable();
               responsable.setId_responsable(rs.getInt("id_responsable"));
               responsable.setCedula(rs.getString("cedula"));
               Almacen.getInstance().listResponsables.add(responsable);
            }
            st.close();
            rs.close();
        }
    }
}
