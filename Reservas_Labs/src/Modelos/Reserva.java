
package Modelos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ASUS
 */
public class Reserva {
  private String laboratorio,horaFin,horaInicio,descripcion,observacionLaboratorio; 
  private Date fechaReserva; 
  private Recursos rec = new Recursos();
//  
//  
//  
//  
//    //Consultas SQL-------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//
//  //GUARDAR CLIENTE-------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//    public void guardarReserva(Reserva res) throws SQLException {
//        Conexion conec = new Conexion();
//        Connection con = conec.Conectar();
//        if (con == null) {
//            rec.aviso("No tiene conexion RECUERDE cada accion que realize en el programa no se va a guardar");
//        } else {
//            Statement stmt = con.createStatement();
//            String consulta = "INSERT INTO reservas (cedula,nombre,ciudadID,direccion) VALUES('"+c.getCedula()+"','"+ c.getNombre()+"','"+c.getCiudad().getCodigo()+"','"+ c.getDireccion()+"');";
//            stmt.executeUpdate(consulta);
//            stmt.close();
//            con.close();
//        }
//    }
      
}
