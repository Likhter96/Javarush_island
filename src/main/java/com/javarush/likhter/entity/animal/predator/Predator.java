package com.javarush.likhter.entity.animal.predator;

import com.javarush.likhter.entity.EntityType;
import com.javarush.likhter.entity.animal.Animal;

public abstract class Predator extends Animal {

    public Predator(EntityType type) {
        super(type);
    }
}