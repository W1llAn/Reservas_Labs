
package Modelos;

public class Usuario_2 {
    
    private int id;
    private String nombreUsuario;
    private String password;
    private String correo;
    private String nombre;
    private String apellido;
    private String rol;

    public Usuario_2() {
    }

    public Usuario_2(String nombreUsuario, String password, String correo, String nombre, String apellido, String rol) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.correo = correo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.rol = rol;
    }

    public Usuario_2(int id, String nombreUsuario, String password, String correo, String nombre, String apellido, String rol) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.correo = correo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.rol = rol;
    }

    


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    
    
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Usuario_2{" + "id=" + id + ", nombreUsuario=" + nombreUsuario + ", password=" + password + ", correo=" + correo + ", nombre=" + nombre + ", apellido=" + apellido + ", rol=" + rol + '}';
    }
    
    
    
}
