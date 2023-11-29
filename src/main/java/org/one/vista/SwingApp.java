package org.one.vista;

import org.one.model.Moneda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingApp extends JFrame {

    //private JPanel contentPane;
    private JTextField campoValor;
    private JTextField campoResultado;
    private JButton btnConvertir;
    //private Moneda moneda;

    public SwingApp(){
        setTitle("ConvertidorONE");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,600);

        getContentPane().setLayout(new BorderLayout(0,0));

        //Panel general contenedor
        JPanel panelPrincipal = new JPanel();
        getContentPane().add(panelPrincipal, BorderLayout.CENTER);
        panelPrincipal.setLayout(new BorderLayout(0, 0));

        //Panel superior con información sobre la App
        JPanel panelSuperior = new JPanel();
        panelSuperior.setBackground(new Color(50,50,50));
        panelPrincipal.add(panelSuperior, BorderLayout.NORTH);

        //Panel botones
        JPanel panelInferior = new JPanel();
        panelInferior.setBackground(new Color(50,50,50));
        panelPrincipal.add(panelInferior, BorderLayout.SOUTH);

        //Botón de conversión
        JButton btnConvertir = new JButton("Convertir");
        panelInferior.add(btnConvertir);

        //Panel Información
        JPanel panelCentral = new JPanel();
        panelCentral.setBackground(new Color(154,205,50));
        panelPrincipal.add(panelCentral, BorderLayout.CENTER);

        //Campos de texto para recibir y mostrar información:
        JLabel lblValor = new JLabel("Valor a convertir:");
        campoValor = new JTextField();
        campoValor.setColumns(10);

        JLabel lblResultado = new JLabel("Resultado:");
        campoResultado = new JTextField();
        campoResultado.setColumns(10);
        campoResultado.setEditable(false); // Para que sea editable

        panelCentral.add(lblValor);
        panelCentral.add(campoValor);
        panelCentral.add(lblResultado);
        panelCentral.add(campoResultado);

        panelPrincipal.add(panelCentral);

        // Instancia de la clase Moneda
        Moneda moneda = new Moneda();

        // ActionListener para el botón de convertir
        btnConvertir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obtener el valor ingresado en el campo
                try {
                    double valor = Double.parseDouble(campoValor.getText());

                    // Llamar al método convertirMoneda de la clase Moneda
                    double resultado = moneda.convertirMoneda(valor);

                    // Mostrar el resultado en el campo de resultado
                    campoResultado.setText(String.valueOf(resultado));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(SwingApp.this, "Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


    }

    /**
     * Curso de Layouts en Java de Cristian Henao:
     * https://www.youtube.com/playlist?list=PLAg6Lv5BbjjfAWETI3j3D78ZaophRGhrs
     *
     * Video para organizar la APP con Java Swing:
     * https://www.youtube.com/watch?v=hIBEmpV30Ao
     * */

}

/*import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import javax.swing.table.DefaultTableModel;

public class SwingApp extends JFrame {

    //private JPanel contentPane;

    private JTextField campoValor;
    private JTextField campoResultado;
    private JButton btnConvertir;
    private Moneda moneda;

    public SwingApp() {

        // Configuración del JFrame
        setTitle("ConvertidorONE");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setSize(600,600);

        //Configuración del JPanel
        //getContentPane().setLayout(new BorderLayout(0,0));

        JPanel panelPrincipal = new JPanel();
        getContentPane().add(panelPrincipal, BorderLayout.CENTER);
        panelPrincipal.setLayout(new BorderLayout(0,0));



        //setLayout(new GridLayout(2, 1));


        // Panel para los campos de entrada y resultado
        //JPanel panelCampos = new JPanel(new GridLayout(2, 2));

        JPanel panelSuperior = new JPanel();
        panelPrincipal.add(panelSuperior, BorderLayout.NORTH);
        setSize(550,500);
        setBackground(Color.blue);
        setVisible(true);

        JLabel lblValor = new JLabel("Valor a convertir:");
        campoValor = new JTextField();
        JLabel lblResultado = new JLabel("Resultado:");
        campoResultado = new JTextField();
        campoResultado.setEditable(false); // Para que sea editable

        panelSuperior.add(lblValor);
        panelSuperior.add(campoValor);
        panelSuperior.add(lblResultado);
        panelSuperior.add(campoResultado);

        add(panelSuperior);

        // Panel para el botón de conversión
        JPanel panelBoton = new JPanel();
        panelPrincipal.add(panelBoton, BorderLayout.SOUTH);
        btnConvertir = new JButton("Convertir");
        panelBoton.add(btnConvertir);
        add(panelBoton);

        // Instancia de la clase Moneda
        moneda = new Moneda();

        // ActionListener para el botón de convertir
        btnConvertir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obtener el valor ingresado en el campo
                try {
                    double valor = Double.parseDouble(campoValor.getText());

                    // Llamar al método convertirMoneda de la clase Moneda
                    double resultado = moneda.convertirMoneda(valor);

                    // Mostrar el resultado en el campo de resultado
                    campoResultado.setText(String.valueOf(resultado));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(SwingApp.this, "Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Mostrar la ventana
        //pack();
        //setLocationRelativeTo(null);
        //setVisible(true);
    }

    // Clase Moneda (simulada)
    private class Moneda {
        // Método de conversión (simulado)
        public double convertirMoneda(double valor) {
            // Implementación de la conversión aquí
            // Esta es una implementación simulada para el ejemplo
            // Reemplaza esto con tu lógica de conversión real
            return valor * 2; // Por ejemplo, simplemente se duplica el valor
        }
    }
}*/
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
/*
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
        //JTable tablaMonedas = new JTable();
        //JScrollPane scrollPane = new JScrollPane(tablaMonedas);
        //add(scrollPane, BorderLayout.CENTER);

        //Campos de texto
        JTextField ingresarTexto = new JTextField();

        //Panel campos de texto
        JPanel textPanel = new JPanel();
        textPanel.add(ingresarTexto);
        add(textPanel, BorderLayout.SOUTH);


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
*/
