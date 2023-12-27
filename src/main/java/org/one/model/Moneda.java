package org.one.model;

public class Moneda {
    private double valor;

    private double resultado;

    public Moneda() {
    }

    public double setValor(double valor) {
        this.valor = valor;
        return valor;
    }

    public double convertirMoneda(double cantidad) {
        resultado = cantidad / valor;
        return resultado;
    }
}
