/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kiwar
 */
public class BlockDB {

    private Conexion con;
    public BlockDB() {
        con = new Conexion();
    }


    public ArrayList<Block> blockList() {
        ArrayList<Block> blocks = new ArrayList<>();
        try (Connection cn = con.Conectar(); PreparedStatement preparedStatement = cn.prepareStatement(
                "SELECT * FROM bloques"
        )) {

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Block block = new Block(resultSet.getInt("id"), resultSet.getString("nombre_bloque"));
                blocks.add(block);
                
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return blocks;
    }

}
