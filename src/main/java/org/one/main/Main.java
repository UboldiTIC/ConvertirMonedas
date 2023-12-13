package org.one.main;

import org.one.model.Temperatura;
import org.one.vista.SwingApp;

public class Main {
    public static void main(String[] args) {

        //Iniciar SwingApp:
        /*SwingApp app = new SwingApp();
        app.setVisible(true);
        app.setLocationRelativeTo(null);*/

        Temperatura myTemperatura = new Temperatura();
        myTemperatura.convertirTemperatura(15, "fahrenheit_celsius");
        System.out.println("El resultado en celsius es: " + myTemperatura.getResultado());

        myTemperatura.convertirTemperatura(15, "fahrenheit_kelvin");
        System.out.println("El resultado en kelvin es: " + myTemperatura.getResultado());

        myTemperatura.convertirTemperatura(15, "celsius_fahrenheit");
        System.out.println("El resultado en fahrenheit es: " + myTemperatura.getResultado());

        myTemperatura.convertirTemperatura(15, "celsius_kelvin");
        System.out.println("El resultado en kelvin es: " + myTemperatura.getResultado());

        myTemperatura.convertirTemperatura(15, "kelvin_celsius");
        System.out.println("El resultado en celsius es: " + myTemperatura.getResultado());

        myTemperatura.convertirTemperatura(15, "kelvin_fahrenheit");
        System.out.println("El resultado en fahrenheit es: " + myTemperatura.getResultado());





        //myTemperatura.convertirTemperatura(myTemperatura.setUnidad("celcius_fahrenheit")myTemperatura.setTemperatura(30);

        /*Moneda myMoneda = new Moneda();
        myMoneda.setTipo("USD");
        myMoneda.setValor(355.86);


        Cantidad myConvert = new Cantidad();
        myConvert.setCantidad(100000);


        System.out.println(myConvert.getCantidad() / myMoneda.getValor());*/

    }
}
