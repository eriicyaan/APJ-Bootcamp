package com;

import java.util.List;

public class AnimalIterator implements BaseIterator<Animal> {

    private List<Animal> pets;
    private int idx;

    public AnimalIterator(List<Animal> pets) {
        this.pets = pets;
    }

    @Override
    public Animal next() {
        return pets.get(idx++);
    }

    @Override
    public boolean hasNext() {
        return idx < pets.size();
    }

    @Override
    public void reset() {
        idx = 0;
    }
}
