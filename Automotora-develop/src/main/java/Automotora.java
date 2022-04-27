import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Automotora {
    private List<Vehiculo> vehiculosAVenta;
    private List<Vehiculo> vehiculosVendidos;
    private List<Vendedor> vendedorList;
    private Scanner teclado = new Scanner(System.in);
    String rut;     //private?  
    String nombre;
    int edad;

    public Automotora(){
        this.vehiculosAVenta= new ArrayList<Vehiculo>();
        this.vehiculosVendidos= new ArrayList<Vehiculo>();
        this.vendedorList= new ArrayList<Vendedor>();
    }

    public List<Vehiculo> getVehiculosAVenta() {
        return vehiculosAVenta;
    }

    public List<Vehiculo> getVehiculosVendidos() {
        return vehiculosVendidos;
    }

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
    public List<Vehiculo> buscarAutoNombreForBasico(String nombre){
        List<Vehiculo> vehiculos= new ArrayList<>();
        for(int i=0; i<this.vehiculosAVenta.size(); i++){
            if(this.vehiculosAVenta.get(i).getNombre().equals(nombre)){
                vehiculos.add(this.vehiculosAVenta.get(i));
            }
        }
        return vehiculos;
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
    public void añadirVendedor(String rutAV,String nombreAV, int edadAV){
        if(ValidarRut(rutAV)) {
            try {
                rut = rutAV;
                System.out.println("Ingresar el Nombre del Vendedor: ");
                nombre = nombreAV; //teclado.nextLine()
                System.out.println("Ingresar la Edad del Vendedor: ");
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
            System.out.println("Ingrese el rut:");
            rut= rutVR;
        }catch (Exception e){
            System.out.println("Error Exception(ValidarRut): Rut Ingresado no valido. Reintente la operación.");
            ValidarRut(rutVR);
        }
        return  (ValidadorRut.Verificacion(rut));// añadirVendedor(rut,nombre,edad);
    }

    public void mostrarVendedorLista(List<Vendedor> vendedorList){
        for(Vendedor persona : vendedorList){
            String datos="nombre: "+persona.getNombre()+", rut: "+persona.getRut()+", edad: "+persona.getEdad();
            System.out.println(datos);
        }
    }

    public void probarSistema(){
        Automotora automotora= new Automotora();
        automotora.añadirVehiculosPorVender();
        automotora.mostrarAutosLista(automotora.buscarAutoNombre("Celerio"));
        automotora.venderAuto("Celerio",2018);
        automotora.mostrarAutosLista(automotora.getVehiculosVendidos());
    }
    }


