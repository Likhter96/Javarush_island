package com.javarush.likhter.entity.animal.herbivore;

import com.javarush.likhter.entity.EntityType;
import com.javarush.likhter.entity.animal.Animal;

public abstract class Herbivore extends Animal {
    protected Herbivore(EntityType type) {
        super(type);
    }
}
