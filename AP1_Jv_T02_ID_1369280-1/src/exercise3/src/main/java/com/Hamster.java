package com;

public class Hamster extends Animal implements Herbivore{

    public Hamster(String name, Integer age) {
        super(name, age);
    }

    @Override
    public String chill() {
        return "I can chill for 8 hours";
    }

    @Override
    public String toString() {
        return String.format("Hamster name = %s, age = %d. ", getName(), getAge()) + chill();
    }
}
