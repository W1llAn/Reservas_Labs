/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.util.ArrayList;

public class Almacen {

    private static Almacen instance;
    private ArrayList<Lab> listaLab = new ArrayList<>();
    public ArrayList<Responsable> listResponsables= new ArrayList<>();

    public static Almacen getInstance() {
        if (instance == null) {
            instance = new Almacen();
        }
        return instance;
    }

    public ArrayList<Lab> getListaLab() {
        return listaLab;
    }

    public void agregarLabLista(Lab lab) {
        listaLab.add(lab);
    }
}
