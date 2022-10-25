package com.javarush.likhter.entity.plant;

import com.javarush.likhter.entity.Entity;
import com.javarush.likhter.entity.EntityType;
import com.javarush.likhter.config.Config;
import com.javarush.likhter.island.Location;

public class Plant extends Entity {
    public Plant() {
        super(EntityType.PLANTS);
    }

    @Override
    public void multiply(Location currentLocation) {
        safeMultiply(currentLocation);
    }

    @Override
    public boolean eat(Location currentLocation) {
        return false;
    }

    @Override
    public void move(Location currentLocation) {
    }

    private void safeMultiply(Location currentLocation) {
        currentLocation.getLock().lock();
        try {
            int plantsToLocationQuantity = currentLocation.getOneTypeOfEntitiesToLocation(getTypeInt()).size();
            int maxQuantityInLocation = Config.MAX_PER_LOCATION[getTypeInt()];
            if (plantsToLocationQuantity < maxQuantityInLocation) {
                currentLocation.addEntityToLocation(getTypeInt());
            }
        } finally {
            currentLocation.getLock().unlock();
        }
    }
}
