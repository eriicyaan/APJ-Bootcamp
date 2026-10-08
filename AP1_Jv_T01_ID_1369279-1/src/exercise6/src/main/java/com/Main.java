package com;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        double[] nums = input();
        if(nums == null) return;

        selectionSort(nums);

        for (double num : nums) {
            System.out.printf("%.1f ", num);
        }
    }

    private static double[] input() {
        Scanner scanner = new Scanner(System.in);
        double[] nums = null;

        while(true) {
            try {
                int n = scanner.nextInt();

                if(n <= 0) {
                    System.out.println("Input error. Size <= 0");
                    break;
                }

                nums = new double[n];

                for(int i = 0; i < n; i++) {
                    nums[i] = scanner.nextDouble();
                }
                break;
            } catch (Exception e) {
                System.out.println("Could not parse a number. Please, try again");
                scanner.next();
            }
        }
        return nums;
    }

    private static void selectionSort(double[] nums) {
        for(int i = 0; i < nums.length; i++) {
            int minIdx = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIdx]) {
                    minIdx = j;
                }
            }
            if (minIdx != i) {
                double num = nums[i];
                nums[i] = nums[minIdx];
                nums[minIdx] = num;
            }
        }
    }
}