package org.one.controller;

import org.one.model.Moneda;

public class ConversorMonedas {

    //función convertir monedas.
   /* public static double convertToDolar(double quantity, String currency) {
        //MXN COP
        switch (currency){
            case "MXN":
                quantity = quantity * 0.52;
                break;
            case "COP":
                quantity = 0.00031;
                break;
        }
        return quantity;
    }*/

}

/**
 * Contiene todos los métodos y funciones que permiten realizar
 * la conversión de monedas según el tipo de moneda seleccionada.
 * El valor de la moneda, en un primer momento se establece manualmente,
 * luego, se realizará mediante el consumo de una API.
 * Para implementar la selección del tipo moneda se puede utilizar un
 * switch o un if que permita escuchar la opción seleccionada y,
 * a partir de la selección, establecer el valor de cambio.
 * */