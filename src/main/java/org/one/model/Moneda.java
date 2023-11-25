package org.one.model;

public class Moneda {
    private String tipo;
    private double valor;

    private double resultado;
    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }


    //private double cantidad; //Cantidad debe ingresar como parámetro para realizar el cálculo.

    //Constructor para probar si lee en método ConversorMonedas.
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

    /*public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }*/
}
