package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Game {
    Flower[][] flowers = new Flower[8][8];

    public void start() {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                flowers[i][j] = new Flower();
                flowers[i][j].setPos(new Position(i, j));

            }
        }


        Gardener gardener = new Gardener();
        List<Insect> insects = new ArrayList<>();

        for(int i = 0; i < 7; i++) {
            Insect insect = new Insect();
            insect.setPos(new Position(new Random().nextInt(8), new Random().nextInt(8)));
            insects.add(insect);
        }



        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                for (Insect insect : insects) {
                    if (flowers[i][j].getPos().equals(insect.getPos())) {
                        insect.eatFlower(flowers[i][j], gardener);
                    }
                }
            }
        }
        insects.get(0).getPos().moveUp();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(flowers[i][j].getHealth());
                for (Insect insect : insects) {
                    if (insect.getPos().getX() == i && insect.getPos().getY() == j) {
                        System.out.print(":i");
                    }
                }
                System.out.print(" ");
            }
            System.out.println();
        }














    }
}
