package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer n = Integer.parseInt(scanner.nextLine());

        List<User> users = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            String username = "";
            int age = 0;
            try {
                while(true) {
                    username = scanner.nextLine();
                    age = Integer.parseInt(scanner.nextLine());
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Could not parse a number. Please, try again");
            }
            if(age <= 0) {
                System.out.println("Incorrect input. Age <= 0");
                i--;
            } else {
                users.add(new User(username, age));
            }
        }


        List<String> list = users.stream()
                .filter(user -> user.getAge() >= 18)
                .map(User::getUsername)
                .toList();

        System.out.println(String.join(", ", list));
    }
}