package Modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

public class LabDB {

    private Conexion con;

    public LabDB() {
        con = new Conexion();
    }

    public boolean addLab(Lab l) {

        try (Connection cn = con.Conectar(); PreparedStatement preparedStatement = cn.prepareStatement(
                "INSERT INTO laboratorios ( codigo,nombre_laboratorio, piso, id_bloque, es_aula) VALUES (?, ?, ?, ?, ?)"
        )) {

            // Establecer los parámetros
            preparedStatement.setString(1, l.getCode());
            preparedStatement.setString(2, l.getName());
            preparedStatement.setInt(3, l.getFloor());
            preparedStatement.setInt(4, l.getIdBlock());
            preparedStatement.setBoolean(5, l.isType()); // false para lab, true para aula

            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return false;
        }

    }

    public ArrayList<Lab> labList() {
        ArrayList<Lab> labs = new ArrayList<>();
        try (Connection cn = con.Conectar(); PreparedStatement preparedStatement = cn.prepareStatement(
                "SELECT l.*,b.nombre_bloque AS name FROM laboratorios l,bloques b where l.id_bloque=b.id"
        )) {

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Lab lab = new Lab.LabBuilder()
                        .Id(resultSet.getInt("id_laboratorio"))
                        .Name(resultSet.getString("nombre_laboratorio"))
                        .Type(resultSet.getBoolean("es_aula"))
                        .Code(resultSet.getString("codigo"))
                        .IdBlock(resultSet.getInt("id_bloque"))
                        .BlockName(resultSet.getString("name"))
                        .Floor(resultSet.getInt("piso"))
                        .build();

                labs.add(lab);
                Almacen.getInstance().listaLabo.add(lab);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return labs;
    }

   
    /*
    public static void main(String[] args) {
        LabDB lb = new LabDB();
        //List<Lab> labs = 
        lb.labList().forEach(lab->System.out.println(lab.getCode()+lab.getName()+lab.getBlockName()+lab.isLab()+lab.isType()+lab.isLab()));
                
    }*/
    
    public boolean editLab(Lab lb) {
        String sql = "UPDATE laboratorios SET nombre_laboratorio = ?, piso = ?, id_bloque = ?, es_aula = ?, codigo = ? WHERE id_laboratorio = ?";

        try (Connection cn = con.Conectar(); PreparedStatement preparedStatement = cn.prepareStatement(sql)) {

            // Establecer los parámetros
            preparedStatement.setString(1, lb.getName());
            preparedStatement.setInt(2, lb.getFloor());
            preparedStatement.setInt(3, lb.getIdBlock());
            preparedStatement.setBoolean(4, lb.isType());
            preparedStatement.setString(5, lb.getCode());
            preparedStatement.setInt(6, lb.getId());

            // Ejecutar la actualización
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0; // Devuelve true si al menos una fila fue actualizada
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteLab(int id) {
        String sql = "DELETE FROM laboratorios WHERE id_laboratorio = ?";

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
