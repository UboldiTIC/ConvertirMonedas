package org.one.model;

public class Moneda {
    private String tipo;
    private double cantidad;

    private double resultado;

    public Moneda() {
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double convertirMoneda(double cantidad) {
        //resultado = valor / 359.99;
        //cambiar round por mostrar solo dos decimales.
        resultado = Math.round(cantidad / 955);
        return resultado;
    }

    //Debería ser valor / valorActual que debería provenir del consumo de una App en vez de dos.
    //En controler debería crear un JOptionPane que selecciones una categoría Ej. USD y tome el valor desde una App.
}
