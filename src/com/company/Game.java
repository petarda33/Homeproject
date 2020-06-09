package com.company;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Game {
    Flower[][] flowers = new Flower[8][8];
    List<Insect> insects = new ArrayList<>();
    Gardener gardener = new Gardener();

    public Game() {

        //szupervirágok kiválasztása
        List<Position> posList = new ArrayList<Position>();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Position pos = new Position(i, j);
                posList.add(pos);
            }
        }

        Collections.shuffle(posList);

        //kert léterhozása
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                boolean superPos = false;
                for (int k = 0; k < 15; k++) {
                    if (posList.get(k).getX() == i && posList.get(k).getY() == j) {
                        superPos = true;
                    }
                }
                flowers[i][j] = new Flower(superPos);
                flowers[i][j].setPos(new Position(i, j));
            }
        }

        //rovarok létrehozása
        for (int i = 0; i < 7; i++) {
            Insect insect = new Insect();
            insect.setPos(new Position(new Random().nextInt(8), new Random().nextInt(8)));
            insects.add(insect);
        }

        //insects.get(0).getPos().moveUp();

    }

    public void round() {


        System.out.println(gardener.getPos());

        for (int i = 0; i < 500; i++) {
            System.out.println(i + ". Nap");
            gardenerMove();
            startGardenerKillInsect();
            eatInsects();
            insectMove();
            insectRemove();
            flowerDeath();
            //insectBorn();
            printRound();
            System.out.println("A rovarok száma" + " :" + insects.size());
            endGame();


        }


    }

    //kör végi összesités
    public void printRound() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(flowers[i][j].getHealth());
                for (Insect insect : insects) {
                    if (insect.getPos().getX() == i && insect.getPos().getY() == j) {
                        System.out.print(":i");
                    }
                }
                if (gardener.getPos().getX() == i && gardener.getPos().getY() == j) {
                    System.out.print(":G");
                }
                System.out.print("    ");
            }
            System.out.println();
        }


    }

    //rovar eszik a virágbol ha azonos pozicioban vannak
    public void eatInsects() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                for (Insect insect : insects) {
                    if (flowers[i][j].getPos().equals(insect.getPos())) {
                        insect.eatFlower(flowers[i][j], gardener);
                    }
                }
            }
        }
    }

    public void gardenerMove() {
        for (int i = 0; i < 12; i++) {
            gardener.move();

        }
    }

    //ha a keetész olyan helyre született ahol volt rovar akkor azt megöli
    public void startGardenerKillInsect() {
        Iterator<Insect> insectIterator = insects.iterator();
        while (insectIterator.hasNext()) {
            Insect i = insectIterator.next();
            // if(gardener.getPos().getX() == i.getPos().getX() && gardener.getPos().getY() == i.getPos().getY()) {
            if (i.isLive() && gardener.getPos().equals(i.getPos())) {
                gardener.killInsect(i);
            }
        }
    }

    //rovarok listábol doglott rovarok eltávolitása
    public void insectRemove() {
        Iterator<Insect> insectIterator3 = insects.iterator();
        while (insectIterator3.hasNext()) {
            if (insectIterator3.next().isLive() == false) {
                insectIterator3.remove();
            }
        }
    }

    //rovarok mozgatása
    public void insectMove() {
        for (Insect insect : insects) {
            if (insect.isLive()) {
                insect.move();
            }
        }
    }

    //Virághalál
    public void flowerDeath() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                flowers[i][j].healthLessThan0(flowers[i][j]);
            }
        }
    }

   /* public void insectBorn() {
        for (int i = 0; i < insects.size(); i++) {
            Insect insect = new Insect();
            if(insect.isLive() == true);
            insects.add(insect);
        }
    }*/

   public void endGame() {
       for (int i = 0; i < 8; i++) {
           for (int j = 0; j < 8; j++) {
               if (insects.size() == 0 ) {
                   System.exit(1);
               }
           }
       }
   }
}



