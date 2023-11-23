package org.one.main;

public class Main {
    public static void main(String[] args) {

        System.out.println("Pesos a dolares: " + convertToDolar(200, "MXN"));

    }

    public static double convertToDolar(double quantity, String currency) {
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
    }
}
