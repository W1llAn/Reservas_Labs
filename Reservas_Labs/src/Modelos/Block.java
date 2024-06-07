
package Modelos;

import java.util.ArrayList;

/**
 *
 * @author Kiwar
 */
public class Block {
    private int id;
    private String name;
    private ArrayList<Lab> laboratorios = new ArrayList<>();

    public Block() {
    }

    public Block(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public ArrayList<Lab> getLaboratorios() {
        return this.laboratorios;
    }

    public void setLaboratorios(ArrayList<Lab> laboratorios) {
        this.laboratorios = laboratorios;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name ;
    }
    
    
    
}
