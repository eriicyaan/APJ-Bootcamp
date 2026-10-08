package com;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        int n = input();

        try {
            System.out.println(fib(n));
        } catch (StackOverflowError e) {
            System.out.println("Too large n");
        }

    }

    private static int input() {
        int n;
        Scanner scanner = new Scanner(System.in);

        while(true) {
            try {
                n = scanner.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Could not parse a number. Please, try again");
                scanner.next();
            }
        }
        return n;
    }

    private static int fib(int n) {

        if (n <= 0) {
            return 0;
        } else if(n == 1) {
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

}