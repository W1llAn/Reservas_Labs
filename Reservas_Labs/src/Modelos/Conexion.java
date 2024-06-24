/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author William
 */
public class Conexion {

    private static final String url = "jdbc:sqlserver:99//serv-reserv.database.windows.net:1433;database=reservas_labs;user=administrador@serv-reserv;password=Reservas_04BDD;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
    private static final String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static Connection con;

    public Connection Conectar() {
        con = null; //borrar la conexion-siempre hay que poner null en cada nueva conexion
        try {
            Class.forName(driver); //devuelve sql y necesito forzar ah que utilice la conexion mysql
            con = (Connection) DriverManager.getConnection(url);
            System.out.println("Se conecto correctamente a la base");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("No se pudo conectar con la base de datos");
            System.out.println(e); //error al conectar con la base de datos.
        }
        return con;
    }
}
