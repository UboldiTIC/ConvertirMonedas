package org.one.vista;

import org.one.model.Moneda;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;

public class SwingApp extends JFrame implements ActionListener {

    //Variables:
    private JTextField textCantidad;
    private JTextField textResultado;
    private JComboBox comboBoxValor;
    public double valorActual;
    JPanel contentPane,panelPrincipal,panelBtnSeleccion, panelPantalla1,panelPantalla2, panelPantalla, panelFormMonedas, panelFormTemperaturas, panelPie;
    JButton btnSelecMoneda, btnSelecTemperatura;


    public SwingApp() {
        //Configuración JFrame
        setTitle("ConvertidorONE");
        setBounds(250, 250, 700, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Configuración JPanel Contenedor
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(new Color(17, 0, 0));

        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        //Panel general principal
        panelPrincipal = new JPanel();
        contentPane.add(panelPrincipal, BorderLayout.CENTER);
        panelPrincipal.setLayout(new BorderLayout(0, 0));

        //Panel superior botones seleccionar monedas o temperaturas
        panelBtnSeleccion = new JPanel();
        panelBtnSeleccion.setBackground(new Color(17, 0, 0));
        panelPrincipal.add(panelBtnSeleccion, BorderLayout.NORTH);

        //Botones de panel superior:
        btnSelecMoneda = new JButton("Monedas");
        btnSelecMoneda.setForeground(new Color(255, 255, 255));
        btnSelecMoneda.setPreferredSize(new Dimension(134, 25));
        btnSelecMoneda.setBackground(new Color(192, 28, 40));
        panelBtnSeleccion.add(btnSelecMoneda);
        btnSelecMoneda.addActionListener(this);

        //Agregar cuando sea necesario convertir temperaturas.
        btnSelecTemperatura = new JButton("Temperaturas");
        btnSelecTemperatura.setForeground(new Color(255, 255, 255));
        btnSelecTemperatura.setPreferredSize(new Dimension(134,25));
        btnSelecTemperatura.setBackground(new Color(192, 28, 40));
        panelBtnSeleccion.add(btnSelecTemperatura);
        btnSelecTemperatura.addActionListener(this);

        //Panel inferior pie de App:
        panelPie = new JPanel();
        panelPie.setBackground(new Color(17, 0, 0));
        panelPrincipal.add(panelPie, BorderLayout.SOUTH);

        JLabel lblPie = new JLabel("Proyecto ONE - Oracle Next Education");
        lblPie.setForeground(new Color(246, 245, 244));
        panelPie.add(lblPie);

        panelPantalla = new JPanel();
        panelPrincipal.add(panelPantalla, BorderLayout.CENTER);
        panelPantalla.setBackground(new Color(61, 56, 70));
        panelPantalla.setLayout(null);

        //Panel BorderLayout para mostrar paneles Absolutos:
        panelPantalla1 = new JPanel();
        panelPantalla1.setBackground(new Color(61, 56, 70));
        panelPantalla1.setBounds(10, 10, 670, 370);
        panelPantalla1.setLayout(null);
        panelPantalla.add(panelPantalla1);
        cargarComponentesPantalla1();

        //Panel BorderLayout para mostrar paneles Absolutos:
        panelPantalla2 = new JPanel();
        panelPantalla2.setBackground(Color.GREEN);
        panelPantalla2.setBounds(10, 10, 670, 370);
        panelPantalla2.setLayout(null);
        panelPantalla.add(panelPantalla2);

        /*//Panel convertir monedas (absolutos):
        panelFormMonedas = new JPanel();
        panelFormMonedas.setBackground(new Color(61, 56, 70));
        panelPantalla1.add(panelFormMonedas, BorderLayout.CENTER);
        panelFormMonedas.setLayout(null);*/




        //Panel convertir monedas (absolutos):
       /* panelFormTemperaturas = new JPanel();
        panelFormTemperaturas.setBackground(new Color(61, 56, 70));
        panelPantalla1.add(panelFormTemperaturas, BorderLayout.CENTER);
        panelFormTemperaturas.setLayout(null);
        panelFormTemperaturas.setVisible(false);*/
    }

    private void cargarComponentesPantalla1() {


        // Instancia de la clase Moneda
        Moneda moneda = new Moneda();

        //Combo box seleccionar conversion:
        comboBoxValor = new JComboBox();
        comboBoxValor.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                //Evento ComboBox:
                establecerValor();
                moneda.setValor(valorActual);
            }
        });
        comboBoxValor.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar", "ARS a USD", "USD a ARS", "ARS a EUR", "EUR a ARS"}));
        comboBoxValor.setBounds(245, 12, 190, 30);
        panelPantalla1.add(comboBoxValor);

        //Ingresar cantidad a convertir:
        JLabel lblCantidad = new JLabel("Cantidad a convertir:");
        lblCantidad.setForeground(new Color(245, 255, 255));
        lblCantidad.setFont(new Font("Dialog", Font.BOLD, 15));
        lblCantidad.setBounds(245, 95, 191, 25);
        panelPantalla1.add(lblCantidad);

        textCantidad = new JTextField();
        textCantidad.setBounds(245, 120, 190, 30);
        panelPantalla1.add(textCantidad);
        textCantidad.setColumns(10);

        //Texto de resultado:
        JLabel lblResultado = new JLabel("Resultado:");
        lblResultado.setForeground(new Color(255, 255, 255));
        lblResultado.setFont(new Font("Dialog", Font.BOLD, 15));
        lblResultado.setBounds(245, 195, 119, 19);
        panelPantalla1.add(lblResultado);

        textResultado = new JTextField();
        textResultado.setEditable(false);
        textResultado.setBounds(245, 220, 190, 30);
        panelPantalla1.add(textResultado);
        textResultado.setColumns(10);

        //Botón convertir moneda:
        JButton btnConvertirMoneda = new JButton("Convertir");
        btnConvertirMoneda.setBounds(245, 300, 190, 30);
        panelPantalla1.add(btnConvertirMoneda);

        // ActionListener para el botón de convertir
        btnConvertirMoneda.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obtener el valor ingresado en el campo
                try {
                    double cantidad = Double.parseDouble(textCantidad.getText());

                    // Llamar al método convertirMoneda de la clase Moneda
                    double resultado = moneda.convertirMoneda(cantidad);

                    // Mostrar el resultado en el campo de resultado
                    Double resultadoParcial = Double.valueOf(String.valueOf(resultado));
                    DecimalFormat df = new DecimalFormat("#.##");
                    String resultadoFormateado = df.format(resultadoParcial);
                    textResultado.setText(resultadoFormateado);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(SwingApp.this, "Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

    }

    private void establecerValor() {
        //Falta que cada valor se tome a partir del consumo de una API.
        String mi_cambio = comboBoxValor.getSelectedItem().toString();
        switch (mi_cambio){
            case "ARS a USD":
                valorActual = 821.00;
                break;
            case "USD a ARS":
                valorActual = 0.0012;
                break;
            case "ARS a EUR":
                valorActual = 872.87;
                break;
            case "EUR a ARS":
                valorActual = 0.0011;
                break;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnSelecMoneda) {
            panelPantalla1.setVisible(true);
            panelPantalla2.setVisible(false);
        }
        if(e.getSource()==btnSelecTemperatura) {
            panelPantalla2.setVisible(true);
            panelPantalla1.setVisible(false);
        }
    }

//Falta obtener valor de API - Convertir temperatura: habilitar selección de paneles.
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
         * Video para crear y configurar un JComboBox:
         * https://www.youtube.com/watch?v=3jGkv19Hg0Q
         *
         * Una vez funcionando la lógica del Conversor de Monedas, hay que cambiar de panel,
         * para usar el Conversor de Temperaturas:
         * https://www.youtube.com/watch?v=UUENqBb1l34&t=98s
         * Para ello es muy útil seguir los pasos que explica Cristian Henao en su canal de YouTube.
         * */
}
