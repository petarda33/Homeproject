package com.company;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Game {
    //Flower[][] flowers = new Flower[8][8];
    List<Flower> flowersList = new ArrayList<>();
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
                Flower f = new Flower(superPos);
                f.setPos(new Position(i, j));
                flowersList.add(f);
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

    public void start() {
        while (true) {
            round();
        }
    }

    public void round() {

        startGardenerKillInsect();
        printRound();
        gardenerMove();
        insectsEat();
        insectsCantEat();
        flowerDeath();
        //insectBorn();
        System.out.println("A rovarok száma: " + insects.size());
        printRound();
        endRound();
        System.out.println("-------------------------------------------------------");
    }

    public void gardenerMove() {
        for (int i = 0; i < 12; i++) {
            gardener.move();
            Iterator<Insect> insectIterator3 = insects.iterator();
            while (insectIterator3.hasNext()) {
                Insect j = insectIterator3.next();
                if (j.isLive() && gardener.getPos().equals(j.getPos())) {
                    System.out.println("Rovar elpusztult:" + j.getPos());
                    gardener.killInsect(j);
                    insectIterator3.remove();
                }

            }
        }
    }

    //a kertész uj sarokbol indul és megőli a rovart ha azonos helyre szuletett
    public void startGardenerKillInsect() {
        int posX = 0;
        int posY = 0;
        int randomNum = new Random().nextInt(4);
        switch (randomNum) {
            case 1:
                posX = 0;
                posY = 7;
                break;
            case 2:
                posX = 7;
                posY = 7;
                break;
            case 3:
                posX = 7;
                posY = 0;
                break;
            default:
                posX = 0;
                posY = 0;
                break;
        }
        gardener.setPos(new Position(posX, posY));
        System.out.println("Kertész pozíciója kezdő pozíciója:" + gardener.getPos());

        Iterator<Insect> insectIterator = insects.iterator();
        while (insectIterator.hasNext()) {
            Insect i = insectIterator.next();
            if (i.isLive() && gardener.getPos().equals(i.getPos())) {
                System.out.println("Rovar meghalt: " + i.getPos());
                gardener.killInsect(i);
                insectIterator.remove();
            }
        }

    }


    //rovar eszik a virágbol ha azonos pozicioban vannak
    public void insectsEat() {
        for (Insect i : insects) {
            for (Flower f : flowersList) {
                if (i.getPos().equals(f.getPos()) && !i.getPos().equals(gardener.getPos()) && f.getHealth() >= 0) {
                    i.eatFlower(f);
                }
            }
        }
    }

    //rovar élete csokken, ha olyan mezőn van, ahol nincs virág
    public void insectsCantEat() {

        Iterator<Insect> insectIterator = insects.iterator();
        while (insectIterator.hasNext()) {
            Insect i = insectIterator.next();
            boolean canteat = true;
            for (Flower f : flowersList) {
                if (i.getPos().equals(f.getPos()) && !i.getPos().equals(gardener.getPos()) && f.getHealth() > 0) {
                    canteat = false;
                }
            }
            if (canteat == true) {
                System.out.println("A rovar nem tud enni" + i.getHealth());
                i.setHealth(Math.max(0, i.getHealth() - 3));
                System.out.println("A rovar nem tudott enni:" + i.getPos() + i.getHealth());
                i.move();
                if (i.getHealth() <= 0) {
                    System.out.println("A rovar nem tudott enni ezért meghalt" + i.getPos());
                    i.die();
                    insectIterator.remove();
                }
            }
            i.move();
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


    //rovarok listábol doglott rovarok eltávolitása
    public void insectRemove() {
        Iterator<Insect> insectIterator3 = insects.iterator();
        while (insectIterator3.hasNext()) {
            Insect i = insectIterator3.next();
            if (i.getHealth() == 0) {
                insectIterator3.remove();
            }
        }
    }


    //Virághalál
    public void flowerDeath() {
        Iterator<Flower> flowerIterator = flowersList.iterator();
        while (flowerIterator.hasNext()) {
            Flower f = flowerIterator.next();
            if (f.getHealth() <= 0) {
                flowerIterator.remove();
            }
        }
    }
   /* public void insectBorn() {
        for (Insect i : insects) {
            Insect newBorn = new Insect();
            if (i.isLive() == true) {
                newBorn.setPos(i.getPos());
                insects.add(newBorn);
            }
        }
    }

            // 1. 0-tol 7-ig
            // 2. jobbra van-e virag (getX + 1);
            // 2b. jobbra szuletik
            // 3. jobbra fel van-e virag (getX + 1, getY + 1);
            // ...
            // x. ha nincs sehol virag akkor getX, getY-ba szuletik
            for (int ind = 0; ind < 8; ind++) {
                switch (ind) {
                    case 1:
                        i.getPos().getX() + 1;
                        break;
                    case 2:
                        i.getPos().getX() - 1;
                        break;
                    case 3:
                        pos.moveLeft();
                        break;
                    case 4:
                        pos.moveRight();
                        break;
                    case 5:
                        pos.moveUpLeft();
                        break;
                    case 6:
                        pos.moveUpRight();
                        break;
                    case 7:
                        pos.moveDownLeft();
                        break;
                    default :
                        pos.moveDownRight();
                        break;
                }
            }
            i.getPos().getX + 1;
            i.getPos().getY + 1;
            for (Flower f : flowersList) {

            }
            newBorn.setPos(i.getPos());
            insects.add(newBorn);
        }
    } */

    public void endRound() {
        if (insects.size() == 0) {
            System.out.println("Elfogytak a rovarok");
            System.exit(0);
        }
        if (flowersList.size() == 0) {
            System.out.println("Elfogytak a viragok");
            System.exit(0);
        }
//       for (int i = 0; i < 8; i++) {
//           for (int j = 0; j < 8; j++) {
//               flowers[i][j]
//           }
//       }
    }

/*
   public void insectCantEat () {
       for (int i = 0; i < 8; i++) {
           for (int j = 0; j < 8; j++) {
               for (Insect insect : insects) {
                   if (flowers[i][j].getHealth() <= 0 && flowers[i][j].getPos().equals(insect.getPos()) && insect.isLive() == true) {
                       insect.insectHealthDown(flowers[i][j]);
                   }
               }
           }
       }
   }

   public void insectDie () {
       for (Insect insect : insects) {
           if (insect.getHealth() == 0) {
               insects.remove(insect);
           }
       }
   }

    public void insectRemove2() {
        Iterator<Insect> insectIterator3 = insects.iterator();
        while (insectIterator3.hasNext()) {
            Insect i = insectIterator3.next();
            if (i.getHealth() == 0) {
                insectIterator3.remove();
            }
        }
    }*/


    //kör végi összesités
    public void printRound() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                boolean isNotEmpty = false;
                for (Insect ins : insects) {
                    if (ins.getPos().equals(new Position(i, j))) {
                        System.out.print("i:");
                        isNotEmpty = true;
                    }
                }
                for (Flower f : flowersList) {
                    if (f.getPos().equals(new Position(i, j))) {
                        isNotEmpty = true;
                        if (gardener.getPos().equals(f.getPos())) {
                            System.out.print(f.getHealth() + ":g");
                        } else {
                            System.out.print(f.getHealth() + "  ");
                        }
                    }
                }
                if (!isNotEmpty) {
                    System.out.print("0  ");
                }
            }
            System.out.println("");
        }
    }


}



