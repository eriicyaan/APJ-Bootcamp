package com;

public class GuineaPig extends Animal implements Herbivore{
    public GuineaPig(String name, Integer age) {
        super(name, age);
    }

    @Override
    public String chill() {
        return "I can chill for 12 hours";
    }

    @Override
    public String toString() {
        return String.format("GuineaPig name = %s, age = %d. ", getName(), getAge()) + chill();
    }
}
