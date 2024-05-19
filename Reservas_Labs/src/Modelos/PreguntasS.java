/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author William
 */
class PreguntasS {
    private int id_pregunta;
    private String descripcion;

    public PreguntasS(int id_pregunta, String descripcion) {
        this.id_pregunta = id_pregunta;
        this.descripcion = descripcion;
    }

    public int getId_pregunta() {
        return this.id_pregunta;
    }

    public void setId_pregunta(int id_pregunta) {
        this.id_pregunta = id_pregunta;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
