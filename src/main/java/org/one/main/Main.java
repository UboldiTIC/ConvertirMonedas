package org.one.main;

import org.one.model.Moneda;

public class Main {
    public static void main(String[] args) {

        //Lógica 1
        Moneda myMoneda = new Moneda();
        myMoneda.setTipo("USD");
        myMoneda.setValor(357.02);

        /*
        String mon = myMoneda.getTipo();
        double valorActual = myMoneda.getValor();
        double cantidad = 100000.00;

        System.out.println(cantidad + " = " + (cantidad / valorActual) + " " + mon);*/




        /*public static double convertToDolar(double quantity, String currency) {
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


        System.out.println();

        //Main para probar función no funciona porque está en otro paquete.
        //System.out.println("Pesos a dolares: " + convertToDolar(200, "MXN"));

    }

}
