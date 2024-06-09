package Modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;

public class LabDB {

    private Conexion con;

    public LabDB() {
        con = new Conexion();
    }

    public boolean addLab(Lab l) {

        try (Connection cn = con.Conectar(); PreparedStatement preparedStatement = cn.prepareStatement(
                "INSERT INTO laboratorios ( codigo,nombre_laboratorio, piso, id_bloque, tipo) VALUES (?, ?, ?, ?, ?)"
        )) {

            // Establecer los parámetros
            preparedStatement.setString(1, l.getCode());
            preparedStatement.setString(2, l.getName());
            preparedStatement.setInt(3, l.getFloor());
            preparedStatement.setInt(4, l.getIdBlock());
            preparedStatement.setString(5, l.isType()); // false para lab, true para aula

            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return false;
        }

    }

    public ArrayList<Lab> labList() {
        ArrayList<Lab> labs = new ArrayList<>();
        System.out.println("Estoy en la consulta labs");
        try (Connection cn = con.Conectar(); PreparedStatement preparedStatement = cn.prepareStatement(
                "SELECT l.*,b.nombre_bloque AS name FROM laboratorios l,bloques b where l.id_bloque=b.id"
        )) {

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Lab lab = new Lab.LabBuilder()
                        .Id(resultSet.getInt("id_laboratorio"))
                        .Name(resultSet.getString("nombre_laboratorio"))
                        .Type(resultSet.getString("tipo"))
                        .Code(resultSet.getString("codigo"))
                        .IdBlock(resultSet.getInt("id_bloque"))
                        .BlockName(resultSet.getString("name"))
                        .Floor(resultSet.getInt("piso"))
                        .build();
                labs.add(lab);
                Almacen.getInstance().listaLabo.add(lab);
            }
        } catch (Exception e) {
            System.out.println("Error al cargar lista de laboratorios: " + e);
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
        String sql = "UPDATE laboratorios SET nombre_laboratorio = ?, id_bloque = ?, tipo = ? WHERE codigo = ?";

        try (Connection cn = con.Conectar(); PreparedStatement preparedStatement = cn.prepareStatement(sql)) {

            // Establecer los parámetros
            preparedStatement.setString(1, lb.getName());
            preparedStatement.setInt(2, lb.getIdBlock());
            preparedStatement.setString(3, lb.isType());
            preparedStatement.setString(4, lb.getCode());

            // Ejecutar la actualización
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0; // Devuelve true si al menos una fila fue actualizada
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteLab(String id) {
        String sql = "DELETE FROM laboratorios WHERE codigo = ?";

        try (Connection cn = con.Conectar(); PreparedStatement preparedStatement = cn.prepareStatement(sql)) {

            // Establecer los parámetros
            preparedStatement.setString(1, id);
            // Ejecutar la actualización
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0; // Devuelve true si al menos una fila fue actualizada
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }
    
    
    public void llenarBloques(){
        ArrayList<Lab> laboratorios = this.labList();
        for (int i = 0; i < laboratorios.size(); i++) {
            switch(laboratorios.get(i).getIdBlock()){
                case 1:
                    UsuarioSesion.getBloques().get(0).setLaboratorios(laboratorios.get(i));
                break;
                case 2:
                    UsuarioSesion.getBloques().get(1).setLaboratorios(laboratorios.get(i));
                break;
                case 3:
                    UsuarioSesion.getBloques().get(2).setLaboratorios(laboratorios.get(i));
                break;
                case 4:
                    UsuarioSesion.getBloques().get(3).setLaboratorios(laboratorios.get(i));
                break;
            }
        }
    }
}
