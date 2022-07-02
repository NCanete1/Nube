package GUI;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

import Modelo.*;

import java.awt.event.*;;

public class VentanaRegistroVehiculos extends JFrame {
    private JButton bregistrarauto;
    private JLabel text;
    private JButton bcancelar;
    private JTextField modelo;
    private JLabel labelmodelo;
    private JLabel labelmarca;
    private JLabel labeaño;
    private JLabel labelprecio;
    private JLabel labelkmrecorridos;
    private JTextField año;
    private JTextField precio;
    private JTextField kmrecorridos;
    private JComboBox marca;
    private JLabel labelcolor;
    private JComboBox color;

    public VentanaRegistroVehiculos() {
        Menu();
        pack();
        setVisible(true);
    }

    public void Menu() {
        // Cuando intentaba llamar la clases que contenian enum, no aparecian los
        // nombres, lo hice de esta manera funcionaba.
        String[] marcaitems = { "CHEVROLET", "NISSAN", "FERRARI", "SUSUKI", "TOYOTA" };
        String[] coloritems = { "BLANCO", "AZUL ", "NEGRO", "PLATEADO", "GRIS", "DORADO", "VERDE" };

        // Definiendo Componentes
        bregistrarauto = new JButton("Registrar Vehícuclo");
        text = new JLabel("Registro Vehiculo");
        bcancelar = new JButton("Cancelar");
        labelmodelo = new JLabel("Modelo:");
        labelmarca = new JLabel("Marca:");
        labeaño = new JLabel("Año:");
        labelprecio = new JLabel("Precio:");
        labelkmrecorridos = new JLabel("Kilómetros Recorridos:");
        labelcolor = new JLabel("Color:");
        modelo = new JTextField(5);
        año = new JTextField(5);
        precio = new JTextField(5);
        kmrecorridos = new JTextField(5);
        marca = new JComboBox(marcaitems);
        color = new JComboBox(coloritems);

        // set components properties
        color.setToolTipText("color");

        // Tamaño y diseño
        setPreferredSize(new Dimension(500, 500));
        setLayout(null);
        this.setTitle("Registro Vehículos");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Añadiendo Componentes
        add(bregistrarauto);
        add(text);
        add(bcancelar);
        add(modelo);
        add(labelmodelo);
        add(labelmarca);
        add(labeaño);
        add(labelprecio);
        add(labelkmrecorridos);
        add(año);
        add(precio);
        add(kmrecorridos);
        add(marca);
        add(labelcolor);
        add(color);

        // Posicionamiento
        bregistrarauto.setBounds(50, 365, 150, 30);
        text.setBounds(195, 35, 110, 30);
        bcancelar.setBounds(300, 365, 150, 30);
        modelo.setBounds(220, 90, 220, 20);
        labelmodelo.setBounds(60, 90, 100, 20);
        labelmarca.setBounds(60, 140, 45, 20);
        labeaño.setBounds(60, 190, 100, 20);
        labelprecio.setBounds(60, 240, 100, 20);
        labelkmrecorridos.setBounds(60, 290, 150, 20);
        año.setBounds(220, 190, 220, 20);
        precio.setBounds(220, 240, 220, 20);
        kmrecorridos.setBounds(220, 290, 220, 20);
        marca.setBounds(120, 140, 100, 25);
        labelcolor.setBounds(290, 140, 35, 25);
        color.setBounds(335, 140, 100, 25);

        ActionListener registrar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Automotora automotora = new Automotora();
                if (modelo.getText().isEmpty() || año.getText().isEmpty() || precio.getText().isEmpty() || kmrecorridos.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Favor de llenar los campos vacios");
                } else {
                    automotora.AñadirVehiculo(modelo.getText(), color.getSelectedItem().toString(), marca.getSelectedItem().toString(), Integer.parseInt(año.getText()), Integer.parseInt(precio.getText()), Double.parseDouble(kmrecorridos.getText()));
                    JOptionPane.showMessageDialog(null,"Vehiculo Agregado!");
                    VentanaMenu ventana = new VentanaMenu();
                    ventana.setVisible(true);
                    dispose();
                }
    
            }
        };
        ActionListener cancelar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                VentanaMenu ventana = new VentanaMenu();
                ventana.setVisible(true);
                dispose();
            }
        };

        // Añadiendo Acciones
        bregistrarauto.addActionListener(registrar);
        bcancelar.addActionListener(cancelar);
    }

}
