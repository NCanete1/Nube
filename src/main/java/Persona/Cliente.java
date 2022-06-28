package Persona;

public class Cliente extends Persona {

    // número telefónico, correo electrónico y dirección.
    private String direccion, correo;
    private int telefono;

    public Cliente(String rut, String nombre, String direccion, String correo, int telefono) {
        super(rut, nombre);
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
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

    @Override
    public String toString() {
        return getNombre() + ", " + getRut() + ", " + direccion + ", " + correo + ", " + telefono;
    }
}
