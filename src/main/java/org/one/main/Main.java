package org.one.main;

import org.one.model.ConvertirMoneda;
import org.one.model.Moneda;

public class Main {
    public static void main(String[] args) {
        Moneda myMoneda = new Moneda();
        myMoneda.setTipo("USD");
        myMoneda.setValor(355.86);

        ConvertirMoneda myConvert = new ConvertirMoneda();
        myConvert.setCantidad(100000);

        System.out.println(myConvert.getCantidad() / myMoneda.getValor());
    }
}
