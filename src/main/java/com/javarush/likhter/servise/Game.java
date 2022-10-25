package com.javarush.likhter.servise;

import com.javarush.likhter.island.Island;

public class Game extends Thread {
        private final Island island;

        public Game(Island island) {
            this.island = island;
        }

        @Override
        public void run() {
            super.run();
        }

        public Island getIsland() {
            return island;
        }
    }
