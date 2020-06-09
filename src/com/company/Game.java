package com.company;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Game {
    Flower[][] flowers = new Flower[8][8];
    List<Insect> insects = new ArrayList<>();

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
        for(int i = 0; i < 7; i++) {
            Insect insect = new Insect();
            insect.setPos(new Position(new Random().nextInt(8), new Random().nextInt(8)));
            insects.add(insect);
        }

        //insects.get(0).getPos().moveUp();

    }

    public void round() {


        //kertész léterhozása
        Gardener gardener = new Gardener();
        System.out.println(gardener.getPos());

        //ha a keetész olyan helyre született ahol volt rovar akkor azt megöli
        Iterator<Insect> insectIterator = insects.iterator();
        while(insectIterator.hasNext()) {
            Insect i = insectIterator.next();
            if(gardener.getPos().getX() == i.getPos().getX() && gardener.getPos().getY() == i.getPos().getY()) {
                gardener.killInsect(i);
            }
        }


        //lép a kertész
        for( int i = 0; i < 12; i++) {
            gardener.move();
            //ha olyan pozicioban van a kertész ahol van rovar akkor megöli a rovart
            Iterator<Insect> insectIterator2 = insects.iterator();
            while(insectIterator2.hasNext()) {
                if(gardener.getPos().equals(insectIterator2.next().getPos())) {
                    gardener.killInsect(insectIterator2.next());
                }
            }
        }

        //rovarok listábol doglott rovarok eltávolitása
        Iterator<Insect> insectIterator3 = insects.iterator();
        while(insectIterator3.hasNext()) {
            if(insectIterator3.next().isLive() == false) {
                insectIterator3.remove();
            }
        }


        //rovar eszik a virágbol ha azonos pozicioban vannak
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                for (Insect insect : insects) {
                    if (flowers[i][j].getPos().equals(insect.getPos())) {
                        insect.eatFlower(flowers[i][j], gardener);
                    }
                }
            }
        }
        //kör végi összesités
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


        System.out.println("Rovarok száma" + " :" + insects.size());
    }
}
