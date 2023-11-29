package org.one.main;

import org.one.controller.Cantidad;
import org.one.model.Moneda;
import org.one.vista.SwingApp;

public class Main {
    public static void main(String[] args) {

        SwingApp app = new SwingApp();
        app.setVisible(true);
        app.setLocationRelativeTo(null);


        /*Moneda myMoneda = new Moneda();
        myMoneda.setTipo("USD");
        myMoneda.setValor(355.86);


        Cantidad myConvert = new Cantidad();
        myConvert.setCantidad(100000);


        System.out.println(myConvert.getCantidad() / myMoneda.getValor());*/

    }
}
