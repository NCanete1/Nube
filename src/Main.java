import java.util.Scanner;

public class Main{
    public static String Invertir(String rut){
        StringBuilder rut_Inv = new StringBuilder(rut);
        rut= rut_Inv.reverse().toString();  // cambiar de vuelta al tipo de variable String
        return rut;
    }
    public static int Verificacion1(String rut){   //Se adquiere la suma de la multiplicaciones para un paso más tarde.
        char[] cadena= Invertir(rut).toCharArray();
        int sum=0;
        int number;
        int multipicador =2;            //variables, multiplicador va de 2 al 7.
        for(int i=0;i<=7;i=i+1){ //Recorre la cadena
            number=Integer.parseInt(String.valueOf(cadena[i])); //convierte el char a String y de String a Int. Muchas vuelta? posiblemente si, conozco una forma mas simple? no.
            sum+= number * (multipicador);
            multipicador += 1;
            if (multipicador > 7){ //en caso que supere al 7 se reinicia el multiplicador.
                multipicador = 2;
            }
        }
        return sum;
    }

    public static int Verificacion2(String rut){
        int valor1=Verificacion1(rut); // el resultado de sum. Verificacion1.
        int valor2= valor1/11; //El resultado puede llegar a dar decimales pero solo se pide el valor entero, por eso el Int.
        valor2= valor2*11;
        return valor1-valor2;
    }

    public static String DigitoVerificador(String rut){
        int digito= Verificacion2(rut);
        digito= 11-digito;
        String verificado;
        if(digito==10) {
            verificado="k";
        }else if(digito==11) {
            verificado = "0";
        }else{
            verificado=String.valueOf(digito);
        }
        return verificado;
    }
    public static void EjecutarPruebas(){
        System.out.print("Rut: 20901792 - El DigitoV es: "+DigitoVerificador("20901792")+ "\n"); //k
        System.out.print("Rut: 12345678 - El DigitoV es: "+DigitoVerificador("12345678")+ "\n"); //5
        System.out.print("Rut: 20104038 - El DigitoV es: "+DigitoVerificador("20104038")+ "\n"); //8
        System.out.print("Rut: 11111111 - El DigitoV es: "+DigitoVerificador("11111111")+ "\n"); //1
    }
    public static void Ejecutar(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese RUT sin digito verificador");
        String rut= teclado.next();
        System.out.println("Rut Ingresado: "+ rut +" - El DigitoV es: "+ DigitoVerificador(rut) );
    }
    public static void main(String[] args) {
        EjecutarPruebas();
    }
}
