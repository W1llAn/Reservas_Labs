/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author Kiwar
 */
class Lab {
    
    private int id;
    private String name;
    private boolean type;
    private String code;
    private int floor;
    private int idBlock;

    private Lab(int id, String name, boolean type, String code, int floor, int idBlock) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.code = code;
        this.floor = floor;
        this.idBlock = idBlock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getIdBlock() {
        return idBlock;
    }

    public void setIdBlock(int idBlock) {
        this.idBlock = idBlock;
    }
    
    public static class LabBuilder{
     
    private int id;
    private String name;
    private boolean type;
    private String code;
    private int floor;
    private int idBlock;

        public LabBuilder Id(int id) {
            this.id = id;
            return this;
        }

        public LabBuilder Name(String name) {
            this.name = name;
            return this;
        }

        public LabBuilder Type(boolean type) {
            this.type = type;
            return this;
        }

        public LabBuilder Code(String code) {
            this.code = code;
            return this;
        }

        public LabBuilder Floor(int floor) {
            this.floor = floor;
            return this;
        }

        public LabBuilder IdBlock(int idBlock) {
            this.idBlock = idBlock;
            return this;
        }
    
    public Lab build(){
        return new Lab(id, name, type, code, floor, idBlock);
    }
    
}
     
}
