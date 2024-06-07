/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class  UsuarioSesion {
    private static String nombre_Usuario;
    private static int id_usuario;
    private static ArrayList<Block> bloques = new ArrayList<>();

    // Getter para el nombre del usuario
    public static String getNombreUsuario() {
        return nombre_Usuario;
    }

    // Setter para el nombre del usuario
    public static void setNombreUsuario(String nombreUsuario) {
        UsuarioSesion.nombre_Usuario = nombreUsuario;
    }

    // Getter para el ID del usuario
    public static int getIdUsuario() {
        return id_usuario;
    }

    // Setter para el ID del usuario
    public static void setIdUsuario(int idUsuario) {
        UsuarioSesion.id_usuario = idUsuario;
    }
}
