package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Animal> pets = new ArrayList<>();


        IntStream.range(0, n)
                .forEach(i -> {
                    String type = inputType(scanner);
                    if(type == null) return;
                    String name = scanner.nextLine();
                    Integer age = inputAge(scanner);
                    if(age == null) return;
                    if(type.equals("dog")) {
                        pets.add(new Dog(name, age > 10? age + 1 : age));
                    } else if(type.equals("cat")) {
                        pets.add(new Cat(name, age > 10? age + 1 : age));
                    }
                });


        pets.forEach(System.out::println);
    }




    private static String inputType(Scanner scanner) {
        String type = scanner.nextLine();
        if(!type.equals("dog") && !type.equals("cat")) {
            System.out.println("Incorrect input. Unsupported pet type");
            return null;
        }
        return type;

    }

    private static Integer inputAge(Scanner scanner) {
        int age;
        try {
            age = Integer.parseInt(scanner.nextLine());
            if (age <= 0) {
                System.out.println("Incorrect input. Age <= 0");
                return null;
            }
        } catch (Exception e) {
            System.out.println("Could not parse a number. Please, try again");
            return null;
        }
        return age;

    }

}