package Modelo;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Persona.Cliente;
import Persona.Vendedor;

public class Automotora {
    private List<Vehiculo> vehiculosAVenta;
    private List<Vehiculo> vehiculosVendidos;
    private List<Vendedor> vendedorList;
    private List<Cliente> clientList;

    Scanner teclado = new Scanner(System.in);
    String rut,nombre,direccion,correo;
    int edad, telefono;

    public Automotora(){
        this.vehiculosAVenta= new ArrayList<Vehiculo>();
        this.vehiculosVendidos= new ArrayList<Vehiculo>();
        this.vendedorList= new ArrayList<Vendedor>();
        this.clientList=new ArrayList<Cliente>();
    }

    public List<Vehiculo> getVehiculosAVenta() {
        return vehiculosAVenta;
    }

    public List<Vehiculo> getVehiculosVendidos() {
        return vehiculosVendidos;
    }

    public  List<Cliente> getClientList(){return clientList;}

    public List<Vendedor> getVendedorList() {
        return vendedorList;
    }


    public void añadirVehiculosPorVender(){
        this.vehiculosAVenta.add(new Vehiculo("Celerio","Gris","Suzuki",
                2018,5000000,40000.4));
        this.vehiculosAVenta.add(new Vehiculo("Hilux","Rojo","Toyota",
                2020,12000000,1000));
        this.vehiculosAVenta.add(new Vehiculo("Qashqai","Blanco","Nissan",
                2018,10590000,20000.23));
        this.vehiculosAVenta.add(new Vehiculo("Cruze","Celeste","Chevrolet",
                2010,4500000,105000.144));
        this.vehiculosAVenta.add(new Vehiculo("Sail","Gris","Chevrolet",
                2020,6000000,0));
    }
    public void venderAuto(String nombre, int año){
        for(Vehiculo auto: this.vehiculosAVenta){
            if(auto.getNombre().equals(nombre) && auto.getAño()==año){
               this.vehiculosVendidos.add(auto);
               this.vehiculosAVenta.remove(auto);
               break;
            }
        }
    }
    public List<Vehiculo> buscarAutoNombre(String nombre){
        List<Vehiculo> vehiculos= new ArrayList<Vehiculo>();
        for(Vehiculo auto : this.vehiculosAVenta){
            if(auto.getNombre().equals(nombre)){
                vehiculos.add(auto);
            }
        }
        return vehiculos;
        }

    public List<Vehiculo> buscarAutoMarca(String marca){
        List<Vehiculo> vehiculos= new ArrayList<Vehiculo>();
        for(Vehiculo auto : this.vehiculosAVenta){
            if(auto.getMarca().equals(marca)){
                vehiculos.add(auto);
            }
        }
        return vehiculos;
    }
    public void mostrarAutosLista(List<Vehiculo> vehiculos){
        for(Vehiculo auto : vehiculos){
            String datos="nombre: "+auto.getNombre()+", marca: "+auto.getMarca()+", año: "+auto.getAño()
                    +", color= "+auto.getColor()+", precio: "+auto.getPrecio()+", kmRecorridos: "+auto.getKmRecorridos();
            System.out.println(datos);
        }
    }

    //Ayudantia 4
    public void añadirVendedor(String rutAV,String nombreAV, int edadAV){
        if(ValidarRut(rutAV)) {
            try {
                rut = rutAV;
                //System.out.println("Ingresar el Nombre del Vendedor: ");
                nombre = nombreAV; //teclado.nextLine()
                //System.out.println("Ingresar la Edad del Vendedor: ");
                edad = edadAV; //teclado.nextInt()
                this.vendedorList.add(new Vendedor(rut, nombre, edad));
            } catch (Exception e) {
                System.out.println("Error Exception(Añadir Vendedor). Verifique el nombre");
            }
        }else {
            System.out.println("No se ejecuto correctamente. Añadir Vendedor");
        }
    }

