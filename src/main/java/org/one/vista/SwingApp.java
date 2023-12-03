package org.one.vista;

import org.one.model.Moneda;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingApp extends JFrame {

    //Variables:
    private JTextField textCantidad;
    private JTextField textResultado;


    public SwingApp() {
        setTitle("ConvertidorONE");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 200, 600, 450);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        //Panel general principal
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setBackground(new Color(119, 118, 123));
        contentPane.add(panelPrincipal, BorderLayout.CENTER);
        panelPrincipal.setLayout(new BorderLayout(0, 0));

        //Panel superior botones seleccionar monedas o temperaturas
        JPanel panelBtnSeleccion = new JPanel();
        panelBtnSeleccion.setBackground(new Color(36, 31, 49));
        panelPrincipal.add(panelBtnSeleccion, BorderLayout.NORTH);

        //Botones de panel superior:
        JButton btnSelecMoneda = new JButton("Monedas");
        btnSelecMoneda.setPreferredSize(new Dimension(134, 25));
        btnSelecMoneda.setBackground(new Color(192, 28, 40));
        panelBtnSeleccion.add(btnSelecMoneda);

        //Agregar cuando sea necesario convertir temperaturas.
        /*JButton btnSelecTemperatura = new JButton("Temperaturas");
        btnSelecTemperatura.setPreferredSize(new Dimension(134,25));
        btnSelecTemperatura.setBackground(new Color(192, 28, 40));
        panelBtnSeleccion.add(btnSelecTemperatura);*/

        //Panel inferior pie de App:
        JPanel panelPie = new JPanel();
        panelPie.setBackground(new Color(36, 31, 49));
        panelPrincipal.add(panelPie, BorderLayout.SOUTH);

        JLabel lblPie = new JLabel("Proyecto ONE - Oracle Next Education");
        lblPie.setForeground(new Color(246, 245, 244));
        panelPie.add(lblPie);

        //Panel BorderLayout para mostrar paneles Absolutos:
        JPanel panelPantalla = new JPanel();
        panelPantalla.setBackground(new Color(94, 92, 100));
        panelPrincipal.add(panelPantalla, BorderLayout.CENTER);
        panelPantalla.setLayout(new BorderLayout(0, 0));

        //Panel formularios (absolutos):
        JPanel panelFormMonedas = new JPanel();
        panelFormMonedas.setBackground(new Color(94, 92, 100));
        panelPantalla.add(panelFormMonedas, BorderLayout.CENTER);
        panelFormMonedas.setLayout(null);

        //Ingresar cantidad a convertir:
        JLabel lblCantidad = new JLabel("Cantidad a convertir:");
        lblCantidad.setBounds(134, 12, 160, 25);
        panelFormMonedas.add(lblCantidad);

        textCantidad = new JTextField();
        textCantidad.setBounds(156, 35, 114, 19);
        panelFormMonedas.add(textCantidad);
        textCantidad.setColumns(10);

        //Texto de resultado:
        JLabel lblResultado = new JLabel("Resultado:");
        lblResultado.setBounds(175, 103, 119, 19);
        panelFormMonedas.add(lblResultado);

        textResultado = new JTextField();
        textResultado.setEditable(false);
        textResultado.setBounds(156, 123, 114, 19);
        panelFormMonedas.add(textResultado);
        textResultado.setColumns(10);

        //Botón convertir moneda:
        JButton btnConvertirMoneda = new JButton("Convertir");
        btnConvertirMoneda.setBounds(156, 168, 114, 25);
        panelFormMonedas.add(btnConvertirMoneda);

        // Instancia de la clase Moneda
        Moneda moneda = new Moneda();

        // ActionListener para el botón de convertir
        btnConvertirMoneda.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obtener el valor ingresado en el campo
                try {
                    double valor = Double.parseDouble(textCantidad.getText());

                    // Llamar al método convertirMoneda de la clase Moneda
                    double resultado = moneda.convertirMoneda(valor);

                    // Mostrar el resultado en el campo de resultado
                    textResultado.setText(String.valueOf(resultado));
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
     * Crear botonera con lógica:
     * https://www.youtube.com/watch?v=xvvMSJ3nfT8&list=PLAg6Lv5BbjjfAWETI3j3D78ZaophRGhrs&index=5
     *
     * Video para organizar la APP con Java Swing:
     * https://www.youtube.com/watch?v=hIBEmpV30Ao
     *
     * Video para crear y configurar un JOptionPane:
     * https://www.youtube.com/watch?v=3jGkv19Hg0Q
     * */

}
