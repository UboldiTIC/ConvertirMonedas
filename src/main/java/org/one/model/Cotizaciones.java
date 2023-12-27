package org.one.model;

//import org.json.JSONArray;
import org.json.JSONObject;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Cotizaciones {
    double valor_blue;
    double valor_euro;

    public Cotizaciones() {
    }

    public double getValor_blue() {
        return valor_blue;
    }

    public double getValor_euro() {
        return valor_euro;
    }

    public double establecerValorBlue(double valorBlue) {
        //Realizar petición:
        try {
            URL url = new URL("https://api.bluelytics.com.ar/v2/latest");
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
                //System.out.println(informationString);

                //Actualización de la API a la versión 2 con JSONObject anidados.
                JSONObject jsonObject = new JSONObject(informationString.toString());
                JSONObject primerObjeto = jsonObject.getJSONObject("blue");

                valor_blue = primerObjeto.getDouble("value_sell");
                return valor_blue;

                //Lógica para consumir un valor desde un JSONArray de la versión 1 de: https://api.bluelytics.com.ar/json/last_price
                /*JSONArray jsonArray = new JSONArray(informationString.toString());
                JSONObject jsonObject = jsonArray.getJSONObject(1);
                valor_blue = jsonObject.getDouble("value_sell");
                return valor_blue;*/

                /**
                 * Interpretar el contenido de JSON con Maven Repository org.json
                 * En GOGODEV: https://www.youtube.com/watch?v=kSmwtbRgoDs&list=PLDllzmccetSMFnraCQgehsxfb11v8QXTP&index=2
                 *
                 * [] = Dentro de corchetes es un Array. Puede tener un Objeto o muchos.
                 *      A los arreglos los llamamos JSONArray.
                 *
                 * {} = Dentro de llaves es un Objeto.
                 *      A los objetos los llamamos JSONObject
                 *
                 * */
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public double establecerValorEuro(double valorEuro) {
        try {
            //Aplicación cómo ejercicio: valor Banco de la Pampa.
            URL url = new URL("https://api.bluelytics.com.ar/v2/latest");
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
                //System.out.println(informationString);

                JSONObject jsonObject = new JSONObject(informationString.toString());
                JSONObject primerObjeto = jsonObject.getJSONObject("blue_euro");

                valor_euro = primerObjeto.getDouble("value_sell");
                return valor_euro;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
