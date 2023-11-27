package org.one.vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class SwingApp extends JFrame {

    public SwingApp() {
        //Configuración ventana:
        setTitle("ConvertidorONE");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 230);

        //Tabla ?
        JTable tablaMonedas = new JTable();
        JScrollPane scrollPane = new JScrollPane(tablaMonedas);
        add(scrollPane, BorderLayout.CENTER);

        //Botones para realizar acciones
        JButton agregarButton = new JButton("Convertir");


    }



}
