package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> strings = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());
        for(int i = 0; i < n; i++) {
            String str = scanner.nextLine();
            strings.add(str);
        }

        String substring = scanner.nextLine();

        System.out.println(String.join(", ", filter(strings, substring)));
    }


    private static List<String> filter(List<String> src, String substr) {
        ArrayList<String> result = new ArrayList<>();

        for(String str: src) {
            if(str.contains(substr)) {
                result.add(str);
            }
        }

        return result;
    }
}