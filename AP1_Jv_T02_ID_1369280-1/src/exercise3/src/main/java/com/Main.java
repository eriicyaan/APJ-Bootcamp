package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Animal> pets = new ArrayList<>();
        List<Animal> herbivores = new ArrayList<>();
        List<Animal> omnivores = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            String type = inputType(scanner);
            if(type == null) continue;
            String name = scanner.nextLine();
            Integer age = inputAge(scanner);
            if(age == null) continue;

            switch (type) {
                case "dog":
                    omnivores.add(new Dog(name, age));
                    break;
                case "cat":
                    omnivores.add(new Cat(name, age));
                    break;
                case "hamster":
                    herbivores.add(new Hamster(name, age));
                    break;
                case "guinea":
                    herbivores.add(new GuineaPig(name, age));
                    break;
            }
        }

        pets.addAll(herbivores);
        pets.addAll(omnivores);

        for(Animal pet: pets) {
            System.out.println(pet);
        }
    }


    private static String inputType(Scanner scanner) {
        String type = scanner.nextLine();
        if(!type.equals("dog")
                && !type.equals("cat")
                && !type.equals("hamster")
                && !type.equals("guinea")) {
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