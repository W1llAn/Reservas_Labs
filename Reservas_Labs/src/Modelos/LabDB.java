package Modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;


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
    
        
}
