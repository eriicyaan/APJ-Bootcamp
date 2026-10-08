package com;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        double[] nums = input();
        if(nums == null) return;

        double min = findMin(nums);
        double max = findMax(nums);

        String str = min + " " + max;
        saveIntoFile(str, "result.txt");
        System.out.println("Saving min and max values in file");
    }


    private static double[] input() {
        Scanner scanner = new Scanner(System.in);
        double[] nums = null;
        try {
            String path = scanner.nextLine();
            Scanner fileScanner = new Scanner(new FileInputStream(path));

            int n = fileScanner.nextInt();

            if(n <= 0) {
                System.out.println("Input error. Size <= 0");
                return null;
            }
            else {
                nums = new double[n];

                int i = 0;
                while (fileScanner.hasNext() && i < n) {
                    try {
                        double num = fileScanner.nextDouble();
                        nums[i++] = num;
                    } catch (Exception e) {
                        fileScanner.next();
                    }
                }
                if(i != n) {
                    System.out.println("Input error. Insufficient number of elements");
                    return null;
                }
                printNumbers(n, nums);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Input error. File doesn't exist");
        }
        return nums;
    }


    private static void printNumbers(int n, double[] nums) {
        System.out.println(n);
        for(double num: nums) {
            System.out.printf("%.1f ", num);
        }
        System.out.println();
    }

    private static double findMin(double[] nums) {
        double min = Double.MAX_VALUE;

        for(double num: nums) {
            if(num < min) min = num;
        }
        return min;
    }

    private static double findMax(double[] nums) {
        double max = Double.MIN_VALUE;

        for(double num: nums) {
            if(num > max) max = num;
        }

        return max;
    }

    private static void saveIntoFile(String str, String path) throws IOException {
        Files.writeString(Path.of(path), str);
    }
}