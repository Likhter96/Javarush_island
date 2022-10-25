package com.javarush.likhter.initializer;

import com.javarush.likhter.entity.Entity;
import com.javarush.likhter.island.Island;
import com.javarush.likhter.island.Location;
import com.javarush.likhter.utils.Randomizer;

import java.util.*;

import static com.javarush.likhter.config.Config.*;

public class IslandCreator {

        public Island create() {
            Island island = new Island(COLS, ROWS);
            createLocations(island);
            findNearbyLocations(island);
            return island;
        }

        private void createLocations(Island island) {
            Location[][] locations = island.getLocations();

            for (int col = 0; col < locations.length; col++) {
                for (int row = 0; row < locations[col].length; row++) {
                    locations[col][row] = createLocation();
                }
            }
            initializeAnimal(island);
        }

        private Location createLocation() {
            Map<Integer, Set<Entity>> result = new HashMap<>();

            for (int i = 0; i < ENTITIES_INITIAL_QUANTITY.length; i++) {
                result.put(i, new HashSet<>());
            }
            Location newLocation = new Location();
            newLocation.setEntitiesToLocation(result);
            return newLocation;
        }

        private void initializeAnimal(Island island) {
            Location[][] locations = island.getLocations();

            for (int typeOfEntityToCreate = 0; typeOfEntityToCreate < ENTITIES_INITIAL_QUANTITY.length; typeOfEntityToCreate++) {
                for (int quantity = 0; quantity < ENTITIES_INITIAL_QUANTITY[typeOfEntityToCreate]; quantity++) {
                    int randomCol = Randomizer.getRandom(COLS);
                    int randomRow = Randomizer.getRandom(ROWS);
                    locations[randomCol][randomRow].addEntityToLocation(typeOfEntityToCreate);
                }
            }
        }

        private void findNearbyLocations(Island island) {
            Location[][] locations = island.getLocations();

            for (int col = 0; col < locations.length; col++) {
                for (int row = 0; row < locations[col].length; row++) {
                    List<Location> result = new ArrayList<>();
                    if (0 < col) {
                        result.add(locations[col - 1][row]);
                    }
                    if (0 < row) {
                        result.add(locations[col][row - 1]);
                    }
                    if (col < locations.length - 1) {
                        result.add(locations[col + 1][row]);
                    }
                    if (row < locations[col].length - 1) {
                        result.add(locations[col][row + 1]);
                    }
                    locations[col][row].setNearbyLocations(result);
                }
            }
        }
}