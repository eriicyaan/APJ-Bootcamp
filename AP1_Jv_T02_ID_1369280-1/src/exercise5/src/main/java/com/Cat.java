package com;

import java.util.concurrent.TimeUnit;

public class Cat extends Animal {

    public Cat(String name, Integer age) {
        super(name, age);
    }

    @Override
    public Double goToWalk() {
        double time = getAge() * 0.25;

        try {
            TimeUnit.SECONDS.sleep((long) time);
        } catch (InterruptedException e) {

        }
        return time;
    }

    @Override
    public String toString() {
        return String.format("Cat name = %s, age = %d", getName(), getAge());
    }
}
