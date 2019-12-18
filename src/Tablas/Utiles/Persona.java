package Tablas.Utiles;

public class Persona {
    // Var
    String nombre,clave,apellido,calle;
    int edad,cp,numeroTelf;
    // Constructor
    public Persona(String nombre, String clave, String apellido, String calle, int edad, int cp, int numeroTelf) {
        this.nombre = nombre;
        this.clave = clave;
        this.apellido = apellido;
        this.calle = calle;
        this.edad = edad;
        this.cp = cp;
        this.numeroTelf = numeroTelf;
    }
    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setClave(String clave) {
        this.clave = clave;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public void setCalle(String calle) {
        this.calle = calle;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public void setCp(int cp) {
        this.cp = cp;
    }
    public void setNumeroTelf(int numeroTelf) {
        this.numeroTelf = numeroTelf;
    }
    // Getters
    public String getNombre() {
        return nombre;
    }
    public String getClave() {
        return clave;
    }
    public String getApellido() {
        return apellido;
    }
    public String getCalle() {
        return calle;
    }
    public int getEdad() { return edad; }
    public int getCp() { return cp; }
    public int getNumeroTelf() {
        return numeroTelf;
    }
}
