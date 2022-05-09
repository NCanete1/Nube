import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AutomotoraTest {
    private String rut;
    private String nombre;
    private int edad;
    Automotora auto = new Automotora();
    List<Vendedor> vendedorList= auto.getVendedorList();

    @BeforeEach
    public void setUp() {
        rut="12345678-5";
        nombre="Tulio Triviño";
        edad =71;
    }
    @Test
    public void ValidarRutTest(){
    assertTrue(auto.ValidarRut(rut));
}

    @Test
    public void AñadirVendedorTest(){
        auto.añadirVendedor(rut,nombre,edad);
        auto.mostrarVendedorLista(vendedorList);

    }
}