package com.example.computersciencea_summerwork_2021;

import java.text.DecimalFormat;

public class Order {
    public static double total = 0.00, subtotal = 0.00, tax = 0.00;

    public static String totalString, subtotalString, taxString;
    private static DecimalFormat format = new DecimalFormat("##.##");

    public static void setValues(){
        totalString = "Total: $" + format.format(total);
        subtotalString = "Subtotal: $" +  format.format(subtotal);
        taxString = "Tax (12.5%): $" +  format.format(tax);
    }
}
