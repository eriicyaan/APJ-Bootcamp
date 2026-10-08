package com;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] nums = input();
        if(nums == null) return;

        int[] matchingNums = new int[nums.length];
        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(matching(num)) {
                matchingNums[j] = num;
                j++;
            }
        }
        if(j == 0) {
            System.out.println("There are no such elements");
            return;
        }
        for(int i = 0; i < j; i++) {
            System.out.printf("%d ", matchingNums[i]);
        }
    }

    private static int[] input() {
        Scanner scanner = new Scanner(System.in);

        int[] nums = null;

        while(true) {
            try {
                int n = scanner.nextInt();

                if(n <= 0) {
                    System.out.println("Input error. Size <= 0");
                    break;
                }

                nums = new int[n];

                for(int i = 0; i < n; i++) {
                    nums[i] = scanner.nextInt();
                }
                break;
            } catch (Exception e) {
                System.out.println("Could not parse a number. Please, try again");
                scanner.next();
            }
        }
        return nums;
    }


    private static boolean matching(int num) {
        int firstDigit = num % 10;

        int lastDigit = num;
        while(lastDigit >= 10) {
            lastDigit /= 10;
        }

        return firstDigit == lastDigit;
    }
}
