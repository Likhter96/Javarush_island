package com.javarush.likhter.servise;

import com.javarush.likhter.entity.Entity;
import com.javarush.likhter.entity.animal.Animal;
import com.javarush.likhter.island.Location;

public class Task {
    private final Entity entity;
    private final Location location;

    public Task(Entity entity, Location location) {
        this.entity = entity;
        this.location = location;
    }

    public void perform() {
        if (entity instanceof Animal animal) {
            if (animal.eat(location)) {
                animal.multiply(location);
            }
            animal.move(location);
        } else {
            entity.multiply(location);
        }
    }

}
