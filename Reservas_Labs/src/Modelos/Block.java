
package Modelos;

/**
 *
 * @author Kiwar
 */
public class Block {
    private int id;
    private String name;

    public Block() {
    }

    public Block(int id, String name) {
        this.id = id;
        this.name = name;
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
