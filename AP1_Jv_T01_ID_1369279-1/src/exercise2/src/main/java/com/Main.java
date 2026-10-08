package com;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int seconds = input();

        if(seconds < 0) {
            System.out.println("Incorrect time");
        } else {
            int[] time = find(seconds);
            printTime(time);
        }
    }

    private static int input() {
        int seconds = 0;
        Scanner scanner = new Scanner(System.in);

        while(true) {
            try {
                seconds = scanner.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Could not parse a number. Please, try again");
                scanner.next();
            }
        }
        return seconds;
    }

    private static int[] find(int seconds) {
        int hours = seconds / 3600;
        int minutes = (seconds % 3600) / 60;
        int secs = seconds % 60;

        return new int[] {hours, minutes, secs};
    }

    private static void printTime(int[] time) {
        System.out.printf("%02d:%02d:%02d\n", time[0], time[1], time[2]);
    }
}