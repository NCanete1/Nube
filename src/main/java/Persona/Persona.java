package Persona;

import Modelo.ValidadorRut;

public class Persona {

    private String rut, nombre;

    public Persona(String rut, String nombre) {
        if (ValidadorRut.Verificacion(rut)) {
            this.rut = rut;
        } else {
            this.rut = null;
        }
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        if (ValidadorRut.Verificacion(rut)) {
            this.rut = rut;
        } else {
            this.rut = null;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
