package Persona;

public class Vendedor extends Persona {

    private int edad;

    public Vendedor(String rut, String nombre, int edad) {
        super(rut, nombre);
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return getNombre() + ", " + getRut() + ", " + edad;
    }
}
