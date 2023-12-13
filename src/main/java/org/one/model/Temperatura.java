package org.one.model;
public class Temperatura {

    private double resultado;

    public Temperatura() {
    }

    public double getResultado() {
        return resultado;
    }

    public double convertirTemperatura(double temperatura, String unidad) {

        switch (unidad) {
            case "fahrenheit_celsius":
                resultado = (temperatura - 32) * 5/9;
                return resultado;
            case "fahrenheit_kelvin":
                resultado = (temperatura - 32) * 5/9 + 273.15;
                return resultado;
            case "celsius_fahrenheit":
                resultado = (temperatura * 9/5) + 32;
                return resultado;
            case "celsius_kelvin":
                resultado = temperatura + 273.15;
                return resultado;
            case "kelvin_celsius":
                resultado = temperatura - 273.15;
                return resultado;
            case "kelvin_fahrenheit":
                resultado = (temperatura - 273.15) * 9/5 + 32;
                return resultado;
            default:
                return -1;
        }
    }

}
