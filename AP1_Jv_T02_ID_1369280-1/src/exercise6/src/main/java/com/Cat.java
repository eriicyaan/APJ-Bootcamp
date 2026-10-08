package com;

public class Cat extends Animal {

    public Cat(String name, Integer age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return String.format("Cat name = %s, age = %d", getName(), getAge());
    }
}
