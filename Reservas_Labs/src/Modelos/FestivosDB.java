package Modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FestivosDB {
    private Recursos rec = new Recursos();
    private Conexion con;

    public FestivosDB() {
        con = new Conexion();
    }

    public boolean insertarDiaFestivo(Festivo f) {

        try ( Connection cn = con.Conectar();
             PreparedStatement preparedStatement = cn.prepareStatement(
             "INSERT INTO Festivos ( descripcion, fecha_inicio, fecha_fin) VALUES (?, ?, ?)"
        )) {

            // Establecer los parámetros
            preparedStatement.setString(1, f.getNombre());
            preparedStatement.setString(2, f.getFechaInicio());
            preparedStatement.setString(3, f.getFechaFin());

            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return false;
        }
    }

    public ArrayList<Festivo> listaFestivos() {
                ArrayList<Festivo> festivos = new ArrayList<>();
        try (Connection cn = con.Conectar(); 
             PreparedStatement preparedStatement = cn.prepareStatement(
             "SELECT id_festivos, descripcion, fecha_inicio, fecha_fin  FROM Festivos"
        )) {

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Festivo f = new Festivo();
                f.setId(resultSet.getInt(1));
                f.setNombre(resultSet.getString(2));
                f.setFechaInicio(resultSet.getString(3));
                f.setFechaFin(resultSet.getString(4));
                festivos.add(f);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return festivos;
    }
    //"SELECT * FROM Festivos WHERE fecha_inicio BETWEEN '"+fechaInicio+"' AND ' "+fechaFin+"' ;"
     public ArrayList<Festivo> listaFestivosSemana(String fechaInicio, String fechaFin) throws SQLException {
        ArrayList<Festivo> festivos = new ArrayList<>();
        Conexion conexion = new Conexion();
        Connection con = conexion.Conectar();
        if (con == null) {
            rec.aviso("No tiene conexion RECUERDE cada accion que realize en el programa no se va a guardar");
        } else {
            Statement st = con.createStatement();
            ResultSet rs = null;
            String consulta = "SELECT  id_festivos, descripcion, fecha_inicio, fecha_fin FROM Festivos WHERE fecha_inicio BETWEEN '"+fechaInicio+"' AND '"+fechaFin+"' ;";
            rs = st.executeQuery(consulta);
            while (rs.next()) {
                Festivo fest = new Festivo();
                fest.setId(rs.getInt("id_festivos"));
                fest.setFechaInicio(rs.getString("fecha_inicio"));
                fest.setFechaFin(rs.getString("fecha_fin"));
                fest.setNombre(rs.getString("descripcion"));
                festivos.add(fest);
            }
            st.close();
            rs.close();
        }
         System.out.println("festivos "+festivos.size());
        return festivos;
    }

    public boolean eliminarDiaFestivo(int id) {
                String sql = "DELETE FROM Festivos WHERE id_festivos = ?";
        try (Connection cn = con.Conectar(); PreparedStatement preparedStatement = cn.prepareStatement(sql)) {
            // Establecer los parámetros
            preparedStatement.setInt(1, id);
            // Ejecutar la actualización
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0; // Devuelve true si al menos una fila fue actualizada
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }
}
