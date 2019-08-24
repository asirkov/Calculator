package com;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.regex.Pattern;

public class Main {

    private static BinaryOperator<Double> operation(String op) {
        switch (op) {
            case "+": return (x, y) -> { return x + y; };
            case "-": return  (x, y) -> { return x - y; };
            case "*": return  (x, y) -> { return x * y; };
            case "/": return  (x, y) -> { return x / y; };
            default: return (x, y) -> { return 0d; };
        }
    }

    public static void main(String[] args) {
        BinaryOperator<Double> calculator = null;

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
        calculator = operation(op);

        if(calculator != null) {
            System.out.printf("%.1f %s %.1f = %.1f", a, op, b, calculator.apply(a, b) );
        }
    }
}
