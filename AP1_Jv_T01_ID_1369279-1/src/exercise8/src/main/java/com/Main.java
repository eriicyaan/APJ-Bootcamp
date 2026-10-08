package com;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int first;
        boolean flag = false;
        try {
            first = scanner.nextInt();
            flag = true;
            int i = 1;
            while (true) {
                int second = scanner.nextInt();
                if (second > first) {
                    first = second;
                    i++;
                } else {
                    System.out.println("The sequence is not ordered from the ordinal number of the number " + i);
                    break;
                }
            }
        } catch (Exception e) {
            if(flag) {
                System.out.println("The sequence is ordered in ascending order");
            } else {
                System.out.println("Input error");
            }
        }
    }
}