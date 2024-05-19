package Modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;


public class LabDB {
    
    private Conexion con = new Conexion();
    
    public boolean addLab(Lab l){
        
        try (Connection cn = con.Conectar();
             PreparedStatement preparedStatement = cn.prepareStatement(
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
            System.out.println("Error: "+e);
            return false;
        }
        
    }
    
   public List<Lab> labList() {
    List<Lab> labs = new ArrayList<>();
    try (Connection cn = con.Conectar();
         PreparedStatement preparedStatement = cn.prepareStatement("SELECT * FROM laboratorios")) {
        
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            // Suponiendo que la clase Lab tiene un constructor que acepta estos parámetros
            Lab lab = new Lab.LabBuilder()
                    .Id(resultSet.getInt("id"))
                    .Name(resultSet.getString("nombre_laboratorio"))
                    .Type(resultSet.getBoolean("es_aula"))
                    .Code(resultSet.getString("codigo"))
                    .IdBlock(resultSet.getInt("id_bloque"))
                    .Floor(resultSet.getInt("piso"))
                    .build();
                    
                    /*new Lab(
                resultSet.getInt("id"), // Ajusta los nombres de las columnas según tu base de datos
                resultSet.getString("nombre"),
                resultSet.getString("ubicacion"),
                resultSet.getString("telefono")
                // Añade más atributos según tu tabla de laboratorios
            );*/
            labs.add(lab);
        }
    } catch (Exception e) {
        System.out.println("Error: " + e);
    }
    return labs;
}
        
}
