package org.one.main;

import org.json.JSONArray;
import org.json.JSONObject;
import org.one.model.Cotizaciones;
import org.one.model.Temperatura;
import org.one.vista.SwingApp;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Iniciar SwingApp:
        SwingApp app = new SwingApp();
        app.setVisible(true);
        app.setLocationRelativeTo(null);

       /* Cotizaciones cotizaciones = new Cotizaciones();
        cotizaciones.establecerValorBlue();
        System.out.println(cotizaciones.getValor_blue());*/


        /*try {
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

                *//**
                 * Interpretar el contenido de JSON con Maven Repository org.json
                 * En GOGODEV: https://www.youtube.com/watch?v=kSmwtbRgoDs&list=PLDllzmccetSMFnraCQgehsxfb11v8QXTP&index=2
                 *
                 * [] = Dentro de corchetes es un Array. Puede tener un Objeto o muchos.
                 *      A los arreglos los llamamos JSONArray.
                 *
                 * {} = Dentro de llaves es un Objeto.
                 *      A los objetos los llamamos JSONObject
                 *
                 * *//*

                JSONArray jsonArray = new JSONArray(informationString.toString());
                JSONObject jsonObject = jsonArray.getJSONObject(1);
                System.out.println(jsonObject.getString("source"));
                System.out.println(jsonObject.getDouble("value_sell"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/










        //myTemperatura.convertirTemperatura(myTemperatura.setUnidad("celsius_fahrenheit")myTemperatura.setTemperatura(30);

        /*Moneda myMoneda = new Moneda();
        myMoneda.setTipo("USD");
        myMoneda.setValor(355.86);


        Cantidad myConvert = new Cantidad();
        myConvert.setCantidad(100000);


        System.out.println(myConvert.getCantidad() / myMoneda.getValor());*/

    }
}
