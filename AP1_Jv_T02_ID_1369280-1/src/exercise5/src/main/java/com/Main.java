package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        long programStart = System.nanoTime();

        int n = Integer.parseInt(scanner.nextLine());

        List<Animal> pets = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            String type = inputType(scanner);
            if(type == null) continue;
            String name = scanner.nextLine();
            Integer age = inputAge(scanner);
            if(age == null) continue;

            switch (type) {
                case "dog":
                    pets.add(new Dog(name, age));
                    break;
                case "cat":
                    pets.add(new Cat(name, age));
                    break;
            }
        }

        List<Thread> threads = new ArrayList<>();

        for(Animal pet: pets) {
            Thread thread = new Thread(() -> {
                long start = System.nanoTime();
                pet.goToWalk();
                long end = System.nanoTime();

                double startTime = (start - programStart) / 1_000_000_000.0;
                double endTime = (end - programStart) / 1_000_000_000.0;

                System.out.printf(
                        "%s, start time = %.2f, end time = %.2f%n",
                        pet,
                        startTime,
                        endTime
                );
            });

            threads.add(thread);
            thread.start();
        }

        for(Thread thread: threads) {
            thread.join();
        }
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