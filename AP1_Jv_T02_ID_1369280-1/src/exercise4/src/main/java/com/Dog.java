package com;

public class Dog extends Animal {

    public Dog(String name, Integer age) {
        super(name, age);
    }


    @Override
    public String toString() {
        return String.format("Dog name = %s, age = %d", getName(), getAge());
    }
}
