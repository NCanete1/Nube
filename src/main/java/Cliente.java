public class Cliente {
    //nombre, dirección,
    //número telefónico, correo electrónico y rut.
    private String rut, nombre , direccion, correo;
    private int telefono;

    public Cliente(String rut, String nombre, String direccion, String correo, int telefono) {
        this.rut = rut;
        this.nombre = nombre;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    // Ayudantia 5, toda esta clase es de la ayudantia 5 pero toString es el importante.
    @Override
    public String toString() {
        return nombre + ", "+rut + ", "+ direccion + ", " + correo+ ", " + telefono;
    }
}
