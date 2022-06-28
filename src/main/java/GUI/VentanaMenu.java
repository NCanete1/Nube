package GUI;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;

public class VentanaMenu extends JFrame {
    private JButton registrarcliente;
    private JLabel text;
    private JButton registrarauto;
    private JButton buscarauto;
    private JButton venderauto;
    private JButton bsalir;

    public VentanaMenu() {
        this.setTitle("Automotora");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        MenuBotones();
        MenuEtiqueta();
        pack();
        setVisible(true);
    }
    public void MenuEtiqueta() {
        // Definiendo Componentes
        text = new JLabel("Menu Automotora");
         // Añadiendo Componentes
        add(text);
         // Posicionamiento
        text.setBounds(70, 35, 135, 35);
    }

    public void MenuBotones() {
        // Definiendo Componentes
        registrarcliente = new JButton("Registrar Cliente");
        registrarauto = new JButton("Registrar Vehiculo");
        buscarauto = new JButton("Buscar Vehiculo");
        venderauto = new JButton("Vender Vehiculo");
        bsalir = new JButton("Salir");

        // Tamaño y diseño
        setPreferredSize(new Dimension(500, 500));
        setLayout(null);

        // Añadiendo Componentes
        add(registrarcliente);
        add(registrarauto);
        add(buscarauto);
        add(bsalir);

        // Posicionamiento
        registrarcliente.setBounds(165, 100, 165, 40);
        registrarauto.setBounds(165, 170, 165, 40);
        buscarauto.setBounds(165, 240, 165, 40);
        bsalir.setBounds(165, 320, 165, 40);
        
        //Listener
        ActionListener registrocliente= new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                VentanaRegistroClientes ventana= new VentanaRegistroClientes();
                ventana.setVisible(true);
                dispose();
            }
        };
        ActionListener registrovehiculo= new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                VentanaRegistroVehiculos ventana= new VentanaRegistroVehiculos();
                ventana.setVisible(true);
                dispose();
            }
        };
        ActionListener busquedavehiculo= new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                VentanaBusquedaVehiculos ventana= new VentanaBusquedaVehiculos();
                ventana.setVisible(true);
                dispose();
            }
        };
        ActionListener salir= new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                System.exit(WIDTH);
                dispose();
            }
        };
        
        //Añadiendo Acciones
        registrarcliente.addActionListener(registrocliente);
        registrarauto.addActionListener(registrovehiculo);
        buscarauto.addActionListener(busquedavehiculo);
        bsalir.addActionListener(salir);
    
    }
    

}

