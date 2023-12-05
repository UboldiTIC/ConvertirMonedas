package org.one.model;

public class Moneda {
    private double valor;
    private double cantidad;

    private double resultado;

    public Moneda() {
    }

    public double getValor() {
        return valor;
    }

    public double setValor(double valor) {
        this.valor = valor;
        return valor;
    }

    public double getCantidad() {
        return cantidad;
    }

    public double setCantidad(double cantidad) {
        this.cantidad = cantidad;
        return cantidad;
    }

    public double convertirMoneda(double cantidad) {
        resultado = cantidad / valor;
        return resultado;
    }
}
