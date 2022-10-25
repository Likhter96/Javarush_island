package com.javarush.likhter.initializer;

import com.javarush.likhter.island.Island;

public class Initializer {
    public Island createIsland(){
        IslandCreator islandCreator = new IslandCreator();
        return islandCreator.create();
    }
}
