
package Modelos;

public class Usuario_2 {
    
    private String nombreUsuario;
    private String password;
    private String correo;
    private String nombre;
    private String apellido;
    private String cedula;

    public Usuario_2() {
    }

    public Usuario_2(String nombreUsuario, String password, String correo, String nombre, String apellido, String cedula) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.correo = correo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
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

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    
    
    
    
}
