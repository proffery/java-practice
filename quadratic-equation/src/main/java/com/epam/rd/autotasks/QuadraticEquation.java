package com.epam.rd.autotasks;

import java.util.Locale;
import java.util.Scanner;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class QuadraticEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        double x1;
        double x2;
        double d = pow(b, 2) - 4 * a * c;

        if (d > 0) {
            x1 = (-b + sqrt(d)) / (2 * a);
            x2 = (-b - sqrt(d)) / (2 * a);
            System.out.println(x1 + " " + x2);
        }

        else {
            if (d == 0) {
                x1 = (-b + sqrt(d)) / (2 * a);
                System.out.println(x1);
            }
            else{
                System.out.println("no roots");
            }
        }
    }
}