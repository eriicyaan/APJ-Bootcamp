package com;

import java.util.concurrent.TimeUnit;

public class Dog extends Animal {

    public Dog(String name, Integer age) {
        super(name, age);
    }

    @Override
    public Double goToWalk() {
        double time = getAge() * 0.5;

        try {
            TimeUnit.SECONDS.sleep((long) time);
        } catch (InterruptedException e) {

        }
        return time;
    }


    @Override
    public String toString() {
        return String.format("Dog name = %s, age = %d", getName(), getAge());
    }


}
