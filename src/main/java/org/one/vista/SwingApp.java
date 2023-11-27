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
        JButton convertirButton = new JButton("Convertir");

        //Panel de botones:
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(convertirButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Establecer estilos para los botones
        convertirButton.setBackground(new Color(46, 204, 113));
        convertirButton.setForeground(Color.WHITE);
        convertirButton.setFocusPainted(false);

        //ActionListener para los botones:

        //convertirButton.addActionListener(e -> convertirMoneda);

        //private void convertirMoneda(){

        }





    }



}
