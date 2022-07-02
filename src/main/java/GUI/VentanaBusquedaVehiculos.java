package GUI;

import Modelo.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Modelo.Automotora;

public class VentanaBusquedaVehiculos extends JFrame {
    private JButton buscarboton;
    private JButton bcancelar;
    private JTextField modelo;
    private JLabel labelmodelo;
    private JLabel labelmarca;
    private JComboBox marca;

    public VentanaBusquedaVehiculos() {
        Menu();
        MenuEtiqueta();
        pack();
        setVisible(true);
    }

    public void Menu() {

        // Definiendo Componentes
        buscarboton = new JButton("Buscar Vehículo");
        bcancelar = new JButton("Cancelar");
        modelo = new JTextField(5);

        String[] marcaItems = { "CHEVROLET", "NISSAN", "FERRARI", "SUSUKI", "TOYOTA" };
        marca = new JComboBox(marcaItems);

        // Tamaño y diseño
        setPreferredSize(new Dimension(500, 500));
        setLayout(null);
        this.setTitle("Buscar Vehículo");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Añadiendo Componentes
        add(buscarboton);
        add(bcancelar);
        add(modelo);
        add(marca);

        // Posicionamiento
        buscarboton.setBounds(50, 250, 150, 30);
        bcancelar.setBounds(295, 250, 150, 30);
        modelo.setBounds(220, 90, 220, 20);
        marca.setBounds(220, 180, 160, 20);

        // Listener
        ActionListener buscar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Automotora automotora = new Automotora();
                String[] columnas = { "Modelo", "Color", "Marca", "Año", "Precio", "Km.Recorridos" };
                String[][] datos = null;
                VentanaTabla ventana = new VentanaTabla(datos, columnas);
                ventana.setVisible(true);
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
        buscarboton.addActionListener(buscar);
        bcancelar.addActionListener(cancelar);

    }

    public void MenuEtiqueta() {
        // Definiendo Componentes
        labelmodelo = new JLabel("Modelo:");
        labelmarca = new JLabel("Marca:");

        // Add
        add(labelmodelo);
        add(labelmarca);

        // Posicionamiento
        labelmodelo.setBounds(80, 90, 100, 20);
        labelmarca.setBounds(80, 175, 45, 20);

    }

}
