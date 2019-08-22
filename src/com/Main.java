package com;

import java.util.*;
import java.util.regex.Pattern;

interface Calculable {
    Double calc(Double a, Double b);
}

public class Main {


    public static void main(String[] args) {
        Calculable calculator = null;

        //Scanner in = new Scanner(System.in);
        String s = "120.1 - 22 ="; //in.nextLine();

        Double a = 0d;
        Double b = 0d;
        String op = "";

        try {
            //if (s.matches("(\\d+([.,]\\d+)?) [-+/*] (\\d+([.,]\\d+)?) = ")) {
                a = Double.valueOf(s.split(" ")[0]);
                b = Double.valueOf(s.split(" ")[2]);

                op = s.split(" ")[1];
                System.out.println(Arrays.toString(s.split(" ")));
            //}
            /*
            else {
                throw new Exception("Error: wrong expression.");
            }
            */
        } catch (Exception ex ) { /* do nothing */ }

        //System.out.printf("%.1f %s %.1f = ", a, op, b);
        //[120, -, 22, =]
        switch (op) {
            case "+":
                calculator = (x, y) -> { return x + y; };
                break;
            case "-":
                calculator = (x, y) -> { return x - y; };
                break;
            case "*":
                calculator = (x, y) -> { return x * y; };
                break;
            case "/":
                calculator = (x, y) -> { return x / y; };
                break;
            default: break;
        }

        if(calculator != null) {
            System.out.printf("%.1f %s %.1f = %.1f", a, op, b, calculator.calc(a, b) );
        }
    }
}
