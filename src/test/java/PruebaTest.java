import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PruebaTest {
    private String[] rut;
    private String[] digitos;
    @BeforeEach
    public void setUp() {
    }
    @Test
    public void NormalizarTest(){
        rut = new String[]{"12.345.6785","20.104.038-8","18.456.985-K",};
        digitos= new String[]{"123456785","201040388","18456985k"};
        boolean condicion = true;
        for(int i= 0;i<rut.length;i++){
            String normalizado = Prueba.Normalizar(rut[i]);
            if(!digitos[i].equals(normalizado)){
                condicion= false;
            }
        }
        assertTrue(condicion);
    }
    @Test
    public void FuncionaTest(){
        rut = new String[]{"12.345.6785","20.104.038-8"};
        digitos= new String[]{"123456785","201040388"};
        boolean condicion = true;
        for(int i= 0;i<rut.length;i++){
            String normalizado = Prueba.Normalizar(rut[i]);
            if(digitos[i].equals(normalizado)){
                condicion= false;
            }
        }
        assertTrue(condicion);
    }

    @Test
    public void DigitoTest(){                                          //Que de el D.Verificador (Numero) 10=k, 11=0
        rut = new String[]{"20901792","11111111","12345678","13826816"};
        digitos = new String[]{"10","1","5","11"};
        boolean condicion = true;
        for(int i= 0;i<rut.length;i++){
            int digitoTest = Prueba.Digito(rut[i]);
            if(digitoTest != Integer.parseInt(digitos[i])){
                condicion= false;
            }
        }
        assertTrue(condicion);
    }
    @Test
    public void DigitoK0(){                     //Digito verificador K y 0
        rut = new String[]{"20901792","13826816"};
        digitos = new String[]{"k","0"};
        boolean condicion = true;
        for(int i= 0;i<rut.length;i++){
            String digitoTest = Prueba.DigitoVerificador(rut[i]);
            if(!digitoTest.equals(digitos[i])){
                condicion= false;
            }
        }
        assertTrue(condicion);
    }
    @Test
    public void Digito8_Test(){    //Rut menos de 10 millones (menores a 8 digitos)
        rut = new String[]{"8670342"};
        digitos = new String[]{"4"};
        boolean condicion = true;
        for(int i= 0;i<rut.length;i++){
            int digitoTest = Prueba.Digito(rut[i]);
            if(digitoTest != Integer.parseInt(digitos[i])){
                condicion= false;
            }
        }
        assertTrue(condicion);
    }
    @Test
    public void InversoTest(){
        rut = new String[]{"20901792","11111111","12345678","08670342"};
        digitos = new String[]{"29710902","11111111","87654321","24307680"};
        boolean condicion = true;
        for(int i= 0;i<rut.length;i++){
            String digitoTest = Prueba.Invertir(rut[i]);
            if(!digitoTest.equals(digitos[i])){
                condicion= false;
            }
        }
        assertTrue(condicion);
    }
    @Test
    public void RutTest(){
        rut = new String[]{"20901792","11A11111","12345678","0"};
        digitos = new String[]{"20901792","","12345678",""};
        boolean condicion = true;
        for(int i= 0;i<rut.length;i++){
            String digitoTest = Prueba.Rut(rut[i]);
            if(!digitoTest.equals(digitos[i])){
                condicion= false;
            }
        }
        assertTrue(condicion);
    }

    @AfterEach
    void tearDown() {
        rut=null;
        digitos=null;
    }
}