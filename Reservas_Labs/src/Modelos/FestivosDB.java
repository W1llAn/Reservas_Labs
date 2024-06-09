package Modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;

public class FestivosDB {

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
    
     public ArrayList<Festivo> listaFestivosSemana(String fechaInicio, String fechaFin) {
                ArrayList<Festivo> festivos = new ArrayList<>();
        try (Connection cn = con.Conectar(); 
             PreparedStatement preparedStatement = cn.prepareStatement(
             "SELECT * FROM Festivos WHERE fecha_inicio BETWEEN '"+fechaInicio+"' AND ' "+fechaFin+"' ;"
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
