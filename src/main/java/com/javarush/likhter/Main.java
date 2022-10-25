package com.javarush.likhter;

import com.javarush.likhter.initializer.Initializer;
import com.javarush.likhter.island.Island;
import com.javarush.likhter.servise.Game;
import com.javarush.likhter.servise.GameWorker;

public class Main {
    public static void main(String[] args) {
        Initializer initializer = new Initializer();
        Island island = initializer.createIsland();
        island.showStatistic(island.getDay());
        Game game = new Game(island);
        GameWorker gameWorker = new GameWorker(game);
        gameWorker.start();
    }
}
