package com.company;
import java.util.concurrent.ThreadLocalRandom;

public class Gardener extends Creature {
    public Gardener () {
        int posX = 0;
        int posY = 0;
        int randomNum = ThreadLocalRandom.current().nextInt(0, 4);
        switch (randomNum) {
            case 1 :
                posX = 0;
                posY = 7;
                break;
            case 2 :
                posX = 7;
                posY = 7;
                break;
            case 3 :
                posX = 7;
                posY = 0;
                break;
            default :
                posX = 0;
                posY = 0;
                break;
        }
        this.setPos(new Position(posX, posY));

    }



    public void move() {
        int posX = getPos().getX();
        int posY = getPos().getY();
        int newX;
        int newY;

        inputloop: while(true) {
            int randomNum = ThreadLocalRandom.current().nextInt(0, 4);
            switch (randomNum) {
                case 1:
                    if (posX < 7) {
                        newX = posX + 1;
                        newY = posY;
                        break inputloop;
                    }
                    break;
                case 2 :
                    if (posY < 7) {
                        newX = posX;
                        newY = posY + 1;
                        break inputloop;
                    }
                    break;
                case 3 :
                    if (posX > 0) {
                        newX = posX - 1;
                        newY = posY;
                        break inputloop;
                    }
                    break;
                default:
                    if (posY > 0) {
                        newX = posX;
                        newY = posY - 1;
                        break inputloop;
                    }
                    break;
            }
        }

        getPos().setX(newX);
        getPos().setY(newY);
        System.out.println("A kertész ide lépett:" + getPos());
    }

    public void killInsect(Insect i) {
        i.die();
       // System.out.println("A kertész jelenleg ebben a pozícióban van és megölt egy rovart" + i.getPos());
    }
}