    public boolean ValidarRut(String rutVR){   //void
        try {
            //System.out.println("Ingrese el rut:");
            rut= rutVR;
        }catch (Exception e){
            System.out.println("Error Exception(ValidarRut): Rut Ingresado no valido. Reintente la operación.");
            ValidarRut(rutVR);
        }
        return  (ValidadorRut.Verificacion(rut));
    }

    public void mostrarVendedorLista(List<Vendedor> vendedorList){
        for(Vendedor persona : vendedorList){
            String datos="nombre: "+persona.getNombre()+", rut: "+persona.getRut()+", edad: "+persona.getEdad();
            System.out.println(datos);
        }
    }

    //Ayudantia 5

    public void añadirCliente(String rutaC, String nombreaC, String direccionaC, String correoaC, int telefonoaC){
        if(ValidarRut(rutaC)) {
            try {
                rut = rutaC;
                //System.out.println("Ingresar el Nombre del Cliente: ");
                nombre = nombreaC; //teclado.nextLine()
                //System.out.println("Ingresar la Dirrecion del Cliente: ");
                direccion = direccionaC; //teclado.nextLine()
                //System.out.println("Ingresar el Correo del Cliente: ");
                correo = correoaC; //teclado.nextLine()
                //System.out.println("Ingresar el Telefono del Cliente: ");
                telefono = telefonoaC; //teclado.nextLine()
                this.clientList.add(new Cliente(rut,nombre,direccion, correo,telefono));
            } catch (Exception e) {
                System.out.println("Error Exception(Añadir Cliente)");
            }
        }else {
            System.out.println("No se ejecuto correctamente. Añadir Cliente");
        }
    }
    public void MostrarClientes(){
        int i=0;
        for(Cliente persona : this.clientList){
            i++;
            System.out.println("["+(i)+"]" + persona);
        }
    }
    public void ModificarCliente(String rutMC, String nombreMC, String direccionMC, String correoMC, int telefonoMC){
        MostrarClientes();
        try {
            int i= teclado.nextInt();
            do{
                if(i>this.clientList.size()||i<this.clientList.size()){
                    System.out.println("No valido reintente");
                    i=teclado.nextInt();
                }
                }while (i>this.clientList.size());
                i--;
                //System.out.println("Modificar el Rut del Cliente: ");
                this.clientList.get(i).setRut(rutMC);//teclado.nextLine()
                //System.out.println("Modificar  el Nombre del Cliente: ");
                this.clientList.get(i).setNombre(nombreMC);//teclado.nextLine()
                //System.out.println("Modificar  la Dirrecion del Cliente: ");
                this.clientList.get(i).setDireccion(direccionMC); //teclado.nextLine()
                //System.out.println("Modificar  el Correo del Cliente: ");
                this.clientList.get(i).setCorreo(correoMC); //teclado.nextLine()
                //System.out.println("Modificar  el Telefono del Cliente: ");
                this.clientList.get(i).setTelefono(telefonoMC); //teclado.nextLine()
            } catch (Exception e) {
                System.out.println("Error Exception(Modificar Cliente)");
            }
    }


    /*public void probarSistema(){
        Automotora automotora= new Automotora();
        automotora.añadirVehiculosPorVender();
        automotora.mostrarAutosLista(automotora.buscarAutoNombre("Celerio"));
        automotora.venderAuto("Celerio",2018);
        automotora.mostrarAutosLista(automotora.getVehiculosVendidos());
    }*/

        public void probarSistema(){
        Automotora automotora= new Automotora();
        automotora.añadirCliente("123456785","Juan","condorito","123@ufromail.cl",894561238);
        automotora.añadirCliente("123456785","Pedro","condorito","123@ufromail.cl",894561238);
        automotora.ModificarCliente("123456785","Axel","condes","456@ufromail.cl",894561238);
        automotora.MostrarClientes();
    }
    }


