package org.one.main;

import org.one.model.Temperatura;
import org.one.vista.SwingApp;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /*//Iniciar SwingApp:
        SwingApp app = new SwingApp();
        app.setVisible(true);
        app.setLocationRelativeTo(null);*/

        try {
            URL url = new URL("https://api.bluelytics.com.ar/json/last_price");
            //Establecer conexión:
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            //¿Petición correcta?
            int response_code = conn.getResponseCode();
            if(response_code != 200) {
                throw new RuntimeException("Ocurrió un error: " + response_code);
            } else {
                //Abrir un scanner que lee el flujo de datos recibidos:
                StringBuilder informationString = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());

                while (scanner.hasNext()) {
                    informationString.append(scanner.nextLine());
                }
                scanner.close();
                //Mostrar la información obtenida por consola:
                System.out.println(informationString);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }










        //myTemperatura.convertirTemperatura(myTemperatura.setUnidad("celsius_fahrenheit")myTemperatura.setTemperatura(30);

        /*Moneda myMoneda = new Moneda();
        myMoneda.setTipo("USD");
        myMoneda.setValor(355.86);


        Cantidad myConvert = new Cantidad();
        myConvert.setCantidad(100000);


        System.out.println(myConvert.getCantidad() / myMoneda.getValor());*/

    }
}
