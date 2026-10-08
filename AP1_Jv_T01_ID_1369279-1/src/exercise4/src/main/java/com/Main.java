package com;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        int[] nums = input();
        if(nums == null) return;

        int negativeCount = 0;
        int negativeSum = 0;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < 0) {
                negativeCount++;
                negativeSum += nums[i];
            }
        }

        if(negativeCount == 0) {
            System.out.println("There are no negative elements");
        }
        else {
            System.out.println(negativeSum / negativeCount);
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
}