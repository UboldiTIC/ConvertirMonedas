package org.one.vista;

import org.one.model.Cotizaciones;
import org.one.model.Moneda;
import org.one.model.Temperatura;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class SwingApp extends JFrame implements ActionListener {

    //Variables:
    private JTextField textCantidad, textResultado, textTemperatura, txtResultadoTemperatura;
    //private JTextField textResultado;
    private JComboBox comboBoxValor;
    public double valor_actual;
    public String parametro_grados;
    JPanel contentPane,panelPrincipal,panelBtnSeleccion,panelPantalla1,panelPantalla2,panelPantalla,panelPie;
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

        //Panel general principal. Organiza el resto de los paneles.
        panelPrincipal = new JPanel();
        contentPane.add(panelPrincipal, BorderLayout.CENTER);
        panelPrincipal.setLayout(new BorderLayout(0, 0));

        //Panel superior botones seleccionar monedas o temperaturas
        panelBtnSeleccion = new JPanel();
        panelBtnSeleccion.setBackground(new Color(17, 0, 0));
        panelPrincipal.add(panelBtnSeleccion, BorderLayout.NORTH);

        //Botones de panel superior, convertir monedas:
        btnSelecMoneda = new JButton("Monedas");
        btnSelecMoneda.setForeground(new Color(255, 255, 255));
        btnSelecMoneda.setPreferredSize(new Dimension(134, 25));
        btnSelecMoneda.setBackground(new Color(192, 28, 40));
        panelBtnSeleccion.add(btnSelecMoneda);
        btnSelecMoneda.addActionListener(this);

        //Botones de panel superior, convertir temperaturas:
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

        //Pantalla central principal, incorpora paneles conversores.
        panelPantalla = new JPanel();
        panelPrincipal.add(panelPantalla, BorderLayout.CENTER);
        panelPantalla.setBackground(new Color(61, 56, 70));
        panelPantalla.setLayout(null);

        //Pantalla 1 conversor de monedas:
        panelPantalla1 = new JPanel();
        panelPantalla1.setBackground(new Color(61, 56, 70));
        panelPantalla1.setBounds(10, 10, 670, 370);
        panelPantalla1.setLayout(null);
        panelPantalla.add(panelPantalla1);
        cargarComponentesPantalla1();

        //Pantalla 2 conversor de temperaturas:
        panelPantalla2 = new JPanel();
        panelPantalla2.setBackground(new Color(61, 56, 70));
        panelPantalla2.setBounds(10, 10, 670, 370);
        panelPantalla2.setLayout(null);
        cargarComponentesPantalla2();
    }

    //Método cargar componentes del panel conversor de monedas:
    private void cargarComponentesPantalla1() {


        // Instancia de la clase Moneda
        Moneda moneda = new Moneda();

        //Combo box seleccionar conversion:
        comboBoxValor = new JComboBox();
        comboBoxValor.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                //Evento ComboBox:
                establecerValor();
                moneda.setValor(valor_actual);
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

                    // Envía la cantidad a convertir a la clase Moneda
                    double resultado = moneda.convertirMoneda(cantidad);

                    // Trae el resultado de la clase Moneda y lo muestra
                    Double resultado_parcial = Double.valueOf(String.valueOf(resultado));
                    DecimalFormat df = new DecimalFormat("#.##");
                    String resultado_formateado = df.format(resultado_parcial);
                    textResultado.setText(resultado_formateado);

                    System.out.println("El valor actual es: " + valor_actual);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(SwingApp.this, "Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    //Método cargar componentes del panel conversor de temperaturas:
    private void cargarComponentesPantalla2() {

        //Instancia de la clase Temperatura
        Temperatura miTemperatura = new Temperatura();

        //RadioButton seleccionar tipos de temperaturas a convertir:

        JRadioButton rdbtnCelsiusFahrenheit = new JRadioButton("Celsius a Fahrenheit");
        rdbtnCelsiusFahrenheit.setBounds(62, 37, 190, 23);
        rdbtnCelsiusFahrenheit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                parametro_grados = "celsius_fahrenheit";
            }
        });
        panelPantalla2.add(rdbtnCelsiusFahrenheit);

        JRadioButton rdbtnCelsiusKelvin = new JRadioButton("Celsius a Kelvin");
        rdbtnCelsiusKelvin.setBounds(62, 64, 190, 23);
        rdbtnCelsiusKelvin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                parametro_grados = "celsius_kelvin";
            }
        });
        panelPantalla2.add(rdbtnCelsiusKelvin);

        JRadioButton rdbtnFahrenheitCelsius = new JRadioButton("Fahrenheit a Celsius");
        rdbtnFahrenheitCelsius.setBounds(255, 37, 190, 23);
        rdbtnFahrenheitCelsius.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                parametro_grados = "fahrenheit_celsius";
            }
        });
        panelPantalla2.add(rdbtnFahrenheitCelsius);

        JRadioButton rdbtnFahrenheitKelvin = new JRadioButton("Fahrenheit a Kelvin");
        rdbtnFahrenheitKelvin.setBounds(255, 64, 190, 23);
        rdbtnFahrenheitKelvin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                parametro_grados = "fahrenheit_kelvin";
            }
        });
        panelPantalla2.add(rdbtnFahrenheitKelvin);

        JRadioButton rdbtnKelvinCelsius = new JRadioButton("Kelvin a Celsius");
        rdbtnKelvinCelsius.setBounds(449, 37, 190, 23);
        rdbtnKelvinCelsius.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                parametro_grados="kelvin_celsius";
            }
        });
        panelPantalla2.add(rdbtnKelvinCelsius);

        JRadioButton rdbtnKelvinFahrenheit = new JRadioButton("Kelvin a Fahrenheit");
        rdbtnKelvinFahrenheit.setBounds(449, 64, 190, 23);
        rdbtnKelvinFahrenheit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                parametro_grados="kelvin_fahrenheit";
            }
        });
        panelPantalla2.add(rdbtnKelvinFahrenheit);

        //Grupo de RadioButtons, seleccionar una sóla opción:
        ButtonGroup g1 = new ButtonGroup();
        g1.add(rdbtnCelsiusFahrenheit);
        g1.add(rdbtnCelsiusKelvin);
        g1.add(rdbtnFahrenheitCelsius);
        g1.add(rdbtnFahrenheitKelvin);
        g1.add(rdbtnKelvinCelsius);
        g1.add(rdbtnKelvinFahrenheit);

        //Ingresar cantidad a convertir:
        JLabel lblTemperatura = new JLabel("Ingresar temperatura");
        lblTemperatura.setForeground(new Color(255, 255, 255));
        lblTemperatura.setFont(new Font("Dialog", Font.BOLD, 15));
        lblTemperatura.setBounds(252, 106, 191, 25);
        panelPantalla2.add(lblTemperatura);

        textTemperatura = new JTextField();
        textTemperatura.setBounds(252, 130, 190, 30);
        panelPantalla2.add(textTemperatura);
        textTemperatura.setColumns(10);

        //Texto de resultado:
        JLabel lblResultadoTemperatura = new JLabel("Resultado:");
        lblResultadoTemperatura.setForeground(new Color(255, 255, 255));
        lblResultadoTemperatura.setFont(new Font("Dialog", Font.BOLD, 15));
        lblResultadoTemperatura.setBounds(252, 172, 119, 19);
        panelPantalla2.add(lblResultadoTemperatura);

        txtResultadoTemperatura = new JTextField();
        txtResultadoTemperatura.setEditable(false);
        txtResultadoTemperatura.setBounds(252, 195, 190, 30);
        panelPantalla2.add(txtResultadoTemperatura);
        txtResultadoTemperatura.setColumns(10);

        //Botón convertir temperatura:
        JButton btnConvertirTemperatura = new JButton("Convertir");
        btnConvertirTemperatura.setBounds(250, 340, 190, 30);
        panelPantalla2.add(btnConvertirTemperatura);

        btnConvertirTemperatura.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    //Enviar parámetros:
                    double temperatura = Double.parseDouble(textTemperatura.getText());
                    miTemperatura.convertirTemperatura(parametro_grados, temperatura);

                    //Mostrar resultado:
                    Double resultado_parcial = Double.valueOf(miTemperatura.getResultado());
                    DecimalFormat df = new DecimalFormat("#.##");
                    String resultado_formateado = df.format(resultado_parcial);
                    txtResultadoTemperatura.setText(resultado_formateado);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(SwingApp.this, "Ingrese un número válido o seleccione una opción.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    //Método que recibe una opción del ComboBox, establece un valor y lo envía a la clase moneda.
    private void establecerValor() {
        //Falta que cada valor se tome a partir del consumo de una API.
        Cotizaciones cotizaciones = new Cotizaciones();
        String mi_cambio = comboBoxValor.getSelectedItem().toString();
        switch (mi_cambio){
            case "ARS a USD":
                valor_actual = cotizaciones.establecerValorBlue(cotizaciones.getValor_blue());
                //valor_actual = 821.00;
                break;
            case "USD a ARS":
                valor_actual = 0.0012;
                break;
            case "ARS a EUR":
                valor_actual = cotizaciones.establecerValorEuro(cotizaciones.getValor_euro());
                //valor_actual = 872.87;
                break;
            case "EUR a ARS":
                valor_actual = 0.0011;
                break;
        }
    }

    //Lógica para eventos de botones que permiten seleccionar los paneles de conversión.
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnSelecMoneda) {
            panelPantalla1.setVisible(true);
            panelPantalla2.setVisible(false);
        }
        if(e.getSource()==btnSelecTemperatura) {
            panelPantalla.add(panelPantalla2);
            panelPantalla2.setVisible(true);
            panelPantalla1.setVisible(false);
        }
    }

//Falta obtener valor de API - Crear componentes del panel convertir temperatura.
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
         *
         * Video para crear RadioButtons para convertir temperaturas, Luis Villa:
         * https://www.youtube.com/watch?v=9mVRegzH_LY
         *
         * Obtener información de una API:
         * ¿Qué es una API? TodoCode; Luisina De Paula.
         * https://www.youtube.com/watch?v=IwnIxk8DdHs
         *
         * Consumir una API desde Java - GoGoDEV:
         * https://www.youtube.com/watch?v=GmL1Nmj9TqY&t=7s
         *
         * Agregar dependencia org.json con Maven para poder manipular el JSON.
         * */
}
