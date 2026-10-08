package com;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double x1, y1;
        double x2, y2;
        double x3, y3;

        while(true) {
            try {
                x1 = scanner.nextDouble();
                y1 = scanner.nextDouble();
                x2 = scanner.nextDouble();
                y2 = scanner.nextDouble();
                x3 = scanner.nextDouble();
                y3 = scanner.nextDouble();
                break;
            } catch (Exception e) {
                System.out.println("Could not parse a number. Please, try again");
                scanner.next();
            }
        }

        double a = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        double b = Math.sqrt(Math.pow((x3 - x1), 2) + Math.pow((y3 - y1), 2));
        double c = Math.sqrt(Math.pow((x3 - x2), 2) + Math.pow((y3 - y2), 2));


        if(a + b > c && a + c > b && b + c > a) {
            System.out.printf("Perimeter: %.3f", a + b + c);
        } else {
            System.out.println("It's not a triangle");
        }

    }
}