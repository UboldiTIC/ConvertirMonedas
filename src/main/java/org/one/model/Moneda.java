package org.one.model;

public class Moneda {
    private String tipo;
    private double valor;

    private double resultado;

    public Moneda() {
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double convertirMoneda(double valor) {
        resultado = valor / 359.99;
        return resultado;
    }

    //Debería ser valor / valorActual que debería provenir del consumo de una App en vez de dos.
    //En controler debería crear un JOptionPane que selecciones una categoría Ej. USD y tome el valor desde una App.
}
