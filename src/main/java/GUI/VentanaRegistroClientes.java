package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class VentanaRegistroClientes extends JFrame {
    private JButton bregistrarcliente;
    private JLabel text;
    private JButton bcancelar;
    private JTextField nombre;
    private JLabel labelnombre;
    private JLabel labelrut;
    private JLabel labedireccion;
    private JLabel labelcorreo;
    private JLabel labeltelefono;
    private JTextField rut;
    private JTextField direccion;
    private JTextField correo;
    private JTextField telefono;

    public VentanaRegistroClientes() {
        Menu();
        pack();
        setVisible(true);
    }

    public void Menu() {
        // Definiendo Componentes
        bregistrarcliente = new JButton ("Registrar Cliente");
        text = new JLabel ("Registro Cliente");
        bcancelar = new JButton ("Cancelar");
        nombre = new JTextField (5);
        labelnombre = new JLabel ("Nombre");
        labelrut = new JLabel ("Rut");
        labedireccion = new JLabel ("Dirección");
        labelcorreo = new JLabel ("Correo");
        labeltelefono = new JLabel ("Telefono");
        rut = new JTextField (5);
        direccion = new JTextField (5);
        correo = new JTextField (5);
        telefono = new JTextField (5);

        // Tamaño y diseño
        setPreferredSize (new Dimension (500, 500));
        setLayout (null);
        this.setTitle("Registro Clientes");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Añadiendo Componentes
        add (bregistrarcliente);
        add (text);
        add (bcancelar);
        add (nombre);
        add (labelnombre);
        add (labelrut);
        add (labedireccion);
        add (labelcorreo);
        add (labeltelefono);
        add (rut);
        add (direccion);
        add (correo);
        add (telefono);

        // Posicionamiento
        bregistrarcliente.setBounds (50, 365, 150, 30);
        text.setBounds (195, 35, 95, 30);
        bcancelar.setBounds (300, 365, 150, 30);
        nombre.setBounds (220, 90, 220, 20);
        labelnombre.setBounds (80, 90, 100, 20);
        labelrut.setBounds (80, 140, 100, 20);
        labedireccion.setBounds (80, 190, 100, 20);
        labelcorreo.setBounds (80, 240, 100, 20);
        labeltelefono.setBounds (80, 290, 100, 20);
        rut.setBounds (220, 140, 220, 20);
        direccion.setBounds (220, 195, 220, 20);
        correo.setBounds (220, 240, 220, 20);
        telefono.setBounds (220, 290, 220, 20);

        ActionListener registrar= new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                
            }
        };
        ActionListener cancelar= new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                VentanaMenu ventana= new VentanaMenu();
                ventana.setVisible(true);
                dispose();
            }
        };
        
        //Añadiendo Acciones
        bregistrarcliente.addActionListener(registrar);
        bcancelar.addActionListener(cancelar);
    }

}
