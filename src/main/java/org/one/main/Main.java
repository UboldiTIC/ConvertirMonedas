package org.one.main;

import org.one.controller.Cantidad;
import org.one.model.Moneda;

public class Main {
    public static void main(String[] args) {
        Moneda myMoneda = new Moneda();
        myMoneda.setTipo("USD");
        myMoneda.setValor(355.86);


        Cantidad myConvert = new Cantidad();
        myConvert.setCantidad(100000);


        System.out.println(myConvert.getCantidad() / myMoneda.getValor());

    }
}
